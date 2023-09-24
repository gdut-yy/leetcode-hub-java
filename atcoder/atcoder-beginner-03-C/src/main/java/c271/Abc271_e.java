package c271;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc271_e {
    static int n, m, k;
    static int[][] es;
    static int[] e;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        es = new int[m][3];
        for (int i = 0; i < m; i++) {
            es[i][0] = scanner.nextInt();
            es[i][1] = scanner.nextInt();
            es[i][2] = scanner.nextInt();
        }
        e = new int[k];
        for (int i = 0; i < k; i++) {
            e[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final long INF = (long) 1e18;

    private static String solve() {
        long[] dis = new long[n + 1];
        for (int i = 2; i <= n; i++) {
            dis[i] = INF;
        }
        for (int i = 0; i < k; i++) {
            int[] ee = es[e[i] - 1];
            dis[ee[1]] = Math.min(dis[ee[1]], dis[ee[0]] + ee[2]);
        }
        return dis[n] == INF ? "-1" : String.valueOf(dis[n]);
    }
}
/*
E - Subsequence Path
https://atcoder.jp/contests/abc271/tasks/abc271_e

灵茶の试炼 2022-12-23
题目大意：
输入 n m k (≤2e5)，然后输入 m 条边，每条边输入两个点 x y（表示从 x 到 y 的一条有向边，点的编号 1~n）和一个值在 [1,1e9] 内的边权，每条边的编号 1~m。
图中没有自环，但可能有重边。
然后输入一个长为 k 的数组 a (1≤e[i]≤m)。
找到一条从 1 到 n 的路径，满足路径上的边的编号是 a 的子序列。
输出满足这个要求的路径的最短长度。如果不存在，输出 -1。

https://atcoder.jp/contests/abc271/submissions/37441829
类似最短路，按照数组 a 的顺序放松边，即如果 dis[x] + 边权 < dis[y]，那么就更新 dis[y]。
======

Input 1
3 4 4
1 2 2
2 3 2
1 3 3
1 3 5
4 2 1 2
Output 1
4

Input 2
3 2 3
1 2 1
2 3 1
2 1 1
Output 2
-1

Input 3
4 4 5
3 2 2
1 3 5
2 4 7
3 4 10
2 4 1 4 3
Output 3
14
 */