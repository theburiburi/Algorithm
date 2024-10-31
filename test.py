inf = 10000
N1 = 6
N2 = 7

graph1 = [
    [0,1,inf,4,inf,inf],
    [1,0,3,inf,1,inf],
    [inf,3,0,inf,1,2],
    [4,inf,inf,0,1,inf],
    [inf,1,1,1,0,4],
    [inf,inf,2,inf,4,0]
]

graph2 =[
    [0,4,5,inf,inf,inf,inf],
    [4,0,6,5,10,inf,inf],
    [5,6,0,4,inf,9,inf],
    [inf,5,4,0,6,3,inf],
    [inf,10,inf,6,0,3,2],
    [inf,inf,9,3,3,0,2],
    [inf,inf,inf,inf,2,2,0]
]

graph3 =[
    [0,1,1,inf,inf,inf,inf],
    [1,0,1,1,1,inf,inf],
    [1,1,0,1,inf,1,inf],
    [inf,1,1,0,1,1,inf],
    [inf,1,inf,1,0,1,1],
    [inf,inf,1,1,1,0,1],
    [inf,inf,inf,inf,1,1,0]
]

def floyd_warshall1():

    dist = list(map(lambda i: list(map(lambda j: j, i)), graph1))
    prev = [[0 for k in range(N1)]for l in range(N1)]

    print("그림1 그래프")
    print("Floyd 실행 전")

    for i in range(N1):
        print(dist[i])
    print(" ")

    for i in range(N1):
        for j in range(N1):
            for k in range(N1):
                cost = dist[j][i] + dist[i][k]
                if  dist[j][k] > cost:
                    dist[j][k] = cost
                    prev[j][k] = dist[j][k]

    print("Floyd 실행 후")
    for i in range(N1):
        print(dist[i])
    print(" ")


def floyd_warshall2():

    dist = list(map(lambda i: list(map(lambda j: j, i)), graph2))
    prev = [[0 for k in range(N2)]for l in range(N2)]

    print("그림2 그래프")
    print("Floyd 실행 전")

    for i in range(N2):
        print(dist[i])
    print(" ")

    for i in range(N2):
        for j in range(N2):
            for k in range(N2):
                cost = dist[j][i] + dist[i][k]
                if  dist[j][k] > cost:
                    dist[j][k] = cost
                    prev[j][k] = dist[j][k]

    print("Floyd 실행 후")
    for i in range(N2):
        print(dist[i])
    print(" ")


def floyd_warshall3():

    print("그림2 그래프에서 모든 거리를 1로 설정했을 때")
    print("Floyd 실행 전")

    dist = list(map(lambda i: list(map(lambda j: j, i)), graph3))
    prev = [[0 for k in range(N2)]for l in range(N2)]

    for i in range(N2):
        print(dist[i])
    print(" ")

    for i in range(N2):
        for j in range(N2):
            for k in range(N2):
                cost = dist[j][i] + dist[i][k]
                if  dist[j][k] > cost:
                    dist[j][k] = cost
                    prev[j][k] = dist[j][k]

    print("Floyd 실행 후")
    for i in range(N2):
        print(dist[i])
    print(" ")


floyd_warshall1()
floyd_warshall2()
floyd_warshall3()