package p1845;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1845A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();
            System.out.println(solve(n, k, x));
        }
    }

    private static String solve(int n, int k, int x) {
        // 能选 1，直接 n 个 1
        if (x != 1) {
            return "YES" + System.lineSeparator()
                    + n + System.lineSeparator()
                    + "1 ".repeat(n);
        }
        // 不能选 1，没得选
        if (k == 1) {
            return "NO";
        }
        // 只能选 2，但 n 为奇数
        if (k == 2 && n % 2 == 1) {
            return "NO";
        }
        // 能选 2，n 为偶数
        if (n % 2 == 0) {
            return "YES" + System.lineSeparator()
                    + (n / 2) + System.lineSeparator()
                    + "2 ".repeat(n / 2);
        }
        // n 为奇数，选 1 个 3，然后变成偶数
        n -= 3;
        return "YES" + System.lineSeparator()
                + (n / 2 + 1) + System.lineSeparator()
                + "3 " + "2 ".repeat(n / 2);
    }
}
/*
Educational Codeforces Round 151 (Rated for Div. 2) https://www.bilibili.com/video/BV12h411P7PS/
A. Forbidden Integer
https://codeforces.com/contest/1845/problem/A

题目大意：
给你一个整数 n，你想要得到它。从 1 到 k 的每一个整数都有无限的供应，除了整数 x(根本没有整数 x)。
你可以取任意数量的这些整数(可能是零)。你能使所取整数的和等于 n 吗?
如果有多个答案，打印其中任何一个。
输入第一行包含单个整数 t(1≤t≤100)—测试用例的个数。
每个测试用例的唯一一行包含三个整数 n、k 和 x(1≤x≤k≤n≤100)。

分类讨论
======

input
5
10 3 2
5 2 1
4 2 1
7 7 3
6 1 1
output
YES
6
3 1 1 1 1 3
NO
YES
2
2 2
YES
1
7
NO

1
3 3 1
 */
