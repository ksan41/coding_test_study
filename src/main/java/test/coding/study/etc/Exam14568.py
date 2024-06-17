
# 2017 연세대학교 프로그래밍 경시대회
candy = int(input())

cnt = 0;
for A in range(1, candy + 1):
    for B in range(1, candy + 1):
        for C in range(1, candy + 1):
            if A + B + C == candy:
                if A >= B + 2:
                    if C % 2 == 0:
                        cnt = cnt + 1
print(cnt)