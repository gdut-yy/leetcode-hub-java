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

            k--;
            int a = n / getGCD(n, d);
            long res = (long) d * k % n + k / a;
            System.out.println(res);
        }
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

为了解决这个问题，你需要知道（或通过实验等弄清楚）以下事实：
设 A 和 B 为正整数，g=gcd(A, B)，设 A=ag, B=bg。则整数 0, BmodA, 2BmodA, ..., (a-1)BmodA 包含 0, g, 2g, ..., (a-1)g（即 g 在 [0, a-1] 所有倍数）每个恰好一次。
例如，如果 A=12, B=9，其中 g=3, a=4, b=3，则 0, BmodA, 2BmodA, 3BmodA 分别为 0, 9, 6, 3，其中 g 在 0 到 A 之间的所有倍数各出现一次。
我们如何利用这个事实来解决原来的问题呢?首先，设 g 是 N 和 D 的最大公约数，设 N=gn, D=gd。
由于 0, DmodN, 2DmodN, ..., (n−1)DmodN 是不相同的，所以第 i 个(1≤i≤n) 个需要标记的方格为 (i−1)DmodN。
 */