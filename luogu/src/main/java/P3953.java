import base.Unaccepted;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

@Unaccepted
public class P3953 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    static final int N = (int) (1e5 + 10);
    static final long INF = (long) 1e18;
    static int n, m, K, p;
    static List<int[]>[] e1, e2;
    static long[] d = new long[N];
    static long[][] dp = new long[N][60];
    static boolean flg;
    static boolean[] vis1 = new boolean[N];
    static boolean[][] vis2 = new boolean[N][60];

    static {
        e1 = new ArrayList[N];
        e2 = new ArrayList[N];
        Arrays.setAll(e1, e -> new ArrayList<>());
        Arrays.setAll(e2, e -> new ArrayList<>());
    }

    // https://www.luogu.com.cn/article/4riqnd23
    private static void solve() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        K = scanner.nextInt();
        p = scanner.nextInt();

        for (int i = 1; i < N; i++) {
            e1[i].clear();
            e2[i].clear();
        }
        for (int i = 1; i <= m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            e1[a].add(new int[]{b, c});
            e2[b].add(new int[]{a, c});
        }
        dij();
        flg = false;
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        long ans = 0;
        for (int i = 0; i <= K; i++) {
            ans = (ans + dfs(n, i)) % p;
            if (flg) break;
        }
        if (flg) out.println(-1);
        else out.println(ans);
    }

    static void dij() {
        Arrays.fill(vis1, false);
        Arrays.fill(d, INF);
        d[1] = 0;
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        q.add(new long[]{0, 1});
        while (!q.isEmpty()) {
            long[] p = q.remove();
            int u = (int) p[1];
            if (vis1[u]) continue;
            vis1[u] = true;
            for (int[] x : e1[u]) {
                int v = x[0], w = x[1];
                if (d[v] > d[u] + w) {
                    d[v] = d[u] + w;
                    q.add(new long[]{d[v], v});
                }
            }
        }
    }

    static long dfs(int u, int k) {
        if (vis2[u][k]) {
            flg = true;
            return 0;
        }
        if (dp[u][k] != -1) return dp[u][k];
        vis2[u][k] = true;
        dp[u][k] = 0;
        for (int[] x : e2[u]) {
            int v = x[0], w = x[1], nk = (int) (d[u] - d[v] + k - w);
            if (nk < 0 || nk > K) continue;
            dp[u][k] = (dp[u][k] + dfs(v, nk)) % p;
            if (flg) {
                vis2[u][k] = false;
                return 0;
            }
        }
        if (u == 1 && k == 0) dp[u][k] = 1;
        vis2[u][k] = false;
        return dp[u][k];
    }
}
/*
# P3953 [NOIP 2017 提高组] 逛公园
https://www.luogu.com.cn/problem/P3953

灵茶の试炼 2024-08-29 ext
## 题目背景

NOIP2017 D1T3

## 题目描述

策策同学特别喜欢逛公园。公园可以看成一张 $N$ 个点 $M$ 条边构成的有向图，且没有 自环和重边。其中 $1$ 号点是公园的入口，$N$ 号点是公园的出口，每条边有一个非负权值， 代表策策经过这条边所要花的时间。

策策每天都会去逛公园，他总是从 $1$ 号点进去，从 $N$ 号点出来。

策策喜欢新鲜的事物，它不希望有两天逛公园的路线完全一样，同时策策还是一个 特别热爱学习的好孩子，它不希望每天在逛公园这件事上花费太多的时间。如果 $1$ 号点 到 $N$ 号点的最短路长为 $d$，那么策策只会喜欢长度不超过 $d + K$ 的路线。

策策同学想知道总共有多少条满足条件的路线，你能帮帮它吗？

为避免输出过大，答案对 $P$ 取模。

如果有无穷多条合法的路线，请输出 $-1$。

## 输入格式

第一行包含一个整数 $T$, 代表数据组数。

接下来 $T$ 组数据，对于每组数据： 第一行包含四个整数 $N,M,K,P$，每两个整数之间用一个空格隔开。


接下来 $M$ 行，每行三个整数 $a_i,b_i,c_i$，代表编号为 $a_i,b_i$ 的点之间有一条权值为 $c_i$ 的有向边，每两个整数之间用一个空格隔开。

## 输出格式

输出文件包含 $T$ 行，每行一个整数代表答案。

## 输入输出样例 #1

### 输入 #1

```
2
5 7 2 10
1 2 1
2 4 0
4 5 2
2 3 2
3 4 1
3 5 2
1 5 3
2 2 0 10
1 2 0
2 1 0
```

### 输出 #1

```
3
-1
```

## 说明/提示

【样例解释1】


对于第一组数据，最短路为 $3$。 $1\to 5, 1\to 2\to 4\to 5, 1\to 2\to 3\to 5$ 为 $3$ 条合法路径。


【测试数据与约定】

对于不同的测试点，我们约定各种参数的规模不会超过如下


测试点编号　　|$T$　　　|$N$　　　|$M$　　　|$K$　　　|是否有 $0$ 边
-|-|-|-|-|-
$1$|$5$|$5$|$10$|$0$|否
$2$|$5$|$10^3$|$2\times 10^3$|$0$|否
$3$|$5$|$10^3$|$2\times 10^3$|$50$|否
$4$|$5$|$10^3$|$2\times 10^3$|$50$|否
$5$|$5$|$10^3$|$2\times 10^3$|$50$|否
$6$|$5$|$10^3$|$2\times 10^3$|$50$|是
$7$|$5$|$10^5$|$2\times 10^5$|$0$|否
$8$|$3$|$10^5$|$2\times 10^5$|$50$|否
$9$|$3$|$10^5$|$2\times 10^5$|$50$|是
$10$|$3$|$10^5$|$2\times 10^5$|$50$|是


对于 $100\%$ 的数据，$1 \le P \le 10^9$，$1 \le a_i,b_i \le N$，$0 \le c_i \le 1000$。

数据保证：至少存在一条合法的路线。

---

- 2019.8.30 增加了一组 hack 数据 by @skicean
- 2022.7.21 增加了一组 hack 数据 by @djwj233
 */