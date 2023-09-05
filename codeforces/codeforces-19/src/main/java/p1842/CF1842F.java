package p1842;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1842F {
    static int n;
//    static Map<Integer, List<Integer>> g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
//        g = new HashMap<>();
//        for (int i = 0; i < n - 1; i++) {
//            int u = scanner.nextInt() - 1;
//            int v = scanner.nextInt() - 1;
//            g.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
//            g.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
//        }
        Arrays.fill(he, -1);
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            add(u, v);
            add(v, u);
        }
        System.out.println(solve());
    }

    // 链式前向星
    static int N = 5005, M = N * 2;
    static int[] he = new int[N], ne = new int[M], ed = new int[M]/*, we = new int[M]*/;
    static int idx = 0;

    static void add(int u, int v/*, int w*/) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
//        we[idx] = w;
        idx++;
    }

    static int[] cnt, ans;

    // https://codeforces.com/problemset/submission/1842/210914105
    private static String solve() {
        cnt = new int[n + 1];
        ans = new int[n + 1];

        for (int r = 0; r < n; r++) {
            for (int d = 0; d <= n; d++) {
                cnt[d] = 0;
            }
            dfs(r, -1, 0);
            int k = 0;
            int sum = 0;
            for (int d = 0; d <= n; d++) {
                for (int i = 0; i < cnt[d]; i++) {
                    k++;
                    sum -= 2 * d;
                    ans[k] = Math.max(ans[k], k * (n - 1) + sum);
                }
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static void dfs(int x, int fa, int d) {
        cnt[d]++;
//        for (Integer y : g.getOrDefault(x, new ArrayList<>())) {
        for (int i = he[x]; i != -1; i = ne[i]) {
            int y = ed[i];
            if (y != fa) {
                dfs(y, x, d + 1);
            }
        }
    }
}
/*
F. Tenzing and Tree
https://codeforces.com/contest/1842/problem/F

题目大意：
Tenzing 有一个 n 个顶点的无向树。
用下面的方法定义带有黑色和白色顶点的树的值。边的值是删除该边后，树的两个组成部分的黑节点数之差的绝对值。树的值是所有边的值之和。
对于所有满足 0≤k≤n 的 k, Tenzing 想知道当 k 个顶点涂成黑色，n - k 个顶点涂成白色时树的最大值。

rating 2500
======

input
4
1 2
3 2
2 4
output
0 3 4 5 6

input
1
output
0 0
 */
