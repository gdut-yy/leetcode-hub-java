package p1744;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1744E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.println(solve(a, b, c, d));
        }
    }

    private static String solve(int a, int b, int c, int d) {
        long ab = (long) a * b;

        List<Integer> aFactors = breakdown(a);
        List<Integer> bFactors = breakdown(b);
        for (long aFactor : aFactors) {
            for (long bFactor : bFactors) {
                long x = aFactor * bFactor;
                // s = a·b·gdc(a·b, x) = a·b·a'·b'
//                long s = ab * x;

                x = c / x * x;
                if (a < x) {
                    long y = ab / getGCD(ab, x);
                    y = d / y * y;
                    if (b < y) {
                        return x + " " + y;
                    }
                }
            }
        }
        return "-1 -1";
    }

    private static long getGCD(long num1, long num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }

    private static List<Integer> breakdown(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                factors.add(num / i);
            }
        }
        return factors;
    }

}
/*
E2. Divisible Numbers (hard version)
https://codeforces.com/contest/1744/problem/E2

======

input
10
1 1 2 2
3 4 5 7
8 9 15 18
12 21 14 24
36 60 48 66
1024 729 373248 730
1024 729 373247 730
5040 40320 40319 1000000000
999999999 999999999 1000000000 1000000000
268435456 268435456 1000000000 1000000000

output
2 2
4 6
12 12
-1 -1
-1 -1
373248 730
-1 -1
15120 53760
-1 -1
536870912 536870912
 */
