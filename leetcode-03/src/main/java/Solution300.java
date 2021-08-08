public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int len = 1;

        // dp[j] 代表 nums[i,j] 中以 nums[j] 结尾的最长上升子序列
        int[] dp = new int[n + 1];
        dp[len] = nums[0];
        for (int i = 1; i < n; i++) {
            // 严格递增
            if (nums[i] > dp[len]) {
                len++;
                dp[len] = nums[i];
            } else {
                int left = 1;
                int right = len;
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 dp[1]，所以这里将 pos 设为 0
//                int pos = 0;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    // 严格递增
                    if (dp[mid] < nums[i]) {
//                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
//                dp[pos + 1] = nums[i];
                dp[left] = nums[i];
            }
        }
        return len;
    }
}
/*
300. 最长递增子序列
https://leetcode-cn.com/problems/longest-increasing-subsequence/

LIS 模板题
二分优化后
时间复杂度 O(nlogn)
空间复杂度 O(n)
 */