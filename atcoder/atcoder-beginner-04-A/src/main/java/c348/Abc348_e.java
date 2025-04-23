package c348;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Abc348_e {
    static int n;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static long ans;
    static long[] sum;

    private static String solve() {
        ans = 0;
        sum = new long[n];

        dfs(0, -1, 0);
        reroot(0, -1, ans);
        return String.valueOf(ans);
    }

    static void dfs(int x, int fa, int depth) {
        ans += (long) depth * a[x];
        sum[x] = a[x];
        for (Integer y : g[x]) {
            if (y != fa) {
                dfs(y, x, depth + 1);
                sum[x] += sum[y];
            }
        }
    }

    static void reroot(int x, int fa, long res) {
        ans = Math.min(ans, res);
        for (Integer y : g[x]) {
            if (y != fa) {
                reroot(y, x, res + sum[0] - sum[y] * 2);
            }
        }
    }
}
/*
E - Minimize Sum of Distances
https://atcoder.jp/contests/abc348/tasks/abc348_e

灵茶の试炼 2025-02-26
题目大意：
输入 n(1≤n≤1e5)。
输入一棵无向树的 n-1 条边，边权为 1，节点编号从 1 到 n。
输入长为 n 的数组 a(1≤a[i]≤1e9)。
定义 f(x) = sum(dist(x, i) * a[i] for i in [1, n])，其中 dist(x, i) 表示 x 到 i 的最短路长度。
输出 f(1),f(2),...,f(n) 中的最小值。

换根 DP。
做法同 834. 树中距离之和 834. 树中距离之和，把代码中的子树大小改成子树点权和。
代码 https://atcoder.jp/contests/abc348/submissions/62942731
======

Input 1
4
1 2
1 3
2 4
1 1 1 2
Output 1
5

Input 2
2
2 1
1 1000000000
Output 2
1

Input 3
7
7 3
2 5
2 4
3 1
3 6
2 1
2 7 6 9 3 4 6
Output 3
56
 */
