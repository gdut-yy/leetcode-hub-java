import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionLCP09 {
    // dp 时间复杂度 O(n)
    public int minJump(int[] jump) {
        int n = jump.length;
        int w = 0;

        int[] f = new int[n + 1];
        int[] maxdis = new int[n + 1];

        // 最多跳 n 步
        Arrays.fill(f, n);
        f[1] = 0;
        maxdis[0] = 1;

        int ans = n;
        for (int i = 1; i <= n; ++i) {
            // 更新单调指针
            if (i > maxdis[w]) {
                w++;
            }
            // 用 maxdis[w] 更新 f[i]
            f[i] = Math.min(f[i], w + 1);
            // 第一步跳跃更新
            int next = i + jump[i - 1];

            if (next > n) {
                ans = Math.min(ans, f[i] + 1);
            } else if (f[next] > f[i] + 1) {
                f[next] = f[i] + 1;
                maxdis[f[next]] = Math.max(maxdis[f[next]], next);
            }
        }
        return ans;
    }

    // 链式前向星
    private int[] he, ne, ed, we;
    private int idx;

    private void init(int n, int m) {
        he = new int[n + 1];
        Arrays.fill(he, -1);
        ne = new int[m];
        ed = new int[m];
        we = new int[m];
        idx = 0;
    }

    private void add(int u, int v, int w) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
        we[idx] = w;
        idx++;
    }

    // 0-1 BFS 链式前向星 时间复杂度 O(n)
    public int minJump2(int[] jump) {
        int n = jump.length;

        // 终点
        int target = n * 2;

        // n*2 个点 n*2*4 条边
        init(n * 2, n * 2 * 4);

        // 链式前向星 建图
        for (int i = 0; i < n; i++) {
            // u->u'
            add(i, i + n, 1);
            // u'->u
            add(i + n, i, 0);
            // u'->(u-1)'
            if (i > 0) {
                add(i + n, i + n - 1, 0);
            }
            // u->v
            int v = (i + jump[i] < n) ? i + jump[i] : target;
            add(i, v, 1);
        }

        int[] dist = new int[target + 1];
        Arrays.fill(dist, n);
        dist[0] = 0;

        // 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        // [id, step]
        deque.addFirst(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] cur = deque.removeFirst();
            int u = cur[0];
            if (u == target) {
                return dist[u];
            }

            for (int i = he[u]; i != -1; i = ne[i]) {
                int v = ed[i];
                int step = we[i];
                if (dist[v] > dist[u] + step) {
                    dist[v] = dist[u] + step;
                    if (step == 0) {
                        deque.addFirst(new int[]{v, dist[v]});
                    } else {
                        deque.addLast(new int[]{v, dist[v]});
                    }
                }
            }
        }
        return dist[target];
    }

    // 0-1 BFS 优化 时间复杂度 O(n)
    public int minJump3(int[] jump) {
        int n = jump.length;

        // 终点
        int target = n * 2;

        int[] dist = new int[target + 1];
        Arrays.fill(dist, n);
        dist[0] = 0;

        // 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        // [id, step]
        deque.addFirst(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] cur = deque.removeFirst();
            int u = cur[0];
            if (u == target) {
                return dist[u];
            }

            int v;
            int step;
            if (u < n) {
                // u->v
                v = (u + jump[u] < n) ? u + jump[u] : target;
                step = 1;
                if (dist[v] > dist[u] + step) {
                    dist[v] = dist[u] + step;
                    deque.addLast(new int[]{v, dist[v]});
                }
                // u->u'
                v = u + n;
                if (dist[v] > dist[u] + step) {
                    dist[v] = dist[u] + step;
                    deque.addLast(new int[]{v, dist[v]});
                }
            } else {
                // u'->u
                v = u - n;
                step = 0;
                if (dist[v] > dist[u] + step) {
                    dist[v] = dist[u] + step;
                    deque.addFirst(new int[]{v, dist[v]});
                }
                if (u - n > 0) {
                    // u'->(u-1)'
                    v = u - 1;
                    if (dist[v] > dist[u] + step) {
                        dist[v] = dist[u] + step;
                        deque.addFirst(new int[]{v, dist[v]});
                    }
                }
            }
        }
        return dist[target];
    }
}
/*
LCP 09. 最小跳跃次数
https://leetcode.cn/problems/zui-xiao-tiao-yue-ci-shu/

为了给刷题的同学一些奖励，力扣团队引入了一个弹簧游戏机。游戏机由 N 个特殊弹簧排成一排，编号为 0 到 N-1。初始有一个小球在编号 0 的弹簧处。
若小球在编号为 i 的弹簧处，通过按动弹簧，可以选择把小球向右弹射 jump[i] 的距离，或者向左弹射到任意左侧弹簧的位置。
也就是说，在编号为 i 弹簧处按动弹簧，小球可以弹向 0 到 i-1 中任意弹簧或者 i+jump[i] 的弹簧（若 i+jump[i]>=N ，则表示小球弹出了机器）。小球位于编号 0 处的弹簧时不能再向左弹。
为了获得奖励，你需要将小球弹出机器。请求出最少需要按动多少次弹簧，可以将小球从编号 0 弹簧弹出整个机器，即向右越过编号 N-1 的弹簧。
限制：
1 <= jump.length <= 10^6
1 <= jump[i] <= 10000

解法一：动态规划
假设某一个位置只需要 w 步可以跳到，那么这个位置之前的步数，最多只需要 w+1 步。
maxdis[w] 表示 w 步可以跳到的最远位置。对于位置 i而言，满足 maxdis[w] > i 条件的最小 w+1 是往左跳到达 i 的最小操作次数。
状态转移
f[i] = min(f[i], w+1): 用往左跳到达 i 的最小操作数 w+1
f[i+jump[i]] = min(f[i+jump[i],f[i]+1): 从 i 往右跳到 i+jump[i] 更新 f[i+jump[i]]
maxdis[f[i+jump[i]]] = max(maxdis[f[i+jump[i]]], i+jump[i]): 更新 f[i+jump[i]] 次操作到达最远距离。
时间复杂度 O(n)
空间复杂度 O(n)
解法二：0-1 BFS
直接建图跑最短路复杂度是 O(n^2)，一种经典的套路就是对每个 u 新增对应虚拟点 u'，然后新增三种边：
u->u', weight=1
u'->u, weight=0
u'->(u-1)', weight=0
再外加一条 u->v, weight=1 指向下一跳即可。
时间复杂度 O(n)
空间复杂度 O(n)
 */