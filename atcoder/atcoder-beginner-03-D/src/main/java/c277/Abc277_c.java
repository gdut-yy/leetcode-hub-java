package c277;

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

public class Abc277_c {
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

    private static String solve(int n, int[][] ab) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : ab) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        int ans = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                ans = Math.max(ans, x);

                for (int y : adj.getOrDefault(x, new ArrayList<>())) {
                    if (!visited.contains(y)) {
                        visited.add(y);
                        queue.add(y);
                    }
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
C - Ladder Takahashi
https://atcoder.jp/contests/abc277/tasks/abc277_c

题目大意：
有一座 10^9 层楼的建筑，有 N 个梯子。
高桥在 1 楼(最低)，他想用梯子(可能没有梯子)爬到最高的楼层。
梯子编号从 1 到 N，梯子 i 连接 A 层和 B 层。人们可以使用梯子 i 在任何方向从 Ai 层移动到 Bi 层，反之亦然，但不能在其他楼层之间移动。
高桥可以在同一楼层内自由移动，但不使用梯子就不能在楼层之间移动。
高桥能到达的最高楼层是几楼?

BFS。
======

Input 1
4
1 4
4 3
4 10
8 3
Output 1
10

Input 2
6
1 3
1 5
1 12
3 5
3 12
5 12
Output 2
12

Input 3
3
500000000 600000000
600000000 700000000
700000000 800000000
Output 3
1
 */