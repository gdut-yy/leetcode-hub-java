package c133;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Abc133_e {
    static int n, k;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);
    static long ans;

    private static String solve() {
        ans = k;
        dfs(1, 0, 0);
        return String.valueOf(ans);
    }

    static void dfs(int v, int fa, int dep) {
        int c = 0;
        for (Integer w : g[v]) {
            if (w == fa) continue;
            ans = ans * (k - Math.min(dep + 1, 2) - c) % MOD;
            dfs(w, v, dep + 1);
            c++;
        }
    }
}
/*
E - Virus Tree 2
https://atcoder.jp/contests/abc133/tasks/abc133_e

灵茶の试炼 2025-01-29
题目大意：
输入 n(1≤n≤1e5) k(1≤k≤1e5) 和一棵无向树的 n-1 条边，节点编号从 1 到 n。
有 k 种颜色，你需要把每个节点染成 k 种颜色中的一个。
要求：对于相距为 1 或 2 的点对，颜色必须不同。
输出染色方案数，模 1e9+7。
进阶：改成相距为 1~3。

从特殊到一般，如果树是一条链，答案是多少？
从左到右思考：
第一个点可以染 k 种颜色；
第二个点颜色不能和前一个点相同，可以染 k-1 种颜色；
其余点不能和前两个点相同，可以染 k-2 种颜色。
对于一般树上的点 v，哪些点是在点 v 前面的距离点 v 至多为 2 的点？
v 的父节点，
v 的父节点的父节点，
v 左边的兄弟节点（即 v 的父节点的儿子）。
那么 v 可以染 (k - 上述节点个数) 种颜色。
代码 https://atcoder.jp/contests/abc133/submissions/62016013
======

Input 1
4 3
1 2
2 3
3 4
Output 1
6

Input 2
5 4
1 2
1 3
1 4
4 5
Output 2
48

Input 3
16 22
12 1
3 1
4 16
7 12
6 2
2 15
5 16
14 16
10 11
3 10
3 13
8 6
16 8
9 12
4 3
Output 3
271414432
 */
