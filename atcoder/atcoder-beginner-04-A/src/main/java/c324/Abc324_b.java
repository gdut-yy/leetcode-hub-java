package c324;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc324_b {
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        return n == 1 ? "Yes" : "No";
    }
}
/*
B - 3-smooth Numbers
https://atcoder.jp/contests/abc324/tasks/abc324_b

题目大意：
You are given a positive integer N. If there are integers x and y such that N=2^x 3^y , print Yes; otherwise, print No.

判断是否只含 因子2 和 因子3
======

Input 1
324
Output 1
Yes

Input 2
5
Output 2
No

Input 3
32
Output 3
Yes

Input 4
37748736
Output 4
Yes
 */
