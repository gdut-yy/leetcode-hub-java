public class Solution3797 {
    static final int MOD = (int) (1e9 + 7);

    public int numberOfRoutes(String[] grid, int d) {
        int m = grid[0].length();
        long[] sumF = new long[m + 1];
        long[] sum = new long[m + 1];

        for (int i = 0; i < grid.length; i++) {
            char[] row = grid[i].toCharArray();
            // 从 i-1 行移动到 i 行的方案数
            long[] f = new long[m];
            for (int j = 0; j < m; j++) {
                if (row[j] == '#') {
                    continue;
                }
                if (i == 0) { // 第一行（起点）
                    f[j] = 1; // DP 初始值
                } else {
                    f[j] = sum[Math.min(j + d, m)] - sum[Math.max(j - d + 1, 0)];
                }
            }
            // f 的前缀和
            for (int j = 0; j < m; j++) {
                sumF[j + 1] = (sumF[j] + f[j]) % MOD;
            }
            // 从 i 行移动到 i 行的方案数
            long[] g = new long[m];
            for (int j = 0; j < m; j++) {
                if (row[j] == '#') {
                    continue;
                }
                // 不能原地不动，减去 f[j]
                g[j] = sumF[Math.min(j + d + 1, m)] - sumF[Math.max(j - d, 0)] - f[j];
            }
            // f[j] + g[j] 的前缀和
            for (int j = 0; j < m; j++) {
                sum[j + 1] = (sum[j] + f[j] + g[j]) % MOD;
            }
        }
        return (int) ((sum[m] + MOD) % MOD); // +MOD 保证结果非负
    }
}
/*
3797. 统计在矩形格子里移动的路径数目
https://leetcode.cn/problems/count-routes-to-climb-a-rectangular-grid/description/

第 173 场双周赛 T4。

给你一个大小为 n 的字符串数组 grid，其中每个字符串 grid[i] 的长度为 m。字符 grid[i][j] 是以下符号之一：
- '.'：该单元格可用。
- '#'：该单元格被阻塞。
你想计算攀爬 grid 的不同路径数量。每条路径必须从最后一行（第 n - 1 行）的任何一个格子开始，并在第一行（第 0 行）结束。
但是，路径受到以下限制：
- 你只能从一个可用单元格移动到 另一个 可用单元格。
- 每次移动的 欧几里得距离至多 为 d，其中 d 是给定的整数参数。两个单元格 (r1, c1) 和 (r2, c2) 之间的欧几里得距离为 sqrt((r1 - r2)2 + (c1 - c2)2)。
- 每次移动要么留在同一行，要么移动到正上方的一行（从第 r 行到第 r - 1 行）。
- 你不能连续两次移动都留在同一行。如果你在一次移动中留在同一行（且该移动不是最后一次移动），你的下一次移动必须进入上一行。
返回一个整数，表示此类路径的数量。由于答案可能很大，请将其对 10^9 + 7 取余 后返回。
提示:
1 <= n == grid.length <= 750
1 <= m == grid[i].length <= 750
grid[i][j] 为 '.' 或 '#'。
1 <= d <= 750

前缀和优化 DP https://leetcode.cn/problems/count-routes-to-climb-a-rectangular-grid/solutions/3872180/qian-zhui-he-you-hua-dppythonjavacgo-by-w3ve2/
rating 2378 (clist.by)
 */