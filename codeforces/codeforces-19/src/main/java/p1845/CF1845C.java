package p1845;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1845C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) V2.solve();
        out.flush();
    }

    // 方法一
    static class V1 {
        private static void solve() {
            String s = scanner.next();
            int m = scanner.nextInt();
            String l = scanner.next();
            String r = scanner.next();

            int n = s.length();
            int[][] nxt = new int[n + 1][10];

            for (int j = 0; j < 10; j++) {
                nxt[n][j] = n;
            }
            for (int i = n - 1; i >= 0; i--) {
                System.arraycopy(nxt[i + 1], 0, nxt[i], 0, 10);
                nxt[i][s.charAt(i) - '0'] = i;
            }

            int cur = -1;
            for (int i = 0; i < l.length(); i++) {
                int start = l.charAt(i) - '0';
                int end = r.charAt(i) - '0';
                int maxIndex = Integer.MIN_VALUE;

                for (int j = start; j <= end; j++) {
                    maxIndex = Math.max(maxIndex, nxt[cur + 1][j]);
                }
                cur = maxIndex;
                if (cur >= n) {
                    out.println("YES");
                    return;
                }
            }
            out.println("NO");
        }
    }

    // 方法二
    static class V2 {
        private static void solve() {
            String s = scanner.next();
            int m = scanner.nextInt();
            String l = scanner.next();
            String r = scanner.next();

            int vis = 0, j = 0;
            for (char b : s.toCharArray()) {
                vis |= 1 << (b - '0');
                int msk = (1 << (r.charAt(j) - l.charAt(j) + 1)) - 1;
                if ((vis >> (l.charAt(j) - '0') & msk) == msk) {
                    j++;
                    if (j == m) {
                        out.println("NO");
                        return;
                    }
                    vis = 0;
                }
            }
            out.println("YES");
        }
    }
}
/*
C. Strong Password
https://codeforces.com/contest/1845/problem/C

灵茶の试炼 2025-10-28
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 |s| 之和 ≤3e5。
每组数据输入一个只包含 0~9 的字符串 s(1≤|s|≤3e5)，
然后输入 m(1≤m≤10) 和两个长为 m 的只包含 0~9 的字符串 L 和 R，保证 L[i]≤R[i]。
是否存在长为 m 的，只包含 0~9 的字符串 t，满足 L[i]≤t[i]≤R[i] 且 t 不是 s 的子序列？
输出 YES 或 NO。
注：子序列不一定连续。

rating 1400
方法一
预处理 s 的 子序列自动机 nxt。
密码的第一个数字，在 s 中的位置越靠右越好。利用 nxt 可以快速求出。设这个下标为 cur。
密码的第二个数字，从 cur+1 往右看，在 s 中的位置越靠右越好。做法同理。求出后，更新 cur。
如果 cur >= n，那么密码可以不是 s 的子序列。
方法二
这个思路类似 LC2350. 不可能得到的最短骰子序列。
遍历 s 的同时，收集遇到了哪些数字。
如果收集到的数字包含 [l[j],r[j]] 中的所有数字，那么此刻的 s[i] 就是密码的第 j 个数字。把 j 加一。
如果加一后 j=m，说明无论怎么填，密码都是 s 的子序列。
利用位运算，可以做到一次遍历 + O(1) 额外空间。
方法一代码 https://codeforces.com/problemset/submission/1845/343954985
方法二代码 https://codeforces.com/problemset/submission/1845/343955928
代码备份（上面打不开的同学看这个）
======

Input
5
88005553535123456
2
50
56
123412341234
3
111
444
1234
4
4321
4321
459
2
49
59
00010
2
10
11
Output
YES
NO
YES
NO
YES
 */