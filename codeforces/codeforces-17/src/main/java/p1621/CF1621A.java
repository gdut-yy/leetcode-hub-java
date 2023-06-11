package p1621;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1621A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            List<String> res = solve(n, k);
            if (res.isEmpty()) {
                System.out.println("-1");
            } else {
                for (String re : res) {
                    System.out.println(re);
                }
            }
        }
    }

    private static List<String> solve(int n, int k) {
        List<String> resList = new ArrayList<>();
        if (k + k - 1 <= n) {
            char[][] chars = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(chars[i], '.');
            }
            for (int i = 0; i < k; i++) {
                chars[i * 2][i * 2] = 'R';
            }

            for (int i = 0; i < n; i++) {
                resList.add(new String(chars[i]));
            }
        }
        return resList;
    }
}
/*
Hello 2022
A. Stable Arrangement of Rooks
https://codeforces.com/contest/1621/problem/A

题目大意：
给出整数 n，求在 n*n 矩阵中放置多少个 rook。rook 可以移动到相邻的单元格，且可以打败同行或同列的 rook。

贪心，从左上到右下 沿矩阵的副对角线放置。间隔一行一列即可。
======

input
5
3 2
3 3
1 1
5 2
40 33

output
..R
...
R..
-1
R
.....
R....
.....
....R
.....
-1
 */