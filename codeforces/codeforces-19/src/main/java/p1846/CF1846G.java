package p1846;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1846G {
    static int n, m;
    static int mask;
    static int[] m_d, m_mask1, m_mask2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            mask = Integer.parseInt(scanner.next(), 2);

            m_d = new int[m];
            m_mask1 = new int[m];
            m_mask2 = new int[m];
            for (int i = 0; i < m; i++) {
                m_d[i] = scanner.nextInt();
                m_mask1[i] = Integer.parseInt(scanner.next(), 2);
                m_mask2[i] = Integer.parseInt(scanner.next(), 2);
            }
            System.out.println(solve());
        }
    }

    private static final int INF = (int) 1e9;
    static int N;
    static int[][] adj;

    private static String solve() {
        N = 1 << n;
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                adj[i][j] = i == j ? 0 : INF;
            }
        }
        for (int mask = 0; mask < N; mask++) {
            for (int j = 0; j < m; j++) {
                int nextMask = mask & ~m_mask1[j] | m_mask2[j];
                adj[mask][nextMask] = Math.min(adj[mask][nextMask], m_d[j]);
            }
        }

        int[] dist = dijkstra_n2(mask);
        int ans = dist[0] == INF ? -1 : dist[0];
        return String.valueOf(ans);
    }

    // 暴力 O(n^2)
    private static int[] dijkstra_n2(int source) {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[source] = 0;
        boolean[] vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            int x = 0, mind = INF;
            for (int j = 0; j < N; j++) {
                if (!vis[j] && dist[j] < mind) {
                    x = j;
                    mind = dist[x];
                }
            }
            vis[x] = true;
            for (int y = 0; y < N; y++) {
                if (x != y && adj[x][y] != INF) {
                    if (dist[y] > dist[x] + adj[x][y]) {
                        dist[y] = dist[x] + adj[x][y];
                    }
                }
            }
        }
        return dist;
    }
}
/*
G. Rudolf and CodeVid-23
https://codeforces.com/contest/1846/problem/G

题目大意：
一种名为“CodeVid-23”的新病毒在程序员中传播开来。作为一名程序员，鲁道夫无法避免这种情况。
感染后会出现从 1 到 n 的 n 种症状。最初，鲁道夫有一些。他去药房给我买了药。
对于每种药物，需要服用的天数是已知的，以及它所消除的一系列症状。不幸的是，药物往往有副作用。因此，对于每种药物，服用时出现的一系列症状也是已知的。
看了说明书后，鲁道夫意识到一次服用一种以上的药是非常不健康的。
鲁道夫希望能尽快痊愈。因此，他要求您计算消除所有症状的最小天数，或者说这是不可能的。
---
第一行包含一个整数 t(1≤t≤100)——测试用例的数量。
然后遵循测试用例的描述。
每个测试用例的第一行包含两个整数 n,m(1≤n≤10,1≤m≤10^3)，分别是症状数和药物数。
每个测试用例的第二行包含一个长度为 n 的字符串，由字符 0 和 1 组成——鲁道夫症状的描述。如果字符串的第 i 个字符是 1，鲁道夫有第 i 个症状，否则他没有。
然后按照 3m 行药物的描述。
每种药物描述的第一行包含一个整数 d(1≤d≤10^3)-药物需要服用的天数。
药品说明的下两行包含两个长度为 n 的字符串，由字符 0 和 1 组成-描述其消除的症状和描述副作用。
在第一行中，第 i 位的 1 表示药物消除了第 i 个症状，否则为 0。
在第二行中，第 i 位的 1 表示服药后出现第 i 个症状，否则为 0。
不同的药物可能会有相同的症状和副作用。如果一种药能缓解某种症状，那么它就不属于副作用。
所有测试用例 m 的总和不超过 10^3。
---
在第一个例子中，我们可以首先使用 4 号药物，之后症状看起来像“00101”。之后，服用第二种药，那么所有症状都会消失，天数为 5+3=8。另一种选择是按 1、3、2 的顺序施用药物。在这种情况下，所有症状也会消失，但天数将是 3+3+3=9。
在第二个例子中，最初没有任何症状，因此治疗将需要 0 天。
在第三个示例中，没有删除所有症状的选项。

https://codeforces.com/blog/entry/118044
让我们将鲁道夫的状态表示为长度为 n 的二进制掩码，由 0 和 1 组成，类似于输入数据中给出的方式。然后每一种药都能把鲁道夫从一种状态变成另一种状态。
让我们构造一个加权有向图，其中的顶点将表示鲁道夫的所有可能状态。有 2^n 个这样的顶点。如果存在一种药物，可以将鲁道夫从第一个顶点对应的状态转变为第二个顶点对应的状态，那么两个顶点将被一条边连接起来。边缘的重量将等于该药需要服用的天数。注意，在这种情况下，我们只需要在这个图中找到最短路径从顶点 s，对应于鲁道夫的初始状态，到顶点 f，对应于无症状状态。
为了在加权图中找到最短路径，我们将使用 Dijkstra 算法。我们将从顶点 s 开始运行，如果结果是到达顶点 f，输出到它的距离，否则为 -1。
时间复杂度为 O(n·m·2^n)。
======

input
4
5 4
10011
3
10000
00110
3
00101
00000
3
01010
00100
5
11010
00100
4 1
0000
10
1011
0100
2 2
11
2
10
01
3
01
10
2 3
11
3
01
10
3
10
00
4
10
01
output
8
0
-1
6
 */
