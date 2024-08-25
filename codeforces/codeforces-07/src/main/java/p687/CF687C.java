package p687;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF687C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(solve(n, k, c));
    }

    private static String solve(int n, int k, int[] c) {
        // f[i][j1][j2] 表示能否从 c 中选出两个不相交的子集，其中一个和为 x(j1)，另一个和为 k-x(j2)，求所有 x
        // 倒序循环 可以 压缩掉第一维
        boolean[][] f = new boolean[k + 1][k + 1];
        f[0][0] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j1 = k; j1 >= 0; j1--) {
                for (int j2 = k; j2 >= 0; j2--) {
                    f[j1][j2] = f[j1][j2]
                            || (j1 - c[i] >= 0 && f[j1 - c[i]][j2])
                            || (j2 - c[i] >= 0 && f[j1][j2 - c[i]]);
                }
            }
        }

        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            if (f[i][k - i]) {
                resList.add(i);
            }
        }
        return resList.size()
                + System.lineSeparator()
                + resList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. The Values You Can Make
https://codeforces.com/contest/687/problem/C

灵茶の试炼 2023-03-15
题目大意：
输入正整数 n(≤500) k(≤500) 和长为 n 的数组 c(1≤c[i]≤500)。
从 c 中选择若干个数，组成数组 A，满足 sum(A) = k。
从 A 中再选择若干个数，组成数组 B（可以为空）。
你需要计算 sum(B) 的所有可能的值。
输出这些值的个数 q，然后按升序输出这 q 个数。

rating 1900
https://codeforces.com/problemset/submission/687/197390629
提示 1：问题转换成，能否从 c 中选出两个不相交的子集，其中一个和为 x，另一个和为 k-x。（求所有 x）
提示 2：相当于一个二维体积的 0-1 背包问题。
每个 c[i] 要么不选，要么放入一种体积，要么放入另一种体积。
所以
f[i][j1][j2] = f[i-1][j1][j2] || f[i-1][j1-c[i]][j2] || f[i-1][j1][j2-c[i]]
代码实现时第一个维度可以优化掉（倒序循环）
答案就是所有 f[x][k-x] 为 true 的 x。
======

input
6 18
5 6 1 10 12 2
output
16
0 1 2 3 5 6 7 8 10 11 12 13 15 16 17 18

input
3 50
25 25 50
output
3
0 25 50
 */
