package p1676;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1676D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String[] line1 = reader.readLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int m = Integer.parseInt(line1[1]);
            String[] lineN = new String[n];
            for (int j = 0; j < n; j++) {
                lineN[j] = reader.readLine();
            }
            writer.write(solution(n, m, lineN).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, int m, String[] lineN) {
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] lineIs = lineN[i].split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(lineIs[j]);
            }
        }

        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long sum = a[i][j];
                for (int k = 1; ; k++) {
                    if (i + k < n && j + k < m) {
                        sum += a[i + k][j + k];
                    } else {
                        break;
                    }
                }
                for (int k = 1; ; k++) {
                    if (i + k < n && j - k >= 0) {
                        sum += a[i + k][j - k];
                    } else {
                        break;
                    }
                }
                for (int k = 1; ; k++) {
                    if (i - k >= 0 && j - k >= 0) {
                        sum += a[i - k][j - k];
                    } else {
                        break;
                    }
                }
                for (int k = 1; ; k++) {
                    if (i - k >= 0 && j + k < m) {
                        sum += a[i - k][j + k];
                    } else {
                        break;
                    }
                }
                max = Math.max(max, sum);
            }
        }
        return String.valueOf(max);
    }
}
/*
D. X-Sum
https://codeforces.com/contest/1676/problem/D

题目大意：
给定 n * m 的棋盘，求所有可能位置的最大和（主对角线 + 副对角线）

暴力枚举。时间复杂度 O(n*m*(m+n))
======

input
4
4 4
1 2 2 1
2 4 2 4
2 2 3 1
2 4 2 4
2 1
1
0
3 3
1 1 1
1 1 1
1 1 1
3 3
0 1 1
1 0 1
1 1 0

output
20
1
5
3
 */