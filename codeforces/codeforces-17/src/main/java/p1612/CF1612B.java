package p1612;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1612B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(solve(n, a, b));
        }
    }

    private static String solve(int n, int a, int b) {
        int halfN = n / 2;

        boolean canSolve;
        if (a < b) {
            canSolve = n - a - 1 >= halfN - 1 && b - 1 - 1 >= halfN - 1;
        } else {
            canSolve = n - a >= halfN - 1 && b - 1 >= halfN - 1;
        }
        if (canSolve) {
            String[] res = new String[n];
            res[0] = String.valueOf(a);
            res[n - 1] = String.valueOf(b);
            int idx = 1;
            for (int i = n; i >= 1; i--) {
                if (i != a && i != b) {
                    res[idx] = String.valueOf(i);
                    idx++;
                }
            }
            return String.join(" ", res);
        } else {
            return "-1";
        }
    }
}
/*
B. Special Permutation
https://codeforces.com/contest/1612/problem/B

题目大意：
给出整数 n,a,b。n 为偶数，表示 1 到 n 的排列，判断能否输出排列，使左半部分所有元素中最小值为 a，右半部分所有元素中最大值为 b

贪心即可，若有解，则左半部分需要 n/2-1 个比 a 大的数，右半部分需要 n/2-1 个比 b 小的数。
======

input
7
6 2 5
6 1 3
6 4 3
4 2 4
10 5 3
2 1 2
2 2 1

output
4 2 6 5 3 1
-1
6 4 5 1 3 2
3 2 4 1
-1
1 2
2 1
 */