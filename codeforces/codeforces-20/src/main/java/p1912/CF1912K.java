package p1912;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1912K {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) V2.solve();
        out.flush();
    }

    private static final int MOD = 998244353;

    static class V1 {
        private static void solve() {
            int n = scanner.nextInt();
            int[] cnt = new int[2];
            int[] cnt2 = new int[4];
            long[] f = new long[4];
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt() % 2;
                if (v == 0) {
                    f[0] = (f[0] * 2 % MOD + cnt2[0]) % MOD;
                    f[2] = (f[2] + f[3] + cnt2[3]) % MOD;
                } else {
                    f[3] = (f[3] + f[1] + cnt2[1]) % MOD;
                    f[1] = (f[1] + f[2] + cnt2[2]) % MOD;
                }
                cnt2[v] = (cnt2[v] + cnt[0]) % MOD;
                cnt2[2 | v] = (cnt2[2 | v] + cnt[1]) % MOD;
                cnt[v]++;
            }
            long ans = (f[0] + f[1] + f[2] + f[3]) % MOD;
            out.println(ans);
        }
    }

    static class V2 {
        private static void solve() {
            int n = scanner.nextInt();
            long[] cnt = new long[2];
            long[] cnt2 = new long[4];
            long[] f = new long[4];
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt() % 2;
                f[2 | v] = (f[2 | v] + f[(v ^ 1) << 1 | 1] + cnt2[(v ^ 1) << 1 | 1]) % MOD;
                f[v] = (f[v] + f[v << 1] + cnt2[v << 1]) % MOD;
                cnt2[2 | v] = (cnt2[2 | v] + cnt[1]) % MOD;
                cnt2[v] = (cnt2[v] + cnt[0]) % MOD;
                cnt[v]++;
            }
            long ans = (f[0] + f[1] + f[2] + f[3]) % MOD;
            out.print(ans);
        }
    }
}
/*
K. Kim's Quest
https://codeforces.com/contest/1912/problem/K

灵茶の试炼 2025-12-10
题目大意：
输入 n(3≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤2e5)。
输出 a 有多少个长度至少为 3 的子序列 b，满足任意连续三个数之和 b[i]+b[i+1]+b[i+2] 一定是偶数。
答案模 998244353。
注：子序列不一定连续。

rating 1800
连续三数之和为偶数，一共四种情况：
偶偶偶
偶奇奇
奇偶奇
奇奇偶
比如最后两个数都是奇数，那么倒数第三个数一定是偶数。或者说，去掉最后一个奇数，末尾两个数是偶数和奇数。
定义 f[i][mask] 表示从前 i 个数中选合法子序列，且子序列最后两个数的奇偶性组成了 mask 的方案数。
通过转移来源限定倒数第三个数的值。
如果 mask = 00（表示最后两个数都是偶数），那么从 f[i-1][00] 转移过来，或者从长为 2 的 00 子序列转移过来。
如果 mask = 11（表示最后两个数都是奇数），那么从 f[i-1][01] 转移过来，或者从长为 2 的 01 子序列转移过来。
如果 mask = 01（表示最后两个数都是偶奇），那么从 f[i-1][10] 转移过来，或者从长为 2 的 10 子序列转移过来。
如果 mask = 10（表示最后两个数都是奇偶），那么从 f[i-1][11] 转移过来，或者从长为 2 的 11 子序列转移过来。
长为 2 的 00 子序列，可以在一个 0 的后面加个 0 得到。设前面有 cnt[0] 个 0，那么有 cnt2[00] += cnt[0]，下同。
长为 2 的 01 子序列，可以在一个 0 的后面加个 1 得到。
长为 2 的 10 子序列，可以在一个 1 的后面加个 0 得到。
长为 2 的 11 子序列，可以在一个 1 的后面加个 1 得到。
答案为 sum(f[n])。
代码实现时，f 的第一个维度可以优化掉。
注意状态更新的顺序，不要提前覆盖。
写法一 https://codeforces.com/contest/1912/submission/349798863
写法二（无 if else） https://codeforces.com/contest/1912/submission/349801628
代码备份（上面打不开的同学看这个）
======

Input
3
1 2 3
Output
1

Input
5
2 8 2 6 4
Output
16

Input
5
5 7 1 3 5
Output
0

Input
11
3 1 4 1 5 9 2 6 5 3 6
Output
386

Input
54
2 1 1 1 1 2 1 2 2 2 2 1 1 1 2 1 1 2
2 1 2 2 2 2 2 2 2 1 1 1 2 2 1 1 1 1
2 2 1 1 2 2 2 2 2 1 1 1 2 2 1 2 1 1
Output
0
 */