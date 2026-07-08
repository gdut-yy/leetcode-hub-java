public class Solution3956 {
}
/*
3956. M 个非重叠子数组最大和 I
https://leetcode.cn/problems/maximum-sum-of-m-non-overlapping-subarrays-i/description/

第 505 场周赛 T3。

给你一个长度为 n 的整数数组 nums，以及三个整数 m、l 和 r。
你的任务是从 nums 中选择 至少 一个且 至多 m 个 互不重叠的子数组，并满足：
- 每个被选择的 子数组 的长度都在 [l, r] 范围内（包含两端）。
- 所有被选择 子数组 的总和 最大 。
返回你能够取得的 最大 总和。
子数组 是数组中一个连续的 非空 元素序列。
提示：
1 <= n == nums.length <= 1000
-10^9 <= nums[i] <= 10^9
1 <= m <= n
1 <= l <= r <= n

同: 3957. M 个非重叠子数组最大和 II
https://leetcode.cn/problems/maximum-sum-of-m-non-overlapping-subarrays-ii/description/
 */