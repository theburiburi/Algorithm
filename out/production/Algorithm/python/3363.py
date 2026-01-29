import sys
num = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
bigger = num.copy()
smaller = num.copy()

for _ in range(3):
    coin_list = list(sys.stdin.readline().split())
    if not coin_list : #입력받지 못하면 재입력 받기
        coin_list = list(sys.stdin.readline().split())
    left = list(map(int, coin_list[:4]))
    right = list(map(int, coin_list[5:]))
    difference = list(set(num)-set(left)-set(right)) #리스트 차이점 찾기
    #common = list(set(left) & set(right)) #리스트 공통점 찾기    
    
    if coin_list[4] == '=':
        for i in left :
            if i in bigger :
                bigger.remove(i)
            if i in smaller :
                smaller.remove(i)
        for j in right :
            if j in bigger :
                bigger.remove(j)
            if j in smaller :
                smaller.remove(j)
    
    elif coin_list[4] == '>':
        for i in left :
            if i in smaller :
                smaller.remove(i)
        for j in right :
            if j in bigger :
                bigger.remove(j)
        for k in difference :
            if k in bigger :
                bigger.remove(k)
            if k in smaller :
                smaller.remove(k)

    elif coin_list[4] == '<':
        for i in left :
            if i in bigger :
                bigger.remove(i)
        for j in right :
            if j in smaller :
                smaller.remove(j)
        for k in difference :
            if k in bigger :
                bigger.remove(k)
            if k in smaller :
                smaller.remove(k)

# print(type(smaller)) 자료형 출력

if len(smaller) > 0 :
    check = '-'
else:
    check = '+'
    
result = []
result.extend(smaller)
result.extend(bigger)

if not result :
    print("impossible")
elif len(result) > 1 :
    print("indefinite")
else :
    print(result[0], end = "")
    print(check)
