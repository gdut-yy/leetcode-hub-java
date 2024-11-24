package p1436;

import java.util.Arrays;
import java.util.Scanner;

public class CF1436E {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        t = new Seg[4 * n];
        Arrays.setAll(t, e -> new Seg());
        build(1, 1, n);

        boolean[] has = new boolean[n + 3];
        int[] last = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int v = a[i - 1];
            if (v == 1) {
                has[2] = true;
            } else {
                has[1] = true;
                if (preMin(1, v - 1) > last[v]) {
                    has[v] = true;
                }
                last[v] = i;
            }
            update(1, v, i);
        }
        for (int v = 2; v <= n + 1; v++) {
            if (preMin(1, v - 1) > last[v]) {
                has[v] = true;
            }
        }
        int mex = 1;
        while (has[mex]) {
            mex++;
        }
        return String.valueOf(mex);
    }

    static Seg[] t;

    static class Seg {
        int l, r, min;
    }

    static void build(int o, int l, int r) {
        t[o].l = l;
        t[o].r = r;
        if (l == r) {
            return;
        }
        int m = (l + r) >> 1;
        build(o << 1, l, m);
        build(o << 1 | 1, m + 1, r);
        maintain(o);
    }

    static void maintain(int o) {
        t[o].min = Math.min(t[o << 1].min, t[o << 1 | 1].min);
    }

    static void update(int o, int i, int val) {
        if (t[o].l == t[o].r) {
            t[o].min = val;
            return;
        }
        int m = (t[o].l + t[o].r) >> 1;
        if (i <= m) update(o << 1, i, val);
        else update(o << 1 | 1, i, val);
        maintain(o);
    }

    static int preMin(int o, int r) {
        if (t[o].r <= r) {
            return t[o].min;
        }
        int m = (t[o].l + t[o].r) >> 1;
        if (r <= m) return preMin(o << 1, r);
        return Math.min(t[o << 1].min, preMin(o << 1 | 1, r));
    }
}
/*
E. Complicated Computations
https://codeforces.com/contest/1436/problem/E

灵茶の试炼 2024-03-08
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤n)。
定义一个数组的 mex 为不在这个数组中的最小正整数。
把 a 的所有非空连续子数组的 mex 丢到一个数组 b 中，输出 b 的 mex。

rating 2400
把所有可能的子数组 mex 算出来，就可以算出答案。
例如，要检查是否有子数组的 mex 等于 6，我们可以把 a 按照 6 切分成若干段，检查是否有一段包含了 [1,5] 中的所有整数。如果包含，那么这一段的 mex 就是 6。
我们可以在遍历 a 的同时，维护每个 a[i] 最近一次出现的下标，以及用一棵值域线段树维护元素的最小下标。
对于 a[i] 来说，用线段树计算 1 到 a[i]-1 中的每个数的最近一次出现下标的最小值（记作 minIdx），如果 minIdx 大于上一个 a[i] 的出现位置，就说明这两个 a[i] 之间，包含了 1 到 a[i]-1 中的所有整数，那么这一段（两个 a[i] 之间）的 mex 等于 a[i]。
其它情况：
如果 a 中有 1，那么子数组的 mex 可以等于 2。
如果 a 中有大于 1 的数，那么子数组的 mex 可以等于 1。
https://codeforces.com/problemset/submission/1436/249298385
======

Input
3
1 3 2
Output
3

Input
5
1 4 3 1 2
Output
6
 */
