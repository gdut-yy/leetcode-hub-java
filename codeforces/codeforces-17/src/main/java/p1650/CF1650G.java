package p1650;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CF1650G {
    static int n, m, s, t;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            s = scanner.nextInt() - 1;
            t = scanner.nextInt() - 1;
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
    }

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        // 偶数下标表示最短路，奇数下标表示次短路
        long[] f = new long[n * 2];
        long[] dis = new long[n * 2];
        Arrays.fill(dis, -1);
        dis[s * 2] = 0;
        f[s * 2] = 1;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s * 2);
        while (!q.isEmpty()) {
            int v = q.remove();
            long newD = dis[v] + 1;

            for (Integer w : g[v / 2]) {
                w *= 2;
                if (dis[w] < 0) {
                    dis[w] = newD;
                    f[w] = f[v];
                    q.add(w);
                } else if (newD == dis[w]) {
                    f[w] = (f[w] + f[v]) % MOD;
                } else if (newD == dis[w] + 1) { // 次短路
                    w++;
                    if (dis[w] < 0) {
                        dis[w] = newD;
                        q.add(w);
                    }
                    f[w] = (f[w] + f[v]) % MOD;
                }
            }
        }
        long ans = (f[t * 2] + f[t * 2 + 1]) % MOD;
        return String.valueOf(ans);
    }
}
/*
G. Counting Shortcuts
https://codeforces.com/contest/1650/problem/G

灵茶の试炼 2024-08-29
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) m(1≤m≤2e5)，表示一个 n 点 m 边的无向图。
然后输入 s 和 t (s≠t)，表示起点和终点。节点编号从 1 开始。
然后输入 m 条边，每条边输入 x y，表示有一条无向边连接 x 和 y。
保证图是连通的。保证图中无自环和重边。
设从 s 到 t 的最短路长度为 d。
输出从 s 到 t 的路径个数，要求路径的长度至多为 d+1。
答案模 1e9+7。
样例太长，请在原题查看。
进阶：改成路径的长度至多为 d+50。
P3953 [NOIP2017 提高组] 逛公园

rating 2100
前置题目：P1144 最短路计数
P1144 的核心思想是：
1. 对于边 v-w，首次访问节点 w 时，「起点到 w 的方案数」等于「起点到 v 的方案数」。
2. 重复访问节点 w 时，如果发现到从起点到 v 再到 w 的长度，与之前求出的最短路是一样的，那么把「起点到 v 的方案数」加到「起点到 w 的方案数」中。
对于次短路也一样，当我们重复访问一个节点时，如果发现到这个节点的次短路是一样的，那么方案数要累加。
本题相当于计算 s 到 t 的最短路个数和次短路个数。
关于次短路，我们可以额外用一个数组 dis2[i] 记录起点到点 i 的次短路。
如果发现「起点到 w 的路径长度」刚好比已记录的「起点到 w 的最短路长度」多 1，说明我们找到了起点到 w 的次短路。
首次更新次短路时，也把点 i 入队。
队列中包含更新最短路时入队的节点，和更新次短路时入队的节点。
一个节点至多入队两次。
代码 https://codeforces.com/contest/1650/submission/277853154
======

Input
4

4 4
1 4
1 2
3 4
2 3
2 4

6 8
6 1
1 4
1 6
1 5
1 2
5 6
4 6
6 3
2 6

5 6
1 3
3 5
5 4
3 1
4 2
2 1
1 4

8 18
5 1
2 1
3 1
4 2
5 2
6 5
7 3
8 4
6 4
8 7
1 4
4 7
1 6
6 7
3 8
8 5
4 5
4 3
8 2
Output
2
4
1
11
 */
