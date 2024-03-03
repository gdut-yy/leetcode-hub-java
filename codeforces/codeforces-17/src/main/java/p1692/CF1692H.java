package p1692;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1692H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }
            System.out.println(solve(n, x));
        }
    }

    private static String solve(int n, int[] x) {
        // 按值分组
        Map<Integer, List<Integer>> groupIdsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            groupIdsMap.computeIfAbsent(x[i], key -> new ArrayList<>()).add(i);
        }

        // 初始全置 -1
        int[] init = new int[n];
        Arrays.fill(init, -1);
        MaxSubArraySegTree seg = new MaxSubArraySegTree(init);
        int a = 0, maxSubarraySum = 0;
        for (Map.Entry<Integer, List<Integer>> entry : groupIdsMap.entrySet()) {
            int key = entry.getKey();
            List<Integer> idxList = entry.getValue();

            // 操作，置 1
            for (int idx : idxList) seg.modify(idx + 1, 1);

            if (maxSubarraySum < seg.query(1, n)) {
                maxSubarraySum = seg.query(1, n);
                a = key;
            }
            // 回退，置 -1
            for (int idx : idxList) seg.modify(idx + 1, -1);
        }

        // 模拟
        for (int i = 0; i < n; i++) {
            x[i] = (x[i] == a) ? 1 : -1;
        }
        // 双指针找最大子段和对应下标
        int l = 0, r = 0, sum = 0;
        while (r < n) {
            sum += x[r];
            if (sum == maxSubarraySum) break;
            if (sum <= 0) {
                l = r + 1;
                sum = 0;
            }
            r++;
        }
        return a + " " + (l + 1) + " " + (r + 1);
    }

    private static class MaxSubArraySegTree {
        Node[] tree;
        static final int INF = (int) 1e9;

        static class Node {
            // 分别表示 [l,r] 区间：前缀最大子段和，后缀最大子段和，最大子段和，区间和
            int maxL, maxR, maxSum, sum;

            public Node(int maxL, int maxR, int maxSum, int sum) {
                this.maxL = maxL;
                this.maxR = maxR;
                this.maxSum = maxSum;
                this.sum = sum;
            }
        }

        int[] nums;
        int n;

        public MaxSubArraySegTree(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            tree = new Node[4 * n];
            Arrays.setAll(tree, e -> new Node(0, 0, 0, 0));

            build(1, 1, n);
        }

        void build(int p, int l, int r) {
            if (l == r) {
                int val = nums[l - 1];
                tree[p].maxL = tree[p].maxR = tree[p].maxSum = tree[p].sum = val;
                return;
            }
            int mid = l + (r - l) / 2;
            build(p << 1, l, mid);
            build(p << 1 | 1, mid + 1, r);
            tree[p] = pushUp(tree[p << 1], tree[p << 1 | 1]);
        }

        // nums[pos] 修改为 val
        void modify(int pos, int val) {
            modify(1, 1, n, pos, val);
        }

        void modify(int p, int l, int r, int pos, int val) {
            if (l > pos || r < pos) {
                return;
            }
            if (l == pos && r == pos) {
                tree[p].maxL = tree[p].maxR = tree[p].maxSum = tree[p].sum = val;
                return;
            }
            int mid = l + (r - l) / 2;
            modify(p << 1, l, mid, pos, val);
            modify(p << 1 | 1, mid + 1, r, pos, val);
            tree[p] = pushUp(tree[p * 2], tree[p * 2 + 1]);
        }

        // 查询 [l,r] 区间最大子段和
        int query(int ql, int qr) {
            return query(1, 1, n, ql, qr).maxSum;
        }

        Node query(int p, int l, int r, int ql, int qr) {
            if (l > qr || r < ql) {
                return new Node(-INF, -INF, -INF, 0);
            }
            if (ql <= l && r <= qr) {
                return tree[p];
            }
            int mid = l + (r - l) / 2;
            Node ls = query(p << 1, l, mid, ql, qr);
            Node rs = query(p << 1 | 1, mid + 1, r, ql, qr);
            return pushUp(ls, rs);
        }

        Node pushUp(Node ls, Node rs) {
            int maxL = Math.max(ls.maxL, ls.sum + rs.maxL);
            int maxR = Math.max(rs.maxR, rs.sum + ls.maxR);
            // max(l.maxSum, r.maxSum, l.maxR + r.maxL)
            int maxSum = Math.max(Math.max(ls.maxSum, rs.maxSum), ls.maxR + rs.maxL);
            int sum = ls.sum + rs.sum;
            return new Node(maxL, maxR, maxSum, sum);
        }
    }
}
/*
H. Gambling
https://codeforces.com/contest/1692/problem/H

题目大意：
玛丽安在赌场。赌场的游戏是这样的。
在每一轮之前，玩家在 1 到 10^9 之间选择一个数字。之后，掷一个有 10^9 个面的骰子，这样就会出现一个 1 到 10^9 之间的随机数。如果玩家猜对了数字，他们的总钱就会翻倍，否则他们的总钱就会减半。
Marian 预测了未来，并且知道在接下来的 n 轮骰子中会出现的所有数字 x1,x2,...,xn。
他将选择三个整数 a, l 和 r (l≤r)。他将打 r-l+1 轮(包括 l 和 r 之间的回合)。在每一轮中，他都会猜出相同的数字 a。开始时(在第一轮之前)他有 1 美元。
Marian 要求你确定整数 a, l 和 r(1≤a≤10^9,1≤l≤r≤n)，使他最终赚的钱最多。
请注意，在对半和相乘期间，没有舍入，也没有精度误差。因此，例如在游戏中，Marian 的钱可能等于 1/1024、1/128、1/2、1、2、4 等(2^t 的任何值，其中 t 是任何符号的整数)。
---
给定整数 n 和长度为 n 的数组 x，求 a,l,r，在 [l,r] 内均选择 a，如果 a == x[i] 那么翻倍，否则减半。

动态最大子数组和。线段树。
时间复杂度 O(nlogn)
相似题目: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
======

input
4
5
4 4 3 4 4
5
11 1 11 1 11
1
1000000000
10
8 8 8 9 9 6 6 9 6 6
output
4 1 5
1 2 2
1000000000 1 1
6 6 10
 */