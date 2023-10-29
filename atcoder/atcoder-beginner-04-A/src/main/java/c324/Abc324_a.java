package c324;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc324_a {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);
        return a[n - 1] == a[0] ? "Yes" : "No";
    }
}
/*
A - Same
https://atcoder.jp/contests/abc324/tasks/abc324_a

题目大意：
You are given N integers A1, A2,..., AN.
If their values are all equal, print Yes; otherwise, print No.

判断元素是否全部相等
======

Input 1
3
3 2 4
Output 1
No

Input 2
4
3 3 3 3
Output 2
Yes

Input 3
10
73 8 55 26 97 48 37 47 35 55
Output 3
No
 */
