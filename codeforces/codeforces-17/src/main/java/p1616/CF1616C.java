package p1616;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1616C {
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
        // 我们可以固定任意一个元素，并使所有其他元素都等于它（答案的下界 n-1）。
        int min = n - 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = a[j] - a[i];
                int len = j - i;

                // 间隔
                double interval = diff / (double) len;

                // a[0] = a[i] - diff * i / len;
                int molecular = a[i] * len - diff * i;
                double a0 = molecular / (double) len;

                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    double should = a0 + k * interval;
                    if (!checkEqual(should, a[k])) {
                        cnt++;
                    }
                }
                min = Math.min(min, cnt);

            }
        }
        return String.valueOf(min);
    }

    private static boolean checkEqual(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }
}
/*
C. Representative Edges
https://codeforces.com/contest/1616/problem/C

题目大意：
给定整数 n 和长度为 n 的数组 a。每次操作可置 a[i] 为任意实数。求使 a 为等差数列的最少操作数。

上界为 n-1，枚举任意两个下标，得出 首项 和 公差，统计需要改变的个数，求最少值即可。
时间复杂度 O(n^3)
======

input
5
4
1 2 3 4
4
1 1 2 2
2
0 -1
6
3 -2 4 -1 -4 0
1
-100

output
0
2
0
3
0
 */
