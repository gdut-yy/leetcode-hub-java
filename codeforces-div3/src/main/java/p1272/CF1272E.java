package p1272;

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

public class CF1272E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        int[] d = new int[n];

        // 奇偶队列
        List<Queue<Integer>> queues = new ArrayList<>();
        queues.add(new LinkedList<>());
        queues.add(new LinkedList<>());

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int p = a[i] & 1, v1 = i - a[i], v2 = i + a[i];
            if ((v1 >= 0 && (a[v1] & 1) != p) || (v2 < n && (a[v2] & 1) != p)) {
                queues.get(p).add(i);
                d[i] = 1;
            } else {
                d[i] = -1;
            }

            // 建图 反图
            if (v1 >= 0 && (a[v1] & 1) == p) {
                adj.computeIfAbsent(v1, key -> new ArrayList<>()).add(i);
            }
            if (v2 < n && (a[v2] & 1) == p) {
                adj.computeIfAbsent(v2, key -> new ArrayList<>()).add(i);
            }
        }

        for (Queue<Integer> queue : queues) {
            while (!queue.isEmpty()) {
                int u = queue.remove();
                for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                    if (d[v] < 0) {
                        d[v] = d[u] + 1;
                        queue.add(v);
                    }
                }
            }
        }

        return Arrays.stream(d).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E. Nearest Opposite Parity
https://codeforces.com/contest/1272/problem/E

灵茶の试炼 2023-02-17
题目大意：
从位置 i，你可以移动到位置 i - a[i] 或 i + a[i]，下标从 1 开始
定义 d[i] 表示从 i 出发，移动到某个位置 j 的最小移动次数，要求 a[i] 和 a[j] 的奇偶性不同，如果不存在则 d[i] = -1
返回 d[1], d[2], ..., d[n]

图论 BFS。注意奇偶队列添加元素技巧。
https://codeforces.com/contest/1272/submission/193830507
提示 1：从起点出发不好计算的话，试试从终点出发反着走。
提示 2：以偶数为例，定义终点为能直接到达奇数的位置。
从终点出发，在反图上 BFS。
反图怎么建？如果存在 v->w 的边，则建一条 w->v 的边。
偶数奇数各跑一次 BFS。
======

input
10
4 5 7 6 7 5 4 4 6 4
output
1 1 1 2 -1 1 1 3 1 1
 */
