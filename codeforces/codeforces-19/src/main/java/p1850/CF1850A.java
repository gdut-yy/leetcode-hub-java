package p1850;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1850A {
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = new int[3];
            a[0] = scanner.nextInt();
            a[1] = scanner.nextInt();
            a[2] = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(a);
        return a[1] + a[2] >= 10 ? "YES" : "NO";
    }
}
/*
Codeforces Round 886 (Div. 4)
A. To My Critics
https://codeforces.com/contest/1850/problem/A

题目大意：
sunet 有三个数字 a, b 和 c。
因为数学不是他的强项，他让你决定你是否可以选择任何两个数字使一个总和大于或等于 10。
如果存在，则输出“YES”，否则输出“NO”。

贪心。取最大两个数判断即可。
======

input
5
8 1 2
4 4 5
9 9 9
0 0 0
8 5 3
output
YES
NO
YES
NO
YES
 */
