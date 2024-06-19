# 체커(ing)

n = int(input())

li = []
xli = [0 for i in range(n)]
yli = [0 for i in range(n)]


answer = [-1] * n
for i in range(n):
    x, y = map(int,input().split())
    xli[i] = x
    yli[i] = y
    li.append([x,y])

for y in yli:
    for x in xli:
        arr = []
        for nx, ny in li:
            sum = abs(x - nx) + abs(y - ny)
            arr.append(sum)
        arr.sort()
        
        temp = 0
        for i in range(len(arr)):
            t = arr[i]
            temp += t
            if answer[i] == -1 :
                answer[i] = temp
            else:
                answer[i] = min(answer[i], temp)
print(*answer)

