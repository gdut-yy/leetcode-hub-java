package p587;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF587C {
    static int n, m, q;
    static int[] c;
    static int[][] uva;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        adj = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
        }
        c = new int[m];
        for (int i = 0; i < m; i++) {
            c[i] = scanner.nextInt();
        }
        uva = new int[q][3];
        for (int i = 0; i < q; i++) {
            uva[i][0] = scanner.nextInt() - 1;
            uva[i][1] = scanner.nextInt() - 1;
            uva[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    // 2^17 = 131072 > 1e5
    private static final int mx = 17;
    private static Map<Integer, List<Integer>> adj;
    private static int[] depth;
    private static int[][] pa;
    static List<Integer>[][] pamins;
    private static int k = 10;

    private static String solve() {
        depth = new int[n];
        pa = new int[n][mx];
        pamins = new ArrayList[n][mx];
        for (int i = 0; i < n; i++) {
            pamins[i][0] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int v = c[i] - 1;
            if (pamins[v][0].size() < 10) {
                pamins[v][0].add(i + 1);
            }
        }
        dfs(0, -1, 0);
        for (int i = 0; i + 1 < mx; i++) {
            for (int v = 0; v < n; v++) {
                int p = pa[v][i];
                if (p != -1) {
                    pa[v][i + 1] = pa[p][i];
                    pamins[v][i + 1] = merge(pamins[v][i], pamins[p][i]);
                } else {
                    pa[v][i + 1] = -1;
                    pamins[v][i + 1] = new ArrayList<>();
                }
            }
        }

        List<String> resList = new ArrayList<>();
        for (int[] tuple : uva) {
            int v = tuple[0], w = tuple[1];
            k = tuple[2];

            if (depth[v] > depth[w]) {
                int tmp = v;
                v = w;
                w = tmp;
            }
            List<Integer> mins = new ArrayList<>();
            for (int i = 0; i < mx; i++) {
                if (((depth[w] - depth[v]) >> i & 1) == 1) {
                    mins = merge(mins, pamins[w][i]);
                    w = pa[w][i];
                }
            }
            if (w != v) {
                for (int i = mx - 1; i >= 0; i--) {
                    if (pa[v][i] != pa[w][i]) {
                        mins = merge(mins, merge(pamins[v][i], pamins[w][i]));
                        v = pa[v][i];
                        w = pa[w][i];
                    }
                }
                mins = merge(mins, merge(pamins[v][0], pamins[w][0]));
                v = pa[v][0];
            }
            mins = merge(mins, pamins[v][0]);

            String res = mins.size() + " " + mins.stream().map(String::valueOf).collect(Collectors.joining(" "));
            resList.add(res.trim());
        }
        return String.join(System.lineSeparator(), resList);
    }

    private static void dfs(int x, int fa, int d) {
        pa[x][0] = fa;
        depth[x] = d;
        for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            dfs(y, x, d + 1);
        }
    }

    private static List<Integer> merge(List<Integer> a, List<Integer> b) {
        int i = 0, n = a.size();
        int j = 0, m = b.size();
        List<Integer> c = new ArrayList<>(Math.min(n + m, k));
        while (c.size() < k) {
            if (i == n) {
                if (c.size() + m - j > k) {
                    c.addAll(b.subList(j, j + k - c.size()));
                } else {
                    c.addAll(b.subList(j, b.size()));
                }
                break;
            }
            if (j == m) {
                if (c.size() + n - i > k) {
                    c.addAll(a.subList(i, i + k - c.size()));
                } else {
                    c.addAll(a.subList(i, a.size()));
                }
                break;
            }
            if (a.get(i) < b.get(j)) {
                c.add(a.get(i));
                i++;
            } else {
                c.add(b.get(j));
                j++;
            }
        }
        return c;
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
C. Duff in the Army
https://codeforces.com/contest/587/problem/C

题目大意：
达夫最近在军队当了一名士兵。马利克是她的指挥官。
他们的国家，安达尔兹古有 n 个城市(编号从 1 到 n)和 n - 1 双向道路。每条路连接两个不同的城市。任何两个城市之间都有一条独特的道路。
安达尔兹古也有 m 人(编号从 1 到 m)，每个人都有一个身份证号。身份证号 i -这个人是 i，他/她住在城市号 ci。注意，一个城市可能不止一个人，也可能没有人住在这个城市。
马利克喜欢点菜。这就是为什么他让达夫回答 q 个问题。在每个查询中，他都给了她数字 v, u 和 a。
回答问题:
假设有 x 个人居住在从城市 v 到城市 u 的路径上，假设这些人的 id 是 p1, p2,...,px 依次递增。
如果 k = min(x, a)，那么 Duff 应该告诉 Malek k, p1, p2,...,pk 按此顺序。换句话说，Malek 想知道那条路径上的最小值(或者更小，如果少于一个人)。
达夫现在很忙，所以她让你帮她回答问题。

rating 2200
树上倍增
https://codeforces.com/contest/587/submission/119458835
======

input
5 4 5
1 3
1 2
1 4
4 5
2 1 4 3
4 5 6
1 5 2
5 5 10
2 3 3
5 3 1
output
1 3
2 2 3
0
3 1 2 4
1 2
 */
