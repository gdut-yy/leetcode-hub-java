package lq240420;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LQ240420T8 {
    static int n, m, q;
    static int[] us, vs, fs;
    static List<Integer>[] path;
    static int[][] st;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            q = scanner.nextInt();

            us = new int[m];
            vs = new int[m];
            fs = new int[m];
            path = new ArrayList[n];
            Arrays.setAll(path, e -> new ArrayList<>());
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                int f = scanner.nextInt();

                path[u].add(i);
                path[v].add(i);
                us[i] = u;
                vs[i] = v;
                fs[i] = f;
            }

            st = new int[q][2];
            for (int i = 0; i < q; i++) {
                st[i][0] = scanner.nextInt() - 1;
                st[i][1] = scanner.nextInt() - 1;
            }
            System.out.println(solve());
        }
    }

    static int[] parent;
    static int[] depth;

    private static String solve() {
        boolean[] used = new boolean[m];
        parent = new int[n];
        Arrays.fill(parent, -1);
        depth = new int[n];
        Arrays.fill(depth, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        depth[0] = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();

            for (Integer i : path[u]) {
                int v = (us[i] == u) ? vs[i] : us[i];
                if (depth[v] == -1) {
                    parent[v] = i;
                    used[i] = true;
                    depth[v] = depth[u] + 1;
                    stack.push(v);
                }
            }
        }

        DSU dsu = new DSU(n);
        for (int i = 0; i < m; i++) {
            if (!used[i]) {
                int u = dsu.find(us[i]);
                int v = dsu.find(vs[i]);
                while (u != v) {
                    if (depth[u] < depth[v]) {
                        int tmp = u;
                        u = v;
                        v = tmp;
                    }
                    int p = (us[parent[u]] == u) ? vs[parent[u]] : us[parent[u]];
                    dsu.union(p, u);
                    u = dsu.find(u);
                }
            }
        }

        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            col[i] = dsu.find(i);
        }
        // 离散化
        int[] col_map = getDiscrete(col);
        int[] col_tmp = new int[n];
        for (int i = 0; i < n; i++) {
            col_tmp[i] = getId(col_map, col[i]);
        }
        col = col_tmp;

        int color = Arrays.stream(col).max().orElseThrow() + 1;
        int[] nodes = new int[color + 1];
        List<Integer>[] npath = new ArrayList[color];
        Arrays.setAll(npath, e -> new ArrayList<>());
        for (int u = 0; u < n; u++) {
            for (Integer i : path[u]) {
                int v = (us[i] == u) ? vs[i] : us[i];
                if (col[u] == col[v]) {
                    nodes[col[u]] |= fs[i];
                } else {
                    if (fs[i] != 0) {
                        npath[col[u]].add(~col[v]);
                    } else {
                        npath[col[u]].add(col[v]);
                    }
                }
            }
        }

        parent = new int[color];
        Arrays.fill(parent, -1);
        depth = new int[color];
        stack.clear();
        stack.push(0);
        int[] edges = new int[color];
        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (Integer v : npath[u]) {
                int c = 0;
                if (v < 0) {
                    v = ~v;
                    c = 1;
                }
                if (parent[u] != v) {
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    nodes[v] += nodes[u];
                    edges[v] += edges[u] + c;
                    stack.push(v);
                }
            }
        }

        String[] output = new String[q];
        for (int i = 0; i < q; i++) {
            int u = st[i][0], v = st[i][1];
            int cu = col[u], cv = col[v];
            int l = getLCA(cu, cv);
            int cnt = nodes[cu] + nodes[cv] - nodes[l] - nodes[Math.floorMod(parent[l], color + 1)];
            cnt += edges[cu] + edges[cv] - edges[l] * 2;
            output[i] = (cnt != 0) ? "Yes" : "No";
        }
        return String.join(System.lineSeparator(), output);
    }

    static int getLCA(int x, int y) {
        if (depth[x] > depth[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        while (depth[y] - depth[x] >= 1) {
            y = parent[y];
        }
        while (parent[y] != parent[x]) {
            y = parent[y];
            x = parent[x];
        }
        return (x == y) ? x : parent[x];
    }

    static int[] getDiscrete(int[] xArr) {
        Set<Integer> set = new HashSet<>();
        for (int x : xArr) {
            set.add(x);
        }
        int sz = set.size();
        int[] yArr = new int[sz];
        int id = 0;
        for (int x : set) {
            yArr[id++] = x;
        }
        Arrays.sort(yArr);
        return yArr;
    }

    static int getId(int[] yArr, int x) {
        return Arrays.binarySearch(yArr, x);
    }

    static class DSU {
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
}
/*
外卖员的小爱好【算法赛】

考察图论，树，代码能力。
本题是一个图上问题，询问从 s 到 t 能否经过一条特殊边。
可能有同学有不同解法。
本文提供一种可行的解法。
第一步，对图进行缩点处理，由于是无向图，所以我们只需要算出所有的桥，即割边，然后删除割边，剩下的连通块自然形成一个点，对每个连通块进行特殊检查即可。
然后整个图会退化为一棵树，我们对树进行 LCA 预处理，每次询问的时候倍增查找即可。
查找这一步有很多不同的解法，树上差分也好，倍增也好，都能在正确的复杂度下过题。
时间复杂度为：O(nlogn)。
如果是离线lca求法，可以将复杂度降为接近：O(n)。
注：小羊肖恩有一种神奇的缩点法，

1
7 7 4
1 2 1
1 3 0
3 2 0
3 7 0
3 4 0
4 5 0
4 6 0
1 3
5 6
4 7
6 1

Yes
No
Yes
Yes
 */