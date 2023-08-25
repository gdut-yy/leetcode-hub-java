package c296;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc296_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(solve(n, m));
    }

    private static String solve(long n, long m) {
        long sqrt = (long) Math.ceil(Math.sqrt(m));
        if (sqrt > n) {
            return "-1";
        }

        long ans = Long.MAX_VALUE;
        for (long a = sqrt; a >= 1; a--) {
            // 数论向上取整法
            // 保证 a * b >= m
            long b = (m + a - 1) / a;
            if (b > n) {
                break;
            }
            ans = Math.min(ans, a * b);
        }
        return ans == Long.MAX_VALUE ? "-1" : String.valueOf(ans);
    }
}
/*
D - M<=ab
https://atcoder.jp/contests/abc296/tasks/abc296_d

灵茶の试炼 2023-08-22
题目大意：
给定正整数 N 和 m，找出满足下面两个条件的最小正整数 X，如果没有这样的整数，则输出 −1。
- X 可以表示为 1 到 N 之间的两个整数 a 和 b 的乘积。这里，a 和 b 可能是一样的。
- X 至少是 M。
相似题目: 1362. 最接近的因数
https://leetcode.cn/problems/closest-divisors/
======

Input
5 7
Output
8

Input
2 5
Output
-1

Input
100000 10000000000
Output
10000000000
 */