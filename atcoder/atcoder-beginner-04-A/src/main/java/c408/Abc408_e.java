package c408;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc408_e {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int find(int[] fa, int x) {
        int rt = x;
        while (fa[rt] != rt) rt = fa[rt];
        while (fa[x] != rt) {
            int nx = fa[x];
            fa[x] = rt;
            x = nx;
        }
        return rt;
    }
    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] es = new int[m][3];
        for (int i = 0; i < m; i++) {
            es[i][0] = scanner.nextInt();
            es[i][1] = scanner.nextInt();
            es[i][2] = scanner.nextInt();
        }
        int[] fa = new int[n + 1];
        int ans = 0;
        for (int i = 29; i >= 0; i--) {
            for (int j = 0; j <= n; j++) fa[j] = j;
            int tar = ans >> i;
            for (int[] e : es) {
                if ((e[2] >> i | tar) == tar) {
                    fa[find(fa, e[0])] = find(fa, e[1]);
                }
            }
            if (find(fa, 1) != find(fa, n)) ans |= 1 << i;
        }
        out.println(ans);
    }
}
/*
E - Minimum OR Path
https://atcoder.jp/contests/abc408/tasks/abc408_e

灵茶の试炼 2026-01-20
题目大意：
输入 n(2≤n≤2e5) m(n-1≤m≤2e5)，表示一个 n 点 m 边的无向图。保证图是连通的，无自环。
然后输入 m 条边，每条边输入 x y w(0≤w<2^30)，表示一条边权为 w 的无向边连接 x 和 y。节点编号从 1 到 n。
对于一条从 1 到 n 的简单路径，计算路径所有边权的 OR（按位或）。
输出最小的 OR。

试填法。
从高到低考虑 ans 的第 i 位能不能是 0。
哪些边可以经过？
对于一条边，如果边权二进制中的某一位是 1，而 ans 这一位是 0，那么经过这条边的话，OR 在这一位上是 1，无法满足要求，所以不能经过这条边。
用并查集（或者 DFS）把可以经过的边连起来，如果最终 1 和 n 相连，那么答案第 i 位是 0，否则必须是 1。
代码 https://atcoder.jp/contests/abc408/submissions/72586061
======

Input 1
4 5
1 2 1
1 3 4
2 3 2
2 4 4
3 4 3
Output 1
3

Input 2
3 5
1 2 1
1 2 2
1 2 3
1 2 4
2 3 4
Output 2
4

Input 3
8 12
4 5 16691344
5 7 129642441
2 7 789275447
3 8 335307651
3 5 530163333
5 6 811293773
3 8 333712701
1 2 2909941
2 3 160265478
5 7 465414272
1 3 903373004
6 7 408299562
Output 3
468549631
 */
