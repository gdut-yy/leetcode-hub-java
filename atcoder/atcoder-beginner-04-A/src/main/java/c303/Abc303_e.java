package c303;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc303_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, edges));
    }

    private static String solve(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] deg = new int[n];
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
            deg[x]++;
            deg[y]++;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            // 随便找一个叶子
            if (deg[i] == 1) {
                // 与叶子相连的点必然为 星型顶点
                Integer x = adj.get(i).get(0);
                vis[x] = true;
                queue.add(new int[]{x, 0});
                break;
            }
        }
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int x = tuple[0], dis = tuple[1];
                dist[x] = dis;

                for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
                    if (!vis[y]) {
                        vis[y] = true;
                        queue.add(new int[]{y, dis + 1});
                    }
                }
            }
        }

        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dist[i] % 3 == 0) {
                resList.add(deg[i]);
            }
        }
        return resList.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E - A Gift From the Stars
https://atcoder.jp/contests/abc303/tasks/abc303_e

题目大意：
具有(k+1)个顶点和 k 条边的图称为- k (k≥2)星，当且仅当:
- 它有一个顶点与其他 k 个顶点相连，每个顶点都有一条边，没有其他边。
起初，高桥有一个由星星组成的图表。他重复以下操作，直到图中的每对顶点都连通:
- 在图中选择两个顶点。这里，顶点必须是不相连的，它们的度数必须都是 1。添加一条连接所选两个顶点的边。
然后，他给图中的每个顶点随机分配一个从 1 到 N 的整数。得到的图是一个树;我们称它为 T, T 有(N−1)条边，第 i 条边连接 ui 和 vi。
高桥现在已经忘记了他最初拥有的星星的数量和级别。给定 T，求出它们。
---
假设 Takahashi 最初有 M 颗星，其级别为 L=(l1, l2,..., lm)。将 L 按升序排序，并打印它们，中间有空格。我们可以证明这个问题的解是唯一的。

T 的叶节点是初始恒星的叶节点，距离 T 不超过 2 的顶点属于同一颗恒星。因此，下面的算法是可能的。
- 选择 T 的一个叶。
- 计算距离它(包括它自己)不超过 2 的顶点数。如果它们有 x 个，它们就形成一个能级 (x−1) 星。
- 从 T 中移除被计数的顶点和相邻边。
重复这个过程，直到 T 中没有任何顶点，你就得到了答案。通过适当的实现，它总共只需要 O(N) 时间，但是实现有点复杂。我们通过一些观察来描述一个更简单的实现。
下面的引理成立。
- 在原始星型中，我们称非叶顶点为中心。在 T 中，中心之间的距离总是 3 的倍数，中心和叶结点之间的距离总是非 3 的倍数。
这可以用归纳法来证明。根据这个引理，我们可以得出以下算法:
- 从 T 中选择一个原星形中心的顶点。您可以通过选择与叶节点相邻的顶点来实现。
- 求每个顶点到所选顶点的最短距离。
- 对于每个最短距离是 3 的倍数的顶点，将该顶点的度数加到 L 上。
该算法总共工作 O(N)次，并且需要像 BFS(广度优先搜索) 或 DFS(深度优先搜索) 这样的简单算法。
======

Input 1
6
1 2
2 3
3 4
4 5
5 6
Output 1
2 2

Input 2
9
3 9
7 8
8 6
4 6
4 1
5 9
7 3
5 2
Output 2
2 2 2

Input 3
20
8 3
8 18
2 19
8 20
9 17
19 7
8 7
14 12
2 15
14 10
2 13
2 16
2 1
9 5
10 15
14 6
2 4
2 11
5 12
Output 3
2 3 4 7
 */