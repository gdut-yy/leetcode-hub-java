package p1879;

import java.util.Scanner;

public class CF1879D {
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

    private static final int MOD = 998244353;

    private static String solve() {
        long[][] cnt = new long[30][2];
        long[][] sum = new long[30][2];
        for (int i = 0; i < 30; i++) {
            cnt[i][0] = 1;
        }

        long xor = 0, ans = 0;
        for (int i = 1; i <= n; i++) {
            long v = a[i - 1];

            xor ^= v;
            for (int j = 0; j < 30; j++) {
                int b = (int) (xor >> j & 1);
                ans = (ans + ((i * cnt[j][b ^ 1] - sum[j][b ^ 1]) % MOD << j)) % MOD;
                cnt[j][b]++;
                sum[j][b] += i;
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Sum of XOR Functions
https://codeforces.com/contest/1879/problem/D

灵茶の试炼 2024-06-12
题目大意：
输入 n(1≤n≤3e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
定义 f(L,R) 为连续子数组 a[L] 到 a[R] 的异或和。
计算所有 f(L,R)*(R-L+1) 的和，其中 L <= R。
输出答案模 998244353 的结果。

rating 1700
我将带你一步步思考本题。
首先，完成 560. 和为 K 的子数组
我的题解
在我的题解中，第三个思考题是：
计算和为 k 的所有子数组的长度之和。
这也可以用前缀和来算，即所有满足 s[r]-s[l] = k 的 r-l 之和。
枚举 r，假如有三个 l 满足 s[l] = s[r] - k，那么 r-l 之和就是
(r-l1) + (r-l2) + (r-l3)
= r * 3 - (l1 + l2 + l3)
所以我们需要维护两类数据：
1. s[i] 的出现次数，即上式中的 3。
2. s[i] 的 i 之和，也就是值等于 s[i] 的下标之和，即上式中的 l1 + l2 + l3。
回到本题，计算异或前缀和，问题变成 (s[r+1]^s[l])*(r+1-l) 之和，
用 r'=r+1 做个变量替换，要计算的变成 (s[r']^s[l])*(r'-l)，其中 l < r'。下文用 r 表示 r'。
拆位，考虑每一位的贡献。
最低位，如果异或结果等于 0，则没有贡献，只需要考虑 1，即所有 s[r]^s[l] 最低位 = 1 的 r-l 之和。
这正是我们前面思考的「和为 k 的所有子数组的长度之和」！
次低位，同上，0 没有贡献，只需要考虑 1，即所有 s[r]^s[l] 次低位 = 1 的 r-l 之和，再乘上 1 << 1。
第三位，同上，0 没有贡献，只需要考虑 1，即所有 s[r]^s[l] 第三位 = 1 的 r-l 之和，再乘上 1 << 2。
依此类推，一直到：所有 ((s[r]^s[l]) >> 29 & 1) == 1 的 r-l 之和，再乘上 1 << 29。
注意取模。
https://codeforces.com/contest/1879/submission/264665078
======

Input
3
1 3 2
Output
12

Input
4
39 68 31 80
Output
1337

Input
7
313539461 779847196 221612534 488613315 633203958 394620685 761188160
Output
257421502
 */
