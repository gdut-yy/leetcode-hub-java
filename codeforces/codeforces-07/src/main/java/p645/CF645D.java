package p645;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class CF645D {
    static int n, m;
    static List<edge>[] g;
    static int[] deg;

    record edge(int to, int i) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        deg = new int[n];
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(new edge(w, i));
            deg[w]++;
        }
        System.out.println(solve1());
    }

    // 方法一
    private static String solve() {
        int[] _deg = new int[n];
        int l = n - 1, r = m + 1;
        long ans = l + sortSearch(r - l, m -> {
            m += l;
            Arrays.fill(_deg, 0);
            for (List<edge> es : g) {
                for (edge e : es) {
                    if (e.i < m) {
                        _deg[e.to]++;
                    }
                }
            }
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < _deg.length; i++) {
                if (_deg[i] == 0) {
                    q.add(i);
                }
            }
            while (!q.isEmpty()) {
                if (q.size() > 1) {
                    return false;
                }
                int v = q.remove();
                for (edge e : g[v]) {
                    if (e.i >= m) {
                        continue;
                    }
                    int w = e.to;
                    _deg[w]--;
                    if (_deg[w] == 0) {
                        q.add(w);
                    }
                }
            }
            return true;
        });
        if (ans > m) {
            ans = -1;
        }
        return String.valueOf(ans);
    }

    static long sortSearch(long n, Function<Long, Boolean> f) {
        long l = 0, r = n;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // 方法二
    private static String solve1() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < deg.length; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1) return "-1";
            int v = q.remove();
            for (edge e : g[v]) {
                int w = e.to;
                deg[w]--;
                if (deg[w] == 0) {
                    ans = Math.max(ans, e.i);
                    q.add(w);
                }
            }
        }
        return String.valueOf(ans + 1);
    }
}
/*
D. Robot Rapping Results Report
https://codeforces.com/contest/645/problem/D

灵茶の试炼 2025-05-15
题目大意：
输入 n(2≤n≤1e5) m(1≤m≤1e5)，表示一个 n 点 m 边的有向无环图（DAG）。保证图中无自环和重边。
然后输入 m 条边，每条边输入 x y，表示一条 x 到 y 的有向边。节点编号从 1 开始。
输出最小的 k，满足：
只考虑输入的前 k 条边，所形成的（包含 n 个点的）图的拓扑序是唯一的。
如果不存在这样的 k，输出 -1。
你能做到 O(n) 吗？

rating 1800
方法一：二分答案
二分答案，问题变成判断一个图的拓扑序是否唯一。
判断方法：任意时刻队列中不能有超过一个元素。（因为出队的时候队列中的任意节点都可以出队，拓扑序不唯一）
小技巧：把边的编号加到图中，避免反复建图。
方法一代码 https://codeforces.com/problemset/submission/645/319485808
方法二：O(n) 做法
拓扑序唯一等价于存在一条有 n 个点的路径。
不在这条路径上的边可以去掉。怎么判断？
拓扑排序的过程中，一个节点的入度从 1 减成 0，那么入队，这个时候对应的边就是在路径上的边。
这个节点的入度减成 1 之前的所有边都是多余的。
比如 1->2，2->3，1->3 这三条边构成的图，1->3 就是多余的。
路径上的边的编号的最大值就是答案。
判断 -1 的方式同方法一。
方法二代码 https://codeforces.com/problemset/submission/645/319487993
代码备份（洛谷）二合一
======

Input
4 5
2 1
1 3
2 3
4 2
4 3
Output
4

Input
3 2
1 2
3 2
Output
-1
 */
