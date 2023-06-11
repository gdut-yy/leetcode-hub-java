package p1674;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1674C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            String t = scanner.next();
            System.out.println(solve(s, t));
        }
    }

    private static String solve(String s, String t) {
        // t 等于 "a" 换了等于没换
        if (t.equals("a")) {
            return "1";
        }

        // 如果 t 含 'a' 且不为 "a"，则无限大
        if (t.contains("a")) {
            return "-1";
        }

        int n = s.length();
        return String.valueOf((long) Math.pow(2, n));
    }
}
/*
C. Infinite Replacement
https://codeforces.com/contest/1674/problem/C

题目大意：
给定一个只包含 'a' 的字符串 s 和只包含小写字母的字符串 t。一次操作可用 t 替换 s 中的 'a'，可以进行任意（包括 0）次操作。
求可以获得的不同字符串的数量 s。如果数字无限大，则输出-1。

分三种情况：
t = "a" => 1
t 除了 'a' 还有其他字符 => 无穷大
t 只含非 'a' 字符 => 2^n 种可能
======

input
3
aaaa
a
aa
abc
a
b

output
1
-1
2
 */