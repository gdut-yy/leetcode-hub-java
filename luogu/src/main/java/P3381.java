import base.Unaccepted;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

@Unaccepted
public class P3381 {
    static int n, m, s, t, u, v, w, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        t = scanner.nextInt();
        S = s;
        T = t;
        tot = 1;
        for (int i = 0; i < m; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            w = scanner.nextInt();
            c = scanner.nextInt();
            add_edge(u, v, w, c);
        }
        while (spfa()) update();
        System.out.println(maxflow + " " + ans);
    }

    static int N = 5010, M = 100010;
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
https://www.luogu.com.cn/problem/P3381

4 5 4 3
4 2 30 2
4 3 20 3
2 3 20 1
2 1 30 9
1 3 40 5
 */