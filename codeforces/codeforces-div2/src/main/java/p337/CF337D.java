package p337;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF337D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = scanner.nextInt();
        }
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, m, d, p, edges));
    }

    private static boolean[] evil;
    private static Map<Integer, List<Integer>> adj;
    private static Node[] dis;
    private static int ans;

    private static String solve(int n, int m, int d, int[] p, int[][] edges) {
        // evil[i] = true 表示节点 i 为 Book of Evil 节点
        evil = new boolean[n + 1];
        for (int x : p) {
            evil[x] = true;
        }
        // 建图
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        dis = new Node[n + 1];
        dfs1(1, -1);

        ans = 0;
        dfs2(1, -1, Integer.MIN_VALUE, d);
        return String.valueOf(ans);
    }

    private static int dfs1(int x, int fa) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, fx = 0;
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            int d = dfs1(y, x) + 1;
            if (d > first) {
                second = first;
                first = d;
                fx = y;
            } else if (d > second) {
                second = d;
            }
        }
        dis[x] = new Node(first, second, fx);
        if (first < 0 && evil[x]) {
            return 0;
        }
        return first;
    }

    // 换根 DP
    private static void dfs2(int x, int fa, int dFa, int d) {
        if (dFa > d) {
            return;
        }
        Node node = dis[x];
        if (node.first <= d) {
            ans++;
        }
        if (evil[x] && dFa < 0) {
            dFa = 0;
        }
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            if (y == node.fx) {
                dfs2(y, x, Math.max(dFa, node.second) + 1, d);
            } else {
                dfs2(y, x, Math.max(dFa, node.first) + 1, d);
            }
        }
    }

    private static class Node {
        // 对每个点记录往下走的最远特殊点距离和第二远特殊点距离，以及最远特殊点在哪棵子树中
        int first, second, fx;

        public Node(int first, int second, int fx) {
            this.first = first;
            this.second = second;
            this.fx = fx;
        }
    }
}
/*
D. Book of Evil
https://codeforces.com/contest/337/problem/D

灵茶の试炼 2023-03-08
题目大意：
输入 n m(1≤m≤n≤1e5) d(0≤d≤n-1) 表示一棵 n 个节点的树，其中 m 个节点有怪物，这些怪物是由一个传送门生成的，传送门与任意怪物的距离不超过 d。
然后输入 m 个互不相同的数，表示怪物所在节点编号（从 1 开始）。
然后输入 n-1 行，每行两个节点编号，表示树的边。
输出可能存在传送门的节点的个数。注意传送门只有一个。

https://codeforces.com/contest/337/submission/116580503
换根 DP。
第一次 DFS 以 1 为根，对每个点记录往下走的最远怪物距离和次远怪物距离，以及最远怪物在哪棵子树中。
第二次 DFS，从 v 到 w 时：
如果 w 是 v 的最远怪物所在子树，那么 w 往上的最远怪物距离就是 max(v 往上最远怪物距离, v 往下次远怪物距离)+1；
如果 w 不是 v 的最远怪物所在子树，那么 w 往上的最远怪物距离就是 max(v 往上最远怪物距离, v 往下最远怪物距离)+1。
对于一个点 v，如果 v 往上往下的最远怪物距离都不超过 d，那么 v 就可能是传送门所在位置。
相似题目: DD-2020007. 多源 D 点
https://leetcode.cn/problems/XiqZWx/
======

input
6 2 3
1 2
1 5
2 3
3 4
4 5
5 6
output
3
 */
