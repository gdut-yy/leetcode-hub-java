package c281;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Abc281_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, k, a));
    }

    private static String solve(int n, int m, int k, int[] a) {
        // 堆顶最大 保留 k 个
        TreeSet<Integer> maxTreeSet = new TreeSet<>((o1, o2) -> {
            if (a[o1] == a[o2]) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(a[o2], a[o1]);
        });
        // 堆顶最小
        TreeSet<Integer> minTreeSet = new TreeSet<>((o1, o2) -> {
            if (a[o1] == a[o2]) {
                return Integer.compare(o1, o2);
            }
            return Integer.compare(a[o1], a[o2]);
        });

        long[] ans = new long[n - m + 1];
        long sum = 0L;

        // 前 M 取 K 个
        for (int i = 0; i < m; i++) {
            sum += a[i];
            maxTreeSet.add(i);
        }
        while (maxTreeSet.size() > k) {
            int maxId = maxTreeSet.pollFirst();
            sum -= a[maxId];
            minTreeSet.add(maxId);
        }
        ans[0] = sum;

        // 滑动窗口
        for (int i = m; i < n; i++) {
            // 先移除
            int rmId = i - m;
            if (maxTreeSet.contains(rmId)) {
                maxTreeSet.remove(rmId);
                sum -= a[rmId];
            } else {
                minTreeSet.remove(rmId);
            }

            // 再新增
            sum += a[i];
            maxTreeSet.add(i);
            if (!minTreeSet.isEmpty()) {
                int minId = minTreeSet.pollFirst();
                sum += a[minId];
                maxTreeSet.add(minId);
            }
            while (maxTreeSet.size() > k) {
                int maxId = maxTreeSet.pollFirst();
                sum -= a[maxId];
                minTreeSet.add(maxId);
            }
            ans[i - m + 1] = sum;
        }

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
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

Input 1
6 4 3
3 1 4 1 5 9
Output 1
5 6 10

Input 2
10 6 3
12 2 17 11 19 8 4 3 6 20
Output 2
21 14 15 13 13
 */