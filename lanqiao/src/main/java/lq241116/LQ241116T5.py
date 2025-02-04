"""
缺失的环节【算法赛】

所有子字符串的数量为 N(N+1)/2，答案不可能大于这个数量
枚举长度不超过 20
"""
if __name__ == '__main__':
    n = int(input())
    s = input()

    vis = set()
    for i in range(n):
        cur = 0
        for j in range(20):
            if i + j >= n:
                break
            cur = cur * 2 + int(s[i + j])
            vis.add(cur)

    ans = 0
    while ans in vis:
        ans += 1
    print(ans)