package p121;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF121E {
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
        int m = scanner.nextInt();

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        SegTree t = new SegTree(n);
        t.build(1, 0, n - 1);

        for (int i = 0; i < m; i++) {
            String op = scanner.next();
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;

            if (op.charAt(0) == 'a') {
                int d = scanner.nextInt();
                t.update(1, l, r, d);
            } else {
                out.println(t.query(1, l, r));
            }
        }
    }

    static final int[] lucky = {4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777, 4444, 4447, 4474, 4477, 4744, 4747, 4774, 4777, 7444, 7447, 7474, 7477, 7744, 7747, 7774, 7777, 1000000000};
    static int[] a;

    static class SegNode {
        int l, r, cnt, minD, todo = 0;
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

        void set(int o) {
            int i = tree[o].l;
            int pos = Arrays.binarySearch(lucky, a[i]);
            if (pos < 0) {
                pos = -pos - 1;
            }
            tree[o].minD = lucky[pos] - a[i];
            if (tree[o].minD == 0) {
                tree[o].cnt = 1;
            } else {
                tree[o].cnt = 0;
            }
        }

        void apply(int o, int f) {
            tree[o].minD -= f;
            tree[o].todo += f;
        }

        void maintain(int o) {
            tree[o].cnt = tree[o << 1].cnt + tree[o << 1 | 1].cnt;
            tree[o].minD = Math.min(tree[o << 1].minD, tree[o << 1 | 1].minD);
        }

        void build(int o, int l, int r) {
            tree[o].l = l;
            tree[o].r = r;
            if (l == r) {
                set(o);
                return;
            }
            int m = (l + r) >> 1;
            build(o << 1, l, m);
            build(o << 1 | 1, m + 1, r);
            maintain(o);
        }

        void update(int o, int l, int r, int f) {
            if (l <= tree[o].l && tree[o].r <= r && tree[o].minD > f) {
                apply(o, f);
                return;
            }
            if (tree[o].l == tree[o].r) {
                a[tree[o].l] += tree[o].todo + f;
                tree[o].todo = 0;
                set(o);
                return;
            }
            spread(o);
            int m = (tree[o].l + tree[o].r) >> 1;
            if (l <= m) {
                update(o << 1, l, r, f);
            }
            if (m < r) {
                update(o << 1 | 1, l, r, f);
            }
            maintain(o);
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

        int query(int o, int l, int r) {
            if (l <= tree[o].l && tree[o].r <= r) {
                return tree[o].cnt;
            }
            int m = (tree[o].l + tree[o].r) >> 1;
            if (r <= m) {
                return query(o << 1, l, r);
            }
            if (l > m) {
                return query(o << 1 | 1, l, r);
            }
            return query(o << 1, l, r) + query(o << 1 | 1, l, r);
        }
    }
}
/*
E. Lucky Array
https://codeforces.com/contest/121/problem/E

灵茶の试炼 2025-09-12
题目大意：
输入 n(1≤n≤1e5) m(1≤m≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e4)。下标从 1 开始。
然后输入 m 个询问，格式如下：
"add L R d"：把 a 中下标在 [L,R] 中的元素都增加 d(1≤d≤1e4)。保证增加后元素始终 ≤1e4。
"count L R"：输出 a 中下标在 [L,R] 中的幸运元素的个数。幸运元素是只包含 4 或者 7 的数，例如 47,744,4 是幸运数，而 5,17,467 不是。

rating 2400
由于幸运数只包含 4 或 7，所以：
长为 1 的幸运数有 2 个。
长为 2 的幸运数有 4 个。（考虑每个数位填 4 还是填 7）
长为 3 的幸运数有 8 个。
长为 4 的幸运数有 16 个。
在本题数据范围下，一共有 2+4+8+16 = 30 个幸运数。
做区间更新时，有三种情况：
1. 区间中的「元素 a[i] 与其下一个幸运数的距离」的最小值 > d，那么直接执行标准线段树的区间更新。
   更新后，区间中的「元素 a[i] 与其下一个幸运数的距离」的最小值减少了 d。
2. 区间中的「元素 a[i] 与其下一个幸运数的距离」的最小值 <= d，那么暴力递归左右子树，继续更新。
3. 特殊情况：递归到了叶子（区间更新退化成了单点更新）。直接更新 a[i] 即可，然后重新计算「元素 a[i] 与其下一个幸运数的距离」。
时间复杂度：递归到叶子的情况至多发生 30n 次。所以区间更新的总体时间复杂度为 O(Knlogn)，K=30。
具体来说，线段树维护：
1. 区间幸运数个数。
2. 区间中的「元素 a[i] 与其下一个幸运数的距离」的最小值。
3. 区间要增加多少（lazy tag）。
代码 https://codeforces.com/contest/121/submission/332428334
代码备份（上面打不开的同学看这个）
======

Input
3 6
2 3 4
count 1 3
count 1 2
add 1 3 2
count 1 3
add 2 3 3
count 1 3
Output
1
0
1
1

Input
4 5
4 4 4 4
count 1 4
add 1 4 3
count 1 4
add 2 3 40
count 1 4
Output
4
4
4
 */
