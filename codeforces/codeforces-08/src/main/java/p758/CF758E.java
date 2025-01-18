package p758;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF758E {
    //    record edge(int v, int w, int wt, int p) {
    //    }
    static class edge {
        int v, w, wt, p;

        public edge(int v, int w, int wt, int p) {
            this.v = v;
            this.w = w;
            this.wt = wt;
            this.p = p;
        }
    }

    record nb(int to, int i) {
    }

    static int n;
    static edge[] es;
    static List<nb>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        es = new edge[n - 1];
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            int wt = scanner.nextInt();
            int p = scanner.nextInt();
            es[i] = new edge(v, w, wt, p);
            g[v].add(new nb(w, i));
        }


        System.out.println(solve());
    }

    static tuple[] a;
    static long dec;

    private static String solve() {
        a = new tuple[n + 1];
        Arrays.setAll(a, e -> new tuple());

        long minSum = dfs(1).minSum;
        if (minSum < 0) return "-1";

        dec = 0;
        modify(1);
        return n + "\n"
                + Arrays.stream(es)
                .map(e -> e.v + " " + e.w + " " + e.wt + " " + e.p)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    //    record tuple(long minSum, long extraDec) {
    //    }
    static class tuple {
        long minSum, extraDec;

        public tuple() {
        }

        public tuple(long minSum, long extraDec) {
            this.minSum = minSum;
            this.extraDec = extraDec;
        }
    }

    // 第一次 DFS：预处理每棵子树的 minSum（子树最小重量和）以及 extraDec（见下面注释）
    static tuple dfs(int v) {
        long minSum = 0, maxSum = 0;
        for (nb e : g[v]) {
            int w = e.to;
            // 递归计算子树 w 的最小重量和 mn、最大重量和 mx
            tuple sub = dfs(w);
            long mn = sub.minSum, mx = sub.extraDec;
            int p = es[e.i].p;
            // v-w 边的强度不能小于子树 w 的最小重量和
            if (mn < 0 || p < mn) {
                return new tuple(-1, 0);
            }
            int wt = es[e.i].wt;
            // v-w 边的强度可以减少到子树 w 的最小重量和
            minSum += Math.max(wt - (p - mn), 1) + mn;
            // 子树 w 的最大重量和不能超过 v-w 边的强度
            maxSum += wt + Math.min(mx, p);
            // 如果 v-w 这条边的强度 p < mx，那么 w 子树的最大重量和 mx 要额外减少 mx-p（减少到 p）
            // 说【额外】是因为 mx 已经是 w 子树内部减重之后的最大重量和了
            // 如果 p < mx，那么 mx 内部还要再减少 mx-p
            a[w].extraDec = Math.max(mx - p, 0);
        }
        a[v].minSum = minSum;
        // 最后返回子树 v 的最小重量和、最大重量和
        return new tuple(minSum, maxSum);
    }

    // 第二次 DFS：减重
    // 核心思想：优先减重最下面的边
    // 如果不这样做，先减重上面的，那么由于上面的边强度变小，下面的边也得跟着减重，不如先减重下面的边优
    static void modify(int v) {
        for (nb ew : g[v]) {
            int w = ew.to;
            // 递归之前，只累加需要减重的量，在递归之后处理减重，这样就可以保证下面的边先减重
            dec += a[w].extraDec;
            // 处理 w 子树内部的减重
            modify(w);
            // 处理 v-w 这条边的减重
            edge e = es[ew.i];
            // v-w 这条边，重量可以减到 1，强度可以减到子树 w 的最小重量和
            long d = Math.min(e.wt - 1, Math.min(e.p - a[w].minSum, dec));
            e.wt -= d;
            e.p -= d;
            dec -= d;
        }
    }
}
/*
E. Broken Tree
https://codeforces.com/contest/758/problem/E

灵茶の试炼 2024-10-04
题目大意：
输入 n(1≤n≤2e5) 和一棵树的 n-1 条边（节点编号从 1 开始），
然后输入 n-1 条边，每条边包含 4 个数 x y weight(1≤weight≤1e9) strength(0≤strength≤1e9)，表示 x 是 y 的父节点，边的重量为 weight，边的强度为 strength。
树根为 1。
如果 x-y 边的强度，小于子树 y 所有边的重量之和，那么这棵树就断了。
为了避免树断掉，你可以把边的重量减少，但边的强度也会随之减少。比如你把一条边的重量减少 3，那么边的强度也会减少 3。
边的重量必须是正整数，边的强度必须是非负整数。
你需要在避免树断掉的同时，让树的总重量尽量大。
如果无法做到，输出 -1。
否则输出具体方案，格式如下：
首先输出 n。
然后输出 n-1 条边，必须和输入的顺序完全相同，每条边的前两个数 x 和 y 不能变。

rating 2600
如果只要求输出最大重量和，估计难度在 2000 分左右。
剩下的 600 分难度在输出具体方案上。
详细思路我写在代码注释中了。
代码+详细注释 https://codeforces.com/problemset/submission/758/284117590
======

Input
3
1 3 5 7
3 2 4 3
Output
3
1 3 5 7
3 2 4 3

Input
4
1 3 2 3
3 4 5 1
3 2 3 3
Output
-1

Input
5
1 2 2 4
2 4 1 9
4 5 5 6
4 3 4 8
Output
5
1 2 2 4
2 4 1 9
4 5 1 2
4 3 2 6

Input
7
1 2 5 2
2 3 4 3
1 4 3 7
4 5 4 1
4 6 3 2
6 7 1 6
Output
7
1 2 5 2
2 3 2 1
1 4 3 7
4 5 3 0
4 6 3 2
6 7 1 6
 */
