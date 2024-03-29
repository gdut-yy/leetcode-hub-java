package c290;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc290_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(solve(n, d, k));
        }
    }

    private static String solve(int n, int d, int k) {
        k--;
        int a = n / getGCD(n, d);
        long ans = (long) d * k % n + k / a;
        return String.valueOf(ans);
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
D - Marking
https://atcoder.jp/contests/abc290/tasks/abc290_d

题目大意：
有 N 个索引为 0 到(N−1)的正方形排成一行。Snuke 将按照以下程序标记每个方格。
1.标记平方 0。
2.重复以下步骤 i ~ iii (N−1)次。
  1.用(a +D)modN 初始化变量 x，其中 a 是上次标记的正方形的索引。
  2.标记方块 x 时，重复将 x 替换为(x+1)modN。
  3.标记 x 的平方。
求 Snuke 第 k 次标记的正方形的索引。
给定 T 个测试用例，找到每个用例的答案。

为了解决这个问题，你需要知道（或通过实验等弄清楚）以下事实：
设 A 和 B 为正整数，g=gcd(A, B)，设 A=ag, B=bg。则整数 0, BmodA, 2BmodA, ..., (a-1)BmodA 包含 0, g, 2g, ..., (a-1)g（即 g 在 [0, a-1] 所有倍数）每个恰好一次。
例如，如果 A=12, B=9，其中 g=3, a=4, b=3，则 0, BmodA, 2BmodA, 3BmodA 分别为 0, 9, 6, 3，其中 g 在 0 到 A 之间的所有倍数各出现一次。
我们如何利用这个事实来解决原来的问题呢?首先，设 g 是 N 和 D 的最大公约数，设 N=gn, D=gd。
由于 0, DmodN, 2DmodN, ..., (n−1)DmodN 是不相同的，所以第 i 个(1≤i≤n) 个需要标记的方格为 (i−1)DmodN。
======

Input 1
9
4 2 1
4 2 2
4 2 3
4 2 4
5 8 1
5 8 2
5 8 3
5 8 4
5 8 5
Output 1
0
2
1
3
0
3
1
4
2
 */