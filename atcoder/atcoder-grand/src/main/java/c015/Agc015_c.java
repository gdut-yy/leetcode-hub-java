package c015;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Agc015_c {
    static Scanner scanner = new Scanner(System.in);
    static int n, m, q;
    static char[][] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[][] sumV = new int[n + 1][m + 1];
        int[][] sumE = new int[n + 1][m];
        int[][] rowE = new int[n + 1][m + 1];
        int[][] colE = new int[n + 1][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char v = a[i][j];
                sumV[i + 1][j + 1] = sumV[i + 1][j] + sumV[i][j + 1] - sumV[i][j] + (v - '0');
                if (i < n - 1 && j < m - 1) {
                    sumE[i + 1][j + 1] = sumE[i + 1][j] + sumE[i][j + 1] - sumE[i][j];
                    if (v == '1') {
                        sumE[i + 1][j + 1] += (a[i][j + 1] - '0') + (a[i + 1][j] - '0');
                    }
                }
                rowE[i][j + 1] = rowE[i][j];
                if (j < m - 1 && v == '1') {
                    rowE[i][j + 1] += (a[i][j + 1] - '0');
                }
                colE[i + 1][j] = colE[i][j];
                if (i < n - 1 && v == '1') {
                    colE[i + 1][j] += (a[i + 1][j] - '0');
                }
            }
        }
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int r1 = scanner.nextInt() - 1;
            int c1 = scanner.nextInt() - 1;
            int r2 = scanner.nextInt();
            int c2 = scanner.nextInt();
            int v = sumV[r2][c2] - sumV[r2][c1] - sumV[r1][c2] + sumV[r1][c1];
            r2--;
            c2--;
            int e = sumE[r2][c2] - sumE[r2][c1] - sumE[r1][c2] + sumE[r1][c1] +
                    rowE[r2][c2] - rowE[r2][c1] +
                    colE[r2][c2] - colE[r1][c2];
            ans[i] = v - e;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
C - Nuske vs Phantom Thnook
https://atcoder.jp/contests/agc015/tasks/agc015_c

灵茶の试炼 2025-02-28
题目大意：
输入 n(1≤n≤2000) m(1≤m≤2000) q(1≤q≤2e5) 和一个 n 行 m 列的 01 网格图。
其中 0 表示白色格子，1 表示蓝色格子。
保证每个由蓝色格子构成的（四方向）连通块都是树。
然后输入 q 个询问，每个询问输入 4 个数，表示一个子矩形的左上角行列坐标和右下角行列坐标（下标从 1 开始）。
输出这个子矩形中，有多少个蓝色连通块。

树有什么性质？
点的个数 - 边的个数 = 1。
多棵树呢？
点的个数 - 边的个数 = 树的个数 = 连通块的个数。
怎么统计子矩形中的点的个数和边的个数？
二维前缀和。
注意子矩形最后一排/最后一列需要额外单独统计。则需要两个额外的前缀和矩阵。
代码 https://atcoder.jp/contests/agc015/submissions/63153808
======

Input 1
3 4 4
1101
0110
1101
1 1 3 4
1 1 3 1
2 2 3 4
1 2 2 4
Output 1
3
2
2
2

Input 2
5 5 6
11010
01110
10101
11101
01010
1 1 5 5
1 2 4 5
2 3 3 4
3 3 3 3
3 1 3 5
1 1 3 4
Output 2
3
2
1
1
3
2
 */
