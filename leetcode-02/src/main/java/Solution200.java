public class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int gridM = grid.length;
        int gridN = grid[0].length;
        UnionFind unionFind = new UnionFind(grid);
        for (int m = 0; m < gridM; m++) {
            for (int n = 0; n < gridN; n++) {
                if (grid[m][n] == '1') {
                    // up
                    if (m - 1 >= 0 && grid[m - 1][n] == '1') {
                        unionFind.union(m * gridN + n, (m - 1) * gridN + n);
                    }
                    // down
                    if (m + 1 < gridM && grid[m + 1][n] == '1') {
                        unionFind.union(m * gridN + n, (m + 1) * gridN + n);
                    }
                    // left
                    if (n - 1 >= 0 && grid[m][n - 1] == '1') {
                        unionFind.union(m * gridN + n, m * gridN + n - 1);
                    }
                    // right
                    if (n + 1 < gridN && grid[m][n + 1] == '1') {
                        unionFind.union(m * gridN + n, m * gridN + n + 1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        public UnionFind(char[][] grid) {
            int gridM = grid.length;
            int gridN = grid[0].length;
            parent = new int[gridM * gridN];
            rank = new int[gridM * gridN];
            count = 0;
            for (int i = 0; i < gridM; i++) {
                for (int j = 0; j < gridN; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * gridN + j] = i * gridN + j;
                        count++;
                    }
                    rank[i * gridN + j] = 0;
                }
            }
        }

        /**
         * 返回节点 x 的根节点
         *
         * @param x 节点 x
         * @return 节点 x 的根节点
         */
        private int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        /**
         * 将 p 和 q 连通
         *
         * @param p p
         * @param q q
         */
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    // 重量平衡
                    rank[rootP] += 1;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
}
/*
200. 岛屿数量
https://leetcode-cn.com/problems/number-of-islands/

并查集
时间复杂度 O(mn x α(mn))
空间复杂度 O(mn) 并查集需要使用的空间。
其中 m 和 n 分别为行数和列数。注意当使用路径压缩（见 find 函数）和按秩合并（见数组 rank）实现并查集时，
单次操作的时间复杂度为 α(mn)，其中 α(x) 为反阿克曼函数，当自变量 x 的值在人类可观测的范围内（宇宙中粒子的数量）时，
函数 α(x) 的值不会超过 5，因此也可以看成是常数时间复杂度。
 */