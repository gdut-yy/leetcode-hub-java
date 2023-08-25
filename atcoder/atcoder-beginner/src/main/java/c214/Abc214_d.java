package c214;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Abc214_d {
    static int n;
    static int[][] es;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        es = new int[n][3];
        for (int i = 0; i < n - 1; i++) {
            es[i][0] = scanner.nextInt();
            es[i][1] = scanner.nextInt();
            es[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(es, Comparator.comparingInt(o -> o[2]));

        long ans = 0;
        DSU dsu = new DSU(n + 1);
        for (int[] e : es) {
            int x = dsu.find(e[0]);
            int y = dsu.find(e[1]);
            ans += (long) dsu.sz[x] * dsu.sz[y] * e[2];
            dsu.fa[x] = y;
            dsu.sz[y] += dsu.sz[x];
        }
        return String.valueOf(ans);
    }

    private static class DSU {
        int[] fa;
        int[] sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = new int[n];
            Arrays.fill(sz, 1);
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }
    }
}
/*
D - Sum of Maximum Weights
https://atcoder.jp/contests/abc214/tasks/abc214_d

灵茶の试炼 2023-08-09
题目大意：
输入 n(2≤n≤1e5) 和一棵树的 n-1 条边（节点编号从 1 开始），每条边包含 3 个数 a b c，表示有一条边权为 c(1≤c≤1e7) 的边连接 a 和 b。
定义 f(x,y) 表示从 x 到 y 的简单路径上的最大边权。
输出所有 f(i,j) 的和，其中 i<j。

https://atcoder.jp/contests/abc214/submissions/44395458
贡献法。
假设边 x-y 的边权为 z，如果 x 通过 <= z 的边可以到达 a 个点，y 通过 <= z 的边可以到达 b 个点，根据乘法原理，总共有 a*b 条简单路径通过 x-y，所以这条边对答案的贡献为 a*b*z。
这启发我们得到下面的做法：
按照边权从小到大遍历这些边，一边遍历一边用并查集 merge 这些边，同时维护每个点所在的点集大小。
（merge 前）上面说的 a 就是 x 所在点集的大小，b 就是 y 所在点集的大小。
相似题目：2421. 好路径的数目
https://leetcode.cn/problems/number-of-good-paths/
F. Imbalance Value of a Tree
https://codeforces.com/contest/915/problem/F
======

Input 1
3
1 2 10
2 3 20
Output 1
50

Input 2
5
1 2 1
2 3 2
4 2 5
3 5 14
Output 2
76
 */