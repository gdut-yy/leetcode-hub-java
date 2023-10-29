package c301;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc301_d {
    static String s;
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next();
        n = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        String all0 = s.replace("?", "0");
        long min = Long.parseLong(all0, 2);
        if (min > n) return "-1";

        char[] cs = all0.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                cs[i] = '1';
                long cur = Long.parseLong(new String(cs), 2);
                if (cur > n) {
                    cs[i] = '0';
                }
            }
        }
        long ans = Long.parseLong(new String(cs), 2);
        return String.valueOf(ans);
    }
}
/*
D - Bitmask
https://atcoder.jp/contests/abc301/tasks/abc301_d

灵茶の试炼 2023-09-19
题目大意：
给定一个整数 N 和一个由 0、1 和 ? 组成的字符串 S。设 T 是一组可以通过替换每个 ? 在 S 中输入 0 或 1，并将结果解释为二进制整数。
例如，如果 S = ?0?,我们有 T ={000(2), 001(2), 100(2), 101(2)} ={0、1、4、5}。
打印(以十进制整数形式) T 中小于或等于 N 的最大值。如果 T 中不包含小于或等于 N 的值，则打印 -1。

把 ? 都替换成 0，如果此时 x > n，则输出 -1。
然后从左到右遍历每个 ?，如果把这个 ? 替换成 1，右侧 ? 替换成 0 后，满足 x <= n，那么这个 ? 一定要替换成 1，否则这个 ? 一定要替换成 0。
https://atcoder.jp/contests/abc301/submissions/45500660
======

Input 1
?0?
2
Output 1
1

Input 2
101
4
Output 2
-1

Input 3
?0?
1000000000000000000
Output 3
5
 */