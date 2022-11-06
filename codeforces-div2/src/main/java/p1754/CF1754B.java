package p1754;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1754B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        int offset = n / 2;
        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i <= offset; i++) {
            resList.add(i + offset);
            resList.add(i);
        }
        if (n % 2 == 1) {
            resList.add(n);
        }
        return resList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Kevin and Permutation
https://codeforces.com/contest/1754/problem/B

题目大意：
给定整数 n。打印一个 n 个整数 p 的排列，使两个连续数之间的最小绝对差尽可能大。

constructive algorithms
观察规律。最小绝对差最大值为 n/2.
======

input
2
4
3

output
2 4 1 3
1 2 3
 */