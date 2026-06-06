public class Solution3903 {
}
/*
3903. 最小稳定下标 I
https://leetcode.cn/problems/smallest-stable-index-i/description/

第 498 场周赛 T1。

给你一个长度为 n 的整数数组 nums 和一个整数 k。
对于每个下标 i，定义它的 不稳定值 为 max(nums[0..i]) - min(nums[i..n - 1])。
换句话说：
- max(nums[0..i]) 表示从下标 0 到下标 i 的元素中的 最大值 。
- min(nums[i..n - 1]) 表示从下标 i 到下标 n - 1 的元素中的 最小值 。
如果某个下标 i 的不稳定值 小于等于 k，则称该下标为 稳定下标 。
返回 最小 的稳定下标。如果不存在这样的下标，则返回 -1。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 10^9
0 <= k <= 10^9

同: 3904. 最小稳定下标 II
https://leetcode.cn/problems/smallest-stable-index-ii/description/
 */