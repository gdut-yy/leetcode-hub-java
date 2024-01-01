package p1106;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1106D {
    static int n, m;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(solve());
    }

    private static String solve() {
        PriorityQueue<Integer> h = new PriorityQueue<>();
        h.add(1);
        boolean[] vis = new boolean[n + 1];
        vis[1] = true;
        List<Integer> ans = new ArrayList<>();
        while (!h.isEmpty()) {
            int v = h.remove();
            ans.add(v);

            for (Integer w : g[v]) {
                if (!vis[w]) {
                    vis[w] = true;
                    h.add(w);
                }
            }
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Lunar New Year and a Wander
https://codeforces.com/contest/1106/problem/D

灵茶の试炼 2023-11-07
题目大意：
输入 n m(1≤n,m≤1e5) 和一个无向图的 m 条边。节点编号从 1 开始。
你从 1 出发，沿着边在图上行走，每遇到一个之前没有访问过的点，就把这个点的编号记录下来。你可以重复访问节点。
这个过程直到你记录了 n 个节点编号时停止。
输出这 n 个数的最小字典序。

用最小堆模拟。
一开始把 1 入堆，然后每次循环把最小节点 x 出堆，并把 x 的邻居入堆。
用一个 vis 数组避免重复访问。
注：这个过程有点像 Dijkstra。
https://codeforces.com/contest/1106/submission/231063593
======

input
3 2
1 2
1 3
output
1 2 3

input
5 5
1 4
3 4
5 4
3 2
1 5
output
1 4 3 2 5

input
10 10
1 4
6 8
2 5
3 7
9 4
5 6
3 4
8 10
8 9
1 10
output
1 4 3 7 9 8 6 5 2 10
 */
