package p1675;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class CF1675D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] p = new int[n];
            for (int j = 0; j < n; j++) {
                p[j] = scanner.nextInt();
            }

            List<String> res = solve(n, p);
            System.out.println(res.size() / 2);
            for (String re : res) {
                System.out.println(re);
            }
            System.out.println();
        }
    }

    private static Map<Integer, List<Integer>> adj;
    private static boolean[] visited;

    private static List<String> solve(int n, int[] p) {
        // 建图
        int root = -1;
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int u = p[i];
            int v = i + 1;
            if (u != v) {
                // the minimum amount of non-intersecting leading down paths that can cover all vertices of the tree.
                adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
//                adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
            } else {
                root = u;
            }
        }

        List<String> resList = new ArrayList<>();
        visited = new boolean[n + 1];

        // bfs
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                if (!visited[cur]) {
                    visited[cur] = true;
                    List<String> listI = new ArrayList<>();
                    listI.add(String.valueOf(cur));
                    dfs(listI, cur);
                    resList.add(String.valueOf(listI.size()));
                    resList.add(String.join(" ", listI));
                }
                queue.addAll(adj.getOrDefault(cur, new ArrayList<>()));
            }
        }
        return resList;
    }

    private static void dfs(List<String> list, int node) {
        for (int next : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited[next]) {
                visited[next] = true;
                list.add(String.valueOf(next));
                dfs(list, next);
                break;
            }
        }
    }
}
/*
D. Vertical Paths
https://codeforces.com/contest/1675/problem/D

题目大意：
给定长度为 n 的数组 p，表示一棵有 n 个顶点的根树。顶点的编号从 1 到 n。其中 pi 是 i 的父节点。
输出一个整数 m —— 可以覆盖树的所有顶点的不相交的向下路径的最小数量。

BFS + DFS。虽然树是无向无环图，但是本题要求向下路径，因此实际上可以当成有向图处理。
DFS 输出最长路径，BFS 按层序往下遍历即可。
======

intput
6
5
3 1 3 3 1
4
1 1 4 1
7
1 1 2 3 4 5 6
1
1
6
4 4 4 4 1 2
4
2 2 2 2

output
3
3
3 1 5
1
2
1
4

2
2
1 2
2
4 3

1
7
1 2 3 4 5 6 7

1
1
1

3
3
4 1 5
2
2 6
1
3

3
2
2 1
1
3
1
4
 */