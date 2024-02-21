package p833;

import java.util.Scanner;

public class CF833B {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] pre = new int[n + 1];
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = a[i - 1];
            pre[i] = p[v];
            p[v] = i;
        }

        int[] f = new int[n + 1];
        SegmentTree seg = new SegmentTree(n);
        while (k-- > 0) {
            seg.build(f, 1, 1, n);
            for (int i = 1; i <= n; i++) {
                seg.inc(1, pre[i] + 1, i);
                f[i] = seg.query(1, 1, i);
            }
        }
        return String.valueOf(f[n]);
    }

    static class SegmentTree {
        int n;
        Node[] t;

        static class Node {
            int l, r, max, todo;

            public Node(int l, int r, int max, int todo) {
                this.l = l;
                this.r = r;
                this.max = max;
                this.todo = todo;
            }
        }

        public SegmentTree(int n) {
            this.n = n;
            t = new Node[4 * n];
        }

        void build(int[] a, int p, int l, int r) {
            t[p] = new Node(l, r, 0, 0);
            if (l == r) {
                t[p].max = a[l - 1];
                return;
            }
            int mid = l + (r - l) / 2;
            build(a, p << 1, l, mid);
            build(a, p << 1 | 1, mid + 1, r);
            maintain(p);
        }

        void _do(int p, int v) {
            t[p].max += v;
            t[p].todo += v;
        }

        void spread(int p) {
            int v = t[p].todo;
            if (v != 0) {
                _do(p << 1, v);
                _do(p << 1 | 1, v);
                t[p].todo = 0;
            }
        }

        void maintain(int p) {
            t[p].max = Math.max(t[p << 1].max, t[p << 1 | 1].max);
        }

        void inc(int p, int l, int r) {
            if (l <= t[p].l && t[p].r <= r) {
                _do(p, 1);
                return;
            }
            spread(p);
            int mid = t[p].l + (t[p].r - t[p].l) / 2;
            if (l <= mid) inc(p << 1, l, r);
            if (r > mid) inc(p << 1 | 1, l, r);
            maintain(p);
        }

        int query(int p, int l, int r) {
            if (l <= t[p].l && t[p].r <= r) {
                return t[p].max;
            }
            spread(p);
            int mid = t[p].l + (t[p].r - t[p].l) / 2;
            // ?
            if (r <= mid) return query(p << 1, l, r);
            if (l > mid) return query(p << 1 | 1, l, r);
            return Math.max(query(p << 1, l, r), query(p << 1 | 1, l, r));
        }
    }
}
/*
B. The Bakery
https://codeforces.com/contest/833/problem/B

灵茶の试炼 2023-12-01
题目大意：
输入 n(1≤n≤35000) k(1≤k≤min(50,n)) 和长为 n 的数组 a(1≤a[i]≤n)。
你需要把 a 划分成 k 个非空连续段。
每段的得分 = 这一段的不同元素个数。
输出这 k 段的得分之和的最大值。

rating 2200
提示 1
先把这题做了 2262. 字符串的总引力
https://leetcode.cn/problems/total-appeal-of-a-string/
提示 2
本题是划分型 DP，通用套路是定义 f[k][i] 表示把前 i 个数分成 k 段的最大得分。
枚举第 k 段的开始位置 j，那么 f[k][i] = max{f[k-1][j-1] + 从 j 到 i 的不同元素个数}
提示 3
在枚举 i 的同时，用 lazy 线段树维护如下序列的区间最大值（维护[转移来源+不同元素个数]的最大值）：
序列的位置 L 维护着从 L 到 i 的不同元素个数，再加上 f[k-1][L-1]。这里的【加上 f[k-1][L-1]】在初始化线段树的时候完成。
遍历到 a[i] 时，把序列的下标 [pre+1,i] 内的数都 +1，这里 pre 是 a[i] 上一次出现的下标。
这样 f[k][i] 就等于线段树的 query(1,i) 了。
答疑：题目要求子数组不能为空，为什么可以直接 query(1,i)？不应该给前面的子段留下一些位置吗？
解答：没关系，分出来的子段越多，f 必然越大，query(1,i) 一定会取到分出 k 段的答案。
代码实现时，f 的第一个维度可以去掉，只需要一棵线段树。
https://codeforces.com/contest/833/submission/234860427
======

input
4 1
1 2 2 1
output
2

input
7 2
1 3 3 1 4 4 4
output
5

input
8 3
7 7 8 7 7 8 1 7
output
6

50 5
2 39 16 20 32 36 29 42 14 23 9 4 28 17 45 16 46 1 39 33 47 15 34 43 6 6 12 15 46 11 32 16 31 12 41 33 47 35 22 3 10 4 9 36 22 22 17 33 15 46
 */
