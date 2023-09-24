package c259;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc259_f {
    static int n;
    static int[] a;
//    static Map<Integer, List<int[]>> adj;

    static int N = (int) (3e5 + 5), M = N * 2;
    // 链式前向星
    static int[] he = new int[N], ne = new int[M], ed = new int[M], we = new int[M];
    static int idx = 0;

    static void add(int u, int v, int w) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
        we[idx] = w;
        idx++;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
//        adj = new HashMap<>();
//        for (int i = 0; i < n - 1; i++) {
//            int v = scanner.nextInt() - 1;
//            int w = scanner.nextInt() - 1;
//            int wt = scanner.nextInt();
//            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(new int[]{w, wt});
//            adj.computeIfAbsent(w, key -> new ArrayList<>()).add(new int[]{v, wt});
//        }
        Arrays.fill(he, -1);
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            int wt = scanner.nextInt();
            add(v, w, wt);
            add(w, v, wt);
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] res = dfs(0, -1);
        return String.valueOf(res[0]);
    }

    private static long[] dfs(int v, int fa) {
        long sumF = 0;
        List<Long> diff = new ArrayList<>();
        diff.add(0L);
//        for (int[] e : adj.getOrDefault(v, new ArrayList<>())) {
        for (int i = he[v]; i != -1; i = ne[i]) {
//            int w = e[0], wt = e[1];
            int w = ed[i], wt = we[i];

            if (w != fa) {
                long[] res = dfs(w, v);
                long full = res[0], notFull = res[1];
                sumF += full;
                diff.add(Math.max(wt + notFull - full, 0));
            }
        }
        diff.sort(Comparator.reverseOrder());
        int d = a[v];
        if (d == 0) {
            return new long[]{sumF, (long) -1e18};
        }
        long extra = 0;
        for (int i = 0; i < d - 1; i++) {
            extra += diff.get(i);
        }
        return new long[]{sumF + extra + diff.get(d - 1), sumF + extra};
    }
}
/*
F - Select Edges
https://atcoder.jp/contests/abc259/tasks/abc259_f

灵茶の试炼 2022-12-30
题目大意：
输入 n(≤3e5)，长为 n 的数组 d，和一颗带权树的 n-1 条边，边权 [-1e9,1e9]。
d[i] 不会超过点 i 的度数。
移除一些边，使得点 i 的度数不超过 d[i]。
输出剩余边的边权之和的最大值。

https://atcoder.jp/contests/abc259/submissions/37624720
写一个树形 DP。
类似打家劫舍 III，子树返回两个数：子树连了至多 d 条边，子树连了至多 d-1 条边（预留一条边给父节点）。
这两个数分别记作 full 和 notFull。
把 full 累加起来，这是一条边都不连的情况。
然后思考：在这个基础上，与哪些子树连边的收益最大？
把边权记作 weight，优先选择 weight + notFull - full 更大的子树，与之连边，这样收益最大。注意这个数有可能是负数，这种情况是不能连边的。
注意 d=0 的情况。
相似题目: 337. 打家劫舍 III
https://leetcode.cn/problems/house-robber-iii/
======

Input 1
7
1 2 1 0 2 1 1
1 2 8
2 3 9
2 4 10
2 5 -3
5 6 8
5 7 3
Output 1
28

Input 2
20
0 2 0 1 2 1 0 0 3 0 1 1 1 1 0 0 3 0 1 2
4 9 583
4 6 -431
5 9 325
17 6 131
17 2 -520
2 16 696
5 7 662
17 15 845
7 8 307
13 7 849
9 19 242
20 6 909
7 11 -775
17 18 557
14 20 95
18 10 646
4 3 -168
1 3 -917
11 12 30
Output 2
2184
 */