package lq240113;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LQ240113T8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 1; i <= n; ++i) {
            G[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; ++i) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            G[u].add(v);
            G[v].add(u);
        }

        bfs1();
        bfs2();
        long t = 0;
        for (int i = 2; i <= n; ++i) {
            t += ans[i];
            t %= MOD;
        }
        System.out.println(t * quickPow(n, MOD - 2) % MOD);
    }

    static final int N = 1000100;
    static List<Integer>[] G = new ArrayList[N];
    static int[][] fa = new int[N][20];
    static int[] ans = new int[N];
    static int[] dep = new int[N];
    static int[] ddep = new int[N];

    static int n;
    static int MOD = 998244353;

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    static int[] qq = new int[N];

    static void bfs1() {
        int l = 1, r = 0;
        for (int i = 1; i <= n; ++i) ddep[i] = -1;
        qq[++r] = 1;
        dep[1] = ddep[1] = 0;
        fa[1][0] = 0;
        while (l <= r) {
            int u = qq[l++];
            for (int v : G[u]) {
                if (ddep[v] == -1) {
                    dep[v] = ddep[v] = ddep[u] + 1;
                    fa[v][0] = u;
                    qq[++r] = v;
                }
            }
        }
        for (int u = 1; u <= n; ++u) {
            for (int j = 1; j < 20; ++j) {
                fa[u][j] = fa[fa[u][j - 1]][j - 1];
            }
        }
        for (int i = n; i > 0; --i) {
            int u = qq[i];
            dep[fa[u][0]] = Math.max(dep[fa[u][0]], dep[u]);
        }
    }

    static void bfs2() {
        for (int u = 2; u <= n; ++u) {
            int pos = ddep[u] / 2 + 1;
            int x = u, gg = ddep[u];
            ans[u] = dep[u];
            for (int i = 19; i >= 0; --i) {
                if (gg - (1 << i) >= pos) {
                    x = fa[x][i];
                    ans[u] = Math.max(ans[u], dep[x]);
                    gg -= (1 << i);
                }
            }
        }
    }
}
/*
逃跑【算法赛】

解题思路
考察倍增。
首先考虑如何计算期望，一种相对而言简单的方法是，我们计算出每个点的最大值，然后取平均即可。
然后我们的问题就转变为了如何计算出每个点的最大值。
由于两人是等速移动，所以我们优先移动到桥需要移动的最远的地方。
我们以 1 号点为根。
第一种方案是，小蓝向下移动，移动到当前子树的最远儿子节点。
第二种方案是，小蓝先向上移动，然后再向下，当前子树的最远儿子节点。需要注意的是，在向上的过程中，不能被小桥抓住。即向上移动的步数要小于小桥到达该点的步数。
所以我们维护两个值，一个是当前点能到达的最远儿子节点，一个是当前点的深度，然后然后对于每个点，用倍增的方式跳父亲即可。
复杂度：O(nlogn)。
 */