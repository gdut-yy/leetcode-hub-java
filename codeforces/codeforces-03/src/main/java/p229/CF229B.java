package p229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CF229B {
    static int n, m;
    static Map<Integer, List<int[]>> adj;
    static List<List<int[]>> t;

    public static void main(String[] args) {
        // Time limit exceeded on test 8
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int c = scanner.nextInt();
            adj.computeIfAbsent(a, key -> new ArrayList<>()).add(new int[]{b, c});
            adj.computeIfAbsent(b, key -> new ArrayList<>()).add(new int[]{a, c});
        }
        t = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            t.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int pre = -2;
            int k = scanner.nextInt();
            while (k-- > 0) {
                int v = scanner.nextInt();
                if (v > pre + 1) {
                    t.get(i).add(new int[]{v, v});
                } else {
                    List<int[]> ti = t.get(i);
                    ti.get(ti.size() - 1)[1] = v;
                }
                pre = v;
            }
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 2e9;

    private static String solve() {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        if (t.get(0).size() > 0 && t.get(0).get(0)[0] == 0) {
            dist[0] = t.get(0).get(0)[1] + 1;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        minHeap.add(new int[]{0, dist[0]});
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.remove();
            int v = top[0], dis = top[1];
            if (dis > dist[v]) {
                continue;
            }
            for (int[] tuple : adj.getOrDefault(v, new ArrayList<>())) {
                int w = tuple[0], wt = tuple[1];
                int newD = dist[v] + wt;
                List<int[]> tw = t.get(w);
                int i = searchInts(tw, newD);
                if (i < tw.size() && tw.get(i)[0] <= newD) {
                    newD = tw.get(i)[1] + 1;
                }
                if (dist[w] > newD) {
                    dist[w] = newD;
                    minHeap.add(new int[]{w, newD});
                }
            }
        }

        int ans = dist[n - 1] == INF ? -1 : dist[n - 1];
        return String.valueOf(ans);
    }

    // Params:
    // a – the array to be searched
    // key – the value to be searched for
    private static int searchInts(List<int[]> tw, int key) {
        int left = 0;
        int right = tw.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (tw.get(mid)[1] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
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
B. Planets
https://codeforces.com/contest/229/problem/B

灵茶の试炼 2023-05-24
题目大意：
输入 n(2≤n≤1e5) m(0≤m≤1e5) 表示一个 n 点 m 边的无向图（节点编号从 1 开始）。
然后输入 m 条边，每条边包含 3 个数 a b c(1≤c≤1e4)，表示有一条边权为 c 的无向边连接 a 和 b，表示从 a 到 b 需要 c 秒。
保证无自环、无重边。
然后输入 n 行，每行第一个数 k 表示数组 t[i] 的长度，然后输入数组 t[i]。
数组 t[i] 是一个严格递增序列，0≤t[i][j]<1e9。
所有 k 之和 ≤1e5。
初始时间为 0。你从 1 出发，要去 n。
如果你在点 i，但是当前时间在数组 t[i] 中，那么你必须等待 1 秒。如果下一秒仍然在 t[i] 中，那么继续等待 1 秒。依此类推。
输出到达 n 的最早时间。
如果无法到达 n，输出 -1。
【易错题】

rating 1700
https://codeforces.com/contest/229/submission/206931343
Dijkstra 的变形。
把 dis[i] 定义成可以从 i 出发的最早时间。特别地，dis[n] 定义成到 n 的最早时间。
假设在时刻 j 到达点 i，那么需要快速求出 >= j 的第一个不在 t[i] 中的数 next。可以把相邻的时间合并成区间，这样二分就能求出 next。
易错点：
1. t[1][0] = 0 的情况处理了吗？
2. t[n] 中的数据不应当考虑。
======

input
4 6
1 2 2
1 3 3
1 4 8
2 3 4
2 4 5
3 4 3
0
1 3
2 3 4
0
output
7

input
3 1
1 2 3
0
1 3
0
output
-1
 */
