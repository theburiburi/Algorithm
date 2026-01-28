import sys

num, gap = map(int, (sys.stdin.readline().split()))
list = []

start = gap-1
step = start

for i in range (num):
    list.append(i+1)

print("<", end="")

for _ in range(num):
    print(list.pop(start), end ="")
    start = start+step
    
    if len(list) >0:
        print(", ", end ="")
    else :
        break
    
    if start > len(list)-1:
        start = start % (len(list))
print(">", end ="")