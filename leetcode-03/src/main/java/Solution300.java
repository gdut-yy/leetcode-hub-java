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
        int len = nums.length;

        // ascend[idx] 表示长度为 idx 的最长上升子序列的末尾元素的最小值，用 idx 记录目前最长上升子序列的长度
        int[] ascend = new int[len + 1];
        int idx = 1;
        ascend[idx] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > ascend[idx]) {
                idx++;
                ascend[idx] = nums[i];
            } else {
                int left = 1;
                int right = idx;
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 边界二分 F, F,..., F, [T, T,..., T] checkMid(mid) == T
                    if (checkMid(nums[i], ascend, mid)) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                // 左边界二分
                ascend[left] = nums[i];
            }
        }
        return idx;
    }

    private boolean checkMid(int nums, int[] ascend, int mid) {
        return ascend[mid] >= nums;
    }
}
/*
300. 最长递增子序列
https://leetcode-cn.com/problems/longest-increasing-subsequence/

LIS 模板题。二分优化后：
时间复杂度 O(nlogn)
空间复杂度 O(n)

相似题目: 1964. 找出到每个位置为止最长的有效障碍赛跑路线
https://leetcode-cn.com/problems/find-the-longest-valid-obstacle-course-at-each-position/
 */