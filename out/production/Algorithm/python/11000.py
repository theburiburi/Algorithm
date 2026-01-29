import sys
import heapq as hq

N = int(input())
cl_room = []
for _ in range(N):
    cl_room.append(list(map(int, sys.stdin.readline().split())))
cl_room = sorted(cl_room, key = lambda x : (x[0], x[1]))

result = [cl_room.pop(0)[1]]
for i in cl_room:
    if i[0] < result[0]:
        hq.heappush(result, i[1])
    else:
        hq.heappop(result)
        hq.heappush(result, i[1])
print(len(result))