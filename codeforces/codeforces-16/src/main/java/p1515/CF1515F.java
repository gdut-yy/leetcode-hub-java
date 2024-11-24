package p1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CF1515F {
    static int n, m, x;
    static long[] a;
    static List<int[]>[] g;

    public static void main(String[] args) {
        // Time limit exceeded on test 22
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        x = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i <= m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(new int[]{w, i});
            g[w].add(new int[]{v, i});
        }
        System.out.println(solve());
    }

    static List<String> output;
    static List<Integer> todo;
    static boolean[] vis;

    private static String solve() {
        long s = Arrays.stream(a).sum();
        if (s < (n - 1L) * x) return "NO";

        output = new ArrayList<>();
        output.add("YES");
        todo = new ArrayList<>();
        vis = new boolean[n];
        dfs(0);
        for (int i = todo.size() - 1; i >= 0; i--) {
            output.add("" + todo.get(i));
        }
        return String.join(System.lineSeparator(), output);
    }

    static void dfs(int v) {
        vis[v] = true;
        for (int[] e : g[v]) {
            int w = e[0], eid = e[1];
            if (vis[w]) continue;
            dfs(w);
            if (a[w] >= x) {
                output.add("" + eid);
                a[v] += a[w] - x;
            } else {
                todo.add(eid);
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
F. Phoenix and Earthquake
https://codeforces.com/contest/1515/problem/F

灵茶の试炼 2024-01-26
题目大意：
输入 n(2≤n≤3e5) m(n-1≤m≤3e5) x(1≤x≤1e9)，表示一个 n 点 m 边的无向图（节点编号从 1 开始）。
输入长为 n 的数组 a(0≤a[i]≤1e9)，表示每个点的点权。
然后输入 m 条边。保证图中没有自环和重边。保证图是连通的。
把点视作城市，把边视作道路。
一场地震摧毁了所有的道路，现在需要修复其中 n-1 条道路，将所有城市连接起来。
城市 i 有 a[i] 吨沥青。
如果城市 i 和城市 j 的沥青总量至少是 x，那么可以修复 i 和 j 之间的道路，并消耗 x 吨沥青。
一个城市的沥青可以沿着修好的道路运往其它城市。
是否可以将所有城市连接起来？
如果不能，输出 NO。
如果能，输出 YES，并按照修路的顺序，依次输出这 n-1 条边的编号（输入的第 i 条边的编号是 i，从 1 开始）。如果有多种方案，输出任意一种。

rating 2600
如果 sum(a) < (n-1) * x，输出 NO。
如果 sum(a) >= (n-1) * x 则一定可以。
设 T 为图的任意一棵生成树，设 v 是 T 的一个叶子节点。
用归纳法思考：
- 如果 a[v] >= x，我们可以修 v 及其父节点 fa 的边，然后把 a[fa] 增加 a[v]-x，问题变成一个 n-1 个点 n-2 条边的子问题，仍然满足 sum(a') >= (n-2) * x，因为不等式左右都减少了 x。
- 如果 a[v] < x，我们可以先把其余 n-1 个点之间的 n-2 条边修好，最后再来修 v 及其父节点的边。对于其余 n-1 个点，仍然满足 sum(a') >= (n-2) * x，因为不等式左边减少了 a[v]，右边减少了 x。
如何实现？
DFS 图，把 DFS 树当作生成树。
当前点设为 v，它的儿子设为 w。
递归完 w 之后：
如果 a[w] >= x，那么把 a[v] 增加 a[w]-x，直接输出 v-w 边的编号（编号在建图的时候保存）。
如果 a[w] < x，保存 v-w 边的编号到一个 to do 列表中。
DFS 结束后，倒序输出 to do 列表中的编号。
https://codeforces.com/problemset/submission/1515/242942041
======

input
5 4 1
0 0 0 4 0
1 2
2 3
3 4
4 5
output
YES
3
2
1
4

input
2 1 2
1 1
1 2
output
YES
1

input
2 1 2
0 1
1 2
output
NO

input
5 6 5
0 9 4 0 10
1 2
1 3
2 3
3 4
1 4
4 5
output
YES
6
4
1
2
 */
