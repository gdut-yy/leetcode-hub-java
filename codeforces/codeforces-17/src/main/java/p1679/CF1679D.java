package p1679;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class CF1679D {
    static int n, m;
    static long k;
    static int[] a;
//    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextLong();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
//        g = new ArrayList[n];
//        Arrays.setAll(g, e -> new ArrayList<>());
        Arrays.fill(he, -1);
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
//            g[v].add(w);
            add(v, w);
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;
    // 链式前向星
    static int N = (int) (1e6 + 5), M = N;
    static int[] he = new int[N], ne = new int[M], ed = new int[M]/*, we = new int[M]*/;
    static int idx = 0;

    static void add(int u, int v/*, int w*/) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
//        we[idx] = w;
        idx++;
    }

    private static String solve() {
        int left = 0;
        int right = INF + 5;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int ans = left > INF ? -1 : left;
        return String.valueOf(ans);
    }

    static boolean checkMid(int mx) {
        int[] inDeg = new int[n];
        int left = n;
        for (int v = 0; v < n; v++) {
            if (a[v] > mx) {
                left--;
                continue;
            }
//            for (Integer w : g[v]) {
            for (int i = he[v]; i != -1; i = ne[i]) {
                int w = ed[i];

                if (a[w] <= mx) {
                    inDeg[w]++;
                }
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0 && a[i] <= mx) {
                q.add(i);
            }
        }
        long[] f = new long[n];
        long mxF = 0;
        while (!q.isEmpty()) {
            left--;
            int v = q.remove();
            f[v]++;
            mxF = Math.max(mxF, f[v]);
//            for (Integer w : g[v]) {
            for (int i = he[v]; i != -1; i = ne[i]) {
                int w = ed[i];

                if (a[w] > mx) {
                    continue;
                }
                f[w] = f[v];
                if (--inDeg[w] == 0) {
                    q.add(w);
                }
            }
        }
        return left > 0 || mxF >= k;
    }
}
/*
D. Toss a Coin to Your Graph...
https://codeforces.com/contest/1679/problem/D

灵茶の试炼 2023-11-02
题目大意：
输入 n(1≤n≤2e5) m(0≤m≤2e5) k(1≤k≤1e18) 和长为 n 的数组 a(1≤a[i]≤1e9)。
然后输入 m 条边，每条边输入 x y，表示一条从 x 到 y 的有向边。节点编号从 1 开始。
保证图中无自环和重边。
如果图中不存在一条长为 k 的路径（路径有 k 个节点），输出 -1。
否则输出路径上的最大点权的最小值。
注意：你可以重复访问同一个节点。

二分答案 mx。
只考虑点权 <= mx 的点。
如果这些点组成的图是有环的，那么 check 为 true。
否则说明图是个 DAG，拓扑排序计算 DAG 的最长路，如果长度 >= k，那么 check 为 true。
否则 check 为 false。
优化：代码实现时，只需建一次图，不需要每次二分重新建图，这样可以更快一些。
https://codeforces.com/problemset/submission/1679/230820936
======

input
6 7 4
1 10 2 3 4 5
1 2
1 3
3 4
4 5
5 6
6 2
2 5
output
4

input
6 7 100
1 10 2 3 4 5
1 2
1 3
3 4
4 5
5 6
6 2
2 5
output
10

input
2 1 5
1 1
1 2
output
-1

input
1 0 1
1000000000
output
1000000000
 */
