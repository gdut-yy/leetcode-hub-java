package p633;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF633F {
    static int n;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(V2.solve());
    }

    static class V1 {
        static long[] subAns;
        static Node[] nodes;
        static long ans;

        private static String solve() {
            subAns = new long[n];
            nodes = new Node[n];
            Arrays.setAll(nodes, e -> new Node());
            ans = 0;
            dfs(0, -1);
            reroot(0, -1, 0);
            return String.valueOf(ans);
        }

        static long dfs(int v, int fa) {
            int val = a[v];
            subAns[v] = val;
            long maxS = val;
            long maxSubAnsW = 0;
            Node p = nodes[v];
            for (Integer w : g[v]) {
                if (w == fa) continue;
                long s = dfs(w, v);
                ans = Math.max(ans, maxSubAnsW + subAns[w]); // 两个子树 w 中的最大路径和之和
                maxSubAnsW = Math.max(maxSubAnsW, subAns[w]); // 子树 w 中的最大路径和
                subAns[v] = Math.max(subAns[v], maxS + s); // 在 v 拐弯的最大路径和
                maxS = Math.max(maxS, s + val); // 子树 v 中的最大链和
                if (s > p.fi) {
                    p.th = p.se;
                    p.se = p.fi;
                    p.seW = p.fiW;
                    p.fi = s;
                    p.fiW = w;
                } else if (s > p.se) {
                    p.th = p.se;
                    p.se = s;
                    p.seW = w;
                } else if (s > p.th) {
                    p.th = s;
                }
            }
            subAns[v] = Math.max(subAns[v], maxSubAnsW);
            return maxS;
        }

        static void reroot(int v, int fa, long mxFa) {
            int val = a[v];
            Node p = nodes[v];
            for (Integer w : g[v]) {
                if (w == fa) continue;
                if (w == p.fiW) {
                    // 子树 w 中的最大路径和 + val + 在 v 拐弯的两条最大链和
                    ans = Math.max(ans, subAns[w] + val + p.se + Math.max(p.th, mxFa));
                    reroot(w, v, val + Math.max(p.se, mxFa));
                } else {
                    long s = p.se;
                    if (w == p.seW) {
                        s = p.th;
                    }
                    ans = Math.max(ans, subAns[w] + val + p.fi + Math.max(s, mxFa));
                    reroot(w, v, val + Math.max(p.fi, mxFa));
                }
            }
        }

        static class Node {
            long fi, se, th, fiW, seW;
        }
    }

    static class V2 {
        static long ans;

        private static String solve() {
            ans = 0;
            dfs(0, -1);
            return String.valueOf(ans);
        }

        static long[] dfs(int v, int fa) {
            int val = a[v];
            long maxChain = val;
            long maxPathV = val;
            long maxPathW = 0;
            long maxChainPath = val;
            for (Integer w : g[v]) {
                if (w == fa) {
                    continue;
                }
                long[] tuple = dfs(w, v);
                long chainW = tuple[0], pathW = tuple[1], chainPathW = tuple[2];
                ans = max(ans, maxPathV + pathW, maxPathW + pathW, maxChain + chainPathW, maxChainPath + chainW);
                maxChainPath = max(maxChainPath, chainPathW + val, maxPathW + chainW + val, maxChain + pathW);
                maxPathV = Math.max(maxPathV, maxChain + chainW);
                maxPathW = Math.max(maxPathW, pathW);
                maxChain = Math.max(maxChain, chainW + val);
            }
            return new long[]{maxChain, Math.max(maxPathV, maxPathW), maxChainPath};
        }

        static long max(long... a) {
            return Arrays.stream(a).max().orElseThrow();
        }
    }
}
/*
F. The Chocolate Spree
https://codeforces.com/contest/633/problem/F

灵茶の试炼 2024-07-05
题目大意：
输入 n(2≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，表示每个节点的点权。
然后输入一棵树的 n-1 条边，节点编号从 1 开始。
从这棵树中，选出两条不相交的路径，也就是没有节点会同时出现在两条路径中。
输出这两条路径的节点点权之和的最大值。

rating 2600
如果只有一条路径，做法类似求 树的直径 ，把路径分解成左右两条链，dfs 返回从叶子到当前节点的最长链。
方法一：两次 DFS（换根 DP）
提示：枚举边，删除这条边，把这棵树一分为二，每部分只需要计算一条最大路径和。
分类讨论：
如果两条路径分别在两棵不相交子树中，那么做法和求直径是一样的，设当前节点为 v，维护前面遍历的 v 的儿子子树的最大路径和，加上当前儿子子树的最大路径和。
dfs 除了返回最长链，还要返回子树最大路径和。
如果两条路径分别在两棵相交子树中，考虑换根 DP，一条路径在 v 的子树 w 中，另一条路径从 v 开始的以下三条链中选两条：
v - w1 子树中的最长链（其中 w1 != w）
v - w2 子树中的最长链（其中 w2 != w）
v - 从父节点过来的最长链（在换根的过程中计算）
代码一 https://codeforces.com/problemset/submission/633/268735935
方法二：一次 DFS
如右图所示，下文把：
从叶子往上到 v 的路径称作「链」。
由两条链拼成的路径叫做「路」。
由链 + 路组成的复合结构叫做「链路」。
注意链路中的链和路不一定在一起，可能间隔很远。
分类讨论，遍历 v 的子树列表时，假设当前遍历到子树 w，得到其「w 链」「w 路」「w 链路」，同时维护遍历过的子树的「最大链」「含 v 最大路」「不含 v 最大路」「最大链路」。其中「最大链」「最大链路」已经把 a[v] 算进去了。
如右图，答案是以下三种情况的最大值：
max(含 v 最大路, 不含 v 最大路) + w 路
最大链 + w 链路
最大链路 + w 链
其中「最大链路」是以下三种情况的最大值：
w 链路 + a[v]
不含 v 最大路 + w 链 + a[v]
最大链 + w 路
注意链路这一复合结构，一定是链在上，路在下，不然无法往上加点。
不能是【含 v 最大路 + w 链】。
这也是为什么我们要区分这两种最大路。
含 v 最大路的计算方式同直径，取最大链 + w 链的最大值。
而最大链又是 w 链 + a[v] 的最大值。注意变量更新的顺序。
不含 v 最大路是 w 路的最大值。
代码二 https://codeforces.com/problemset/submission/633/268854936
======

Input
9
1 2 3 4 5 6 7 8 9
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
Output
25

Input
2
20 10
1 2
Output
30
 */
