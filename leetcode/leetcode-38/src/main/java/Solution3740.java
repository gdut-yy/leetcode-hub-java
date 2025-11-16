public class Solution3740 {
}
/*
3740. 三个相等元素之间的最小距离 I
https://leetcode.cn/problems/minimum-distance-between-three-equal-elements-i/description/

第 475 场周赛 T1。

给你一个整数数组 nums。
如果满足 nums[i] == nums[j] == nums[k]，且 (i, j, k) 是 3 个 不同 下标，那么三元组 (i, j, k) 被称为 有效三元组 。
有效三元组 的 距离 被定义为 abs(i - j) + abs(j - k) + abs(k - i)，其中 abs(x) 表示 x 的 绝对值 。
返回一个整数，表示 有效三元组 的 最小 可能距离。如果不存在 有效三元组 ，返回 -1。
提示：
1 <= n == nums.length <= 100
1 <= nums[i] <= n

中国时间 2025-11-09 周日 10:30
佛山。
同: 3741. 三个相等元素之间的最小距离 II
https://leetcode.cn/problems/minimum-distance-between-three-equal-elements-ii/description/
 */