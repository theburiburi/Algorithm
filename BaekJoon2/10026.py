import sys
import queue
sys.setrecursionlimit(10**6)

def possible(y,x, RGB):
    if ((0 <= y and y < N) and (0 <= x and x < N)):
        if check[y][x] == False:
            if (color[y][x] == RGB):
                return True
    return False

def checkRGB(y, x, RGB):
    Q = queue.Queue()
    Q.put([y,x])
    check[y][x] = True
    while Q.qsize() != 0:
        y, x = Q.get()
        for dy, dx in [-1,0],[1,0],[0,-1],[0,1]:
            if possible(y+dy, x+dx, RGB):
                check[y+dy][x+dx] = True
                Q.put([y+dy,x+dx])

N = int(input())
check = [[False for _ in range(N)] for _ in range(N)]
num = 0
color = []

for i in range(N):
    color.append(list(sys.stdin.readline().strip()))

for i in range(N):
    for j in range(N):
        if(check[i][j] == False):
            num += 1
            checkRGB(i, j, color[i][j])
            
print(num, end= " ")
check = [[False for _ in range(N)] for _ in range(N)]
num = 0
for i in range(N):
    for j in range(N):
        if color[i][j] == 'G':
            color[i][j] = 'R'

for i in range(N):
    for j in range(N):
        if(check[i][j] == False):
            num += 1
            checkRGB(i, j, color[i][j])
            

print(num, end = "")

'''
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
'''