package p1286;

import java.util.Arrays;
import java.util.Scanner;

public class CF1286A {
    static int n;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int INF = (int) 1e9;

    private static String solve() {
        // f[i][j][0/1] 表示前 i 个数中有 j 个偶数时的奇偶性不同对的最小个数
        // 其中 f[i][j][0] 表示第 i 个数是偶数，f[i][j][1] 表示第 i 个数是奇数
        int[][][] f = new int[n + 1][n / 2 + 1][2];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n / 2 + 1; j++) {
                Arrays.fill(f[i][j], INF);
            }
        }
        f[0][0] = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2 + 1; j++) {
                if (j > 0 && p[i] % 2 == 0) {
                    f[i + 1][j][0] = Math.min(f[i][j - 1][0], f[i][j - 1][1] + 1);
                }
                if (p[i] == 0 || p[i] % 2 > 0) {
                    f[i + 1][j][1] = Math.min(f[i][j][0] + 1, f[i][j][1]);
                }
            }
        }
        int ans = Math.min(f[n][n / 2][0], f[n][n / 2][1]);
        return String.valueOf(ans);
    }
}
/*
A. Garland
https://codeforces.com/contest/1286/problem/A

灵茶の试炼 2022-10-13
题目大意：
输入 n(≤100) 和一个长为 n 的数组 p，p 原本是一个 1~n 的排列，但是有些数字丢失了，丢失的数字用 0 表示。
你需要还原 p，使得 p 中相邻元素奇偶性不同的对数最少。输出这个最小值。

rating 1800
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1286a
======

input
5
0 5 0 2 3
output
2

input
7
1 0 0 5 0 0 2
output
1
 */
