package p1693;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1693C {
    static int n, m;
    static int[][] edges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;

    private static String solve() {
        Map<Integer, List<Integer>> rg = new HashMap<>();
        int[] deg = new int[n + 1];
        for (int[] p : edges) {
            int v = p[0], w = p[1];
            rg.computeIfAbsent(w, key -> new ArrayList<>()).add(v);
            deg[v]++;
        }
        int[] dist = new int[n + 1];
        for (int i = 1; i < n; i++) {
            dist[i] = INF;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        minHeap.add(new int[]{n, 0});
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.remove();
            int w = top[0], dis = top[1];
            if (dis > dist[w]) {
                continue;
            }
            for (Integer v : rg.getOrDefault(w, new ArrayList<>())) {
                int newD = dis + deg[v];
                if (dist[v] > newD) {
                    dist[v] = newD;
                    minHeap.add(new int[]{v, newD});
                }
                deg[v]--;
            }
        }
        return String.valueOf(dist[1]);
    }
}
/*
C. Keshi in Search of AmShZ
https://codeforces.com/contest/1693/problem/C

灵茶の试炼 2023-05-26
题目大意：
输入 n(2≤n≤1e5) m(1≤m≤2e5) 表示一个 n 点 m 边的有向图（节点编号从 1 开始）。
然后输入 m 条边。没有自环，可能有重边。
你初始在 1，要到达 n。（输入保证可以从 1 到 n。）
每次操作，要么永久删除一条边，要么从当前点随机移动到一个邻居上。
最小化最大操作次数。

https://codeforces.com/contest/1693/submission/207136188
根据题意，从某个点移动时，我们实际上是走的一条「最差」的边，使得花费最多的操作次数到达终点。
注意在描述这个性质时，是用「到终点的操作次数」来描述的，因此以终点为主体来思考。
设从 i 到 n 的最短路长度为 dis[i]。
---
性质 1：对于一个点 v，假设它有邻居 w1,w2,w3，且 dis[w1] <= dis[w2] <= dis[w3]，那么删边时，肯定是优先删除最大的 v-w3 这条边。
性质 2：如果删除的多，那么总的操作次数也多。如果删除的少，那么走最差的边，总的操作次数也多。
那么干脆枚举删除了多少条边。
难道每次枚举都要重新计算吗？
---
设原图为 g，反图为 rg。
设原图上的点 i 的出度为 deg[i]。
借鉴 Dijkstra，在 rg 上，从 n 出发去计算最短路。
在 rg 上从 w1 到达 v 时（首次访问 v），那就相当于在 g 上的 v 删除了 deg[i]-1 条边，然后走剩下的那条边到达 w1。
在 rg 上从 w2 到达 v 时（第二次访问 v），那就相当于在 g 上的 v 删除了 deg[i]-2 条边，然后走剩下的花费时间最多的那条边到达 w2。
为什么这里只需要删除 deg[i]-2 条边呢？因为按照 Dijkstra 算法，在 rg 上从 w2 到达 v，那么走的这条边在 g 上一定是从 v 出发的所有边中第二短的（最短的之前枚举过了），所以只需要删除 deg[i]-2 条边。
======

input
2 1
1 2
output
1

input
4 4
1 2
1 4
2 4
1 4
output
2

input
5 7
1 2
2 3
3 5
1 4
4 3
4 5
3 1
output
4
 */

