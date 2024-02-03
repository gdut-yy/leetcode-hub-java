package p247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF247B {
    static int n;
    static List<Integer>[] g;
    static int[] a;

    public static void main(String[] args) {
        // Time limit exceeded on test 7
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();

        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        g[0].add(-1);
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            g[x].add(y);
            g[y].add(x);
        }

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] res = dfs(0, -1);
        long ans = res[1] - res[0];
        return String.valueOf(ans);
    }

    // 目标是得到将子树 v 变为 0 所需的 -1 操作和 +1 操作的次数，这样就能够自底向上计算
    static long[] dfs(int x, int fa) {
        long mn = 0, mx = 0;
        long cur = a[x];
        if (g[x].size() == 1) { // 叶子
            mn = Math.min(mn, cur);
            mx = Math.max(mx, cur);
            return new long[]{mn, mx};
        }
        for (Integer y : g[x]) {
            if (y != fa) {
                long[] p = dfs(y, x);
                mn = Math.min(mn, p[0]);
                mx = Math.max(mx, p[1]);
            }
        }
        cur -= mn + mx;
        if (cur < 0) mn += cur;
        else mx += cur;
        return new long[]{mn, mx};
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
B. Zero Tree
https://codeforces.com/contest/274/problem/B

灵茶の试炼 2022-09-27
题目大意：
输入 n(≤1e5)，表示一棵有 n 个节点的树。
然后输入 n-1 条边：这条边所连接的两点的编号（从 1 开始）。
最后输入 n 个数，表示每个节点的值 a[i](-1e9≤a[i]≤1e9)。
每次操作，你可以选择一个包含节点 1 的连通块，把所有点的值都 +1 或都 -1。
输出把树上所有节点的值都变为 0 的最少操作次数。

rating 1800
https://codeforces.com/contest/274/submission/173643473
提示 1：根据题意，以 1 为根，需要先把叶子节点变为 0，才能处理父节点。
提示 2：把处理子节点的操作次数，累加到当前节点上。
提示 3：由于子节点有负有正，需要分别计算对应的操作次数，并返回，继续传递给祖先节点。
======

input
3
1 2
1 3
1 -1 1
output
3

5
2 3
4 5
2 5
1 3
0 2 1 4 3
 */
