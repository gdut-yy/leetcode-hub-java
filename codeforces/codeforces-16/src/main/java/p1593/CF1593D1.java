package p1593;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1593D1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        List<Integer> list = Arrays.stream(a).boxed().distinct().toList();
        if (list.size() == 1) {
            return "-1";
        }
        int res = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            res = getGCD(res, list.get(i) - list.get(i - 1));
        }
        return String.valueOf(Math.abs(res));
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
D1. All are Same
https://codeforces.com/contest/1593/problem/D1

题目大意：
给出整数 n 及长度为 n 的数组 a，假设存在一个 k，对数组任一元素减去 k，重复若干次后，数组所有数相等，求 k 的最大值。如果 k 无限大，返回 -1.

即求出最大公约数。
======

input
3
6
1 5 3 1 1 5
8
-1 0 1 -1 0 1 -1 0
4
100 -1000 -1000 -1000

output
2
1
1100
 */