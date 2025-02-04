"""
召唤帝皇侠【算法赛】

数学推导
"""
import math

if __name__ == '__main__':
    t = int(input())
    outs = []
    mod = 998244353

    for _ in range(t):
        x = int(input())
        ans = 0

        v = math.isqrt(x)
        ans += v * (v + 1) * (2 * v + 1) // 6

        v = (math.isqrt(4 * x + 1) - 1) // 2
        ans += v * (v + 1) * (2 * v + 1) // 6 + v * (v + 1) // 2

        v = (math.isqrt(x + 1) - 1)
        ans += v * (v + 1) * (2 * v + 1) // 6 + v * (v + 1)
        outs.append(ans % mod)

    print(*outs, sep='\n')