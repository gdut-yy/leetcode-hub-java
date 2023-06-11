package p1829;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1829D {
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
        int res = dfs(n, m);
        return res == 1 ? "YES" : "NO";
    }

    private static int dfs(int n, int m) {
        if (n < m) {
            return 0;
        }
        if (n == m) {
            return 1;
        }
        if (n % 3 != 0) {
            return 0;
        }
        return dfs(n / 3, m) | dfs(n / 3 * 2, m);
    }
}
/*
D. Gold Rush
https://codeforces.com/contest/1829/problem/D

题目大意：
一开始你有一堆 n 块金币。在一个操作中，您可以执行以下操作:
取任意一堆金子，把它分成两堆，这样，其中一堆金子的数量恰好是另一堆金子的两倍。(所有的桩都应该有一个整数的掘金。)
你能用零或更多的操作得到一堆恰好有 m 个金块的金子吗?

记忆化搜索
======

input
11
6 4
9 4
4 2
18 27
27 4
27 2
27 10
1 1
3 1
5 1
746001 2984004
output
YES
YES
NO
NO
YES
YES
NO
YES
YES
NO
NO
 */

