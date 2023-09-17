package c303;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc303_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(n, m, a));
    }

    private static String solve(int n, int m, int[][] a) {
        int N = n + 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int x = Math.min(a[i][j - 1], a[i][j]);
                int y = Math.max(a[i][j - 1], a[i][j]);
                set.add(x * N + y);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!set.contains(i * N + j)) {
                    ans++;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
B - Discord
https://atcoder.jp/contests/abc303/tasks/abc303_b

题目大意：
M 张照片里有 N 个编号为 1、2、…、N 的人。在每张照片中，他们站在一条线上。在第 i 张照片中，从左边开始的第 j 个人是人(i,j)。
没有在任何照片中站在一起的两个人可能心情不好。
有多少对人可能心情不好?这里，我们不区分一对 x 人和 y 人，也不区分一对 y 人和 x 人。
2≤N≤50
1≤M≤50

哈希表。
======

Input 1
4 2
1 2 3 4
4 3 1 2
Output 1
2

Input 2
3 3
1 2 3
3 1 2
1 2 3
Output 2
0

Input 3
10 10
4 10 7 2 8 3 9 1 6 5
3 6 2 9 1 8 10 7 4 5
9 3 4 5 7 10 1 8 2 6
7 3 1 8 4 9 5 6 2 10
5 2 1 4 10 7 9 8 3 6
5 8 1 6 9 3 2 4 7 10
8 10 3 4 5 7 2 9 6 1
3 10 2 7 8 5 1 4 9 6
10 6 1 5 4 2 3 8 9 7
4 5 9 1 8 2 7 6 3 10
Output 3
6
 */