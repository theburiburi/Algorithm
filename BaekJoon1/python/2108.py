from collections import Counter
import sys

N = int(input())
arr = []
for _ in range(N):
    arr.append(int(sys.stdin.readline()))
arr.sort()
count_array = sorted(Counter(arr).items(), key = lambda x : (-x[1], x[0]))

print(round(sum(arr)/N))
print(arr[N//2])
if count_array[0][1] == count_array[1][1]:
    print(count_array[1][0])
else:
    print(count_array[0][0])
print(max(arr) - min(arr))