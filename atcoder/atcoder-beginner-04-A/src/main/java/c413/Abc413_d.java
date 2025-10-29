package c413;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Abc413_d {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        if (n <= 2) {
            out.println("Yes");
            return;
        }
        Arrays.sort(a, Comparator.comparingLong(Math::abs));

        if (check(a)) {
            out.println("Yes");
            return;
        }
        // 公比为-1
        if (check_r1(a)) {
            out.println("Yes");
            return;
        }
        out.println("No");
    }

    static boolean check_r1(Long[] a) {
        long abs = Math.abs(a[0]);
        int count_pos = 0;
        for (Long v : a) {
            if (Math.abs(v) != abs) return false;
            if (v > 0) count_pos++;
        }
        int count_neg = a.length - count_pos;
        return Math.abs(count_pos - count_neg) <= 1;
    }

    static boolean check(Long[] a) {
        for (int i = 1; i + 1 < a.length; i++) {
            if (a[i] * a[i] != a[i - 1] * a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
/*
D - Make Geometric Sequence
https://atcoder.jp/contests/abc413/tasks/abc413_d

题目大意：
给你一个长度为 N 的整数序列 A=(A1,A2,...,AN) 。对于任意 i (1<=i<=N) ，保证 A_i 不是 0 。
判断是否存在 A 的置换 B=(B_1,B_2,...,B_N) ，使得 B 构成一个几何数列。
如果存在一个实数 r ，使得所有整数 1<=i<N 中的 S_{i+1}=rS_i 都是 S=(S_1,S_2,...,S_N) ，那么序列 S=(S_1,S_2,...,S_N) 就是一个几何序列。
解决每个输入文件中的 T 个测试用例。

注意特判 r = -1 的情况。
1
4
1 -1 1 -1
======

Input 1
3
5
1 8 2 4 16
5
-16 24 54 81 -36
7
90000 8100 -27000 729 -300000 -2430 1000000
Output 1
Yes
No
Yes
 */
