package p1826;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1826C {
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
        if (n == 1 || m == 1) {
            return "YES";
        }
        if (n <= m) {
            return "NO";
        }

        // 最小质因子
        for (int i = 2; i * i <= n && i <= m; i++) {
            if (n % i == 0) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
C. Dreaming of Freedom
https://codeforces.com/contest/1826/problem/C

题目大意：
有 n 个程序员在 m 个不同的选择选项中选择他们最喜欢的算法。在第一轮之前，所有 m 个选项都是可用的。在每一轮中，每个程序员对剩下的算法进行投票。
一轮之后，只剩下得票最多的算法。当只剩下一个选项时，投票过程就结束了。决定投票过程是否可以无限期地继续下去，还是无论人们如何投票，他们最终都会在有限的轮数后选择一个选项？

n 的最小质因子 <= m
======

input
5
3 2
4 2
5 3
1000000 1000000
1 1000000
output
YES
NO
YES
NO
YES

1
11 67
NO
 */
