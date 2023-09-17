package c314;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc314_a {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        System.out.println(solve());
    }

    static final String S = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

    private static String solve() {
        return S.substring(0, n + 2);
    }
}
/*
A - 3.14
https://atcoder.jp/contests/abc314/tasks/abc314_a

题目大意：
圆周率的小数点后 100 位是
3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679.
你会得到一个介于 1 到 100 之间的整数 N。
将 pi 的值打印到小数点后第 n 位。
更准确地说，将 pi 的值截断到小数点后 N 位，并打印结果，而不删除后面的 0。

字符串处理
======

Input 1
2
Output 1
3.14

Input 2
32
Output 2
3.14159265358979323846264338327950

Input 3
100
Output 3
3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679
 */