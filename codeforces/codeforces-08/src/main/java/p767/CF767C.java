package p767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF767C {
    static int n, rt;
    static int tot;
    static int[] wt;

    public static void main(String[] args) {
        // only java 8/11 AC, java 17 64bit RE (StackOverflowError)
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        wt = new int[N];
        tot = 0;
        rt = 0;
        Arrays.fill(he, -1);
        for (int w = 1; w <= n; w++) {
            // v -> w
            int v = scanner.nextInt();
            wt[w] = scanner.nextInt();

            tot += wt[w];
            if (v == 0) {
                rt = w;
            } else {
                add(v, w);
            }
        }
        System.out.println(solve());
    }

    // 链式前向星
    static int N = (int) (1e6 + 5), M = N;
    static int[] he = new int[N], ne = new int[M], ed = new int[M]/*, we = new int[M]*/;
    static int idx = 0;

    static void add(int u, int v/*, int w*/) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
//        we[idx] = w;
        idx++;
    }

    static int x, y;

    private static String solve() {
        if (tot % 3 != 0) {
            return "-1";
        }
        tot /= 3;

        x = 0;
        y = 0;
        dfs(rt);
        if (y == 0) return "-1";
        return x + " " + y;
    }

    static int dfs(int v) {
        int s = wt[v];
        for (int i = he[v]; i != -1; i = ne[i]) {
            int w = ed[i];

            s += dfs(w);
        }
        if (v != rt && s == tot) {
            if (x == 0) {
                x = v;
                s = 0;
            } else if (y == 0) {
                y = v;
                s = 0;
            }
        }
        return s;
    }

    private static class FastReader {
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
C. Garland
https://codeforces.com/contest/767/problem/C

灵茶の试炼 2022-10-17
题目大意：
输入 n(3≤n≤1e6)，表示一颗有 n 个节点的有根树，节点编号从 1 开始。
每行输入两个数，表示当前节点的父节点编号（如果是 0 表示当前节点是根节点），以及节点的点权，范围在 [-100,100]。
例如节点 1 的父节点为 2，则表示一条 2->1 的边。
你需要删除两条边，将这棵树分成三个连通块，且每个连通块的点权和相等。
假设删除的边是 a->b 和 c->d，你需要输出 b 和 d。如果有多种方案，输出任意一种。
如果无法做到，输出 -1。

rating 2000
https://codeforces.com/contest/767/submission/174193693
做法类似双周赛 t4，每统计到一个点权和等于 total / 3 的连通块，就断开它和父节点的边。取前两个作为答案。
https://www.bilibili.com/video/BV1cV4y157BY
相似题目: 2440. 创建价值相同的连通块
https://leetcode.cn/problems/create-components-with-same-value/
======

input
6
2 4
0 5
4 2
2 1
1 1
4 2
output
1 4

input
6
2 4
0 6
4 2
2 1
1 1
4 2
output
-1
 */
