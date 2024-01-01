package p1673;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1673C {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            System.out.println(solve());
        }
    }

    static final int MAX_N = (int) (4e4 + 5);
    static final int MOD = (int) (1e9 + 7);
    static List<Integer> pal;
    static long[] f;

    static {
        pal = new ArrayList<>();
        for (int i = 1; i < 400; i++) {
            int p = i;
            for (int x = i / 10; x > 0; x /= 10) {
                p = p * 10 + x % 10;
            }
            pal.add(p);
            if (i < 100) {
                p = i;
                for (int x = i; x > 0; x /= 10) {
                    p = p * 10 + x % 10;
                }
                pal.add(p);
            }
        }
        // 完全背包
        f = new long[MAX_N];
        f[0] = 1;
        for (Integer v : pal) {
            for (int j = v; j < MAX_N; j++) {
                f[j] = (f[j] + f[j - v]) % MOD;
            }
        }
    }

    private static String solve() {
        return String.valueOf(f[n]);
    }
}
/*
C. Palindrome Basis
https://codeforces.com/contest/1673/problem/C

灵茶の试炼 2023-11-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 n(1≤n≤4e4)。
输出把 n 拆分成若干回文数之和的方案数。模 1e9+7。
例如 3 有 3 种方案：3, 2+1, 1+1+1。

预处理 4e4 内的回文数，然后跑完全背包。
如何高效枚举回文数请看代码。
https://codeforces.com/problemset/submission/1673/231925676
======

input
2
5
12
output
7
74
 */
