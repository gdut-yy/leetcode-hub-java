"""
精准难度【算法赛】

从某个位置乘到第 i 个位置 mod 2025 = x 的子数组有多少个
"""
if __name__ == '__main__':
    n = int(input())
    nums = list(map(int, input().split()))

    dp = [0] * 2025
    ndp = [0] * 2025
    ans = 0

    for v in nums:
        v %= 2025

        for i in range(2025):
            ndp[i * v % 2025] ^= dp[i]
        ndp[v] ^= 1

        for i in range(2025):
            dp[i] = ndp[i]
            ndp[i] = 0
            if dp[i]:
                ans ^= i

    print(ans)