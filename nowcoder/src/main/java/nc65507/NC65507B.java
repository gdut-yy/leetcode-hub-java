package nc65507;

import java.util.Scanner;

public class NC65507B {
    static int n, x, y;
    static int[][] ab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        int c = 0;
        for (int[] p : ab) {
            int a = p[0], b = p[1];
            if (a >= x && b <= y) {
                c++;
            }
        }
        // 2^c - 1
        long ans = quickPow(2, c) - 1;
        ans = (ans + MOD) % MOD;
        return String.valueOf(ans);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
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
小红买基金
https://ac.nowcoder.com/acm/contest/65507/B

题目描述
小红准备买一些基金。一共有 n 支基金，第 i 支基金的收益指数为 ai ，风险指数为 bi。小红准备买一些基金，但她不会买收益指数低于 x 的基金，也不会买风险指数超过 y 的基金。
小红想知道，一共有多少种买基金的方案？答案对 10^9+7 取模。
输入描述:
第一行输入三个正整数 n,x,y，用空格隔开。
接下来的 n 行，每行输入两个正整数 ai 和 bi，分别代表第 i 支基金的收益指数和风险指数。
1≤n≤200000
1≤x,y,ai,bi ≤10^9
输出描述:
一个整数，代表最终方案数量对 10^9 +7 取模的值。

枚举 + 快速幂
======

示例1
输入
5 2 3
1 2
1 4
3 1
5 4
3 2
输出
3
说明
共有3种方案：
方案1，只购买第三支基金。
方案2，只购买第五支基金。
方案3，购买第三支和第五支基金。
 */