# 비밀번호

n = int(input())

number = 1000000

for _ in range(n):
    s = int(input())
    for i in range(2, number + 1):
        if s % i == 0:
            print("NO")
            break
        if i == number:
            print("YES")
    