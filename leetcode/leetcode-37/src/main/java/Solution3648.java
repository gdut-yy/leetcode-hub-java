public class Solution3648 {
    public int minSensors(int n, int m, int k) {
        int d = k * 2 + 1;
        int a = (n + d - 1) / d;
        int b = (m + d - 1) / d;
        return a * b;
    }
}
/*
3648. 覆盖网格的最少传感器数目
https://leetcode.cn/problems/minimum-sensors-to-cover-grid/description/

第 163 场双周赛 T1。

给你一个 n × m 的网格和一个整数 k。
一个放置在单元格 (r, c) 的传感器可以覆盖所有与 (r, c) 的 切比雪夫距离不超过 k 的单元格。
两个单元格 (r1, c1) 和 (r2, c2) 之间的 切比雪夫距离 为 max(|r1 − r2|,|c1 − c2|)。
你的任务是返回覆盖整个网格所需传感器的 最少 数量。
提示:
1 <= n <= 10^3
1 <= m <= 10^3
0 <= k <= 10^3

数学。长和宽分别向上取整。
时间复杂度 O(1)。
 */