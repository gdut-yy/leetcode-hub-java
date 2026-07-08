package c346;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc346_g {
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

    static int[] min, minCnt, todo;

    static void maintain(int o) {
        int lo = o << 1, ro = o << 1 | 1;
        int mn = Math.min(min[lo], min[ro]);
        min[o] = mn;
        minCnt[o] = 0;
        if (min[lo] == mn) minCnt[o] = minCnt[lo];
        if (min[ro] == mn) minCnt[o] += minCnt[ro];
    }

    static void apply(int o, int f) {
        min[o] += f;
        todo[o] += f;
    }

    static void build(int o, int l, int r) {
        minCnt[o] = r - l + 1;
        if (l == r) return;
        int m = (l + r) >> 1;
        build(o << 1, l, m);
        build(o << 1 | 1, m + 1, r);
    }

    static void spread(int o) {
        int f = todo[o];
        if (f == 0) return;
        apply(o << 1, f);
        apply(o << 1 | 1, f);
        todo[o] = 0;
    }

    static void update(int o, int l, int r, int ql, int qr, int v) {
        if (ql <= l && r <= qr) {
            apply(o, v);
            return;
        }
        spread(o);
        int m = (l + r) >> 1;
        if (ql <= m) update(o << 1, l, m, ql, qr, v);
        if (m < qr) update(o << 1 | 1, m + 1, r, ql, qr, v);
        maintain(o);
    }

    static int query(int o, int l, int r, int qr) {
        if (r <= qr) {
            if (min[o] == 0) return minCnt[o];
            return 0;
        }
        spread(o);
        int m = (l + r) >> 1;
        if (qr <= m) return query(o << 1, l, m, qr);
        return query(o << 1, l, m, qr) + query(o << 1 | 1, m + 1, r, qr);
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] last = new int[n + 1];
        int[] last2 = new int[n + 1];
        int size = 4 * n + 5;
        min = new int[size];
        minCnt = new int[size];
        todo = new int[size];
        build(1, 1, n);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int v = scanner.nextInt();
            int j = last[v];
            if (j > 0) {
                update(1, 1, n, last2[v] + 1, j, -1);
            }
            update(1, 1, n, j + 1, i, 1);
            ans += i - query(1, 1, n, i);
            last2[v] = j;
            last[v] = i;
        }
        out.println(ans);
    }
}
/*
G - Alone
https://atcoder.jp/contests/abc346/tasks/abc346_g

灵茶の试炼 2026-06-19
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
对于数组 b，如果其中存在一个数恰好出现一次，则称 b 为好数组。
a 有 n*(n+1)/2 个连续子数组，其中有多少个好子数组？

rating
本文下标从 1 开始。
枚举子数组的右端点，那么合法左端点有多少个？
设元素 v 上次出现的位置是 i，上上次出现的位置是 j，那么左端点可以在 [j+1, i] 中。
我们需要计算的是 v=1,2,...,n 时，对应的 [j+1, i] 的并集的大小。
对于每个区间 [j+1, i]，我们执行区间加一，那么并集大小就相当于 > 0 的数的个数。
做法同矩形面积并，维护区间最小值、区间最小值的出现次数、区间加 tag，原理见 LC850. 矩形面积 II 我的题解。
对于本题，当我们遍历到 v=a[i] 时，设 j = last[v]，k = last2[v]（初始值为 0）。
如果 j > 0，那么先撤销之前的区间加一，也就是对 [k+1, j] 执行区间减一。
然后对 [j+1, i] 执行区间加一。
合法左端点的个数，等于 i 减去「线段树 [1, i] 中的 0 的个数」。
代码 https://atcoder.jp/contests/abc346/submissions/76753637
======

Input 1
5
2 2 1 2 1
Output 1
12

Input 2
4
4 4 4 4
Output 2
4

Input 3
10
1 2 1 4 3 3 3 2 2 4
Output 3
47
 */
