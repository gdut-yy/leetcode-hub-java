package p1404;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1404B {
    private static int n, a, b, da, db;
    private static int[][] edges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            da = scanner.nextInt();
            db = scanner.nextInt();
            edges = new int[n - 1][2];
            for (int i = 0; i < n - 1; i++) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static Map<Integer, List<Integer>> adj;
    private static int dab, u, maxD;

    private static String solve() {
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        // Bob 在 Alice 的覆盖范围内
        if (da * 2 >= db) {
            return "Alice";
        }

        maxD = -1;
        f(a, 0, 0);
        // Alice 一步到达 Bob
        if (da >= dab) {
            return "Alice";
        }

        maxD = -1;
        f(u, 0, 0);
        // Alice 可以覆盖整棵树
        if (da * 2 >= maxD) {
            return "Alice";
        }
        return "Bob";
    }

    private static void f(int x, int fa, int d) {
        if (x == b) {
            dab = d;
        }
        if (d > maxD) {
            maxD = d;
            u = x;
        }
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y != fa) {
                f(y, x, d + 1);
            }
        }
    }
}
/*
B. Tree Tag
https://codeforces.com/contest/1404/problem/B

灵茶の试炼 2023-04-20
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(2≤n≤1e5) 表示一棵 n 个节点的树（节点编号从 1 开始）。
然后输入树上两个不同的点 a 和点 b，表示 Alice 和 Bob 的位置。
然后输入 da db，范围在 [1,n-1]。表示 Alice 和 Bob 每次传送的最大距离。例如从 x 传送到 y，那么 x 到 y 的简单路径的边数不能超过最大距离。
然后输入这棵树的 n-1 条边。
Alice 和 Bob 轮流在树上传送（可以原地不动），Alice 先手。
Bob 逃，Alice 追。
如果在有限步内 Alice 和 Bob 能在同一个点，输出 Alice，否则输出 Bob。
注意从 x 传送到 y，并不会经过从 x 到 y 的简单路径的中间节点。

rating 1900
https://codeforces.com/contest/1404/submission/202566203
分类讨论：
如果 2*da >= db，那么 Alice 每次向 Bob 移动一步，必然可以在某个时刻让 Bob 无路可走。
如果 Alice 到 Bob 的距离 <= da，那么 Alice 第一步就可以和 Bob 相遇。
如果 2*da >= 树的直径，那么 Alice 只要走到树的直径的中点，就可以传送到树的任意位置，也就可以和 Bob 相遇了。
其余情况，Bob 总是可以「跨过」Alice。
Bob 可以选择留在原地，只要 Alice 覆盖到了 Bob，就立刻跳出 Alice 的覆盖范围。
注：树的直径可以用 DP，也可以用两次 DFS。
======

input
4
4 3 2 1 2
1 2
1 3
1 4
6 6 1 2 5
1 2
6 5
2 3
3 4
4 5
9 3 9 2 5
1 2
1 6
1 9
1 3
9 5
7 9
4 8
4 3
11 8 11 3 3
1 2
11 9
4 9
6 5
2 10
3 2
5 9
8 3
7 4
7 10
output
Alice
Bob
Alice
Alice
 */
