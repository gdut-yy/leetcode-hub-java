package c282;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc282_d {
    static Map<Integer, List<Integer>> adj;
    static int[] colors;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        adj = new HashMap<>();
        colors = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }

        long ans = N * (N - 1L) / 2 - M;
        for (int i = 1; i <= N; i++) {
            if (colors[i] == 0) {
                // 1:蓝色 -1:红色
                int[] res = dfs(i, -1, 1);
                if (res[0] == -1) {
                    System.out.println(0);
                    return;
                }
                ans -= res[0] * (res[0] - 1L) / 2;
                ans -= res[1] * (res[1] - 1L) / 2;
            }
        }
        System.out.println(ans);
    }

    // 蓝色 红色
    private static int[] dfs(int u, int fa, int color) {
        int[] ret = new int[]{0, 0};
        colors[u] = color;

        if (color == 1) {
            ret[0]++;
        } else {
            ret[1]++;
        }

        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (v == fa || colors[v] == -color) {
                continue;
            }
            if (colors[v] == color) {
                return new int[]{-1, -1};
            }
            int[] res = dfs(v, u, -color);
            if (res[0] == -1) {
                return new int[]{-1, -1};
            }
            ret[0] += res[0];
            ret[1] += res[1];
        }
        return ret;
    }
}
/*
D - Make Bipartite 2
https://atcoder.jp/contests/abc282/tasks/abc282_d

二分图染色
 */