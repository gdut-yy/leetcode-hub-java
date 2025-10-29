package c418;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc418_b {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String s = scanner.next();
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 't') {
                pos.add(i);
            }
        }
        int sz = pos.size();
        double ans = 0;
        for (int i = 0; i < sz; i++) {
            for (int j = i + 1; j < sz; j++) {
                int pi = pos.get(i), pj = pos.get(j);
                int t = pj - pi + 1;
                int x = j - i + 1;
                if (t >= 3) {
                    double res = (double) (x - 2) / (t - 2);
                    if (res > ans) {
                        ans = res;
                    }
                }
            }
        }
        out.printf("%.10f\n", ans);
    }
}
/*
B - You're a teapot
https://atcoder.jp/contests/abc418/tasks/abc418_b

题目大意：
对于一个字符串 t ，定义 填充率 如下：
- 如果 t 的第一个字符和最后一个字符都是 "T "和 |t| >= 3 ：设 x 是 t 中 "t "的个数。那么 t 的填充率为 \frac{x-2}{|t|-2} ，其中 |t| 表示 t 的长度。
- 否则： t 的填充率为 0 。
给你一个字符串 S 。求 S 子串的最大填充率。

s 长度只有 100，双层循环即可。
======

Input 1
attitude
Output 1
0.50000000000000000

Input 2
ottottott
Output 2
0.66666666666666667

Input 3
coffeecup
Output 3
0.00000000000000000
 */
