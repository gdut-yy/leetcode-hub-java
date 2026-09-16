public class Solution4035 {
}
/*
4035. 最多有效分割位置 I
https://leetcode.cn/problems/maximum-valid-split-positions-i/description/

第 190 场双周赛 T2。

给你一个整数数组 nums。
你可以从 nums 中移除 至多一个 元素。记 arr 为按原始顺序保留其余元素后得到的数组，m 为其长度。
如果 arr 的 分割位置 i 满足以下条件，则称其为 有效的 ：
- 0 <= i < m - 1，且
- gcd(arr[0..i]) == gcd(arr[i + 1..m - 1])。
长度为 1 的数组没有有效的分割位置。
arr 的 得分 是其有效分割位置的数量。
返回 arr 的 最大可能得分 。
在这里，gcd(a) 表示数组 a 中所有元素的最大公约数。
提示：
2 <= nums.length <= 1000
1 <= nums[i] <= 10^9

同: 4037. 最多有效分割位置 II
https://leetcode.cn/problems/maximum-valid-split-positions-ii/description/
 */