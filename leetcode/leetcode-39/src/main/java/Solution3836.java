import java.util.Arrays;

public class Solution3836 {
    private int[] nums1, nums2;
    private long[][][] memo;

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        memo = new long[k + 1][n][m];
        for (long[][] mat : memo) {
            for (long[] row : mat) {
                Arrays.fill(row, Long.MIN_VALUE);
            }
        }
        return dfs(k, n - 1, m - 1);
    }

    private long dfs(int k, int i, int j) {
        if (k == 0) { // 选完了
            return 0;
        }
        if (i + 1 < k || j + 1 < k) { // 剩余元素不足 k 个
            return Long.MIN_VALUE; // 下面计算 max 不会取到 MIN_VALUE
        }
        if (memo[k][i][j] != Long.MIN_VALUE) { // 之前计算过
            return memo[k][i][j];
        }
        long res1 = dfs(k, i - 1, j); // 不选 nums1[i]
        long res2 = dfs(k, i, j - 1); // 不选 nums2[j]
        long res3 = dfs(k - 1, i - 1, j - 1) + (long) nums1[i] * nums2[j]; // 选 nums1[i] 和 nums2[j]
        return memo[k][i][j] = Math.max(Math.max(res1, res2), res3); // 记忆化
    }
}
/*
3836. 恰好 K 个下标对的最大得分
https://leetcode.cn/problems/maximum-score-using-exactly-k-pairs/description/

第 488 场周赛 T4。

给你两个长度分别为 n 和 m 的整数数组 nums1 和 nums2，以及一个整数 k。
你必须 恰好 选择 k 对下标 (i1, j1), (i2, j2), ..., (ik, jk)，使得：
- 0 <= i1 < i2 < ... < ik < n
- 0 <= j1 < j2 < ... < jk < m
对于每对选择的下标 (i, j)，你将获得 nums1[i] * nums2[j] 的得分。
总 得分 是所有选定下标对的乘积的 总和。
返回一个整数，表示可以获得的 最大 总得分。
提示：
1 <= n == nums1.length <= 100
1 <= m == nums2.length <= 100
-10^6 <= nums1[i], nums2[i] <= 10^6
1 <= k <= min(n, m)

子序列 DP。
https://leetcode.cn/problems/maximum-score-using-exactly-k-pairs/solutions/3898739/zi-xu-lie-dpcong-ji-yi-hua-sou-suo-dao-d-y9aw/
时间复杂度 O(knm)。
 */