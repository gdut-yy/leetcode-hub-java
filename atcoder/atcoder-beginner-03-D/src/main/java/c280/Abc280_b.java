package c280;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc280_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }
        System.out.println(solve(n, s));
    }

    private static String solve(int n, int[] s) {
        long[] a = new long[n];
        a[0] = s[0];
        for (int i = 1; i < n; i++) {
            a[i] = s[i] - s[i - 1];
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B - Inverse Prefix Sum
https://atcoder.jp/contests/abc280/tasks/abc280_b

题目大意：
给定一个整数 N 和一个长度为 N 的序列 S=(s1，…，sn)。
求一个长度为 N 的序列 a =(a 1，…，a N)，满足 k=1，…，N 的所有条件:
A1 + A2 + ... + Ak = sk。
这样的序列 a 总是存在并且是唯一的。

前缀和逆运算 - 差分
======

Input 1
3
3 4 8
Output 1
3 1 4

Input 2
10
314159265 358979323 846264338 -327950288 419716939 -937510582 97494459 230781640 628620899 -862803482
Output 2
314159265 44820058 487285015 -1174214626 747667227 -1357227521 1035005041 133287181 397839259 -1491424381
 */