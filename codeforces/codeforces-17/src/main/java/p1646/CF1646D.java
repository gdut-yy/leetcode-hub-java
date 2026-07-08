package p1646;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1646D {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static List<List<Integer>> g;
    static int[][] f;
    static int[] ans;

    static int[] dfs(int v, int fa) {
        int notChosen = 0, chosen = 1, notChosenS = 1, chosenS = g.get(v).size();
        for (int w : g.get(v)) {
            if (w == fa) continue;
            int[] child = dfs(w, v);
            int cnc = child[0], cc = child[1], cncs = child[2], ccs = child[3];
            if (cnc > cc) {
                notChosen += cnc;
                notChosenS += cncs;
            } else if (cnc < cc) {
                notChosen += cc;
                notChosenS += ccs;
            } else {
                notChosen += cc;
                notChosenS += Math.min(cncs, ccs);
            }
            chosen += cnc;
            chosenS += cncs;
        }
        f[v][0] = notChosen;
        f[v][1] = chosen;
        f[v][2] = notChosenS;
        f[v][3] = chosenS;
        return new int[]{notChosen, chosen, notChosenS, chosenS};
    }

    static void makeAns(int v, int fa, boolean isChosen) {
        ans[v] = isChosen ? g.get(v).size() : 1;
        for (int w : g.get(v)) {
            if (w != fa) {
                makeAns(w, v, !isChosen && (f[w][0] < f[w][1] || f[w][0] == f[w][1] && f[w][2] > f[w][3]));
            }
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        if (n == 2) {
            out.println("2 2");
            out.print("1 1");
            return;
        }
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1, w = scanner.nextInt() - 1;
            g.get(v).add(w);
            g.get(w).add(v);
        }
        f = new int[n][4];
        int[] res = dfs(0, -1);
        int nc = res[0], c = res[1], ncs = res[2], cs = res[3];
        ans = new int[n];
        boolean choose = nc < c || nc == c && ncs > cs;
        makeAns(0, -1, choose);
        out.println(Math.max(nc, c) + " " + (choose ? cs : ncs));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(i > 0 ? " " : "").append(ans[i]);
        out.print(sb);
    }
}
/*
D. Weight the Tree
https://codeforces.com/contest/1646/problem/D

灵茶の试炼 2026-01-22
题目大意：
输入 n(2≤n≤2e5) 和一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 到 n。
你需要给每个节点分配一个整数点权，值在 [1, 1e9] 中。
我们称点 x 为「好点」，当且仅当 x 的点权等于 x 的邻居的点权和。
目标是让树中的好点尽量多。
如果「好点个数最多」的方案不止一种，你还需要让整棵树的点权总和尽量小。
输出两行：
第一行输出好点个数，点权总和。
第二行输出节点 1,2,...,n 的点权。
多解输出任意解。

rating 2000
对于一个非叶节点 x（度 > 1 的节点），如果 x 是好点，那么 x 的点权大于其邻居点权（因为点权都是正数），所以其邻居不能是好点。
对于一个叶子节点 x，如果 n > 3，那么 x 的邻居必然不是叶子。如果 x 是好点，那么其邻居不能是好点。
所以当一个点是好点时，其邻居不能是好点。
这是最大独立集。视频讲解【基础算法精讲 24】。
注意本题还需要保证点权和最小，这需要修改最大独立集的 DP 过程，额外维护选或不选分别对应的点权和的最小值。
算完 DP 后，再跑一遍自顶向下的 DFS，求出每个点选或不选。
如果不选根节点，独立集的大小更大，那么不选；
如果选根节点，独立集的大小更大，那么选；
如果一样大，就根据对应的点权和判断，哪个小用哪个决策。
从根节点开始，如果根节点选，那么其儿子不能选。
如果根节点不选，那么儿子选不选？判断依据和根节点是一样的。依此类推。
特判 n=2 的情况，两个点都可以选（样例 3）。
代码 https://codeforces.com/contest/1646/submission/359027321
代码备份（上面打不开的同学看这个）
======

Input
4
1 2
2 3
2 4
Output
3 4
1 1 1 1

Input
3
1 2
1 3
Output
2 3
1 1 1

Input
2
1 2
Output
2 2
1 1

Input
9
3 4
7 6
2 1
8 3
5 6
1 8
8 6
9 6
Output
6 11
1 1 1 1 1 1 1 3 1
 */
