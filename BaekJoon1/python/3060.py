import sys

T = int(input())
result = []
for _ in range(T):
    feed = int(input())
    pig = list(map(int, sys.stdin.readline().split()))
    
    time = 0
    while(1):
        new_pig = [0] * 6
        print(pig)
        if feed >= sum(pig) :
            time += 1
            for i in range(6):
                new_pig[i] = pig[i] + pig[((i-1)+6)%6] + pig[(i+1)%6] + pig[(i+3)%6]
            pig = new_pig
        else :
            break
    result.append(str(time+1))
print("\n".join(result))