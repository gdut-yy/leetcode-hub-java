import java.util.Arrays;

public class SolutionP3339 {
    private static final int MOD = (int) (1e9 + 7);
    private int n, k, odd, even;
    private long[][][] memo;

    public int countOfArrays(int n, int m, int k) {
        if (k > n) return 0; // 不可能有k次跳跃
        this.n = n;
        this.k = k;
        odd = (m + 1) / 2;
        even = m / 2;
        memo = new long[n + 1][3][k + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return (int) (dfs(0, 2, 0) % MOD);
    }

    // i: 当前处理索引 (0~n)
    // last: 0(偶)或1(奇)或2(初始状态)
    // s: 跳跃次数 (0~k)
    private long dfs(int i, int last, int s) {
        if (s > k) return 0; // 减枝：跳跃次数超过k
        if (i == n) {
            return s == k ? 1 : 0; // 终止条件
        }
        if (memo[i][last][s] != -1) return memo[i][last][s];
        long res = 0;
        if (last == 2) { // 初始状态（无上一个数字）
            // 选择偶数：不增加跳跃，last更新为0
            res = (res + even * dfs(i + 1, 0, s)) % MOD;
            // 选择奇数：不增加跳跃，last更新为1
            res = (res + odd * dfs(i + 1, 1, s)) % MOD;
        } else {
            // 选择偶数：如果上次为偶数则跳跃+1，否则不变
            int ns = s + (last == 0 ? 1 : 0);
            res = (res + even * dfs(i + 1, 0, ns)) % MOD;
            // 选择奇数：不增加跳跃
            res = (res + odd * dfs(i + 1, 1, s)) % MOD;
        }
        return memo[i][last][s] = res;
    }
}
/*
$3339. 查找 K 偶数数组的数量
https://leetcode.cn/problems/find-the-number-of-k-even-arrays/description/

给定三个整数 n，m 和 k。
一个数组 arr 如果 恰好 有 k 个下标，其中的每个下标 i (0 <= i < n - 1) 满足下述条件，则被称为是 K 偶数的：
(arr[i] * arr[i + 1]) - arr[i] - arr[i + 1] 是偶数。
返回长度为 n 的满足 K 偶数 的数组的数量，其中所有元素的范围在 [1, m]。
因为答案可能很大，返回答案对 10^9 + 7 取模。
提示：
1 <= n <= 750
0 <= k <= n - 1
1 <= m <= 1000

记忆化搜索。
https://leetcode.cn/problems/find-the-number-of-k-even-arrays/solutions/2974393/python-ji-yi-hua-sou-suo-dp-by-nrib8zib5-0vl2/
 */