package p1680;

import java.util.Scanner;

public class CF1680C {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int n = s.length;
        int in0 = 0, out1 = 0;
        for (char c : s) {
            if (c == '1') out1++;
        }

        int ans = n;
        int l = 0, r = 0;
        while (r < n) {
            int v = s[r] & 1;
            in0 += v ^ 1;
            out1 -= v;

            // 0 多就缩小窗口
            while (in0 > out1) {
                v = s[l] & 1;
                in0 -= v ^ 1;
                out1 += v;
                l++;
            }
            // in0 <= out1
            ans = Math.min(ans, out1);

            r++;
        }
        return String.valueOf(ans);
    }
}
/*
C. Binary String
https://codeforces.com/contest/1680/problem/C

灵茶の试炼 2023-10-11
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的字符串长度之和 ≤2e5。
每组数据输入长度 ≤2e5 的字符串 s，只包含 0 和 1。
选择 s 的一个子串（可以为空），设 in0 是子串内的 0 的个数，out1 是子串外的 1 的个数。
定义子串的代价为 max(in0, out1)。
输出代价的最小值。
注：子串是连续的。
思考：如果改成所有子串的代价之和要怎么做？

二分+滑窗 or 直接滑窗
我的题解：https://www.luogu.com.cn/blog/endlesscheng/solution-cf1680c
======

input
5
101110110
1001001001001
0000111111
00000
1111
output
1
3
0
0
0
 */
