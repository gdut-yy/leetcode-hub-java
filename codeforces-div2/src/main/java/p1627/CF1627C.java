package p1627;

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

public class CF1627C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] uv = new int[n - 1][2];
            for (int j = 0; j < n - 1; j++) {
                uv[j][0] = scanner.nextInt();
                uv[j][1] = scanner.nextInt();
            }
            System.out.println(solve(n, uv));
        }
    }

    private static String solve(int n, int[][] uv) {
        // 无向图
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        for (int[] tuple : uv) {
            int u = tuple[0];
            int v = tuple[1];
            adj.computeIfAbsent(u, key -> new HashMap<>()).put(v, -1);
            adj.computeIfAbsent(v, key -> new HashMap<>()).put(u, -1);
        }

        // 不存在三个质数，任意两个之和也是质数
        for (int i = 1; i <= n; i++) {
            if (adj.getOrDefault(i, new HashMap<>()).size() > 2) {
                return "-1";
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        // 设 (u,v) 权重为 2
        int u0 = uv[0][0];
        int v0 = uv[0][1];
        adj.get(u0).put(v0, 2);
        adj.get(v0).put(u0, 2);
        queue.add(u0);
        queue.add(v0);
        visited.add(u0);
        visited.add(v0);
        boolean is2 = true;
        while (!queue.isEmpty()) {
            is2 = !is2;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                for (int next : adj.get(cur).keySet()) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        adj.get(cur).put(next, is2 ? 2 : 3);
                        adj.get(next).put(cur, is2 ? 2 : 3);
                        queue.add(next);
                    }
                }
            }
        }

        List<String> resList = new ArrayList<>();
        for (int[] tuple : uv) {
            int u = tuple[0];
            int v = tuple[1];
            resList.add(String.valueOf(adj.get(u).get(v)));
        }
        return String.join(" ", resList);
    }
}
/*
C. Not Assigning
https://codeforces.com/contest/1627/problem/C

题目大意：
给出整数 n 和 n-1 对整数，分别代表 n 个顶点和 n-1 条边，要求生成一颗 质数树，每条由一条或两条边组成的路径的权值都是质数。求按序输出 n-1 条边的权重。

可以证明：不存在三个质数，任意两个之和也是质数：除 2 外质数都是 奇数，不存在两个奇数的和也是奇数。
生成图后，按序填充 2,3 即可（其他组合也可以）
======

input
3
2
1 2
4
1 3
4 3
2 1
7
1 2
1 3
3 4
3 5
6 2
7 2


input2
1
10
9 2
5 1
3 5
10 2
3 4
6 4
8 7
8 1
6 9
 */