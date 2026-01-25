from collections import deque
import sys

def bfs(v):
    q = deque()
    q.append(v)
    visited_bfs[v] = 1
    while q:
        v = q.popleft()
        print(v, end = " ")
        for i in range(1, N+1):
            if visited_bfs[i] == 0 and graph[v][i] == 1:
                q.append(i)
                visited_bfs[i] = 1
            
def dfs(v):
    visited_dfs[v] = 1
    print(v, end = " ")
    for i in range(1, N+1):
        if visited_dfs[i] == 0 and graph[v][i] == 1:
            dfs(i)

N, M, V = map(int, sys.stdin.readline().split())

graph = [[0] * (N+1) for _ in range(N+1)] # 새로운 표현
visited_dfs = [0] * (N+1)                 # 새로운 표현
visited_bfs = [0 for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    graph[a][b] = graph[b][a] = 1

dfs(V)
print()
bfs(V)
