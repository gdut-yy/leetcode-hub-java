package p2114;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF2114E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 0; i < n - 1; i++) {
                int v = scanner.nextInt() - 1;
                int w = scanner.nextInt() - 1;
                g[v].add(w);
                g[w].add(v);
            }
            solve();
        }
        out.flush();
    }

    static long[] ans;

    private static void solve() {
        ans = new long[n];
        dfs(0, -1, 0, 0);

        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
    }

    static void dfs(int v, int fa, long _pos, long _neg) {
        long pos = _neg + a[v], neg = Math.max(_pos - a[v], 0);
        ans[v] = pos;
        for (Integer w : g[v]) {
            if (w != fa) {
                dfs(w, v, pos, neg);
            }
        }
    }
}
/*
E. Kirei Attacks the Estate
https://codeforces.com/contest/2114/problem/E

灵茶の试炼 2025-06-17
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
然后输入一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 开始。
树根为 1。节点点权记录在数组 a 中。
对于节点 v=1,2,3,...,n，输出从 v 往上的最大交替子段和，即 a[v] - a[parent[v]] + a[parent[parent[v]]] - ... 的最大值。

rating 1400
对于节点 v 来说，我们需要知道在 v 的父节点处，以负数项结尾的最大交替和，记作 neg。（我们保证 neg 非负）
那么 ans[v] = neg+a[v]。
往下传递信息时，为了计算在节点 v 处的 neg，我们需要知道在 v 的父节点处，以正数项结尾的最大交替和，记作 pos。
那么在节点 v 处，我们有
neg = max(pos-a[v], 0)。
pos = neg+a[v]。
这两项要同时计算。
代码 https://codeforces.com/contest/2114/submission/324426476
代码备份（Ubuntu Pastebin）
======

Input
2
5
4 5 2 6 7
1 2
3 2
4 3
5 1
6
1000000000 500500500 900900900 9 404 800800800
3 4
5 1
2 5
1 6
6 4
Output
4 5 2 9 7
1000000000 1500500096 1701701691 199199209 404 800800800
 */
