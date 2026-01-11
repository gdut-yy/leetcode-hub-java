package p1470;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1470B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int mx = 1_000_001;
    static int[] core = new int[mx];

    static {
        for (int i = 1; i < mx; i++) {
            if (core[i] == 0) {
                for (int j = 1; i * j * j < mx; j++) {
                    core[i * j * j] = i;
                }
            }
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            cnt.merge(core[v], 1, Integer::sum);
        }

        int maxC = 0, c1 = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            int v = entry.getKey();
            int c = entry.getValue();
            maxC = Math.max(maxC, c);
            if (v == 1 || c % 2 == 0) {
                c1 += c;
            }
        }

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            long w = scanner.nextLong();
            if (w > 0) {
                out.println(Math.max(maxC, c1));
            } else {
                out.println(maxC);
            }
        }
    }
}
/*
B. Strange Definition
https://codeforces.com/contest/1470/problem/B

灵茶の试炼 2025-10-16
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤3e5，q 之和 ≤3e5。
每组数据输入 n(1≤n≤3e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。
然后输入 q(1≤q≤3e5) 和 q 个询问。
每个询问输入 w(0≤w≤1e18)。
如果 lcm(x,y) / gcd(x,y) 是完全平方数，那么称 x 与 y 相邻。
每过一秒，所有 a[i] 同时被替换成 a 中所有与 a[i] 相邻的数的乘积（包括 a[i]）。
定义 d[i] 为与 a[i] 相邻的元素个数（包括 a[i]）。
对于每个询问，输出 w 秒后，max(d) 的值。每个询问互相独立。

rating 1900
由于 lcm(x,y) = x*y/gcd(x,y)，
所以 x*y / gcd(x,y)^2 = k^2，
即 x*y = (gcd(x,y)*k)^2，
所以 x*y 是完全平方数。
根据上场周赛第四题我题解中的结论，这相当于 core(x) = core(y)。
分类讨论：
如果 a 中有偶数个数的 core 都等于 v，那么一秒后，v^count(v) 是完全平方数，所以这些数的 core 都变成 1。
如果 a 中有奇数个数的 core 都等于 v，那么一秒后，v^count(v) 是完全平方数乘以 v，所以这些数的 core 不变。
所以我们只需关心 w 是等于 0 还是大于 0。
如果 w=0，那么答案为出现次数最多的那个 core 的出现次数 maxC。
否则，统计 core=1 的个数，以及其余出现次数为偶数的 core 的出现次数，累加，得到 c1。答案为 max(maxC, c1)。
代码 https://codeforces.com/problemset/submission/1470/343547459
代码备份（上面打不开的同学看这个）
======

Input
2
4
6 8 4 2
1
0
6
12 3 20 5 80 1
1
1
Output
2
3
 */
