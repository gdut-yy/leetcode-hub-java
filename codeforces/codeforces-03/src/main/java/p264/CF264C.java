package p264;

import java.util.Arrays;
import java.util.Scanner;

public class CF264C {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static int[][] ps; // v, c

    public static void main(String[] args) {
        n = scanner.nextInt();
        q = scanner.nextInt();
        ps = new int[n][2];
        for (int i = 0; i < n; i++) {
            ps[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ps[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final long INF = (long) 1e18;

    private static String solve() {
        String[] output = new String[q];
        long[] f = new long[n + 1];
        for (int i = 0; i < q; i++) {
            long a = scanner.nextInt();
            long b = scanner.nextInt();
            Arrays.fill(f, -INF);

            long mx1 = 0, mx2 = 0, mxC = 0;
            for (int[] p : ps) {
                int c = p[1];
                long mx = (c != mxC ? mx1 : mx2);

                f[c] = Math.max(f[c] + Math.max(p[0] * a, 0), mx + p[0] * b);
                if (f[c] > mx1) {
                    if (c != mxC) {
                        mx2 = mx1;
                        mxC = c;
                    }
                    mx1 = f[c];
                } else if (c != mxC && f[c] > mx2) {
                    mx2 = f[c];
                }
            }
            output[i] = String.valueOf(mx1);
        }
        return String.join(System.lineSeparator(), output);
    }
}
/*
C. Choosing Balls
https://codeforces.com/contest/264/problem/C

灵茶の试炼 2024-06-06
题目大意：
输入 n(1≤n≤1e5) q(1≤q≤500) 和长为 n 的数组 v(-1e5≤v[i]≤1e5)，长为 n 的数组 c(1≤c[i]≤n)。
有 n 个球排成一排，第 i 个球的价值为 v[i]，颜色为 c[i]。
然后输入 q 个询问，每个询问输入 a 和 b，范围 [-1e5,1e5]。
对每个询问，计算：
从这一排球中，从左到右，选出一个子序列，子序列的价值和为：
- 如果球不在序列开头，且球的颜色与前一个球的颜色相同，则加上球的值 * a。
- 否则，加上球的值 * b。
输出子序列的价值和的最大值。
子序列可以是空的，此时价值和为 0。
注：子序列不一定连续。
思路可以用到 2024.6.8 的双周 t4 上。

rating 2000
每个询问跑一个 O(n) 的子序列 DP。
提示：想一想，如果只有两种颜色，要如何 DP？
遍历到第 i 个球时，我们需要维护以颜色 c 结尾的子序列的最大价值和，定义为 f[c]，初始全为 -inf。
对于每个球，有四种决策：
1. 不选：f[c] 不变。
2. 选，且和前一个球颜色一样：f[c] += v*a。
3. 选，且和前一个球颜色不一样：我们需要知道颜色不等于 c 的最大 f，记作 f[mxC]。具体分析见下。
4. 选，作为子序列第一个数：f[c] = v*b。
对于第三个决策，我们需要维护 f 的最大值 mx1、最大值对应的颜色 mxC，以及 f 的颜色不等于 mxC 的最大值 mx2。
如果 c != mxC，那么 f[c] = mx1 + v*b，否则 f[c] = mx2 + v*b。
最后答案为 mx1。
https://codeforces.com/problemset/submission/264/264344362
相似题目: 3177. 求出最长好子序列 II
https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-ii/description/
======

Input
6 3
1 -2 3 4 0 -1
1 2 1 2 1 1
5 1
-2 1
1 0
Output
20
9
4

Input
4 1
-3 6 -1 2
1 2 3 1
1 -1
Output
5
 */