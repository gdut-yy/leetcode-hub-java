package p1714;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1714B {
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
        Set<Integer> visitedSet = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!visitedSet.contains(a[i])) {
                visitedSet.add(a[i]);
            } else {
                return String.valueOf(i + 1);
            }
        }
        return "0";
    }
}
/*
B. Remove Prefix
https://codeforces.com/contest/1714/problem/B

题目大意：
给定整数 n 和长度为 n 的序列 ai，求从序列开始删除最小元素数量，使所有剩余元素都不相同。

贪心，由后往前枚举，遇到重复元素即停止。
======

input
5
4
3 1 4 3
5
1 1 1 1 1
1
1
6
6 5 4 3 2 1
7
1 2 1 7 1 2 1

output
1
4
0
0
5
 */