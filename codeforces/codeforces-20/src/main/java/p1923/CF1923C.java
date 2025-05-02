package p1923;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1923C {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int v = a[i];
            if (v == 1) {
                s[i + 1] = s[i] - 1;
            } else {
                s[i + 1] = s[i] + v - 1;
            }
        }

        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (l < r && s[l - 1] <= s[r]) {
                ans[i] = 1;
            }
        }
        return Arrays.stream(ans).mapToObj(o -> o == 1 ? "YES" : "NO").collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
C. Find B
https://codeforces.com/contest/1923/problem/C

灵茶の试炼 2025-01-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5，q 之和 ≤3e5。
每组数据输入 n(1≤n≤3e5) q(1≤q≤3e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，下标从 1 开始。
然后输入 q 个询问，每个询问输入两个数 L 和 R，表示下标从 L 到 R 的连续子数组 b (1≤L≤R≤n)。
对于每个询问，你需要构造一个和 b 一样长的数组 c，要求：
1. sum(c) = sum(b)。
2. 所有 c[i] 都不等于 b[i]。
3. 所有 c[i] 都是正数。
能否构造？输出 YES 或 NO。

rating 1400
如果 b[i] = 1，那么必须增大，至少增大 1。
如果 b[i] > 1，那么为了弥补 b[i]=1 的增大，我们需要知道这些数最多能减小多少，也就是 b[i]-1 之和。
所以统计子数组内的 b[i]=1 的个数，以及 b[i]-1 的元素和，如果前者 <= 后者，那么输出 YES，否则输出 NO。
注意特判 L=R 的情况，只有一个数必然是 NO。
计算子数组和用前缀和。
代码 https://codeforces.com/contest/1923/submission/300453533
代码备份（洛谷）
======

Input
1
5 4
1 2 1 4 5
1 5
4 4
3 4
1 3
Output
YES
NO
YES
NO
 */
