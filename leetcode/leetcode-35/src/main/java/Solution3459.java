public class Solution3459 {
    private static final int[][] DIRS = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}}; // 顺时针 90 度转向
    private int[][] grid;
    private int[][][] memo;

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        // 开太多维度影响效率，这里把后面三个状态压缩成一个 int
        memo = new int[m][n][1 << 4];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) { // 枚举起始方向
                        ans = Math.max(ans, dfs(i, j, k, 1, 2) + 1);
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int k, int canTurn, int target) {
        i += DIRS[k][0];
        j += DIRS[k][1];
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != target) {
            return 0;
        }
        int mask = (k << 2) | (canTurn << 1) | (target / 2);
        // 之前计算过
        if (memo[i][j][mask] > 0) return memo[i][j][mask];
        int res = dfs(i, j, k, canTurn, 2 - target); // 直行
        if (canTurn == 1) {
            res = Math.max(res, dfs(i, j, (k + 1) % 4, 0, 2 - target)); // 右转
        }
        return memo[i][j][mask] = res + 1; // 记忆化
    }
}
/*
3459. 最长 V 形对角线段的长度
https://leetcode.cn/problems/length-of-longest-v-shaped-diagonal-segment/description/

第 437 场周赛 T4。

给你一个大小为 n x m 的二维整数矩阵 grid，其中每个元素的值为 0、1 或 2。
V 形对角线段 定义如下：
- 线段从 1 开始。
- 后续元素按照以下无限序列的模式排列：2, 0, 2, 0, ...。
- 该线段：
  - 起始于某个对角方向（左上到右下、右下到左上、右上到左下或左下到右上）。
  - 沿着相同的对角方向继续，保持 序列模式 。
  - 在保持 序列模式 的前提下，最多允许 一次顺时针 90 度转向 另一个对角方向。
返回最长的 V 形对角线段 的 长度 。如果不存在有效的线段，则返回 0。
提示：
n == grid.length
m == grid[i].length
1 <= n, m <= 500
grid[i][j] 的值为 0、1 或 2。

记忆化搜索+剪枝优化。
相似题目: 2328. 网格图中递增路径的数目
https://leetcode.cn/problems/number-of-increasing-paths-in-a-grid/
rating 2539 (clist.by)
 */