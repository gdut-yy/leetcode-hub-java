package c434;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc434_d {
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

    private static void solve() {
        final int mx = 2000;
        long[][] diff = new long[mx + 2][mx + 2];
        int n = scanner.nextInt();
        for (int v = n; v < n * 2; v++) {
            int r1 = scanner.nextInt();
            int r2 = scanner.nextInt();
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();
            diff[r1][c1] += v;
            diff[r1][c2 + 1] -= v;
            diff[r2 + 1][c1] -= v;
            diff[r2 + 1][c2 + 1] += v;
        }
        int[] ans = new int[n];
        int zero = 0;
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                diff[i + 1][j + 1] += diff[i + 1][j] + diff[i][j + 1] - diff[i][j];
                long v = diff[i + 1][j + 1];
                if (v == 0) {
                    zero++;
                } else if (v < n * 2) {
                    ans[(int) v - n]++;
                }
            }
        }
        for (int v : ans) {
            out.println(v + zero);
        }
    }
}
/*
D - Clouds
https://atcoder.jp/contests/abc434/tasks/abc434_d

灵茶の试炼 2026-06-30
题目大意：
有一个 2000 * 2000 大小的网格图。
输入 n(1≤n≤2e5) 和 n 个矩形，每个矩形输入 U D(1≤U≤D≤2000) L R(1≤L≤R≤2000)，该矩形覆盖网格图中的行号在 [U,D]，列号在 [L,R] 的区域。
定义 f(i) 表示去掉第 i 个矩形后，网格图中的没有被任何一个矩形覆盖的格子个数。
输出 f(1), f(2), ..., f(n)。

rating
用二维差分可以求出每个位置被多少个矩形覆盖。
但在恰好被一个矩形覆盖的情况下，如何求出这个矩形的编号？
对于矩形 i，我们可以把二维差分的加减一改成加减 n+i。
如此一来，被至少两个矩形覆盖的位置，值至少为 2n。
值大于 0 且小于 2n 的位置，就是恰好被一个矩形覆盖的位置，值减去 n 就得到了矩形的编号。
关于二维差分的原理，请看 【图解】从一维差分到二维差分。
代码 https://atcoder.jp/contests/abc434/submissions/77040632
======

Input 1
5
2 4 1 4
3 3 3 5
1 3 4 6
4 5 3 5
5 5 4 6
Output 1
3999983
3999976
3999982
3999978
3999977
 */
