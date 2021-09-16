public class Solution1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        // LCS
        int[][] dp = new int[nums1Len + 1][nums2Len + 1];
        for (int i = 1; i <= nums1Len; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= nums2Len; j++) {
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1Len][nums2Len];
    }
}
/*
1035. 不相交的线
https://leetcode-cn.com/problems/uncrossed-lines/

第 134 场周赛 T3。
LCS 同 1143 最长公共子序列 https://leetcode-cn.com/problems/longest-common-subsequence/
 */