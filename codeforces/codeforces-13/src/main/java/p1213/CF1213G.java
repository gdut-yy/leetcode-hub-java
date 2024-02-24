package p1213;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1213G {
    static int n, m;
    static int[][] es;
    static int[][] qs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        es = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            es[i][0] = scanner.nextInt();
            es[i][1] = scanner.nextInt();
            es[i][2] = scanner.nextInt();
        }
        qs = new int[m][2];
        for (int i = 0; i < m; i++) {
            qs[i][0] = scanner.nextInt();
            qs[i][1] = i;
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(es, Comparator.comparingInt(o -> o[2]));
        Arrays.sort(qs, Comparator.comparingInt(o -> o[0]));

        DSU dsu = new DSU(n + 1);
        long[] ans = new long[m];
        long c = 0;
        int i = 0;
        for (int[] q : qs) {
            for (; i < n - 1 && es[i][2] <= q[0]; i++) {
                int v = dsu.find(es[i][0]);
                int w = dsu.find(es[i][1]);
                c += (long) dsu.sz[v] * dsu.sz[w];
                dsu.fa[v] = w;
                dsu.sz[w] += dsu.sz[v];
            }
            ans[q[1]] = c;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static class DSU {
        int[] fa;
        int[] sz;

        public DSU(int n) {
            fa = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                sz[i] = 1;
            }
        }

        int find(int x) {
            if (x != fa[x]) fa[x] = find(fa[x]);
            return fa[x];
        }
    }
}
/*
G. Path Queries
https://codeforces.com/contest/1213/problem/G

灵茶の试炼 2022-09-26
题目大意：
输入 n(≤2e5) 和 m(≤2e5)，表示一棵有 n 个节点的树，和 m 个询问。
然后输入 n-1 条边：这条边所连接的两点的编号（从 1 开始），以及边权(1≤边权≤2e5)。
最后输入 m 个询问 q[i](1≤q[i]≤2e5)，你需要对每个询问，输出树上有多少条路径，要求路径至少有两个节点且无重复节点，且路径上的最大边权不超过 q[i]。
注意 a->b 和 b->a 的路径只统计一次。
相关题目：昨天周赛第四题 https://leetcode.cn/problems/number-of-good-paths/

rating 1800
https://codeforces.com/contest/1213/submission/160406169
提示 1：离线询问，把边权和询问都从小到大排序。
提示 2：遍历询问，用并查集把小于 q[i] 的边都合并。
合并时，两个连通块的大小的乘积累加到答案中。
======

input
7 5
1 2 1
3 2 3
2 4 1
4 5 2
5 7 4
3 6 2
5 2 3 4 1
output
21 7 15 21 3

input
1 2
1 2
output
0 0

input
3 3
1 2 1
2 3 2
1 3 2
output
1 3 3
 */
