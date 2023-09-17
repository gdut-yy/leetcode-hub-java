package c278;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc278_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, k, a));
    }

    private static String solve(int n, int k, int[] a) {
        int[] ans = new int[n];
        for (int i = k; i < n; i++) {
            ans[i - k] = a[i];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
A - Shift
https://atcoder.jp/contests/abc278/tasks/abc278_a

题目大意：
给定长度为 N 的序列 a =(a1, a2，…，a N)。
下面的操作执行了整整 K 次:
- 删除 A 的初始元素，并在 A 的尾部添加一个 0。
输出操作后 A 的所有元素。

模拟。
======

Input 1
3 2
2 7 8
Output 1
8 0 0

Input 2
3 4
9 9 9
Output 2
0 0 0

Input 3
9 5
1 2 3 4 5 6 7 8 9
Output 3
6 7 8 9 0 0 0 0 0
 */