package p1650;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1650B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int a = scanner.nextInt();
            System.out.println(solve(l, r, a));
        }
    }

    private static String solve(int l, int r, int a) {
        int max;
        int div1 = l / a;
        int div2 = r / a;
        if (div1 == div2) {
            max = r / a + r % a;
        } else {
            int remain = r - (a - 1);
            max = remain / a + (a - 1);
        }
        return String.valueOf(max);
    }
}
/*
B. DIV + MOD
https://codeforces.com/contest/1650/problem/B

题目大意：
给定整数 li,ri,ai，求 li 到 ri 范围内的 floor(x/a) + x%a 最大值

贪心，优先考虑余数，x%a 最大可取到 a-1，再考虑 floor(x/a)
======

input
5
1 4 3
5 8 4
6 10 6
1 1000000000 1000000000
10 12 8

output
2
4
5
999999999
5
 */