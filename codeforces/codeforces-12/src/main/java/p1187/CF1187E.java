package p1187;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1187E {
    static int n;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(solve());
    }

    static int[] size;
    static long ans;

    private static String solve() {
        size = new int[n + 1];
        ans = 0;
        reroot(1, 0, dfs(1, 0));
        return String.valueOf(ans);
    }

    static long dfs(int v, int fa) {
        long sum = 0;
        size[v] = 1;
        for (Integer w : g[v]) {
            if (w != fa) {
                sum += dfs(w, v);
                size[v] += size[w];
            }
        }
        return sum + size[v];
    }

    static void reroot(int v, int fa, long res) {
        ans = Math.max(ans, res);
        for (Integer w : g[v]) {
            if (w != fa) {
                reroot(w, v, res + n - size[w] * 2L);
            }
        }
    }
}
/*
E. Tree Painting
https://codeforces.com/contest/1187/problem/E

灵茶の试炼 2024-03-21
题目大意：
输入 n(2≤n≤2e5) 表示一棵有 n 个节点的无向无根树，然后输入这棵树的 n-1 条边（节点编号从 1 开始）。
一开始，所有节点都是白色的。
第一回合，你可以随便选一个节点，并把它涂成黑色，得到 n 分。
在接下来的 n-1 个回合中，每回合，选择一个与黑色节点相邻的白色节点。设该白色节点所在的白色连通块的大小为 k，你会先得到 k 分，然后把该白色节点涂成黑色。
输出最大得分和。

rating 2100
换根 DP。
教程 https://leetcode.cn/problems/sum-of-distances-in-tree/solution/tu-jie-yi-zhang-tu-miao-dong-huan-gen-dp-6bgb/
先通过一次 DFS 求出以 1 为根的得分，以及每棵子树的大小 size[i]。
然后换根，从根 v 换到根 w 时，得分减少了 size[w]，增加了 n-size[w]。后者是因为除去子树 w 的其余节点成为了一棵新的子树，其大小为 n-size[w]。
https://codeforces.com/contest/1187/submission/252381990
======

Input
9
1 2
2 3
2 5
2 6
1 4
4 9
9 7
9 8
Output
36

Input
5
1 2
1 3
2 4
2 5
Output
14
 */
