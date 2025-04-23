package c282;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Abc282_e {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    record tuple(int v, int w, int wt) {
    }

    private static String solve() {
        List<tuple> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = a[i];
            for (int j = i + 1; j < n; j++) {
                int w = a[j];
                b.add(new tuple(i, j, (int) ((quickPow(v, w, m) + quickPow(w, v, m)) % m)));
            }
        }
        b.sort(Comparator.comparingLong(o -> -o.wt));

        long ans = 0;
        DSU dsu = new DSU(n);
        for (tuple e : b) {
            int v = e.v, w = e.w, wt = e.wt;
            int fv = dsu.find(v);
            int fw = dsu.find(w);
            if (fv != fw) {
                dsu.union(fv, fw);
                ans += wt;
            }
        }
        return String.valueOf(ans);
    }

    static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
        }
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b, long MOD) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
E - Choose Two and Eat One
https://atcoder.jp/contests/abc282/tasks/abc282_e

灵茶の试炼 2025-01-09
题目大意：
输入 n(2≤n≤500) m(2≤m≤1e9) 和长为 n 的数组 a(1≤a[i]≤m-1)。
重复如下操作 n-1 次：
选择 a 中的两个数 x 和 y，得到 (pow(x,y)+pow(y,x))%m 分，然后从 a 中删除 x 或者 y。
输出总得分的最大值。

看成有 n 个节点的完全图。
每次操作相当于选择一条边，并删掉一个节点。
由于选择的边，不会与已删除的点相连，所以选择的边不能构成环。
于是 n-1 次选边后，我们得到的是一棵生成树。
Kruskal/Prim 计算最大生成树即可，后者复杂度 O(n^2)。
代码 https://atcoder.jp/contests/abc282/submissions/61218053
======

Input 1
4 10
4 2 3 2
Output 1
20

Input 2
20 100
29 31 68 20 83 66 23 84 69 96 41 61 83 37 52 71 18 55 40 8
Output 2
1733
 */
