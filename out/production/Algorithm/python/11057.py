import math

def homo(a):
    sum = math.factorial(a+9) // (math.factorial(a) * math.factorial(9))
    sum %= 10007
    return sum

a = homo(int(input()))

print(a)