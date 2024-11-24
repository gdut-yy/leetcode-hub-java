package p934;

import java.util.Arrays;
import java.util.Scanner;

public class CF934A {
    static int n, m;
    static long[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new long[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);
        Arrays.sort(b);

        long mx1 = Math.max(a[0] * b[0], a[0] * b[m - 1]);
        long mx2 = Math.max(a[n - 1] * b[0], a[n - 1] * b[m - 1]);
        if (mx1 > mx2) {
            a = Arrays.copyOfRange(a, 1, n);
        } else {
            a = Arrays.copyOfRange(a, 0, n - 1);
        }
        n--;

        mx1 = Math.max(a[0] * b[0], a[0] * b[m - 1]);
        mx2 = Math.max(a[n - 1] * b[0], a[n - 1] * b[m - 1]);
        long ans = Math.max(mx1, mx2);
        return String.valueOf(ans);
    }
}
/*
A. A Compatible Pair
https://codeforces.com/contest/934/problem/A

灵茶の试炼 2024-02-19
题目大意：
输入 n(2≤n≤50) m(2≤m≤50) 和长为 n 的数组 a，长为 m 的数组 b，元素范围 [-1e9,1e9]。
你必须恰好删除 a 中的一个数字。
最小化 a[i] * b[j] 的最大值。
输出这个最大值。

rating 1400
暴力做法：
枚举删除哪个数。
非暴力做法：
注意到最大值只能在最小数和最大数之间产生（两两组合有 4 个乘积）。
如果 a[0] 与 b[0] 或 b[m-1] 乘积更大，那么删除 a[0]，否则删除 a[n-1]。
删除后重新算最小数和最大数，取这 4 个乘积的最大值，作为答案。
https://codeforces.com/contest/934/submission/246076964
======

input
2 2
20 18
2 14
output
252

input
5 3
-1 0 1 2 3
-1 0 1
output
2
 */
