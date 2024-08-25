package p295;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF295B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = scanner.nextInt();
            }
        }
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        System.out.println(solve(n, adj, x));
    }

    private static String solve(int n, int[][] adj, int[] x) {
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            ans[i] = x[i] - 1;
        }

        boolean[] vis = new boolean[n];
        for (int q = n - 1; q >= 0; q--) {
            int k = (int) ans[q];
            vis[k] = true;
            ans[q] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    if (vis[i] && vis[j]) {
                        ans[q] += adj[i][j];
                    }
                }
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Greg and Graph
https://codeforces.com/contest/295/problem/B

灵茶の试炼 2023-04-26
题目大意：
输入 n(1≤n≤500) 表示 n 个点的有向完全图，然后输入 n*n 的邻接矩阵 a，其中 a[i][j] 表示 i 到 j 的边权，范围 [1,1e5]（特例是 a[i][i]=0）。
图的节点编号从 1 开始。
然后输入 1~n 的排列，表示我要一个个地删除图上的点，每删除一个点，这个点的出边和入边都会被删除。
输出 n 个数，第 i 个数表示第 i 次删除之前，所有剩余点对的最短路之和。

rating 1700
https://codeforces.com/contest/295/submission/202933808
倒着加点。
每次添加点 k 后，跑只与 k 有关的 Floyd。
也就是对所有点对更新 d[i][j] = min(d[i][j], d[i][k]+d[k][j])
（相当于输入的这个排列规定了 Floyd 最外层的循环顺序。）
相似题目: 2642. 设计可以求最短路径的图类
https://leetcode.cn/problems/design-graph-with-shortest-path-calculator/
======

input
1
0
1
output
0

input
2
0 5
4 0
1 2
output
9 0

input
4
0 3 1 1
6 0 400 1
2 4 0 1
1 1 1 0
4 1 2 3
output
17 23 404 0
 */
