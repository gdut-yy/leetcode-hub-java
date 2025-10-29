package c423;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc423_f {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int MX = 21;
    private static final long[][] C = new long[MX][MX];

    static {
        // 预处理组合数
        for (int i = 0; i < MX; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    private static void solve() {
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long Y = scanner.nextLong();

        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }

        long[] U = new long[N + 1];
        int totalSubsets = 1 << N;

        for (int bitmask = 1; bitmask < totalSubsets; bitmask++) {
            int j = 0;
            long lcmVal = 1;
            boolean skip = false;

            for (int i = 0; i < N; i++) {
                if ((bitmask & (1 << i)) != 0) {
                    j++;
                    long a = A[i];
                    long g = getGCD(lcmVal, a);

                    // 这样写 lcmVal 会溢出
//                    lcmVal = lcmVal / g * a;
//                    if (lcmVal > Y) {
//                        skip = true;
//                        break;
//                    }
                    if (lcmVal / g > Y / a) {
                        skip = true;
                        break;
                    }
                    lcmVal = lcmVal / g * a;
                }
            }

            if (skip || j > N) continue;
            U[j] += Y / lcmVal;
        }

        long ans = 0;
        for (int j = M; j <= N; j++) {
            int sign = ((j - M) % 2 == 0) ? 1 : -1;
            ans += sign * C[j][M] * U[j];
        }
        out.println(ans);
    }
}
/*
F - Loud Cicada
https://atcoder.jp/contests/abc423/tasks/abc423_f

题目大意：
阿特科德岛有 N(20) 种蝉类。 i 种的蝉只有在 Ai(1e18) 的倍数年才会大规模爆发。
从 1 年到 Y(1e18) 年的 Y 年中，求有多少年正好有 M 种蝉类大规模爆发。

https://yuanbao.tencent.com/chat/naQivTmsDa/291707ee-fd44-464b-9b9b-849ee526a5af
======

Input 1
3 2 16
4 2 3
Output 1
4

Input 2
2 1 122333444422333
1429 73651
Output 2
87266392324

Input 3
20 3 832725971730072237
19639596380058 49098990950145 32732660633430 114564312217005 68738587330203 45825724886802 252041486877411 180029633483865 108017780090319 72011853393546 468077047058049 297867211764213 212762294117295 127657376470377 85104917646918 723391799998803 612100753845141 389518661537817 278227615384155 166936569230493
Output 3
24231
 */
