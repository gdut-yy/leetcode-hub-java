package c309;

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

public class Abc309_d {
    static int n1, n2, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n1 = scanner.nextInt();
        n2 = scanner.nextInt();
        m = scanner.nextInt();

        adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
        }
        System.out.println(solve());
    }

    static Map<Integer, List<Integer>> adj;

    private static String solve() {
        int d1 = bfs(1);
        int d2 = bfs(n1 + n2);
        return String.valueOf(d1 + d2 + 1);
    }

    private static int bfs(int begin) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(begin);
        Set<Integer> vis = new HashSet<>();
        vis.add(begin);

        int dist = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.remove();

                for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
                    if (!vis.contains(y)) {
                        vis.add(y);
                        queue.add(y);
                    }
                }
            }
            dist++;
        }
        return dist;
    }
}
/*
D - Add One Edge
https://atcoder.jp/contests/abc309/tasks/abc309_d

题目大意：
我们有一个无向图，有(n1 + n2)个顶点和 M 条边。对于 i=1,2,...,M，第 i 条边连接顶点 ai 和顶点 bi。
保证以下属性:
- 顶点 u 和顶点 v 是连通的，对于 1≤u,v≤n1 的所有整数 u 和 v。
- 顶点 u 和顶点 v 是连通的，对于 N1+1≤u,v≤N1+N2 的所有整数 u 和 v。
- 顶点 1 和顶点(N1 + N2)是断开的。
请考虑只执行一次以下操作:
- 选择一个 1≤u≤n1 的整数 u 和一个 n1+1≤v≤n1+n2 的整数 v，添加一条连接顶点 u 和顶点 v 的边。
我们可以证明顶点 1 和顶点(n1 + n2)在结果图中总是连通的;设 d 为顶点 1 和顶点(n1 + n2)之间路径的最小长度(边数)
找出添加一条合适的边所产生的最大可能的 d 值。

贪心 + bfs
======

Input 1
3 4 6
1 2
2 3
4 5
4 6
1 3
6 7
Output 1
5

Input 2
7 5 20
10 11
4 5
10 12
1 2
1 5
5 6
2 4
3 5
9 10
2 5
1 4
11 12
9 12
8 9
5 7
3 7
3 6
3 4
8 12
9 11
Output 2
4
 */