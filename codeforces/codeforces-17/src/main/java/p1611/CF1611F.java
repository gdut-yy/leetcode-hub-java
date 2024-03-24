package p1611;

import java.util.Scanner;

public class CF1611F {
    static int n, s;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.nextInt();
            a = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        for (int i = 1; i <= n; i++) {
            a[i] += a[i - 1];
        }

        int ll = -1, rr = -1;
        int l = 0, r = 0;
        while (r < n) {
            while (r < n && a[r + 1] - a[l] >= -s) {
                r++;
            }
            if (r - l > rr - ll) {
                ll = l;
                rr = r;
            }
            l++;
        }
        if (ll < 0) {
            return "-1";
        }
        return (ll + 1) + " " + rr;
    }
}
/*
F. ATM and Students
https://codeforces.com/contest/1611/problem/F

灵茶の试炼 2022-08-26
题目大意：
输入 t (≤1e4) 表示有 t 组数据。
每组数据输入 n (≤2e5)、s (0≤s≤1e9) 和一个长为 n 的数组 a (-1e9≤a[i]≤1e9)。
所有数据的 n 之和不超过 2e5。
请你在 a 中找到一个最长的连续子数组 b，满足 b 的每个前缀和都 ≥ -s（注意是 -s）。
如果存在这样的 b，输出 b 的左右边界在 a 中的下标 l 和 r（下标从 1 开始，如果有多个答案，输出任意一种）。
如果不存在这样的 b，输出 -1。
思考：如果 s<0 要怎么做？@Zakl

rating 1800
https://codeforces.com/contest/1611/submission/169674825
O(n) 做法：前缀和 + 双指针。
固定左指针 l，去看右指针 r 最远能到哪。
当左指针右移时，如果右指针不能移动甚至要往左移，那就无法得到更优解，不用管它，右指针不移动；
否则右指针右移，移动到 r+1 无法满足要求时停止。
答案为移动过程中的最大的 r-l。
思考：为什么这样做是正确的？在可以移动右指针时，为什么不会出现中间某个前缀和 < -s 的情况？
======

input
3
4 10
-16 2 -6 8
3 1000
-100000 -100000 -100000
6 0
2 6 -164 1 -1 -6543
output
2 4
-1
1 2
 */
