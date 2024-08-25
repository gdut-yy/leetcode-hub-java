package p1256;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1256D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();
            String s = scanner.next();
            System.out.println(solve(n, k, s));
        }
    }

    private static String solve(int n, long k, String s) {
        int c0 = 0, c1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (k < c1) {
                    // c0 个 '0', (c1-k) 个 '1', '0', k 个 '1',
                    return "0".repeat(c0) + "1".repeat((int) (c1 - k))
                            + "0" + "1".repeat((int) k) + s.substring(i + 1);
                }
                k -= c1;
                c0++;
            } else {
                c1++;
            }
        }
        return "0".repeat(c0) + "1".repeat(c1);
    }
}
/*
D. Binary String Minimizing
https://codeforces.com/contest/1256/problem/D

灵茶の试炼 2023-05-02
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e6。
每组数据输入 n(≤1e6) k(≤n^2) 和长为 n 的 01 字符串 s。
你可以交换相邻字符，至多 k 次。
输出字典序最小的结果。
如果不是 01 串要怎么做？加强版：1505 题

rating 1500
https://codeforces.com/problemset/submission/1256/203854959
贪心。
0 往左移。
先移动左边的 0 更优。
那么从左到右遍历，同时统计 1 的个数 c1。如果遇到 0，且 c1 <= k，那么就直接移到开头，k 减小 c1；否则只能移动 k 次，循环结束。
相似题目: 1505. 最多 K 次交换相邻数位后得到的最小整数
https://leetcode.cn/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/
======

input
3
8 5
11011010
7 9
1111100
7 11
1111100
output
01011110
0101111
0011111
 */
