package p1139;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1139C {
    static int n, k;
    static Map<Integer, List<Integer>> adj;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        adj = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int x = scanner.nextInt();
            if (x == 0) {
                adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
                adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
            }
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);
    private static boolean[] vis;

    private static String solve() {
        vis = new boolean[n];

        long ans = quickPow(n, k);
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ans -= quickPow(f(i), k);
            }
        }
        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }

    private static int f(int x) {
        vis[x] = true;
        int sz = 1;
        for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
            if (!vis[y]) {
                sz += f(y);
            }
        }
        return sz;
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
C. Edgy Trees
https://codeforces.com/contest/1139/problem/C

灵茶の试炼 2023-05-23
题目大意：
输入 n(2≤n≤1e5) k(2≤k≤100) 和一棵无向树的 n-1 条边（节点编号从 1 开始），每条边包含 3 个数 x y c，表示有一条颜色为 c 的边连接 x 和 y，其中 c 等于 0 或 1。
对于长为 k 节点序列 a，走最短路，按顺序经过节点 a1 -> a2 -> ... -> ak。
对于所有长为 k 的节点序列 a（这有 n^k 个），统计至少经过一条 c=1 的边的序列 a 的个数。

rating 1500
https://codeforces.com/contest/1139/submission/206859984
正难则反，统计只经过 c=0 的序列数。
相当于计算每个 c=0 组成的连通块的大小 sz，对应的只经过 c=0 序列数为 sz^k。
答案为 n^k - ∑sz^k，用快速幂计算。
======

input
4 4
1 2 1
2 3 1
3 4 1
output
252

input
4 6
1 2 0
1 3 0
1 4 0
output
0

input
3 5
1 2 1
2 3 0
output
210
 */
