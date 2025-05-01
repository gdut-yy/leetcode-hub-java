package p212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF212E {
    static int n;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
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

    static boolean[] has;

    private static String solve() {
        has = new boolean[n - 1];
        dfs(0, -1);

        has[0] = false;
        int tot = 0;
        for (boolean v : has) {
            if (v) {
                tot++;
            }
        }
        StringBuilder output = new StringBuilder();
        output.append(tot).append("\n");
        for (int i = 0; i < has.length; i++) {
            if (has[i]) {
                output.append(i).append(" ").append(n - 1 - i).append("\n");
            }
        }
        return output.toString();
    }

    static int dfs(int v, int fa) {
        int size = 1;
        boolean[] f = new boolean[n - 1];
        f[0] = true;
        for (Integer w : g[v]) {
            if (w == fa) continue;
            int sz = dfs(w, v);
            for (int j = n - 2; j >= sz; j--) {
                f[j] = f[j] || f[j - sz];
            }
            size += sz;
        }
        int sz = n - size;
        for (int j = n - 2; j >= sz; j--) {
            f[j] = f[j] || f[j - sz];
        }
        for (int i = 0; i < f.length; i++) {
            if (f[i]) {
                has[i] = true;
            }
        }
        return size;
    }
}
/*
E. IT Restaurants
https://codeforces.com/contest/212/problem/E

灵茶の试炼 2025-03-11
题目大意：
输入 n(3≤n≤5000) 和一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 开始。
一开始每个节点都是白色。
你需要把某些（不是全部）节点染色红色或者蓝色。
要求：
1. 至少有一个点是红色，至少有一个点是蓝色。
2. 红色节点不能和蓝色节点相邻。
设 (a,b) = (红色节点数,蓝色节点数)。
你需要最大化 a+b。
输出有多少种不同的 (a,b)，记作 k。
然后输出这 k 种 (a,b)，按照 a 升序。

rating 1500
根据题意，由于每种颜色都要出现，至少有一个点不能染色。
去掉这个点后，图分成了若干个连通块，为了最大化染色的节点数，每个连通块都必须是同一种颜色。
所以 a+b = n-1。
现在问题变成，给定一些数字（连通块大小），这些数字的子集和有哪些？
枚举每个点，断成若干连通块，用 0-1 背包解决。（或者 bitset）
每个节点跑个独立的 0-1 背包。
代码 https://codeforces.com/problemset/submission/212/309426752
代码备份（洛谷）
======

Input
5
1 2
2 3
3 4
4 5
Output
3
1 3
2 2
3 1

Input
10
1 2
2 3
3 4
5 6
6 7
7 4
8 9
9 10
10 4
Output
6
1 8
2 7
3 6
6 3
7 2
8 1
 */
