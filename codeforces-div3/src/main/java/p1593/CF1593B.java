package p1593;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1593B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            System.out.println(solve(n));
        }
    }

    private static String solve(long n) {
        String nStr = String.valueOf(n);
        if (nStr.endsWith("00") || nStr.endsWith("25") || nStr.endsWith("50") || nStr.endsWith("75")) {
            return "0";
        }
        int res = Integer.MAX_VALUE;
        String reverse = new StringBuilder(nStr).reverse().toString();
        int indexOf0 = reverse.indexOf("0");
        if (indexOf0 > -1) {
            int indexOf00 = reverse.substring(indexOf0 + 1).indexOf("0");
            int indexOf05 = reverse.substring(indexOf0 + 1).indexOf("5");
            if (indexOf00 > -1) {
                res = Math.min(res, indexOf0 + indexOf00);
            }
            if (indexOf05 > -1) {
                res = Math.min(res, indexOf0 + indexOf05);
            }
        }
        int indexOf5 = reverse.indexOf("5");
        if (indexOf5 > -1) {
            int indexOf52 = reverse.substring(indexOf5 + 1).indexOf("2");
            int indexOf57 = reverse.substring(indexOf5 + 1).indexOf("7");
            if (indexOf52 > -1) {
                res = Math.min(res, indexOf5 + indexOf52);
            }
            if (indexOf57 > -1) {
                res = Math.min(res, indexOf5 + indexOf57);
            }
        }
        return String.valueOf(res);
    }
}
/*
B. Make it Divisible by 25
https://codeforces.com/contest/1593/problem/B

题目大意：
给出一个正整数 n，每次删除一个数字，前导 0 会自动删除，求最少删除多少次能得到被 25 整除的正整数。

冷知识：能被 25 整除的正整数，结尾必定为 00,25,50,75
分别计算这 4 种 case 的次数，取最小值即可。
======

input
5
100
71345
3259
50555
2050047

output
0
3
1
3
2
 */