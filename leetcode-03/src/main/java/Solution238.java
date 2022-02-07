public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];
        leftProduct[0] = 1;
        for (int i = 1; i < len; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }
        rightProduct[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = leftProduct[i] * rightProduct[i];
        }
        return res;
    }
}
/*
238. 除自身以外数组的乘积
https://leetcode-cn.com/problems/product-of-array-except-self/

给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请不要使用除法，且在 O(n) 时间复杂度内完成此题。
提示：
2 <= nums.length <= 10^5
-30 <= nums[i] <= 30
保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

最直观的方法是用数组的乘积除以当前的数，但是题目规定不能用出发而且 数组中可能存在 0.
转变思路，预处理数的左右侧乘积，乘积即为 除自身以外数组的乘积
同: 剑指 Offer 66. 构建乘积数组
https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */