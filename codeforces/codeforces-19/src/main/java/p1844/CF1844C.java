package p1844;

import java.util.Scanner;

public class CF1844C {
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
        int mx = Integer.MIN_VALUE;
        long[] s = new long[2];
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, a[i]);
            s[i % 2] += Math.max(a[i], 0);
        }
        if (mx < 0) {
            return String.valueOf(mx);
        }
        return String.valueOf(Math.max(s[0], s[1]));
    }
}
/*
C. Particles
https://codeforces.com/contest/1844/problem/C

灵茶の试炼 2024-11-26
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
执行如下操作，直到 a 中只剩下 1 个数：
删除 a[i]，如果 a[i] 左右两边都有数字，则把 a[i-1] 和 a[i+1] 合并成一个数。
输出最后剩下的那个数的最大值。

rating 1300
操作不改变什么？
操作相当于把 a[i] += a[i+2]，然后把 a[i+1] 和 a[i+2] 都去掉。
例如 a=[1,2,3,4,5]，去掉 3，把 4 加到 2 中，数组变成 [1,6,5]。
注意 5 的下标的奇偶性是不变的。
一般地，由于每次操作都去掉了两个数，所以操作不会改变剩余元素的下标的奇偶性。
如果在 [1,6,5] 的基础上，去掉 6，把 5 加到 1 中，那么相当于把原数组的 2,3,4 都去掉，把 5 加到 1 中。
一般地，参与求和运算的元素，本质是 a 的子序列，且子序列相邻元素在 a 中的下标之差都是偶数。
也就是说，子序列的所有元素的下标，要么都是偶数，要么都是奇数。
贪心地想，我们可以从 a 中偶数下标中选出所有的正数 a[i] 再求和，记作 s0；或者从奇数下标中选出所有的正数 a[i] 再求和，记作 s1。
答案为 max(s0, s1)。
特殊情况：如果所有 a[i] 都是负数，那么答案为 max(a)。
代码 https://codeforces.com/contest/1844/submission/281947340
代码备份（洛谷）
======

Input
3
6
-3 1 4 -1 5 -9
5
998244353 998244353 998244353 998244353 998244353
1
-2718
Output
9
2994733059
-2718
 */
