package c097;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc097_b {
    static int n, m;
    static int[] p;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt() - 1;
        }
        xy = new int[m][2];
        for (int i = 0; i < m; i++) {
            xy[i][0] = scanner.nextInt() - 1;
            xy[i][1] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        DSU dsu = new DSU(n);
        for (int[] p : xy) {
            int x = p[0], y = p[1];
            dsu.union(x, y);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == dsu.find(p[i])) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }
}
/*
D - Equals
https://atcoder.jp/contests/arc097/tasks/arc097_b

灵茶の试炼 2022-11-29
题目大意：
输入 n(≤1e5) m(≤1e5) 和一个 1~n 的排列 p。
然后输入 m 行，每行两个数 x 和 y，表示你可以交换 p[x] 和 p[y]（下标从 1 开始）。
这 m 个操作你可以按任意顺序执行任意多次。
输出你可以让多少个 p[i]=i。

https://atcoder.jp/contests/arc097/submissions/36870960
把 x 和 y 连起来，组成一个图。
如果 p[i] 和 i 在同一个连通块，那么答案就+=1。
======

Input 1
5 2
5 3 1 4 2
1 3
5 4
Output 1
2

Input 2
3 2
3 2 1
1 2
2 3
Output 2
3

Input 3
10 8
5 3 6 8 7 10 9 1 2 4
3 1
4 1
5 9
2 5
6 5
3 5
8 9
7 9
Output 3
8

Input 4
5 1
1 2 3 4 5
1 5
Output 4
5
 */