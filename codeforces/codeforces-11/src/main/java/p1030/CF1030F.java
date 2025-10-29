package p1030;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1030F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt() - i;
        }

        long[] w = new long[n + 1];
        BIT fw = new BIT(n + 1);
        BIT fwa = new BIT(n + 1);
        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
            fw.add(i, w[i]);
            fwa.add(i, w[i] * a[i] % MOD);
        }

        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (l < 0) {
                l = -l;
                long d = r - w[l];
                w[l] = r;
                fw.add(l, d);
                fwa.add(l, d * a[l] % MOD);
            } else {
                int m = fw.kth((fw.pre(l - 1) + fw.pre(r) + 1) / 2);
                long x = a[m];
                long ans = fw.query(l, m) % MOD * x - fwa.query(l, m) +
                        fwa.query(m, r) - fw.query(m, r) % MOD * x;
                ans = (ans % MOD + MOD) % MOD;
                out.println(ans);
            }
        }
    }

    static class BIT {
        int n;
        long[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, long val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        long pre(int pos) {
            long ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }

        long query(int l, int r) {
            return pre(r) - pre(l - 1);
        }

        int kth(long k) {
            int res = 0;
            for (int b = 1 << 17; b > 0; b >>= 1) {
                int nxt = res | b;
                if (nxt <= n && tree[nxt] < k) {
                    k -= tree[nxt];
                    res = nxt;
                }
            }
            return res + 1;
        }
    }
}
/*
F. Putting Boxes Together
https://codeforces.com/contest/1030/problem/F

灵茶の试炼 2025-08-08
题目大意：
输入 n(1≤n≤2e5) q(1≤q≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，长为 n 的数组 w(1≤w[i]≤1e9)。
保证 a 是严格递增数组。
数轴上有 n 个物品，第 i 个物品的位置是 a[i]，权重为 w[i]。
定义 f(L,R) 表示把下标 [L,R] 中的物品排在一起且位置连续的最小带权距离和。
比如三个物品的位置分别为 1,3,7，若把物品分别移动到 4,5,6，则带权距离和为 |4-1|*w[1] + |5-3|*w[2] + |6-7|*w[3]。
然后输入 q 个询问，每个询问包含两个数，格式如下：
"i newW"：把 w[i] 改成 newW(1≤newW[i]≤1e9)。数组下标从 1 到 n。
"L R"：输出 f(L,R) % (1e9+7)。其中 1≤L≤R≤n。
用输入的第一个数区分这两种询问：
如果第一个数是负数，表示第一种询问。把第一个数取反，就是正确的 i。
如果第一个数是正数，表示第二种询问。

rating 2500
推荐先完成本题的简单版本 LC2448. 使数组相等的最小开销。
本文接着我题解的方法二讲解，请先阅读我的题解。
题目要求位置是连续的，对于移动后的任意两个位置 a[i] 和 a[j]，满足 a[j] - a[i] = j - i。
移项得 a[j] - j = a[i] - i。
于是，在计算之前，先把 a[i] -= i，问题就变成把物品移到同一个位置的最小带权距离和了，这是标准的带权中位数贪心。
计算区间中位数的位置，需要计算区间 w[i] 之和，记作 s，这可以用树状数组 fw 维护。
那么中位数的位置 i 需要满足 w[l] + ... + w[i] >= ceil(s / 2)。
为了计算 i，需要在树状数组 fw 上二分 ceil(s / 2) + (w[1] + w[2] + ... + w[l-1]) 的位置。
树状数组二分可以做到 O(log n)，类似倍增的查询过程，见 [OI-WIKI](https://oi-wiki.org/ds/fenwick/#%E5%8D%95%E7%82%B9%E4%BF%AE%E6%94%B9%E6%9F%A5%E8%AF%A2%E5%85%A8%E5%B1%80%E7%AC%AC-k-%E5%B0%8F)
对于 i 左边的物品 a[j]，代价为
  w[j] * (a[i] - a[j])
= w[j] * a[i] - w[j] * a[j]
所以还需要一棵树状数组 fwa，专门维护区间 w[j] * a[j] 的和。
对于 i 右边的物品 a[j]，代价为
  w[j] * (a[j] - a[i])
= w[j] * a[j] - w[j] * a[i]
计算方式同上。
注：前文中的 s = fw.pre(r) - fw.pre(l-1)。
所以 ceil(s / 2) + (w[1] + w[2] + ... + w[l-1])
= floor((fw.pre(r) - fw.pre(l-1) + 1) / 2) + pre(l-1)
= floor((fw.pre(r) + fw.pre(l-1) + 1) / 2)。
注意 fw 不能取模。
由于 w 的区间和是一个 1e18 量级的数，在计算乘法前，要先把区间和取模。
注意有减法，答案可能是负数，需要调整为非负数。
代码 https://codeforces.com/contest/1030/submission/329028373
代码备份（Ubuntu Pastebin）
======

Input
5 8
1 2 6 7 10
1 1 1 1 2
1 1
1 5
1 3
3 5
-3 5
-1 10
1 4
2 5
Output
0
10
3
4
18
7
 */
