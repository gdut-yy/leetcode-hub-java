package p1364;

import java.util.Scanner;

public class CF1364A {
    static int n, x;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            x = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long s = 0;
        int l = -1, r = -1;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            s += v;
            if (v % x != 0) {
                if (l < 0) {
                    l = i;
                }
                r = i;
            }
        }

        int ans;
        if (s % x != 0) {
            ans = n;
        } else if (l < 0) {
            ans = -1;
        } else {
            ans = Math.max(n - l - 1, r);
        }
        return String.valueOf(ans);
    }
}
/*
A. XXXXX
https://codeforces.com/contest/1364/problem/A

灵茶の试炼 2025-01-20
题目大意：
输入 T(≤5) 表示 T 组数据。
每组数据输入 n(1≤n≤1e5) x(1≤x≤1e4) 和长为 n 的数组 a(0≤a[i]≤1e4)。
输出 a 的最长连续子数组的长度，满足子数组的元素和不是 x 的倍数。
如果没有这样的子数组，输出 -1。

rating 1200
子数组 = 原数组 a 删除若干前缀/后缀元素。
分类讨论：
如果 sum(a) 不是 x 的倍数，无需删除数字，输出 n。
否则，应当删除一段全为 x 的倍数的前缀（或者后缀），然后再多删一个数，就可以让子数组元素和不是 x 的倍数了。取前缀/后缀两种情况的剩余长度的最大值作为答案。
如果所有 a[i] 都是 x 的倍数，输出 -1。
代码 https://codeforces.com/contest/1364/submission/301167260
代码备份（洛谷）
======

Input
3
3 3
1 2 3
3 4
1 2 3
2 2
0 6
Output
2
3
-1
 */
