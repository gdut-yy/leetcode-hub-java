package p1760;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1760C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] s = new int[n];
            for (int j = 0; j < n; j++) {
                s[j] = scanner.nextInt();
            }
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, int[] s) {
        int[] copy = s.clone();
        Arrays.sort(copy);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            if (s[i] != copy[n - 1]) {
                res[i] = String.valueOf(s[i] - copy[n - 1]);
            } else {
                res[i] = String.valueOf(s[i] - copy[n - 2]);
            }
        }
        return String.join(" ", res);
    }
}
/*
C. Advantage
https://codeforces.com/contest/1760/problem/C

题目大意：
给定整数 n 和长度为 n 的数组 s。输出 si 与任何其他参与者的最大强度之间的差值。

排序，如果是最大的就与次大的比，否则与最大的比。
======

input
5
4
4 7 3 5
2
1 2
5
1 2 3 4 5
3
4 9 4
4
4 4 4 4

output
-3 2 -4 -2
-1 1
-4 -3 -2 -1 1
-5 5 -5
0 0 0 0
 */