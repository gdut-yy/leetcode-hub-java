public class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        int isConnectedM = isConnected.length;
        int isConnectedN = isConnected[0].length;
        UnionFind unionFind = new UnionFind(isConnectedM);
        for (int i = 0; i < isConnectedM; i++) {
            for (int j = 0; j < isConnectedN; j++) {
                if(isConnected[i][j] == 1){
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.count;
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
            count = n;
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
    }
}
/*
547. 省份数量
https://leetcode-cn.com/problems/number-of-provinces/

并查集。
 */