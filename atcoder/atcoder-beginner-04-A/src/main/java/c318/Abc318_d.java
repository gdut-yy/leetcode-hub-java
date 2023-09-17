package c318;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Abc318_d {
    static int n;
    static int[][] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int wt = scanner.nextInt();
                d[i][j] = wt;
                d[j][i] = wt;
            }
        }
        System.out.println(solve1());
    }

    private static String solve1() {
        long[] dp = new long[1 << n];
        for (int b = 0; b < (1 << n); b++) {
            int l = -1;
            for (int i = 0; i < n; i++) {
                if ((b >> i & 1) == 0) {
                    l = i;
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if ((b >> i & 1) == 0) {
                    int nb = b | (1 << l) | (1 << i);
                    dp[nb] = Math.max(dp[nb], dp[b] + d[l][i]);
                }
            }
        }
        return String.valueOf(dp[(1 << n) - 1]);
    }

    private static String solve() {
        long ans = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            // C(16, 8) = 12870
            if (Integer.bitCount(mask) == n / 2) {
                int[][] g = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if ((mask >> i & 1) == 1 && (mask >> j & 1) == 0) {
                            g[i][j] = d[i][j];
                            g[j][i] = d[j][i];
                            KmAlgo kmAlgo = new KmAlgo(n, g);
                            long maxWt = kmAlgo.getMaximumWeight();
                            ans = Math.max(ans, maxWt);
                        }
                    }
                }
            }
        }
        return String.valueOf(ans / 2);
    }

    private static class KmAlgo {
        private final int n;
        // 左集合对应的匹配点
        private final int[] matchX;
        // 右集合对应的匹配点
        private final int[] matchY;
        // 连接右集合的左点
        private final int[] pre;
        // 拜访数组 左
        private final boolean[] visX;
        // 拜访数组 右
        private final boolean[] visY;
        // 可行顶标 给每个节点 i 分配一个权值 l(i)，对于所有边 (u,v) 满足 w(u,v) <= l(u) + l(v)。
        private final long[] lx;
        private final long[] ly;
        private final int[][] graph;
        private final long[] slack;
        private static final long INF = Long.MAX_VALUE;
        private final Queue<Integer> queue;

        public KmAlgo(int n, int[][] graph) {
            this.n = n;
            this.graph = graph;
            this.queue = new LinkedList<>();
            this.matchX = new int[n];
            Arrays.fill(matchX, -1);
            this.matchY = new int[n];
            Arrays.fill(matchY, -1);
            this.pre = new int[n];
            this.visX = new boolean[n];
            this.visY = new boolean[n];
            this.lx = new long[n];
            Arrays.fill(lx, -INF);
            this.ly = new long[n];
            this.slack = new long[n];
        }

        public long getMaximumWeight() {
            // 初始顶标
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    lx[i] = Math.max(lx[i], graph[i][j]);
                }
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(slack, INF);
                Arrays.fill(visX, false);
                Arrays.fill(visY, false);
                bfs(i);
            }
            // custom
            long res = 0;
            for (int i = 0; i < n; i++) {
                res += graph[i][matchX[i]];
            }
            return res;
        }

        private boolean check(int v) {
            visY[v] = true;
            if (matchY[v] != -1) {
                queue.add(matchY[v]);
                // in S
                visX[matchY[v]] = true;
                return false;
            }
            // 找到新的未匹配点 更新匹配点 pre 数组记录着"非匹配边"上与之相连的点
            while (v != -1) {
                matchY[v] = pre[v];
                // swap(v, matchx[pre[v]]);
                int tmp = matchX[pre[v]];
                matchX[pre[v]] = v;
                v = tmp;
            }
            return true;
        }

        private void bfs(int i) {
            queue.clear();
            queue.add(i);
            visX[i] = true;
            while (true) {
                while (!queue.isEmpty()) {
                    int u = queue.remove();
                    for (int v = 0; v < n; v++) {
                        if (!visY[v]) {
                            long delta = lx[u] + ly[v] - graph[u][v];
                            if (slack[v] >= delta) {
                                pre[v] = u;
                                if (delta > 0) {
                                    slack[v] = delta;
                                } else if (check(v)) {
                                    // delta=0 代表有机会加入相等子图 找增广路
                                    // 找到就return 重建交错树
                                    return;
                                }
                            }
                        }
                    }
                }
                // 没有增广路 修改顶标
                long a = INF;
                for (int j = 0; j < n; j++) {
                    if (!visY[j]) {
                        a = Math.min(a, slack[j]);
                    }
                }
                for (int j = 0; j < n; j++) {
                    // S
                    if (visX[j]) {
                        lx[j] -= a;
                    }
                    // T
                    if (visY[j]) {
                        ly[j] += a;
                    }
                    // T'
                    else {
                        slack[j] -= a;
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (!visY[j] && slack[j] == 0 && check(j)) {
                        return;
                    }
                }
            }
        }
    }
}
/*
D - General Weighted Max Matching
https://atcoder.jp/contests/abc318/tasks/abc318_d

题目大意：
给定一个加权无向完全图，有 N 个顶点，编号从 1 到 N。连接顶点 i 和 j 的边(i<j)的权值为 di,j。
当在下列条件下选择一定数量的边时，找出所选边的最大可能总权值。
- 所选边的端点是两两不同的。
---
如果选择连接顶点 1 和 3 的边，以及连接顶点 2 和 4 的边，则这些边的总权重为 5+8=13。
可以看出，这是可达到的最大值。

贪心肯定不对，精确匹配？
---
让我们通过所选边的最大总权重来定义 dp[b]，对于每个顶点 i1, i2,..., ik，选择一条与该顶点相连的边，或者确定不选择这样的边，其中 i1, i2,..., ik 是 b 的位被设置。答案是 dp[2^N−1]。
相似题目: D - Dance
https://atcoder.jp/contests/abc236/tasks/abc236_d
======

Input 1
4
1 5 4
7 8
6
Output 1
13

Input 2
3
1 2
3
Output 2
3

Input 3
16
5 6 5 2 1 7 9 7 2 5 5 2 4 7 6
8 7 7 9 8 1 9 6 10 8 8 6 10 3
10 5 8 1 10 7 8 4 8 6 5 1 10
7 4 1 4 5 4 5 10 1 5 1 2
2 9 9 7 6 2 2 8 3 5 2
9 10 3 1 1 2 10 7 7 5
10 6 1 8 9 3 2 4 2
10 10 8 9 2 10 7 9
5 8 8 7 5 8 2
4 2 2 6 8 3
2 7 3 10 3
5 7 10 3
8 5 7
9 1
4
Output 3
75
 */