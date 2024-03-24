package p1108;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1108E2 {
    static int n, m;
    static int[] a;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        lr = new int[m][2];
        for (int i = 0; i < m; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        SegmentTree seg = new SegmentTree(n);
        seg.build(a, 1, 1, n);

        List<Integer>[] ls = new ArrayList[n + 1];
        Arrays.setAll(ls, e -> new ArrayList<>());
        for (int[] p : lr) {
            int l = p[0], r = p[1];
            seg.update(1, l, r, -1);
            ls[l].add(r);
        }

        int maxD = 0, maxI = 1;
        List<Integer>[] rs = new ArrayList[n + 1];
        Arrays.setAll(rs, e -> new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            for (Integer r : ls[i]) {
                seg.update(1, i, r, 1);
                rs[r].add(i);
            }
            for (Integer l : rs[i - 1]) {
                seg.update(1, l, i - 1, -1);
            }
            int d = a[i] - seg.t[1].min;
            if (d > maxD) {
                maxD = d;
                maxI = i;
            }
        }

        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int l = lr[i][0], r = lr[i][1];
            if (r < maxI || l > maxI) {
                ids.add(i + 1);
            }
        }
        return maxD + System.lineSeparator()
                + ids.size() + System.lineSeparator()
                + ids.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }


    static class SegmentTree {
        int n;
        Node[] t;

        static class Node {
            int l, r, min, todo;

            public Node(int l, int r, int min, int todo) {
                this.l = l;
                this.r = r;
                this.min = min;
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
                t[p].min = a[l];
                return;
            }
            int mid = l + (r - l) / 2;
            build(a, p << 1, l, mid);
            build(a, p << 1 | 1, mid + 1, r);
            maintain(p);
        }

        void _do(int p, int v) {
            t[p].min += v;
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
            t[p].min = Math.min(t[p << 1].min, t[p << 1 | 1].min);
        }

        void update(int p, int l, int r, int v) {
            if (l <= t[p].l && t[p].r <= r) {
                _do(p, v);
                return;
            }
            spread(p);
            int mid = t[p].l + (t[p].r - t[p].l) / 2;
            if (l <= mid) update(p << 1, l, r, v);
            if (r > mid) update(p << 1 | 1, l, r, v);
            maintain(p);
        }
    }
}
/*
E2. Array and Segments (Hard version)
https://codeforces.com/contest/1108/problem/E2

灵茶の试炼 2022-08-23
题目大意：
本题分为简单版本和困难版本，唯一的区别是，在困难版本中 n≤1e5。
输入 n (n≤300) 和 m (m≤300)，以及长度为 n 的数组 a，元素值范围在 [-1e6,1e6]，数组的下标从 1 开始。
然后输入 m 个闭区间 [l[i],r[i]]。
你可以选择若干个区间（可以一个都不选），对每个区间，将区间内的数字减一（如果一个数字被 k 个区间覆盖，则需要减少 k）。
最大化 max(a) - min(a)。
第一行，输出这个最大值。
第二行，输出你选择了多少个区间。
第三行，按任意顺序输出你选择的区间的编号（从 1 到 m）。
输出任意一种满足要求的方案。
思考：如果 n 和 m 均为 1e5 呢？

rating 2100
https://codeforces.com/problemset/submission/1108/169394119
提示 1：枚举 a[i] 作为最大值，它需要减小吗？
提示 2：凡是不包含 i 的区间都可以选。
提示 3：到这一步，就可以用暴力枚举解决简单版本了。
对于 n,m 都等于 1e5 的情况呢？
形象地理解下面的内容：把枚举中的 i 当成一个在区间流中前进的人。
用线段树维护全局最小值。一开始把所有区间都减掉（选择），更新线段树，同时加到一个二维数组 ls 中，ls[i] 表示左端点为 i 的右端点列表。遍历 i，把 ls[i] 对应的区间加回去（不选择），然后放到一个二维数组 rs 中，rs[i] 表示右端点为 i 的左端点列表；同时，把 rs[i-1] 对应的区间再减掉（选择）。
在这个过程中记录 a[i]-min 的最大值，以及对应的 a[i] 的下标 i，最后选择所有不包含 i 的区间。
======

input
5 4
2 -2 3 1 2
1 3
4 5
2 5
1 3
output
6
2
4 1

input
5 4
2 -2 3 1 4
3 5
3 4
2 4
2 5
output
7
2
3 2

input
1 0
1000000
output
0
0

 */