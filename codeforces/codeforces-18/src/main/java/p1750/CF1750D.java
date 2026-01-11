package p1750;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1750D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int MOD = 998244353;

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int pre = scanner.nextInt();
        long ans = 1;
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt();
            if (v == pre) {
                ans = ans * (m / v) % MOD;
                continue;
            }
            if (pre % v != 0) {
                ans = 0;
                continue;
            }

            int t = pre / v;
            List<Integer> ps = new ArrayList<>();
            for (int p = 2; p * p <= t; p++) {
                if (t % p != 0) continue;
                while (t % p == 0) {
                    t /= p;
                }
                ps.add(p);
            }
            if (t > 1) {
                ps.add(t);
            }

            // m := m / v
            int m_div_v = m / v;
            long res = 0;
            int len = ps.size();
            for (int mask = 0; mask < (1 << len); mask++) {
                int mul = 1;
                for (int j = mask; j > 0; j &= j - 1) {
                    mul *= ps.get(Integer.numberOfTrailingZeros(j));
                }
                int sign = (Integer.bitCount(mask) % 2 == 0) ? 1 : -1;
                res += sign * (m_div_v / mul);
            }
            ans = ans * (res % MOD + MOD) % MOD;
            pre = v;
        }
        out.println(ans);
    }
}
/*
D. Count GCD
https://codeforces.com/contest/1750/problem/D

灵茶の试炼 2025-10-29
题目大意：
输入 T(≤100) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) m(1≤m≤1e9) 和长为 n 的数组 a(1≤a[i]≤m)。
计算有多少个长为 n 的数组 b，元素范围 [1,m]，且 b 的前缀 gcd 数组恰好等于 a，即 gcd(b[1],b[2],...,b[i]) 恰好等于 a[i]（下标从 1 开始）。
答案模 998244353。

rating 1800
gcd 的性质是，参与 gcd 的元素越多，gcd 越小（或不变）。
所以 a 是非递增的（即递减，相邻元素可以相等）。如果不是非递增的，直接输出 -1。
如果 a[i-1] = a[i]，那么 b[i] 可以是任意 a[i] 的倍数，这有 m/a[i] 个，乘到答案中。
如果 a[i-1] > a[i] 呢？
例如 a[i-1] = 6，a[i] = 1。
6 = 2 * 3。
b[i] 不能是 2 的倍数（否则 gcd 等于 2 而不是 1），所以从 m 中减去 m/2。
b[i] 不能是 3 的倍数（否则 gcd 等于 3 而不是 1），所以从 m 中减去 m/3。
但 6 的倍数多减了一次，把 m/6 加回来。
所以 b[i] 的个数为 m-m/2-m/3+m/6，乘到答案中。
如果 a[i-1] = 12，a[i] = 2，那么 b[i] 只能选偶数，我们可以把该问题缩小至 a[i-1] = 6，a[i] = 1，但 b[i] 的范围变成 [1,m/2]。
一般地，计算 a[i-1]/a[i] 的质因子分解，然后用容斥原理计算在 [1,m/a[i]] 中的合法 b[i] 的个数。
时间复杂度：O(ω2^ω + sqrt(m)) 或者 O(2^ω + sqrt(m))，其中 ω = O(log m / log log m) 是 m 的不同质因子个数。在最坏情况下，把鸡蛋放同一个篮子里，即 a=[m,1,1,1,...] 是最慢的，质因子个数最多，计算容斥跑得最慢。
代码 https://codeforces.com/problemset/submission/1750/341512372
代码备份（上面打不开的同学看这个）
======

Input
5
3 5
4 2 1
2 1
1 1
5 50
2 3 5 2 3
4 1000000000
60 30 1 1
2 1000000000
1000000000 2
Output
3
1
0
595458194
200000000
 */
