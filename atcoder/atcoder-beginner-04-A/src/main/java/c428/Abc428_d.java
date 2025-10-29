package c428;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Abc428_d {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    // long sqrt 的精度不够
    static class WA {
        static long[] powers = new long[11];

        static {
            powers[0] = 1;
            for (int i = 1; i <= 10; i++) {
                powers[i] = powers[i - 1] * 10;
            }
        }

        static void solve() {
            long C = scanner.nextLong();
            long D = scanner.nextLong();
            long low_y = C + 1;
            long high_y = C + D;

            int d_min = String.valueOf(low_y).length();
            int d_max = String.valueOf(high_y).length();

            long total_count = 0;
            for (int d = d_min; d <= d_max; d++) {
                if (d < 1 || d > 10) continue;

                long low_bound = powers[d - 1];
                long high_bound = powers[d] - 1;

                long L_d = Math.max(low_bound, low_y);
                long R_d = Math.min(high_bound, high_y);
                if (L_d > R_d) continue;

                long base = powers[d];
                long A = C * base + L_d;
                long B = C * base + R_d;

                // 计算最小k: k^2 >= A
                long k_low = (long) Math.sqrt(A);
                if (k_low * k_low < A) {
                    k_low++;
                }

                // 计算最大k: k^2 <= B
                long k_high = (long) Math.sqrt(B);

                if (k_low <= k_high) {
                    total_count += (k_high - k_low + 1);
                }
            }
            out.println(total_count);
        }
    }

    static BigInteger[] powers = new BigInteger[11];

    static {
        powers[0] = BigInteger.ONE;
        for (int i = 1; i <= 10; i++) {
            powers[i] = powers[i - 1].multiply(BigInteger.TEN);
        }
    }

    private static void solve() {
        long C = scanner.nextLong();
        long D = scanner.nextLong();
        long low_y = C + 1;
        long high_y = C + D;

        int d_min = String.valueOf(low_y).length();
        int d_max = String.valueOf(high_y).length();

        long total_count = 0;
        for (int d = d_min; d <= d_max; d++) {
            if (d < 1 || d > 10) {
                continue;
            }

            BigInteger low_bound = powers[d - 1];
            BigInteger high_bound = powers[d].subtract(BigInteger.ONE);

            BigInteger L_d = BigInteger.valueOf(low_y).max(low_bound);
            BigInteger R_d = BigInteger.valueOf(high_y).min(high_bound);

            if (L_d.compareTo(R_d) > 0) {
                continue;
            }

            BigInteger base = powers[d];
            BigInteger A = base.multiply(BigInteger.valueOf(C)).add(L_d);
            BigInteger B = base.multiply(BigInteger.valueOf(C)).add(R_d);

            // Calculate k_low: smallest integer >= sqrt(A)
            BigInteger sqrtA = A.sqrt();
            BigInteger sqrtASquare = sqrtA.multiply(sqrtA);
            long k_low;
            if (sqrtASquare.compareTo(A) < 0) {
                k_low = sqrtA.longValue() + 1;
            } else {
                k_low = sqrtA.longValue();
            }

            // Calculate k_high: largest integer <= sqrt(B)
            BigInteger sqrtB = B.sqrt();
            long k_high = sqrtB.longValue();

            if (k_low <= k_high) {
                total_count += (k_high - k_low + 1);
            }
        }
        out.println(total_count);
    }
}
/*
D - 183184
https://atcoder.jp/contests/abc428/tasks/abc428_d

题目大意：
对于正整数 x 和 y ，定义 f(x,y) 如下：
- 设 z 是将十进制符号 x,y 解释为字符串并按此顺序连接得到的字符串。设 f(x,y) 是将 z 解释为十进制整数时的值。
例如， f(3,14)=314, f(100,3)=1003 。
给你正整数 C 和 D 。求满足以下条件的整数 x 的个数：
- 1 <= x <= D
- f(C, C+x) 是一个完全平方。
给你 T 个测试用例，求每个测试用例的答案。

https://yuanbao.tencent.com/chat/naQivTmsDa/c429e554-4acb-45c3-aaf6-4b0a3d095377
======

Input 1
4
4 80
183 5000
18 10
824 5000000000
Output 1
3
2
0
1421
 */
