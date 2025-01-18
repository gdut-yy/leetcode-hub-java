package p1904;

import java.util.Arrays;
import java.util.Scanner;

public class CF1904C {
    static int n, k;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (k > 2) return "0";
        Arrays.sort(a);
        long ans = a[0];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, a[i] - a[i - 1]);
        }
        if (k == 2) {
            for (int i = 0; i < n; i++) {
                long v = a[i];
                int j = i - 1;
                for (int l = 0; l < i; l++) {
                    long w = a[l];

                    long d = v - w;
                    while (j >= 0 && d < a[j]) {
                        j--;
                    }
                    ans = Math.min(ans, a[j + 1] - d);
                    if (j >= 0) {
                        ans = Math.min(ans, d - a[j]);
                    }
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Array Game
https://codeforces.com/contest/1904/problem/C

灵茶の试炼 2024-10-21
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n^2 之和 ≤4e6。
每组数据输入 n(2≤n≤2e3) k(1≤k≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e18)。
每次操作，你可以选择两个不同的下标 i 和 j，然后把 |a[i]-a[j]| 加到 a 的末尾（append）。
输出操作 k 次后，min(a) 的最小值。

rating 1400
如果 k>=3，那么答案是 0，因为可以对相同的 (i,j) 操作两次，得到两个一样的数，对这两个一样的数操作一次，得到 0。
如果 k=1，答案是 a 从小到大排序后，相邻元素的最小差值。
如果 k=2，暴力枚举所有 (i,j)，计算 d=|a[i]-a[j]|，然后使用二分/双指针找到 a 中离 d 最近的左右两个数，计算最小差值。
代码 https://codeforces.com/problemset/submission/1904/286327574
======

Input
4
5 2
3 9 7 15 1
4 3
7 4 15 12
6 2
42 47 50 54 62 79
2 1
500000000000000000 1000000000000000000
Output
1
0
3
500000000000000000
 */
