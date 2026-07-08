package p2112;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF2112D {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static List<Integer>[] g;
    static int n;

    private static void solve() {
        n = scanner.nextInt();
        g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt(), w = scanner.nextInt();
            g[v].add(w);
            g[w].add(v);
        }
        int rt = 0;
        for (int i = 1; i <= n; i++) {
            if (g[i].size() == 2) {
                rt = i;
                break;
            }
        }
        if (rt == 0) {
            out.println("NO");
            return;
        }
        out.println("YES");
        dfs(rt, g[rt].get(1), false);
        dfs(rt, g[rt].get(0), true);
    }

    static void dfs(int v, int fa, boolean rev) {
        for (int w : g[v]) {
            if (w == fa) continue;
            if (rev) out.println(w + " " + v);
            else out.println(v + " " + w);
            dfs(w, v, !rev);
        }
    }
}
/*
D. Reachability and Tree
https://codeforces.com/contest/2112/problem/D

灵茶の试炼 2026-01-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和一棵无向树的 n-1 条边，节点编号从 1 到 n。
你需要给每条边定向，得到一棵有向树。
这棵树必须恰好有 n 条简单有向路径（每条路径至少有两个节点）。
如果无解，输出 NO。
否则输出 YES 和每条边（出点和入点）。
多解输出任意解。边的输出顺序随意。

rating 1700
由于每条边都贡献了 1，这已经有 n-1 条有向路径了，所以必须恰好再来一条至少有 3 个点的有向路径。
但如果超过 3 个节点，就至少要额外贡献 2。
所以恰好有一条恰好有 3 个节点的有向路径，这条路径额外贡献 1。
考察这三个点的中间那个点 x。
如果 x 的度数是 3，那么 x 到第三个邻居的边无论怎么定向，都会生成额外的有 3 个节点的有向路径。度数 > 3 同理。
这意味着 x 的度数必须是 2。
如果没有这样的 x，输出 NO。
否则一定有解，构造方案见右图。
随便选一个度为 2 的点为根，根节点到其邻居的两条边方向相反。
往下 DFS，每条边的方向和上面那条边的方向相反。
代码 https://codeforces.com/problemset/submission/2112/356897302
代码备份（上面打不开的同学看这个）
======

Input
4
5
1 2
2 4
1 3
3 5
5
1 2
1 3
1 4
4 5
2
2 1
4
3 1
1 2
2 4
Output
YES
1 2
3 1
3 5
4 2
YES
2 1
3 1
4 1
5 4
NO
YES
1 3
2 1
2 4
 */
