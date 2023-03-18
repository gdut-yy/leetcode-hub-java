package c119;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Arc119_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        long sum = 0L;
        Map<Long, Integer> sumCntMap = new HashMap<>();
        sumCntMap.put(0L, 1);

        long ans = 0L;
        // 交错和
        for (int i = 0; i < n; i++) {
            // 符号
            int sign = (i & 1) == 0 ? 1 : -1;
            sum += a[i] * sign;
            ans += sumCntMap.getOrDefault(sum, 0);
            sumCntMap.put(sum, sumCntMap.getOrDefault(sum, 0) + 1);
        }
        return String.valueOf(ans);
    }
}
/*
C - ARC Wrecker 2
https://atcoder.jp/contests/arc119/tasks/arc119_c

灵茶の试炼 2023-02-03
题目大意：
输入 n(2≤n≤3e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
每次操作，你可以选择两个相邻的数字，把它们都加一，或者都减一。
对于 a 的一个连续子数组 b，如果可以通过执行任意多次操作，使 b 的所有元素为 0，则称 b 为好子数组。
输出 a 的好子数组的数量。

https://www.luogu.com.cn/blog/endlesscheng/solution-at-arc119-c
问题等价于：求有多少个区间的交错和等于 0。
相似题目: 560. 和为K的子数组
https://leetcode.cn/problems/subarray-sum-equals-k/
======

Input
5
5 8 8 6 6
Output
3

Input
7
12 8 11 3 3 13 2
Output
3

Input
10
8 6 3 9 5 4 7 2 1 10
Output
1

Input
14
630551244 683685976 249199599 863395255 667330388 617766025 564631293 614195656 944865979 277535591 390222868 527065404 136842536 971731491
Output
8
 */