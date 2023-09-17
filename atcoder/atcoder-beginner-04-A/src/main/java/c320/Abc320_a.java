package c320;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc320_a {
    static int a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = (long) (Math.pow(a, b) + Math.pow(b, a));
        return String.valueOf(ans);
    }
}
/*
A - Leyland Number
https://atcoder.jp/contests/abc320/tasks/abc320_a

题目大意：
计算 a^b + b^a

======

Input 1
2 8
Output 1
320

Input 2
9 9
Output 2
774840978

Input 3
5 6
Output 3
23401
 */
