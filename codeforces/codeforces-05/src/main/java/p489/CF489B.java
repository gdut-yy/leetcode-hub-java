package p489;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CF489B {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        m = scanner.nextInt();
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);
        Arrays.sort(b);

        int ans = 0;
        int j = 0;
        for (int v : a) {
            while (j < m && b[j] < v - 1) {
                j++;
            }
            if (j < m && b[j] <= v + 1) {
                ans++;
                j++;
            }
        }
        return String.valueOf(ans);
    }

    static int st, end;
    // to, rig, cap
    static List<int[]>[] g;
    static int[] d, iter;

    private static String solve1() {
        st = a.length + b.length;
        end = st + 1;
        g = new ArrayList[end + 1];
        Arrays.setAll(g, e -> new ArrayList<>());

        for (int i = 0; i < n; i++) {
            addEdge(st, i, 1);
            for (int j = 0; j < m; j++) {
                if (Math.abs(a[i] - b[j]) < 2) {
                    addEdge(i, j + n, 1);
                }
            }
        }
        for (int j = 0; j < m; j++) {
            addEdge(j + n, end, 1);
        }

        // 从源点 st 出发的距离
        d = new int[g.length];
        // 寻找增广路
        // 当前弧，在其之前的边已经没有用了，避免对没有用的边进行多次检查
        iter = new int[g.length];
        return String.valueOf(dinic());
    }

    static int dfs(int v, int minF) {
        if (v == end) {
            return minF;
        }
        for (; iter[v] < g[v].size(); iter[v]++) {
            int[] e = g[v].get(iter[v]);
            int w = e[0], rid = e[1], cap = e[2];
            if (cap > 0 && d[w] > d[v]) {
                int f = dfs(w, Math.min(minF, cap));
                if (f > 0) {
                    e[2] -= f;
                    g[w].get(rid)[2] += f;
                    return f;
                }
            }
        }
        return 0;
    }

    static int dinic() {
        int maxFlow = 0;
        while (bfs()) {
            iter = new int[g.length];
            while (true) {
                int f = dfs(st, (int) 1e9);
                if (f > 0) {
                    maxFlow += f;
                } else {
                    break;
                }
            }
        }
        return maxFlow;
    }

    static boolean bfs() {
        d = new int[g.length];
        d[st] = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(st);
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int[] e : g[v]) {
                int w = e[0], cap = e[2];
                if (cap > 0 && d[w] == 0) {
                    d[w] = d[v] + 1;
                    q.add(w);
                }
            }
        }
        return d[end] > 0;
    }

    static void addEdge(int from, int to, int cap) {
        g[from].add(new int[]{to, g[to].size(), cap});
        g[to].add(new int[]{from, g[from].size() - 1, 0});
    }
}
/*
B. BerSU Ball
https://codeforces.com/contest/489/problem/B

灵茶の试炼 2024-01-29
题目大意：
输入 n(1≤n≤100) 和长为 n 的数组 a(1≤a[i]≤100)。
输入 m(1≤m≤100) 和长为 m 的数组 b(1≤b[i]≤100)。
你可以从 a b 中各选一个数字，组成一个数对 (a[i],b[j])，要求 |a[i]-b[j]|<=1。
选过的数字不能再选，最多可以选出多少个数对？
相似题目: 3008. 找出数组中的美丽下标 II
https://leetcode.cn/problems/find-beautiful-indices-in-the-given-array-ii/description/

把 a 和 b 从小到大排序。
考虑 a[0] 和谁组合。
应当选一个 >=a[0]-1 的最小的 b[j]，这样后面能组成数对的可能性就更大。
当然，如果这个 b[j]>a[0]+1 则 a[0] 无法参与组成数对。
然后考虑 a[1] 和谁组合，依此类推。
按照这个规则，双指针匹配。
https://codeforces.com/problemset/submission/489/243841230
网络流写法 https://codeforces.com/contest/489/submission/243843771
======

input
4
1 4 6 2
5
5 1 5 7 9
output
3

input
4
1 2 3 4
4
10 11 12 13
output
0

input
5
1 1 1 1 1
3
1 2 3
output
2
 */
