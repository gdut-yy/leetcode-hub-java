package p1833;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1833C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        Arrays.sort(a);

        // 全奇数
        if (a[0] % 2 == 1) {
            // 偶数 - 奇数 = 奇数
            // 奇数 = 奇数
            return "YES";
        }

        // 全偶数
        // 偶数 = 偶数
        // 奇数 - 奇数 = 偶数
        for (int i = 1; i < n; i++) {
            if (a[i] % 2 == 1) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
C. Vlad Building Beautiful Array
https://codeforces.com/contest/1833/problem/C

题目大意：
给 Vlad 一个 n 个正整数的数组 a。现在他想以此构建一个长度为 n 的数组 b。
Vlad 认为，如果数组中的所有数字都是正的，并且具有相同的奇偶校验，那么这个数组就是漂亮的。也就是说，这个漂亮数组中的所有数字都大于零，并且要么全是偶数，要么全是奇数。
为了构建数组 b, Vlad 可以为每个 bi 赋值 ai 或 ai - aj，其中 j 可以从 1 到 n 中任意选择。
为了避免尝试做不可能的事情，Vlad 要求您确定是否有可能使用他的数组 a 构建一个长度为 n 的漂亮数组 b。

最小的元素决定了奇偶。
======

input
7
5
2 6 8 4 3
5
1 4 7 6 9
4
2 6 4 10
7
5 29 13 9 10000001 11 3
5
2 1 2 4 2
5
2 4 5 4 3
4
2 5 5 4
output
NO
YES
YES
YES
YES
NO
NO
 */
