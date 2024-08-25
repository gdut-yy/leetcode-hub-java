package p1272;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1272D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        int ans = 1;

        // 前后缀分解
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = 1;
            }
            ans = Math.max(ans, pre[i]);
        }

        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                suf[i] = suf[i + 1] + 1;
            } else {
                suf[i] = 1;
            }
            ans = Math.max(ans, suf[i]);
        }

        for (int i = 1; i < n; i++) {
            if (i + 1 < n && a[i - 1] < a[i + 1]) {
                ans = Math.max(ans, pre[i - 1] + suf[i + 1]);
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Remove One Element
https://codeforces.com/contest/1272/problem/D

灵茶の试炼 2023-04-25
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你可以从 a 中去掉一个数（也可以不去掉）。
输出 a 的最长严格递增连续子数组的长度。

rating 1500
https://codeforces.com/contest/1272/submission/148467966
前后缀分解。
计算从后往前的严格递增子数组长度 suf[i]。
计算从前往后的严格递增子数组长度 pre[i]。
如果 a[i-1] < a[i+1]，那么可以去掉 a[i]，用 pre[i-1] + suf[i+1] 更新答案。
注：也可以状态机 DP，f[i][0/1] 表示到 i 的答案，0/1 表示是否消耗了一次去掉的机会。
======

input
5
1 2 5 3 4
output
4

input
2
1 2
output
2

input
7
6 5 4 3 2 4 3
output
2
 */
