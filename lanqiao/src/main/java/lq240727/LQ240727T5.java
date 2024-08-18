package lq240727;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ240727T5 {
    static int n;
    static char[] s;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        ans = 0;
        dep = new long[n];
        s0 = new long[n];
        s1 = new long[n];

        dfs(0, -1, 1);
        return String.valueOf(ans);
    }

    static long ans;
    static long[] dep, s0, s1;

    static void dfs(int u, int p, int d) {
        dep[u] = d;
        long c0 = 0, c1 = 0;
        for (Integer v : g[u]) {
            if (v == p) continue;
            dfs(v, u, d + 1);
            c0 += s0[v];
            c1 += s1[v];
        }

        s0[u] = c0;
        s1[u] = c1;
        if (s[u] == '0') {
            ans = (ans + c1 * dep[u]) % MOD;
            s0[u] += 1;
        } else {
            ans = (ans + c0 * dep[u]) % MOD;
            s1[u] += 1;
        }

        for (Integer v : g[u]) {
            if (v == p) continue;
            c0 -= s0[v];
            c1 -= s1[v];
            ans = (ans + (c0 * s1[v] + c1 * s0[v]) * dep[u]) % MOD;
        }
    }
}
/*
蟠桃树【算法赛】

假设有 lca(u, v) = k，我们不应该将注意力放在 u, v 上，而是放在 k 上。考虑枚举每个点 i 作为 k，有多少对 (u, v) 满足条件，
假设有 x 对 (u, v) 满足条件，则第 i 个点对答案的贡献为 x * di，di 表示第 i 个点的深度。
- 思考 1：怎样的 (u, v) 满足 lca(u, v) = k。
我们假设点 k 有 c 个儿子，将这些以儿子为根的树设为集合 s1,s2,s3,...,sc。显然 (u, v) 肯定属于这若干个儿子集合其中某一个，
并且 (u, v) 不能属于同一个儿子集合（否则不会满足 lca(u, v) = k）。
问题转变为 s1,s2,s3,...,sc 选择两个不同的集合，并从两个集合选择不同颜色点的方案数。这一点我们只需要预处理得到每个集合内黑色点的个数和白色点的个数即可。
上面的处理没考虑 u=k 或 v=k 的情况，我们还需要特判这种情况。
综上所述，深度优先搜索一遍即可完成本题。时间复杂度 O(n)。
 */