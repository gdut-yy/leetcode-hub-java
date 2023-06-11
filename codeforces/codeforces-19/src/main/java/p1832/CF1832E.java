package p1832;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1832E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int a1 = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solve(n, a1, x, y, m, k));
    }

    private static final int MOD = 998244353;

    // https://codeforces.com/contest/1832/submission/205562791
    private static String solve(int n, int a1, int x, int y, int m, int k) {
        long[] a = new long[n];
        a[0] = a1;
        for (int i = 1; i < n; i++) {
            a[i] = (a[i - 1] * x + y) % m;
        }

        // k+1 轮前缀和
        for (int i = 0; i < k + 1; i++) {
            long[] b = new long[n];
            b[0] = a[0];
            for (int j = 1; j < n; j++) {
                b[j] = (b[j - 1] + a[j]) % MOD;
            }
            // swap
            a = b.clone();
        }

        // [0, k-1) 均为 0
        long ans = 0L;
        for (int i = k - 1; i < n; i++) {
            ans ^= a[i - (k - 1)] * (i + 1);
        }
        return String.valueOf(ans);
    }
}
/*
E. Combinatorics Problem
https://codeforces.com/contest/1832/problem/E

题目大意：
k=2
b2 = a1
b3 = 3a1 + a2
b4 = 6a1 + 3a2 + a3
b5 = 10a1 + 6a2 + 3a3 + a4
---
△5 = b5-b4 = 4a1 + 3a2 + 2a3 + a4
△4 = b4-b3 = 3a1 + 2a2 + a3
△3 = b3-b2 = 2a1 + a2
△2 = b2-b1 = a1
---
△△2 = a1
△△3 = a1 + a2
△△4 = a1 + a2 + a3
△△5 = a1 + a2 + a3 + a4

观察到 1≤k≤5
当 k = 2 时，需要做 3 次前缀和运算。
规律为 k+1 次前缀和运算
======

input
5 8 2 3 100 2
output
1283

1000 100 255 666 421377788 1
333167578662
 */
