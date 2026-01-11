package p1701;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1701F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int q = scanner.nextInt();
        int d = scanner.nextInt();

        build(1, 1, MX);

        for (int i = 0; i < q; i++) {
            int idx = scanner.nextInt();
            if (!has[idx]) {
                has[idx] = true;
                long cnt = query(1, idx, Math.min(idx + d, MX)).cnt;
                set(1, idx, cnt);
                if (idx > 1) {
                    update(1, Math.max(idx - d, 1), idx - 1, 1);
                }
            } else {
                has[idx] = false;
                set(1, idx, -1);
                if (idx > 1) {
                    update(1, Math.max(idx - d, 1), idx - 1, -1);
                }
            }
            out.println((t[1].data.sumC2 - t[1].data.sumC) / 2);
        }
    }

    static final int MX = 200000;
    static final int N = 2 << bitsLen(MX);

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }

    static class Data {
        long cnt, sumC, sumC2;

        Data() {
        }

        Data(long cnt, long sumC, long sumC2) {
            this.cnt = cnt;
            this.sumC = sumC;
            this.sumC2 = sumC2;
        }
    }

    static class SegNode {
        int l, r;
        Data data;
        int todo;

        SegNode() {
            data = new Data();
            todo = 0;
        }
    }

    static SegNode[] t = new SegNode[N];
    static boolean[] has = new boolean[MX + 1];

    static {
        for (int i = 0; i < N; i++) {
            t[i] = new SegNode();
        }
    }

    static Data merge(Data l, Data r) {
        return new Data(l.cnt + r.cnt, l.sumC + r.sumC, l.sumC2 + r.sumC2);
    }

    static void apply(int o, int f) {
        SegNode cur = t[o];
        cur.data.sumC2 += cur.data.sumC * f * 2 + cur.data.cnt * f * f;
        cur.data.sumC += cur.data.cnt * f;
        cur.todo += f;
    }

    static void maintain(int o) {
        t[o].data = merge(t[o << 1].data, t[o << 1 | 1].data);
    }

    static void spread(int o) {
        int f = t[o].todo;
        if (f == 0) {
            return;
        }
        apply(o << 1, f);
        apply(o << 1 | 1, f);
        t[o].todo = 0;
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
    }

    static void set(int o, int i, long cnt) {
        if (t[o].l == t[o].r) {
            if (cnt < 0) {
                t[o].data = new Data();
            } else {
                t[o].data = new Data(1, cnt, cnt * cnt);
            }
            return;
        }
        spread(o);
        int m = (t[o].l + t[o].r) >> 1;
        if (i <= m) {
            set(o << 1, i, cnt);
        } else {
            set(o << 1 | 1, i, cnt);
        }
        maintain(o);
    }

    static void update(int o, int l, int r, int f) {
        if (l <= t[o].l && t[o].r <= r) {
            apply(o, f);
            return;
        }
        spread(o);
        int m = (t[o].l + t[o].r) >> 1;
        if (l <= m) {
            update(o << 1, l, r, f);
        }
        if (m < r) {
            update(o << 1 | 1, l, r, f);
        }
        maintain(o);
    }

    static Data query(int o, int l, int r) {
        if (l <= t[o].l && t[o].r <= r) {
            return t[o].data;
        }
        spread(o);
        int m = (t[o].l + t[o].r) >> 1;
        if (r <= m) {
            return query(o << 1, l, r);
        }
        if (l > m) {
            return query(o << 1 | 1, l, r);
        }
        return merge(query(o << 1, l, r), query(o << 1 | 1, l, r));
    }
}
/*
F. Points
https://codeforces.com/contest/1701/problem/F

灵茶の试炼 2025-10-24
题目大意：
输入 q(1≤q≤2e5) 和 d(1≤d≤2e5)。
然后输入 q 个询问，每个询问输入 v(1≤v≤2e5)。
一开始，集合为空。
如果 v 不在集合中，那么把 v 加到集合中，否则把 v 从集合中删除。
定义美丽三元组 (x,y,z) 为满足 x < y < z 且 z - x ≤ d 的三元组。
对于每个询问，输出添加/删除 v 之后，集合中的美丽三元组个数。

rating 2500
首先，解决本题的静态版本，即给定集合，计算集合中的美丽三元组个数。
这一步，请想清楚，我们需要维护什么？维护的数据保存在哪？
如果可以把三元组的个数打散在 [1,2e5] 中，就可以用线段树维护了。
由于 z-x <= d 与 y 无关，考虑枚举 z，计算有多少个 (x,y)。
x 必须 >= z-d。
如果 [z-d, z-1] 中有 k 个数，那么 (x,y) 就是从 k 个数选 2 个数的方案数，即 C(k,2) = k*(k-1)/2 = k*k/2 - k/2。
考虑把 k*k/2 - k/2 记在 z 这个位置。
但 k*k/2 - k/2 不好维护，可以拆成 k*k 和 k，每个 z 位置维护 k*k 和 k 两个数。
那么答案就是：所有位置的 k*k 之和 / 2 - 所有位置的 k 之和 / 2。
回到原问题。
添加 v，哪些 z 位置保存的 k*k 和 k 会变大？
由于 k 的定义是 [z-d, z-1] 中的元素个数，所以当 z-d <= v <= z-1，即 z 在 [v+1,v+d] 中时，
k 会增加 1，
k*k 会变成 (k+1)*(k+1) = k*k + 2k + 1，增加了 2k+1。
删除 v 类似。
这里有一个「区间中的每个 k 增加 1」的操作，暗示我们用 Lazy 线段树维护。
线段树的每个节点保存：
区间中的 z 的个数 cnt。
区间中的 z 保存的 k 之和 sumC。
区间中的 z 保存的 k*k 之和 sumC2。
懒标记 f，表示区间中的每个 k 增加 f。
当我们把区间中的每个 k 增加 f 时：
cnt 个 z 保存的 k 都增加了 f，所以：
    sumC += cnt * f
由于 (k+f)*(k+f) - k*k = k*f*2 + f*f，所以：
    sumC2 += sumC*f*2 + cnt*f*f。
注意更新顺序！先更新 sumC2，再更新 sumC。
当我们添加 v 时，把 v 当作 z，我们需要记录 z 这个位置的 k 和 k*k。
查询集合（线段树）中的 [z-d, z-1] 中的元素个数 k，
那么对于 z 这个位置来说，初始化 cnt=1（这个点只有一个 z），sumC=k，sumC2=k*k。
删除时，cnt、sumC、sumC2 置为 0。
答案为线段树根节点的 (sumC2 - sumC) / 2。
代码 https://codeforces.com/contest/1701/submission/342385593
代码备份（上面打不开的同学看这个）
======

Input
7 5
8 5 3 2 1 5 6
Output
0
0
1
2
5
1
5
 */
