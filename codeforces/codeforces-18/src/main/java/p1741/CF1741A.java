package p1741;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1741A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String a = scanner.next();
            String b = scanner.next();
            System.out.println(solve(a, b));
        }
    }

    private static String solve(String a, String b) {
        if (a.equals(b)) {
            return "=";
        }

        int n = a.length();
        int m = b.length();
        char aLast = a.charAt(n - 1);
        char bLast = b.charAt(m - 1);
        if (aLast == bLast) {
            if (aLast == 'S') {
                return (n > m) ? "<" : ">";
            } else {
                return (n > m) ? ">" : "<";
            }
        } else {
            if (aLast == 'S' || aLast == 'M' && bLast == 'L') {
                return "<";
            } else {
                return ">";
            }
        }
    }
}
/*
Codeforces Round #826 (Div. 3)
A. Compare T-Shirt Sizes
https://codeforces.com/contest/1741/problem/A

题目大意：
给定两个字符串 a,b 分别代表两件 T 恤的尺码，比较大小。
字母 M 代表中，S 代表小，L 代表大。字母 X 表示尺寸的大小(来自 eXtra)。例如，XXL 是超大号(比 XL 大，比 XXXL 小)。

模拟。若末位字符相等，比较 X 数量；否则比较字符本身。
======

input
6
XXXS XS
XXXL XL
XL M
XXL XXL
XXXXXS M
L M

output
<
>
>
=
<
>
 */