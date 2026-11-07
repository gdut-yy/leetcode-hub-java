public class Solution4094 {
}
/*
4094. 统计频次阶梯子数组的数目 I
https://leetcode.cn/problems/count-frequency-staircase-subarrays-i/description/

第 525 场周赛 T3。

给你一个整数数组 nums。
考虑一个子数组中的所有不同值，并按它们首次出现的顺序排列。
如果其中有 k 个不同值，且第一个不同值恰好出现一次，第二个不同值恰好出现两次，以此类推，第 k 个不同值恰好出现 k 次，则称该子数组为频次阶梯。
即，按首次出现的顺序排列的各个不同值，其出现次数必须恰好为 1, 2, 3, ..., k。
返回 nums 中频次阶梯子数组的数量。
子数组是数组中一段连续且非空的元素序列。
一个值在子数组中的频次，是指它在该子数组中出现的次数。
示例 1：
输入： nums = [5,8,8,2,2,2]
输出： 9
示例 2：
输入： nums = [6,6,9,9]
输出： 5
示例 3：
输入： nums = [2,3,4,4,3,4]
输出： 8
提示：
1 <= nums.length <= 1500
1 <= nums[i] <= 10^5

同: 4095. 统计频次阶梯子数组的数目 II
https://leetcode.cn/problems/count-frequency-staircase-subarrays-ii/description/
 */
