import java.util.LinkedList;
import java.util.Queue;

public class Solution1254 {
    private int M;
    private int N;

    public int closedIsland(int[][] grid) {
        this.M = grid.length;
        this.N = grid[0].length;

        // “水淹” 所有边缘的 土地
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if ((i == 0 || i == M - 1 || j == 0 || j == N - 1) && grid[i][j] == 0) {
                    bfs(grid, i, j);
                }
            }
        }

        // Same as Solution200
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    // up
                    if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                        unionFind.union(i * N + j, (i - 1) * N + j);
                    }
                    // down
                    if (i + 1 < M && grid[i + 1][j] == 0) {
                        unionFind.union(i * N + j, (i + 1) * N + j);
                    }
                    // left
                    if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                        unionFind.union(i * N + j, i * N + j - 1);
                    }
                    // right
                    if (j + 1 < N && grid[i][j + 1] == 0) {
                        unionFind.union(i * N + j, i * N + j + 1);
                    }
                }
            }
        }
        return unionFind.count;
    }

    private void bfs(int[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.remove();
                grid[cur[0]][cur[1]] = 1;

                for (int[] dir : directions) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N
                            && grid[nextM][nextN] == 0) {
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        public UnionFind(int[][] grid) {
            int M = grid.length;
            int N = grid[0].length;
            parent = new int[M * N];
            rank = new int[M * N];
            count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 0) {
                        parent[i * N + j] = i * N + j;
                        count++;
                    }
                    rank[i * N + j] = 0;
                }
            }
        }

        // 返回节点 x 的根节点
        private int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        // 将 p 和 q 连通
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
    }
}
/*
1254. 统计封闭岛屿的数目
https://leetcode-cn.com/problems/number-of-closed-islands/

二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
请返回 封闭岛屿 的数目。
提示：
1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1

并查集 + BFS
先将与矩阵边缘联通的 0 全部转成 1，其余同 岛屿数量。
相似题目: 200. 岛屿数量
https://leetcode-cn.com/problems/number-of-islands/
1020. 飞地的数量
https://leetcode-cn.com/problems/number-of-enclaves/
 */