import sys

N = int(sys.stdin.readline())
lst = []

for _ in range (N):
    T, S = map(int, sys.stdin.readline().split())
    lst.append([T, S])
lst.sort(key = lambda x : x[1])
# lst.sort(key = lambda x : (x[1], x[0])) -> x[1] 기준으로 정렬후 같은 것은 x[0]로 정렬

diff = 1000000
total = 0
for i in lst:
    total += i[0]
    if (total > i[1]):
        print("-1")
        exit(0)
    diff = min(diff, i[1] - total)
print(diff)