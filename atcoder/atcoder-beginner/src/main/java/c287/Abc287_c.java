package c287;

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

public class Abc287_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            edges[i] = new int[]{u, v};
        }
        System.out.println(solve(n, m, edges));
    }

    private static String solve(int n, int m, int[][] edges) {
        if (m != n - 1) {
            return "No";
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
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
            int u = queue.remove();
            permutation.add(u);
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                if (!permutation.contains(v)) {
                    queue.add(v);
                }
            }
        }
        return permutation.size() == n ? "Yes" : "No";
    }
}
/*
C - Path Graph
https://atcoder.jp/contests/abc287/tasks/abc287_c

拓扑排序
 */