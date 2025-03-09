public class Solution3477 {
}
/*
3477. 将水果放入篮子 II
https://leetcode.cn/problems/fruits-into-baskets-ii/description/

第 440 场周赛 T1。

给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量，baskets[j] 表示第 j 个篮子的 容量。
你需要对 fruits 数组从左到右按照以下规则放置水果：
- 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
- 每个篮子只能装 一种 水果。
- 如果一种水果 无法放入 任何篮子，它将保持 未放置。
返回所有可能分配完成后，剩余未放置的水果种类的数量。
提示：
n == fruits.length == baskets.length
1 <= n <= 100
1 <= fruits[i], baskets[i] <= 1000

同: 3479. 将水果装入篮子 III
https://leetcode.cn/problems/fruits-into-baskets-iii/description/
 */