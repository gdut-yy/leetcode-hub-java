package p1270;

import java.util.Scanner;

public class CF1270B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve1());
        }
    }

    // 方法一
    private static String solve() {
        int mn = a[0], mx = a[0];
        int minL = 0, maxL = 0, l = -1, r = -1;
        for (int i = 1; i < n; i++) {
            int v = a[i];
            if (v - i > mn) {
                l = minL;
                r = i;
            } else {
                mn = v - i;
                minL = i;
            }
            if (v + i < mx) {
                l = maxL;
                r = i;
            } else {
                mx = v + i;
                maxL = i;
            }
        }
        if (r < 0) {
            return "NO";
        }
        return "YES\n" + (l + 1) + " " + (r + 1);
    }

    // 方法二
    private static String solve1() {
        int pre = a[0];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            int v = a[i];
            if (Math.abs(v - pre) > 1) {
                l = i;
                r = i + 1;
            }
            pre = v;
        }
        if (r == 0) {
            return "NO";
        }
        return "YES\n" + (l) + " " + (r);
    }
}
/*
B. Interesting Subarray
https://codeforces.com/contest/1270/problem/B

灵茶の试炼 2025-05-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
找 a 的一个非空连续子数组 b，满足 max(b) - min(b) >= len(b)。
如果不存在这样的 b，输出 NO。
否则输出 YES，以及 b 在 a 中的位置，即左右端点的下标。下标从 1 开始。多解输出任意解。

rating 1200
方法一：枚举右，维护左
最大值和最小值在 b 的左右端点处是最优的，这样 len(b) 更小，更容易满足要求。
讨论最小值在最大值左边的情况。
设 mn = a[i]，mx = a[j]。其中 i < j。
题目要求 a[j]-a[i] >= j-i+1，
即 a[j]-a[i] > j-i，
变形得 a[j]-j > a[i]-i。
枚举 j，维护 a[i]-i 的最小值。
最大值在最小值左边的情况，可以用同样的方式推导。
方法二：脑筋急转弯
如果存在相邻元素之差 >= 2，那这两个数就组成一个符合要求的子数组。
如果任意相邻元素之差都 <= 1，那么任意子数组 b 的最大最小之差都会 < len(b)，无解。
方法一 https://codeforces.com/contest/1270/submission/320162977
方法二 https://codeforces.com/contest/1270/submission/320163045
代码备份（洛谷）二合一
======

Input
3
5
1 2 3 4 5
4
2 0 1 9
2
2019 2020
Output
NO
YES
1 4
NO
 */
