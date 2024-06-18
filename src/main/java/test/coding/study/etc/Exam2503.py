# 숫자 야구

n = int(input())

answer = 0
li = [list(map(int, input().split())) for _ in range(n)]

for a in range(1, 10):
    for b in range(1, 10):
        for c in range(1, 10):
            if a == b or b == c or c == a :
                continue
            cnt = 0
            for arr in li:
                num = arr[0]
                strike = arr[1]
                ball = arr[2]
                hun = num // 100 % 10
                ten = num // 10 % 10
                one = num % 10
                if (hun == a):
                    strike = strike - 1
                if (ten == b):
                    strike = strike - 1
                if (one == c):
                    strike = strike - 1
                if (hun == b or hun == c):
                    ball = ball - 1
                if (ten == a or ten == c):
                    ball = ball - 1
                if (one == a or one == b):
                    ball = ball - 1
                if 0 == strike and ball == 0:
                    cnt = cnt + 1
            if cnt == n:
                answer = answer + 1
print(answer)