package c267;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Abc267_f {
    static int n, q;
    static Map<Integer, List<Integer>> adj;
    //    static int[][] uk;
    static Map<Integer, List<int[]>> qs;

    public static void main(String[] args) {
        // TLE
//        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        adj = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(w);
            adj.computeIfAbsent(w, key -> new ArrayList<>()).add(v);
        }
        q = scanner.nextInt();
//        uk = new int[n][2];
//        for (int i = 0; i < q; i++) {
//            uk[i][0] = scanner.nextInt();
//            uk[i][1] = scanner.nextInt();
//        }
        qs = new HashMap<>();
        for (int i = 0; i < q; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            qs.computeIfAbsent(v, key -> new ArrayList<>()).add(new int[]{i, w});
        }
        System.out.println(solve());
    }

    static int[] ans, nodes;
    static int rt, mx;

    private static String solve() {
        ans = new int[q];
        Arrays.fill(ans, -1);
        nodes = new int[n];

        rt = 1;
        for (int i = 0; i < 3; i++) {
            mx = -1;
            dfs(rt, 0, 0);
        }

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static void dfs(int v, int fa, int d) {
        if (mx < d) {
            mx = d;
            rt = v;
        }
        nodes[d] = v;
        for (int[] p : qs.getOrDefault(v, new ArrayList<>())) {
            if (d >= p[1]) {
                ans[p[0]] = nodes[d - p[1]];
            }
        }
        for (Integer w : adj.getOrDefault(v, new ArrayList<>())) {
            if (w != fa) {
                dfs(w, v, d + 1);
            }
        }
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
F - Exactly K Steps
https://atcoder.jp/contests/abc267/tasks/abc267_f

灵茶の试炼 2022-12-29
题目大意：
输入 n(≤2e5) 和一棵树的 n-1 条边（节点编号从 1 开始）。
然后输入 q(≤2e5) 和 q 个询问，每个询问输入 u 和 k。
输出到 u 的距离为 k 的任意一个点。如果这个点不存在则输出 -1。
距离指两点最短路上的边的数目。

https://atcoder.jp/contests/abc267/submissions/37595672
求出树的任意一条直径，设直径端点为 x 和 y。
从 x 出发 dfs，同时记录 dfs 路径上的点。
如果点 u 的深度 d >= k，那么 dfs 路径上的第 d-k 个点就是答案。
一次 dfs 不一定能满足所有点，再从 y 出发 dfs 一次就能保证所有点都有答案（除了 k 非常大的）。
======

Input 1
5
1 2
2 3
3 4
3 5
3
2 2
5 3
3 3
Output 1
4
1
-1

Input 2
10
1 2
2 3
3 5
2 8
3 4
4 6
4 9
5 7
9 10
5
1 1
2 2
3 3
4 4
5 5
Output 2
2
4
10
-1
-1
 */