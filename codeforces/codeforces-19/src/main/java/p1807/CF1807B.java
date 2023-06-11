package p1807;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1807B {
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
        int odd = 0, even = 0;
        for (int x : a) {
            if ((x & 1) == 1) {
                odd += x;
            } else {
                even += x;
            }
        }
        return even > odd ? "YES" : "NO";
    }
}
/*
B. Grab the Candies
https://codeforces.com/contest/1807/problem/B

题目大意：
给定整数 n 和长度为 n 的数组 a。判断偶数的和是否严格大于奇数的和。

模拟。
======

input
3
4
1 2 3 4
4
1 1 1 2
3
1 4 3
output
YES
NO
NO
 */
