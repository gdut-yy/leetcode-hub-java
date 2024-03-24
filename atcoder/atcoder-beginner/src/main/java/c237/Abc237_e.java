package c237;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Abc237_e {
    static int n, m;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(solve());
    }

    static final long INF = (long) 1e18;

    private static String solve() {
        long[] dis = new long[n];
        Arrays.fill(dis, INF);
        dis[0] = 0;

        PriorityQueue<Pair> h = new PriorityQueue<>(Comparator.comparingLong(o -> o.d));
        h.add(new Pair(0, 0));
        while (!h.isEmpty()) {
            Pair p = h.remove();
            int v = p.v;
            if (dis[v] < p.d) {
                continue;
            }
            for (Integer w : g[v]) {
                long d = dis[v] + Math.max(a[w] - a[v], 0);
                if (dis[w] > d) {
                    dis[w] = d;
                    h.add(new Pair(w, d));
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, a[0] - a[i] - dis[i]);
        }
        return String.valueOf(ans);
    }

    static class Pair {
        int v;
        long d;

        public Pair(int v, long d) {
            this.v = v;
            this.d = d;
        }
    }
}
/*
E - Skiing
https://atcoder.jp/contests/abc237/tasks/abc237_e

灵茶の试炼 2022-04-28
题目大意：
给你一个无向连通图，点 <=2e5，边 <= 2e5（无重边无自环），每个点有一个高度 h[i] (0<=h[i]<=1e8)，对于每条边 v-w，从 v 到 w 对快乐度的影响如下：
h[v] > h[w]：增加 h[v]-h[w]
h[v] < h[w]：减少 2*(h[w]-h[v])
h[v] = h[w]：不变
求从点 1 出发，能获得的快乐度最大是多少。

如果把减少的倍率从 2 改成 1 的话，那么上上下下都可以合并，找个高度最低的点 x，答案就是 h[1]-h[x]。
由于减少的倍率是 2，可以转换成只要高度增加，会额外产生 h[w]-h[v] 的开销，那么我们就需要求从 1 到 v 的最短路 dis[v]，来计算到每个点的最小额外开销。
答案为 max(h[1]-h[i]-dis[i])
https://atcoder.jp/contests/abc237/submissions/28975067
======

Input 1
4 4
10 8 12 5
1 2
1 3
2 3
3 4
Output 1
3

Input 2
2 1
0 10
1 2
Output 2
0
 */