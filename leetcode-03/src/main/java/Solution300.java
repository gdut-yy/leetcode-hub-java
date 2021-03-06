public class Solution300 {
    /**
     * 动态规划法
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(n)
     */
    public int lengthOfLIS(int[] nums) {
        // 1 <= nums.length <= 2500
        int len = nums.length;

        // 定义 dp[i] 为包含第 i 个元素的最长上升子序列长度
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 严格递增
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 贪心 + 二分查找
     * 时间复杂度 O(nlogn)
     * 空间复杂度 O(n)
     */
    public int lengthOfLIS2(int[] nums) {
        // 1 <= nums.length <= 2500
        int len = nums.length;

        // ascend[idx] 表示长度为 idx 的最长上升子序列的末尾元素的最小值，用 idx 记录目前最长上升子序列的长度
        int[] ascend = new int[len + 1];
        int idx = 1;
        ascend[idx] = nums[0];
        for (int i = 1; i < len; i++) {
            // 严格递增
            if (nums[i] > ascend[idx]) {
                idx++;
                ascend[idx] = nums[i];
            } else {
                int left = 1;
                int right = idx;
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    // 边界二分 F, F,..., F, [T, T,..., T]
                    // ----------------------^
                    // 严格递增
                    if (ascend[mid] >= nums[i]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                ascend[left] = nums[i];
            }
        }
        return idx;
    }
}
/*
300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/

给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
提示：
1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4
进阶：
你能将算法的时间复杂度降低到 O(n log(n)) 吗?

LIS 模板题。二分优化后：
时间复杂度 O(nlogn)
空间复杂度 O(n)
相似题目: 673. 最长递增子序列的个数
https://leetcode.cn/problems/number-of-longest-increasing-subsequence/
1671. 得到山形数组的最少删除次数
https://leetcode.cn/problems/minimum-number-of-removals-to-make-mountain-array/
1713. 得到子序列的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-a-subsequence/
1964. 找出到每个位置为止最长的有效障碍赛跑路线
https://leetcode.cn/problems/find-the-longest-valid-obstacle-course-at-each-position/
 */