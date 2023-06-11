package p1760;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CF1760G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[] u = new int[n - 1];
            int[] v = new int[n - 1];
            int[] w = new int[n - 1];
            for (int j = 0; j < n - 1; j++) {
                u[j] = scanner.nextInt();
                v[j] = scanner.nextInt();
                w[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a, b, u, v, w));
        }
    }

    private static String solve(int n, int a, int b, int[] u, int[] v, int[] w) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            adj.computeIfAbsent(u[i], key -> new ArrayList<>()).add(new int[]{v[i], w[i]});
            adj.computeIfAbsent(v[i], key -> new ArrayList<>()).add(new int[]{u[i], w[i]});
        }

        Set<Integer> xorSet1 = getXORs(adj, a, b);
        Set<Integer> xorSet2 = getXORs(adj, b, b);
        if (xorSet2.contains(0)) {
            return "YES";
        }
        for (int x : xorSet1) {
            if (xorSet2.contains(x)) {
                return "YES";
            }
        }
        return "NO";
    }

    // 从 begin 点出发，到除 exclude 的异或和
    private static Set<Integer> getXORs(Map<Integer, List<int[]>> adj, int begin, int exclude) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{begin, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(begin);
        visited.add(exclude);
        Set<Integer> xorSet = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int u = cur[0];
                int xor = cur[1];

                for (int[] ints : adj.getOrDefault(u, new ArrayList<>())) {
                    int v = ints[0];
                    int xor1 = xor ^ ints[1];
                    if (!visited.contains(v)) {
                        visited.add(v);
                        xorSet.add(xor1);
                        queue.add(new int[]{v, xor1});
                    }
                }
            }
        }
        return xorSet;
    }
}
/*
G. SlavicG's Favorite Problem
https://codeforces.com/contest/1760/problem/G

题目大意：
给定整数 n,a,b, 分别是顶点的个数，起始节点和期望的结束节点。n-1 条边 ui、vi 和 wi。
开始时变量 x 的初始值为 0。当你通过边 i 时，x 将其值更改为 x XOR wi（其中 wi 是第 i 条边的权值）。
你的任务是从顶点 a 到顶点 b，但是当且仅当到达节点 b 后，x 的值变为 0 时，你可以进入节点 b。
此外，除了 b 点，你最多可以在任何时间点传送一次到任何顶点。你可以从任何顶点传送，甚至从 a 点。

从 a b 点分别出发做 bfs，当且存在两个异或和相等的情况时，可以用传送机会跳到另一个顶点。
或者从 b 点出发的 存在 0 的异或和，开始就直接传送过去。
======

input
3
5 1 4
1 3 1
2 3 2
4 3 3
3 5 1
2 1 2
1 2 2
6 2 3
1 2 1
2 3 1
3 4 1
4 5 3
5 6 5

output
YES
NO
YES
 */