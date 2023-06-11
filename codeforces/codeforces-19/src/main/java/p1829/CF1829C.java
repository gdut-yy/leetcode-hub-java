package p1829;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1829C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] m = new int[n];
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                m[i] = scanner.nextInt();
                s[i] = scanner.next();
            }
            System.out.println(solve(n, m, s));
        }
    }

    private static final int INF = (int) (4e5 + 5);

    private static String solve(int n, int[] m, String[] s) {
        int min11 = INF, min01 = INF, min10 = INF;

        for (int i = 0; i < n; i++) {
            if (s[i].equals("11")) {
                min11 = Math.min(min11, m[i]);
            } else if (s[i].equals("01")) {
                min01 = Math.min(min01, m[i]);
            } else if (s[i].equals("10")) {
                min10 = Math.min(min10, m[i]);
            }
        }

        int res = Math.min(min11, min10 + min01);
        return String.valueOf(res == INF ? -1 : res);
    }
}
/*
C. Mr. Perfectly Fine
https://codeforces.com/contest/1829/problem/C

题目大意：
维克多想成为“完美先生”。为此，他需要掌握一套特定的技能。更准确地说，他需要掌握两项技能。
维克多有 n 本书。阅读第 1 本书花了他 1 分钟，并会给他一些(可能没有)所需的两种技能，用长度为 2 的二进制字符串表示。
要让维克多掌握这两项技能，最少需要多少时间?

分类讨论。
要么 11
要么 10+01
取最小值。
======

input
6
4
2 00
3 10
4 01
4 00
5
3 01
3 01
5 01
2 10
9 10
1
5 11
3
9 11
8 01
7 10
6
4 01
6 01
7 01
8 00
9 01
1 00
4
8 00
9 10
9 11
8 11
output
7
5
5
9
-1
8
 */

