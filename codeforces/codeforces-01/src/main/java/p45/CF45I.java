package p45;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF45I {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int mxI = -1, neg = 0, z = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                neg++;
                if (mxI < 0 || a[i] > a[mxI]) {
                    mxI = i;
                }
            } else if (a[i] == 0) {
                z++;
            }
        }
        if (n == 1) {
            return String.valueOf(a[0]);
        }
        if (z == n || neg == 1 && z == n - 1) {
            return "0";
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] != 0 && (neg % 2 == 0 || i != mxI)) {
                ans.add(String.valueOf(a[i]));
            }
        }
        return String.join(" ", ans);
    }
}
/*
https://codeforces.com/contest/45/problem/I

灵茶の试炼 2024-03-11
题目大意：
输入 n(1≤n≤100) 和长为 n 的数组 a(-100≤a[i]≤100)。
你需要从 a 中选择若干个数（至少一个），最大化所选数字的乘积。
输出你选的数字。如果答案不唯一，输出任意一个。

rating 1400
把所有非零数相乘，如果结果是负数（有奇数个负数），就去掉一个绝对值最小的负数（最大的负数）。
corner case：
如果 n=1，直接输出 a[0]。
如果全为 0，或者一个负数和 n-1 个 0，输出 0。
https://codeforces.com/contest/45/submission/250010096
======

Input
5
1 2 -3 3 3
Output
3 1 2 3

Input
13
100 100 100 100 100 100 100 100 100 100 100 100 100
Output
100 100 100 100 100 100 100 100 100 100 100 100 100

Input
4
-2 -2 -2 -2
Output
-2 -2 -2 -2
 */
