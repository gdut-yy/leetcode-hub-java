import java.util.Scanner;

public class P3097 {
    static int n, d;
    static int[] a;
    static int[][] queries;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        d = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        queries = new int[d][2];
        for (int i = 0; i < d; i++) {
            queries[i][0] = scanner.nextInt() - 1;
            queries[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        SegmentTree seg = new SegmentTree(a);
        for (int[] p : queries) {
            int pos = p[0], x = p[1];
            seg.update(pos, x);
            ans += seg.tree[1][3]; // 注意 f11 没有任何限制，也就是整个数组的打家劫舍
        }
        return String.valueOf(ans);
    }

    static class SegmentTree {
        int n;
        // 4 个数分别保存 f00, f01, f10, f11
        long[][] tree;
        int[] nums;

        public SegmentTree(int[] nums) {
            n = nums.length;
            tree = new long[4 * n][4];
            this.nums = nums;
            build(1, 0, n - 1);
        }

        void pushUp(int p) {
            long[] a = tree[p * 2], b = tree[p * 2 + 1];
            tree[p] = new long[]{
                    Math.max(a[0] + b[2], a[1] + b[0]),
                    Math.max(a[0] + b[3], a[1] + b[1]),
                    Math.max(a[2] + b[2], a[3] + b[0]),
                    Math.max(a[2] + b[3], a[3] + b[1])
            };
        }

        void build(int p, int l, int r) {
            if (l == r) {
                tree[p][3] = Math.max(0, nums[l]);
                return;
            }
            int mid = l + (r - l) / 2;
            build(p << 1, l, mid);
            build(p << 1 | 1, mid + 1, r);
            pushUp(p);
        }

        void update(int i, int val) {
            update(1, 0, n - 1, i, val);
        }

        void update(int p, int l, int r, int i, int val) {
            if (l == r) {
                tree[p][3] = Math.max(0, val);
                return;
            }
            int mid = l + (r - l) / 2;
            if (i <= mid) update(p << 1, l, mid, i, val);
            else update(p << 1 | 1, mid + 1, r, i, val);
            pushUp(p);
        }
    }
}
/*
P3097 [USACO13DEC] Optimal Milking G
https://www.luogu.com.cn/problem/P3097

# [USACO13DEC] Optimal Milking G

## 题目描述

Farmer John has recently purchased a new barn containing N milking machines (1 <= N <= 40,000), conveniently numbered 1..N and arranged in a row.

Milking machine i is capable of extracting M(i) units of milk per day (1 <= M(i) <= 100,000).  Unfortunately, the machines were installed so close together that if a machine i is in use on a particular day, its two neighboring machines cannot be used that day (endpoint machines have only one neighbor, of course).  Farmer John is free to select different subsets of machines to operate on different days.

Farmer John is interested in computing the maximum amount of milk he can extract over a series of D days (1 <= D <= 50,000).  At the beginning of each day, he has enough time to perform maintenance on one selected milking machine i, thereby changing its daily milk output M(i) from that day forward. Given a list of these daily modifications, please tell Farmer John how much milk he can produce over D days (note that this number might not fit into a 32-bit integer).

FJ最近买了1个新仓库, 内含N 个挤奶机,1 到N 编号并排成一行。


挤奶机i 每天能产出M(i) 单位的奶。不幸的是, 机器装得太近以至于如果一台机器i 在某天被使用, 那与它相邻的两台机器那一天不能被使用


(当然, 两端点处的机器分别只有一个与之相邻的机器)。


FJ 可自由选择不同的机器在不同的日子工作。


FJ感兴趣于计算在D 天内他能产出奶的最大值。在每天开始时, 他有足够的时间维护一个选中的挤奶机i, 从而改变它从那天起的每日产奶量M(i)。


给出这些每日的修改,请告诉FJ他D 天中能产多少奶。

## 输入格式

\* Line 1: The values of N and D.

\* Lines 2..1+N: Line i+1 contains the initial value of M(i).

\* Lines 2+N..1+N+D: Line 1+N+d contains two integers i and m,

indicating that Farmer John updates the value of M(i) to m at the beginning of day d.

## 输出格式

\* Line 1: The maximum total amount of milk FJ can produce over D days.

## 样例 #1

### 样例输入 #1

```
5 3
1
2
3
4
5
5 2
2 7
1 10
```

### 样例输出 #1

```
32
```

## 提示

There are 5 machines, with initial milk outputs 1,2,3,4,5.  On day 1, machine 5 is updated to output 2 unit of milk, and so on.


On day one, the optimal amount of milk is 2+4 = 6 (also achievable as 1+3+2).  On day two, the optimal amount is 7+4 = 11.  On day three, the optimal amount is 10+3+2=15.

题意简述：给定n个点排成一排，每个点有一个点权，多次改变某个点的点权并将最大点独立集计入答案，输出最终的答案

感谢@zht467 提供翻译
 */