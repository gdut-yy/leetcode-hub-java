package lq231024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LQ231024T7 {
    static final int N = 100005;
    static ArrayList<Integer>[] G = new ArrayList[N];
    static ArrayList<Integer>[] val = new ArrayList[N];
    static ArrayList<Integer>[] dfsQ = new ArrayList[N];
    static int[] w = new int[N];
    static int n, q;
    static int DFN = 0;
    static int[] dfn = new int[N];
    static int[] dep = new int[N];
    static int[] Siv = new int[N];
    static int MaxDpt = 0;
    static RMQ[] res = new RMQ[N];

    public static void dfs(int u, int fa, int dpt) {
        MaxDpt = Math.max(MaxDpt, dpt);
        dfn[u] = ++DFN;
        dep[u] = dpt;
        Siv[u] = 1;
        val[dpt].add(w[u]);
        dfsQ[dpt].add(dfn[u]);
        for (int v : G[u]) {
            if (v == fa) continue;
            dfs(v, u, dpt + 1);
            Siv[u] += Siv[v];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
            val[i] = new ArrayList<>();
            dfsQ[i] = new ArrayList<>();
        }
        int u, v, x, k;
        for (int i = 1; i < n; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            G[u].add(v);
            G[v].add(u);
        }
        dfs(1, 0, 1);
        for (int i = 1; i <= MaxDpt; i++) {
            res[i] = new RMQ(val[i]);
        }
        while (q-- > 0) {
            x = sc.nextInt();
            k = sc.nextInt();
            int l = Collections.binarySearch(dfsQ[k + dep[x]], dfn[x]);
            int r = Collections.binarySearch(dfsQ[k + dep[x]], dfn[x] + Siv[x]);
            if (l < 0) l = (-l) - 1;
            if (r < 0) r = (-r) - 1;
            System.out.println(res[k + dep[x]].query(Math.abs(l), Math.abs(r)));
        }
        sc.close();
    }

    static class RMQ {
        private int[][] f;
        private final int N, LOGN;

        public RMQ(ArrayList<Integer> init) {
            N = init.size();
            LOGN = (int) (Math.log(N) / Math.log(2)) + 1;
            f = new int[LOGN][N];
            for (int i = 0; i < N; i++) {
                f[0][i] = init.get(i);
            }
            for (int i = 1; i < LOGN; i++) {
                for (int j = 0; j + (1 << i) - 1 < N; j++) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j + (1 << (i - 1))]);
                }
            }
        }

        public int query(int l, int r) {
            int k = (int) (Math.log(r - l) / Math.log(2));
            return Math.max(f[k][l], f[k][r - (1 << k)]);
        }
    }
}
/*
小蓝的疑问【算法赛】

考察数据结构（堆、线段树），图（DFS 序），二分查找
1、离线做法，启发式合并 + 优先队列，同时对于每层的节点都维护一个大根堆，每次询问，查询堆中最大值。时间复杂度：`O(nloglogn)`。
2、在线做法，DFS 序 + 线段树（ST 表） + 二分查找，对每层按照 DFS 序相对顺序建立线段树（或者 ST 表），当查询到 u 时，通过二分找到 k 层的左右端点，查询最大值。时间复杂度：`O(nlogn)`。
 */