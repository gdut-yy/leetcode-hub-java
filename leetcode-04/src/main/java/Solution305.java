import java.util.ArrayList;
import java.util.List;

public class Solution305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind unionFind = new UnionFind(m * n);
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        List<Integer> resList = new ArrayList<>();
        for (int[] position : positions) {
            int curM = position[0];
            int curN = position[1];

            if (!visited[curM][curN]) {
                unionFind.count += 1;
                visited[curM][curN] = true;
                int curIdx = curM * n + curN;

                for (int[] dir : directions) {
                    int nextM = curM + dir[0];
                    int nextN = curN + dir[1];
                    int nextIdx = nextM * n + nextN;
                    if (nextM >= 0 && nextM < m && nextN >= 0 && nextN < n
                            && visited[nextM][nextN]
                            && !unionFind.connected(curIdx, nextIdx)) {
                        unionFind.union(curIdx, nextIdx);
                    }
                }
            }
            resList.add(unionFind.count);
        }
        return resList;
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        // 0 ~ n-1
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
//            count = n;
            count = 0;
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

        // p 和 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }
}
/*
$305. 岛屿数量 II
https://leetcode-cn.com/problems/number-of-islands-ii/

给你一个大小为 m x n 的二进制网格 grid 。网格表示一个地图，其中，0 表示水，1 表示陆地。最初，grid 中的所有单元格都是水单元格（即，所有单元格都是 0）。
可以通过执行 addLand 操作，将某个位置的水转换成陆地。给你一个数组 positions ，其中 positions[i] = [ri, ci] 是要执行第 i 次操作的位置 (ri, ci) 。
返回一个整数数组 answer ，其中 answer[i] 是将单元格 (ri, ci) 转换为陆地后，地图中岛屿的数量。
岛屿 的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。你可以假设地图网格的四边均被无边无际的「水」所包围。
提示：
1 <= m, n, positions.length <= 10^4
1 <= m * n <= 10^4
positions[i].length == 2
0 <= ri < m
0 <= ci < n
进阶：你可以设计一个时间复杂度 O(k log(mn)) 的算法解决此问题吗？（其中 k == positions.length）

并查集。注意本题的 连通分量 要从 0 开始增加。
 */