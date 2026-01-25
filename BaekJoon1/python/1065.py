def han(n):
    if n < 100:
        return n
    else:
        ans = 99
        for i in range(100,n+1):
            lis = list(map(int, str(i)))
            if lis[0] - lis[1] == lis[1] - lis[2]:
                ans +=1
        return ans


n = int(input())
print(han(n))
        