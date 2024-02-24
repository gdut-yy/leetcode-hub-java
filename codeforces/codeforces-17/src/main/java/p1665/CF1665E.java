package p1665;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1665E {
    static int n, q;
    static int[] a;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            q = scanner.nextInt();
            lr = new int[q][2];
            for (int i = 0; i < q; i++) {
                lr[i][0] = scanner.nextInt();
                lr[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        SegmentTree seg = new SegmentTree(n);
        seg.build(a, 1, 1, n);

        int[] ans = new int[q];
        for (int qi = 0; qi < q; qi++) {
            int l = lr[qi][0], r = lr[qi][1];

            int[] b = seg.query(1, 1, n, l, r);
            int res = 1 << 30;
            for (int i = 0; i < b.length; i++) {
                int v = b[i];
                for (int j = 0; j < i; j++) {
                    int w = b[j];
                    res = Math.min(res, v | w);
                }
            }
            ans[qi] = res;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static class SegmentTree {
        int n;
        Node[] t;

        static class Node {
            int[] arr = new int[0];
        }

        public SegmentTree(int n) {
            this.n = n;
            this.t = new Node[4 * n];
            Arrays.setAll(t, e -> new Node());
        }

        // 合并两个有序数组，保留前 k 个数
        int[] merge(int[] a, int[] b) {
            int i = 0, n = a.length;
            int j = 0, m = b.length;
            int k = Math.min(31, n + m);
            int[] res = new int[k];
            int id = 0;
            while (id < k) {
                if (i == n) {
                    while (id < k && j < m) res[id++] = b[j++];
                    break;
                }
                if (j == m) {
                    while (id < k && i < n) res[id++] = a[i++];
                    break;
                }
                if (a[i] <= b[j]) res[id++] = a[i++];
                else res[id++] = b[j++];
            }
            return res;
        }

        void build(int[] a, int p, int l, int r) {
            if (l == r) {
                t[p].arr = Arrays.copyOfRange(a, l - 1, l);
                return;
            }
            int mid = l + (r - l) / 2;
            build(a, p << 1, l, mid);
            build(a, p << 1 | 1, mid + 1, r);
            t[p].arr = merge(t[p << 1].arr, t[p << 1 | 1].arr);
        }

        int[] query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return t[p].arr;
            }
            int mid = l + (r - l) / 2;
            // ?
            if (qr <= mid) return query(p << 1, l, mid, ql, qr);
            if (ql > mid) return query(p << 1 | 1, mid + 1, r, ql, qr);
            return merge(query(p << 1, l, mid, ql, qr), query(p << 1 | 1, mid + 1, r, ql, qr));
        }
    }
}
/*
E. MinimizOR
https://codeforces.com/contest/1665/problem/E

灵茶の试炼 2023-11-17
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5，q 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(0≤a[i]<2^30)。数组下标从 1 开始。
然后输入 q(1≤q≤1e5) 和 q 个询问，每个询问输入两个数 L 和 R，表示下标从 L 到 R 的连续子数组 (1≤L<R≤n)。
对于每个询问，输出子数组内两个下标不同的数的 OR 的最小值。

rating 2500
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1665e
总的来说，通过数学归纳法可以证明，OR 的最小值一定是最小的 31 个数中选 2 个数的 OR。
所以用线段树维护区间内最小的 31 个数，问题就变成 C(31,2) 的暴力枚举了。
======

input
2
5
6 1 3 2 1
4
1 2
2 3
2 4
2 5
4
0 2 1 1073741823
4
1 2
2 3
1 3
3 4
output
7
3
3
1
2
3
1
1073741823
 */
