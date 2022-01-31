public class Solution53 {
    /**
     * 动态规划
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 代表以第 i 个数结尾的「连续子数组的最大和」
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 动态规划（状态压缩）
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int maxSubArray2(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
/*
53. 最大子序和
https://leetcode-cn.com/problems/maximum-subarray/

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

动态规划
时间复杂度 O(n)
空间复杂度 O(1)

也可以使用线段树，参考官方题解:
https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/

相似题目: 152. 乘积最大子数组
https://leetcode-cn.com/problems/maximum-product-subarray/
$1746. 经过一次操作后的最大子数组和
https://leetcode-cn.com/problems/maximum-subarray-sum-after-one-operation/
 */
