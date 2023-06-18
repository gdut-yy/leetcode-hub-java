package p1841;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1841C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static final int[] VAL = {1, 10, 100, 1000, 10000};

    private static String solve(String s) {
        int n = s.length();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i) - 'A';
        }

        long ans = 0L;
        int mx = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += (a[i] < mx) ? -VAL[a[i]] : VAL[a[i]];
            mx = Math.max(mx, a[i]);
        }
        for (char c1 = 'A'; c1 <= 'E'; c1++) {
            if (!s.contains(String.valueOf(c1))) continue;

            for (char c2 = 'A'; c2 <= 'E'; c2++) {
                if (c1 == c2) continue;

                // 字母改小，改最右边的，否则改最左边的
                int idx = c2 < c1 ? s.lastIndexOf(c1) : s.indexOf(c1);

                long sum = 0L;
                a[idx] = c2 - 'A';
                mx = 0;
                for (int i = n - 1; i >= 0; i--) {
                    sum += (a[i] < mx) ? -VAL[a[i]] : VAL[a[i]];
                    mx = Math.max(mx, a[i]);
                }
                a[idx] = c1 - 'A';
                ans = Math.max(ans, sum);
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Ranom Numbers
https://codeforces.com/contest/1841/problem/C

题目大意：
不，不是“随机”数字。
随机数字用大写拉丁字母 A ~ E 表示，其中字母 A 取值为 1,B 取值为 10,C 取值为 100,D 取值为 1000,E 取值为 10000。
随机数是由随机数组成的序列。Ranom 数的值计算如下:所有数字的值相加，但有些数字带负号:如果一个数字的右边有一个值比它大得多的数字(不一定紧接在它后面)，那么这个数字带负号;否则，该数字取正号。
例如，随机数 DAAABDCA 为 1000−1−1−1−10+1000+100+1=2088。
你会得到一个随机数字。你最多只能改变一个数字。计算结果数的最大可能值。

枚举 5*5*2 = 50种情况
字母改小，改最右边的
字母改大，改最左边的
======

input
4
DAAABDCA
AB
ABCDEEDCBA
DDDDAAADDABECD
output
11088
10010
31000
15886
 */
