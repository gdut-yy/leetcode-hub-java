package c296;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc296_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, x, a));
    }

    private static String solve(int n, int x, int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int ai : a) {
            set.add(ai);
        }
        for (int ai : a) {
            if (set.contains(ai - x) || set.contains(ai + x)) {
                return "Yes";
            }
        }
        return "No";
    }
}
/*
C - Gap Existence
https://atcoder.jp/contests/abc296/tasks/abc296_c

题目大意：
给定一个 N 个数的序列:a = (a1,...aN)。
判断是否存在一对(i,j)，且 1≤i,j≤N，使得 ai−aj =X。

HashSet 模拟
======

Input
6 5
3 1 4 1 5 9
Output
Yes

Input
6 -4
-2 -7 -1 -8 -2 -8
Output
No

Input
2 0
141421356 17320508
Output
Yes
 */