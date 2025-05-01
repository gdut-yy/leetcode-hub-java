package p446;

import java.util.Scanner;

public class CF446A {
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
        int ans = 1;
        int[][] f = new int[n][2];
        f[0][0] = 1;
        f[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                f[i][0] = f[i - 1][0] + 1;
                f[i][1] = f[i - 1][1] + 1;
            } else {
                f[i][0] = 1;
                f[i][1] = 2; // 把 a[i-1] 改成任意 <= a[i]-1 的数
            }
            if (i > 1 && a[i] > a[i - 2] + 1) { // 把 a[i-1] 改成 [a[i-2]+1, a[i]-1] 中的任意数字
                f[i][1] = max(f[i][1], f[i - 2][0] + 2); // 在 f[i-2][0] 的基础上多了两个数
            }
            ans = max(ans, f[i][0], f[i][1], f[i - 1][0] + 1); // 在 f[i-1][0] 的基础上，修改 a[i] 为任意 >= a[i-1]+1 的数
        }
        return String.valueOf(ans);
    }

    static int max(int... values) {
        int maxValue = Integer.MIN_VALUE;
        for (int i : values) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }
}
/*
A. DZY Loves Sequences
https://codeforces.com/contest/446/problem/A

灵茶の试炼 2025-03-19
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你可以修改 a 中至多一个数（修改成任意整数）。
输出 a 的最长严格递增子数组的长度。
注：子数组是连续的。
进阶：如果可以改 2 个数呢？改 k 个数呢？

rating 1600
类似最大子数组和，对于子数组问题，我们可以枚举 a[i] 作为严格递增子数组的最后一个数。
定义 f[i][0] 表示以 a[i] 结尾的最长严格递增子数组的长度。
定义 f[i][1] 表示以 a[i] 结尾的修改一个数（但不是 a[i]）的最长严格递增子数组的长度。
分类讨论：
如果 a[i] > a[i-1]，无需修改，f[i][j] = f[i-1][j] + 1
如果 a[i] <= a[i-1]，那么 f[i][0] 只能是 1。把 a[i-1] 改成很小的数，可以得到 f[i][1]=2。
此外，如果 a[i] > a[i-2] + 1，可以通过修改 a[i-1]，在 f[i-2][0] 的基础上多两个数，也就是用 f[i-2][0]+2 更新 f[i][1] 的最大值。
还有一种情况，把 a[i] 改的很大，我们可以在 f[i-1][0] 的基础上多一个数。但如果 a[i+1] > a[i]，转移方程 f[i][1] = f[i-1][1] + 1 是错误的。
这种情况只能用于更新答案的最大值，不能参与状态转移。
这也是为什么状态定义要加上「但不是 a[i]」这样的限定词。
初始值 f[0][j] = 1，此时只有一个数 a[0]，最长严格递增子数组的长度只能是 1。
答案为 f[i][j] 的最大值，以及 f[i-1][0] + 1 的最大值，表示把 a[i] 改成 a[i-1]+1，便可以在 f[i-1][0] 的基础上多一个数。
代码 https://codeforces.com/problemset/submission/446/310503147
代码备份（洛谷）
双倍经验（洛谷 P9147） https://www.luogu.com.cn/problem/P9147
======

Input
6
7 2 3 1 5 6
Output
5
 */
