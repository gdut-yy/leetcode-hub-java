package c317;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc317_b {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);
        for (int i = 1; i < n; i++) {
            if (a[i] - a[0] != i) {
                return String.valueOf(a[0] + i);
            }
        }
        return String.valueOf(a[n - 1] + 1);
    }
}
/*
B - MissingNo.
https://atcoder.jp/contests/abc317/tasks/abc317_b

题目大意：
直宏有 N+1 个连续整数，每个整数一个，但他丢失了一个。
剩下的 N 个整数以任意顺序排列为 a1,...,aN。找到丢失的整数。
给定的输入保证丢失的整数是唯一确定的。

3
2 3 4
======

Input 1
3
2 3 5
Output 1
4

Input 2
8
3 1 4 5 9 2 6 8
Output 2
7

Input 3
16
152 153 154 147 148 149 158 159 160 155 156 157 144 145 146 150
Output 3
151
 */