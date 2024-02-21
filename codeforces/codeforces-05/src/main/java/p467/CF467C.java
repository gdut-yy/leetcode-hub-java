package p467;

import java.util.Scanner;

public class CF467C {
    static int n, m, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + a[i];
        }

        long[] pre = new long[n + 1];
        long[] f = new long[n + 1];
        while (k-- > 0) {
            for (int j = m; j <= n; j++) {
                f[j] = Math.max(f[j - 1], pre[j - m] + s[j] - s[j - m]);
            }
            // pre, f = f, pre
            pre = f;
            f = new long[n + 1];
        }
        return String.valueOf(pre[n]);
    }
}
/*
C. George and Job
https://codeforces.com/contest/467/problem/C

灵茶の试炼 2022-08-09
题目大意：
输入三个正整数 n m k (1≤m*k≤n≤5000)，和一个长为 n 的整数数组 a(0≤a[i]≤1e9)。
从 a 中选择 k 个长度均为 m 且互不相交的子数组，使得这些子数组的元素之和最大，输出这个最大值。
注：子数组是连续的。
进阶：如果 a 是环形数组要怎么做？

rating 1700
https://codeforces.com/contest/467/submission/167580710
定义 f[i][j] 表示前 j 个元素选 i 个子数组，能得到的最大的元素和。
计算 f[i][j]，讨论 a[j] 选 or 不选，不选就是 f[i][j-1]，选就意味着把 a[j] 当作第 i 个子数组的最后一个元素（因为我们只考虑前 j 个元素），因此为 f[i-1][j-m] + a[j-m+1]+...+a[j]，这可以用前缀和优化。
因此 f[i][j] = max(f[i][j-1], f[i-1][j-m]+s[j]-s[j-m])。
答案为 f[k][n]。
时间复杂度 O(nk)。
代码实现中可以用滚动数组优化掉第一个维度。
环形的话，枚举前 m 个位置当作数组的起点，O(nmk) 可以通过。
---
“最后一个元素” 让我想到了 2209. 用地毯覆盖后的最少白色砖块 https://leetcode.cn/problems/minimum-white-tiles-after-covering-with-carpets/
这两题还是挺像的。
======

input
5 2 1
1 2 3 4 5
output
9

input
7 1 3
2 10 7 18 5 33 0
output
61
 */
