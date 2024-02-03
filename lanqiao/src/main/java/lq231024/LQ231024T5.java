package lq231024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ231024T5 {
    static int n;
    static List<int[]>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        tot = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
            tot += w * 2L;
        }
        System.out.println(solve());
    }

    static long[] dist;
    static long treeD;
    static long tot;

    private static String solve() {
        treeD = 0;
        dist = new long[n + 1];
        dfs(1, 0);
        long ans = tot - treeD;
        return String.valueOf(ans);
    }

    static void dfs(int x, int fa) {
        for (int[] tuple : g[x]) {
            int y = tuple[0], wt = tuple[1];
            if (y != fa) {
                dfs(y, x);
                treeD = Math.max(treeD, dist[x] + dist[y] + wt);
                dist[x] = Math.max(dist[x], dist[y] + wt);
            }
        }
    }
}
/*
串门【算法赛】

树形 DP。
结论：
1、从起点到终点的最短路上的边，只需要经过一次；
2、其他边，都需要至少两次；
我们利用容斥，假设每条边都需要访问两次，那么我们减去只需要访问一次的，就是结果。
所以实际上就是求树的直径。
 */