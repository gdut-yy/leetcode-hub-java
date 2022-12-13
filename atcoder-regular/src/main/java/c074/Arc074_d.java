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

2163. 删除元素后和的最小差值
https://leetcode.cn/problems/minimum-difference-in-sums-after-removal-of-elements/
 */