package p1593;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1593C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] x = new int[k];
            for (int j = 0; j < k; j++) {
                x[j] = scanner.nextInt();
            }
            System.out.println(solve(n, k, x));
        }
    }

    private static String solve(int n, int k, int[] x) {
        Arrays.sort(x);
        int cnt = 0;
        int res = 0;
        for (int i = x.length - 1; i >= 0; i--) {
            if (cnt + n - x[i] < n) {
                cnt += n - x[i];
                res++;
            } else {
                break;
            }
        }
        return String.valueOf(res);
    }
}
/*
C. Save More Mice
https://codeforces.com/contest/1593/problem/C

题目大意：
给出正整数 n,k 和 k 个正整数。猫位于 0，洞位于 n，k只老鼠，第 i 只老鼠位置 ki。求能够到达洞而不被吃掉的最大老鼠数量。

排序后顺序累加判断边界即可。时间复杂度 O(nlogn)，但本题使用 Arrays.sort(int[]) testcase8 会 TLE，Arrays.sort(Integer[]) 却能 AC。。

import java.util.Arrays;
import java.util.Scanner;

public class CF1593C_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            Integer[] x = new Integer[k];
            for (int i = 0; i < k; i++) {
                x[i] = scanner.nextInt();
            }
            Arrays.sort(x);

            int cnt = 0;
            long sum = 0L;
            while (cnt < x.length && sum + n - x[k - 1 - cnt] < n) {
                sum += n - x[k - 1 - cnt];
                cnt++;
            }
            System.out.println(cnt);

            t--;
        }
    }
}
======

input
3
10 6
8 7 5 4 9 4
2 8
1 1 1 1 1 1 1 1
12 11
1 2 3 4 5 6 7 8 9 10 11

output
3
1
4
 */