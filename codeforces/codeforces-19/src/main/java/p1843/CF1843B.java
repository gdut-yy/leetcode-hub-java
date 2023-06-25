package p1843;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1843B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        long sum = 0;
        int cnt = 0;
        int i = 0;
        while (i < n) {
            boolean flag = false;
            while (i < n && a[i] <= 0) {
                sum += -a[i];
                if (a[i] < 0) {
                    flag = true;
                }
                i++;
            }
            if (flag) cnt++;
            while (i < n && a[i] > 0) {
                sum += a[i];
                i++;
            }
        }
        return sum + " " + cnt;
    }
}
/*
B. Long Long
https://codeforces.com/contest/1843/problem/B

题目大意：
今天 Alex 看到了长度为 n 的数组 a1,a2,...,an。他可以应用任意多的操作(包括零操作)来更改数组元素。
在 1 个操作中，Alex 可以选择 1≤l≤r≤n 的任意 l 和 r，并将数组中从 l 到 r 的所有元素乘以 -1。换句话说，Alex 可以在一次操作中将子数组[al,al+1,...,ar]替换为[-al,-al+1,...,-ar]。
例如，设 n=5，则数组为[1,−2,0,3,−1]，l=2, r=4，则运算后的数组为[1,2,0,−3,−1]。
Alex 上学迟到了，所以你应该帮助他找到数组中可以通过任意次数的操作获得的最大可能的数字和，以及为此必须完成的最小操作次数。

统计 含负数 非正数段数量。
注意爆 int。。
======

input
5
6
-1 7 -4 -2 5 -8
8
-1 0 0 -2 1 0 -3 0
5
2 -1 0 -3 -7
5
0 -17 0 1 0
4
-1 0 -2 -1
output
27 3
7 2
13 1
18 1
4 1
 */
