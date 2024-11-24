package p895;

import java.util.Scanner;

public class CF895C {
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

    private static final int MOD = (int) (1e9 + 7);
    static final int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67};

    private static String solve() {
        int[] cnt = new int[71];
        for (int v : a) {
            cnt[v]++;
        }
        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }

        long[] f = new long[1 << primes.length];
        f[0] = 1;
        for (int x = 0; x < 71; x++) {
            int c = cnt[x];
            if (c == 0) continue;

            int mask = 0;
            for (int i = 0; i < primes.length; i++) {
                int p = primes[i];
                for (int x0 = x; x0 % p == 0; x0 /= p) {
                    mask ^= 1 << i;
                }
            }
            long[] nf = new long[f.length];
            for (int s = 0; s < f.length; s++) {
                nf[s] = (nf[s] + f[s] * pow2[c - 1]) % MOD; // 选偶数个 x
                nf[s ^ mask] = (nf[s ^ mask] + f[s] * pow2[c - 1]) % MOD; // 选奇数个 x
            }
            f = nf;
        }
        long ans = (f[0] - 1 + MOD) % MOD;
        return String.valueOf(ans);
    }
}
/*
C. Square Subsets
https://codeforces.com/contest/895/problem/C

灵茶の试炼 2024-03-07
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤70)。
输出有多少个非空子序列，其元素乘积是完全平方数。模 1e9+7。
注：子序列不一定连续。
注：只要有元素下标不一样，就算做不同的子序列。
加强版：https://loj.ac/p/2978
反向题目：2572. 无平方子集计数
https://leetcode.cn/problems/count-the-number-of-square-free-subsets/

rating 2000
有两种方法，状压 DP / 线性基。这里介绍状压 DP 的做法。
统计每个元素的出现次数，记到 cnt 数组中。
70 以内有 19 个质数，考虑状压 DP。
定义 f[x][s] 表示考虑从 1 到 x 中选择子序列的方案数，满足子序列乘积的质因子分解中出现奇数次的质因子的集合是 s。
设 x 出现了 c=cnt[x] 次。
如果选择偶数个 x（这样的方案有 pow(2,c-1) 个），那么 s 不变，有
f[x][s] += f[x-1][s] * pow(2,c-1)
如果选择奇数个 x（这样的方案有 pow(2,c-1) 个），那么 s 变成 s XOR mask，其中 mask 是 x 的质因子分解中出现奇数次的质因子的集合，有
f[x][s XOR mask] += f[x-1][s] * pow(2,c-1)
注：转移方程是用刷表法思考的。
初始值 f[0][0] = 1。
答案为 f[70][0]。
代码实现时，可以用滚动数组优化空间。
https://codeforces.com/problemset/submission/895/249221937
======

Input
4
1 1 1 1
Output
15

Input
4
2 2 2 2
Output
7

Input
5
1 2 4 5 8
Output
7
 */
