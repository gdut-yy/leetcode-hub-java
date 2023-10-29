package p1881;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1881F {
    static int n, k;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = scanner.nextInt() - 1;
            }
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 0; i < n - 1; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                g[u].add(v);
                g[v].add(u);
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (k == 1) return "0";

        int[] d1 = new int[n];
        dfs(a[0], -1, d1);
        int mx = a[0];
        for (int e : a) {
            if (d1[e] > d1[mx]) mx = e;
        }

        int[] d2 = new int[n];
        dfs(mx, -1, d2);
        mx = a[0];
        for (int e : a) {
            if (d2[e] > d2[mx]) mx = e;
        }

        int ans = (d2[mx] + 1) / 2;
        return String.valueOf(ans);
    }

    private static void dfs(int x, int fa, int[] d) {
        if (fa != -1) {
            d[x] = d[fa] + 1;
        }
        for (Integer y : g[x]) {
            if (y != fa) {
                dfs(y, x, d);
            }
        }
    }
}
/*
F. Minimum Maximum Distance
https://codeforces.com/contest/1881/problem/F

题目大意：
你有一个有 n 个顶点的树，其中一些被标记了。树是无环连通的无向图。
设 fi 表示从顶点 i 到任何标记顶点的最大距离。
你的任务是在所有顶点中找到 fi 的最小值。
例如，在示例所示的树中，标记了顶点 2、6 和 7。然后数组 f(i)=[2,3,2,4,4,3,3]。最小值是顶点 1 和 3。

https://codeforces.com/blog/entry/121327
让我们从任何标记的顶点 v1 开始运行一个宽度优先遍历，并找到距离它最远的另一个标记的顶点 v2。然后我们从 v2 开始遍历，找到距离它最远的标记顶点 v3(它可能与 v1 重合)。
那么答案是 ≤d2^2，其中 d 是 v2 和 v3 之间的距离。当树中只有一个标记顶点时，值得单独考虑。那么答案是 0。
======

input
6
7 3
2 6 7
1 2
1 3
2 4
2 5
3 6
3 7
4 4
1 2 3 4
1 2
2 3
3 4
5 1
1
1 2
1 3
1 4
1 5
5 2
4 5
1 2
2 3
1 4
4 5
10 8
1 2 3 4 5 8 9 10
2 10
10 5
5 3
3 1
1 7
7 4
4 9
8 9
6 1
10 9
1 2 4 5 6 7 8 9 10
1 3
3 9
9 4
4 10
10 6
6 7
7 2
2 5
5 8
output
2
2
0
1
4
5

input
3
6 1
3
1 2
1 3
3 4
3 5
2 6
5 3
1 2 5
1 2
1 3
2 4
3 5
7 1
2
3 2
2 6
6 1
5 6
7 6
4 5
output
0
2
0
 */
