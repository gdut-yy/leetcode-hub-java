package c282;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc282_d {
    private static Map<Integer, List<Integer>> adj;
    private static int[] colors;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, m, edges));
    }

    private static String solve(int n, int m, int[][] edges) {
        adj = new HashMap<>();
        colors = new int[n + 1];
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        long ans = n * (n - 1L) / 2 - m;
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                // 1:蓝色 -1:红色
                int[] res = dfs(i, -1, 1);
                if (res[0] == -1) {
                    return "0";
                }
                ans -= res[0] * (res[0] - 1L) / 2;
                ans -= res[1] * (res[1] - 1L) / 2;
            }
        }
        return String.valueOf(ans);
    }

    // 蓝色 红色
    private static int[] dfs(int x, int fa, int color) {
        int[] ans = new int[]{0, 0};
        colors[x] = color;

        if (color == 1) {
            ans[0]++;
        } else {
            ans[1]++;
        }

        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa || colors[y] == -color) {
                continue;
            }
            if (colors[y] == color) {
                return new int[]{-1, -1};
            }
            int[] res = dfs(y, x, -color);
            if (res[0] == -1) {
                return new int[]{-1, -1};
            }
            ans[0] += res[0];
            ans[1] += res[1];
        }
        return ans;
    }
}
/*
D - Make Bipartite 2
https://atcoder.jp/contests/abc282/tasks/abc282_d

题目大意：
给定一个简单的无向图 G，它有 N 个顶点和 M 条边(简单图不包含自环或多条边)。对于 i=1,2，…，M，第 i 条边连接顶点 u i 和顶点 v i。
输出满足 1≤u<v≤N 且满足以下两个条件的整数(u,v)对的个数。

二分图染色。
======

Input 1
5 4
4 2
3 1
5 2
3 2
Output 1
2

Input 2
4 3
3 1
3 2
1 2
Output 2
0

Input 3
9 11
4 9
9 1
8 2
8 3
9 2
8 4
6 7
4 6
7 5
4 5
7 8
Output 3
9
 */