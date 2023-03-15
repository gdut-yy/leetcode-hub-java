package p1692;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1692H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            for (int j = 0; j < n; j++) {
                x[j] = scanner.nextInt();
            }
            System.out.println(solve(n, x));
        }
    }

    private static String solve(int n, int[] x) {
        // 预处理
        Map<Integer, List<Integer>> idxListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxListMap.computeIfAbsent(x[i], key -> new ArrayList<>()).add(i);
        }

        // 线段树模拟 时间复杂度 O(nlogn)
        SegmentTree segmentTree = new SegmentTree(new int[n]);
        // maximum-subarray 最大子数组和
        long maxSum = 0;
        long maxKey = -1;
        for (Map.Entry<Integer, List<Integer>> entry : idxListMap.entrySet()) {
            int key = entry.getKey();
            List<Integer> idxList = entry.getValue();
            // idx+1 置为 1
            for (int idx : idxList) {
                segmentTree.modify(1, n, 1, idx + 1, 1);
            }
            if (maxSum < segmentTree.query(1, n, 1, 1, n).maxSum) {
                maxKey = key;
                maxSum = segmentTree.query(1, n, 1, 1, n).maxSum;
            }
            // idx+1 置为 -1
            for (int idx : idxList) {
                segmentTree.modify(1, n, 1, idx + 1, -1);
            }
        }

        // 模拟
        for (int i = 0; i < n; i++) {
            if (x[i] == maxKey) {
                x[i] = 1;
            } else {
                x[i] = -1;
            }
        }
        // 双指针
        int leftIdx = -1;
        int rightIdx = -1;
        long sum = 0;
        int lastL = 0;
        maxSum = 0;
        for (int i = 0; i < n; i++) {
            sum += x[i];
            if (sum > maxSum) {
                maxSum = sum;
                rightIdx = i;
                leftIdx = lastL;
            }
            if (sum <= 0) {
                lastL = i + 1;
                sum = 0;
            }
        }
        return maxKey + " " + (leftIdx + 1) + " " + (rightIdx + 1);
    }

    private static class SegmentTree {
        private static class Node {
            // lSum 表示 [l,r] 内以 l 为左端点的最大子段和
            long lSum;
            // rSum 表示 [l,r] 内以 r 为右端点的最大子段和
            long rSum;
            // maxSum 表示 [l,r] 内的最大子段和
            long maxSum;
            // itSum 表示 [l,r] 的区间和
            long itSum;

            public Node(long lSum, long rSum, long maxSum, long itSum) {
                this.lSum = lSum;
                this.rSum = rSum;
                this.maxSum = maxSum;
                this.itSum = itSum;
            }
        }

        private final Node[] tree;

        public SegmentTree(int[] nums) {
            int N = nums.length;
            tree = new Node[4 * N];
            for (int i = 0; i < 4 * N; i++) {
                tree[i] = new Node(0, 0, 0, 0);
            }
            build(1, N, 1);
        }

        private void build(int s, int t, int p) {
            if (s == t) {
                tree[p].lSum = -1;
                tree[p].rSum = -1;
                tree[p].maxSum = -1;
                tree[p].itSum = -1;
                return;
            }
            int mid = s + (t - s) / 2;
            build(s, mid, p * 2);
            build(mid + 1, t, p * 2 + 1);
            tree[p] = pushUp(tree[p * 2], tree[p * 2 + 1]);
        }

        private Node pushUp(Node a, Node b) {
            long lSum = Math.max(a.lSum, a.itSum + b.lSum);
            long rSum = Math.max(b.rSum, b.itSum + a.rSum);
            long maxSum = Math.max(Math.max(a.maxSum, b.maxSum), a.rSum + b.lSum);
            long itSum = a.itSum + b.itSum;
            return new Node(lSum, rSum, maxSum, itSum);
        }

        private void modify(int s, int t, int p, int pos, long val) {
            if (s > pos || t < pos) {
                return;
            }
            if (s == pos && t == pos) {
                tree[p].lSum = val;
                tree[p].rSum = val;
                tree[p].maxSum = val;
                tree[p].itSum = val;
                return;
            }
            int mid = s + (t - s) / 2;
            modify(s, mid, p * 2, pos, val);
            modify(mid + 1, t, p * 2 + 1, pos, val);
            tree[p] = pushUp(tree[p * 2], tree[p * 2 + 1]);
        }

        private Node query(int s, int t, int p, int l, int r) {
            if (s > r || t < l) {
                return new Node(0, 0, 0, 0);
            }
            if (s >= l && t <= r) {
                return tree[p];
            }
            int mid = s + (t - s) / 2;
            Node lSub = query(s, mid, p * 2, l, r);
            Node rSub = query(mid + 1, t, p * 2 + 1, l, r);
            return pushUp(lSub, rSub);
        }
    }
}
/*
H. Gambling
https://codeforces.com/contest/1692/problem/H

题目大意：
给定整数 n 和长度为 n 的数组 x，求 a,l,r，在 [l,r] 内均选择 a，如果 a == x[i] 那么翻倍，否则减半。

动态最大子数组和。线段树。时间复杂度 O(nlogn)
相似题目: 53. 最大子数组和（静态最大子数组和）
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