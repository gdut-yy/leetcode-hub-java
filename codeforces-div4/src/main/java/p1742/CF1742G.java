package p1742;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1742G {
    public static void main(String[] args) {
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
        boolean[] used = new boolean[n];

        int mask = 0;
        List<Integer> resList = new ArrayList<>();
        for (int k = 30; k >= 0; k--) {
            int j = -1;
            int maxMask = mask;
            // 第 k 位为 0
            if (((mask >> k) & 1) == 0) {
                for (int i = 0; i < n; i++) {
                    if (!used[i] && ((a[i] >> k) & 1) == 1) {
                        int newMask = mask | a[i];
                        if (maxMask < newMask) {
                            maxMask = newMask;
                            j = i;
                        }
                    }
                }
                if (j != -1) {
                    resList.add(a[j]);
                    used[j] = true;
                    mask = maxMask;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                resList.add(a[i]);
            }
        }
        return resList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
G. Orray
https://codeforces.com/contest/1742/problem/G

题目大意：
给定整数 n 和长为 n 的数组 a。定义 bi = a1 OR a2 OR ... OR ai。要求重新排列数组 a 的元素。使数组 b 字典序最大。

贪心，位运算。要使数尽可能大，需要先补全高位的 1。暴力枚举即可。
时间复杂度 O(n * logmaxai)
======

input
5
4
1 2 4 8
7
5 1 2 3 4 5 5
2
1 101
6
2 3 4 2 3 4
8
1 4 2 3 4 5 7 1

output
8 4 2 1
5 2 1 3 4 5 5
101 1
4 3 2 2 3 4
7 1 4 2 3 4 5 1
 */