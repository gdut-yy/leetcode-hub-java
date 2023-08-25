package c222;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc222_f {
    static int n;
    static Map<Integer, List<int[]>> adj;
    static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        adj = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            int wt = scanner.nextInt();
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(new int[]{w, wt});
            adj.computeIfAbsent(w, key -> new ArrayList<>()).add(new int[]{v, wt});
        }
        d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    // fi, i, se
//    static long[][] res;
    static Result[] res;
    static long[] ans;

    private static String solve() {
//        res = new long[n][3];
        res = new Result[n];
        dfs(0, -1);

        ans = new long[n];
        reroot(0, -1, 0);

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static void dfs(int v, int fa) {
//        long[] cur = new long[3];
        Result cur = new Result();
        for (int[] e : adj.getOrDefault(v, new ArrayList<>())) {
            int w = e[0], wt = e[1];
            if (w == fa) continue;
            dfs(w, v);
            long r = Math.max(res[w].fi, d[w]) + wt;
            if (r > cur.fi) {
                cur = new Result(r, w, cur.fi);
            } else if (r > cur.se) {
                cur.se = r;
            }
        }
        res[v] = cur;
    }

    private static void reroot(int v, int fa, long up) {
//        ans[v] = Math.max(res[v][0], up);
        ans[v] = Math.max(res[v].fi, up);
        up = Math.max(up, d[v]);
        for (int[] e : adj.getOrDefault(v, new ArrayList<>())) {
            int w = e[0], wt = e[1];
            if (w == fa) continue;
            long down = res[v].fi;
            if (w == res[v].i) {
                down = res[v].se;
            }
            reroot(w, v, Math.max(up, down) + wt);
        }
    }

    static class Result {
        long fi, se;
        int i;

        public Result() {
        }

        public Result(long fi, int i, long se) {
            this.fi = fi;
            this.i = i;
            this.se = se;
        }
    }
}
/*
F - Expensive Expense
https://atcoder.jp/contests/abc222/tasks/abc222_f

灵茶の试炼 2023-01-18
题目大意：
输入 n(2≤n≤2e5) 和一棵树的 n-1 条边（节点编号从 1 开始），每条边输入两个端点和边权。
然后输入 n 个数 d，d[i] 表示点 i 的点权。
定义 f(x,y) = 从 x 到 y 的简单路径的边权之和，再加上 d[y]。
定义 g(x) = max{f(x,i)}，这里 i 取遍 1~n 的所有不为 x 的点。
输出 g(1),g(2),...,g(n)。

https://atcoder.jp/contests/abc222/submissions/38126974
换根 DP。
我的思路是从 1 开始 dfs，记录从每棵子树的根往下走能得到的最大值 fi 和次大值 se，以及哪个子树可以得到最大值。
然后换根，从 v 到 w，把根从 v 换成 w：如果 w 是 v 的最大值对应的子树，那么对于 w 来说，它往上走能得到的最大值可以是 v 的 se，否则往上走能得到的最大值可以是 v 的 fi。
由于 g(x,y) 和 d[y] 有关，所以对于 w 来说，往上走的最大值还需要与 d[v]+(v-w的边权) 求最大值。具体见代码。
不了解换根 DP 可以先做做 834. 树中距离之和
https://leetcode.cn/problems/sum-of-distances-in-tree/

======

Input 1
3
1 2 2
2 3 3
1 2 3
Output 1
8
6
6

Input 2
6
1 2 3
1 3 1
1 4 4
1 5 1
1 6 5
9 2 6 5 3 100
Output 2
105
108
106
109
106
14

Input 3
6
1 2 1000000000
2 3 1000000000
3 4 1000000000
4 5 1000000000
5 6 1000000000
1 2 3 4 5 6
Output 3
5000000006
4000000006
3000000006
3000000001
4000000001
5000000001
 */