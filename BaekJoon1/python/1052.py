import sys
#N, K = map(int, sys.stdin.readline().split)
N, K = map(int, input().split())


count = 0
#bin(십진수) -> 2진수 변환
while (bin(N).count('1') > K):
    N += 1
    count += 1
print(count)