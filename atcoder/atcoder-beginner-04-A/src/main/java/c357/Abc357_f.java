package c357;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Abc357_f {
    static Data[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        a = new Data[n];
        Arrays.setAll(a, e -> new Data());
        for (int i = 0; i < n; i++) {
            a[i].sa = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i].sb = scanner.nextInt();
            a[i].sab = a[i].sa * a[i].sb % MOD;
        }

        int sz = 4 * n;
        t = new Seg[sz];
        Arrays.setAll(t, e -> new Seg());
        build(1, 1, n);

        List<String> output = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (op == 3) {
                long sab = query(1, l, r).sab;
                output.add("" + sab);
            } else {
                int x = scanner.nextInt();
                if (op == 1) {
                    update(1, l, r, new Pair(x, 0));
                } else {
                    update(1, l, r, new Pair(0, x));
                }
            }
        }
        System.out.println(String.join(System.lineSeparator(), output));
    }

    private static final int MOD = 998244353;

    static Seg[] t;

    static class Data {
        long sa, sb, sab;

        public Data() {
        }

        public Data(long sa, long sb, long sab) {
            this.sa = sa;
            this.sb = sb;
            this.sab = sab;
        }
    }

    static class Pair {
        long a, b;

        public Pair() {
        }

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    static class Seg {
        int l, r;
        Data d;
        Pair todo;
    }

    static void build(int o, int l, int r) {
        t[o].l = l;
        t[o].r = r;
        t[o].todo = new Pair();
        if (l == r) {
            t[o].d = a[l - 1];
            return;
        }
        int m = (l + r) >> 1;
        build(o << 1, l, m);
        build(o << 1 | 1, m + 1, r);
        maintain(o);
    }

    static void _do(int O, Pair p) {
        Seg o = t[O];
        int sz = o.r - o.l + 1;
        o.d.sa = (o.d.sa + sz * p.a) % MOD;
        o.d.sab = (o.d.sab + o.d.sb * p.a) % MOD;
        o.d.sb = (o.d.sb + sz * p.b) % MOD;
        o.d.sab = (o.d.sab + o.d.sa * p.b) % MOD;

        o.todo.a = (o.todo.a + p.a) % MOD;
        o.todo.b = (o.todo.b + p.b) % MOD;
    }

    static Data mergeInfo(Data a, Data b) {
        return new Data((a.sa + b.sa) % MOD,
                (a.sb + b.sb) % MOD,
                (a.sab + b.sab) % MOD);
    }

    static void spread(int o) {
        if (t[o].todo != null) {
            _do(o << 1, t[o].todo);
            _do(o << 1 | 1, t[o].todo);
            t[o].todo = new Pair();
        }
    }

    static void maintain(int o) {
        t[o].d = mergeInfo(t[o << 1].d, t[o << 1 | 1].d);
    }

    static void update(int o, int l, int r, Pair v) {
        if (l <= t[o].l && t[o].r <= r) {
            _do(o, v);
            return;
        }
        spread(o);
        int m = (t[o].l + t[o].r) >> 1;
        if (l <= m) update(o << 1, l, r, v);
        if (r > m) update(o << 1 | 1, l, r, v);
        maintain(o);
    }

    static Data query(int o, int l, int r) {
        if (l <= t[o].l && t[o].r <= r) {
            return t[o].d;
        }
        spread(o);
        int m = (t[o].l + t[o].r) >> 1;
        if (r <= m) return query(o << 1, l, r);
        if (l > m) return query(o << 1 | 1, l, r);
        return mergeInfo(query(o << 1, l, r), query(o << 1 | 1, l, r));
    }
}
/*
F - Two Sequence Queries
https://atcoder.jp/contests/abc357/tasks/abc357_f

灵茶の试炼 2024-08-15
题目大意：
输入 n(1≤n≤2e5) q(1≤q≤2e5) 和两个长为 n 的数组 a b，元素范围 [0,1e9]，下标从 1 开始。
然后输入 q 个询问，格式如下：
"1 l r x"：把 a[l] 到 a[r] 都增加 x。
"2 l r x"：把 b[l] 到 b[r] 都增加 x。
"3 l r"：输出 (a[l]*b[l] + a[l+1]*b[l+1] + ... + a[r]*b[r]) % 998244353。

lazy 线段树。
线段树维护：
区间 a[i] 之和 sa。
区间 b[i] 之和 sb。
区间 a[i]*b[i] 之和 sab。
lazy tag 是区间内的 a[i] 的统一增加量，区间内的 b[i] 的统一增加量。
应用 lazy tag（pushdown）：
如果把 a[i] 增加 x：
1. sa 增加 sz * x，其中 sz 是该节点的区间大小。
2. (a[i] + x) * b[i] = a[i] * b[i] + x * b[i]，也就是 sab 增加量等于 x * sb。
对于 b[i] 增加 x 同理。
可以先增加 a[i]，再增加 b[i]，无需考虑同时增加。
代码 https://atcoder.jp/contests/abc357/submissions/56473039
======

Input 1
5 6
1 3 5 6 8
3 1 2 1 2
3 1 3
1 2 5 3
3 1 3
1 1 3 1
2 5 5 2
3 1 5
Output 1
16
25
84

Input 2
2 3
1000000000 1000000000
1000000000 1000000000
3 1 1
1 2 2 1000000000
3 1 2
Output 2
716070898
151723988
 */