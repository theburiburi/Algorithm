import sys
input = sys.stdin.readline

#파이썬에서 list 자체가 stack임 pop 같은 거 사용 가능
D, N = map(int, input().split())

case = list(map(int, input().split()))
pizza = list(map(int, input().split()))

min = D - 1

for i in range (D - 1):
    if  case[i] < case[i+1]:
        case[i+1] = case[i]

for i in range (D):
    if pizza[0] > case[i]:
        min = i - 1
        break

for i in range(1, N):
    if min == -1:
        print(0)
        exit()
    while (min != -1):
        min -= 1
        if not(case[min] < pizza[i]) :
            break
        
print(min+1)
