package p1759;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1759D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(solve(n, m));
        }
    }

    private static String solve(long n, long m) {
        long n0 = n;
        int cnt2 = 0;
        int cnt5 = 0;
        long k = 1L;
        while (n > 0 && n % 2 == 0) {
            n /= 2;
            cnt2++;
        }
        while (n > 0 && n % 5 == 0) {
            n /= 5;
            cnt5++;
        }
        while (cnt2 < cnt5 && k * 2 <= m) {
            cnt2++;
            k *= 2;
        }
        while (cnt5 < cnt2 && k * 5 <= m) {
            cnt5++;
            k *= 5;
        }
        while (k * 10 <= m) {
            k *= 10;
        }
        k = m / k * k; // 1 <= m/k < 10
        return String.valueOf(n0 * k);
    }
}
/*
D. Make It Round
https://codeforces.com/contest/1759/problem/D

灵茶の试炼 2024-05-06
题目大意：
给定整数 n,m。n 是商品的旧价格，数字 m 意味着你可以将价格 n 增加不超过 m 次。输出末尾 0 最多的新价格。

rating 1400
贪心。由于 n 不可变而 m 可变。因此先计算 n 中有多少 2 因子和 5 因子。再从 m 尽可能凑到 cnt2 == cnt5
======

input
10
6 11
5 43
13 5
4 16
10050 12345
2 6
4 30
25 10
2 81
1 7

output
60
200
65
60
120600000
10
100
200
100
7
 */