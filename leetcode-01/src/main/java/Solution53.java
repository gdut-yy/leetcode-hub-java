public class Solution53 {
    public int maxSubArray(int[] nums) {
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

动态规划
时间复杂度 O(n)
空间复杂度 O(1)

也可以使用线段树，参考官方题解:
https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
 */
