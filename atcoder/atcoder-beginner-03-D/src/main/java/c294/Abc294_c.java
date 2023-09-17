package c294;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc294_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, a, b));
    }

    private static String solve(int n, int m, int[] a, int[] b) {
        int[] ans1 = new int[n];
        int[] ans2 = new int[m];

        int i = 0, j = 0;
        int id = 1;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                ans1[i++] = id++;
            } else {
                ans2[j++] = id++;
            }
        }
        while (i < n) {
            ans1[i++] = id++;
        }
        while (j < m) {
            ans2[j++] = id++;
        }

        return Arrays.stream(ans1).mapToObj(String::valueOf).collect(Collectors.joining(" "))
                + System.lineSeparator()
                + Arrays.stream(ans2).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C - Merge Sequences
https://atcoder.jp/contests/abc294/tasks/abc294_c

题目大意：
给定长度为 N 和 M 的严格递增序列: A=(A1, A2,..., AN)和 B=(B1, B2,..., BM)。这里，Ai != Bj 对于每个 i 和 j(1≤i≤N,1≤j≤M)。
设 C=(C1, c2,..., CN+M)是一个严格递增的长度为 N+M 的序列，由以下过程产生。
- 设 C 是 A 和 B 的拼接，形式上，当 i=1,2,..., N 时，令 Ci= Ai，当 i=N+1, N+2,..., N+M 时，令 Ci=B[i−N]。
- 按升序排序 C。
对于 A1, A2,..., AN, B1, B2,..., BM，找出它在 C 中的位置。更正式地说，对于每一个 i=1,2,...,N，找到 k 个使得 Ck = Ai，并且对于每一个 j=1,2,...,M，找到 k 个使得 Ck = Bj。

双指针。合并两个有序的数组。
======

Input
4 3
3 14 15 92
6 53 58
Output
1 3 4 7
2 5 6

Input
4 4
1 2 3 4
100 200 300 400
Output
1 2 3 4
5 6 7 8

Input
8 12
3 4 10 15 17 18 22 30
5 7 11 13 14 16 19 21 23 24 27 28
Output
1 2 5 9 11 12 15 20
3 4 6 7 8 10 13 14 16 17 18 19
 */