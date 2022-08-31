package p1722;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1722G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        int case1 = 0;
        int case2 = 0;
        for (int i = 0; i < n - 2; i++) {
            case1 ^= i;
            case2 ^= (i + 1);
        }
        long addLast = (1L << 31) - 1;

        List<String> resList = new ArrayList<>();
        if (case1 != 0) {
            for (int i = 0; i < n - 2; i++) {
                resList.add(String.valueOf(i));
            }
            case1 ^= addLast;
            resList.add(String.valueOf(addLast));
            resList.add(String.valueOf(case1));
        } else {
            for (int i = 1; i <= n - 2; i++) {
                resList.add(String.valueOf(i));
            }
            case2 ^= addLast;
            resList.add(String.valueOf(addLast));
            resList.add(String.valueOf(case2));
        }
        return String.join(" ", resList);
    }
}
/*
G. Even-Odd XOR
https://codeforces.com/contest/1722/problem/G

题目大意：
给定整数 n，需输出 n 个不等的数，奇数位异或和 等于 偶数位异或和。

若能满足条件，必然有 n 个数的 异或和 等于 0。可考虑前 n-1 个数随便取，第 n 个数取它的异或，但不能保证这 n 个数互不相等。
如果前 n-2 个数异或和为 0，那么第 n-1 和第 n 个数会相等
======

input
7
8
3
4
5
6
7
9

output
4 2 1 5 0 6 7 3
2 1 3
2 1 3 0
2 0 4 5 3
4 1 2 12 3 8
1 2 3 4 5 6 7
8 2 3 7 4 0 5 6 9
 */