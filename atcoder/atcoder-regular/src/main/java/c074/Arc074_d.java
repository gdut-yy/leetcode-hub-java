package c074;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Arc074_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int[] A = new int[N * 3];
        for (int i = 0; i < N * 3; i++) {
            A[i] = scanner.nextInt();
        }

        long[] lSum = new long[N + 1];
        long[] rSum = new long[N + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // 预处理左侧
        // [0, n-1]
        for (int i = 0; i < N; i++) {
            lSum[0] += A[i];
            minHeap.add(A[i]);
        }
        // [n, 2n-1]
        for (int i = N; i < N * 2; i++) {
            minHeap.add(A[i]);
            lSum[i + 1 - N] = lSum[i - N] + A[i] - minHeap.remove();
        }

        // 预处理右侧
        // [2n, 3n-1]
        for (int i = N * 2; i < N * 3; i++) {
            rSum[N] += A[i];
            maxHeap.add(A[i]);
        }
        // [n, 2n-1]
        for (int i = N * 2 - 1; i >= N; i--) {
            maxHeap.add(A[i]);
            rSum[i - N] += rSum[i + 1 - N] + A[i] - maxHeap.remove();
        }

        // 遍历最大值
        long max = Long.MIN_VALUE;
        for (int i = 0; i <= N; i++) {
            max = Math.max(max, lSum[i] - rSum[i]);
        }
        System.out.println(max);
    }
}
/*
D - 3N Numbers
https://atcoder.jp/contests/arc074/tasks/arc074_b

題目大意：
设 N 为正整数。
有一个长度为 3N 的数字序列，a =(a1,a2,...,a3N)。Snuke 通过从 a 中移除 N 个元素而不改变剩余元素的顺序，构建了一个长度为 2N a' 的新序列。在这里，a' 的分数定义为:(a' 前半部分的元素之和) − (a' 后半部分的元素之和)。
找出 a' 的最大可能得分。

相似題目: 2163. 删除元素后和的最小差值
https://leetcode.cn/problems/minimum-difference-in-sums-after-removal-of-elements/
======

Input
2
3 1 4 1 5 9
Output
1

Input
1
1 2 3
Output
-1

Input
3
8 2 2 7 4 6 5 3 8
Output
5
 */