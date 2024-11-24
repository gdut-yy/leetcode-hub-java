package p911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF911F {
    static int n;
    static List<Integer>[] g;
    static int[] deg;

    public static void main(String[] args) {
        // Time limit exceeded on test 35
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        deg = new int[n];
        for (int i = 1; i < n; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
            deg[v]++;
            deg[w]++;
        }
        System.out.println(solve());
    }

    static int u;
    static int maxD;
    static int[][] f; // v, d

    private static String solve() {
//        u = 0;
        maxD = -1;
        dfs(0, -1, 0);
        int dv = u;
        maxD = -1;
        dfs(u, -1, 0);
        int dw = u;
        long ans = maxD * (maxD + 1L) / 2;

        f = new int[n][2];
        for (int i = 0; i < n; i++) {
            f[i][1] = -1;
        }
        findFarthest(dv, -1, 0, dv);
        findFarthest(dw, -1, 0, dw);

        List<int[]> op = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && i != dv && i != dw) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int v = q.remove();
            int[] p = f[v];
            ans += p[1];
            p[1] = -1;
            op.add(new int[]{v, p[0], v});
            for (Integer w : g[v]) {
                if (--deg[w] == 1) {
                    q.add(w);
                }
            }
        }

        for (int v = dv; v != dw; ) {
            f[v][1] = -1;
            op.add(new int[]{v, dw, v});
            for (Integer w : g[v]) {
                if (f[w][1] >= 0) {
                    v = w;
                    break;
                }
            }
        }
        return ans + System.lineSeparator()
                + op.stream().map(row -> Arrays.stream(row).mapToObj(o -> String.valueOf(o + 1)).collect(Collectors.joining(" ")))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    static void dfs(int v, int fa, int d) {
        if (d > maxD) {
            maxD = d;
            u = v;
        }
        for (Integer w : g[v]) {
            if (w != fa) {
                dfs(w, v, d + 1);
            }
        }
    }

    static void findFarthest(int v, int fa, int d, int tar) {
        if (d > f[v][1]) {
            f[v][1] = d;
            f[v][0] = tar;
        }
        for (Integer w : g[v]) {
            if (w != fa) {
                findFarthest(w, v, d + 1, tar);
            }
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
F. Tree Destruction
https://codeforces.com/contest/911/problem/F

灵茶の试炼 2024-04-19
题目大意：
输入 n(2≤n≤2e5) 和一棵 n 个节点的无权树的 n-1 条边。节点编号从 1 开始。
你需要执行 n-1 次操作，每次操作包含如下三步：
1. 选择两个叶节点。
2. 把两个叶节点之间的最短距离（简单路径的长度）加到答案中（答案初始为 0）。
3. 删除这两个叶节点中的一个。
输出答案的最大值，以及 n-1 行，每行三个数，表示你选的两个叶结点的编号，以及删除的叶结点的编号。

rating 2400
提示 1
对于给定的一个点，谁到这个节点的距离最远？
答：直径端点。
提示 2
前期操作：选一个非直径端点 x，以及这个点对应的直径端点，然后删除 x。这可以保证直径端点不被破坏。
后期操作：只剩下直径时，再去删除直径。
https://codeforces.com/contest/911/submission/251176966
======

Input
3
1 2
1 3
Output
3
2 3 3
2 1 1

Input
5
1 2
1 3
2 4
2 5
Output
9
3 5 5
4 3 3
4 1 1
4 2 2
 */
