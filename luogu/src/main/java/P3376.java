import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class P3376 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        t = scanner.nextInt();
        tot = 1;
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int c = scanner.nextInt();
            add(x, y, c);
        }
        q = new ArrayDeque<>();
        long flow = 0;
        while (bfs()) {
            while ((flow = dinic(s, inf)) != 0) maxflow += flow;
        }
        System.out.println(maxflow);
    }


    static int inf = 1 << 29, N = 50010, M = 300010;
    static int[] head = new int[N], ver = new int[M], edge = new int[M], Next = new int[M], d = new int[N];
    static int n, m, s, t, tot;
    static long maxflow;
    static Queue<Integer> q;

    static void add(int x, int y, int z) {
        ver[++tot] = y;
        edge[tot] = z;
        Next[tot] = head[x];
        head[x] = tot;

        ver[++tot] = x;
        edge[tot] = 0;
        Next[tot] = head[y];
        head[y] = tot;
    }

    static boolean bfs() { // 在残量网络上构造分层图
        Arrays.fill(d, 0);
        while (!q.isEmpty()) q.remove();
        q.add(s);
        d[s] = 1;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int i = head[x]; i != 0; i = Next[i]) {
                if (edge[i] != 0 && d[ver[i]] == 0) {
                    q.add(ver[i]);
                    d[ver[i]] = d[x] + 1;
                    if (ver[i] == t) return true;
                }
            }
        }
        return false;
    }

    static int dinic(int x, int flow) { // 在当前分层图上增广
        if (x == t) return flow;
        int rest = flow, k;
        for (int i = head[x]; i != 0 && rest != 0; i = Next[i]) {
            if (edge[i] != 0 && d[ver[i]] == d[x] + 1) {
                k = dinic(ver[i], Math.min(rest, edge[i]));
                if (k == 0) d[ver[i]] = 0; // 剪枝，去掉增广完毕的点
                edge[i] -= k;
                edge[i ^ 1] += k;
                rest -= k;
            }
        }
        return flow - rest;
    }
}
/*
# P3376 【模板】网络最大流

## 题目描述

如题，给出一个网络图，以及其源点和汇点，求出其网络最大流。

## 输入格式

第一行包含四个正整数 $n,m,s,t$，分别表示点的个数、有向边的个数、源点序号、汇点序号。

接下来 $m$ 行每行包含三个正整数 $u_i,v_i,w_i$，表示第 $i$ 条有向边从 $u_i$ 出发，到达 $v_i$，边权为 $w_i$（即该边最大流量为 $w_i$）。

## 输出格式

一行，包含一个正整数，即为该网络的最大流。

## 输入输出样例 #1

### 输入 #1

```
4 5 4 3
4 2 30
4 3 20
2 3 20
2 1 30
1 3 30
```

### 输出 #1

```
50
```

## 说明/提示

#### 样例输入输出 1 解释

 ![](https://cdn.luogu.com.cn/upload/pic/2262.png)

题目中存在 $3$ 条路径：

- $4\to 2\to 3$，该路线可通过 $20$ 的流量。
- $4\to 3$，可通过 $20$ 的流量。
- $4\to 2\to 1\to 3$，可通过 $10$ 的流量（边 $4\to 2$ 之前已经耗费了 $20$ 的流量）。

故流量总计 $20+20+10=50$。输出 $50$。

---

#### 数据规模与约定

- 对于 $30\%$ 的数据，保证 $n\leq10$，$m\leq25$。
- 对于 $100\%$ 的数据，保证 $1 \leq n\leq200$，$1 \leq m\leq 5000$，$0 \leq w\lt 2^{31}$。
 */