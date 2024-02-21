package p815;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF815A {
    static int n, m;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] minR = new int[n];
        int[] minC = new int[m];
        Arrays.fill(minR, 999);
        Arrays.fill(minC, 999);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0 && a[i][j] - a[i - 1][j] != a[i][0] - a[i - 1][0]) {
                    return "-1";
                }
                minR[i] = Math.min(minR[i], a[i][j]);
                minC[j] = Math.min(minC[j], a[i][j]);
            }
        }

        int sr = Arrays.stream(minR).sum();
        int sc = Arrays.stream(minC).sum();
        for (int j = 0; j < m; j++) {
            sr += a[0][j] - minR[0];
        }
        for (int i = 0; i < n; i++) {
            sc += a[i][0] - minC[0];
        }

        List<String> ans = new ArrayList<>();
        if (sr < sc) {
            for (int i = 0; i < n; i++) {
                // Fprint(out, strings.Repeat(Sprintln("row", i+1), v))
                for (int k = 0; k < minR[i]; k++) {
                    ans.add("row " + (i + 1));
                }
            }
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < a[0][j] - minR[0]; k++) {
                    ans.add("col " + (j + 1));
                }
            }
        } else {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < minC[j]; k++) {
                    ans.add("col " + (j + 1));
                }
            }
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < a[i][0] - minC[0]; k++) {
                    ans.add("row " + (i + 1));
                }
            }
        }
        return ans.size() + System.lineSeparator()
                + String.join(System.lineSeparator(), ans);
    }
}
/*
A. Karen and Game
https://codeforces.com/contest/815/problem/A

灵茶の试炼 2022-05-18
题目大意：
输入一个 n 行 m 列的矩阵，n 和 m 不超过 100，元素值均在 [0,500] 内。
请你判断能否从一个 n 行 m 列的零矩阵开始，每次操作给某一行全部 +1 或某一列全部 +1，来生成输入的矩阵。
若不能，输出 -1。若能，输出最少操作多少次，以及具体操作方案（任意顺序）：若操作在第 i 行上，输出 "row i"，操作在第 j 列上，输出 "col j"。

rating 1700
https://codeforces.com/contest/815/submission/157523558
每行（或者每列）的差分数组必须都相同，如果有不同的就是 -1。
如果有解，可以倒着想，从输入出发，每行或每列全 -1，需要操作多少次，所以可以用模拟来做。需要判断是先行后列还是先列后行，取操作数的最小值。
也可以通过行或者列的最小值来直接求出每行每列操作多少次。
相似题目 https://leetcode.cn/problems/remove-all-ones-with-row-and-column-flips/
======

input
3 5
2 2 2 3 2
0 0 0 1 0
1 1 1 2 1
output
4
row 1
row 1
col 4
row 3

input
3 3
0 0 0
0 1 0
0 0 0
output
-1

input
3 3
1 1 1
1 1 1
1 1 1
output
3
row 1
row 2
row 3

9 10
14 5 6 4 8 9 4 14 14 13
13 4 5 3 7 8 3 13 13 12
16 7 8 6 10 11 6 16 16 15
10 1 2 0 4 5 0 10 10 9
11 2 3 1 5 6 1 11 11 10
10 1 2 0 4 5 0 10 10 9
12 3 4 2 6 7 2 12 12 11
13 4 5 3 7 8 3 13 13 12
13 4 5 3 7 8 3 13 13 12
 */
