package c138;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc138_d {
    static int n, q;
//    static int[][] ab, px;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        q = scanner.nextInt();
//        ab = new int[n - 1][2];
//        for (int i = 0; i < n - 1; i++) {
//            ab[i][0] = scanner.nextInt();
//            ab[i][1] = scanner.nextInt();
//        }
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }
//        px = new int[q][2];
//        for (int i = 0; i < q; i++) {
//            px[i][0] = scanner.nextInt();
//            px[i][1] = scanner.nextInt();
//        }
        a = new int[n];
        for (int i = 0; i < q; i++) {
            int p = scanner.nextInt() - 1;
            int x = scanner.nextInt();
            a[p] += x;
        }
        System.out.println(solve());
    }

    static List<Integer>[] g;
    static int[] a;

    private static String solve() {
        dfs(0, -1);
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static void dfs(int x, int fa) {
        for (Integer y : g[x]) {
            if (y != fa) {
                a[y] += a[x];
                dfs(y, x);
            }
        }
    }
}
/*
D - Ki
https://atcoder.jp/contests/abc138/tasks/abc138_d

灵茶の试炼 2023-09-25
题目大意：
输入 n(2≤n≤2e5) q(1≤q≤2e5) 表示一个 n 个点的树（节点编号从 1 开始，根节点为 1）。
然后输入 n-1 条边（每行两个数）。
然后输入 q 个操作，每个操作输入 p(1≤p≤n) x(1≤x≤1e4)，表示把子树 p 内的所有节点值都加 x。（一开始所有节点值均为 0）
输出最终每个节点的节点值。（按节点编号从小到大输出）

只需要记录节点 p 的节点值增加了多少。
然后从 1 开始 DFS 这棵树，DFS 的同时累加从 1 到当前节点 x 的这条路径上的节点值之和，即为节点 x 的最终节点值。
（类似 lazy 线段树的懒标记下传 push down）
https://atcoder.jp/contests/abc138/submissions/45500929
======

Input 1
4 3
1 2
2 3
2 4
2 10
1 100
3 1
Output 1
100 110 111 110

Input 2
6 2
1 2
1 3
2 4
3 6
2 5
1 10
1 10
Output 2
20 20 20 20 20 20
 */