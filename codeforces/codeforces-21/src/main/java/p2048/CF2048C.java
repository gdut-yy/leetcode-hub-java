package p2048;

import java.util.Arrays;
import java.util.Scanner;

public class CF2048C {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int n = s.length();
        int i0 = s.indexOf('0');
        if (i0 == -1) {
            return String.format("1 %d 1 1", n);
        }
        int m = n - i0;
        char[] ans = new char[0];
        int rr = 0;
        for (int r = m; r <= n; r++) {
            char[] t = s.substring(i0, n).toCharArray();
            char[] subs = s.substring(r - m, r).toCharArray();
            for (int i = 0; i < m; i++) {
                t[i] ^= subs[i];
            }
            if (Arrays.compare(t, ans) > 0) {
                ans = t;
                rr = r;
            }
        }
        return String.format("1 %d %d %d", n, rr - m + 1, rr);
    }
}
/*
C. Kevin and Binary Strings
https://codeforces.com/contest/2048/problem/C

灵茶の试炼 2025-01-06
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的字符串长度之和 ≤5000。
每组数据输入长度 ≤5000 的 01 字符串 s。保证 s 的第一个字符是 '1'。
你需要在 s 中选择两个非空子串（可以重叠，可以有前导零），将其视作两个二进制数，计算 XOR。
目标是最大化 XOR。
输出你选择的两个子串的左右端点 l1 r1 l2 r2，下标从 1 开始。
如果答案不止一种，输出其中任意一个。

rating 1200
提示 1
其中一个子串必然是 s，如果比 s 还短，那 XOR 必然比 s 小。
提示 2
找到 s 的最左边的 0，这个 0 一定要改成 1，得到的 XOR 一定比不改更大。
设这个 0 的下标为 i，那么另一个子串的长度必须恰好等于 n-i，因为我们要【右对齐】计算 XOR。
提示 3
暴力枚举所有长为 n-i 的子串。
特别地，如果 s 没有 0，那么输出 1 n 1 1。
代码 https://codeforces.com/contest/2048/submission/299119561
代码备份（洛谷）
======

Input
5
111
1000
10111
11101
1100010001101
Output
2 2 1 3
1 3 1 4
1 5 1 4
3 4 1 5
1 13 1 11
 */
