public class Solution1956 {
}
/*
$1956. 感染 K 种病毒所需的最短时间
https://leetcode.cn/problems/minimum-time-for-k-virus-variants-to-spread/

在无限大的二维平面上有 n 种 不同 的病毒。给定二维数组 points ，第 i 项 points[i] = [xi, yi] 说明第 0 天有一种病毒在点 (xi, yi) 。注意初始状态下，可能有 多种 病毒在 同一点 上。
每天，被感染的点会把它感染的病毒传播到上、下、左、右四个邻居点。
现给定一个整数 k ，问 最少 需要多少天，方能找到一点感染 至少 k 种病毒？
提示：
n == points.length
2 <= n <= 50
points[i].length == 2
1 <= xi, yi <= 10^9
2 <= k <= n

目前部分题解（包括标程）的一个错误
https://leetcode.cn/problems/minimum-time-for-k-virus-variants-to-spread/solution/mu-qian-de-ti-jie-bao-gua-biao-cheng-de-tvrfa/
 */