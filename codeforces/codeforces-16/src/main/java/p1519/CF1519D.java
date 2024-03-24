package p1519;

import java.util.Scanner;

public class CF1519D {
    static int n;
    static long[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve1());
    }

    private static String solve() {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * b[i];
        }

        long ans = sum;
        for (int i = 0; i < n; i++) {
            long cur = sum;
            for (int l = i - 1, r = i + 1; l >= 0 && r < n; l--) {
                cur -= (a[l] - a[r]) * (b[l] - b[r]);
                ans = Math.max(ans, cur);
                r++;
            }

            cur = sum;
            for (int l = i - 1, r = i; l >= 0 && r < n; l--) {
                cur -= (a[l] - a[r]) * (b[l] - b[r]);
                ans = Math.max(ans, cur);
                r++;
            }
        }
        return String.valueOf(ans);
    }

    private static String solve1() {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * b[i];
        }

        long[][] dp = new long[n + 1][n + 1];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = sum;
            dp[i + 1][i] = sum;
        }
        // 类似区间 dp 的做法
        for (int span = 2; span <= n; span++) {
            for (int i = 0; i + span - 1 < n; i++) {
                int j = i + span - 1;
                dp[i][j] = dp[i + 1][j - 1] - a[i] * b[i] - a[j] * b[j] + a[i] * b[j] + a[j] * b[i];
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Maximum Sum of Products
https://codeforces.com/contest/1519/problem/D

灵茶の试炼 2022-08-01
题目大意：
输入 n(≤5000) 和两个长为 n 的整数数组 a 和 b，元素值均在 [1,1e7] 中。
你可以至多反转一次 a 的某个子数组，求 sum(a[i]*b[i]) 的最大值（即最大化 a[0]*b[0]+a[1]*b[1]+...+a[n-1]*b[n-1]）。

rating 1600
https://codeforces.com/contest/1519/submission/166430407
暴力枚举是 O(n^3) 的，如何优化？
我们可以枚举反转的中心，然后向两侧扩展，每次扩展可以在上一次扩展的基础上计算，这样就能做到 O(n^2)。
注意反转的中心有两种，分别对应奇数长度和偶数长度的。
你也可以从区间 DP 的角度思考，见 https://www.luogu.com.cn/blog/292315/solution-cf1519d
======

input
5
2 3 2 1 3
1 3 2 4 2
output
29

input
2
13 37
2 4
output
174

input
6
1 8 7 6 3 6
5 9 6 8 8 6
output
235
 */
