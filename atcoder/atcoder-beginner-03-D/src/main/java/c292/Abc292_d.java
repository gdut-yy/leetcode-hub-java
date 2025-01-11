package c292;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Abc292_d {
    static int n, m;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            g[x].add(y);
            g[y].add(x);
        }
        System.out.println(solve());
    }

    private static boolean[] vis;
    private static int cntV, cntE;

    private static String solve() {
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cntV = 0;
                cntE = 0;
                dfs(i);
                if (cntE / 2 != cntV) {
                    return "No";
                }
            }
        }
        return "Yes";
    }

    // 算出来 cntE / 2 = cntV
    private static void dfs(int x) {
        vis[x] = true;
        cntV++;
        cntE += g[x].size();
        for (int y : g[x]) {
            if (vis[y]) continue;
            dfs(y);
        }
    }
}
/*
D - Unicyclic Components
https://atcoder.jp/contests/abc292/tasks/abc292_d

题目大意：
给定一个无向图，其中 N 个顶点编号为 1 到 N, M 条边编号为 1 到 M。边 i 连接顶点 ui 和顶点 vi。
确定此图中每个连接的组件是否满足以下条件。
- 连接的组件具有相同数量的顶点和边。

DFS 统计每个连通块的 点数、边数。
每个连通块的 点数 == 边数。
相似题目: D - Tying Rope
https://atcoder.jp/contests/abc293/tasks/abc293_d
======

Input 1
3 3
2 3
1 1
2 3
Output 1
Yes

Input 2
5 5
1 2
2 3
3 4
3 5
1 5
Output 2
Yes

Input 3
13 16
7 9
7 11
3 8
1 13
11 11
6 11
8 13
2 11
3 3
8 12
9 11
1 11
5 13
3 12
6 9
1 10
Output 3
No
 */