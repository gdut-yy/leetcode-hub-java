package p1401;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1401F {
    static Scanner scanner = new Scanner(System.in);
    static int w, q;
    static int n;
    static int[] a;
    static int[] swap;

    public static void main(String[] args) {
        w = scanner.nextInt();
        q = scanner.nextInt();
        n = 1 << w;
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        swap = new int[w + 1];
        SegmentTree seg = new SegmentTree(n);
        seg.build(1, 1, n);

        List<String> output = new ArrayList<>(q);
        for (; q > 0; q--) {
            int op = scanner.nextInt();
            int l = scanner.nextInt();
            if (op == 1) {
                int r = scanner.nextInt();
                seg.update(1, 1, n, w, l, r);
            } else if (op == 2) {
                for (int i = 0; i <= l; i++) {
                    swap[i] ^= 1;
                }
            } else if (op == 3) {
                swap[l + 1] ^= 1;
            } else {
                int r = scanner.nextInt();
                long query = seg.query(1, 1, n, w, l, r);
                output.add("" + query);
            }
        }
        return String.join(System.lineSeparator(), output);
    }

    static class SegmentTree {
        int n;
        long[] tr_sum;

        public SegmentTree(int n) {
            this.n = n;
            tr_sum = new long[4 * n];
        }

        void build(int o, int l, int r) {
            if (l == r) {
                tr_sum[o] = a[l - 1];
                return;
            }
            int m = (l + r) >> 1;
            build(o << 1, l, m);
            build(o << 1 | 1, m + 1, r);
            maintain(o);
        }

        void update(int o, int ol, int or, int d, int i, long val) {
            if (ol == or) {
                tr_sum[o] = val;
                return;
            }
            int m = (ol + or) >> 1;
            int sw = swap[d];
            if (i <= m) update(o << 1 ^ sw, ol, m, d - 1, i, val);
            else update(o << 1 ^ 1 ^ sw, m + 1, or, d - 1, i, val);
            maintain(o);
        }

        void maintain(int p) {
            int a = p << 1, b = p << 1 | 1;
            tr_sum[p] = tr_sum[a] + tr_sum[b];
        }

        long query(int o, int ol, int or, int d, int l, int r) {
            if (l <= ol && or <= r) {
                return tr_sum[o];
            }
            int m = (ol + or) >> 1;
            int sw = swap[d];
            if (r <= m) return query(o << 1 ^ sw, ol, m, d - 1, l, r);
            if (m < l) return query(o << 1 ^ 1 ^ sw, m + 1, or, d - 1, l, r);
            return query(o << 1 ^ sw, ol, m, d - 1, l, r) + query(o << 1 ^ 1 ^ sw, m + 1, or, d - 1, l, r);
        }
    }
}
/*
F. Reverse and Swap
https://codeforces.com/contest/1401/problem/F

灵茶の试炼 2024-04-26
题目大意：
输入 n(0≤n≤18) q(1≤q≤1e5) 和长为 2^n 的数组 a(0≤a[i]≤1e9)。数组下标从 1 开始。
然后输入 q 个询问：
"1 i v"：把 a[i] 改成 v(0≤v≤1e9)。
"2 k"：把数组从左到右划分为若干长为 2^k(0≤k≤n) 的区间，将每个区间翻转（reverse）。
"3 k"：把数组从左到右划分为若干长为 2^k(0≤k≤n-1) 的区间，交换第一个和第二个区间，第三个和第四个区间，依此类推。
"4 L R"：输出 a[L] + a[L+1] + ... + a[R]。

rating 2400
如何翻转一个数组？
对于如下数组，让我们换一个视角：
12345678
首先，交换相邻数字：
21436587
然后，两个数一组，交换：
43218765
最后，四个数一组，交换：
87654321
注：这个思路可以解决
190. 颠倒二进制位
所以操作 2 可以用操作 3 表达：
调用 "2 k"，相当于调用 "3 0", "3 1", "3 2",..., "3 k-1"。
对于每个 k，记录 "3 k" 的调用次数。偶数次相当于不变。
注意，只记录次数，不修改数组。
现在剩下操作 1 4，单点修改区间查询，用线段树解决。
注意操作 3 的 k 越大，每个区间越长，所以 k 越大越靠近线段树的根节点。
怎么把操作 3 加进去？或者说，操作 3 对操作 1 和操作 4 有何影响？
如果线段树某一层执行了奇数次操作 3，那么原来要递归左子树的逻辑，就要变成递归右子树了；原来要递归右子树的逻辑，就要变成递归左子树了。
https://codeforces.com/contest/1401/submission/251024196
======

Input
2 3
7 4 9 9
1 2 8
3 1
4 2 4
Output
24

Input
3 8
7 0 8 8 7 1 5 2
4 3 7
2 1
3 2
4 1 6
2 3
1 5 16
4 8 8
3 0
Output
29
22
1
 */
