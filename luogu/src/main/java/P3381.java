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
# P3381 【模板】最小费用最大流

## 题目描述

给出一个包含 $n$ 个点和 $m$ 条边的有向图（下面称其为网络） $G=(V,E)$，该网络上所有点分别编号为 $1 \sim n$，所有边分别编号为 $1\sim m$，其中该网络的源点为 $s$，汇点为 $t$，网络上的每条边 $(u,v)$ 都有一个流量限制 $w(u,v)$ 和单位流量的费用 $c(u,v)$。

你需要给每条边 $(u,v)$ 确定一个流量 $f(u,v)$，要求：

1.  $0 \leq f(u,v) \leq w(u,v)$（每条边的流量不超过其流量限制）；
2. $\forall p \in \{V \setminus \{s,t\}\}$，$\sum_{(i,p) \in E}f(i,p)=\sum_{(p,i)\in E}f(p,i)$（除了源点和汇点外，其他各点流入的流量和流出的流量相等）；
3. $\sum_{(s,i)\in E}f(s,i)=\sum_{(i,t)\in E}f(i,t)$（源点流出的流量等于汇点流入的流量）。

定义网络 $G$ 的流量 $F(G)=\sum_{(s,i)\in E}f(s,i)$，网络 $G$ 的费用 $C(G)=\sum_{(i,j)\in E} f(i,j) \times c(i,j)$。

你需要求出该网络的**最小费用最大流**，即在 $F(G)$ 最大的前提下，使 $C(G)$ 最小。

## 输入格式

输入第一行包含四个整数 $n,m,s,t$，分别代表该网络的点数 $n$，网络的边数 $m$，源点编号 $s$，汇点编号 $t$。

接下来 $m$ 行，每行四个整数 $u_i,v_i,w_i,c_i$，分别代表第 $i$ 条边的起点，终点，流量限制，单位流量费用。

## 输出格式

输出两个整数，分别为该网络的最大流 $F(G)$，以及在 $F(G)$ 最大的前提下，该网络的最小费用 $C(G)$。

## 输入输出样例 #1

### 输入 #1

```
4 5 4 3
4 2 30 2
4 3 20 3
2 3 20 1
2 1 30 9
1 3 40 5
```

### 输出 #1

```
50 280
```

## 说明/提示

对于 $100\%$ 的数据，$1 \leq n \leq 5\times 10^3$，$1 \leq m \leq 5 \times 10^4$，$1 \leq s,t \leq n$，$u_i \neq v_i$，$0 \leq w_i,c_i \leq 10^3$，且该网络的最大流和最小费用 $\leq 2^{31}-1$。

输入数据随机生成。
 */