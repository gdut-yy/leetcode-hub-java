package p1547;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1547G {
    static int n, m;
    static List<Integer>[] g;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (; m > 0; m--) {
                int v = scanner.nextInt() - 1;
                int w = scanner.nextInt() - 1;
                g[v].add(w);
            }
            System.out.println(solve());
        }
    }

    static int[] ans;
    static boolean[] inStack;

    private static String solve() {
        ans = new int[n];
        inStack = new boolean[n];
        dfs(0, false);

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static void dfs(int v, boolean inCycle) {
        inStack[v] = true;
        if (inCycle) {
            ans[v] = -1;
        } else {
            // 首次访问：ans[v] = 1
            // 再次访问：ans[v] = 2
            ans[v]++;
        }
        for (Integer w : g[v]) {
            if (ans[w] < 0) continue;
            if (inCycle || inStack[w]) { // w 在环上，再访问一次（w 至多访问三次）
                dfs(w, true); // 从 w 出发能到达的点都在环上
            } else if (ans[w] < 2) { // 除非后面发现 w 在环上，否则至多访问 w 两次
                dfs(w, false);
            }
        }
        inStack[v] = false;
    }
}
/*
G. How Many Paths?
https://codeforces.com/contest/1547/problem/G

灵茶の试炼 2024-04-25
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤4e5，m 之和 ≤4e5。
每组数据输入 n(1≤n≤4e5) m(0≤m≤4e5) 表示一个 n 点 m 边的有向图。
然后输入 m 条边，每条边输入 v w，表示一条 v 到 w 的有向边。
节点编号从 1 开始。保证图中无重边，但图中可能有自环。
对每个点 v，考虑从 1 到 v 的路径个数：
没有：输出 0。
只有一条：输出 1。
不止一条，但个数有限：输出 2。
有无数条路径：输出 -1。
注：路径允许是空的，这意味着 1 到 1 也算一条路径（长度为 0）。
注：路径允许有重复的点和边。

rating 2100
从 1 开始 DFS。
考虑从 v 到 w 的边。
ans 就像是一个计数器，只要 ans[w] < 2 就可以访问节点 w。每访问一个点，就把这个点的 ans 值加一。
对于一个节点 v，如果 v 不在环上，或者无法从环出发到达 v，那么人为地限制 v 至多被访问两次：
首次访问：ans[v] = 1。
再次访问：ans[v] = 2。
否则，v 以及 v 能访问到的点，ans 值都是 -1。
一旦一个点的 ans 值变成 -1，就不再访问了。
所以一个点至多访问 3 次。
最后，怎么判断一个点是否在环上？
我们可以用一个 bool 数组 inStack 标记每个点是否在递归栈中：
开始 DFS 节点 v：标记 inStack[v] = true。
结束 DFS 节点 v：标记 inStack[v] = false。
对于 v 到 w 这条边，如果我们发现 inStack[w] == true，就说明 w 在环上，因为这意味着我们从 w DFS 到了 v，而 v 又可以到 w。（当然，v 也在环上。）
https://codeforces.com/contest/1547/submission/257982013
======

Input
5

6 7
1 4
1 3
3 4
4 5
2 1
5 5
5 6

1 0

3 3
1 2
2 3
3 1

5 0

4 4
1 2
2 3
1 4
4 3
Output
1 0 1 2 -1 -1
1
-1 -1 -1
1 0 0 0 0
1 1 2 1
 */
