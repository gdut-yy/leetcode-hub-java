package template;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 匈牙利算法（KM 算法）
 * Hungarian Algorithm（Kuhn-Munkres Algorithm）
 * 用于求解二分图最大权匹配
 * https://oi-wiki.org/graph/graph-matching/bigraph-weight-match/
 * <p>
 * 时间复杂度 O(n^3)
 */
public class KmAlgo {
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
    private final int[] lx;
    private final int[] ly;
    private final int[][] graph;
    private final int[] slack;
    private static final int INF = Integer.MAX_VALUE;
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
        this.lx = new int[n];
        Arrays.fill(lx, -INF);
        this.ly = new int[n];
        this.slack = new int[n];
    }

    public int getMaximumWeight() {
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
        int res = 0;
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
                        int delta = lx[u] + ly[v] - graph[u][v];
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
            int a = INF;
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
