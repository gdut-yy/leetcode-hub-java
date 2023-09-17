package c277;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Abc277_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }
        int[] s = new int[k];
        for (int i = 0; i < k; i++) {
            s[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, k, edges, s));
    }

    private static Map<Integer, List<Integer>> adj0, adj1;
    private static Queue<int[]> queue;
    private static boolean[][] vis;

    private static String solve(int n, int m, int k, int[][] edges, int[] s) {
        adj0 = new HashMap<>();
        adj1 = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], a = edge[2];
            if (a == 0) {
                adj0.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
                adj0.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
            } else {
                adj1.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
                adj1.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
            }
        }
        Set<Integer> kSet = new HashSet<>();
        for (int i : s) {
            kSet.add(i);
        }

        queue = new ArrayDeque<>();
        queue.add(new int[]{1, 1});
        vis = new boolean[2][n + 1];
        vis[1][1] = true;
        int step = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int state = tuple[0], x = tuple[1];
                if (x == n) {
                    return String.valueOf(step);
                }

                nxt(state, x);
                // 开关
                if (kSet.contains(x)) {
                    state = 1 - state;
                    nxt(state, x);
                }
            }
        }
        return "-1";
    }

    private static void nxt(int state, int x) {
        if (state == 1) {
            for (int y : adj1.getOrDefault(x, new ArrayList<>())) {
                if (!vis[state][y]) {
                    vis[state][y] = true;
                    queue.add(new int[]{state, y});
                }
            }
        } else {
            for (int y : adj0.getOrDefault(x, new ArrayList<>())) {
                if (!vis[state][y]) {
                    vis[state][y] = true;
                    queue.add(new int[]{state, y});
                }
            }
        }
    }
}
/*
E - Crystal Switches
https://atcoder.jp/contests/abc277/tasks/abc277_e

给定一个由 N 个顶点和 M 条边组成的无向图。
对于 i=1,2，…，M，第 i 条边是连接顶点 u i 和 v i 的无向边，当 a i=1 时初始可通过，当 a i= 0 时初始不可通过。另外，在 K 个顶点上有开关:顶点 s1，顶点 s2，…，顶点 sk。
Takahashi 最初在顶点 1，并将重复执行下面两个动作中的一个，移动或点击开关，他可以每次选择，只要他想要的次数。
- 移动:选择一个与他当前所在的顶点相邻的顶点，然后移动到该顶点。
- 点击开关:如果他当前所在的顶点上有一个开关，点击它。这将反转图中每条边的可通过性。也就是说，一条可通过的边将变得不可通过，反之亦然。
确定 Takahashi 是否可以到达顶点 N，如果可以，打印他在到达顶点 N 之前执行 Move 的最小可能次数。

构造两个图。有开关的节点可以选择是否触发。
======

Input 1
5 5 2
1 3 0
2 3 1
5 4 1
2 1 1
1 4 0
3 4
Output 1
5

Input 2
4 4 2
4 3 0
1 2 1
1 2 0
2 1 1
2 4
Output 2
-1
 */