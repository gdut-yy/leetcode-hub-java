import math
import random
from collections import defaultdict

if __name__ == '__main__':
    n, k = map(int, input().rstrip().split())
    nums = list(map(int, input().rstrip().split()))
    mod = 998244353

    nums.sort()
    m = n // 2
    dp = [[0] * ((m + 1) * (k + 1)) for _ in range(2)]


    def f(empty, val):
        return empty * (k + 1) + val


    dp[1][f(0, 0)] = 1

    for i in range(n):
        num = nums[i]
        i %= 2
        for j in range((m + 1) * (k + 1)):
            dp[i][j] = 0

        ni = i ^ 1
        for empty in range(m + 1):
            for val in range(k + 1):
                v = dp[ni][f(empty, val)]
                if v:
                    if val + num <= k:
                        p = f(empty, val + num)
                        dp[i][p] = (dp[i][p] + v * (1 + empty * 2)) % mod
                    if empty:
                        p = f(empty - 1, val)
                        dp[i][p] = (dp[i][p] + v * empty) % mod
                    if empty + 1 <= m and val + num * 2 <= k:
                        p = f(empty + 1, val + num * 2)
                        dp[i][p] = (dp[i][p] + v * (empty + 1)) % mod
    print(dp[(n - 1) % 2][f(0, k)])