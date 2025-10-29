package c417;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Abc417_e {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int N;
    static ArrayList<Integer>[] g;
    static boolean[] inS;

    private static void solve() {
        N = scanner.nextInt();
        int M = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        g = new ArrayList[N + 1];
        Arrays.setAll(g, e -> new ArrayList<>());

        for (int j = 0; j < M; j++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        inS = new boolean[N + 1];
        int[] nextTry = new int[N + 1];
        List<Integer> path = new ArrayList<>();
        inS[X] = true;
        path.add(X);
        boolean[] reachable = bfs(Y);

        while (path.get(path.size() - 1) != Y) {
            int u = path.get(path.size() - 1);
            List<Integer> neighbors = new ArrayList<>(g[u]);
            Collections.sort(neighbors);
            boolean found = false;
            int startIndex = nextTry[u];

            for (int idx = startIndex; idx < neighbors.size(); idx++) {
                int v = neighbors.get(idx);
                nextTry[u] = idx + 1;
                if (inS[v]) continue;
                if (!reachable[v]) continue;
                inS[v] = true;
                path.add(v);
                nextTry[v] = 0;
                reachable = bfs(Y);
                found = true;
                break;
            }

            if (!found) {
                inS[u] = false;
                path.remove(path.size() - 1);
                if (path.isEmpty()) break;
                reachable = bfs(Y);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int node : path) {
            sb.append(node).append(" ");
        }
        out.println(sb.toString().trim());
    }

    private static boolean[] bfs(int start) {
        boolean[] reachable = new boolean[N + 1];
        if (inS[start]) {
            return reachable;
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        reachable[start] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (!inS[v] && !reachable[v]) {
                    reachable[v] = true;
                    q.add(v);
                }
            }
        }
        return reachable;
    }
}
/*
E - A Path in A Dictionary
https://atcoder.jp/contests/abc417/tasks/abc417_e

题目大意：
给你一个简单相连的无向图 G ，其中有 N 个顶点和 M 条边。
G 的顶点编号为顶点 1,顶点 2,...,顶点 N,i-th (1<= i<= M) 边连接顶点 Ui 和 Vi。
求在 G 中，从顶点 X 到顶点 Y 的 最小的简单路径。
也就是说，在满足以下条件的整数序列 P=(P1,P2,...,P_{|P|}) 中，找出一条在词典上最小的路径：
- 1<= Pi<= N
- 若 i != j , 则 Pi != Pj .
- P1=X 和 P_{|P|}=Y .
- 对于 1<= i<= |P|-1 ，存在一条连接顶点 P_i 和 P_{i+1} 的边。
我们可以证明，在此问题的约束条件下，这样一条路径总是存在的。
给你 T 个测试案例，请找出每个案例的答案。

https://chat.deepseek.com/a/chat/s/7f15edb7-5490-4550-a7bc-7aacfbb4dc06
======

Input 1
2
6 10 3 5
1 2
1 3
1 5
1 6
2 4
2 5
2 6
3 4
3 5
5 6
3 2 3 2
1 3
2 3
Output 1
3 1 2 5
3 2
 */
