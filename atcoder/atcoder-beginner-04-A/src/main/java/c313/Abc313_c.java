package c313;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc313_c {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long sum = 0;
        for (int x : a) {
            sum += x;
        }
        long avg = sum / n;
        int remain = (int) (sum % n);

        Arrays.sort(a);
        long ans = 0;
        for (int i = 0; i < n - remain; i++) {
            if (avg - a[i] > 0) {
                ans += avg - a[i];
            }
        }
        for (int i = n - remain; i < n; i++) {
            if (avg + 1 - a[i] > 0) {
                ans += avg + 1 - a[i];
            }
        }
        return String.valueOf(ans);
    }
}
/*
C - Approximate Equalization 2
https://atcoder.jp/contests/abc313/tasks/abc313_c

题目大意：
给定一个整数序列 A=(A 1,A 2，…，A N)。您可以执行以下操作任意次数(可能为零)。
选择 1≤i,j≤N 的整数 i 和 j。A i 减 1,A j 增 1。
找出使 A 的最小值和最大值(不超过 1)之差所需的最小操作数。

贪心
======

Input 1
4
4 7 3 7
Output 1
3

Input 2
1
313
Output 2
0

Input 3
10
999999997 999999999 4 3 2 4 999999990 8 999999991 999999993
Output 3
2499999974
 */