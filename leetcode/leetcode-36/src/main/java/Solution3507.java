public class Solution3507 {
}
/*
3507. 移除最小数对使数组有序 I
https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-i/description/

第 444 场周赛 T1。

给你一个数组 nums，你可以执行以下操作任意次数：
- 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。
- 用它们的和替换这对元素。
返回将数组变为 非递减 所需的 最小操作次数 。
如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。
提示：
1 <= nums.length <= 50
-1000 <= nums[i] <= 1000

同: 3510. 移除最小数对使数组有序 II
https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-ii/description/
 */