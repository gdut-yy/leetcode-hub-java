public class Solution1955 {
    public int countSpecialSubsequences(int[] nums) {
        int mod = 1000000007;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int num : nums) {
            if (num == 0) {
                dp0 = (dp0 * 2 + 1) % mod;
            } else if (num == 1) {
                dp1 = (dp1 * 2 % mod + dp0) % mod;
            } else {
                dp2 = (dp2 * 2 % mod + dp1) % mod;
            }
        }
        return dp2;
    }
}
/*
1955. 统计特殊子序列的数目
https://leetcode-cn.com/problems/count-number-of-special-subsequences/

第 252 场周赛 T4。
动态规划，状态压缩后如诗一样优雅。
时间复杂度 O(n)
空间复杂度 O(1)
 */