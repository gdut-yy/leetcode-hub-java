package c287;

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

public class Abc287_c {
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
        if (m != n - 1) {
            return "No";
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int deg = adj.getOrDefault(i, new ArrayList<>()).size();
            if (deg > 2 || deg == 0) {
                return "No";
            }
            if (deg == 1) {
                queue.add(i);
            }
        }
        if (queue.size() != 2) {
            return "No";
        }
        queue.remove();
        Set<Integer> permutation = new HashSet<>();
        while (!queue.isEmpty()) {
            int x = queue.remove();
            permutation.add(x);
            for (int y : adj.getOrDefault(x, new ArrayList<>())) {
                if (!permutation.contains(y)) {
                    queue.add(y);
                }
            }
        }
        return permutation.size() == n ? "Yes" : "No";
    }
}
/*
C - Path Graph
https://atcoder.jp/contests/abc287/tasks/abc287_c

题目大意：
给你一个简单的无向图，有 N 个顶点和 M 条边。顶点编号为 1、2、…、N，边编号为 1、2、…、M。
边 i(i=1,2，…，M)连接顶点 ui 和 vi。
确定此图是否为路径图。
> 当且仅当存在一个序列(v1, v2，…，v N)，该序列是(1,2，…，N)的置换，且满足以下条件时，称有 N 个顶点的图为路径图:
> 对于所有 i=1,2，…，N-1，存在一条连接顶点 vi 和 vi+1 的边。
> 如果整数 i 和 j 满足 1≤i,j≤N 且 |i−j|≥2，则不存在连接顶点 vi 和 vj 的边。

拓扑排序
======

Input 1
4 3
1 3
4 2
3 2
Output 1
Yes

Input 2
2 0
Output 2
No

Input 3
5 5
1 2
2 3
3 4
4 5
5 1
Output 3
No
 */