package p1825;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1825D2 {
    static int n, k;
    static int[][] uv;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        uv = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            uv[i][0] = scanner.nextInt();
            uv[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);
    private static Map<Integer, List<Integer>> adj;
    private static int[] sz;
    private static long ans, inv;
    private static Comb comb;

    // https://codeforces.com/contest/1824/submission/205086508
    private static String solve() {
        adj = new HashMap<>();
        for (int[] p : uv) {
            int x = p[0] - 1, y = p[1] - 1;
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
        }

        ans = 1;
        if (k % 2 == 0) {
            comb = new Comb(n);
            inv = quickPow(comb.binom(n, k), MOD - 2);
            sz = new int[n];
            dfs(0, -1);
        }
        return String.valueOf(ans);
    }

    private static void dfs(int x, int fa) {
        sz[x] = 1;
        for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            dfs(y, x);
            sz[x] += sz[y];
            ans += comb.binom(sz[y], k / 2) * comb.binom(n - sz[y], k / 2) % MOD * inv % MOD;
            ans %= MOD;
        }
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

    private static class Comb {
        private final long[] fac, invfac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) {
                fac[i] = fac[i - 1] * i % MOD;
            }
            invfac = new long[n + 1];
            for (int i = 0; i <= n; i++) {
                invfac[i] = quickPow(fac[i], MOD - 2);
            }
        }

        // C(n, m) = n! / m!(n-m)!
        private long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * invfac[m] % MOD * invfac[n - m] % MOD;
        }

        // 模下的 a^b
        private long quickPow(long a, long b) {
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
}
/*
D2. LuoTianyi and the Floating Islands (Hard Version)
https://codeforces.com/contest/1825/problem/D2

题目大意：
这是这个问题的难点。唯一的区别是在这个版本中 k≤n。只有在两个版本的问题都解决了的情况下，你才能进行 hack。（D1 k≤min(n,3)）
Chtholly 和浮动岛屿。罗天一现在生活在一个有五座浮岛的世界里。浮岛之间由 n−1 条无向航线连接，任意两个浮岛都可以通过这些航线到达对方。也就是说，n 个浮岛组成了一棵树。
有一天，罗天一想见见她的朋友:Chtholly, Nephren, William， ....当然，她想认识 k 个人。她不知道它们的确切位置，但她知道它们在成对的不同岛屿上。她定义一个岛屿是好的，当且仅当从它到有 k 人的岛屿的距离总和是所有 n 个岛屿中最小的。
现在，罗天一想知道，如果 k 个人随机分布在 n 个岛屿中的 k 个不同的岛屿上，那么理想岛屿的期望数目是多少?你只需要告诉她期望的数对 10^9+7 取模。
两个岛屿之间的距离是你从一个岛屿到另一个岛屿所需的最少航线数。
---
给定一棵树，随机在树上放 k 个互不相同的特殊点。
定义好点为：到所有特殊点的距离之和最小的点。
问：好点个数的期望。

先转换到点，在转换到边
k 为奇数的时候，只有一个点，答案为 1
k 为偶数的时候，答案为 1 + ∑C(sz, k/2) * C(n-sz, k/2) / C(n, k)
======

input
4 2
1 2
2 3
3 4
output
666666674

input
5 5
1 2
2 3
3 4
3 5
output
1
 */