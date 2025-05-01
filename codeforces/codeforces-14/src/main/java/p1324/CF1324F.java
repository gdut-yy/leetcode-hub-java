package p1324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1324F {
    static int n;
    static int[] color;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = scanner.nextInt();
        }
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(solve());
    }

    static long[] ans;

    private static String solve() {
        ans = new long[n];
        dfs(0, -1);
        reroot(0, -1);
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static long dfs(int x, int fa) {
        long res = color[x] * 2L - 1;
        for (Integer y : g[x]) {
            if (y != fa) {
                res += dfs(y, x);
            }
        }
        ans[x] = res;
        return Math.max(res, 0);
    }

    static void reroot(int x, int fa) {
        for (Integer y : g[x]) {
            if (y != fa) {
                if (ans[y] < 0) {
                    ans[y] += Math.max(ans[x], 0);
                } else {
                    ans[y] = Math.max(ans[y], ans[x]);
                }
                reroot(y, x);
            }
        }
    }
}
/*
F. Maximum White Subtree
https://codeforces.com/contest/1324/problem/F

灵茶の试炼 2024-12-04
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数组 a，只包含 0 和 1。
然后输入一棵无向树的 n-1 条边，节点编号从 1 到 n。
a[i] 表示节点 i 的颜色，0 表示黑色，1 表示白色。
定义 f(i) 为包含节点 i 的连通块中，白色节点个数减去黑色节点个数的最大值。
输出 f(1),f(2),...,f(n)。
注意 f(i) 可能是负数，见样例 2。

rating 1800
换根 DP。
先计算出包含节点 1 的答案（最大差值）。在这个过程中，顺带计算在以 x 为根的子树中，包含节点 x 的答案 ans[x]：
- 如果 x 的儿子子树 y 的答案，黑点比白点多（最大差值是负数），那么不考虑子树 y。
- 否则把 ans[y] 加到 ans[x] 中。
然后换根。从 x 换到其儿子 y。
本题其实只需要简单讨论一下：
- 如果 ans[y] < 0，那么 ans[x] 必然不包含 ans[y]，和上面一样，把 max(ans[x], 0) 加到 ans[y] 中。
- 否则 ans[y] >= 0，那么 ans[x] 必然包含 ans[y]，如果 ans[x] 更大，那么直接用 ans[x] 代替 ans[y]，也就是 ans[y] = max(ans[y], ans[x])。
代码 https://codeforces.com/contest/1324/submission/293599967
代码备份（洛谷）
======

Input
9
0 1 1 1 0 0 0 0 1
1 2
1 3
3 4
3 5
2 6
4 7
6 8
5 9
Output
2 2 2 2 2 1 1 0 2

Input
4
0 0 1 0
1 2
1 3
1 4
Output
0 -1 1 -1
 */
