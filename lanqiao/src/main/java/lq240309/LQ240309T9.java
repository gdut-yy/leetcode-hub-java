package lq240309;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class LQ240309T9 {
    static int n, m;
    static int[] p;
    static int[][] sab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextInt();
        }
        sab = new int[m + 1][3];
        for (int i = 1; i <= m; i++) {
            sab[i][0] = scanner.nextInt();
            sab[i][1] = scanner.nextInt();
            sab[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int virtual = n + m + 1;
        S = n + m + 2;
        T = n + m + 3;
        tot = 1;
        for (int j = 1; j <= m; j++) {
            int si = sab[j][0], ai = sab[j][1], bi = sab[j][2];
            // 1、超级源点对每一种优惠券建立一条边，费用为 0，流量为优惠券张数。
            add_edge(S, j + n, si, 0);
            for (int i = 1; i <= n; i++) {
                if (ai == 0) {
                    // 3、每张优惠券对每个物品建立一条边，流量为 1，费用为使用该优惠券折扣后的价格
                    int v = (p[i] * bi + 99) / 100;
                    add_edge(j + n, i, 1, v);
                } else {
                    if (p[i] >= ai) {
                        add_edge(j + n, i, 1, p[i] - bi);
                    }
                }
            }
        }

        // 4、超级源点对虚拟优惠券建立一条边，费用为 0，流量为 n。
        add_edge(S, virtual, n, 0);
        for (int i = 1; i <= n; i++) {
            // 2、每个物品对超级汇点建立一条边，费用为 0，流量为 1。
            add_edge(i, T, 1, 0);
            // 5、虚拟优惠券对每个物品建立一条边，费用为原价，流量为 1。
            add_edge(virtual, i, 1, p[i]);
        }
        while (spfa()) update();
        return String.valueOf(ans);
    }

    static int N = 20010, M = 200010;
    static int[] ver = new int[M], he = new int[N], ne = new int[M], pre = new int[N], vis = new int[N];
    static long[] ed = new long[M], cost = new long[M], dis = new long[N], incf = new long[N];
    static int tot, S, T;
    static long INF = (long) 1e18;
    static long maxflow, ans;

    static void add_edge(int x, int y, long z, int c) {
        // 正向边，初始容量 z，单位费用 c
        ver[++tot] = y;
        ed[tot] = z;
        cost[tot] = c;
        ne[tot] = he[x];
        he[x] = tot;
        // 反向边，初始容量 0，单位费用 -c，与正向边 成对存储
        ver[++tot] = x;
        ed[tot] = 0;
        cost[tot] = -c;
        ne[tot] = he[y];
        he[y] = tot;
    }

    static boolean spfa() {
        Queue<Integer> q = new ArrayDeque<>();
        Arrays.fill(dis, INF);
        q.add(S);
        dis[S] = 0;
        vis[S] = 1; // SPFA 求最长路
        incf[S] = INF; // 增广路上各边的最小剩余容量
        while (!q.isEmpty()) {
            int x = q.remove();
            vis[x] = 0;

            for (int i = he[x]; i != 0; i = ne[i]) {
                int y = ver[i];
                if (ed[i] == 0) continue; // 剩余容量为 0，不在残量网络中，不遍历

                if (dis[y] > dis[x] + cost[i]) {
                    dis[y] = dis[x] + cost[i];
                    incf[y] = Math.min(incf[x], ed[i]);
                    pre[y] = i; // 记录前驱，便于找到最长路的实际方案
                    if (vis[y] == 0) {
                        vis[y] = 1;
                        q.add(y);
                    }
                }
            }
        }
        return dis[T] != INF; // 汇点不可达，已求出最大流
    }

    static void update() {
        int x = T;
        while (x != S) {
            int i = pre[x];
            ed[i] -= incf[T];
            ed[i ^ 1] += incf[T]; // 利用 成对存储 的 xor 1 技巧
            x = ver[i ^ 1];
        }
        maxflow += incf[T];
        ans += dis[T] * incf[T];
    }
}
/*
打折【算法赛】

解题思路
本题考察网络流，最小费用最大流。
考虑如下建图方式：
1、超级源点对每一种优惠券建立一条边，费用为 0，流量为优惠券张数。
2、每个物品对超级汇点建立一条边，费用为 0，流量为 1。
3、每张优惠券对每个物品建立一条边，流量为 1，费用为使用该优惠券折扣后的价格
4、超级源点对虚拟优惠券建立一条边，费用为 0，流量为 n。
5、虚拟优惠券对每个物品建立一条边，费用为原价，流量为 1。
求出最小费用最大流即可，然后我们求出最小的费用，输出即是答案。
样例的建图：
 */