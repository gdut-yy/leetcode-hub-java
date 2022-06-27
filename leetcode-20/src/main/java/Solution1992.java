import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1992 {
    public int[][] findFarmland(int[][] land) {
        if (land.length == 0 || land[0].length == 0) {
            return new int[][]{};
        }
        int landM = land.length;
        int landN = land[0].length;
        // 并查集
        UnionFind unionFind = new UnionFind(land);
        for (int m = 0; m < landM; m++) {
            for (int n = 0; n < landN; n++) {
                if (land[m][n] == 1) {
                    // up
                    if (m - 1 >= 0 && land[m - 1][n] == 1) {
                        unionFind.union(m * landN + n, (m - 1) * landN + n);
                    }
                    // down
                    if (m + 1 < landM && land[m + 1][n] == 1) {
                        unionFind.union(m * landN + n, (m + 1) * landN + n);
                    }
                    // left
                    if (n - 1 >= 0 && land[m][n - 1] == 1) {
                        unionFind.union(m * landN + n, m * landN + n - 1);
                    }
                    // right
                    if (n + 1 < landN && land[m][n + 1] == 1) {
                        unionFind.union(m * landN + n, m * landN + n + 1);
                    }
                }
            }
        }
        // parent 值相等为同一个农场组
        int[] parent = unionFind.parent;
        Map<Integer, List<Integer>> cntMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                List<Integer> list = cntMap.getOrDefault(parent[i], new ArrayList<>());
                list.add(i);
                cntMap.put(parent[i], list);
            }
        }
        List<int[]> resList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : cntMap.entrySet()) {
            List<Integer> list = entry.getValue();
            int min = list.get(0);
            int max = list.get(list.size() - 1);
            resList.add(new int[]{min / landN, min % landN, max / landN, max % landN});
        }
        int[][] res = new int[resList.size()][4];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        public UnionFind(int[][] grid) {
            int gridM = grid.length;
            int gridN = grid[0].length;
            parent = new int[gridM * gridN];
            Arrays.fill(parent, -1);
            rank = new int[gridM * gridN];
            count = 0;
            for (int i = 0; i < gridM; i++) {
                for (int j = 0; j < gridN; j++) {
                    if (grid[i][j] == 1) {
                        parent[i * gridN + j] = i * gridN + j;
                        count++;
                    }
                    rank[i * gridN + j] = 0;
                }
            }
        }

        /**
         * 返回节点 x 的根节点
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
    }
}
/*
1992. 找到所有的农场组
https://leetcode.cn/problems/find-all-groups-of-farmland/

第 60 场双周赛 T2。

给你一个下标从 0 开始，大小为 m x n 的二进制矩阵 land ，其中 0 表示一单位的森林土地，1 表示一单位的农场土地。
为了让农场保持有序，农场土地之间以矩形的 农场组 的形式存在。每一个农场组都 仅 包含农场土地。且题目保证不会有两个农场组相邻，
也就是说一个农场组中的任何一块土地都 不会 与另一个农场组的任何一块土地在四个方向上相邻。
land 可以用坐标系统表示，其中 land 左上角坐标为 (0, 0) ，右下角坐标为 (m-1, n-1) 。请你找到所有 农场组 最左上角和最右下角的坐标。
一个左上角坐标为 (r1, c1) 且右下角坐标为 (r2, c2) 的 农场组 用长度为 4 的数组 [r1, c1, r2, c2] 表示。
请你返回一个二维数组，它包含若干个长度为 4 的子数组，每个子数组表示 land 中的一个 农场组 。如果没有任何农场组，请你返回一个空数组。
可以以 任意顺序 返回所有农场组。

并查集。连片
然后找出 parent[] 值相同的 最大/最小值，分别对应左上角/右下角

相似题目: 200. 岛屿数量
https://leetcode.cn/problems/number-of-islands/
 */