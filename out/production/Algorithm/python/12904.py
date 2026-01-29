import sys

S = str(sys.stdin.readline().rstrip())
T = str(sys.stdin.readline().rstrip())

string = T
T_len = len(T)
S_len = len(S)

if (S != string):
    while(T_len >= S_len):
        if string[T_len - 1] ==  'A':
            T_len -= 1
            string = string[:T_len]
        else:
            T_len -= 1
            string = string[:T_len]
            string = string[::-1]
        if (S == string):
            print(1)
            exit()
else:
    print(1)
    exit()
    
print(0)
