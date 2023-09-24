package c270;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Abc270_f {
    static int n, m;
    static int[][] e1, e2, e3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        e1 = new int[n][3];
        for (int i = 0; i < n; i++) {
            e1[i][0] = i + 1;
            e1[i][1] = n + 1;
            e1[i][2] = scanner.nextInt();
        }
        e2 = new int[n][3];
        for (int i = 0; i < n; i++) {
            e2[i][0] = i + 1;
            e2[i][1] = n + 2;
            e2[i][2] = scanner.nextInt();
        }
        e3 = new int[m][3];
        for (int i = 0; i < m; i++) {
            e3[i][0] = scanner.nextInt();
            e3[i][1] = scanner.nextInt();
            e3[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static long ans;

    private static String solve() {
        ans = (long) 1e18;

        f(n, e3);
        f(n + 2, e3, e1);
        f(n + 2, e3, e2);
        f(n + 2, e3, e1, e2);
        return String.valueOf(ans);
    }

    private static void f(int n, int[][]... var) {
        List<int[]> edges = new ArrayList<>();
        for (int[][] e : var) {
            Collections.addAll(edges, e);
        }

        edges.sort(Comparator.comparingInt(o -> o[2]));
        DSU dsu = new DSU(n + 1);

        long sum = 0, cntE = 0;
        for (int[] e : edges) {
            int fv = dsu.find(e[0]);
            int fw = dsu.find(e[1]);
            if (fv != fw) {
                dsu.fa[fv] = fw;
                sum += e[2];
                cntE++;
            }
        }

        if (edges.size() == m && cntE < n - 1) {
            return;
        }
        ans = Math.min(ans, sum);
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }
    }
}
/*
F - Transportation
https://atcoder.jp/contests/abc270/tasks/abc270_f

灵茶の试炼 2022-12-27
题目大意：
输入 n m (≤2e5)。有 n 个岛屿。
输入 n 个数，表示在第 i 个岛屿上修建机场的花费(≤1e9)。如果两个岛都有机场，则可以互相到达。
输入 n 个数，表示在第 i 个岛屿上修建港口的花费(≤1e9)。如果两个岛都有港口，则可以互相到达。
输入 m 条边，每条边输入 a b z 表示在岛屿 a 和 b 造桥的花费为 z(≤1e9)。
输出使得任意两个岛可以互相到达的最小花费。

https://atcoder.jp/contests/abc270/submissions/37572585
提示 1：如果一定要用上机场和港口的话，可以创建两个超级源点，建机场/港口就往超级源点连边。
提示 2：枚举是否要用上机场/港口，总共 4 种情况。
提示 3：最小生成树。
======

Input 1
4 2
1 20 4 7
20 2 20 3
1 3 5
1 4 6
Output 1
16

Input 2
3 1
1 1 1
10 10 10
1 2 100
Output 2
3

Input 3
7 8
35 29 36 88 58 15 25
99 7 49 61 67 4 57
2 3 3
2 5 36
2 6 89
1 6 24
5 7 55
1 3 71
3 4 94
5 6 21
Output 3
160
 */