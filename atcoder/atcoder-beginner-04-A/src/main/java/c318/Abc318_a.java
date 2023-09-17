package c318;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc318_a {
    static int n, m, p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        p = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int ans = (n - m + 1 + p - 1) / p;
        return String.valueOf(ans);
    }
}
/*
A - Full Moon
https://atcoder.jp/contests/abc318/tasks/abc318_a

题目大意：
高桥喜欢满月。
让今天成为第一天。在今天或之后，他能看到满月的第一天是 M 日。此后，他每隔 P 天就能看到一次满月，也就是说，在 M+P 日，M+2P 日，以此类推。
找出从第 1 天到第 N 天(包括第 N 天)他能看到满月的天数。

数学
======

Input 1
13 3 5
Output 1
3

Input 2
5 6 6
Output 2
0

Input 3
200000 314 318
Output 3
628
 */