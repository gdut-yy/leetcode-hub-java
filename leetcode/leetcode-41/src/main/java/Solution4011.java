public class Solution4011 {
}
/*
4011. 按奇偶比统计子数组 I
https://leetcode.cn/problems/count-subarrays-with-even-odd-ratio-i/description/

第 513 场周赛 T2。

给你一个整数数组 nums，以及两个整数 a 和 b。
对于一个 子数组 ，定义：
- x 表示其中偶数元素的数量。
- y 表示其中奇数元素的数量。
子数组中偶数与奇数的比例定义为 x / y，其中该比例按照精确的有理数值进行比较。
如果一个子数组满足以下条件，则称其为 有效子数组 ：
- y > 0，并且
- x / y <= a / b。
返回 nums 中有效子数组的数量。
子数组 是数组中一个连续的 非空 元素序列。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 1000
1 <= a, b <= 1000

同: 4013. 按奇偶比统计子数组 II
https://leetcode.cn/problems/count-subarrays-with-even-odd-ratio-ii/description/
 */