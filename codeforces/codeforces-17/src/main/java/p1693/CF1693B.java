package p1693;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CF1693B {
    private static int[][] lr;

    public static void main(String[] args) {
        // Time limit exceeded on test 7
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] p = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                p[i] = scanner.nextInt();
            }
            lr = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                lr[i][0] = scanner.nextInt();
                lr[i][1] = scanner.nextInt();
            }
            System.out.println(solve(n, p));
        }
    }

    private static Map<Integer, List<Integer>> adj;
    private static int ans;

    private static String solve(int n, int[] p) {
        adj = new HashMap<>();
        for (int x = 2; x <= n; x++) {
            int fa = p[x];
            adj.computeIfAbsent(fa, key -> new ArrayList<>()).add(x);
        }
        ans = 0;
        dfs(1);
        return String.valueOf(ans);
    }

    private static long dfs(int x) {
        long sum = 0L;
        for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
            sum += dfs(y);
        }
        if (sum < lr[x][0]) {
            ans++;
            sum = lr[x][1];
        } else if (sum > lr[x][1]) {
            sum = lr[x][1];
        }
        return sum;
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
B. Fake Plastic Trees
https://codeforces.com/contest/1693/problem/B

灵茶の试炼 2023-05-17
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 表示一棵 n 个节点的树，编号从 1 开始，1 为根节点。
然后输入 p[2],p[3],...,p[n]，其中 p[i] 表示 i 的父节点。
然后输入 n 行，其中第 i 行输入两个数 l 和 r，表示第 i 个节点值的目标范围 [l,r]。
初始时，所有节点值均为 0。
每次操作你可以选择一条从 1 开始的路径，把路径上的每个节点值都加上一个数。要求这些数按照路径的顺序，形成一个递增序列。（可以相等，可以等于 0，例如 [0,0,1,3,3]）
要使所有节点值都在对应的范围内，至少要操作多少次？

rating 1700
https://codeforces.com/contest/1693/submission/206072426
自底向上思考。
每个叶子由于下界 >=1，所以一定要操作，由于序列是递增的，那么尽量取范围的上界，祖先节点的增量可以没叶子这么多。
对于一个非叶节点，累加所有子节点的增量。如果小于下界，那么必须操作一次，变成上界。如果大于上界则免费调整为上界。
======

input
4
2
1
1 5
2 9
3
1 1
4 5
2 4
6 10
4
1 2 1
6 9
5 6
4 5
2 4
5
1 2 3 4
5 5
4 4
3 3
2 2
1 1
output
1
2
2
5
 */
