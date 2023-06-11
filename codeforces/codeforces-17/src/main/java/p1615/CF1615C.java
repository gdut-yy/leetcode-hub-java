package p1615;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1615C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String a = scanner.next();
            String b = scanner.next();
            System.out.println(solve(n, a, b));
        }
    }

    private static String solve(int n, String a, String b) {
        if (a.equals(b)) {
            return "0";
        }

        int cnt00 = 0;
        int cnt01 = 0;
        int cnt10 = 0;
        int cnt11 = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == '0') {
                if (b.charAt(i) == '0') {
                    cnt00++;
                } else {
                    cnt01++;
                }
            } else {
                if (b.charAt(i) == '0') {
                    cnt10++;
                } else {
                    cnt11++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        // 奇数次。选择 11, 00=>10, 10=>00, 01=>11, 11=>01; 11 += 1, 01 -= 1
        if (cnt11 > 0) {

            // 偶数次。1 的数量相等：10+11 = 01+11，移项得：10 = 01
            int new10 = cnt00;
            int new01 = cnt11 - 1;
            if (new10 == new01) {
                ans = Math.min(ans, new10 + new01 + 1);
            }
        }

        // 偶数次。1 的数量相等：10+11 = 01+11，移项得：10 = 01
        if (cnt10 == cnt01) {
            ans = Math.min(ans, cnt10 + cnt01);
        }
        return (ans == Integer.MAX_VALUE) ? "-1" : String.valueOf(ans);
    }
}
/*
C. Menorah
https://codeforces.com/contest/1615/problem/C

题目大意：
给出整数 n 和长度为 n 的字符串 a,b。表示蜡烛的初始模式和所需模式。每次操作可选择一直蜡烛点燃（或保持点燃）其余的改变状态，求由 a 得到 b 的最小次数。无解输出 -1.

定义所有状态，一共四种：00，01，10，11. 奇数次操作 和 偶数次操作。
======

input
5
5
11010
11010
2
01
11
3
000
101
9
100010111
101101100
9
001011011
011010101

output
0
1
-1
3
4
 */