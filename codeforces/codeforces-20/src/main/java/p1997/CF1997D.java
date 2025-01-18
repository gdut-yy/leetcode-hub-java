package p1997;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1997D {
    static int n;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int w = 1; w < n; w++) {
                int p = scanner.nextInt() - 1;
                g[p].add(w);
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int mn = Integer.MAX_VALUE;
        for (Integer w : g[0]) {
            mn = Math.min(mn, dfs(w));
        }
        return String.valueOf(a[0] + mn);
    }

    static int dfs(int v) {
        if (g[v].isEmpty()) {
            return a[v];
        }
        int mn = Integer.MAX_VALUE;
        for (Integer w : g[v]) {
            mn = Math.min(mn, dfs(w));
        }
        if (a[v] > mn) {
            return mn;
        }
        return (a[v] + mn) / 2;
    }
}
/*
D. Maximize the Root
https://codeforces.com/contest/1997/problem/D

灵茶の试炼 2024-09-17
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)，表示一棵 n 个节点的树，节点 i 的点权为 a[i]。
然后输入 p2,p3,...,pn，表示节点 2,3,...,n 的父节点。
节点编号从 1 到 n，其中 1 是根节点。
你可以执行如下操作任意次：
选择一个非叶节点 v，把 a[v] 加一，把子树 v 中的除了 v 以外的所有点的点权都减一。
操作后，所有点权都必须 >= 0。
输出根节点点权 a[1] 的最大值。

rating 1500
方法一：二分增加量，自顶向下 DFS
二分增加量，从上往下思考。
DFS 中维护当前节点需要减少的量。
如果当前节点是负数，比如 -3，那么所有后代后需要额外减少 3。
如果所有叶子都不会变成负数，则 check 成功。
注意递归过程可能会爆 long long。
方法一代码 https://codeforces.com/contest/1997/submission/280627101
方法二：贪心，自底向上 DFS
从下往上思考。
核心思想：短板效应，子树中的点权越「均匀」越好，这样子树整体可以减少的更多，上面的点权增加的就更多。
对于节点 x，讨论 x 的点权和 x 儿子的点权的大小关系：
- 如果 x 的点权比所有儿子的点权都大，那么 x 的点权不增加更好。（增加会导致更不均匀）
- 否则，把 x 的点权增大到 (x 点权 + min(儿子点权)) / 2 下取整。
最后答案为 0 的点权 + min(0 儿子点权的最小值)。
方法二代码 https://codeforces.com/problemset/submission/1997/280628250
======

Input
3
4
0 1 0 2
1 1 3
2
3 0
1
5
2 5 3 9 6
3 1 5 2
Output
1
3
6
 */
