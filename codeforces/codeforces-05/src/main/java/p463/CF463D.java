package p463;

import java.util.Scanner;

public class CF463D {
    static int n, k;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        arr = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[][] index = new int[k][n + 1];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                index[i][arr[i][j]] = j;
            }
        }

        int ans = 0;
        int[] f = new int[n];
        // 以最后一个排列 a 为基准
        int[] a = arr[k - 1];
        for (int i = 0; i < n; i++) {
            int x = a[i];

            label:
            // 枚举在 x 左边的数 y
            for (int j = 0; j < i; j++) {
                int y = a[j];

                for (int[] idx : index) {
                    // 对于其余排列，y 的位置必须在 x 的左边
                    if (idx[y] > idx[x]) {
                        continue label;
                    }
                }
                f[i] = Math.max(f[i], f[j]);
            }
            f[i]++;
            ans = Math.max(ans, f[i]);
        }
        return String.valueOf(ans);
    }
}
/*
D. Gargari and Permutations
https://codeforces.com/contest/463/problem/D

灵茶の试炼 2024-01-04
题目大意：
输入 n(1≤n≤1000) k(2≤k≤5) 和 k 个 1~n 的排列。
输出这 k 个排列的最长公共子序列（LCS）的长度。
相似题目：https://www.luogu.com.cn/problem/P2364

rating 1900
以最后一个排列（记作 a）为基准求 LCS。
定义 f[i] 为子序列最后一个数是 a[i] 的 LCS 长度。
枚举小于 i 的 j 作为转移来源，即 f[i] = max(f[j]) + 1。
设 x=a[i], y=a[j]。转移来源 j 需要满足，在每个排列中，y 的下标都小于 x 的下标。
例如样例的所有 1 都在 2 的左边，所有 2 都在 3 的左边。
答案为 max(f)。
https://codeforces.com/problemset/submission/463/239943662
======

input
4 3
1 4 2 3
4 1 2 3
1 2 4 3
output
3
 */
