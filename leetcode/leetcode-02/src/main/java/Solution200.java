public class Solution200 {
    public int numIslands(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        // 岛屿数目
        int cnt = 0;
        for (char[] chars : grid) {
            for (char aChar : chars) {
                if (aChar == '1') {
                    cnt++;
                }
            }
        }

        DSU dsu = new DSU(M * N);
        dsu.sz = cnt;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '1') {
                    int p = i * N + j;
                    // up
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        dsu.union(p, p - N);
                    }
                    // down
                    if (i + 1 < M && grid[i + 1][j] == '1') {
                        dsu.union(p, p + N);
                    }
                    // left
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        dsu.union(p, p - 1);
                    }
                    // right
                    if (j + 1 < N && grid[i][j + 1] == '1') {
                        dsu.union(p, p + 1);
                    }
                }
            }
        }
        return dsu.sz;
    }

    private static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
            sz--;
        }
    }
}
/*
200. 岛屿数量
https://leetcode.cn/problems/number-of-islands/

给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'

并查集。将所有陆地连起来，联通分量即为岛屿数量。
时间复杂度 O(mn x α(mn))
空间复杂度 O(mn) 并查集需要使用的空间。
其中 m 和 n 分别为行数和列数。注意当使用路径压缩（见 find 函数）和按秩合并（见数组 rank）实现并查集时，
单次操作的时间复杂度为 α(mn)，其中 α(x) 为反阿克曼函数，当自变量 x 的值在人类可观测的范围内（宇宙中粒子的数量）时，
函数 α(x) 的值不会超过 5，因此也可以看成是常数时间复杂度。
 */