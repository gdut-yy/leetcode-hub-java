package p2008;

import java.util.Scanner;

public class CF2008F {
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

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long ans = 0;
        long s = 0;
        for (int v : a) {
            ans = (ans + v * s) % MOD;
            s = (s + v) % MOD;
        }
        ans = ans * quickPow(n * (n - 1L) / 2, MOD - 2) % MOD;
        return String.valueOf(ans);
    }

    static long quickPow(long a, long b) {
        a %= MOD;
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
F. Sakurako's Box
https://codeforces.com/contest/2008/problem/F

灵茶の试炼 2024-12-16
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
等概率地从 a 中选出两个下标不同的数 a[i] 和 a[j]。
输出 a[i]*a[j] 的期望值，模 1e9+7。
注：设期望值为 P/Q，你需要输出 P*Q^(-1)%(1e9+7)。
进阶：如果改成选 3 个数呢？k 个数呢？
进阶：改成 2e5 个询问，每个询问输出子数组 [L,R] 的答案。

rating 1400
每种选法都是 1/C(n,2) 的概率，所以答案的分母是 C(n,2)=n*(n-1)/2。
分子是满足 i<j 的 a[i]*a[j] 的乘积之和。
枚举右，维护左（a[i] 的和），即可算出。
提醒：如果 WA 了，请检查溢出/取模等问题。
尤其是计算快速幂时，要先把 n*(n-1)/2 取模。
代码 https://codeforces.com/contest/2008/submission/296415984
代码备份（洛谷）
======

Input
3
3
3 2 3
4
2 2 2 4
5
1 2 3 4 5
Output
7
6
500000012
 */
