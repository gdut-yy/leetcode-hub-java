import base.Unaccepted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

@Unaccepted
public class P1144 {
    static int n, m;
//    static List<Integer>[] g;

    static int N = (int) (1e6 + 5), M = N * 2;
    // 链式前向星
    static int[] he = new int[N], ne = new int[M], ed = new int[M]/*, we = new int[M]*/;
    static int idx = 0;

    static void add(int u, int v, int w) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
//        we[idx] = w;
        idx++;
    }

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
//        g = new ArrayList[n];
//        Arrays.setAll(g, e -> new ArrayList<>());
        Arrays.fill(he, -1);
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
//            g[v].add(w);
//            g[w].add(v);
            add(v, w, 1);
            add(w, v, 1);
        }
        System.out.println(solve());
    }

    static final int MOD = 100003;

    private static String solve() {
        long[] f = new long[n];
        long[] dis = new long[n];
        Arrays.fill(dis, -1);
        int s = 0;
        dis[s] = 0;
        f[s] = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        while (!q.isEmpty()) {
            int v = q.remove();
            long newD = dis[v] + 1;

//            for (Integer w : g[v]) {
            for (int i = he[v]; i != -1; i = ne[i]) {
//            int w = e[0], wt = e[1];
                int w = ed[i];
                if (dis[w] < 0) {
                    dis[w] = newD;
                    f[w] = f[v];
                    q.add(w);
                } else if (newD == dis[w]) {
                    f[w] = (f[w] + f[v]) % MOD;
                }
            }
        }

        return Arrays.stream(f).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
P1144 最短路计数
https://www.luogu.com.cn/problem/P1144

灵茶の试炼 2024-08-29 ext
# 最短路计数

## 题目描述

给出一个 $N$ 个顶点 $M$ 条边的无向无权图，顶点编号为 $1\sim N$。问从顶点 $1$ 开始，到其他每个点的最短路有几条。

## 输入格式

第一行包含 $2$ 个正整数 $N,M$，为图的顶点数与边数。

接下来 $M$ 行，每行 $2$ 个正整数 $x,y$，表示有一条连接顶点 $x$ 和顶点 $y$ 的边，请注意可能有自环与重边。

## 输出格式

共 $N$ 行，每行一个非负整数，第 $i$ 行输出从顶点 $1$ 到顶点 $i$ 有多少条不同的最短路，由于答案有可能会很大，你只需要输出 $ ans \bmod 100003$ 后的结果即可。如果无法到达顶点 $i$ 则输出 $0$。

## 样例 #1

### 样例输入 #1

```
5 7
1 2
1 3
2 4
3 4
2 3
4 5
4 5
```

### 样例输出 #1

```
1
1
1
2
4
```

## 提示

$1$ 到 $5$ 的最短路有 $4$ 条，分别为 $2$ 条 $1\to 2\to 4\to 5$ 和 $2$ 条 $1\to 3\to 4\to 5$（由于 $4\to 5$ 的边有 $2$ 条）。

对于 $20\%$ 的数据，$1\le N \le 100$；
对于 $60\%$ 的数据，$1\le N \le 10^3$；
对于 $100\%$ 的数据，$1\le N\le10^6$，$1\le M\le 2\times 10^6$。
 */