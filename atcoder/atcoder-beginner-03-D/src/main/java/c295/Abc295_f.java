package c295;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc295_f {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            System.out.println(solve(s, l, r));
        }
    }

    private final static long[] P10 = new long[18];

    static {
        P10[0] = 1L;
        for (int i = 1; i < 18; i++) {
            P10[i] = P10[i - 1] * 10L;
        }
    }

    private static String solve(String s, long l, long r) {
        return String.valueOf(solve(s, r) - solve(s, l - 1));
    }

    private static long solve(String s, long x) {
        int sl = s.length();
        long res = 0L;
        for (int k = 0; k <= 15; k++) {
            long first = number(1, k, s);
            // not exist
            if (first == -1) continue;
            // too large
            if (first > x) continue;

            long left = 1L;
            long right = P10[16 - sl] + 1;
            while (left < right) {
                long mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (number(mid, k, s) > x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            res += left - 1;
        }
        return res;
    }

    private static long number(long i, int k, String s) {
        int l = s.length();
        int r = k + 1 - l;
        if (r < 0) {
            return -1;
        }
        i--;
        if (s.charAt(0) == '0') {
            i += P10[r];
        }
        long p = i / P10[r];
        long q = i % P10[r];
        return p * P10[k + 1] + Long.parseLong(s) * P10[r] + q;
    }
}
/*
F - substr = S
https://atcoder.jp/contests/abc295/tasks/abc295_f

题目大意：
对于 T 个测试用例，给定一个由数字和正整数 L 和 R 组成的字符串 S。请解决以下问题。
对于正整数 x，我们定义 f(x)为 x 的十进制表示(不带前导零)的连续子字符串的个数，这些子字符串等于 S。
例如，如果 S= 22，我们有 f(122)=1, f(123)=0, f(226)=1, f(222)=2。

数位 DP ?
相似题目: 1397. 找到所有好字符串
https://leetcode.cn/problems/find-all-good-strings/
======

Input
6
22 23 234
0295 295 295
0 1 9999999999999999
2718 998244353 9982443530000000
869120 1234567890123456 2345678901234567
2023032520230325 1 9999999999999999
Output
12
0
14888888888888889
12982260572545
10987664021
1
 */