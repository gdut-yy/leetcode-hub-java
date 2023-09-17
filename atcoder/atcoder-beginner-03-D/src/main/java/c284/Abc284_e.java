package c284;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc284_e {
    private static int n, m;
    private static Map<Integer, List<Integer>> adj;
    private static boolean[] vis;
    private static int ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        // MLE
//        int[][] edges = new int[m][2];
//        for (int i = 0; i < m; i++) {
//            edges[i][0] = scanner.nextInt();
//            edges[i][1] = scanner.nextInt();
//        }
        adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
        }
        System.out.println(solve());
    }

    // https://atcoder.jp/contests/abc284/editorial/5498
    private static String solve() {
        ans = 0;
        vis = new boolean[n];
        dfs(0);
        return String.valueOf(ans);
    }

    private static final int E6 = (int) 1e6;

    private static void dfs(int x) {
        if (ans == E6) {
            return;
        }
        ans++;
        vis[x] = true;
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (vis[y]) continue;
            dfs(y);
        }
        vis[x] = false;
    }
}
/*
E - Count Simple Paths
https://atcoder.jp/contests/abc284/tasks/abc284_e

题目大意：
给你一个简单的无向图，有 N 个编号为 1 到 N 的顶点，M 条编号为 1 到 M 的边，边 i 连接着顶点 u i 和顶点 vi。每个顶点的度数最多为 10。
设 K 为从顶点 1 开始的简单路径(没有重复顶点的路径)的个数。打印 min(K,10^6)。

DFS 计数
======

Input 1
4 2
1 2
2 3
Output 1
3

Input 2
4 6
1 2
1 3
1 4
2 3
2 4
3 4
Output 2
16

Input 3
8 21
2 6
1 3
5 6
3 8
3 6
4 7
4 6
3 4
1 5
2 4
1 2
2 7
1 4
3 5
2 5
2 3
4 5
3 7
6 7
5 7
2 8
Output 3
2023
 */