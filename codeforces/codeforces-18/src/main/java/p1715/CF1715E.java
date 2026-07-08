package p1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1715E {
    // Time limit exceeded on test 7
//    static Scanner scanner;
    static FastReader scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new FastReader();
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int n, m, k;
    static int[][] gTo, gWt;
    static long[] dis;
    static final long INF = (long) 1e18;
    static int[] hv;
    static long[] hd;
    static int hsz;

    // 1. 自定义原始类型堆 (hv[]/hd[] + siftUp/siftDown) 替代 PriorityQueue<long[]>，消除对象分配和GC开销
    // 2. 邻接表用二维数组 (gTo[][]/gWt[][]) 替代 List<int[]>[]，避免遍历时拆箱和对象访问
    // 3. 除法技巧 (crossCmp) 替代 Math.multiplyHigh，避免128位乘法，更精确且更快
    private static void solve() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        int[] deg = new int[n];
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt() - 1;
            edges[i][1] = scanner.nextInt() - 1;
            edges[i][2] = scanner.nextInt();
            deg[edges[i][0]]++;
            deg[edges[i][1]]++;
        }
        gTo = new int[n][];
        gWt = new int[n][];
        for (int i = 0; i < n; i++) {
            gTo[i] = new int[deg[i]];
            gWt[i] = new int[deg[i]];
            deg[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int v = edges[i][0], w = edges[i][1], wt = edges[i][2];
            gTo[v][deg[v]] = w; gWt[v][deg[v]] = wt; deg[v]++;
            gTo[w][deg[w]] = v; gWt[w][deg[w]] = wt; deg[w]++;
        }
        dis = new long[n];
        Arrays.fill(dis, INF);
        dis[0] = 0;
        hv = new int[n + m + 10];
        hd = new long[n + m + 10];
        long[] qx = new long[n];
        long[] qy = new long[n];
        for (int i = 0; i < k; i++) {
            dij();
            int sz = 0;
            for (int j = 0; j < n; j++) {
                long vx = j;
                long vy = (long) j * j + dis[j];
                while (sz > 1) {
                    long ax = qx[sz - 1] - qx[sz - 2];
                    long ay = qy[sz - 1] - qy[sz - 2];
                    long bx = vx - qx[sz - 1];
                    long by = vy - qy[sz - 1];
                    if (crossCmp(ax, ay, bx, by) > 0) break;
                    sz--;
                }
                qx[sz] = vx;
                qy[sz] = vy;
                sz++;
            }
            int head = 0;
            for (int j = 0; j < n; j++) {
                long px = -2L * j;
                while (head + 1 < sz && px * qx[head] + qy[head] >= px * qx[head + 1] + qy[head + 1]) {
                    head++;
                }
                dis[j] = px * qx[head] + qy[head] + (long) j * j;
            }
        }
        dij();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(dis[i]).append(' ');
        }
        out.println(sb);
    }
    static int crossCmp(long ax, long ay, long bx, long by) {
        if (ay >= 0 && by < 0) return -1;
        if (ay < 0 && by >= 0) return 1;
        if (ay >= 0) {
            long q1 = by / bx, r1 = by % bx;
            long q2 = ay / ax, r2 = ay % ax;
            if (q1 != q2) return Long.compare(q1, q2);
            return Long.compare(r1 * ax, r2 * bx);
        }
        long absAy = -ay, absBy = -by;
        long q1 = absBy / bx, r1 = absBy % bx;
        long q2 = absAy / ax, r2 = absAy % ax;
        if (q2 != q1) return Long.compare(q2, q1);
        return Long.compare(r2 * bx, r1 * ax);
    }
    static void dij() {
        hsz = 0;
        for (int i = 0; i < n; i++) {
            if (dis[i] < INF) {
                hv[hsz] = i;
                hd[hsz] = dis[i];
                hsz++;
            }
        }
        for (int i = (hsz - 1) >> 1; i >= 0; i--) siftDown(i, hsz);
        while (hsz > 0) {
            int v = hv[0];
            long d = hd[0];
            hsz--;
            if (hsz > 0) {
                hv[0] = hv[hsz];
                hd[0] = hd[hsz];
                siftDown(0, hsz);
            }
            if (d > dis[v]) continue;
            int[] to = gTo[v], wt = gWt[v];
            for (int i = 0, len = to.length; i < len; i++) {
                int w = to[i];
                long newD = d + wt[i];
                if (newD < dis[w]) {
                    dis[w] = newD;
                    hv[hsz] = w;
                    hd[hsz] = newD;
                    siftUp(hsz);
                    hsz++;
                }
            }
        }
    }
    static void siftUp(int i) {
        while (i > 0) {
            int p = (i - 1) >> 1;
            if (hd[p] <= hd[i]) break;
            int tv = hv[i]; hv[i] = hv[p]; hv[p] = tv;
            long td = hd[i]; hd[i] = hd[p]; hd[p] = td;
            i = p;
        }
    }
    static void siftDown(int i, int sz) {
        while (true) {
            int min = i;
            int l = (i << 1) + 1, r = l + 1;
            if (l < sz && hd[l] < hd[min]) min = l;
            if (r < sz && hd[r] < hd[min]) min = r;
            if (min == i) break;
            int tv = hv[i]; hv[i] = hv[min]; hv[min] = tv;
            long td = hd[i]; hd[i] = hd[min]; hd[min] = td;
            i = min;
        }
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
E. Long Way Home
https://codeforces.com/contest/1715/problem/E

灵茶の试炼 2026-02-13
题目大意：
输入 n(2≤n≤1e5) m(1≤m≤1e5) 和 k(1≤k≤20)，表示一个 n 点 m 边的无向图。无自环，可能有重边。
然后输入 m 条边，每条边输入 x y w(1≤w≤1e9)，表示一条边权为 w 的无向边连接 x 和 y。节点编号从 1 到 n。
有 n 座城市，m 条道路连接这些城市。
此外，每对城市之间都有一条航班。从城市 x 到城市 y 的用时为 (x-y)²。
输出 n 个数。
第 i 个数表示在至多乘坐 k 次航班的约束下，从 1 到 i 的最短路长度。

rating 2400
如果 k=1，怎么做？

移动路线要么是只乘车，要么是车->飞机->车。
这可以统一为车->飞机->车，因为飞机可以原地 TP，边权为 0。
思考框架类似状态机 DP：
状态 0：先跑一次 Dijkstra，这是只乘车的最短路长度。
状态 1：然后，想办法求出「车->飞机」的最短路长度。相当于在图中添加 1 到 i 的边，边权为通过「车->飞机」从 1 到 i 的最短路长度。
状态 2：最后，在这个新图上再跑一遍 Dijkstra，得到「车->飞机->车」的最短路长度。
设第一次 Dijkstra 跑完后，从 1 到 i 的最短路长度为 dis[i]。
设通过「车->飞机」从 1 到 i 的最短路长度 newDis[i]。
假设「车->飞机」的最后一步是从 j 飞到 i，我们枚举 j，那么有
newDis[i] = min_{j} dis[j] + (i-j)^2
上式可以用斜率优化解决。关于斜率优化的入门题和原理，见上周五的题。
注意本题 j 的范围是 1 到 n，要先构建凸包，然后再计算 DP。
算出 newDis 后，在图中添加 1 到 i 的边，边权为 newDis[i]。或者，在 Dijkstra 初始化堆的时候，把所有 newDis[i] 入堆。
最后再跑一遍 Dijkstra，就得到了「车->飞机->车」的最短路长度。
对于 k<=20 的一般情况，重复上述流程 k 次。（也可以理解成状态数为 2k+1 的状态机 DP）
代码 https://codeforces.com/contest/1715/submission/362342314
代码备份（上面打不开的同学看这个）
======

Input
3 1 2
1 3 1
Output
0 1 1

Input
4 3 1
1 2 3
2 4 5
3 4 7
Output
0 1 4 6

Input
2 1 1
2 1 893746473
Output
0 1

Input
5 5 2
2 1 33
1 5 93
5 3 48
2 3 21
4 2 1
Output
0 1 2 2 3
 */
