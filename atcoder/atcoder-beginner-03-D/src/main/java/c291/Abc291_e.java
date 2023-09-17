package c291;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc291_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] xys = new int[m][2];
        for (int i = 0; i < m; i++) {
            xys[i][0] = scanner.nextInt();
            xys[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, xys));
    }

    private static String solve(int n, int[][] xys) {
        // 建图
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] deg = new int[n];
        for (int[] xy : xys) {
            int u = xy[0] - 1, v = xy[1] - 1;
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            deg[v]++;
        }

        // 拓扑序需要唯一
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.size() != 1) {
            return "No";
        }
        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int sz = queue.size();
            int u = queue.remove();
            topo.add(u);
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                deg[v]--;
                if (deg[v] == 0) {
                    queue.add(v);
                }
            }
            // 删一个只能加一个
            if (queue.size() > sz) {
                return "No";
            }
        }
        if (topo.size() != n) {
            return "No";
        }

        int x = 1;
        int[] ans = new int[n];
        for (int id : topo) {
            ans[id] = x++;
        }
        return "Yes" + System.lineSeparator()
                + Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E - Find Permutation
https://atcoder.jp/contests/abc291/tasks/abc291_e

题目大意：
存在一个长度为 N 的序列 a = (a1,...,aN)，它是 1,...,N 的排列。
虽然你不知道 A，但你知道对于 M 对整数(xi, yi)， Axi < Ayi。
A 可以唯一确定吗？如果可能，找到 A。

唯一拓扑序。
======

Input 1
3 2
3 1
2 3
Output 1
Yes
3 1 2

Input 2
3 2
3 1
3 2
Output 2
No

Input 3
4 6
1 2
1 2
2 3
2 3
3 4
3 4
Output 3
Yes
1 2 3 4
 */