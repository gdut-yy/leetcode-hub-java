package p1825;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1825E {
    static int n;
    static int[] a;
    static int[][] uv;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        uv = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            uv[i][0] = scanner.nextInt();
            uv[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static Map<Integer, List<Integer>> adj;
    static List<Map<Integer, Integer>> f;
    static int ans;

    // https://codeforces.com/contest/1824/submission/205112032
    private static String solve() {
        adj = new HashMap<>();
        for (int[] p : uv) {
            int x = p[0], y = p[1];
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
        }
        f = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            f.add(new HashMap<>());
        }
        ans = 0;

        dfs(1, 0);
        return String.valueOf(ans);
    }

    static void dfs(int x, int fa) {
        int mx = 1, c = 0;
        for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y != fa) {
                a[y] ^= a[x];
                dfs(y, x);
                c++;
                if (f.get(x).size() < f.get(y).size()) Collections.swap(f, x, y);
                for (Map.Entry<Integer, Integer> entry : f.get(y).entrySet()) {
                    // mx=max(mx,f[x][o.first]+=o.second
//                    Map<Integer, Integer> fx = f.get(x);
//                    fx.put(entry.getKey(), fx.getOrDefault(entry.getKey(), 0) + entry.getValue());
//                    mx = Math.max(mx, fx.get(entry.getKey()));
                    mx = Math.max(mx, f.get(x).merge(entry.getKey(), entry.getValue(), Integer::sum));
                }
            }
        }
        if (c == 0) f.get(x).put(a[x], 1);
        else ans += c - mx;

        if (mx != 1) {
            for (Iterator<Map.Entry<Integer, Integer>> it = f.get(x).entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<Integer, Integer> item = it.next();
                if (item.getValue() != mx) it.remove();
                else item.setValue(1);
            }
        }
        if (x == 1) {
            ans += !f.get(x).containsKey(0) ? 1 : 0;
        }
    }
}
/*
E. LuoTianyi and XOR-Tree
https://codeforces.com/contest/1825/problem/E

题目大意：
LuoTianyi 给出了一个顶点都有值的树，树的根是顶点 1。
在一次操作中，您可以将一个顶点的值更改为任何非负整数。
现在，您需要找到使从根节点到叶节点†的每个路径的异或值为零所需执行的最小操作数。
有根树中的叶子是一个只有一个邻居且不是根的顶点。

相似题目: 2673. 使二叉树所有路径值相等的最小代价
https://leetcode.cn/problems/make-costs-of-paths-equal-in-a-binary-tree/
======

input
6
3 5 7 5 8 4
1 2
1 3
1 4
3 5
4 6
output
3

input
8
7 10 7 16 19 9 16 11
1 5
4 2
6 5
5 2
7 2
2 3
3 8
output
3

input
4
1 2 1 2
1 2
2 3
4 3
output
0

input
9
4 3 6 1 5 5 5 2 7
1 2
2 3
4 1
4 5
4 6
4 7
8 1
8 9
output
2
 */
