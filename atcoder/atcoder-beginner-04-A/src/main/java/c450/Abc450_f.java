package c450;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Abc450_f {
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

    static final int mod = 998244353;
    static int[] l, r, sum, todo;

    static int mergeInfo(int a, int b) {
        return (a + b) % mod;
    }

    static final int todoInit = 1;

    static void apply(int o, int f) {
        sum[o] = (int) ((long) sum[o] * f % mod);
        todo[o] = (int) ((long) todo[o] * f % mod);
    }

    static void maintain(int o) {
        sum[o] = mergeInfo(sum[o << 1], sum[o << 1 | 1]);
    }

    static void spread(int o) {
        int f = todo[o];
        if (f == todoInit) return;
        apply(o << 1, f);
        apply(o << 1 | 1, f);
        todo[o] = todoInit;
    }

    static void build(int o, int lo, int hi) {
        l[o] = lo;
        r[o] = hi;
        todo[o] = todoInit;
        if (lo == hi) return;
        int m = (lo + hi) >> 1;
        build(o << 1, lo, m);
        build(o << 1 | 1, m + 1, hi);
    }

    static void set(int o, int i, int v) {
        if (l[o] == r[o]) {
            sum[o] = v;
            return;
        }
        spread(o);
        int m = (l[o] + r[o]) >> 1;
        if (i <= m) set(o << 1, i, v);
        else set(o << 1 | 1, i, v);
        maintain(o);
    }

    static void update(int o, int lo, int hi, int f) {
        if (lo <= l[o] && r[o] <= hi) {
            apply(o, f);
            return;
        }
        spread(o);
        int m = (l[o] + r[o]) >> 1;
        if (lo <= m) update(o << 1, lo, hi, f);
        if (m < hi) update(o << 1 | 1, lo, hi, f);
        maintain(o);
    }

    static int query(int o, int lo, int hi) {
        if (lo <= l[o] && r[o] <= hi) return sum[o];
        spread(o);
        int m = (l[o] + r[o]) >> 1;
        if (hi <= m) return query(o << 1, lo, hi);
        if (lo > m) return query(o << 1 | 1, lo, hi);
        return mergeInfo(query(o << 1, lo, hi), query(o << 1 | 1, lo, hi));
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[m][2];
        for (int i = 0; i < m; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        Arrays.sort(a, Comparator.comparingInt(x -> x[0]));
        int size = 2 << (32 - Integer.numberOfLeadingZeros(n - 1));
        l = new int[size];
        r = new int[size];
        sum = new int[size];
        todo = new int[size];
        build(1, 1, n);
        set(1, 1, 1);
        for (int[] p : a) {
            update(1, p[1], n, 2);
            set(1, p[1], query(1, p[0], p[1]));
        }
        out.println(query(1, n, n));
    }
}
/*
F - Strongly Connected 2
https://atcoder.jp/contests/abc450/tasks/abc450_f

灵茶の试炼 2026-06-05
题目大意：
输入 n(2≤n≤2e5) m(1≤m≤2e5) 表示一个 n 点 m+n-1 边的有向图。
然后输入 m 条边，每条边输入 x y(x<y)，表示一条有向边 x->y。节点编号从 1 到 n。
此外，图中还有 n-1 条有向边：n -> (n-1) -> (n-2) -> ... -> 2 -> 1。
从输入的 m 条边中，删除一些边，有 2^m 种删边方案。
其中有多少种方案，删边后，图仍然是强连通的？
答案模 998244353。

rating
考虑保留的边。
把边 [x,y] 视作闭区间 [L,R]，那么保留的区间的并集必须是 [1,n]。
区间合并的套路是，把区间按照左端点升序排序。原因见 LC56. 合并区间我的题解。
定义 f[i][j] 表示从前 i 个区间中选一些区间，覆盖 [1,j] 的方案数。
对于第 i 个区间 [L,R]，分类讨论：
· 对于 f[i][R], f[i][R+1], ..., f[i][n]，区间 [L,R] 完全在已覆盖的区间中，选不选都可以，问题变成从前 i-1 个区间中选一些区间，覆盖 [1,j] 的方案数，所以有
              f[i][j] = f[i-1][j] * 2 (j >= R)
· 对于 f[i][R]，区间 [L,R] 可以和 [1,L] 或者 [1,L+1] …… 或者 [1,R-1] 拼起来，覆盖区间 [1,R]，所以有
              f[i][R] += f[i-1][L] + f[i-1][L+1] + ... + f[i-1][R-1]
  注：[L,R] 和 [1,R] 拼起来的情况，已经在第一种情况中计算了。
初始值 f[0][1] = 1。
答案为 f[m][n]。
去掉 f 的第一个维度，用 Lazy 线段树维护区间乘以 2，区间求和，区间赋值。
代码 https://atcoder.jp/contests/abc450/submissions/76193852
======

Input 1
4 3
1 4
1 3
2 4
Output 1
5

Input 2
10 11
1 4
1 4
3 9
2 5
3 4
9 10
6 9
4 10
1 3
8 10
4 7
Output 2
1297
 */
