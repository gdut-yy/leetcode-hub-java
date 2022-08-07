package p1692;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1692G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, k, a));
        }
    }

    private static String solve(int n, int k, int[] a) {
        // 贪心
        int res = 0;
        int cnt = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i] < a[i + 1] * 2) {
                cnt++;
            } else {
                res += Math.max(0, cnt - k + 1);
                cnt = 0;
            }
        }
        res += Math.max(0, cnt - k + 1);
        return String.valueOf(res);
    }
}
/*
G. 2^Sort
https://codeforces.com/contest/1692/problem/G

题目大意：
给定整数 n,k 和长度为 n 的数组 a，求有多少组 a[i]*2^0 < a[i+1]*2^1 < ··· < a[i+k]*2^k

线性遍历。判断 a[i-1] < a[i] * 2 即可。
======

input
6
4 2
20 22 19 84
5 1
9 5 3 2 1
5 2
9 5 3 2 1
7 2
22 12 16 4 3 22 12
7 3
22 12 16 4 3 22 12
9 3
3 9 12 3 9 12 3 9 12

output
2
3
2
3
1
0
 */