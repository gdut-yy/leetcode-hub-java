package c301;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc301_b {
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
        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] >= 1) {
                int x = a[i - 1];
                while (x < a[i]) {
                    resList.add(x);
                    x++;
                }
            } else if (a[i - 1] - a[i] >= 1) {
                int x = a[i - 1];
                while (x > a[i]) {
                    resList.add(x);
                    x--;
                }
            }
        }
        resList.add(a[n - 1]);
        return resList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B - Fill the Gaps
https://atcoder.jp/contests/abc301/tasks/abc301_b

题目大意：
我们有一个长度为 N 的正整数序列:a =(a1,...,aN)。相邻的两项有不同的值。
让我们通过下面的过程向这个序列中插入一些数字。
1.如果 A 中的每一对相邻项的绝对差为 1，则终止该过程。
2.设 A[i], A[i+1] 是最接近 A 开头的两个相邻项它们的绝对差不为 1。
  - 如果 A[i] < A[i+1]，则在 A[i] 和 A[i+1] 之间插入 A[i]+1、A[i]+2,...,A[i+1]−1。
  - 如果 A[i] > A[i+1]，则在 A[i] 和 A[i+1] 之间插入 A[i]−1、A[i]−2,...,A[i+1]+1。
3.返回到步骤 1。
在过程结束时打印序列。

模拟。
======

Input 1
4
2 5 1 2
Output 1
2 3 4 5 4 3 2 1 2

Input 2
6
3 4 5 6 5 4
Output 2
3 4 5 6 5 4
 */