package p2065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF2065F {
    // Time limit exceeded on test 12
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        char[] ans = new char[n + 1];
        Arrays.fill(ans, '0');
        ArrayList<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
            if (a[v] == a[w]) {
                ans[a[v]] = '1';
            }
        }

        int[] vis = new int[n + 1];
        for (int i = 0; i < g.length; i++) {
            for (Integer j : g[i]) {
                int v = a[j];
                if (vis[v] == i + 1) {
                    ans[v] = '1';
                } else {
                    vis[v] = i + 1;
                }
            }
        }
        out.println(new String(ans).substring(1));
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
F. Skibidus and Slay
https://codeforces.com/contest/2065/problem/F

灵茶の试炼 2025-08-06
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤5e5。
每组数据输入 n(2≤n≤5e5) 和长为 n 的数组 a(1≤a[i]≤n)。
然后输入一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 开始。节点 i 的点权为 a[i]。
对于 1 到 n 的每个整数 x，判断：
树中是否存在一条至少有两个点的简单路径，路径点权的严格众数存在且等于 x？输出 0 或者 1。
注：序列 S 的严格众数为出现次数严格大于 |S|/2 的数。
你需要输出一个长为 n 的 0-1 字符串。

rating 1700
脑筋急转弯。
如果 i 是严格众数，那么路径至少有两个点权为 i 的点。
考察其中相距最近的两个点。
这两个点必须很近：要么相邻，要么隔了一个点。
如果相距最近的两个点都隔了至少两个点，那么 i 不是严格众数。
所以只需枚举所有相邻点，以及间隔为 1 的点。
前者只需遍历边，后者可以枚举点的所有邻居，即为间隔为 1 的点。
代码 https://codeforces.com/contest/2065/submission/331024392
代码备份（Ubuntu Pastebin）
======

Input
4
3
1 2 3
1 3
2 3
4
3 1 1 3
1 2
2 3
4 2
4
2 4 4 2
1 2
2 3
3 4
13
1 4 4 7 4 7 1 1 7 11 11 11 11
1 2
2 3
3 4
4 5
4 6
2 7
7 8
2 9
6 10
5 11
11 12
10 13
Output
000
1010
0001
1001001000100
 */
