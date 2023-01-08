package c284;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc284_e {
    private static Map<Integer, List<Integer>> adj;
    private static boolean[] visited;
    private static int res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        adj = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }

        res = 0;
        visited = new boolean[N];
        dfs(0);
        System.out.println(res);
    }

    private static final int E6 = (int) 1e6;

    private static void dfs(int u) {
        if (res == E6) {
            return;
        }
        res++;
        visited[u] = true;
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (!visited[v]) {
                dfs(v);
            }
        }
        visited[u] = false;
    }
}
/*
E - Count Simple Paths
https://atcoder.jp/contests/abc284/tasks/abc284_e

dfs 计数
 */