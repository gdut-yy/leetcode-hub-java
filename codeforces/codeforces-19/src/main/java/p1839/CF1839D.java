package p1839;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1839D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] P = new int[n];
            for (int i = 0; i < n; i++) {
                P[i] = scanner.nextInt();
            }
            System.out.println(solve(n, P));
        }
    }

    // https://codeforces.com/contest/1839/submission/208320891
    private static String solve(int n, int[] p) {
        int[] c = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            c[i] = p[i - 1];
        }
        c[n + 1] = n + 1;

        int[][] f = new int[n + 2][n + 1];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(f[i], n);
        }
        for (int i = 0; i <= n; i++) {
            f[0][i] = 0;
        }

        for (int i = 1; i <= n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (c[j] < c[i]) {
                    if (j + 1 == i) {
                        for (int k = 0; k <= n; k += 1) {
                            f[i][k] = Math.min(f[i][k], f[j][k]);
                        }
                    } else {
                        for (int k = 0; k < n; k += 1) {
                            f[i][k + 1] = Math.min(f[i][k + 1], f[j][k] + i - j - 1);
                        }
                    }
                }
            }
            for (int j = 1; j <= n; j += 1) {
                f[i][j] = Math.min(f[i][j], f[i][j - 1]);
            }
        }

        int[] ans = Arrays.copyOfRange(f[n + 1], 1, n + 1);
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Ball Sorting
https://codeforces.com/contest/1839/problem/D

题目大意：
有 n 个五颜六色的球排成一排。球被涂成 n 种不同的颜色，用 1 到 n 的数字表示。左边的第 i 个球被涂成 ci 色。你想重新排列这些球，让左边的球颜色是 i。此外，你有 k≥1 个颜色为 0 的球可以在重新排序过程中使用。
由于球的奇怪属性，只能通过以下操作重新排序:
1.在序列的任何位置放置一个颜色为 0 的球(在任意两个连续的球之间，在最左边的球之前或最右边的球之后)，同时保持其他球的相对顺序。你可以执行这个操作不超过 k 次，因为你只有 k 个颜色为 0 的球。
2.选择任意一个颜色为非零的球，使其相邻的球中至少有一个颜色为 0，并将该球(非零颜色)移动到序列中的任何位置(在任意两个连续的球之间，在最左边的球之前或最右边的球之后)，同时保持其他球的相对顺序。您可以执行此操作多次，但每次操作都要支付 1 个硬币。
您可以按任意顺序执行这些操作。在最后一次操作之后，所有颜色为 0 的球都神奇地消失了，留下了 n 个颜色为非 0 的球。
在第二种类型的操作中，你应该花费的最小硬币数是多少，这样左边的第 i 个球在所有颜色为 0 的球消失后，从 1 到 n 的所有 i 的颜色都是 i ?可以证明，在问题的约束下，总是可以按要求的方式重新排序球。
解出从 1 到 n 的所有 k 的问题。
---
输入一个 1 到 n 的排列 p。长度至多 500.
定义 f(k) 表示移除 p 的至多 k 个连续子数组，使 p 递增，所移除的子数组的长度之和的最小值。
输出 f(1),f(2),...,f(n)

转换 + DP
======

input
3
6
2 3 1 4 6 5
3
1 2 3
11
7 3 4 6 8 9 10 2 5 11 1
output
3 2 2 2 2 2
0 0 0
10 5 4 4 4 4 4 4 4 4 4
 */
