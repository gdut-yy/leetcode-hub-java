package p1669;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1669C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        int evenRemainder = a[0] % 2;
        int oddRemainder = a[1] % 2;
        for (int i = 0; i < n; i += 2) {
            if (a[i] % 2 != evenRemainder) {
                return "NO";
            }
        }
        for (int i = 1; i < n; i += 2) {
            if (a[i] % 2 != oddRemainder) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
C. Odd/Even Increments
https://codeforces.com/contest/1669/problem/C

题目大意：
给定长度为 n 的数组 a，可以奇数下标+1 或者偶数下标+1 若干次，问数组 a 最后能否奇偶相等

分别判断 奇数下标奇偶性是否一致 和 偶数下标奇偶性是否一致 即可。
======

input
4
3
1 2 1
4
2 2 2 3
4
2 2 2 2
5
1000 1 1000 1 1000

output
YES
NO
YES
YES
 */