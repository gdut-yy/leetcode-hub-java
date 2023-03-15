package p1760;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1760E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        // 啥也不动
        long res1 = countSmaller(a);

        // 最后一个 1 置 0
        int[] aCopy1 = a.clone();
        for (int i = n - 1; i >= 0; i--) {
            if (aCopy1[i] == 1) {
                aCopy1[i] = 0;
                break;
            }
        }
        long res2 = countSmaller(aCopy1);

        // 第一个 0 置 1
        int[] aCopy2 = a.clone();
        for (int i = 0; i < n; i++) {
            if (aCopy2[i] == 0) {
                aCopy2[i] = 1;
                break;
            }
        }
        long res3 = countSmaller(aCopy2);

        return String.valueOf(Math.max(res1, Math.max(res2, res3)));
    }

    private static long countSmaller(int[] nums) {
        long res = 0;

        int len = nums.length;
        BIT bit = new BIT(2);
        for (int i = len - 1; i >= 0; i--) {
            bit.update(nums[i] + 1);
            // 头插法
            res += bit.query(nums[i]);
        }
        return res;
    }

    private static class BIT {
        private final int n;
        private final int[] tree;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }
    }
}
/*
E. Binary Inversions
https://codeforces.com/contest/1760/problem/E

题目大意：
给定整数 n 和长度为 n 的数组 a。只含 0 和 1，最多只能对它执行一次操作，将 0 变 1 或将 1 变 0。求最大逆序对数。

分类讨论，要么不翻，要么 0 变 1， 要么 1 变 0。
0 变 1 场景只能是选第一个 0
1 变 0 场景只能是选最后一个 1
树状树状统计逆序对。
======

input
5
4
1 0 1 0
6
0 1 0 0 1 0
2
0 0
8
1 0 1 1 0 0 0 1
3
1 1 1

output
3
7
1
13
2
 */