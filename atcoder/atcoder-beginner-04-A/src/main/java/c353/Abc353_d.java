package c353;

import java.util.Scanner;

public class Abc353_d {
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
    static long[] pow10 = new long[11];

    static {
        pow10[0] = 1;
        for (int i = 1; i <= 10; i++) {
            pow10[i] = pow10[i - 1] * 10;
        }
    }

    private static String solve() {
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long v = a[i];
            int vLen = String.valueOf(v).length();
            ans = (ans + pow10[vLen] % MOD * sum + v * i) % MOD;
            sum = (sum + v) % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
D - Another Sigma Problem
https://atcoder.jp/contests/abc353/tasks/abc353_d

灵茶の试炼 2025-04-21
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
定义 f(x,y) 表示拼接 x 和 y 得到的数字。
例如 f(3,14) = 314。
输出所有 f(a[i],a[j]) 之和，其中 i < j。
答案模 998244353。

枚举右，维护左。
枚举 a[j]，设其十进制长度为 m。
那么左边的每个 a[i] 与 a[j] 拼接后，a[i] 的贡献是 a[i] * 10^m。
维护 a[i] 之和即可算出左边所有 a[i] 的贡献。
a[j] 的贡献是 a[j]*j。
注意取模。
注意 10^m 需要先取模，再和 a[i] 之和相乘，否则会爆 LL。
代码 https://atcoder.jp/contests/abc353/submissions/65066000
======

Input 1
3
3 14 15
Output 1
2044

Input 2
5
1001 5 1000000 1000000000 100000
Output 2
625549048
 */
