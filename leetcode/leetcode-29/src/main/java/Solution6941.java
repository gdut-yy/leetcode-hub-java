import java.util.List;

public class Solution6941 {
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        // 定义 dp[i] 为包含第 i 个元素的最长上升子序列长度
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums.get(i) >= nums.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return n - max;
    }
}
/*
6941. 将三个组排序
https://leetcode.cn/problems/sorting-three-groups/

第 111 场双周赛 T3。

给你一个下标从 0 开始长度为 n 的整数数组 nums 。
从 0 到 n - 1 的数字被分为编号从 1 到 3 的三个组，数字 i 属于组 nums[i] 。注意，有的组可能是 空的 。
你可以执行以下操作任意次：
- 选择数字 x 并改变它的组。更正式的，你可以将 nums[x] 改为数字 1 到 3 中的任意一个。
你将按照以下过程构建一个新的数组 res ：
1. 将每个组中的数字分别排序。
2. 将组 1 ，2 和 3 中的元素 依次 连接以得到 res 。
如果得到的 res 是 非递减顺序的，那么我们称数组 nums 是 美丽数组 。
请你返回将 nums 变为 美丽数组 需要的最少步数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 3

LIS
时间复杂度 O(n^2) / O(nlogn)
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */