package p1882;

import java.util.Scanner;

public class CF1882A {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = b[i - 1] + 1;
            if (b[i] == a[i]) b[i]++;
        }
        return String.valueOf(b[n]);
    }
}
/*
Codeforces Round 899 (Div. 2) https://mp.weixin.qq.com/s/n01WmMH0DLr3ERWX8ByjAA
A. Increasing Sequence
https://codeforces.com/contest/1882/problem/A

题目大意：
给定一个序列 a1,a2,...,an。如果序列 b1,b2,...,bn 满足以下所有条件，则称为好序列:
- bi 是一个正整数，对于 i=1,2,...,n;
- 当 i=1,2,...,n 时，Bi≠ai;
- b1 < b2 < ... < bn。
在所有好的序列 b1,b2,...,bn 中求 bn 的最小值。

贪心
======

input
3
5
1 3 2 6 7
4
2 3 4 5
1
1
output
8
4
2
 */