# 소인수분해

n = int(input())
temp = n
while (temp > 1):
    if temp == 1:
        break
    if (temp == 2 or temp == 3 or temp == 5 or temp == 7):
        print(temp)
        break
    flg = False
    for i in range(2, int(n**0.5)+1):
        if (temp % i == 0):
            print(i)
            temp = temp // i
            flg = True
            break
    if (flg == False):
        print(temp)
        break