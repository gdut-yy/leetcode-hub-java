package c293;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Abc293_d {
    static int n, m;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            String b = scanner.next();
            int c = scanner.nextInt() - 1;
            String d = scanner.next();
            g[a].add(c);
            g[c].add(a);
        }
        System.out.println(solve());
    }

    static boolean[] vis;
    static int cntV, cntE;

    private static String solve() {
        // equal, not equal
        int eq = 0, neq = 0;
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cntV = 0;
                cntE = 0;
                dfs(i);
                if (cntE / 2 == cntV) eq++;
                else neq++;
            }
        }
        return eq + " " + neq;
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
D - Tying Rope
https://atcoder.jp/contests/abc293/tasks/abc293_d

题目大意：
一共有 N 根绳子，编号从 1 到 N。每根绳子的一端涂成红色，另一端涂成蓝色。
你将执行 M 个系绳操作。在第 i 个操作中，你把绳子 Ai 的末端画成 Bi，绳子 Ci 的末端画成 Di，其中 R 表示红色，B 表示蓝色。对于每根绳子，相同颜色的一端不打结多次。
在所有操作之后，找出形成循环的连接绳索组的数量，以及不形成循环的连接绳索组的数量。
在这里，如果一组相连的绳子 {v[0], v[1], ..., v[x−1]} 能够重新排列 v 的元素，使得对于每一个 0≤i<x，绳子 vi 被绑在绳子 v(i+1) mod x 上，我们就说这组绳子形成了一个循环。

DFS 统计每个连通块的 点数、边数。
形成循环的连接绳索组的数量 每个连通块的 点数 == 边数。
不能形成循环的连接绳索组的数量 每个连通块的 点数 != 边数。
相似题目: D - Unicyclic Components
https://atcoder.jp/contests/abc292/tasks/abc292_d
======

Input 1
5 3
3 R 5 B
5 R 3 B
4 R 2 B
Output 1
1 2

Input 2
7 0
Output 2
0 7

Input 3
7 6
5 R 3 R
7 R 4 R
4 B 1 R
2 R 3 B
2 B 5 B
1 B 7 B
Output 3
2 1
 */