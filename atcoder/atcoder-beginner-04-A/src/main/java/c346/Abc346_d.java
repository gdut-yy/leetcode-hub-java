package c346;

import java.util.Scanner;

public class Abc346_d {
    static int n;
    static char[] s;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final long INF = (long) 1e18;

    private static String solve() {
        long[][] f = new long[2][2];
        for (int i = 0; i < n; i++) {
            int b = s[i] - '0';
            int v = a[i];
            f = new long[][]{
                    {f[0][1], f[0][0]},
                    {Math.min(f[1][1], f[0][0]), Math.min(f[1][0], f[0][1])}
            };
            f[0][b ^ 1] += v;
            if (i > 0) {
                f[1][b ^ 1] += v;
            } else {
                f[1] = new long[]{INF, INF};
            }
        }
        long ans = Math.min(f[1][0], f[1][1]);
        return String.valueOf(ans);
    }
}
/*
D - Gomamayo Sequence
https://atcoder.jp/contests/abc346/tasks/abc346_d

灵茶の试炼 2025-04-22
题目大意：
输入 n(2≤n≤2e5)，长为 n 的 01 字符串 s，长为 n 的数组 a(1≤a[i]≤1e9)。
修改 s，使其中【恰好】包含一对相邻相同字符。
例如 10010 是符合要求的，11001 是不符合要求的（有两对相邻相同字符 11 和 00）。
修改 s[i] 的代价是 a[i]。
输出最小总代价。
进阶：把一对改成两对，K 对，要怎么做？

状态机 DP，可以轻松扩展到 K 对的情况。
我们需要知道出现多少对相邻相同的情况，以及 s[i] 变成 0 还是 1。
定义 f[i+1][j][k] 表示考虑 s[0,i]，恰好包含 j 对相邻相同，k=0/1 表示 s[i] 变成 0 还是 1。
以 s[i]=0 为例。
对于 f[i+1][0][0] 来说，只有一种策略，就是前一个字母是 1，即 f[i][0][1]。
对于 f[i+1][0][1] 来说，只有一种策略，就是前一个字母是 0，即 f[i][0][0]，再加上修改 s[i] 的代价。
对于 f[i+1][1][0] 来说，有两种策略，前一个字母是 1，即 f[i][1][1]，或者前一个字母是 0，即 f[i][0][0]。
对于 f[i+1][1][1] 来说，有两种策略，前一个字母是 0，即 f[i][1][0]，或者前一个字母是 1，即 f[i][0][1]，再加上修改 s[i] 的代价。
初始值：f[0][j][k] = 0。f[1][1][k] = inf，因为此时只有一个字母。
答案为 min(f[n][1][0], f[n][1][1])。
代码 https://atcoder.jp/contests/abc346/submissions/64671592
======

Input 1
5
00011
3 9 2 6 4
Output 1
7

Input 2
4
1001
1 2 3 4
Output 2
0

Input 3
11
11111100111
512298012 821282085 543342199 868532399 690830957 973970164 928915367 954764623 923012648 540375785 925723427
Output 3
2286846953
 */
