package c111;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Arc111_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[][] ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, ab));
    }

    private static Map<Integer, List<Integer>> adj;
    private static Set<Integer> visitedSet;
    private static int cntV;
    private static int cntE;

    private static String solve(int n, int[][] edges) {
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        visitedSet = new HashSet<>();

        int res = 0;
        for (int x : adj.keySet()) {
            if (!visitedSet.contains(x)) {
                cntV = 0;
                cntE = 0;
                dfs(x);
                res += Math.min(cntV, cntE / 2);
            }
        }
        return String.valueOf(res);
    }

    private static void dfs(int x) {
        visitedSet.add(x);
        cntV++;
        List<Integer> yList = adj.getOrDefault(x, new ArrayList<>());
        cntE += yList.size();
        for (int y : yList) {
            if (!visitedSet.contains(y)) {
                visitedSet.add(y);
                dfs(y);
            }
        }
    }
}
/*
B - Reversible Cards
https://atcoder.jp/contests/arc111/tasks/arc111_b

灵茶の试炼 2023-02-07
题目大意：
输入 n(≤2e5) 和一个 n 行 2 列的矩阵，矩阵元素范围 [1,4e5]。
从每行中恰好选一个数，你最多能选出多少个不同的数？

不止一个连通块
https://atcoder.jp/contests/arc111/submissions/38552445
把每行的两个数当作图的一条边的两个端点。
对每个连通块分别统计。
如果连通块是树，那么答案是边数。
如果连通块不是树，那么答案是点数。
======

Input
4
1 2
1 3
4 2
2 3
Output
4

Input
2
111 111
111 111
Output
1

Input
12
5 2
5 6
1 2
9 7
2 7
5 5
4 2
6 7
2 2
7 8
9 7
1 8
Output
8
 */