import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class P3376 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        t = scanner.nextInt();
        tot = 1;
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int c = scanner.nextInt();
            add(x, y, c);
        }
        q = new ArrayDeque<>();
        long flow = 0;
        while (bfs()) {
            while ((flow = dinic(s, inf)) != 0) maxflow += flow;
        }
        System.out.println(maxflow);
    }


    static int inf = 1 << 29, N = 50010, M = 300010;
    static int[] head = new int[N], ver = new int[M], edge = new int[M], Next = new int[M], d = new int[N];
    static int n, m, s, t, tot;
    static long maxflow;
    static Queue<Integer> q;

    static void add(int x, int y, int z) {
        ver[++tot] = y;
        edge[tot] = z;
        Next[tot] = head[x];
        head[x] = tot;

        ver[++tot] = x;
        edge[tot] = 0;
        Next[tot] = head[y];
        head[y] = tot;
    }

    static boolean bfs() { // 在残量网络上构造分层图
        Arrays.fill(d, 0);
        while (!q.isEmpty()) q.remove();
        q.add(s);
        d[s] = 1;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int i = head[x]; i != 0; i = Next[i]) {
                if (edge[i] != 0 && d[ver[i]] == 0) {
                    q.add(ver[i]);
                    d[ver[i]] = d[x] + 1;
                    if (ver[i] == t) return true;
                }
            }
        }
        return false;
    }

    static int dinic(int x, int flow) { // 在当前分层图上增广
        if (x == t) return flow;
        int rest = flow, k;
        for (int i = head[x]; i != 0 && rest != 0; i = Next[i]) {
            if (edge[i] != 0 && d[ver[i]] == d[x] + 1) {
                k = dinic(ver[i], Math.min(rest, edge[i]));
                if (k == 0) d[ver[i]] = 0; // 剪枝，去掉增广完毕的点
                edge[i] -= k;
                edge[i ^ 1] += k;
                rest -= k;
            }
        }
        return flow - rest;
    }
}