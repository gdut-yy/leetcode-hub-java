package p219;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF219D {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int[][] st = new int[n][2];
        for (int i = 0; i < n - 1; i++) {
            st[i][0] = scanner.nextInt();
            st[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, st));
    }

    private static Map<Integer, List<Integer>> adj;
    private static Set<Long> set;
    private static int cnt1;
    private static int minCnt;
    private static List<Integer> resList;

    private static String solve(int n, int[][] st) {
        adj = new HashMap<>();
        set = new HashSet<>();
        for (int[] x : st) {
            set.add((long) x[0] << 32 | x[1]);
            // 建图
            adj.computeIfAbsent(x[0], key -> new ArrayList<>()).add(x[1]);
            adj.computeIfAbsent(x[1], key -> new ArrayList<>()).add(x[0]);
        }
        // 并不需要从根节点开始
        cnt1 = 0;
        dfs1(1, -1);

        minCnt = n;
        resList = new ArrayList<>();
        dfs2(1, -1, cnt1);

        return minCnt + System.lineSeparator()
                + resList.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "));
    }

    static void dfs1(int x, int fa) {
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            // 需要变向
            if (set.contains((long) y << 32 | x)) {
                cnt1++;
            }
            dfs1(y, x);
        }
    }

    // 换根 DP
    static void dfs2(int x, int fa, int cnt) {
        if (minCnt > cnt) {
            minCnt = cnt;
            resList.clear();
            resList.add(x);
        } else if (minCnt == cnt) {
            resList.add(x);
        }
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            // 换根后反转
            int cnty = cnt;
            if (set.contains((long) x << 32 | y)) cnty++;
            else cnty--;
            dfs2(y, x, cnty);
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
D. Choosing Capital for Treeland
https://codeforces.com/contest/219/problem/D

灵茶の试炼 2023-03-06
题目大意：
给定整数 n 和 n-1 条有向边 si, ti（节点编号 1 ~ n）。保证输入构成一棵树。
你可以把边反向，定义 f(x) 表示以 x 为根时，要让 x 能够到达任意点，需要反向的边的数量。
输出 min(f(x))，以及所有等于 min(f(x)) 的节点编号（按升序输出）。

换根 DP。
不用 FastReader 会 TLE。。
相似题目: 2581. 统计可能的树根数目
https://leetcode.cn/problems/count-number-of-possible-root-nodes/
======

input
3
2 1
2 3
output
0
2

input
4
1 4
2 4
3 4
output
2
1 2 3
 */
