package p1760;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1760A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int[] a = new int[3];
            for (int j = 0; j < 3; j++) {
                a[j] = scanner.nextInt();
            }
            Arrays.sort(a);
            System.out.println(a[1]);
        }
    }
}
/*
Codeforces Round #835 (Div. 4)
A. Medium Number
https://codeforces.com/contest/1760/problem/A

题目大意：
给定三个不同的整数 a, b 和 c，求它们之间的中位数。

排序后取第二个数。
======

input
9
5 2 6
14 3 4
20 2 1
1 2 3
11 19 12
10 8 20
6 20 3
4 1 3
19 8 4

output
5
4
2
2
12
10
6
3
8
 */