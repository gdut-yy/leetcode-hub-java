import java.util.Arrays;

public class Solution3665 {
    private static final int MOD = (int) (1e9 + 7);
    private int[][] grid;
    private long[][][] memo;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        int m = grid.length, n = grid[0].length;
        memo = new long[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return (int) dfs(m - 1, n - 1, 0);
    }

    private long dfs(int i, int j, int k) {
        if (i < 0 || j < 0) return 0; // 出界
        if (i == 0 && j == 0) return 1; // 到达起点
        if (memo[i][j][k] != -1) return memo[i][j][k];
        long res;
        if (grid[i][j] == 0) { // 没有镜子，随便走
            res = (dfs(i, j - 1, 0) + dfs(i - 1, j, 1)) % MOD;
        } else if (k == 0) { // 从下边过来，反射到左边
            res = dfs(i - 1, j, 1);
        } else { // 从右边过来，反射到上边
            res = dfs(i, j - 1, 0);
        }
        return memo[i][j][k] = res;
    }
}
/*
3665. 统计镜子反射路径数目
https://leetcode.cn/problems/twisted-mirror-path-count/description/

第 164 场双周赛 T3。

给你一个 m x n 的二进制网格 grid，其中：
- grid[i][j] == 0 表示一个空格子。
- grid[i][j] == 1 表示一面镜子。
一个机器人从网格的左上角 (0, 0) 出发，想要到达右下角 (m - 1, n - 1)。它只能向 右 或向 下 移动。如果机器人试图移入一个有镜子的格子，它会在进入该格子前被 反射：
- 如果它试图向 右 移动进入镜子，它会被转向 下 方，并移动到镜子正下方的格子里。
- 如果它试图向 下 移动进入镜子，它会被转向 右 方，并移动到镜子正右方的格子里。
如果这次反射会导致机器人移动到网格边界之外，则该路径被视为无效，不应被计数。
返回从 (0, 0) 到 (m - 1, n - 1) 不同的有效路径数量。
由于答案可能非常大，请将其返回对 10^9 + 7 取模 的结果。
注意：如果一次反射将机器人移动到一个有镜子的格子，机器人会立即再次被反射。这次反射的方向取决于它进入该镜子的方向：如果它是向右移动进入的，它将被转向下方；如果它是向下移动进入的，它将被转向右方。
提示:
m == grid.length
n == grid[i].length
2 <= m, n <= 500
grid[i][j] 的值为 0 或 1。
grid[0][0] == grid[m - 1][n - 1] == 0

记忆化搜索。
时间复杂度 O(mn)。
 */