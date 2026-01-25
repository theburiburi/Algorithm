#import queue 쓰는 법 공부하기
import sys

T = int(sys.stdin.readline())


#global = 메인문에 있는 함수를 함수에서 끌어오기
def search(y, x) :
    global arr, visited, M, N
    if (not(0 <= x and x < M and 0 <= y and y < N)):
        return 0
    if arr[y][x] == 0 or visited[y][x] == 1:
        return 0
    else:
        visited[y][x] = 1
        search(y-1, x)
        search(y+1, x)
        search(y, x-1)
        search(y, x+1)
    return 1


for _ in range(T) : #초기 세팅
    count = 0
    M, N, K = map(int, sys.stdin.readline().split())
    arr = [[0 for _ in range(M)] for _ in range(N)]
    visited = [[0 for _ in range(M)] for _ in range(N)]
    for _ in range(K) :
        a, b = map(int, sys.stdin.readline().split())
        try :
            arr[b][a] = 1
        except :
            print(arr)
    for a in range(N) : #탐색
        for b in range(M) :
            count += search(a,b)
    print(count)
    
    #join 함수 > 문자 배열로 돼있으면 사이에 문자 넣기
    #ex> print("\n".join(result)) 시간복잡도 줄어듬