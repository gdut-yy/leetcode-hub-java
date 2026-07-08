package p2040;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF2040D {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int MX = 400001;
    static boolean[] np;
    static int cur;
    static int[] ans;
    static List<Integer>[] g;

    static {
        np = new boolean[MX];
        np[1] = true;
        for (int i = 2; i * i < MX; i++) {
            if (!np[i]) {
                for (int j = i * i; j < MX; j += i) {
                    np[j] = true;
                }
            }
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        ans = new int[n];
        ans[0] = 1;
        cur = 2;
        dfs(0, -1);
        StringBuilder sb = new StringBuilder();
        for (int v : ans) sb.append(v).append(" ");
        out.println(sb);
    }

    static void dfs(int v, int fa) {
        for (int w : g[v]) {
            if (w == fa) continue;
            while (!np[cur - ans[v]]) cur++;
            ans[w] = cur;
            cur++;
            dfs(w, v);
        }
    }
}
/*
D. Non Prime Tree
https://codeforces.com/contest/2040/problem/D

灵茶の试炼 2026-02-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 到 n。
给树上每个点设置整数点权，要求：
1. 点权范围 [1, 2n]。
2. 所有点权互不相同。
3. 相邻节点的点权绝对差不是质数。
输出节点 1,2,...,n 的点权。多解输出任意解。
如果无解，输出 -1。

rating 1900
质数密度是 O(1/log n)。由于非质数个数远多于质数个数，我们可以 DFS 这棵树，用先序遍历填入点权。
DFS 的同时，维护 cur 表示要填入的点权。根节点的点权是 1。
设当前节点为 v，其儿子为 w。
循环：如果 cur - (v 的点权) 是质数，则把 cur 增加一。
循环结束后，把 w 的点权置为 cur，然后把 cur 增加一。
左叶子右儿子的二叉树是最坏情况。
左儿子是当前节点点权 +1，右儿子是当前节点点权 +4。
在这种情况下，每多 2 个点，点权会增加 4。
当 n 是奇数时，最大点权为 2n-1；当 n 是偶数时，最大点权为 2n-2。符合题目点权 <= 2n 的限制。
代码 https://codeforces.com/problemset/submission/2040/363514082
代码备份（上面打不开的同学看这个）
======

Input
2
5
1 2
2 3
2 4
3 5
7
1 2
1 3
2 4
3 5
3 6
3 7
Output
2 10 1 6 5
8 7 12 1 4 6 3
 */
