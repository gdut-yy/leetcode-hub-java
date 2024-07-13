package template;

/**
 * 并查集（路径压缩）
 */
public class DSU {
    int[] fa;

    public DSU(int n) {
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    int find(int x) { // 查找
        return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
    }

    void union(int p, int q) { // 合并
        p = find(p);
        q = find(q);
        if (p == q) return;
        fa[q] = p;
    }
}
