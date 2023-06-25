package p1838;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1838C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(solve(n, m));
        }
    }

    private static String solve(int n, int m) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) odd.add(i * m + 1);
            else even.add(i * m + 1);
        }

        int[][] ans = new int[n][m];
        for (int i = 0; i < odd.size(); i++) {
            ans[i][0] = odd.get(i);
        }
        for (int i = 0; i < even.size(); i++) {
            ans[i + odd.size()][0] = even.get(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                ans[i][j] = ans[i][j - 1] + 1;
            }
        }
        return Arrays.stream(ans)
                .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
C. No Prime Differences
https://codeforces.com/contest/1838/problem/C

题目大意：
给定整数 n 和 m。用整数 1 到 n·m 填充一个 n × m 的网格，这样对于网格中相邻的任意两个单元格，这些单元格中值的绝对差值不是素数。如果网格中的两个单元共用一条边，则认为它们相邻。
可以证明，在给定的约束条件下，总有一个解。

constructive algorithms
列与列的差为 1
 1  2  3  4  5
 6  7  8  9 10
11 12 13 14 15
16 17 18 19 20
调整为
 6  7  8  9 10
16 17 18 19 20
 1  2  3  4  5
11 12 13 14 15
======

input
3
4 4
5 7
6 4
output
16  7  1  9
12  8  2  3
13  4 10 11
14  5  6 15

29 23 17  9  5  6  2
33 27 21 15 11  7  1
32 31 25 19 20 16 10
26 30 24 18 14  8  4
35 34 28 22 13 12  3

 2  3  7 11
 8  9  1 10
17 13  5  4
18 14  6 12
19 23 15 21
20 24 16 22
 */
