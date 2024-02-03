package p369;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF369C {
    static int n;
    static List<int[]>[] g;

    public static void main(String[] args) {
        // Time limit exceeded on test 14
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();

        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int wt = scanner.nextInt();
            g[x].add(new int[]{y, wt});
            g[y].add(new int[]{x, wt});
        }
        System.out.println(solve());
    }

    static List<Integer> ans;

    private static String solve() {
        ans = new ArrayList<>();
        dfs(1, 0);
        return ans.size() + System.lineSeparator() +
                ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    static boolean dfs(int x, int fa) {
        boolean choose = false;
        for (int[] p : g[x]) {
            int y = p[0], wt = p[1];
            if (y == fa) continue;
            boolean c = dfs(y, x);
            if (!c && wt == 2) {
                ans.add(y);
                c = true;
            }
            choose = choose || c;
        }
        return choose;
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
C. Valera and Elections
https://codeforces.com/contest/369/problem/C

灵茶の试炼 2023-12-06
题目大意：
输入 n(2≤n≤1e5)，表示一棵 n 个节点的无向树（节点编号从 1 开始）。
然后输入 n-1 条边，每条边输入 x y t，表示有一条无向边连接 x 和 y，其中 t=1 表示这条边是好的，t=2 表示这条边是坏的。
你需要选择一些点。如果点 v 在你选的点中，那么从 v 到 1 这条路径上的所有坏边都会变成好边。
问：最少需要选多少个点，才能使所有坏边变成好边？
输出两行：第一行是选的点的个数，第二行是这些点的编号（可以按任意顺序输出点的编号）。

rating 1600
从 1 开始 DFS。
如果子树 v 中没有坏边，且 v 到其父节点的边是坏的，则把 v 加入答案。
https://codeforces.com/contest/369/submission/235348779
======

input
5
1 2 2
2 3 2
3 4 2
4 5 2
output
1
5

input
5
1 2 1
2 3 2
2 4 1
4 5 1
output
1
3

input
5
1 2 2
1 3 2
1 4 2
1 5 2
output
4
5 4 3 2
 */
