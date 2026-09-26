import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class tusimple005 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static class Edge {
        int to;
        long w;

        Edge(int to, long w) {
            this.to = to;
            this.w = w;
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Map<String, Integer> id = new HashMap<>();
        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String x = scanner.next();
            String y = scanner.next();
            long t = scanner.nextLong();

            Integer u = id.get(x);
            if (u == null) {
                u = cnt++;
                id.put(x, u);
            }

            Integer v = id.get(y);
            if (v == null) {
                v = cnt++;
                id.put(y, v);
            }

            graph[u].add(new Edge(v, t));
        }

        int q = scanner.nextInt();
        while (q-- > 0) {
            String a = scanner.next();
            String b = scanner.next();

            Integer startObj = id.get(a);
            Integer targetObj = id.get(b);

            if (startObj == null || targetObj == null) {
                out.println("INF");
                continue;
            }

            long ans = dijkstra(graph, startObj, targetObj, n);
            if (ans == Long.MAX_VALUE) {
                out.println("INF");
            } else {
                out.println(ans);
            }
        }
    }

    private static long dijkstra(List<Edge>[] graph, int start, int target, int n) {
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        dist[start] = 0;
        pq.offer(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long d = cur[1];

            if (d != dist[u]) continue;
            if (u == target) return d;

            for (Edge e : graph[u]) {
                long nd = d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.offer(new long[]{e.to, nd});
                }
            }
        }

        return Long.MAX_VALUE;
    }
}
/*
tusimple-005. 服务器
https://leetcode.cn/problems/ca70CL/description/

公司来了一批新的分布式服务器，TuTu 要负责启动他们。
公司的服务器都有一个唯一的不会和其他服务器重复的名字，现在一共有 n 台服务器，这些服务器之间有 m 条数据线连接起来。
如果服务器 x 和 y 之间有一条数据线连接，那么在服务器 x 启动的 t 毫秒后，服务器 y 会自动启动（注意启动是有方向的）。当然如果同时服务器 x 和其他服务器也有数据线连接，而那个服务器在关闭状态，则它也会在相应的时间后自动启动。
现在 TuTu 很好奇，如果他启动了一个服务器 a 那么服务器 b 在多长时间以后会被启动。当然了，好奇的人总是会有很多好奇的点，所以 TuTu 会询问好多个这样的问题。需要注意的是，每一次询问都是独立的。
输入描述:
第一行包含整数 n 和 m (2 <= n <= 1000,1 <= m <= 1000)，分别为服务器数量和数据线数量。
接下来的 m 行中，每行包含两个不同的字符串 x[i] 和 y[i] 以及整数 t[i] (1 <= t[i] <= 10^9) ，它们描述一个数据线的连接情况。字符串最多包含 20 个小写字母，表示服务器的名称。保证所有服务器的名称都会至少出现一次。某些服务器对之间可能存在多个数据线连接。
接下来的一行包含整数 q (1 <= q <= 1000)，表示询问个数。
接下来的 q 行，每行包含两个不同的字符串 a[i] 和 b[i] ，表示 TuTu 询问启动服务器 a[i] 服务器 b[i] 在多长时间以后会被启动。
输出描述:
输出包含 q 行。每一行独立输出每一次询问所需要花费的时间（以毫秒为单位），如果被询问的服务器 b[i] 永远不能被启动，则输出 INF 。
样例1
输入
3 2
novak goat 1
goat simulator 3
2
novak simulator
simulator goat
输出
4
INF
说明 对于第一个询问，TuTu 启动服务器 novak ，1 毫秒后，服务器 goat 启动，再经过 3 毫秒后所询问的服务器 simulator 启动。
备注:
对于其中 40% 的数据，保证 1 <= n <= 10； 对于其中另外 30% 的数据，保证 1 <= n <= 100 。
 */