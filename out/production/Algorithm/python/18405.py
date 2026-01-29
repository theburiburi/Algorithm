import sys
input = sys.stdin.readline #새로운 표현

N, K = map(int, input().split())
arr = [0 for _ in range(N)]

for i in range(N) :
    arr[i] = list(map(int, sys.stdin.readline().split()))
S, X, Y = map(int, sys.stdin.readline().split())
            
dic = {}   #사전형

def check_vi(i, j):
    global arr, N
    if 0 <= i and i < N and 0 <= j and j < N:
        if arr[i][j] == 0:
            return 1
    return 0

def update(u, lst):
    global dic
    
    result = []
    for index in lst:
        i = index[0]
        j = index[1]
        for dx, dy in [1, 0],[-1, 0],[0, 1],[0, -1]: 
            if check_vi(i + dx, j + dy):
                arr[i + dx][j + dy] = u
                result.append([i + dx, j + dy])
    return result

for i in range(N):                  # 처음 바이러스 위치 파악
    for j in range(N):
        if arr[i][j] != 0:
            if arr[i][j] in dic :
                dic[arr[i][j]].append([i, j])
            else:
                dic[arr[i][j]] = [[i, j]]

dic = dict(sorted(dic.items()))  # 바이러스 1, 2, 3 기준으로 정렬
                                # dic 에는 sort함수가 없음
                                # dict형으로 변환 안 하면 list로 반환됨
for _ in range(S):
    if (arr[X-1][Y-1] != 0): #찾는 값이 채워지면 출력하고 종료 (시간 줄이기)
        break
    for i, j in zip(dic.keys() ,dic.values()):#zip > [1, 2, 3] ['a', 'b', 'c'] = (1, 'a') ...
        dic[i] = update(i, j)                 #dic.keys() == dic 같은 표현
print(arr[X-1][Y-1])