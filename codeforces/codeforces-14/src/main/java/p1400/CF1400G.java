package p1400;

import java.util.Scanner;

public class CF1400G {
    static int n, m;
    static int[][] a; // l, r
    static int[] diff;
    static int[][] ban; // x, y

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        // 读入+计算差分
        a = new int[n + 1][2];
        diff = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
            diff[a[i][0]]++;
            diff[a[i][1] + 1]--;
        }
        ban = new int[m][2];
        for (int i = 0; i < m; i++) {
            ban[i][0] = scanner.nextInt();
            ban[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        // 计算前缀和
        long[][] sum = new long[n + 1][41];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += diff[i];
            for (int j = 0; j < 41; j++) {
                sum[i][j] = (sum[i - 1][j] + comb(cnt - j, i - j)) % MOD;
            }
        }

        // 容斥
        long ans = sum[n][0];
        int[] has = new int[n + 1];
        for (int i = 1; i < 1 << m; i++) {
            int l = 1, r = n, k = 0;
            for (int j = i; j > 0; j &= j - 1) {
                int[] p = ban[Integer.numberOfTrailingZeros(j)];
                // 计算区间交集
                l = Math.max(l, Math.max(a[p[0]][0], a[p[1]][0]));
                r = Math.min(r, Math.min(a[p[0]][1], a[p[1]][1]));
                // 计算有多少个人
                if (has[p[0]] != i) {
                    has[p[0]] = i; // 时间戳，这样可以避免使用哈希表
                    k++;
                }
                if (has[p[1]] != i) {
                    has[p[1]] = i;
                    k++;
                }
            }
            if (r < l) {
                continue;
            }
            long res = sum[r][k] - sum[l - 1][k];
            if (Integer.bitCount(i) % 2 > 0) {
                res = -res;
            }
            ans += res;
        }
        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }

    static int MOD = (int) 998244353, MX = (int) 3e5 + 5;
    static long[] F = new long[MX + 1], invF = new long[MX + 1];

    static {
        F[0] = F[1] = invF[0] = invF[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i % MOD;
        invF[MX] = quickPow(F[MX], MOD - 2);
        for (int i = MX - 1; i >= 2; i--) invF[i] = invF[i + 1] * (i + 1) % MOD;
    }

    static long comb(int n, int m) {
        if (n < m || m < 0) return 0;
        return F[n] * invF[n - m] % MOD * invF[m] % MOD;
    }

    static long quickPow(long a, long b) {
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
G. Mercenaries
https://codeforces.com/contest/1400/problem/G

灵茶の试炼 2024-06-21
题目大意：
输入 n(1≤n≤3e5) 和 m(0≤m≤min(20,n*(n-1)/2))。
解释：有 n 个雇佣兵，从中选择一些人（至少一个人），组成一支部队。m 的含义见下。
然后输入 n 个闭区间的左右端点 [Li,Ri]，范围 [1,n]。
解释：如果选了第 i 位雇佣兵，那么部队的人数必须在闭区间 [Li,Ri] 中。
最后输入 m 对数字 (ai, bi)，满足 1≤ai<bi≤n。
解释：这 m 对雇佣兵相互憎恨，如果选了第 ai 位雇佣兵，那么不能选第 bi 位雇佣兵，反之亦然。
输出有多少种选法，模 998244353。

rating 2600
如果 m=0，要怎么做？
枚举部队人数 i=1,2,...,n，对于固定的 i，有多少种选法？
我们需要知道有多少个闭区间包含 i。
对于每个区间 [L,R]，把 [L,R] 内的数都加一。这可以用差分数组解决。
计算差分数组的前缀和，得到 cnt 数组，也就是有 cnt[i] 个区间包含 i，那么选法就是 C(cnt[i],i)。
所以 m=0 的时候，一共有
    ∑C(cnt[i],i)
种选法，其中 i=1,2,...,n。
回到原问题。
考虑容斥。
从不考虑 m 对约束的方案数中，减去不合法的方案数（选了 m 对约束中的）。
这可以用子集容斥计算。
枚举 m 对约束的子集，假设子集中有 j 个人，相当于这 j 个人一定要选，那么选法就是
    ∑C(cnt[i]-j,i-j)
其中 i=p,p+1,...,q，其中 p 和 q 是这 j 个人对应区间的交集的左右端点。
如何高效地计算上述和式？
由于 m 至多 20，所以 j 至多 40。
对 0~40 这 41 个不同的 j，计算 C(cnt[i]-j,i-j) 的前缀和。
组合数可以通过预处理阶乘及其逆元快速计算。
记得取模：组合数取模，前缀和取模，最后返回的答案要保证是非负数（因为容斥里面有负数）。
代码+注释 https://codeforces.com/contest/1400/submission/266578396
这题 7s 时限给的是不是太多了点
======

Input
3 0
1 1
2 3
1 3
Output
3

Input
3 1
1 1
2 3
1 3
2 3
Output
2
 */
