package c305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Abc305_e {
    static int n, m, k;
    static int[][] ab, ph;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        ab = new int[m][2];
        for (int i = 0; i < m; i++) {
            ab[i][0] = scanner.nextInt() - 1;
            ab[i][1] = scanner.nextInt() - 1;
        }
        ph = new int[k][2];
        for (int i = 0; i < k; i++) {
            ph[i][0] = scanner.nextInt() - 1;
            ph[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] p : ab) {
            adj.computeIfAbsent(p[0], key -> new ArrayList<>()).add(p[1]);
            adj.computeIfAbsent(p[1], key -> new ArrayList<>()).add(p[0]);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        // 剪枝：避免小的点影响到大的点
        Arrays.sort(ph, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        for (int[] p : ph) {
            vis[p[0]] = p[1];
            queue.add(p);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] tuple = queue.remove();
                    int x = tuple[0], h = tuple[1];

                    if (h == 0) continue;
                    for (int y : adj.getOrDefault(x, new ArrayList<>())) {
                        // 剪枝：避免小的点影响到大的点
                        if (vis[y] < h - 1) {
                            vis[y] = h - 1;
                            queue.add(new int[]{y, h - 1});
                        }
                    }
                }
            }
        }

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] >= 0) {
                resList.add(String.valueOf(i + 1));
            }
        }
        return resList.size() + System.lineSeparator()
                + String.join(" ", resList);
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
E - Art Gallery on Graph
https://atcoder.jp/contests/abc305/tasks/abc305_e

题目大意：
有一个简单的无向图，有 N 个顶点和 M 条边，其中顶点编号从 1 到 N，边编号从 1 到 M。边 i 连接顶点 ai 和顶点 bi。
K 个编号为 1 到 K 的保安在一些顶点上。守卫 i 在顶点 pi 并且有 hi 的耐力。所有 pi 都是不同的。
当满足以下条件时，顶点 v 被称为受保护顶点:
- 至少有一个守卫 i 使得顶点 v 和顶点 pi 之间的距离不超过 hi。
这里，顶点 u 和顶点 v 之间的距离是连接顶点 u 和 v 的路径中边的最小个数。
按升序列出所有受保护的顶点。

BFS
Scanner 1921ms
======

Input 1
5 5 2
1 2
2 3
2 4
3 5
1 5
1 1
5 2
Output 1
4
1 2 3 5

Input 2
3 0 1
2 3
Output 2
1
2

Input 3
10 10 2
2 1
5 1
6 1
2 4
2 5
2 10
8 5
8 6
9 6
7 9
3 4
8 2
Output 3
7
1 2 3 5 6 8 9
 */