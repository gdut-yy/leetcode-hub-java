package c380;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc380_e {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        UF u = new UF(n + 1);
        int[] color = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            color[i] = 1;
        }

        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            int x = scanner.nextInt();

            if (op == 2) {
                out.println(color[x]);
                continue;
            }

            int c = scanner.nextInt();
            x = u.find(x);
            color[u.color(x)] -= u.size(x);
            u.c[x] = c;
            color[u.color(x)] += u.size(x);

            int l = x - u.size(x);
            if (l > 0 && u.color(l) == c) {
                u.merge(l, x);
            }
            if (x < n && u.color(x + 1) == c) {
                u.merge(x, x + 1);
            }
        }
    }

    static class UF {
        int[] fa;
        int[] sz;
        int[] c;

        public UF(int n) {
            fa = new int[n];
            sz = new int[n];
            c = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                sz[i] = 1;
                c[i] = i;
            }
        }

        public int find(int x) {
            if (fa[x] != x) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        public void merge(int from, int to) {
            int x = find(from);
            int y = find(to);
            if (x == y) {
                return;
            }
            fa[x] = y;
            sz[y] += sz[x];
        }

        public int size(int x) {
            return sz[find(x)];
        }

        public int color(int x) {
            return c[find(x)];
        }
    }
}
/*
E - 1D Bucket Tool
https://atcoder.jp/contests/abc380/tasks/abc380_e

灵茶の试炼 2025-12-31
题目大意：
输入 n(1≤n≤5e5) 和 q(1≤q≤2e5)。
有一条长为 n 的，有 n 个格子的纸带，其中第 i 个格子的初始颜色为 i。
然后输入 q 个询问，格式如下（1≤x≤n，1≤c≤n）：
"1 x c"：把第 x 个格子所在的连续同色段全部涂成颜色 c（类似画图软件的油漆桶工具）。比如 112233 把第三个格子涂成 4，得到 114433。
"2 c"：输出整个纸带的颜色为 c 的格子的数量。

区间并查集，额外维护集合大小 size、集合颜色 color。
并查集合并的时候，总是从左边的格子指向右边的格子，这样对于一段连续同色的格子，其代表元为这一段最右边的格子。
设格子 x 所在段的最右边的格子编号为 i。
那么下一段的第一个格子为 i+1。
上一段的最后一个格子为 i-size[i]。
如果格子 i+1 的颜色也是 c，那么合并 i 和 i+1。
如果格子 i-size[i] 的颜色也是 c，那么合并 i-size[i] 和 i。
对于颜色 c 的总个数，可以额外维护一个数组 colorCnt，初始 colorCnt[i] = 1。
修改颜色：
把 colorCnt[color[i]] 减少 size[i]。
把 colorCnt[c] 增加 size[i]。
代码 https://atcoder.jp/contests/abc380/submissions/72081019
======

Input 1
5 6
1 5 4
1 4 2
2 2
1 3 2
1 2 3
2 3
Output 1
3
4
 */
