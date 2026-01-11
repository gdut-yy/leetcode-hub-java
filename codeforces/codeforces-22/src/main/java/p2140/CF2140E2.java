package p2140;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2140E2 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = scanner.nextInt() - 1;
        }

        // 动态规划数组，使用boolean代替byte
        boolean[] f = new boolean[1 << n];
        f[1] = true;

        for (int sz = 2; sz <= n; sz++) {
            if ((n - sz) % 2 == 0) {
                for (int mask = (1 << sz) - 1; mask > 0; mask--) {
                    boolean found = false;
                    for (int i : a) {
                        if (i >= sz) break;
                        int newMask = (mask >> (i + 1)) << i | (mask & ((1 << i) - 1));
                        if (f[newMask]) {
                            f[mask] = true;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        f[mask] = false;
                    }
                }
            } else {
                for (int mask = (1 << sz) - 1; mask > 0; mask--) {
                    boolean allTrue = true;
                    for (int i : a) {
                        if (i >= sz) break;
                        int newMask = (mask >> (i + 1)) << i | (mask & ((1 << i) - 1));
                        if (!f[newMask]) {
                            allTrue = false;
                            break;
                        }
                    }
                    f[mask] = allTrue;
                }
            }
        }

        // 统计每个大小的mask的计数
        int[] cnt = new int[n + 1];
        for (int mask = 0; mask < (1 << n); mask++) {
            if (f[mask]) {
                cnt[Integer.bitCount(mask)]++;
            }
        }

        long ans = 0;
        for (int i = 0; i <= n; i++) {
            if (cnt[i] == 0) continue;
            long s = 0;
            for (int low = 1; low <= m; low++) {
                long term1 = quickPow(m - low + 1, i);
                long term2 = quickPow(low - 1, n - i);
                s = (s + term1 * term2 % MOD) % MOD;
            }
            ans = (ans + s * cnt[i] % MOD) % MOD;
        }
        out.println(ans % MOD);
    }

    static final int MOD = (int) (1e9 + 7);

    // 快速幂 res = a^b % mod
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
E2. Prime Gaming (Hard Version)
https://codeforces.com/contest/2140/problem/E2

灵茶の试炼 2025-12-19
题目大意：
这是该问题的困难版本。唯一的区别是本题 m≤1e6。
输入 T(≤1e4) 表示 T 组数据。所有数据的 2^n 之和 ≤2^20，所有数据的 m 之和 ≤1e6。
每组数据输入 n(1≤n≤20) m(1≤m≤2) k(1≤k≤n) 和长为 k 的严格递增数组 c(1≤c[i]≤n)，保证 c 的第一个数是 1。
一开始，有一个长为 n 的数组 a，下标从 1 开始。
Alice 和 Bob 玩游戏，Alice 先手：
每回合，当前玩家从 c 中选择一个 i（不超过 a 的长度），然后从 a 中移除 a[i]。
当 a 中只剩一个数时，游戏结束。
令 x 为最后 a 中剩下的数。Alice 希望最大化最终的 x，Bob 则希望最小化。两名玩家均采取最优策略。
你可以设定一开始的数组 a，要求 1≤a[i]≤m。
这一共有 m^n 种方案，每种方案可以得到一个 x。
输出这 m^n 个 x 之和，模 1e9+7。

rating 2500
请先完成昨天的题目。
本题要计算的内容，列个式子
1 * #final(=1) + 2 * #final(=2) + 3 * #final(=3) + ... + m * #final(=m)
其中 #final(=x) 表示最终剩下的石子个数恰好等于 x 的方案数。
横看成岭侧成峰，上式等价于
#final(>=1) + #final(>=2) + #final(>=3) + ... + #final(>=m)
其中 #final(>=x) 表示最终剩下的石子个数 >=x 的方案数。
注：这个技巧常用于期望题。
枚举 x。
对于固定的 x，枚举每堆石子是 <x 还是 >=x，我们可以得到一个 01 序列（二进制数）mask。
这个 01 序列最终是 0 还是 1，就是昨天的题目我们算的 DP。如果 DP 值是 false，表示最终 <x；如果 DP 值是 true，表示最终 >=x。
本题我们算的是 #final(>=x)，所以只需关注 f[n][mask] 为 true 的 mask。
比如 01 序列为 11010，且 f[n][11010] 为 true，那么：
其中有 3 个 1，表示要有恰好 3 个位置填 [x,m] 中的数，方案数为 pow(m-x+1,3)。
其中有 2 个 0，表示要有恰好 2 个位置填 [1,x-1] 中的数，方案数为 pow(x-1,2)。
根据乘法原理，二者相乘，就是 x=11010 的 #final(>=x)，即 pow(m-x+1,3) * pow(x-1,2)。
如果对每个 x 都去枚举 f[n] 中的 mask，就太慢了。
由于 pow(m-x+1,3) * pow(x-1,2) 中的 3，只与 mask 的二进制中的 1 的个数有关，
所以我们可以按照 f[n][mask] 中的 mask 中的 1 的个数分组，把 1 的个数相同且 f[n][mask] 为 true 的个数算出回来，用这个个数乘以上面的 pow(...) * pow(...) 的式子。其中 0 的个数等于 n 减去 1 的个数。
枚举不同的 1 的个数，计算式子，累加，就得到了 #final(>=x)。
枚举 x，累加 #final(>=x)，即为答案。
代码 https://codeforces.com/contest/2140/submission/349371967
代码备份（上面打不开的同学看这个）
======

Input
5
2 3
1
1
7 4
3
1 4 6
12 31
6
1 3 5 7 9 11
11 121
11
1 2 3 4 5 6 7 8 9 10 11
19 6969
2
1 19
Output
18
33664
909076242
683044824
901058932
 */
