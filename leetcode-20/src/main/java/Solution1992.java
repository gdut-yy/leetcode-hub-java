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
1992. 找到所有的农场组
https://leetcode-cn.com/problems/find-all-groups-of-farmland/

第 60 场双周赛 T2。
参考第 200 题 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
并查集。连片
然后找出 parent[] 值相同的 最大/最小值，分别对应左上角/右下角
 */