package c294;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc294_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((a[i] & 1) == 0) {
                list.add(a[i]);
            }
        }
        return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
A - Filter
https://atcoder.jp/contests/abc294/tasks/abc294_a

题目大意：
给你一个 N 个整数的序列: A = (A1, A2,..., AN)。在不改变顺序的情况下打印 A 中的所有偶数。

模拟。
======

Input
5
1 2 3 5 6
Output
2 6

Input
5
2 2 2 3 3
Output
2 2 2

Input
10
22 3 17 8 30 15 12 14 11 17
Output
22 8 30 12 14
 */