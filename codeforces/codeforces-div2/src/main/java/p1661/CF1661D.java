package p1661;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1661D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
        }
        System.out.println(solve(n, k, b));
    }

    private static String solve(int n, int k, long[] b) {
        long ans = 0L;
        long ai = 0L;
        long d = 0L;
        // 二阶差分
        long[] d2 = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            // 一阶差分
            d += d2[i];
            // a[i] 的值
            ai += d;
            if (ai < b[i]) {
                int k2 = Math.min(i + 1, k);
                long times = (b[i] - ai - 1) / k2 + 1;
                ans += times;
                ai += times * k2;
                if (i > 0) {
                    d2[i - 1] -= times;
                    if (i > k2) {
                        d2[i - k2 - 1] += times;
                    }
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Weights Assignment For Tree Edges
https://codeforces.com/contest/1661/problem/D

灵茶の试炼 2023-01-23
题目大意：
输入 n k(k≤n≤3e5) 和长为 n 的数组 b(1≤b[i]≤1e12)。
初始你有一个长为 n 的数组 a，元素都为 0。
每次操作你要选一个长度恰好等于 k 的连续子数组，从左到右，第1个数加1，第2个数加2，……第k个数加k。
要使每个 a[i] >= b[i]，至少需要操作多少次？

https://codeforces.com/problemset/submission/1661/190145738
提示 1：倒着思考，这样可以贪心处理每个下标要操作多少次。
提示 2：用差分数组来处理这个等差数列，维护差分的差分。
======

input
3 3
5 4 6
output
5

input
6 3
1 2 3 2 2 3
output
3

input
6 3
1 2 4 1 2 3
output
3

input
7 3
50 17 81 25 42 39 96
output
92
 */
