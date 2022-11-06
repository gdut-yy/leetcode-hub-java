package p1749;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1749B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                b[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a, b));
        }
    }

    private static String solve(int n, int[] a, int[] b) {
        int maxB = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += a[i] + b[i];
            maxB = Math.max(maxB, b[i]);
        }
        return String.valueOf(res - maxB);
    }
}
/*
B. Death's Blessing
https://codeforces.com/contest/1749/problem/B

题目大意：
给定整数 n 和长度为 n 的数组 a,b。ai 表示对应怪物的初始生命值，bi 表示第 i 个怪物的法术强度。
当第 i 个怪物死亡时，它会施放一个法术，使其邻居的生命值提高 bi (队列中第 j 个怪物的邻居是 j−1 和 j+1 位置的怪物)
求杀死所有怪物的最小可能总时间

观察规律，发现只能减免一次 bi，贪心减去最大的 bi 即可。
======

input
4
1
10
0
3
100 1 100
1 100 1
4
2 6 7 3
3 6 0 5
2
1000000000 1000000000
1000000000 1000000000

output
10
203
26
3000000000
 */