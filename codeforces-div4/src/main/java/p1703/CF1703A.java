package p1703;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1703A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        return s.equalsIgnoreCase("YES") ? "YES" : "NO";
    }
}
/*
Codeforces Round #806 (Div. 4)
A. YES or YES?
https://codeforces.com/contest/1703/problem/A

题目大意：
给定字符串 s，判断 s 是否为 YES（不区分大小写）

模拟。
======

input
10
YES
yES
yes
Yes
YeS
Noo
orZ
yEz
Yas
XES

output
YES
YES
YES
YES
YES
NO
NO
NO
NO
NO
 */