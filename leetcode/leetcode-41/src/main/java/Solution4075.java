public class Solution4075 {
}
/*
4075. 最长有韧性的子数组 I
https://leetcode.cn/problems/longest-resilient-subarray-i/description/

第 193 场双周赛 T2。

给你一个整数数组 nums 和一个整数 k。
如果对一个子数组中的 每一个 元素，删除 该元素后，剩余 元素的 和能被 k 整除 ，那么称它是 有韧性的 。
对于长度为 1 的子数组，剩余元素的和为 0，可以被 k 整除。
返回 最长有韧性子数组 的长度。
子数组 是数组中连续的 非空 元素序列。
示例 1：
输入： nums = [2,4,6,3], k = 2
输出： 3
示例 2：
输入： nums = [1,4,7,1], k = 3
输出： 4
示例 3：
输入： nums = [5,5,4,8], k = 4
输出： 2
提示：
1 <= nums.length <= 2500
1 <= nums[i] <= 10^5
1 <= k <= 10^5

同: 4076. 最长有韧性的子数组 II
https://leetcode.cn/problems/longest-resilient-subarray-ii/description/
 */
