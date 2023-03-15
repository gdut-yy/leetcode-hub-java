package p1759;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1759A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        char[] chars = "Yes".toCharArray();
        int i;
        char first = s.charAt(0);
        if (first == 'Y') {
            i = 0;
        } else if (first == 'e') {
            i = 1;
        } else if (first == 's') {
            i = 2;
        } else {
            return "NO";
        }

        for (char ch : s.toCharArray()) {
            if (ch != chars[i]) {
                return "NO";
            }
            i = (i + 1) % 3;
        }
        return "YES";
    }
}
/*
Codeforces Round #834 (Div. 3)
A. Yes-Yes?
https://codeforces.com/contest/1759/problem/A

题目大意：
给定字符串 s。确定 s 是否是 YesYesYes 的子字符串。

模拟。
======

input
12
YES
esYes
codeforces
es
se
YesY
esYesYesYesYesYesYe
seY
Yess
sY
o
Yes

output
NO
YES
NO
YES
NO
YES
YES
NO
NO
YES
NO
YES
 */