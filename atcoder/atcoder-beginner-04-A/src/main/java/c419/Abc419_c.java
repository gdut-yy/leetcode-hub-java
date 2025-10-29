package c419;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc419_c {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int mnR = Integer.MAX_VALUE;
        int mxR = 0;
        int mnC = Integer.MAX_VALUE;
        int mxC = 0;
        for (int i = 0; i < n; i++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            mnR = Math.min(mnR, r);
            mxR = Math.max(mxR, r);
            mnC = Math.min(mnC, c);
            mxC = Math.max(mxC, c);
        }

        int maxD = Math.max(mxR - mnR, mxC - mnC);
        int ans = (maxD + 1) / 2;
        out.println(ans);
    }
}
/*
C - King's Summit
https://atcoder.jp/contests/abc419/tasks/abc419_c

题目大意：
有一个网格，网格中有 10^9 行和 10^9 列。让 (i, j) 表示从上往下数第 i 行和从左往上数第 j 列的正方形。
网格上有 N 人。最初，第 i 个人位于第 (Ri, Ci) 个方格。
时间从 0 开始。每个人都可以在 1, 2, 3, 4, ... 时做出以下动作。
- 停留在当前位置，或者移动到 8 个相邻的方格。禁止离开网格。形式上，让 (i, j) 号方格为当前方格，然后移动到存在的 (i-1, j-1), (i-1, j), (i-1, j+1), (i, j-1), (i, j), (i, j+1), (i+1, j-1), (i+1, j), (i+1, j+1) 号方格之一。假设移动不耗费时间。
求当 N 人在同一方格时的最小可能时间。

既然可以走也可以停，取 x,y 最大最小值计算中点即可。
======

Input 1
3
2 3
5 1
8 1
Output 1
3

Input 2
5
6 7
6 7
6 7
6 7
6 7
Output 2
0

Input 3
6
91 999999986
53 999999997
32 999999932
14 999999909
49 999999985
28 999999926
Output 3
44
 */
