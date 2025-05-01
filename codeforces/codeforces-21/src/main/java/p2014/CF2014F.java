package p2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF2014F {
    static int n, c;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            c = scanner.nextInt();
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
            System.out.println(solve());
        }
    }

    private static String solve() {
        long[] res = dfs(0, -1);
        long ans = Math.max(res[0], res[1]);
        return String.valueOf(ans);
    }

    static long[] dfs(int v, int fa) {
        long notDec = 0;
        long dec = a[v];
        for (Integer w : g[v]) {
            if (w == fa) continue;
            long[] sub = dfs(w, v);
            notDec += Math.max(sub[0], sub[1]);
            dec += Math.max(sub[0], sub[1] - c * 2L);
        }
        return new long[]{notDec, dec};
    }
}
/*
F. Sheriff's Defense
https://codeforces.com/contest/2014/problem/F

灵茶の试炼 2025-03-20
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) c(1≤c≤1e9) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
然后输入一棵无向树的 n-1 条边，节点编号从 1 到 n。节点 v 的点权为 a[v]。
你可以标记树上的一些点。
每当你标记一个点 v，就把 v 的所有邻居的点权都减少 c。注意一个节点的点权可以被多次减少。
输出你标记的节点的点权的最大和。
比如 n=2，如果两个节点都标记，那么互相把对方的点权减 c，答案为 a[1] + a[2] - c * 2。

rating 2000
树形 DP + 状态机 DP。状态定义类似 力扣 337. 打家劫舍 III。
考虑点 v 是否标记（选或不选）。
dfs 返回两个数（返回 pair）：不选 v 时的子树最大点权和，选 v 时的子树最大点权和。
不选 v，那么 v 的所有儿子都不会减 c，问题变成每个儿子选或不选的最大答案，
把 max(不选儿子，选儿子) 加到「不选 v 时的子树最大点权和」中。
选 v，那么 v 的所有儿子都减 c，问题变成每个儿子选或不选的最大答案，如果儿子选，那么 v 和儿子都要减 c，
把 max(儿子不选，儿子选-c*2) 加到「选 v 时的子树最大点权和」中。
最后答案为 max(不选根节点，选根节点)。
代码 https://codeforces.com/problemset/submission/2014/310661533
代码备份（洛谷）
======

Input
5
3 1
2 3 1
1 2
2 3
3 1
3 6 3
1 2
2 3
3 1
-2 -3 -1
1 2
2 3
6 1
5 -4 3 6 7 3
4 1
5 1
3 5
3 6
1 2
8 1
3 5 2 7 8 5 -3 -4
7 3
1 8
4 3
3 5
7 6
8 7
2 1
Output
3
8
0
17
26
 */
