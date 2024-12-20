import yfinance as yf
import numpy as np
import pandas as pd
from keras.models import Sequential
from keras.layers import Dense, SimpleRNN, GRU, LSTM
from keras.optimizers import SGD,Adamax
#--------------
GOOG= yf.download('GOOG',start='2020-01-01',end='2022-12-31')
GOOG['Adj Close'].plot()
#여러 주식 데이터 중 Adj Close(종가)를 예측하기위해 해당데이터만 출력해본다
#학습데이터로 2020년1월1일~2022년12월31일의 주가 데이터를 하루에 한개씩 사용한다
#(장이 열릴때만 데이터가 있겠죠?#)
#학습 데이터의 개수(10년치로 연도변경, 최근주가예측 등)을 변경하려면 그 데이터 개수에 맞게 밑에 전처리도 변경해주시면 됩니다
#구글 말고 다른 주가로 데이터 변경하고싶으면 해당 주가코드를 다운받으시면 됩니다.
#--------------
GOOG=GOOG.round(2)
#연산 편의를 위해 소수점 둘째자리까지만 남기는데 안해도 된다
#------------
time_steps=5
for_periods=1
ts_train = GOOG[:'2021'].iloc[:,0:1].values
ts_test = GOOG['2022':].iloc[:,0:1].values
ts_train_len = len(ts_train)
ts_test_len = len(ts_test)

# training 데이터의 samples 와 time steps로 원본데이터 슬라이싱
X_train = [] 
y_train = [] 
y_train_stacked = [] 
for i in range(time_steps, ts_train_len - 1):
    X_train.append(ts_train[i-time_steps:i,0])
    y_train.append(ts_train[i:i+for_periods,0])
X_train, y_train = np.array(X_train), np.array(y_train)

# 3차원으로 재구성하기
# np.reshape(samples, time steps, features)
X_train = np.reshape(X_train, (X_train.shape[0], X_train.shape[1],1))

# X_test 생성 준비
inputs = pd.concat((GOOG["Adj Close"][:'2021'], GOOG["Adj Close"]['2022':]), axis=0).values
inputs = inputs[len(inputs)-len(ts_test) - time_steps:]
inputs = inputs.reshape(-1,1)

# X_test 생성
X_test = []
for i in range(time_steps, ts_test_len+ time_steps- for_periods):
    X_test.append(inputs[i-time_steps:i,0])
X_test = np.array(X_test)
X_test = np.reshape(X_test, (X_test.shape[0], X_test.shape[1],1))
#전처리는 학습하기 좋게 데이터의 차원등을 변경하고
#train과 test를 나눠준다
#전처리는 시험 안나옵니다
#---------------
goog_pred_lstm = Sequential(name='goog_pred_lstm')
goog_pred_lstm.add(LSTM(units = 50, 
                        return_sequences = True, 
                        input_shape = (X_train.shape[1],1),activation = 'tanh'
                        ))
goog_pred_lstm.add(LSTM(units = 25,activation = 'tanh'))
goog_pred_lstm.add(Dense(units=1))
goog_pred_lstm.summary()
#주가 데이터 학습 및 예측을 위해 LSTM 레이어를 2개 층으로 구성해준다
#input_shape, return_sequences 는 그냥 넘어가셔도 되고 
#활성화함수(activation)은 하이퍼블릭탄젠트 tanh로 설정한다
#제일 마지막 출력부분 레이어는 Dense로 일자로 쭉 나열해 한 타임스텝(시간단위=1일)마다
#주가 한개를 출력하도록 한다.
#----------------
goog_pred_lstm.compile(optimizer = Adamax(learning_rate = 0.01  ),
                      loss = 'mean_squared_error')
goog_pred_lstm.fit(X_train, y_train, epochs = 100, batch_size = 25, verbose = 2)
#모델의 학습 파라미터 설정 부분으로 optimizer(오차기울기 최적화 업데이트 함수)는 Adam의 한 종류인
#Adamax로 설정 ##optimizer는 경사하강법으로 선형회귀에서 Gradinet Descent, CNN에서는 adam를
#각 AI모델에 맞게 성능이 좋은 함수를 사용한다(요즘은 보통 adam이 일반적으로 어느 모델에도 성능이 좋고)
#사용 방법에 따라 대문자를 주의한다 (Adamax, adam)
#오차함수로 MSE를 사용한다.(선형회귀에서 MSE사용, CNN에서는 sparse_categorical_crossentropy사용)
#vervose는 매 학습(epochs)마다 뭘 출력할건지(결과화면에)를 변경하는데 안써도 되고 
#궁금하시면 1,2,3,등 변경해보세요
#-----------
LSTM_prediction = goog_pred_lstm.predict(X_test)
#-----------
actual_pred = pd.DataFrame(columns = ['Adj. Close', 'prediction'])
actual_pred['Adj. Close'] = GOOG.loc['2022':,'Adj Close'][0:len(LSTM_prediction)]
actual_pred['prediction'] = LSTM_prediction[:,0]
#판다스로 AI모델이 예측한 주가를 출력하기위해 데이터를 만들어준다
#실제값과 예측값을 같이 plot하기 위해 데이터를 준비한다.
#결국 20년~21년도를 학습하고 22년도를 예측한다.
#-----------
import matplotlib.pyplot as plt
actual_pred.plot(figsize=(20,10))
