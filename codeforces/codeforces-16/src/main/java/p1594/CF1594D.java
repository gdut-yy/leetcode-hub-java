package p1594;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1594D {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int[] fa, dis;

    static int find(int x) {
        if (fa[x] != x) {
            int ffx = find(fa[x]);
            dis[x] ^= dis[fa[x]];
            fa[x] = ffx;
        }
        return fa[x];
    }

    static boolean merge(int x, int y, int d) {
        int fx = find(x), fy = find(y);
        if (fx == fy) return (dis[x] ^ dis[y]) == d;
        dis[fx] = d ^ dis[y] ^ dis[x];
        fa[fx] = fy;
        return true;
    }

    private static void solve() {
        int n = scanner.nextInt(), m = scanner.nextInt();
        fa = new int[n];
        dis = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        boolean ok = true;
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1, w = scanner.nextInt() - 1;
            String s = scanner.next();
            int d = s.charAt(1) & 1;
            if (ok && !merge(v, w, d)) ok = false;
        }
        if (!ok) {
            out.println(-1);
            return;
        }
        int[][] cnt = new int[n][2];
        for (int i = 0; i < n; i++) {
            find(i);
            cnt[fa[i]][dis[i]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) ans += Math.max(cnt[i][0], cnt[i][1]);
        out.println(ans);
    }
}
/*
D. The Number of Imposters
https://codeforces.com/contest/1594/problem/D

灵茶の试炼 2026-04-01
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤5e5。
每组数据输入 n(1≤n≤2e5) m(0≤m≤5e5)。
有 n 个人，编号从 1 到 n，每个人要么是只说真话的好人，要么是只说假话的坏人。
然后输入 m 句话，每句话的格式为如下二者之一 (i≠j)：
"i j crewmate"，表示 i 说 j 是好人。
"i j imposter"，表示 i 说 j 是坏人。
如果这 m 句话中有矛盾，输出 -1。
否则输出最多可以有多少个坏人。

rating 1700
如果 A 说 B 是好人，那么：
- 如果 A 是好人，那么 B 也是好人。
- 如果 A 是坏人，那么 B 不是好人，即坏人。
- 如果 B 确实是好人，那么 A 也是好人。如果 B 确实是坏人，那么 A 也是坏人。
所以这两个人是同一阵营的人。
同理可以推导出，如果 A 说 B 是坏人，那么这两个人是不同阵营的人。
把一句话视作一条边，边权：crewmate 视作 0，imposter 视作 1。
同一连通块中的两个人，如果距离是偶数，那么这两个人是同一阵营的人，否则是不同阵营的人。
比如 a 和 b 不同阵营，b 和 c 不同阵营，那么 a 和 c 是同一阵营。
用带权并查集（异或运算）处理。
如果没有矛盾的话，对于属于同一个连通块的人，统计：
- 有多少个人和代表元是同一阵营，设为 cnt0。
- 有多少个人和代表元是不同阵营，设为 cnt1。
代表元可以是好人，也可以是坏人，所以这个连通块对答案（坏人个数）的贡献是 max(cnt0, cnt1)。
代码 https://codeforces.com/problemset/submission/1594/368954131
代码备份（上面打不开的同学看这个）
======

Input
5
3 2
1 2 imposter
2 3 crewmate
5 4
1 3 crewmate
2 5 crewmate
2 4 imposter
3 4 imposter
2 2
1 2 imposter
2 1 crewmate
3 5
1 2 imposter
1 2 imposter
3 2 crewmate
3 2 crewmate
1 3 imposter
5 0
Output
2
4
-1
2
5
 */
