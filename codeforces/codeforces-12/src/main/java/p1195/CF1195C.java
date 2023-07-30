package p1195;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1195C {
    static int n;
    static int[][] h;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        h = new int[2][n + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= n; j++) {
                h[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[][] f = new long[n + 1][3];
        for (int i = 1; i <= n; i++) {
            f[i][0] = Arrays.stream(f[i - 1]).max().orElseThrow();
            f[i][1] = Math.max(f[i - 1][0], f[i - 1][2]) + h[0][i];
            f[i][2] = Math.max(f[i - 1][0], f[i - 1][1]) + h[1][i];
        }
        long ans = Arrays.stream(f[n]).max().orElseThrow();
        return String.valueOf(ans);
    }
}
/*
C. Basketball Exercise
https://codeforces.com/contest/1195/problem/C

灵茶の试炼 2023-07-17
题目大意：
输入 n(1≤n≤1e5) 和一个 2 行 n 列的矩阵 a(1≤a[i][j]≤1e9)。
你需要从矩阵中选择一些数，要求任意两数不能左右相邻，也不能上下相邻。
输出所选数字之和的最大值。
思考：如果改成 m 列要怎么做？ https://ac.nowcoder.com/acm/contest/59157/O

https://codeforces.com/problemset/submission/1195/214035921
本题和打家劫舍是类似的。
定义 f[i][0/1/2] 表示考虑前 i 列，其中第 i 列不选/只选第一行/只选第二行的情况下的最大元素和。
转移方程的下标从 1 开始：
f[i][0] = max(f[i-1])
f[i][1] = max(f[i-1][0], f[i-1][2]) + a[0][i]
f[i][2] = max(f[i-1][0], f[i-1][1]) + a[1][i]
初始值 f[0][0/1/2] = 0。
答案为 max(f[n])。
代码实现时，第一个维度可以优化掉。
相似题目: 198. 打家劫舍
https://leetcode.cn/problems/house-robber/
======

input
5
9 3 5 7 3
5 8 1 4 5
output
29

input
3
1 2 9
10 1 1
output
19

input
1
7
4
output
7
 */
