package p1873;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1873H {
    static int n, a, b;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            g = new ArrayList[n + 1];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 0; i < n; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                g[u].add(v);
                g[v].add(u);
            }
            System.out.println(solve());
        }
    }

    private static final int INF = (int) (2e5 + 5);
    static boolean[] vis;
    static int entry_node;

    private static String solve() {
        vis = new boolean[n + 1];
        entry_node = -1;
        dfs1(b, -1);

        Arrays.fill(vis, false);
        int distMarcel = entry_node == a ? 0 : dfs2(a);

        Arrays.fill(vis, false);
        int distValeriu = entry_node == b ? 0 : dfs2(b);

        return distValeriu < distMarcel ? "YES" : "NO";
    }

    private static boolean dfs1(int x, int fa) {
        vis[x] = true;
        for (Integer y : g[x]) {
            if (y != fa) {
                if (vis[y]) {
                    entry_node = y;
                    return true;
                } else {
                    if (dfs1(y, x)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int dfs2(int x) {
        vis[x] = true;
        int distbruh = INF;
        for (Integer y : g[x]) {
            if (y == entry_node) {
                return 1;
            }
            if (!vis[y]) {
                int dist = dfs2(y) + 1;
                distbruh = Math.min(distbruh, dist);
            }
        }
        return distbruh;
    }
}
/*
H. Mad City
https://codeforces.com/contest/1873/problem/H

题目大意：
Marcel 和 Valeriu 在一个疯狂的城市里，这个城市由 n 座建筑代表，它们之间有 n 条双向道路。
Marcel 和 Valeriu 分别从 a 楼和 b 楼开始。马塞尔想抓住瓦莱留，换句话说，和他在同一栋楼里，或者在同一条路上相遇。
在每次移动过程中，他们可以选择前往当前建筑物的相邻建筑物或留在同一建筑物中。因为瓦莱柳非常了解马塞尔，所以瓦莱柳可以预测马塞尔下一步的行动。瓦莱柳可以利用这些信息采取行动。它们同时开始和结束移动。
保证任何一对建筑物之间都有一定的路径连接，并且任何一对建筑物之间最多有一条道路。
假设双方都采取了最优策略，回答瓦莱柳是否有无限期逃离马塞尔的策略。

https://codeforces.com/blog/entry/120634
因为我们有一棵树外加一条边，我们的图正好有一个循环。
如果 Marcel 和 Valeriu 共用同一栋建筑，那么答案是“不”。
如果我们从 Valeriu 的节点进行深度优先搜索，当我们遇到一个已经访问过的节点，而不是当前节点的父节点时，该节点是循环的一部分。此外，这也是 Valeriu 进入循环的节点。
瓦莱留能永远逃离马塞尔只要他能赶在马塞尔之前到达这个节点。这是因为如果 Valeriu 处于循环中，那么他总是有 2 个建筑选择，他可以在其中奔跑，这仍然使他处于循环中。马塞尔在任何时候都只能待在一栋楼里，而瓦莱柳知道马塞尔的下一步行动，这意味着瓦莱柳总能逃脱他的追捕。
因此，如果 Marcel 在 Valeriu 之后到达 Valeriu 的入口节点，则只需使用广度优先搜索或深度优先搜索进行检查。
======

input
6
3 2 1
2 1
3 2
1 3
4 1 4
1 4
1 2
1 3
2 3
4 1 2
1 2
2 3
2 4
3 4
7 1 1
4 1
2 1
5 3
4 6
4 2
7 5
3 4
8 5 3
8 3
5 1
2 6
6 8
1 2
4 8
5 7
6 7
10 6 1
1 2
4 3
5 8
7 8
10 4
1 9
2 4
8 1
6 2
3 1
output
YES
NO
YES
NO
NO
YES
 */
