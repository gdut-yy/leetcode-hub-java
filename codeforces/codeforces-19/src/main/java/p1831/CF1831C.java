package p1831;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1831C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] edges = new int[n - 1][2];
            for (int i = 0; i < n - 1; i++) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }
            System.out.println(solve(n, edges));
        }
    }

    private static Map<Integer, List<int[]>> adj;
    private static int[] edge, f;

    // https://codeforces.com/contest/1830/submission/207583108
    private static String solve(int n, int[][] edges) {
        adj = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int x = edges[i][0] - 1, y = edges[i][1] - 1;
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(new int[]{y, i});
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(new int[]{x, i});
        }
        edge = new int[n];
        edge[0] = n;
        f = new int[n];
        dfs(0, -1);
        return String.valueOf(Arrays.stream(f).max().orElseThrow());
    }

    private static void dfs(int x, int fa) {
        for (int[] tuple : adj.getOrDefault(x, new ArrayList<>())) {
            int y = tuple[0], yId = tuple[1];
            if (y == fa) continue;
            edge[y] = yId;
            f[y] = f[x] + (yId < edge[x] ? 1 : 0);
            dfs(y, x);
        }
    }
}
/*
C. Copil Copac Draws Trees
https://codeforces.com/contest/1831/problem/C

题目大意：
Copil 给 Copac 一个 n−1 条边的列表来描述一个 n 个顶点的树。他决定用下面的算法来画:
- 步骤 0:绘制第一个顶点(顶点 1)。执行步骤 1。
- 步骤 1:对于输入中的每条边，按照顺序:如果这条边连接了一个已经画好的顶点 u 和一个没有画好的顶点 v，那么它将把没有画好的顶点 v 和这条边画在一起。检查完所有边后，转步骤 2。
- 步骤 2:如果所有顶点绘制完成，则终止算法。否则，执行步骤 1。
读取次数定义为 Copil Copac 执行步骤 1 的次数。
求 Copil Copac 绘制树所需的读数数。

转换 + DFS
======

input
2
6
4 5
1 3
1 2
3 4
1 6
7
5 6
2 4
2 7
1 3
1 2
4 5
output
2
3
 */
