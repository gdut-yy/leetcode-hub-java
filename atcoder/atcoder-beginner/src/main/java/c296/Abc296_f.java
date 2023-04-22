package c296;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc296_f {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a, b));
    }

    // https://atcoder.jp/contests/abc296/editorial/6127
    private static String solve(int n, int[] a, int[] b) {
        Fenwick c = new Fenwick(n + 1);
        Fenwick d = new Fenwick(n + 1);

        long z = 0L;
        for (int i = 0; i < n; i++) {
            int ai = a[i] + 1;
            z += c.getSum(ai, n + 1);
            c.add(ai - 1, 1);
        }
        for (int i = 0; i < n; i++) {
            int bi = b[i] + 1;
            z += d.getSum(bi, n + 1);
            d.add(bi - 1, 1);
        }

        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                return "No";
            }
        }
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == a[i + 1]) {
                return "Yes";
            }
        }
        if ((z & 1) == 1) {
            return "No";
        }
        return "Yes";
    }

    private static class Fenwick {
        private final int n;
        private final int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        int lowbit(int x) {
            return x & -x;
        }

        // nums[x] add k
        void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        // nums [1,x] 的和
        int getSum(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }

        // nums [l,r] 的和
        int getSum(int l, int r) {
            return getSum(r) - getSum(l - 1);
        }
    }
}
/*
F - Simultaneous Swap
https://atcoder.jp/contests/abc296/tasks/abc296_f

题目大意：
你有两个 N 个数字的序列:A=(a1, a2,..., aN)和 B=(b1, b2,..., bn)。高桥可以重复以下操作任意次数(可能为零)。
在 1 和 n 之间选择三个成对不同的整数 i, j 和 k，
交换 A 的第 i 个和第 j 个元素，并交换 B 的第 i 个和第 k 个元素。
如果高桥有办法重复操作使 A 和 B 相等，打印 Yes;否则，打印 No。这里，当 A 的第 i 个元素和 B 的第 i 个元素相等时，A 和 B 相等。
======

Input
3
1 2 1
1 1 2
Output
Yes

Input
3
1 2 2
1 1 2
Output
No

Input
5
1 2 3 2 1
3 2 2 1 1
Output
Yes

Input
8
1 2 3 4 5 6 7 8
7 8 5 6 4 3 1 2
Output
No
 */