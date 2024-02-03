package lq231111;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LQ231111T8 {
    static int n, a, b;
    static List<int[]>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();

        g = new ArrayList[MAX_N * 2];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            int f = 0;
            int t = x;
            for (int j = 0; j < primes.size() && t > 1; j++) {
                while (t % primes.get(j) == 0) {
                    f += primes.get(j);
                    t /= primes.get(j);
                }
            }
            if (t > 1) f += t;
            f = (f % n) + 1;

            g[i].add(new int[]{f, 1});
            g[f].add(new int[]{i, 1});
            g[i].add(new int[]{n + f + 1, 1});
            g[n + f + 1].add(new int[]{i, 0});
        }
        System.out.println(solve());
    }

    static final int MAX_N = (int) (2e5 + 5);

    static final int INF = (int) 1e9;
    static List<Integer> primes;

    static {
        final int N = (int) (1e4 + 5);
        primes = new ArrayList<>();
        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && (long) i * primes.get(j) < N; j++) {
                isPrime[i * primes.get(j)] = false;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
    }

    private static String solve() {
        int[] dist = dijkstra_mlogm(a);
        int ans = dist[b] == INF ? -1 : dist[b];
        return String.valueOf(ans);
    }

    static int[] dijkstra_mlogm(int node) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] vis = new boolean[MAX_N * 2];
        int[] dist = new int[MAX_N];
        Arrays.fill(dist, INF);
        heap.add(new int[]{node, 0});
        dist[node] = 0;
        while (!heap.isEmpty()) {
            int[] top = heap.remove();
            int x = top[0];
            if (vis[x]) continue;
            vis[x] = true;
            for (int[] p : g[x]) {
                int y = p[0], wt = p[1];
                if (dist[y] > dist[x] + wt) {
                    dist[y] = dist[x] + wt;
                    heap.add(new int[]{y, dist[y]});
                }
            }
        }
        return dist;
    }
}
/*
星石传送阵【算法赛】

我们可以对所有的点进行建图，然后跑 dijkstra 或 bfs，我们用前向星的方式建图，对于 a[i]=x，我们连接 i 到 f(x) 建立一条权重为 1 的无向边。
对于 f(a[i]) =f(a[j]) 我们可以建一条边到一个虚拟点，该虚拟点可以设为 n+f(a[i])+1, g(i,f(a[i])+n+1)=1, g(f(a[i])+n+1,i)=0 这样我们可以在 O(n) 的复杂度内完成建图
最终一个点可以向外延伸 2 条边，总计 2n 条边
采用 dijkstra 的时间复杂度为 O(2n * log(2n))
 */