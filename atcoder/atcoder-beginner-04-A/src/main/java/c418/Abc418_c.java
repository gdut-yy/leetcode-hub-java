package c418;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc418_c {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int MX = (int) 1e6;

    private static void solve() {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        long totalBags = 0;
        for (int a : A) {
            totalBags += a;
        }

        int[] F = new int[MX + 1];
        for (int a : A) {
            if (a <= MX) {
                F[a]++;
            }
        }

        long[] C = new long[MX + 1];
        long[] P1 = new long[MX + 1];
        C[0] = 0;
        P1[0] = 0;
        for (int i = 1; i <= MX; i++) {
            C[i] = C[i - 1] + F[i];
            P1[i] = P1[i - 1] + (long) F[i] * i;
        }

        for (int i = 0; i < q; i++) {
            int b = scanner.nextInt();
            int t = Math.min(b - 1, MX);

            long sVal = P1[t] + t * (n - C[t]);
            long candidate = sVal + 1;
            long x0 = Math.max(candidate, b);

            if (x0 <= totalBags) {
                out.println(x0);
            } else {
                out.println(-1);
            }
        }
    }
}
/*
C - Flush
https://atcoder.jp/contests/abc418/tasks/abc418_c

题目大意：
扑克桌上有 N 种不同口味的茶包。这些口味的编号从 1 到 N ，有 A_i 个口味为 i（1 <= i <= N）的茶包。
你们将用这些茶包玩一个游戏。游戏的难度参数在 1 和 A_1 + ... + A_N 之间。难度为 b 的游戏过程如下：
1.宣布一个整数 x 。这里，它必须满足 b <= x <= A_1 + ... + A_N 。
2.庄家从桌子上的茶包中选出正好是 x 的茶包交给您。
3.你检查你收到的 x 个茶包的口味，从中选择 b 个茶包。
4.如果你选择的所有 b 茶叶都是同一种口味，你就赢了。否则，你输了。
庄家会尽力让你输。
您会得到 Q 个问题，请逐一回答这 j 个问题如下：
- 对于一个难度为 B_j 的游戏，请报出你必须在游戏开始时报出的保证获胜的最小整数 x 。如果不可能获胜，则报告 -1 。

https://yuanbao.tencent.com/chat/naQivTmsDa/c3f4505a-7b8e-4d0d-9290-ec896de077de
======

Input 1
4 5
4 1 8 4
1
8
5
2
10
Output 1
1
17
14
5
-1

Input 2
5 3
13 13 13 13 2
5
12
13
Output 2
19
47
51
 */
