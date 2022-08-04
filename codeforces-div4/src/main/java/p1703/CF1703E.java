package p1703;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1703E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] lineN = new String[n];
            for (int j = 0; j < n; j++) {
                lineN[j] = reader.readLine();
            }
            writer.write(solution(n, lineN).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, String[] lineN) {
        int[][][] grid = new int[4][n][n];
        // 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[0][i][j] = lineN[i].charAt(j) == '1' ? 1 : 0;
            }
        }
        // 90
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[1][i][j] = grid[0][i][j];
            }
        }
        rotate(grid[1]);
        // 180
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[2][i][j] = grid[1][i][j];
            }
        }
        rotate(grid[2]);
        // 270
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[3][i][j] = grid[2][i][j];
            }
        }
        rotate(grid[3]);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    if (grid[k][i][j] == 1) {
                        cnt++;
                    }
                }
                if (cnt == 1 || cnt == 3) {
                    sum += 1;
                } else if (cnt == 2) {
                    sum += 2;
                }
            }
        }
        sum /= 4;
        return String.valueOf(sum);
    }

    private static void rotate(int[][] matrix) {
        int len = matrix.length;
        // 上下翻转
        for (int i = 0; i < len / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[len - 1 - i];
            matrix[len - 1 - i] = tmp;
        }
        // 对角线翻转
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
/*
E. Mirror Grid
https://codeforces.com/contest/1703/problem/E

题目大意：
给定整数 n 和 n行n列的正方形网格。每个单元格包含0或1。
在操作中，您可以选择网格的一个单元格并翻转它(从0→1或1→0)。找到在旋转0∘、90∘、180∘和270∘时保持不变的最小变换次数。

贪心，判断 4 个下标 0 和 1 的次数，0000（0次）0001（1次）0011（2次）0111（1次）1111（0次）
时间复杂度 O(n^2)
a	b	c	a
c	d	d	b
b	d	d	c
a	c	b	a

a	b	c	d	a
d	e	f	e	b
c	f	g	f	c
b	e	f	e	d
a	d	c	b	a
======

input
5
3
010
110
010
1
0
5
11100
11011
01011
10011
11000
5
01000
10101
01010
00010
01001
5
11001
00000
11111
10110
01111

output
1
0
9
7
6
 */