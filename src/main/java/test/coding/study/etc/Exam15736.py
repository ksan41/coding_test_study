# 청기 백기

n = int(input())

answer = 0
num = 1
while(num <= n):
    red = num*num
    if red <= n:
        answer = answer + 1
    num = num + 1
print(answer)