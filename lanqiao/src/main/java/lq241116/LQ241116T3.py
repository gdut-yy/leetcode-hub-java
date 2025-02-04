"""
招募队员【算法赛】

用动态规划的思想，定义 dp[i][j] 表示前 i 行中，以第 i 行作为结尾，最多有多少个连续的行，使得这些行都包含数字 j
那么，如果第 i 行和第 i-1 行都包含 j，则
dp[i][j] = dp[i-1][j] + 1
否则
dp[i][j] = 0
最后对于每个数字遍历 dp[1~n][j]，求出最大值即可
"""
if __name__ == '__main__':
    n = int(input())
    ans = [0] * 5
    cur = [0] * 5
    cnt = [0] * 5
    for _ in range(n):
        a = list(map(int, input().split()))
        for x in a:
            cnt[x - 1] = 1
        for i in range(5):
            cur[i] = cur[i] + 1 if cnt[i] else 0
            ans[i] = max(ans[i], cur[i])
            cnt[i] = 0
    print(*ans)