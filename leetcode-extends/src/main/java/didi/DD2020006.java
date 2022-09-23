package didi;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DD2020006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, a));
    }

    private static String solve(int n, int m, int[] a) {
        int preSum = 0;
        int leftSum = 0;
        int res = Arrays.stream(a).sum();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            preSum += a[i];
            if (i >= m) {
                leftSum += a[i - m];
                priorityQueue.add(leftSum);
                int leftMax = priorityQueue.element();
                res = Math.min(res, preSum - leftMax);
            }
        }
        return String.valueOf(res);
    }
}
/*
DD-2020006. 简单游戏
https://leetcode.cn/problems/1zD30O/

给出一个长度为 n 的数组 a，你需要在这个数组中找到一个长度至少为 m 的区间，使得这个区间内的数字的和尽可能小。
格式：
输入：
- 第一行包含一个正整数 n，m,表示数组的大小和所选区间的最小长度。
- 第二行包含 n 个整数，中间用空格隔开。
输出：
- 输出仅包含一个正整数，表示所选区间的和。
示例：
输入：
5 3
1 2 3 4 5
输出：6
提示：
1 <= n < 100000
0 <= |ai| <= 1000
 */