package c185;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc185_e {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[][] f = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            f[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            f[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]) + 1, f[i - 1][j - 1]);
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                }
            }
        }
        return String.valueOf(f[n][m]);
    }
}
/*
E - Sequence Matching
https://atcoder.jp/contests/abc185/tasks/abc185_e

灵茶の试炼 2022-11-10
题目大意：
输入 n(≤1000) 和 m(≤1000)，长度分别为 n 和 m 的数组 a 和 b，元素范围 [1,1e9]。
从 a 中移除若干元素，得到一个子序列 a'；从 b 中移除若干元素，得到一个子序列 b'。
要求 a' 和 b' 的长度相同。
输出 (a和b总共移除的元素个数) + (a'[i]≠b'[i]的i的个数) 的最小值。

https://atcoder.jp/contests/abc185/submissions/36352936
类似 LCS，定义 f[i][j] 表示 a 的前 i 个元素和 b 的前 j 的元素算出的答案。
- 不选 a[i] 选 b[j]：f[i-1][j]+1
- 选 a[i] 不选 b[j]：f[i][j-1]+1
- 选 a[i] 选 b[j]：f[i-1][j-1] + (a[i]==b[j] ? 0 : 1)
取最小值。
注：都不选是不用考虑的，这已经包含在 f[i-1][j] 或者 f[i][j-1] 中了。
也可以这么想：都不选是不如都选的。
边界：f[0][i]=f[i][0]=i。
答案：f[n][m]。
======

Input 1
4 3
1 2 1 3
1 3 1
Output 1
2

Input 2
4 6
1 3 2 4
1 5 2 6 4 3
Output 2
3

Input 3
5 5
1 1 1 1 1
2 2 2 2 2
Output 3
5
 */