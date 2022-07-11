package template;

public class DSU {
    // 父节点数组/祖先数组
    int[] fa;

    // 初始化
    public DSU(int n) {
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    // 查找
    int find(int x) {
        // 路径压缩
        if (x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    // 合并
    void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        fa[rootQ] = rootP;
    }
}
