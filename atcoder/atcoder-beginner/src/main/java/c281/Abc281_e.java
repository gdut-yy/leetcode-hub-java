package c281;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Abc281_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // 堆顶最大 保留 k 个
        TreeSet<Integer> maxTreeSet = new TreeSet<>((o1, o2) -> {
            if (A[o1] == A[o2]) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(A[o2], A[o1]);
        });
        // 堆顶最小
        TreeSet<Integer> minTreeSet = new TreeSet<>((o1, o2) -> {
            if (A[o1] == A[o2]) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(A[o1], A[o2]);
        });

        List<String> resList = new ArrayList<>();
        long sum = 0L;

        // 前 M 取 K 个
        for (int i = 0; i < M; i++) {
            sum += A[i];
            maxTreeSet.add(i);
        }
        while (maxTreeSet.size() > K) {
            int maxId = maxTreeSet.pollFirst();
            sum -= A[maxId];
            minTreeSet.add(maxId);
        }
        resList.add(String.valueOf(sum));

        // 滑动窗口
        for (int i = M; i < N; i++) {
            // 先移除
            int rmId = i - M;
            if (maxTreeSet.contains(rmId)) {
                maxTreeSet.remove(rmId);
                sum -= A[rmId];
            } else {
                minTreeSet.remove(rmId);
            }

            // 再新增
            sum += A[i];
            maxTreeSet.add(i);
            if (!minTreeSet.isEmpty()) {
                int minId = minTreeSet.pollFirst();
                sum += A[minId];
                maxTreeSet.add(minId);
            }
            while (maxTreeSet.size() > K) {
                int maxId = maxTreeSet.pollFirst();
                sum -= A[maxId];
                minTreeSet.add(maxId);
            }
            resList.add(String.valueOf(sum));
        }
        System.out.println(String.join(" ", resList));
    }
}
/*
E - Least Elements
https://atcoder.jp/contests/abc281/tasks/abc281_e

题目大意：
给定长度为 N 的整数序列 A=(A1,...,AN)，以及整数 M 和 K。
对于每一个 i = 1,...,N−M+1，求解如下独立问题。
求 M 个整数 A[i],A[i+1],...,A[i+M-1] 的排序表中前 K 个值的和，按升序排列。

双堆 + 滑动窗口
相似題目: D - 3N Numbers
https://atcoder.jp/contests/arc074/tasks/arc074_b
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