package p1734;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1734E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, b));
    }

    private static String solve(int n, int[] b) {
        int[][] a = new int[n][n];
        // 对角线
        for (int i = 0; i < n; i++) {
            a[i][i] = b[i];
        }
        // a[r1][c1] + a[r2][c2] != a[r1][c2] + a[r2][c1]
        // 移项得 a[r1][c1] - a[r1][c2] != a[r2][c1] - a[r2][c2]
        for (int i = 0; i < n; i++) {
            // 令第 i 行差值为 i
            for (int j = 1; j < n; j++) {
                a[i][(i + j) % n] = (a[i][(i + j - 1) % n] + i) % n;
            }
        }
        return Arrays.stream(a)
                .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
E. Rectangular Congruence
https://codeforces.com/contest/1734/problem/E

题目大意：
给定一个素数 n 和一个由 n 个整数组成的数组 b1,b2,...,bn，其中对于每个 1≤i≤n, 0≤bi<n。
你必须找到一个大小为 n×n 的矩阵 a，使以下所有要求都成立:
- 对于所有 1≤i,j≤n, 0≤ai,j<n。
- ar1,c1 + ar2,c2 != ar1,c2 + ar2,c1 (mod n) 对于所有正整数 r1,r2,c1,c2 满足 1≤r1<r2≤n 且 1≤c1<c2≤n。
- ai,i = bi 对于所有 1≤i≤n。
这里的 x != y (mod m) 表示 x 和 y 除以 m 后的余数不同。
如果有多个解，输出 any。可以证明，在给定的约束条件下，这样的矩阵总是存在的。

constructive algorithms
======

input
2
0 0
output
0 1
0 0

input
3
1 1 1
output
1 2 2
1 1 0
1 0 1

input
5
1 4 1 2 4
output
1 0 1 3 4
1 4 3 1 0
2 4 1 0 2
1 2 2 2 2
2 2 0 1 4
 */
