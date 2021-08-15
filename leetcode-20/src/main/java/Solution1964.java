public class Solution1964 {
    /**
     * LIS
     * 时间复杂度  O(nlogn)
     *
     * @param obstacles 下标从 0 开始 的整数数组 obstacles
     * @return 长度为 n 的答案数组 ans ，其中 ans[i] 是上面所述的下标 i 对应的最长障碍赛跑路线的长度
     */
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        // 1 <= nums.length <= 2500
        int numsLen = obstacles.length;

        // 定义 dp[i] 为包含第 i 个元素的最长上升子序列长度
        int[] dp = new int[numsLen];
        dp[0] = 1;

        int len = 1;
        // d[i] 表示长度为 i 的最长上升子序列的末尾元素的最小值，用 len 记录目前最长上升子序列的长度
        int[] d = new int[numsLen + 1];
        d[len] = obstacles[0];
        for (int i = 1; i < numsLen; ++i) {
            // >= 除第一个障碍外，路线中每个障碍的高度都必须和前一个障碍 相同 或者 更高
            if (obstacles[i] >= d[len]) {
                len++;
                d[len] = obstacles[i];

                // 记录 dp
                dp[i] = len;
            } else {
                int left = 1;
                int right = len;
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int pos = 0;
                while (left <= right) {
                    int mid = (left + right) >> 1;

                    // <= 除第一个障碍外，路线中每个障碍的高度都必须和前一个障碍 相同 或者 更高
                    if (d[mid] <= obstacles[i]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                d[pos + 1] = obstacles[i];

                // 记录 dp
                dp[i] = pos + 1;
            }
        }
        return dp;
    }

    /**
     * LIS
     * 时间复杂度  O(n^n)
     *
     * @param obstacles 下标从 0 开始 的整数数组 obstacles
     * @return 长度为 n 的答案数组 ans ，其中 ans[i] 是上面所述的下标 i 对应的最长障碍赛跑路线的长度
     */
    public int[] longestObstacleCourseAtEachPosition2(int[] obstacles) {
        // 1 <= obstacles.length <= 10^5
        int numsLen = obstacles.length;

        // 定义 dp[i] 为包含第 i 个元素的最长上升子序列长度
        int[] dp = new int[numsLen];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < numsLen; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 严格递增
                if (obstacles[i] >= obstacles[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return dp;
    }
}
/*
1964. 找出到每个位置为止最长的有效障碍赛跑路线
https://leetcode-cn.com/problems/find-the-longest-valid-obstacle-course-at-each-position/

第 253 场周赛 T4。
容易误想到单调栈，实际上本题单调栈不可行，单调栈求出的长度并不是最优的，如：
input:    [5,1,5,5,1,3,4,5,1,4]
actual:   [1,1,2,3,2,3,4,5,3,4]
expected: [1,1,2,3,2,3,4,5,3,5]

需要使用 LIS。参考第 300 题 https://leetcode-cn.com/problems/longest-increasing-subsequence/
注: 时间复杂度需为 O(nlogn) 才能 AC, 时间复杂度 O(n^n) 本题会超出时间限制。
本题代码直接修改自 Solution300#lengthOfLIS2()

实战时，部分用例因数组太长，无法直接在 java 代码中通过硬编码的方式初始化。如以下两个用例。在 UT 中，我们通过文件的方式进行初始化，详见：
Solution1964Tests#example4()
Solution1964Tests#example5()
 */