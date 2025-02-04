"""
奖杯排列【算法赛】

当 k=0 时，等差数列中的每个数必须相同。此时，我们可以去统计每个数出现的次数，而后利用二项式定理计算答案。
当 k>0 时，使用动态规划求解。
定义 dp[i][j] 表示作为尾元素的值为 ai, 公差为 k 的等差数列的个数。由于 ai 的取值很大，因此需要使用字典来维护状态
对应的状态转移方程为：
dp[i][ai] = dp[i-1][ai-k] + dp[i-1][ai] + 1
为了节约空间，我们可以压缩 dp[i][j] 为 dp[j]
在转移完 n 个元素的状态后，将所有的 dp[j] 相加即为公差为 k 的等差数列的个数总和
"""
from collections import Counter

if __name__ == '__main__':
    n, k = map(int, input().split())
    cnt = Counter()

    mod = 10 ** 9 + 7
    ans = 0

    a = map(int, input().split())
    for v in a:
        res = 0
        if v - k in cnt:
            res = cnt[v - k]
        ans += res
        if ans >= mod:
            ans -= mod
        cnt[v] += res + 1
        if cnt[v] >= mod:
            cnt[v] -= mod
    print(ans)