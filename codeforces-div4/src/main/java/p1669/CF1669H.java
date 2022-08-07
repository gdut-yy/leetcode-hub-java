package p1669;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1669H {
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
        int[] cnt = new int[31];
        for (int i = 0; i < n; i++) {
            for (int j = 30; j >= 0; j--) {
                // 为 0 的位
                if (((a[i] >> j) & 1) == 0) {
                    cnt[j]++;
                }
            }
        }

        int res = 0;
        for (int j = 30; j >= 0; j--) {
            if (cnt[j] <= k) {
                k -= cnt[j];
                res += (1 << j);
            }
        }
        return String.valueOf(res);
    }
}
/*
H. Maximal AND
https://codeforces.com/contest/1669/problem/H

题目大意：
给定整数 n 和 k 及长度为 n 的数组 a，可选择任意 ai 替换为为 ai 或 2^j（0 <= j <= 30），求不超过 k 次操作可以得到的最大 AND 和

贪心。由高位到低位，如果可以使 a[i] 在二进制 j 位全为 1，则进行操作。
======

input
4
3 2
2 1 1
7 0
4 6 6 28 6 6 12
1 30
0
4 4
3 1 3 1

output
2
4
2147483646
1073741825
 */