package p1016;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1016D {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        int xorA = 0, xorB = 0;
        for (int v : a) {
            xorA ^= v;
        }
        for (int v : b) {
            xorB ^= v;
        }

        if (xorA != xorB) {
            return "NO";
        }
        int[][] ans = new int[n][m];
        ans[0][0] = xorA ^ a[0] ^ b[0];
        for (int j = 1; j < m; j++) {
            ans[0][j] = b[j];
        }
        for (int i = 1; i < n; i++) {
            ans[i][0] = a[i];
        }
        return "YES" + System.lineSeparator() +
                Arrays.stream(ans)
                        .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
D. Vasya And The Matrix
https://codeforces.com/contest/1016/problem/D

灵茶の试炼 2022-08-22
题目大意：
输入 n (2≤n≤100) 和 m (2≤m≤100)，以及两个长度分别为 n 和 m 的数组 a 和 b，元素范围均在 [0,1e9]。
请你构造一个 n 行 m 列的矩阵，使得矩阵第 i 行所有数的异或和等于 a[i]，第 j 列所有数的异或和等于 b[j]。
如果不存在这样的矩阵，输出 NO；否则输出 YES 和这个矩阵。
思考：把 XOR 换成 AND / OR 呢？
思考：如果既有 AND 又有 OR 呢？https://atcoder.jp/contests/abc164/tasks/abc164_f

rating 1800
https://codeforces.com/problemset/submission/1016/169303183
思考方向：尝试一下 n=m=2 的情况。
提示 1：什么时候一定输出 NO？
提示 2：试一试，能否把关键信息只填到第一行和第一列，其余位置均填 0 呢？
提示 3：直截了当的做法是，除了左上角，第一行填 b[j]，第一列填 a[i]。左上角应该填什么数？
======

input
2 3
2 9
5 3 13
output
YES
3 4 5
6 7 8

input
3 3
1 7 6
2 15 12
output
NO
 */
