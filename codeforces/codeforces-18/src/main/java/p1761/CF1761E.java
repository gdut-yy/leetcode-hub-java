package p1761;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF1761E {
    static int n;
    static char[][] a;
    static int[] deg;

    public static void main(String[] args) {
        // Time limit exceeded on test 10
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new char[n][];
            deg = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next().toCharArray();
                int c1 = 0;
                for (char c : a[i]) if (c == '1') c1++;
                deg[i] = c1;
            }
            System.out.println(solve());
        }
    }

    static boolean[] vis;
    static List<Integer> vs;

    private static String solve() {
        vis = new boolean[n];
        vs = new ArrayList<>();

        List<List<Integer>> comps = new ArrayList<>();
        for (int st = 0; st < n; st++) {
            boolean b = vis[st];
            if (b) continue;
            vs.clear();
            dfs(st);
            int m = vs.size();
            if (m == n) {
                return "0";
            }
            if (m == 1) {
                return "1" + System.lineSeparator()
                        + (vs.get(0) + 1);
            }
            Integer mn = vs.get(0);
            for (Integer v : vs) {
                if (deg[v] < deg[mn]) {
                    mn = v;
                }
            }
            if (deg[mn] < m - 1) {
                return "1" + System.lineSeparator()
                        + (mn + 1);
            }
            comps.add(new ArrayList<>(vs));
        }
        if (comps.size() > 2) {
            return "2" + System.lineSeparator()
                    + (comps.get(0).get(0) + 1) + " " + (comps.get(1).get(0) + 1);
        }
        List<Integer> ans = comps.get(0);
        if (comps.get(1).size() < ans.size()) {
            ans = comps.get(1);
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(o -> String.valueOf(o + 1)).collect(Collectors.joining(" "));
    }

    static void dfs(int v) {
        vis[v] = true;
        vs.add(v);
        for (int w = 0; w < a[v].length; w++) {
            char b = a[v][w];
            if (b == '1' && !vis[w]) {
                dfs(w);
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
E. Make It Connected
https://codeforces.com/contest/1761/problem/E

灵茶の试炼 2024-01-12
题目大意：
输入 T(≤800) 表示 T 组数据。所有数据的 n 之和 ≤4000。
每组数据输入 n(2≤n≤4000) 和一个 n*n 的 01 矩阵 g。
g 表示一个无向图的邻接矩阵，其中 g[i][j]=1 表示有一条边连接 i 和 j。
保证 g[i][j]=g[j][i] 且 g[i][i]=0。
有如下操作：
选择一个点 x，对于其余每个点 y，如果 x 和 y 有边，则删除，如果没有边，则添加一条连接 x 和 y 的边。
要使图是连通的，最少要操作多少次？
输出操作次数和每次操作的 x。顶点编号从 1 开始。

rating 2400
分类讨论题。
按照如下顺序，依次判断：
1. 如果只有一个连通块，那么无需操作，输出 0。
2. 如果存在一个孤立点，那么只需对这个点操作，即可让整个图连通。
3. 如果存在一个不是团（完全子图）的连通块，那么只需对这个连通块的度最小的点操作。证明见下。
4. 如果有至少 3 个连通块（都是团），那么只需操作两次，随便选两个在不同连通块的点。
5. 如果只有两个连通块（都是团），那么选其中点数少的连通块操作，操作次数就是该连通块的点数。
3 的证明：
设这个度最小的点是 x，设 x 所在连通分量为 V。由于 V 不是团，所以 V 中的某些点在操作前不与 x 相连，在操作后会与 x 相连。
如果 x 不是割点，那么操作后，V 不会分成更多的连通块，并且仍然有点连着 x，所以整个图是连通的。
如果 x 是割点（例如两个三角形各有一个顶点连着 x），首先来说明几个性质：
性质 1：由于 x 的度数至少是 2（割点性质），所以其余每个点的度数也至少是 2，这意味着 V 中没有「叶子」。
性质 2：删除 x 会把 V 分成若干个连通块，每个连通块至少有 3 个点（根据性质 1）。
现在的问题是：操作后，每个连通块是否都有点与 x 相连？
反证法：假设有一个连通块 U 没有点与 x 相连，设这个连通块的大小为 |U|。
由于操作前 x 除了与这 |U| 个点相连外，还与其它点相连（注意我们假设 x 是割点），这说明 x 的度数至少是 |U|+1，但由于 x 的度数最小，所以 |U| 中必定有度数至少为 |U|+1 的点，但 U 中只有 |U| 个点，度数不可能超过 |U|，矛盾。所以操作后，每个连通块都至少有一个点与 x 相连。
https://codeforces.com/contest/1761/submission/239970179
======

input
4
3
011
100
100
3
000
001
010
4
0100
1000
0001
0010
6
001100
000011
100100
101000
010001
010010
output
0
1
1
2
3 4
3
2 5 6
 */
