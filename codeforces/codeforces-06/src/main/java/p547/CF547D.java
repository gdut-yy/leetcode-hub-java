package p547;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF547D {
    static int n;
    static List<Integer>[] g;
    static final int mx = (int) (2e5 + 1);
    static int[] preX, preY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        preX = new int[mx];
        preY = new int[mx];
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (preX[x] == 0) {
                preX[x] = i;
            } else {
                g[i].add(preX[x]);
                g[preX[x]].add(i);
                preX[x] = 0;
            }
            if (preY[y] == 0) {
                preY[y] = i;
            } else {
                g[i].add(preY[y]);
                g[preY[y]].add(i);
                preY[y] = 0;
            }
        }
        System.out.println(solve());
    }

    static int[] colors;

    private static String solve() {
        colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                dfs(i, 1);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int c = colors[i];
            ans.append(" br".charAt(c));
        }
        return ans.toString();
    }

    static void dfs(int v, int c) {
        colors[v] = c;
        for (Integer w : g[v]) {
            if (colors[w] == 0) {
                dfs(w, 3 ^ c);
            }
        }
    }
}
/*
D. Mike and Fish
https://codeforces.com/contest/547/problem/D

灵茶の试炼 2023-12-29
题目大意：
输入 n(1≤n≤2e5) 和 n 个二维坐标点，范围 [1,2e5]。
你需要把每个点染成红色或者蓝色，使得每条水平线或垂直线上的红色点和蓝色点的数量之差至多为 1。
输出染色方案，答案的第 i 个字符为 'r' 或 'b'，表示输入的第 i 个点染成红色/蓝色。

rating 2600
双色染色问题，先试试二分图。
建图：
同一水平线上的点，两个两个一对，连一条边。如果有奇数个点，多出的一个点不连边。
同一垂直线上的点，两个两个一对，连一条边。如果有奇数个点，多出的一个点不连边。
由于图中任意路径一定是 水平边-垂直边-水平边-垂直边 交替进行，所以的得到的图一定是二分图（可能有多个连通块）。
直接二分图染色，即可得到答案。
https://codeforces.com/problemset/submission/547/239142819
======

input
4
1 1
1 2
2 1
2 2
output
brrb

input
3
1 1
1 2
2 1
output
brr
 */
