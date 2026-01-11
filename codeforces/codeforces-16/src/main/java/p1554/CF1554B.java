package p1554;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1554B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static class Pair {
        int mx, m2;

        Pair(int mx, int m2) {
            this.mx = mx;
            this.m2 = m2;
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int mx = Integer.toBinaryString(n).length();
        Pair[] f = new Pair[1 << mx];
        for (int i = 0; i < f.length; i++) {
            f[i] = new Pair(0, 0);
        }

        for (int i = 1; i <= n; i++) {
            int v = scanner.nextInt();
            f[v] = new Pair(i, f[v].mx);
        }

        for (int i = 0; i < mx; i++) {
            for (int s = 0; s < (1 << mx); s++) {
                s |= 1 << i;
                Pair p = f[s];
                Pair q = f[s ^ (1 << i)];
                if (q.mx > p.mx) {
                    p.m2 = Math.max(p.mx, q.m2);
                    p.mx = q.mx;
                } else if (q.mx > p.m2) {
                    p.m2 = q.mx;
                }
                f[s] = p;
            }
        }

        long ans = (long) -1e18;
        for (int s = 0; s < f.length; s++) {
            Pair p = f[s];
            if (p.m2 > 0) {
                ans = Math.max(ans, (long) p.mx * p.m2 - (long) k * s);
            }
        }
        out.println(ans);
    }
}
/*
B. Cobb
https://codeforces.com/contest/1554/problem/B

灵茶の试炼 2025-11-26
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(2≤n≤1e5) k(1≤k≤min(n,100)) 和长为 n 的数组 a(0≤a[i]≤n)。
输出 i * j - k * (a[i] OR a[j]) 的最大值，其中 i < j。
进阶：做到与 k 无关的时间复杂度。

rating 1700
与 k 无关的做法。
考虑枚举 a[i] OR a[j] 的值 S。
当 S 固定时，为了最大化 i * j - k * S，i 和 j 越大越好。
我们需要找最大的两个下标 i 和 j，满足 a[i] OR a[j] = S。
考虑 SOS DP，f[S] 是一个 pair，表示二进制是 S 的子集的元素中，最大的两个下标。
你可能会问：但这两个元素只是 S 的子集，OR 可能小于 S 呀？
这没关系，因为我们是减去 k * S，如果 S 比 a[i] OR a[j] 还大，那么必然不优。
换句话说，最优解一定对应着 a[i] OR a[j] = S。
初始值：f[x] = a 中等于 x 的最大的两个下标。如果不存在，初始化成 0（a 的下标从 1 开始）。
关于 SOS DP 的原理，请看 我的题解 的方法二。
代码 https://codeforces.com/contest/1554/submission/331434843
代码备份（上面打不开的同学看这个）
======

Input
4
3 3
1 1 3
2 2
1 2
4 3
0 1 2 3
6 6
3 2 0 0 5 6
Output
-1
-4
3
12
 */
