package p451;

import java.util.Arrays;
import java.util.Scanner;

public class CF451E {
    static int n;
    static long s;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextLong();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long tot = Arrays.stream(a).sum();
        if (tot < s) return "0";

        long ans = 0;
        Comb comb = new Comb(20);
        for (int i = 0; i < 1 << n; i++) {
            long s2 = s;
            for (int j = 0; j < n; j++) {
                long v = a[j];
                if ((i >> j & 1) > 0) {
                    s2 -= v + 1;
                }
            }
            long res = comb.binom2((int) ((s2 + n - 1) % MOD), n - 1);
            if (Integer.bitCount(i) % 2 > 0) {
                res = -res;
            }
            ans += res;
        }
        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }

    static class Comb {
        long[] fac, inv_fac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) fac[i] = fac[i - 1] * i % MOD;
            inv_fac = new long[n + 1];
            for (int i = 0; i <= n; i++) inv_fac[i] = quickPow(fac[i], MOD - 2);
        }

        // C(n, m) = n! / m!(n-m)!
        long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * inv_fac[m] % MOD * inv_fac[n - m] % MOD;
        }

        // n 很大但 k 很小时
        long binom2(int n, int k) {
            if (n < k) return 0;
            long p = 1, q = 1;
            for (int i = 1; i <= k; i++) {
                p = p * (n - i + 1) % MOD;
                q = q * i % MOD;
            }
            return p * quickPow(q, MOD - 2) % MOD;
        }

        // 模下的 a^b
        long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) != 0) res = res * a % MOD;
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    }
}
/*
E. Devu and Flowers
https://codeforces.com/contest/451/problem/E

灵茶の试炼 2024-05-23
题目大意：
输入 n(1≤n≤20) s(0≤s≤1e14) 和长为 n 的数组 a(0≤a[i]≤1e12)。
你有 n 个盒子，第 i 个盒子装有 a[i] 朵颜色一样的花（无法区分）。
此外，没有两个盒子中的花朵颜色相同。
从这些盒子中恰好选出 s 朵花的方案数是多少？模 1e9+7。
如果你没有思路，可以先完成如下题目，并阅读我的题解
相似题目: 2929. 给小朋友们分糖果 II
https://leetcode.cn/problems/distribute-candies-among-children-ii/description/
或者阅读《算法竞赛进阶指南》容斥原理一节，本题为书上例题。

rating 2300
容斥原理+组合数。
请先阅读 n=3 时的题解 https://leetcode.cn/problems/distribute-candies-among-children-ii/solution/o1-rong-chi-yuan-li-pythonjavacgo-by-end-2woj/
看成是把 s 个无区别的小球，分给 n 个有区别的盒子，第 i 个盒子至多容纳 a[i] 个小球。
计算方法同上面的力扣题（n=3 的情况）。
枚举 a 的所有子集，子集中的盒子预先分配 a[i]+1 个小球。
剩余的小球 s2 按照 C(s2+n-1,n-1) 计算方案数。
组合数 C(n,k) 的计算可以分别计算分子和分母，最后用模运算除法解决。
关于模运算除法请看 模运算的世界：当加减乘除遇上取模
注意 n 很大，要先把 n 取模。
注意使用 64 位整数。
代码 https://codeforces.com/problemset/submission/451/261442815
优化：预处理 n-1 以内的阶乘的逆元 https://codeforces.com/problemset/submission/451/261443307
======

Input
2 3
1 3
Output
2

Input
2 4
2 2
Output
1

Input
3 5
1 3 2
Output
3

2 270030023747
891135146290 437305641972
 */
