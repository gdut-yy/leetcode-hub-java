package c284;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc284_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            System.out.println(solve(n));
        }
    }

    private static String solve(long n) {
        long p = -1;
        long q = -1;
        for (long i = 2; i * i * i <= n; i++) {
            if (n % i == 0) {
                // i * j == N
                long j = n / i;
                if (j % i == 0) {
                    p = i;
                    q = j / i;
                } else {
                    q = i;
                    p = (long) Math.sqrt(j);
                }
                break;
            }
        }
        return p + " " + q;
    }
}
/*
D - Happy New Year 2023
https://atcoder.jp/contests/abc284/tasks/abc284_d

题目大意：
给定一个正整数 N，已知 N 可以用两个不同的素数 p 和 q 表示为 N= p^2 * q。
求出 p 和 q。
你有 T 个测试用例需要解决。

质因数分解
时间复杂度 O(3√n)
======

Input 1
3
2023
63
1059872604593911
Output 1
17 7
3 7
104149 97711
 */