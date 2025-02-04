"""
代码知音【算法赛】
"""
if __name__ == '__main__':
    t = int(input())
    outs = []
    mod = 10 ** 9 + 7

    for _ in range(t):
        l, r = map(int, input().split())
        ans = 0
        if l == 1:
            ans += (r - 1) // 8
            l += 1
        if l == 2:
            ans += r // 4
            l += 1

        even = r // 2 - (l - 1) // 2
        ans += even * (even - 1) // 2

        for i in range(1, 8, 2):
            v = (r - i) // 8 - (l - 1 - i) // 8
            ans += v * (v - 1) // 2

        outs.append(ans % mod)

    print(*outs, sep='\n')