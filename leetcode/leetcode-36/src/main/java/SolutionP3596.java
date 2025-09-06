public class SolutionP3596 {
    public int minCost(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 1 && n == 2 || m == 2 && n == 1) return 3;
        return -1;
    }
}
/*
$3596. 最小花费路径交替方向 I
https://leetcode.cn/problems/minimum-cost-path-with-alternating-directions-i/description/

给定两个整数 m 和 n 分别表示一个网格的行数和列数。
进入单元格 (i, j) 的花费定义为 (i + 1) * (j + 1)。
路径始终从第 1 步进入单元格 (0, 0) 并支付入场花费开始。
在每一步，你移动到 相邻 的单元格，遵循交替的模式：
- 在 奇数次 移动，你必须向 右方 或 下方 移动。
- 在 偶数次 移动，你必须向 左方 或 上方 移动。
返回到达 (m - 1, n - 1) 的最小总花费。如果不可能到达，返回 -1。
提示：
1 <= m, n <= 10^6

脑筋急转弯。分类讨论即可。
时间复杂度 O(1)。
 */