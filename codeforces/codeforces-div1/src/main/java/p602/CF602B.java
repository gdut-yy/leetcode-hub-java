package p602;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF602B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();

        int l = 0, r = 0;
        long ans = 0;
        while (r < n) {
            // 滑动窗口最大值
            while (!maxDq.isEmpty() && a[r] > maxDq.getLast()) maxDq.removeLast();
            maxDq.addLast(a[r]);
            // 滑动窗口最小值
            while (!minDq.isEmpty() && a[r] < minDq.getLast()) minDq.removeLast();
            minDq.addLast(a[r]);

            // 差值 > 1 时，左指针右移
            while (!maxDq.isEmpty() && !minDq.isEmpty()
                    && maxDq.getFirst() - minDq.getFirst() > 1) {
                if (a[l] == maxDq.getFirst()) maxDq.removeFirst();
                if (a[l] == minDq.getFirst()) minDq.removeFirst();
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return String.valueOf(ans);
    }
}
/*
B. Approximating a Constant Range
https://codeforces.com/contest/602/problem/B

灵茶の试炼 2023-06-19
题目大意：
输入 n(2≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e5 且 abs(a[i]-a[i-1])≤1)。
输出 a 的最长连续子数组的长度，满足数组中的最大值减最小值不超过 1。

https://codeforces.com/problemset/submission/602/209863696
双指针滑窗，视频讲解：https://www.bilibili.com/video/BV1hd4y1r7Gq/
由于 abs(a[i]-a[i-1])≤1，问题等价于子数组内不同元素个数不超过 2，用 map 维护即可。
相似题目: 1438. 绝对差不超过限制的最长连续子数组
https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
======

input
5
1 2 3 3 2
output
4

input
11
5 4 5 5 6 7 8 8 8 7 6
output
5
 */
