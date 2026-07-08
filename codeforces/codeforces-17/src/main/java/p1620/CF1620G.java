package p1620;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1620G {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int MOD = 998244353;

    private static void tle() {
        int n = scanner.nextInt();
        int[][] cnt = new int[n][26];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < s.length(); j++) {
                cnt[i][s.charAt(j) - 'a']++;
            }
        }
        int[] f = new int[1 << n];
        int[] mn = new int[26];
        for (int mask = 1; mask < 1 << n; mask++) {
            Arrays.fill(mn, Integer.MAX_VALUE);
            for (int m = mask; m > 0; m &= m - 1) {
                int idx = Integer.numberOfTrailingZeros(m);
                for (int i = 0; i < 26; i++) {
                    mn[i] = Math.min(mn[i], cnt[idx][i]);
                }
            }
            int res = (Integer.bitCount(mask) % 2 * 2 - 1 + MOD) % MOD;
            for (int i = 0; i < 26; i++) {
                res = (int) ((long) res * (mn[i] + 1) % MOD);
            }
            f[mask] = res;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1 << n; j++) {
                j |= 1 << i;
                f[j] = (f[j] + f[j ^ (1 << i)]) % MOD;
            }
        }
        long ans = 0;
        for (int mask = 0; mask < 1 << n; mask++) {
            int v = f[mask];
            int sum = 0;
            for (int m = mask; m > 0; m &= m - 1) {
                sum += Integer.numberOfTrailingZeros(m);
            }
            int k = Integer.bitCount(mask);
            ans ^= (long) v * k * (sum + k);
        }
        out.println(ans);
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[][] cnt = new int[n][26];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < s.length(); j++) {
                cnt[i][s.charAt(j) - 'a']++;
            }
        }
        int size = 1 << n;
        int[] f = new int[size];
        Arrays.fill(f, 1);
        int[] mn = new int[size];
        mn[0] = Integer.MAX_VALUE;
        for (int c = 0; c < 26; c++) {
            boolean any = false;
            for (int i = 0; i < n; i++) {
                if (cnt[i][c] > 0) {
                    any = true;
                    break;
                }
            }
            if (!any) continue;
            for (int mask = 1; mask < size; mask++) {
                int lb = mask & -mask;
                mn[mask] = Math.min(mn[mask ^ lb], cnt[Integer.numberOfTrailingZeros(lb)][c]);
                f[mask] = (int) ((long) f[mask] * (mn[mask] + 1) % MOD);
            }
        }
        f[0] = 0;
        for (int mask = 1; mask < size; mask++) {
            if (Integer.bitCount(mask) % 2 == 0) {
                f[mask] = (MOD - f[mask]) % MOD;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < size; j++) {
                j |= 1 << i;
                f[j] += f[j ^ (1 << i)];
                if (f[j] >= MOD) f[j] -= MOD;
            }
        }
        mn[0] = 0;
        for (int mask = 1; mask < size; mask++) {
            mn[mask] = mn[mask & (mask - 1)] + Integer.numberOfTrailingZeros(mask);
        }
        long ans = 0;
        for (int mask = 1; mask < size; mask++) {
            int k = Integer.bitCount(mask);
            ans ^= (long) f[mask] * k * (mn[mask] + k);
        }
        out.println(ans);
    }
}
/*
G. Subsequences Galore
https://codeforces.com/contest/1620/problem/G

灵茶の试炼 2025-11-28
题目大意：
输入 n(1≤n≤23) 和长为 n 的字符串数组 a，每个 a[i] 的长度 ≤2e4，只包含小写英文字母。
保证每个 a[i] 都是升序，例如 a[i] = aaabbccc...
对于字符串数组 b，定义 f(b) 为不同字符串（包括空串）的数量，这些字符串都至少是其中一个 b[i] 的子序列。
特别地，f([]) = 0。
a 有 2^n 个子序列 b，计算这 2^n 个 f(b) % 998244353。
由于输出 2^n 个数太慢了，你只需输出 (f(b) % 998244353) * len(b) * sum(index(b)) 的异或和。
其中 index(b) 是一个长为 len(b) 的列表，表示 b 中元素在 a 中的下标（下标从 1 开始）。

rating 2400
「至少是其中一个字符串的子序列」，比如有两个字符串 s 和 t，我们有如下三种情况：
是 s 的子序列；
是 t 的子序列；
是 s 和 t 的子序列。
根据容斥原理，是 s 或 t 的子序列的个数 = 是 s 的子序列的个数 + 是 t 的子序列的个数 - 是 s 和 t 的子序列的个数。（类似并集与交集的关系）
这可以推广到一般情况，根据容斥原理计算。
现在问题变成：同时是多个字符串的子序列的不同个数。
先思考一个简单的问题：计算单个字符串 s 的不同子序列的个数。
由于题目保证 s 是升序，那么子序列也必须是升序。
两个子序列
子序列有多少个 a？有多少个 b？……多少个 z？
比如 s 中有 3 个 a，那么子序列可以有 0,1,2,3 个 a，有 4 种选法，或者说字母个数加一种选法。
每种字母选多少个互相独立，根据乘法原理，把每种字母的出现次加一再相乘，就是不同子序列的个数。
对于同时是多个字符串的情况，把每种字母的出现次数取最小值，再按照上式计算，得到不同子序列的个数 ways。
根据容斥原理，总的方案数为 f(b) = ∑_c (-1)^(|c|+1) * ways(c)，其中 c 是 b 的子集，|c| 表示 c 的大小。
对于这 2^n 个子序列 b，如果每个都按照上式计算，光是枚举子集的子集，复杂度就要 O(3^n)，太慢了。
注意到，容斥原理的式子正好符合 SOS DP。
定义 g(c) = (-1)^(|c|+1) * ways(c)。
那么 f(b) 就是 ∑_{c⊆b} g(c)，符合 SOS DP 模型。
于是枚举 a 的子序列 b，把 dp[b] = g(b) 作为 DP 初始值，然后计算 SOS DP。
计算完毕后，dp[b] 就是 f(b)。
小结：「容斥原理 + 枚举子集的子集」有大量重复计算，通过 SOS DP 可以把枚举这块从 O(3^n) 降至 O(n*2^n)。
代码 https://codeforces.com/problemset/submission/1620/350673744
代码备份（上面打不开的同学看这个）
======

Input
3
a
b
c
Output
92

Input
2
aa
a
Output
21

Input
2
a
a
Output
10

Input
2
abcd
aabb
Output
124

Input
3
ddd
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
aaaaaaaabbbbbbbbbbbcccccccccccciiiiiiiiiiiiiiiiiiiiiiooooooooooqqqqqqqqqqqqqqqqqqvvvvvzzzzzzzzzzzz
Output
15706243380

23
lpvvwxxx
bdefrx
abeegnovvw
hnoxx
dhp
inqstuyz
cdfnssty
bcky
hksty
efghkrr
ceehkmnoop
f
hhkmrstvvy
bbbfgltyzz
bgkrs
adfhimprxz
chrw
mmortwww
ddiuyzz
ffjqt
gppqryy
crtwyz
dqy

6657984
 */
