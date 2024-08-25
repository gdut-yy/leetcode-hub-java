package p292;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF292D {
    static int n, m;
    static int[][] edges;
    static int k;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt() - 1;
            edges[i][1] = scanner.nextInt() - 1;
        }
        k = scanner.nextInt();
        lr = new int[k][2];
        for (int i = 0; i < k; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        System.out.println(solve1());
    }

    static int[] fa;

    static void init(int n) {
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    static int find(int x) {
        if (x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    private static String solve() {
        init(n);
        int[][] pre = new int[m + 1][n];
        pre[0] = fa.clone();
        for (int i = 0; i < m; i++) {
            int x = edges[i][0], y = edges[i][1];
            fa[find(x)] = find(y);
            pre[i + 1] = fa.clone();
        }

        init(n);
        int[][] suf = new int[m + 1][n];
        suf[m] = fa.clone();
        for (int i = m - 1; i > 0; i--) {
            int x = edges[i][0], y = edges[i][1];
            fa[find(x)] = find(y);
            suf[i] = fa.clone();
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int l = lr[i][0], r = lr[i][1];

            fa = pre[l - 1].clone();
            for (int j = 0; j < n; j++) {
                fa[find(fa[j])] = find(suf[r][j]);
            }
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == fa[j]) {
                    c++;
                }
            }
            ans[i] = c;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static String solve1() {
        DSU dsu = new DSU(n);
        DSU[] pre = new DSU[m + 1];
        pre[0] = new DSU(n);
        pre[0].fa = dsu.fa.clone();
        for (int i = 0; i < m; i++) {
            dsu.union(edges[i][0], edges[i][1]);
            pre[i + 1] = new DSU(n);
            pre[i + 1].fa = dsu.fa.clone();
        }

        dsu = new DSU(n);
        DSU[] suf = new DSU[m + 1];
        suf[m] = new DSU(n);
        suf[m].fa = dsu.fa.clone();
        for (int i = m - 1; i > 0; i--) {
            dsu.union(edges[i][0], edges[i][1]);
            suf[i] = new DSU(n);
            suf[i].fa = dsu.fa.clone();
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int l = lr[i][0], r = lr[i][1];

            DSU tmp = new DSU(n);
            tmp.fa = pre[l - 1].fa.clone();
            for (int j = 0; j < n; j++) {
                tmp.union(tmp.fa[j], suf[r].fa[j]);
            }
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == tmp.fa[j]) {
                    c++;
                }
            }
            ans[i] = c;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    public static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[p] = q;
        }
    }
}
/*
D. Connected Components
https://codeforces.com/contest/292/problem/D

灵茶の试炼 2023-06-15
題目大意：
输入 n(2≤n≤500) m(1≤m≤1e4) 和一个无向图的 m 条边，节点编号从 1 到 n，无自环，可能有重边。
然后输入 k(1≤k≤2e4) 个询问，每个询问输入 left 和 right，表示删除第 left 到第 right 条边（边按照输入编号，从 1 到 m）。
对每个询问，输出删除边后，此时有多少个连通块。
请注意：每个询问都是独立的，在下个询问前会恢复成原图。

rating 1900
https://codeforces.com/contest/292/submission/173783235
前后缀分解。
预处理，对 m 条边的每个前缀和每个后缀建立大小为 n 的并查集，递推计算。每次递推在上一个并查集的基础上计算，预处理总时间 O(nm)。（每次递推都要 copy 一次并查集）
对每个询问，把对应的前缀与后缀的并查集合并（对每个 i，把前缀的 fa[i] 与后缀的 fa[i] 合并），这样每个询问只需要 O(n) 的时间。（暴力是 O(m)）
======

input
6 5
1 2
5 4
2 3
3 1
3 6
6
1 3
2 5
1 5
5 5
2 4
3 3
output
4
5
6
3
4
2
 */
