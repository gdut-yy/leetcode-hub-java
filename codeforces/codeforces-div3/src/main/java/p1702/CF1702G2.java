package p1702;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1702G2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[][] uv = new int[n][2];
        for (int i = 0; i < n - 1; i++) {
            uv[i][0] = scanner.nextInt() - 1;
            uv[i][1] = scanner.nextInt() - 1;
        }
        int q = scanner.nextInt();
        int[] qK = new int[q];
        int[][] qP = new int[q][];
        for (int i = 0; i < q; i++) {
            int k = scanner.nextInt();
            qK[i] = k;
            qP[i] = new int[k];
            for (int j = 0; j < k; j++) {
                qP[i][j] = scanner.nextInt() - 1;
            }
        }

        List<String> res = solve(n, uv, q, qK, qP);
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static int[] d;
    private static int sz;
    private static int[][] up;
    private static Map<Integer, List<Integer>> adj;

    private static List<String> solve(int n, int[][] uv, int q, int[] qK, int[][] qP) {
        sz = 0;
        while ((1 << sz) < n) {
            sz++;
        }
        d = new int[n];
        Arrays.fill(d, -1);
        up = new int[n][sz + 1];
        // 存图
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.computeIfAbsent(uv[i][0], key -> new ArrayList<>()).add(uv[i][1]);
            adj.computeIfAbsent(uv[i][1], key -> new ArrayList<>()).add(uv[i][0]);
        }
        // 预处理
        pretreatment(0, 0);

        List<String> resList = new ArrayList<>();
        for (int qi = 0; qi < q; qi++) {
            int k = qK[qi];
            Integer[] p = new Integer[k];
            for (int i = 0; i < k; i++) {
                p[i] = qP[qi][i];
            }

            Arrays.sort(p, (o1, o2) -> Integer.compare(d[o2], d[o1]));
            boolean[] used = new boolean[k];
            for (int i = 0; i < k; i++) {
                if (lca(p[0], p[i]) == p[i]) {
                    used[i] = true;
                }
            }
            int f = 0;
            while (f < k && used[f]) {
                f++;
            }
            if (f == k) {
                resList.add("YES");
            } else {
                boolean ans = true;
                for (int i = f; i < k; i++) {
                    if (lca(p[f], p[i]) == p[i]) {
                        used[i] = true;
                    }
                }
                for (boolean e : used) {
                    ans &= e;
                }
                ans &= d[lca(p[0], p[f])] <= d[p[k - 1]];
                resList.add(ans ? "YES" : "NO");
            }
        }
        return resList;
    }

    private static void pretreatment(int v, int p) {
        d[v] = d[p] + 1;
        up[v][0] = p;
        for (int i = 1; i <= sz; ++i) {
            up[v][i] = up[up[v][i - 1]][i - 1];
        }
        for (int u : adj.getOrDefault(v, new ArrayList<>())) {
            if (u == p) {
                continue;
            }
            pretreatment(u, v);
        }
    }

    // 倍增法求 lca
    private static int lca(int u, int v) {
        if (d[u] < d[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }
        for (int cur = sz; cur >= 0; --cur) {
            if (d[u] - (1 << cur) >= d[v]) {
                u = up[u][cur];
            }
        }
        for (int cur = sz; cur >= 0; --cur) {
            if (up[u][cur] != up[v][cur]) {
                u = up[u][cur];
                v = up[v][cur];
            }
        }
        return u == v ? u : up[u][0];
    }
}
/*
G2. Passable Paths (hard version)
https://codeforces.com/contest/1702/problem/G2

题目大意：
给定整数 n，n-1 行表示边，形成无向联通图，整数 q，q 行查询，每行为若干节点集合，求是否存在简单路径经过这些节点。

倍增法求 LCA
======

input
5
1 2
2 3
2 4
4 5
5
3
3 2 5
5
1 2 3 4 5
2
1 4
3
1 3 5
3
1 5 4

output
YES
NO
YES
NO
YES
 */