package lq231125;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LQ231125T7 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static int N = 20010, M = 200010;
    static int[] ver = new int[M], cost = new int[M], ne = new int[M], he = new int[N];
    static long[] dis = new long[N], ed = new long[M], incf = new long[N];
    static int[] pre = new int[N], vis = new int[N];
    static int tot, S, T;
    static long INF = (long) 1e18;
    static long maxflow, ans;

    static void add(int x, int y, long z, int c) {
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
        if (dis[T] >= INF) return false; // 汇点不可达，已求出最大流
        update();
        return true;
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

    static String solve() {
        int[] pre = new int[11];
        Map<Integer, Integer> pre11 = new HashMap<>();

        S = n * 2 + 1;
        T = n * 2 + 2;
        tot = 1;
        for (int i = 1; i <= n; i++) {
            add(S, i, 1, 0);
            add(i + n, T, 1, 0);
            add(i, i + n, 1, -1);

            int x = pre[a[i] % 9];
            if (x > 0) {
                add(x, i, INF, 0);
                add(x + n, i, INF, 0);
            }
            if (pre11.containsKey(a[i] - 11)) {
                x = pre11.get(a[i] - 11);
                add(x, i, INF, 0);
                add(x + n, i, INF, 0);
            }
            if (pre11.containsKey(a[i] + 11)) {
                x = pre11.get(a[i] + 11);
                add(x, i, INF, 0);
                add(x + n, i, INF, 0);
            }
            pre[a[i] % 9] = i;
            pre11.put(a[i], i);
        }
        add(n + 1, T, 1, 0);

        List<String> output = new ArrayList<>();
        for (int i = 1; i <= Math.min(n, 9); i++) {
            spfa();
            output.add(String.valueOf(-ans));
        }
        for (int i = 10; i <= n; i++) {
            output.add(String.valueOf(-ans));
        }
        return String.join(" ", output);
    }
}
/*
时空追捕【算法赛】

本题考察网络流与优化建图。
本题有一个很简单的费用流建图方案：
1、将每个点拆为入点和出点，入点对出点建立一条边，费用为 1，容量为 1.
2、超级源点 S 对每一个入点建立一条边，费用为 0，容量无限。
3、每一个出点对超级汇点 T 建立一条边，费用为 0，容量无限。
4、如果 i < j，并且 aj 可以在 ai 后时，我们用 i 的出点对 j 的入点建立一个费用为 0，容量无限的边。
然后我们跑最大费用最大流即可。
但是这样会将图的边的数量变成 n^2 量级，我们考虑优化。
首先我们可以分析题目条件中存在一个等价类，就是 f(x) 函数，f(x) 只会有 0~9 这 10 中取值，所以，我们最多使用 10 个时空战警就可以巡逻完所有的点。
因为有等价类的原因，所以我们可以考虑对入点建边，可以优化掉很多多余的边，具体方案如下：
1、将每个点拆为入点和出点，入点对出点建立一条边，费用为 1，容量为 1.
2、超级源点 S 对每一个入点建立一条边，费用为 0，容量无限。
3、每一个出点对超级汇点 T 建立一条边，费用为 0，容量无限。
4、如果 |g_ai - g_aj| = 11，并且 j > i，并且 j 最小，我们用 i 的出点对 j 的入点建立一个费用为 0，容量无限的边。
5、如果 f(g_ai) = f(g_aj)，并且 j > i，并且 j 最小，我们用 i 的出点对 j 的入点建立一个费用为 0，容量无限的边。同时我们用 i 的入点对 j 的入点建立一个费用为 0，，容量无限的边，用来模拟等价类。
这样，我们的边的数量就是 O(n) 级别，我们采用 EK 算法，跑最大费用流即可。

MCMF minimum cost maximum flow
 */