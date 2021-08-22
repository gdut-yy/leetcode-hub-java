public class Solution300 {
    /**
     * 动态规划法
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     *
     * @param nums 输入数组
     * @return 最长严格递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        // 1 <= nums.length <= 2500
        int numsLen = nums.length;

        // 定义 dp[i] 为包含第 i 个元素的最长上升子序列长度
        int[] dp = new int[numsLen];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < numsLen; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 严格递增
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * 贪心 + 二分查找
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(n)
     *
     * @param nums 输入数组
     * @return 最长严格递增子序列的长度
     */
    public int lengthOfLIS2(int[] nums) {
        // 1 <= nums.length <= 2500
        int numsLen = nums.length;
        int len = 1;

        // d[i] 表示长度为 i 的最长上升子序列的末尾元素的最小值，用 len 记录目前最长上升子序列的长度
        int[] d = new int[numsLen + 1];
        d[len] = nums[0];
        for (int i = 1; i < numsLen; ++i) {
            if (nums[i] > d[len]) {
                len++;
                d[len] = nums[i];
            } else {
                int left = 1;
                int right = len;
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int pos = 0;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
/*
300. 最长递增子序列
https://leetcode-cn.com/problems/longest-increasing-subsequence/

LIS 模板题。二分优化后：
时间复杂度 O(nlogn)
空间复杂度 O(n)

相似题目：
第 1964 题 https://leetcode-cn.com/problems/find-the-longest-valid-obstacle-course-at-each-position/
 */