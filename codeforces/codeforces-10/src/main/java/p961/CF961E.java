package p961;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF961E {
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

    static int[] lo, ro, cnt;
    static int idx;

    static int newNode() {
        int o = idx++;
        lo[o] = ro[o] = cnt[o] = 0;
        return o;
    }

    static int build(int l, int r) {
        int o = newNode();
        if (l == r) return o;
        int m = (l + r) >> 1;
        lo[o] = build(l, m);
        ro[o] = build(m + 1, r);
        return o;
    }

    static int update(int o, int l, int r, int i) {
        int p = newNode();
        cnt[p] = cnt[o];
        lo[p] = lo[o];
        ro[p] = ro[o];
        if (l == r) {
            cnt[p]++;
            return p;
        }
        int m = (l + r) >> 1;
        if (i <= m) {
            lo[p] = update(lo[o], l, m, i);
        } else {
            ro[p] = update(ro[o], m + 1, r, i);
        }
        cnt[p] = cnt[lo[p]] + cnt[ro[p]];
        return p;
    }

    static int query(int o, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) return cnt[o];
        int m = (l + r) >> 1;
        if (qr <= m) return query(lo[o], l, m, ql, qr);
        if (m < ql) return query(ro[o], m + 1, r, ql, qr);
        return query(lo[o], l, m, ql, qr) + query(ro[o], m + 1, r, ql, qr);
    }

    private static void solve() {
        int n = scanner.nextInt();
        int maxNodes = 22 * (n + 2);
        lo = new int[maxNodes];
        ro = new int[maxNodes];
        cnt = new int[maxNodes];
        idx = 0;
        int[] t = new int[n + 1];
        t[0] = build(0, n);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            int r = Math.min(v, i);
            ans += r - query(t[r], 0, n, 0, i);
            t[i + 1] = update(t[i], 0, n, Math.min(v, n));
        }
        out.println(ans);
    }
}
/*
E. Tufurama
https://codeforces.com/contest/961/problem/E

灵茶の试炼 2025-12-03
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
某电视剧有 n 季，第 i 季有 a[i] 集。i 从 1 开始。
输出有多少对 (x,y) 满足 1≤x<y≤n，且同时存在第 x 季第 y 集和第 y 季第 x 集。
进阶：一边读入，一边计算答案。

rating 1900
注：本题可以离线，但这里用可持久化线段树练练手，实现一边读入，一边计算答案。
枚举右，维护左。
比如枚举到 y=5，且 a[5]=2，即存在第 5 季第 1 集和第 5 季第 2 集，我们需要知道是否存在第 1 季第 5 集和第 2 季第 5 集。
换句话说，我们需要知道在 x∈[1,2] 中有多少个 a[x] >= 5。
如果 a[5]=100，我们只需考虑 x∈[1,4] 中有多少个 a[x] >= 5。
一般地，枚举 y，我们需要计算 x∈[1,min(a[y],y-1)] 中有多少个 a[x] >= y。
这可以用可持久化值域线段树解决。对于前缀 [1,min(a[y],y-1)] 的值域线段树，计算值域 [y,inf] 中的元素个数。
注意本题无需离散化，因为在比大小（a[x] >= y）的时候，最多和 y = n 比大小，我们可以把大于 n 的数视作 n。
代码 https://codeforces.com/contest/961/submission/351429313
代码备份（上面打不开的同学看这个）
======

Input
5
1 2 3 4 5
Output
0

Input
3
8 12 7
Output
3

Input
3
3 2 1
Output
2
 */
