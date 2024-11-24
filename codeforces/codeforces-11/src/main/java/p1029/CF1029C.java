package p1029;

import java.util.Scanner;

public class CF1029C {
    static int n;
    static int[][] a; // l, r

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int INF = (int) 1e9;

    private static String solve() {
        int[][] suf = new int[n + 1][2]; // l, r
        suf[n][1] = INF;
        for (int i = n - 1; i > 0; i--) {
            suf[i] = merge(suf[i + 1], a[i]);
        }

        int ans = 0;
        int[] pre = {0, INF};
        for (int i = 0; i < n; i++) {
            int[] m = merge(pre, suf[i + 1]);
            ans = Math.max(ans, m[1] - m[0]);
            pre = merge(pre, a[i]);
        }
        return String.valueOf(ans);
    }

    static int[] merge(int[] p, int[] q) {
        return new int[]{Math.max(p[0], q[0]), Math.min(p[1], q[1])};
    }
}
/*
C. Maximal Intersection
https://codeforces.com/contest/1029/problem/C

灵茶の试炼 2024-04-30
题目大意：
输入 n(2≤n≤3e5) 和 n 条线段的左右端点 L[i] R[i] (0≤L[i]≤R[i]≤1e9)。
你需要删除恰好一条线段，使得剩下的 n-1 条线段的交集长度最大。
输出最大长度。
例如 [1,5] 和 [3,9] 的交集为 [3,5]，长度为 2。
例如 [1,5] 和 [5,7] 的交集为 [5,5]，长度为 0。
例如 [1,5] 和 [6,6] 的交集为空，长度为 0。

rating 1600
前后缀分解。
枚举删除第 i 条线段，问题变成前 i-1 条线段的交集，与后 n-i 条线段的交集，这两个交集的交集长度。
前 i 条线段的交集，可以像前缀和那样递推算出。
两条线段的交集，左端点为两条线段左端点的最大值，右端点为两条线段右端点的最小值。
https://codeforces.com/problemset/submission/1029/258797112
也可以维护左端点的最大次大，右端点的最小次小，分类讨论即可。该方法可以推广到删除多个线段的情况。
======

Input
4
1 3
2 6
0 4
3 3
Output
1

Input
5
2 6
1 3
0 4
1 20
0 4
Output
2

Input
3
4 5
1 2
9 20
Output
0

Input
2
3 10
1 5
Output
7
 */
