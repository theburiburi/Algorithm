import sys

K, N = map(int, sys.stdin.readline().split())

lan_cable = [int(sys.stdin.readline()) for _ in range(K)]
start = 1
end = max(lan_cable)

ans = 0
count = 0

for i in range(K):
    count += lan_cable[i] // end
if (count >= N):
    print(end)
    exit()

while(start < end):
    mid = (start + end) // 2
    count = 0
    for i in range(K):
        count += lan_cable[i] // mid
        
    if (count >=  N):
        start = mid + 1
        ans = max(ans, mid)
    else:
        end = mid
print(ans)