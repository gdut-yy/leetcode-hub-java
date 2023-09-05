package p1862;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1862C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (a[1] != n) return "NO";

        DynamicSegTreeAdd seg = new DynamicSegTreeAdd();

        for (int i = 1; i <= n; i++) {
            int l = n + 1 - a[i];
            int r = n;
            seg.add(l, r, 1);
        }
        for (int i = 1; i <= n; i++) {
            if (a[n + 1 - i] != seg.getMax(i, i)) {
                return "NO";
            }
        }
        return "YES";
    }

    private static class DynamicSegTreeAdd {
        private static final int N = Integer.MAX_VALUE;
        private final Node root = new Node();

        private static class Node {
            Node ls, rs;
            long sum, max, lazy;
        }

        // 区间 [l,r] 置为 val
        public void add(int l, int r, int val) {
            this.add(l, r, val, 0, N, root);
        }

        // 区间 [l,r] 求和
        public long getSum(int l, int r) {
            return this.getSum(l, r, 0, N, root);
        }

        // 区间 [l,r] 最大值
        public long getMax(int l, int r) {
            return this.getMax(l, r, 0, N, root);
        }

        private void add(int l, int r, int val, int s, int t, Node node) {
            if (l <= s && t <= r) {
                node.sum += (t - s + 1L) * val;
                node.max += val;
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

        private long getMax(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.max;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            long max = 0;
            if (l <= mid) {
                max = getMax(l, r, s, mid, node.ls);
            }
            if (r > mid) {
                max = Math.max(max, getMax(l, r, mid + 1, t, node.rs));
            }
            return max;
        }

        private void pushDown(Node node, int s, int t, int mid) {
            if (node.ls == null) {
                node.ls = new Node();
            }
            if (node.rs == null) {
                node.rs = new Node();
            }
            if (node.lazy > 0) {
                node.ls.sum += node.lazy * (mid - s + 1L);
                node.rs.sum += node.lazy * (t - mid);
                node.ls.max += node.lazy;
                node.rs.max += node.lazy;
                node.ls.lazy += node.lazy;
                node.rs.lazy += node.lazy;
                node.lazy = 0;
            }
        }

        private void pushUp(Node node) {
            node.sum = node.ls.sum + node.rs.sum;
            node.max = Math.max(node.ls.max, node.rs.max);
        }
    }
}
/*
C. Flower City Fence
https://codeforces.com/contest/1862/problem/C

题目大意：
安雅住在花城。根据市长的命令，她必须为自己建一道篱笆。
栅栏由 n 块木板组成，每块木板的高度为 ai 米。根据命令，木板的高度不得增加。换句话说，对于所有 i<j, ai≥aj 是成立的。
安雅很好奇她的栅栏相对于对角线是否对称。换句话说，如果她以相同的顺序水平放置所有的木板，她会得到相同的栅栏吗?
例如，当 n=5, a=[5,4,3,2,1]时，栅栏是对称的。因为如果所有的木板水平铺设，栅栏将会是[5,4,3,2,1]，如图所示。
但当 n=3, a=[4,2,1]时，栅栏是不对称的。因为如果所有的木板水平铺设，栅栏将会是[3,2,1,1]，如图所示。
帮助 Anya 并确定她的栅栏是否对称。

模拟
======

input
7
5
5 4 3 2 1
3
3 1 1
3
4 2 1
1
2
5
5 3 3 1 1
5
5 5 5 3 3
2
6 1
output
YES
YES
NO
NO
YES
YES
NO
 */
