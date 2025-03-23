import java.util.HashSet;
import java.util.Set;

public class Solution3493 {
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersectGeK(properties[i], properties[j], k)) {
                    dsu.union(i, j);
                }
            }
        }
        return dsu.sz;
    }

    // intersect >= k
    private boolean intersectGeK(int[] property1, int[] property2, int k) {
        Set<Integer> set = new HashSet<>();
        for (int v : property1) set.add(v);
        Set<Integer> set2 = new HashSet<>();
        for (int v : property2) set2.add(v);
        set.retainAll(set2);
        return set.size() >= k;
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
            sz = n;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
            sz--;
        }
    }
}
/*
3493. 属性图
https://leetcode.cn/problems/properties-graph/description/

第 442 场周赛 T2。

给你一个二维整数数组 properties，其维度为 n x m，以及一个整数 k。
定义一个函数 intersect(a, b)，它返回数组 a 和 b 中 共有的不同整数的数量 。
构造一个 无向图，其中每个索引 i 对应 properties[i]。如果且仅当 intersect(properties[i], properties[j]) >= k（其中 i 和 j 的范围为 [0, n - 1] 且 i != j），节点 i 和节点 j 之间有一条边。
返回结果图中 连通分量 的数量。
提示：
1 <= n == properties.length <= 100
1 <= m == properties[i].length <= 100
1 <= properties[i][j] <= 100
1 <= k <= m

并查集。
时间复杂度 O(n^2 * m)。
 */
