public class SolutionP3935 {
}
/*
$3935. 插入后第 K 大更新的幂 I
https://leetcode.cn/problems/power-update-after-k-th-largest-insertion-i/description/

给定一个整数数组 nums 和一个整数 p。
同时给定一个二维整数数组 queries，其中每个 queries[i] = [vali, ki] 并且 相邻 的两个 ki 之间的差总是 小于 10。
对于每次查询：
- 将 vali 插入到 nums。
- 令 x 为当前 nums 中第 ki 个 最大 的元素。
- 将 p 更新 为 px % (10^9 + 7)。
返回数组 ans，其中 ans[i] 表示在第 i 次查询后 p 的值。
示例 1：
输入：nums = [2], p = 4, queries = [[3,1],[1,2]]
输出：[64,4096]
示例 2：
输入：nums = [7,5], p = 6, queries = [[4,3],[7,2]]
输出：[1296,220296870]
提示：
1 <= nums.length <= 2 × 10^4
1 <= nums[i] <= 10^6
1 <= p <= 10^6
1 <= queries.length <= 2 × 10^4
1 <= vali <= 10^6
1 <= ki <= n + i + 1
对于 i > 0，有 |ki - ki - 1| < 10

同: $3930. 插入后第 K 大更新的幂 II
https://leetcode.cn/problems/power-update-after-k-th-largest-insertion-ii/description/
 */