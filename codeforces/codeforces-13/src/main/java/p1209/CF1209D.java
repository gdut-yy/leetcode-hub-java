package p1209;

import java.util.Scanner;

public class CF1209D {
    static Scanner scanner = new Scanner(System.in);
    static int n, k;

    public static void main(String[] args) {
        n = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        DSU dsu = new DSU(n);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            if (dsu.find(v) == dsu.find(w)) {
                ans++;
            } else {
                dsu.union(v, w);
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
}
/*
D. Cow and Snacks
https://codeforces.com/contest/1209/problem/D

灵茶の试炼 2025-05-14
题目大意：
输入 n(2≤n≤1e5) 和 k(1≤k≤1e5)。
有 k 个人，每个人都有两种喜欢的零食。零食编号从 1 到 n。
然后输入 k 行，每行两个不同的数，表示第 i 个人喜欢的两种零食的编号。
商店有 n 种零食，每种零食各一个，卖完就没了。
这 k 个人排队购买自己喜欢的所有零食。如果没有买到任何自己喜欢的零食，就会伤心。
请你排列这 k 个人的顺序，最小化伤心的人数。

rating 1700
在喜欢的两种零食之间连边，得到一个图。
对于图中的每个连通块，其任意一棵生成树上的边，对应的人都是可以满足的，我们先满足这些人。其余边，由于零食都被买了，无法满足。
用 DFS 或者并查集可以算出有多少条边无法满足。
代码 https://codeforces.com/contest/1209/submission/66523995
代码备份（洛谷）
======

Input
5 4
1 2
4 3
1 4
3 4
Output
1

Input
6 5
2 3
2 1
3 4
6 5
4 5
Output
0
 */
