package p2144;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2144C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve1();
        out.flush();
    }

    static final int MOD = 998244353;

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long f0 = 1, f1 = 0;
        int preV = 0, preW = 0;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            int w = scanner.nextInt();
            long nf0 = 0, nf1 = 0;
            if (v >= preV && w >= preW) {
                nf0 = f0;
                nf1 = f1;
            }
            if (v >= preW && w >= preV) {
                nf0 = (nf0 + f1) % MOD;
                nf1 = (nf1 + f0) % MOD;
            }
            f0 = nf0;
            f1 = nf1;
            preV = v;
            preW = w;
        }
        out.println((f0 + f1) % MOD);
    }

    private static void solve1() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long ans = 1;
        int preV = 0, preW = 0;
        for (int i = 0; i < n; i++) {
            int w = scanner.nextInt();
            int v = a[i];
            if (v >= preV && w >= preW && v >= preW && w >= preV) {
                ans = ans * 2 % MOD;
            }
            preV = v;
            preW = w;
        }
        out.println(ans);
    }
}
/*
C. Non-Descending Arrays
https://codeforces.com/contest/2144/problem/C

灵茶の试炼 2026-03-31
题目大意：
输入 T(≤500) 表示 T 组数据。
每组数据输入 n(1≤n≤100)，长为 n 的数组 a(1≤a[i]≤1000)，长为 n 的数组 b(1≤b[i]≤1000)。
选择一个 [1,n] 的下标子集（可以为空），对于子集中的每个下标 i，交换 a[i] 和 b[i]。
需要满足交换后 a 和 b 的都是递增的（允许相邻元素相同）。
输出有多少个合法的下标子集，模 998244353。
保证至少有一个合法的下标子集。

rating 1300
方法一：状态机 DP
递增约束只会发生在 i-1 和 i 之间。i 换不换，和 i-2 及其前面的位置无关。
定义 f[i][0/1] 表示 [1,i] 的方案数，其中 i 不交换/交换。
通过比较 a[i-1] a[i] b[i-1] b[i] 的大小关系，从 f[i-1][0/1] 转移过来。
初始值 f[0][0] = 1，f[0][1] = 0。
答案为 f[n][0] + f[n][1]。
方法二：乘法原理
有 n 个下标，考虑每个下标是否交换。
最左边的下标换不换都可以，方案数为 2。
第二个下标，如果满足 (a[2] > a[1] && b[2] > b[1]) && (a[2] > b[1] && b[2] > a[1])，那么换不换都可以，方案数为 2，否则方案数为 1。（注意输入保证至少有一个合法的下标子集）
依此类推，把每个位置的方案数相乘，即为答案。
方法一代码 https://codeforces.com/contest/2144/submission/368856886
方法二代码 https://codeforces.com/contest/2144/submission/368911458
代码备份（上面打不开的同学看这个）
======

Input
3
3
2 1 4
1 3 2
1
4
4
5
2 3 3 4 4
1 1 3 5 6
Output
2
2
8
 */
