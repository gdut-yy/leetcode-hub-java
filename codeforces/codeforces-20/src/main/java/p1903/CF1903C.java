package p1903;

import java.util.Scanner;

public class CF1903C {
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
            System.out.println(solve());
        }
    }

    private static String solve() {
        long ans = 0, s = 0;
        for (int i = n - 1; i >= 0; i--) {
            s += a[i];
            if (i == 0 || s > 0) {
                ans += s;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Theofanis' Nightmare
https://codeforces.com/contest/1903/problem/C

灵茶の试炼 2024-07-02
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(-1e8≤a[i]≤1e8)。
你需要把 a 分割成若干非空段，假设分割成了 k 段，那么得分为：
第一段的元素和 * 1 + 第二段的元素和 * 2 + ... + 第 k 段的元素和 * k
例如 [1,2,3,4] 分成两段 [1,2] 和 [3,4]，得分为
(1+2)*1 + (3+4)*2
输出最大得分。

rating 1400
等价转换。
和式可以视作 a 的若干后缀和之和。
例如 [1,2,3,4] 分成两段 [1,2] 和 [3,4]，得分为
(1+2)*1 + (3+4)*2
= (1+2+3+4) + (3+4)
所以计算 a 的所有后缀和，取其中大于 0 的后缀和相加，即为答案。注意整个数组的和一定要加进答案。
注意用 64 位整数。
代码 https://codeforces.com/problemset/submission/1903/268007268
======

Input
4
6
1 -3 7 -6 2 5
4
2 9 -5 -3
8
-3 -4 2 -5 1 10 17 23
1
830
Output
32
4
343
830
 */
