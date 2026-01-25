import sys
from itertools import combinations
# from으로 불러오면 itertools.combination 이라고 안 써도 됨

def nCr(n, r) :
    lst = [i for i in range(n)]
    return len(list(combinations(lst, r)))

N, M, K = map(int, sys.stdin.readline().split())

entire = nCr(N, M)
case = 0

while(M != K-1):
    case += nCr(M,K)*nCr(N-M,M-K)
    K = K+1    
    
percent = case / entire
print(percent)