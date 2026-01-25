import sys
from math import sqrt

def distance(a,b,c,d) :
    return abs((a-c)**2+(b-d)**2)

def compare(a,b,c):
    global check,diagonal,side
    if (a == b and a != c) :
        diagonal.append(c)
        side.append(b)
    elif(b == c and c != a) :
        diagonal.append(a)
        side.append(c)
    elif(a == c and a != b) :
        diagonal.append(b)
        side.append(a)
    else :
        check = 0

T = int(sys.stdin.readline())
result = []

for _ in range(T) :
    arr = []
    side = []
    diagonal = []
    i = 0
    check = 1
    for _ in range(4) :
        a , b = map(int, sys.stdin.readline().split())
        arr.append(a)
        arr.append(b) #여기부분도 요약하고싶어어
    a = distance(arr[i],arr[i+1],arr[i+2],arr[i+3])
    b = distance(arr[i],arr[i+1],arr[i+4],arr[i+5])
    c = distance(arr[i],arr[i+1],arr[i+6],arr[i+7])    
    compare(a,b,c)
    a = distance(arr[i+2],arr[i+3],arr[i],arr[i+1])
    b = distance(arr[i+2],arr[i+3],arr[i+4],arr[i+5])
    c = distance(arr[i+2],arr[i+3],arr[i+6],arr[i+7])    
    compare(a,b,c)
    a = distance(arr[i+4],arr[i+5],arr[i],arr[i+1])
    b = distance(arr[i+4],arr[i+5],arr[i+2],arr[i+3])
    c = distance(arr[i+4],arr[i+5],arr[i+6],arr[i+7])    
    compare(a,b,c)
    if (check == 0):
        check = 0 #그냥 넘어가고 싶으면 뭐 써야하지?
    elif (not(side[0] == side[1] == side[2])):
        check = 0
    elif (not(diagonal[0] == diagonal[1] == diagonal[2])):
        check = 0
    result.append(str(check))
print('\n'.join(result))