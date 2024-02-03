package p1236;

import java.util.Scanner;

public class CF1236B {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long ans = quickPow(quickPow(2, m) - 1, n);
        return String.valueOf(ans);
    }

    // 模下的 a^b
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
B. Alice and the List of Presents
https://codeforces.com/contest/1236/problem/B

灵茶の试炼 2023-12-05
题目大意：
输入 n(1≤n≤1e9) 和 m(1≤m≤1e9)。
有 n 种物品，每种物品有无数个。同一种物品都是相同的，无法区分。不同种类的物品都是不同的，可以区分。
选一些物品放入 m 个盒子。盒子都是不同的，可以区分。
要求：
1. 允许空盒。
2. 同一个盒子中，不能有相同的物品。
3. 每种物品都至少有一个装进某个盒子。
输出方案数。模 1e9+7。

rating 1500
如果 n=1，那么考虑每个盒子放还是不放，有 2^m 个方案，再去掉全都不放的方案，所以有 2^m - 1 个方案。
每种物品互相独立，所以答案是 (2^m-1)^n。
https://codeforces.com/problemset/submission/1236/235547959
======

input
1 3
output
7

input
2 2
output
9
 */
