package p715;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF715B {
    static int n, m, L, s, t;
    static int[][] edges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        L = scanner.nextInt();
        s = scanner.nextInt();
        t = scanner.nextInt();

        edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 2e9;
    // 权重被删除
    private static final int ERASED = 0;
    private static Map<Integer, List<int[]>> adj;
    private static int[][] dist;
    private static int delta;

    private static String solve() {
        adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = edges[i][0], y = edges[i][1], wt = edges[i][2];
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(new int[]{y, i});
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(new int[]{x, i});
        }
        // 跑两轮最短路
        dist = new int[2][n];

        // 第 1 轮：-1 置 1
        dijkstra_n2(s, 0);
        delta = L - dist[0][t];
        if (delta < 0) {
            return "NO";
        }
        // 第 2 轮：修改 edges
        dijkstra_n2(s, 1);
        // 最短路无法再变大，无法达到 target
        if (dist[1][t] < L) {
            return "NO";
        }

        // 没修改的 -1 全部置 1
        for (int[] edge : edges) {
            if (edge[2] == ERASED) {
                edge[2] = 1;
            }
        }

        return "YES" + System.lineSeparator()
                + Arrays.stream(edges)
                .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    // 暴力 O(n^2)
    private static void dijkstra_n2(int source, int k) {
        Arrays.fill(dist[k], INF);
        dist[k][source] = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = 0, mind = INF;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && dist[k][j] < mind) {
                    x = j;
                    mind = dist[k][x];
                }
            }
            vis[x] = true;
            for (int[] tuple : adj.getOrDefault(x, new ArrayList<>())) {
                int y = tuple[0], edgeId = tuple[1];
                int wt = edges[edgeId][2];
                // -1 改成 1
                if (wt == ERASED) {
                    wt = 1;
                }
                // 第 2 轮 改成 w
                if (k == 1 && edges[edgeId][2] == ERASED) {
                    int w = delta + dist[0][y] - dist[1][x];
                    if (wt < w) {
                        wt = w;
                        // 直接在 edges 上修改
                        edges[edgeId][2] = w;
                    }
                }
                // 更新最短路
                if (dist[k][y] > dist[k][x] + wt) {
                    dist[k][y] = dist[k][x] + wt;
                }
            }
        }
    }
}
/*
B. Complete The Graph
https://codeforces.com/contest/715/problem/B

题目大意：
编码器 ZS 绘制了一个无向图，有 n 个顶点，编号从 0 到 n - 1，它们之间有 m 条边。图的每条边都有权重，每个权重都是正整数。
第二天，程序员 ZS 意识到一些权重被删除了!所以他想给每条边重新赋正整数权值这些边的权值被抹去了，这样结果图中顶点 s 和 t 之间的最短路径的长度就是 l，你能帮他吗?

rating 2300
相似题目: 2699. 修改图中的边权
https://leetcode.cn/problems/modify-graph-edge-weights/
======

input
5 5 13 0 4
0 1 5
2 1 2
3 2 3
1 4 0
4 3 4
output
YES
0 1 5
2 1 2
3 2 3
1 4 8
4 3 4

input
2 1 123456789 0 1
0 1 0
output
YES
0 1 123456789

input
2 1 999999999 1 0
0 1 1000000000
output
NO
 */
