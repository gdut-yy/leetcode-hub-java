package template;

/**
 * 并查集
 * <p>
 * 借这个问题科普一下并查集各种情况下的时间复杂度
 * https://leetcode-cn.com/problems/number-of-provinces/solution/jie-zhe-ge-wen-ti-ke-pu-yi-xia-bing-cha-0unne/
 */
public class UnionFind {
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
