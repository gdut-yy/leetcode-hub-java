package p1842;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1842E {
    static int n, k, a;
    static int[] l, r, w;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = scanner.nextInt();
        l = new int[n];
        r = new int[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = scanner.nextInt();
            r[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            r[i] = k - r[i];
        }
        System.out.println(solve());
    }

    // https://codeforces.com/problemset/submission/1842/210898671
    private static String solve() {
        List<List<Integer>> f = new ArrayList<>(k + 1);
        for (int i = 0; i < k + 1; i++) {
            f.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            f.get(r[i]).add(i);
        }

        long[] dp = new long[k + 1];
        // 单点修改，区间加，区间查询最小值
        DynamicSegTreeAdd seg = new DynamicSegTreeAdd();
        for (int i = 1; i <= k; i++) {
            for (Integer j : f.get(i)) {
                seg.add(0, l[j], -w[j]);
            }
            dp[i] = Math.min(dp[i - 1], seg.getMin(0, i - 1) + (long) i * a);
            seg.add(i, i, dp[i] - (long) i * a);
        }

        long ans = dp[k];
        for (int i = 0; i < n; i++) {
            ans += w[i];
        }
        return String.valueOf(ans);
    }

    private static class DynamicSegTreeAdd {
        private static final int N = Integer.MAX_VALUE;
        private final Node root = new Node();

        private static class Node {
            Node ls, rs;
            long sum, min, lazy;
        }

        // 区间 [l,r] 置为 val
        public void add(int l, int r, long val) {
            this.add(l, r, val, 0, N, root);
        }

        // 区间 [l,r] 求和
        public long getSum(int l, int r) {
            return this.getSum(l, r, 0, N, root);
        }

        // 区间 [l,r] 最大值
        public long getMin(int l, int r) {
            return this.getMin(l, r, 0, N, root);
        }

        private void add(int l, int r, long val, int s, int t, Node node) {
            if (l <= s && t <= r) {
                node.sum += (t - s + 1L) * val;
                node.min += val;
                node.lazy += val;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            if (l <= mid) {
                add(l, r, val, s, mid, node.ls);
            }
            if (r > mid) {
                add(l, r, val, mid + 1, t, node.rs);
            }
            pushUp(node);
        }

        private long getSum(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.sum;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            long sum = 0;
            if (l <= mid) {
                sum = getSum(l, r, s, mid, node.ls);
            }
            if (r > mid) {
                sum += getSum(l, r, mid + 1, t, node.rs);
            }
            return sum;
        }

        private long getMin(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.min;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            long min = (long) 1e18;
            if (l <= mid) {
                min = getMin(l, r, s, mid, node.ls);
            }
            if (r > mid) {
                min = Math.min(min, getMin(l, r, mid + 1, t, node.rs));
            }
            return min;
        }

        private void pushDown(Node node, int s, int t, int mid) {
            if (node.ls == null) {
                node.ls = new Node();
            }
            if (node.rs == null) {
                node.rs = new Node();
            }
            if (node.lazy != 0) {
                node.ls.sum += node.lazy * (mid - s + 1L);
                node.rs.sum += node.lazy * (t - mid);
                node.ls.min += node.lazy;
                node.rs.min += node.lazy;
                node.ls.lazy += node.lazy;
                node.rs.lazy += node.lazy;
                node.lazy = 0;
            }
        }

        private void pushUp(Node node) {
            node.sum = node.ls.sum + node.rs.sum;
            node.min = Math.min(node.ls.min, node.rs.min);
        }
    }
}
/*
E. Tenzing and Triangle
https://codeforces.com/contest/1842/problem/E

题目大意：
在二维平面上有 n 个两两不同的点和一条直线 x+y=k。第 i 点在(xi,yi)所有的点都有非负坐标，并且严格地在直线以下。或者 0≤xi,yi,xi+yi<k。
Tenzing 想要抹去所有的点。他可以执行以下两种操作:
1. 绘制三角形:丹增将选择满足 a+b<k 的两个非负整数 a, b，则由 x=a, y=b 和 x+y=k 构成的三角形内的所有点将被擦除。可以证明这个三角形是一个等腰直角三角形。设三角形的边长分别为 l、l 和 2 -√l。那么，这个操作的代价就是 l·A。
下图中蓝色区域描述了 a=1,b=1，代价=1⋅a 的三角形。
2. 擦除指定点:丹增将选择满足 1≤i≤n 的整数 i，擦除点 i。这个操作的代价是 ci。
帮助 Tenzing 找到擦除所有点的最小成本。

rating 2300
======

input
4 6 1
1 2 1
2 1 1
1 1 1
3 2 6
output
4

input
6 7 1
4 2 1
3 3 1
5 1 4
3 2 5
4 1 1
0 6 4
output
4

input
10 4 100
0 0 1
0 1 1
0 2 50
0 3 200
1 0 1
1 1 1
1 2 1
2 0 200
2 1 200
3 0 200
output
355
 */
