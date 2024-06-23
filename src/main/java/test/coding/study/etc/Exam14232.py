# 보석 도둑

k = int(input())

li = []
temp = k
while (temp > 1):
    if temp == 1:
        break
    flg = False
    for i in range(2, int(k**0.5)+1):
        if (temp % i == 0):
            li.append(i)
            temp //= i
            flg = True
            break
    if (flg == False):
        break
if (temp > 1):
    li.append(temp)
li.sort()
print(len(li))
print(*li)