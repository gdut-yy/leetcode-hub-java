package p1676;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1676A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String line = scanner.next();
            System.out.println(solve(line));
        }
    }

    private static String solve(String line) {
        char[] chars = line.toCharArray();
        int sum1 = chars[0] + chars[1] + chars[2];
        int sum2 = chars[3] + chars[4] + chars[5];
        return sum1 == sum2 ? "YES" : "NO";
    }
}
/*
Codeforces Round #790 (Div. 4)
A. Lucky?
https://codeforces.com/contest/1676/problem/A

题目大意：
给定一个 6 位数字，求前 3 位与后 3 位的和是否相等。

模拟。
======

input
5
213132
973894
045207
000000
055776

output
YES
NO
YES
YES
NO
 */