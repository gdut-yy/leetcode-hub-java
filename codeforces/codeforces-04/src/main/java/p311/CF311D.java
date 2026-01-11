package p311;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF311D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        SegTree t = new SegTree(n);
        t.build(1, 1, n);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            if (op == 1) {
                out.println(t.query(1, l, r) % mod);
            } else {
                t.update(1, l, r);
            }
        }
    }

    static final int mod = 95542721;
    static final int period = 48;

    static void rotateLeft(int[] a, int k) {
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
        reverse(a, 0, a.length - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static class SegNode {
        int l, r;
        int[] sum = new int[period];
        int todo = 0;
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }

    static class SegTree {
        SegNode[] tree;
        int n;

        SegTree(int n) {
            this.n = n;
            int size = 2 << bitsLen(n - 1);
            this.tree = new SegNode[size];
            for (int i = 0; i < size; i++) {
                tree[i] = new SegNode();
            }
        }

        void apply(int o, int f) {
            rotateLeft(tree[o].sum, f % period);
            tree[o].todo += f;
        }

        void maintain(int o) {
            for (int i = 0; i < period; i++) {
                tree[o].sum[i] = (tree[o << 1].sum[i] + tree[o << 1 | 1].sum[i]) % mod;
            }
        }

        void spread(int o) {
            int f = tree[o].todo;
            if (f == 0) {
                return;
            }
            apply(o << 1, f);
            apply(o << 1 | 1, f);
            tree[o].todo = 0;
        }

        void build(int o, int l, int r) {
            tree[o].l = l;
            tree[o].r = r;
            if (l == r) {
                int x = scanner.nextInt();
                int[] s = tree[o].sum;
                s[0] = x;
                for (int i = 1; i < period; i++) {
                    x = (int) ((long) x * x % mod * x % mod);
                    s[i] = x;
                }
                return;
            }
            int m = (l + r) >> 1;
            build(o << 1, l, m);
            build(o << 1 | 1, m + 1, r);
            maintain(o);
        }

        void update(int o, int l, int r) {
            if (l <= tree[o].l && tree[o].r <= r) {
                apply(o, 1);
                return;
            }
            spread(o);
            int m = (tree[o].l + tree[o].r) >> 1;
            if (l <= m) {
                update(o << 1, l, r);
            }
            if (m < r) {
                update(o << 1 | 1, l, r);
            }
            maintain(o);
        }

        int query(int o, int l, int r) {
            if (l <= tree[o].l && tree[o].r <= r) {
                return tree[o].sum[0];
            }
            spread(o);
            int m = (tree[o].l + tree[o].r) >> 1;
            if (r <= m) {
                return query(o << 1, l, r);
            }
            if (l > m) {
                return query(o << 1 | 1, l, r);
            }
            return (query(o << 1, l, r) + query(o << 1 | 1, l, r)) % mod;
        }
    }
}
/*
D. Interval Cubing
https://codeforces.com/contest/311/problem/D

灵茶の试炼 2026-01-02
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(0≤a[i]≤1e9)，下标从 1 开始。
然后输入 q(1≤q≤1e5) 和 q 个询问，格式如下：
"1 L R"：输出 a 的子数组 [L,R] 的元素和，模 95542721（这是一个质数）。
"2 L R"：把 a 的子数组 [L,R] 中的每个 a[i] 都改成 a[i]^3（立方）。
输出操作次数。

rating 2600
在模意义下，立方操作有最小正周期。
具体地，我们要找一个最小的周期 k，使得 x^(3^k) % P = x，其中 P = 95542721。
由费马小定理（或者欧拉降幂）可知，3^k % (P-1) = 1。
暴力计算可知 k = 48。
线段树的每个节点维护 48 个整数：
sum[0]：当前区间的和。
sum[1]：对该区间所有元素做 1 次立方操作后，区间的和。
sum[2]：对该区间所有元素做 2 次立方操作后，区间的和。
...
sum[47]：对该区间所有元素做 47 次立方操作后，区间的和。
询问 1，计算区间 sum[0] 之和。
询问 2 呢？
想象你的行李箱上有个转盘密码锁，每个转盘有 48 个数字。
询问 2 相当于同时拨动密码锁的多个转盘。
区间中原来的 sum[0] 变成 sum[1]，原来的 sum[1] 变成 sum[2] …… 原来的 sum[47] 变成 sum[0]。
线段树的 lazy tag 维护区间要循环左移（rotate left）多少次。
比如一个节点 node 的右儿子执行了一次立方操作，那么 node.sum[0] 就是左儿子的 sum[0] 和右儿子的 sum[0]（一开始的 sum[1]）。
如果再对右儿子执行一次立方操作，那么 node.sum[0] 就是左儿子的 sum[0] 和右儿子的 sum[0]（一开始的 sum[2]）。
其余 node.sum[i] 同理。循环 2 每次操作后，受到影响的节点都要更新 48 个 sum 值。
代码 https://codeforces.com/contest/311/submission/353511904
代码备份（上面打不开的同学看这个）
======

Input
8
1 2 3 4 5 6 7 8
5
1 2 5
2 2 5
1 2 5
2 3 6
1 4 7
Output
14
224
2215492
 */
