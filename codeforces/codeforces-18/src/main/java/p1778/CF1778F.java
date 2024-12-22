package p1778;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1778F {
    static final int mx = 1000;
    static final List<Integer>[] divisors;
    static int[] ceilSqrt;

    static {
        divisors = new ArrayList[mx + 1];
        Arrays.setAll(divisors, e -> new ArrayList<>());
        for (int i = mx; i > 0; i--) { // 方便后面从大到小遍历因子
            for (int j = i; j <= mx; j += i) {
                divisors[j].add(i);
            }
        }
        ceilSqrt = new int[mx + 1];
        for (int i = 1; i <= mx; i++) {
            ceilSqrt[i] = 1;
            int x = i;
            for (int p = 2; p * p <= x; p++) {
                for (int p2 = p * p; x % p2 == 0; x /= p2) {
                    ceilSqrt[i] *= p;
                }
                if (x % p == 0) {
                    ceilSqrt[i] *= p;
                    x /= p;
                }
            }
            if (x > 1) {
                ceilSqrt[i] *= x;
            }
        }
    }

    static int n, k;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
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
            System.out.println(solve());
        }
    }

    static final int INF = (int) 1e9;
    static int[] subGcd;
    static int cnt;

    private static String solve() {
        if (k == 0) return String.valueOf(a[0]);

        subGcd = new int[n];
        dfs0(0, -1);

        for (Integer d : divisors[a[0]]) {
            cnt = 0;
            for (Integer v : g[0]) {
                dfs(v, 0, d);
            }
            if (cnt < k) {
                return String.valueOf(a[0] * d);
            }
        }
        return "";
    }

    static void dfs0(int v, int fa) {
        subGcd[v] = a[v];
        for (Integer w : g[v]) {
            if (w != fa) {
                dfs0(w, v);
                subGcd[v] = getGCD(subGcd[v], subGcd[w]);
            }
        }
    }

    static void dfs(int v, int fa, int d) {
        if (subGcd[v] % d == 0) {
            // 无需操作
            return;
        }
        if (subGcd[v] * subGcd[v] % d == 0) {
            cnt++; // 操作 v
            return;
        }
        if (g[v].size() == 1 || a[v] * a[v] % d > 0) {
            cnt = INF; // 无法操作
            return;
        }
        for (Integer w : g[v]) {
            if (w != fa) {
                dfs(w, v, ceilSqrt[d]);
            }
        }
        cnt++; // 操作 v
    }

    static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
F. Maximizing Root
https://codeforces.com/contest/1778/problem/F

灵茶の试炼 2024-07-12
题目大意：
输入 T(≤5e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤1e5) k(0≤k≤n) 和长为 n 的数组 a(1≤a[i]≤1000)。
然后输入一棵无向树的 n-1 条边，节点编号从 1 开始。
根节点为 1。节点 i 的点权为 a[i]。
你可以执行如下操作至多 k 次：
选择一个没有操作过的节点 v 和一个整数 x，其中 x 必须满足 x 是子树 v 中所有点权的公约数。然后把子树 v 中的每个点权都乘上 x。
输出操作后，a[1] 最大是多少。

rating 2600
提示 1：为了让答案尽量大，从上到下操作比较好，还是从下到上操作比较好？
提示 2：答案一定是 a[1] 乘以它的一个因子。枚举这个因子 d。
提示 3：DFS 这棵树，什么情况下，子树是不需要操作的？什么情况下，子树只需要操作一次？什么情况下，子树只需要操作两次？
我的题解 https://www.luogu.com.cn/article/c5cqkwpk
======

Input
2
5 2
24 12 24 6 12
1 2
1 3
2 4
2 5
5 3
24 12 24 6 12
1 2
1 3
2 4
2 5
Output
288
576
 */