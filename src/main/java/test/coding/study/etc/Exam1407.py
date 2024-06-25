# 2로 몇 번 나누어질까

a, b = map(int, input().split())

answer = 0
temp = a
while(temp >= a and temp <= b):
    max = 1
    if (temp % 2 == 0):
        t = 1
        while(t <= temp):
            if (temp % t == 0):
                if (max < t):
                    max = t
            t *= 2
    answer += max
    temp += 1

    
print(answer)