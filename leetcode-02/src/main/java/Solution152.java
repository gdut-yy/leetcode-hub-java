public class Solution152 {
    public int maxProduct(int[] nums) {
        int maxF = nums[0];
        int minF = nums[0];
        int ans = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; ++i) {
            int mx = maxF;
            int mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
/*
152. 乘积最大子数组
https://leetcode-cn.com/problems/maximum-product-subarray/

与第 53 题的差异是: 当前位置的最优解未必是由前一个位置的最优解转移得到的。
需要根据正负性进行分类讨论
参考官方题解:
https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/

动态规划
时间复杂度 O(n)
空间复杂度 O(1)
 */