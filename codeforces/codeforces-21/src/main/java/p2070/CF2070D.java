package p2070;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CF2070D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int MOD = 998244353;

    private static void solve() {
        int n = scanner.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());

        int[] d = new int[n];
        ArrayList<Integer>[] row = new ArrayList[n];
        Arrays.setAll(row, e -> new ArrayList<>());

        for (int i = 1; i < n; i++) {
            int p = scanner.nextInt() - 1;
            g[p].add(i);
            d[i] = d[p] + 1;
            row[d[i]].add(i);
        }

        int[] f = new int[n];
        int pre = 0;
        for (int i = n - 1; i > 0; i--) {
            int cur = 0;
            for (int v : row[i]) {
                int sum = pre;
                for (int w : g[v]) {
                    sum = (sum - f[w] + MOD) % MOD;
                }
                f[v] = (sum + 1) % MOD;
                cur = (cur + f[v]) % MOD;
            }
            pre = cur;
        }
        long ans = ((pre + 1) % MOD + MOD) % MOD;
        out.println(ans);
    }
}
/*
D. Tree Jumps
https://codeforces.com/contest/2070/problem/D

灵茶の试炼 2025-09-24
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据先输入 n(2≤n≤3e5)，然后输入一棵有 n 个节点的树，节点编号从 1 到 n，根节点是 1。
输入格式为 p2,p3,...,pn，分别表示节点 2,3,...,n 的父节点。保证 1≤p[i]<i。
计算有多少个满足如下要求的非空节点序列 b。下标从 1 开始。
1. b[i] 是树的第 i 层的一个节点。（所以 b[1] 是根节点）
2. 当 i ≥ 2 时，b[i] 不是 b[i+1] 的父节点。
输出合法序列个数，模 998244353。

rating 1600
对于节点 x，其可以跳到下一层的非 x 儿子节点。
然后从下一层的节点 y 出发继续跳，这是规模更小的子问题。
所以定义 f[x] 表示从 x 出发的方案数。
f[x] = 1 + sum(f[y] for y in 下一排节点) - sum(f[y] for y in {x 的儿子})
其中 1 表示不往下跳，也是一种方案。
上式需要从下往上层序计算，所以要先 DFS/BFS 预处理每一层的节点。
答案为 1 + sum(f[x] for x in {根节点的儿子})。
注意本题保证 p[i] <= i，无需建图。
代码 https://codeforces.com/contest/2070/submission/339328706
代码备份（上面打不开的同学看这个）
======

Input
3
4
1 2 1
3
1 2
7
1 2 2 1 4 5
Output
4
2
8
 */
