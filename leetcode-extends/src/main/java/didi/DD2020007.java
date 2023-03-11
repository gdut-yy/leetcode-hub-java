package didi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class DD2020007 {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = scanner.nextInt();
        }
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = i + 1 + 1;
            edges[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, m, d, p, edges));
    }

    private static boolean[] special;
    private static Map<Integer, List<Integer>> adj;
    private static Node[] dis;
    private static int ans;

    private static String solve(int n, int m, int d, int[] p, int[][] edges) {
        // special[i] = true 表示节点 i 为特殊点
        special = new boolean[n + 1];
        for (int x : p) {
            special[x] = true;
        }
        // 建图
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        dis = new Node[n + 1];
        dfs(1, -1);

        ans = 0;
        dfs(1, -1, Integer.MIN_VALUE, d);
        return String.valueOf(ans);
    }

    private static int dfs(int x, int fa) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, fx = 0;
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            int d = dfs(y, x) + 1;
            if (d > first) {
                second = first;
                first = d;
                fx = y;
            } else if (d > second) {
                second = d;
            }
        }
        dis[x] = new Node(first, second, fx);
        if (first < 0 && special[x]) {
            return 0;
        }
        return first;
    }

    // 换根 DP
    private static void dfs(int x, int fa, int dFa, int d) {
        if (dFa > d) {
            return;
        }
        Node node = dis[x];
        if (node.first <= d) {
            ans++;
        }
        if (special[x] && dFa < 0) {
            dFa = 0;
        }
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            if (y == node.fx) {
                dfs(y, x, Math.max(dFa, node.second) + 1, d);
            } else {
                dfs(y, x, Math.max(dFa, node.first) + 1, d);
            }
        }
    }

    private static class Node {
        // 对每个点记录往下走的最远特殊点距离和第二远特殊点距离，以及最远特殊点在哪棵子树中
        int first, second, fx;

        public Node(int first, int second, int fx) {
            this.first = first;
            this.second = second;
            this.fx = fx;
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
DD-2020007. 多源 D 点
https://leetcode.cn/problems/XiqZWx/

给出一棵 n 个结点的树，树上每条边的边权都是 1，这 n 个结点中有 m 个特殊点，请你求出树上距离这 m 个特殊点距离均不超过 d 的点的数量，包含特殊点本身。
格式：
输入：
- 输入第一行包含三个正整数，n,m,d 分别表示树上有 n 个结点，其中有 m 个点是特殊点，d 是如题所示的距离。
- 第二行 m 个整数，表示特殊的点的编号，编号在 1-n 之间。
- 第三行有 n-1 个整数，第 i 个数表示第 i+1 号结点的父亲结点的编号，同样在 1-n 之间。
输出：
- 输出仅包含一个整数，即符合题目要求的点的数量。
示例：
输入：
6 2 3
2 1
3 4 5 6 1
输出：2
提示：
1 <= n, m, d <= 50000

换根 DP。CF337D 原题。
如果要暴力求解出最优解，则我们可以枚举所有的节点为根，然后分别跑一次搜索，这样的时间复杂度会达到 O(n^2)，显然不可接受。我们可以通过换根 DP 来解决。
第一次 DFS 以 1 为根，对每个点记录往下走的最远特殊点距离和第二远特殊点距离，以及最远特殊点在哪棵子树中。
第二次 DFS，从 x 到 y 时：
如果 y 是 x 的最远特殊点所在子树，那么 y 往上的最远特殊点距离就是 max(x 往上最远特殊点距离, x 往下第二远特殊点距离) + 1；
如果 y 不是 x 的最远特殊点所在子树，那么 y 往上的最远特殊点距离就是 max(x 往上最远特殊点距离, x 往下最远特殊点距离) + 1。
对于一个点 x，如果 x 往上往下的最远特殊点距离都不超过 d，那么 x 就可能是特殊点所在位置。
https://leetcode.cn/problems/XiqZWx/solution/java-on-huan-gen-dpfu-ti-mu-ce-shi-yong-618o2/
 */