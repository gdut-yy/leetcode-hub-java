package p1882;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1882D {
    static int n;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 0; i < n - 1; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                g[x].add(y);
                g[y].add(x);
            }
            System.out.println(solve());
        }
    }

    static long[] sz;
    static long[] ans;

    private static String solve() {
        sz = new long[n];
        ans = new long[n];
        ans[0] = dfs(0, -1);
        reroot(0, -1);
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static long dfs(int x, int fa) {
        sz[x] = 1;
        long res = 0;
        for (Integer y : g[x]) {
            if (y != fa) {
                res += dfs(y, x);
                res += sz[y] * (a[x] ^ a[y]);
                sz[x] += sz[y];
            }
        }
        return res;
    }

    static void reroot(int x, int fa) {
        if (x == 0) {
        } else {
            ans[x] = (n - sz[x]) * (a[x] ^ a[fa]);
            ans[x] += ans[fa] - sz[x] * (a[x] ^ a[fa]);
        }
        for (Integer y : g[x]) {
            if (y != fa) {
                reroot(y, x);
            }
        }
    }
}
/*
D. Tree XOR
https://codeforces.com/contest/1882/problem/D

题目大意：
给定一棵树，有 n 个顶点，标记为 1 到 n。当 i=1,2，…，n 时，在顶点 i 上写一个整数 ai。你想通过执行一些(可能是零)咒语让所有 ai 都相等。
假设树的根在某个顶点。在每个咒语中，你可以选择任意顶点 v 和任意非负整数 c。然后对于 v 的子树†中的所有顶点 i，将 ai 替换为 ai⊕c。这个法术的代价是 s·c，其中 s 是子树中的顶点数。这里 ⊕ 表示按位异或运算。
设 mr 为使所有 ai 相等所需的最小可能总代价，如果选择顶点 r 作为树的根。找出 m1,m2,...,mn。
†假设顶点 r 被选为树的根。如果从 i 到 r 的简单路径包含 v，那么顶点 i 属于 v 的子树。

树形 DP
考虑异或的性质，对于 x，要使它异或上 c 后，等于 y，有 x^c=y，所以 c=x^y。
先考虑以 1 为根节点的树。
要使所有元素相等，最终目标应该取哪个值最优？这里显然要取根节点，因为每次异或，都是取一整个子树为代价的。我们只能让其他儿子节点等于根节点的值 a[1]，而无法让根节点等于任意一个儿子节点。
要使所有元素等于 a[1]，需要让 1 的儿子节点的子树都等于 a[1]，对于儿子 v 来说，代价就是 sz[v]*(a[1]*a[v])，其中 sz[v]的子树大小。
递归计算这个过程，即可最终得到，以 1 为根节点的子树，所需的异或代价。
在知道以 p（u 的父亲节点）为根节点的子树的异或代价，以 u 为根节点的子树怎么计算？
在 ans[p]的基础上，减去 sz[u] * (a[u] ^ a[p])（因为这个时候的 u 是根节点了），再加上以 p 为儿子节点的贡献即可。
ans[u] = 1LL * (n - sz[u]) * (a[p] ^ a[u]);
ans[u] += ans[p] - 1LL * sz[u] * (a[u] ^ a[p]);
======

input
2
4
3 2 1 0
1 2
2 3
2 4
1
100
output
8 6 12 10
0
 */
