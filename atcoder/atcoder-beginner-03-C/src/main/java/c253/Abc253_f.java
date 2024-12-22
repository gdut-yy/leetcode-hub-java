package c253;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Abc253_f {
    static class Query {
        int op, l, r;
        long x;
    }

    static int n, m, q;
    static Query[] qs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        qs = new Query[q];
        for (int i = 0; i < q; i++) {
            qs[i] = new Query();
            qs[i].op = scanner.nextInt();
            if (qs[i].op == 1) {
                qs[i].l = scanner.nextInt();
                qs[i].r = scanner.nextInt();
                qs[i].x = scanner.nextInt();
            } else if (qs[i].op == 2) {
                qs[i].l = scanner.nextInt();
                qs[i].x = scanner.nextInt();
            } else {
                qs[i].l = scanner.nextInt();
                qs[i].r = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    static String solve() {
        BIT tr = new BIT(m + 1);
        List<Integer>[] todo = new ArrayList[n + 1];
        Arrays.setAll(todo, e -> new ArrayList<>());
        for (int i = q - 1; i >= 0; i--) {
            Query q1 = qs[i];
            if (q1.op == 1) {
                tr.add(q1.l, q1.x);
                tr.add(q1.r + 1, -q1.x); // 差分更新
            } else if (q1.op == 2) {
                for (Integer j : todo[q1.l]) { // 回答这一行的 op=3
                    qs[j].x += tr.query(qs[j].r) + q1.x;
                }
                todo[q1.l].clear();
            } else {
                qs[i].x = -tr.query(q1.r); // 先减掉，因为后面（大于 i）的区间加不会算进来
                todo[q1.l].add(i);
            }
        }
        // 更新剩下的
        for (List<Integer> td : todo) {
            for (Integer j : td) {
                qs[j].x += tr.query(qs[j].r);
            }
        }
        List<String> output = new ArrayList<>();
        for (Query q : qs) {
            if (q.op == 3) {
                output.add("" + q.x);
            }
        }
        return String.join(System.lineSeparator(), output);
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

        long query(int pos) {
            long ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }
    }

//    static String solve1() {
//        int iter = 1;
//        Node[] t = new Node[q + 1];
//        t[0] = build(1, m);
//        Pair[] last = new Pair[n + 1];
//        Arrays.setAll(last, e -> new Pair(0, 0));
//        List<String> output = new ArrayList<>();
//        for (Query q : qs) {
//            int op = q.op, l = q.l, r = q.r, v = q.x;
//            if (op == 1) {
//                Node o = t[iter - 1];
//                update(o, 1, m, l, r, v);
//                t[iter++] = o;
//            } else if (op == 2) {
//                last[l] = new Pair(iter - 1, r);
//            } else {
//                Pair p = last[l];
//                int res = p.v + query(t[iter - 1], 1, m, r) - query(t[p.i], 1, m, r);
//                output.add("" + res);
//            }
//        }
//        return String.join(System.lineSeparator(), output);
//    }
//
//    static class Pair {
//        int i, v;
//
//        public Pair(int i, int v) {
//            this.i = i;
//            this.v = v;
//        }
//    }
//
//    static class Node {
//        Node lo, ro;
//        int sum;
//    }
//
//    static Node root = new Node();
//
//    static Node build(int l, int r) {
//        Node o = root;
//        if (l == r) return o;
//        int m = (l + r) >> 1;
//        o.lo = build(l, m);
//        o.ro = build(m + 1, r);
//        return o;
//    }
//
//    static void update(Node o, int ol, int or, int l, int r, int add) {
//        if (l <= ol && or <= r) {
//            o.sum += add;
//            return;
//        }
//        if (o.sum > 0) {
//            o.lo.sum += add;
//            o.ro.sum += add;
//            o.sum = 0;
//        }
//        int m = (ol + or) >> 1;
//        if (l <= m) update(o.lo, ol, m, l, r, add);
//        if (r > m) update(o.ro, m + 1, or, l, r, add);
//    }
//
//    static int query(Node o, int ol, int or, int i) {
//        if (ol == or) return o.sum;
//        int m = (ol + or) >> 1;
//        if (i <= m) return o.sum + query(o.lo, ol, m, i);
//        return o.sum + query(o.ro, m + 1, or, i);
//    }
}
/*

https://atcoder.jp/contests/abc253/tasks/abc253_f

灵茶の试炼 2024-08-08
题目大意：
输入 n,m,q(1≤n,m,q≤2e5)。
有一个 n 行 m 列的矩阵，初始值均为 0。
然后输入 q 个操作/询问，格式如下：
"1 L R x"：把矩阵第 L,L+1,...,R 列的所有元素都加上 x(1≤x≤1e9)。
"2 i x"：把矩阵第 i 行的元素全部替换为 x(1≤x≤1e9)。
"3 i j"：输出矩阵第 i 行第 j 列的元素值。
矩阵行列编号均从 1 开始。

方法一：离线+线段树/差分树状数组
倒着处理操作/询问。
对于操作 1，区间加，可以用线段树，也可以用差分树状数组实现。
对于询问 3，先保存到 todo 中，其中 todo[i] 保存第 i 行尚未回答的询问的下标列表。
由于我们是倒着处理询问的，发生在询问 3 后面的区间加，是不能计入询问 3 中的，可以先减掉此时（差分树状数组中的）第 j 列的值。
对于操作 2，回答 todo[i] 中的所有询问，把此时（差分树状数组中的）第 j 列的值，以及操作 2 的 x，加到询问 3 中。
倒序遍历结束后，回答 todo 中剩余的询问。
https://atcoder.jp/contests/abc253/submissions/56397757
方法二：在线+可持久化线段树
操作 1：用可持久化线段树维护。
操作 2：记录 x 以及此时线段树的版本编号。
询问 3：查询当前线段树第 j 列的值，减去操作 2 记录的那个版本的线段树第 j 列的值，再加上操作 2 的 x。
https://atcoder.jp/contests/abc253/submissions/35393668
扩展：把询问 3 改成输出第 i 行的第 l 列到第 r 列的元素和。
======


 */