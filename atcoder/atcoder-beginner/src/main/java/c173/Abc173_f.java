package c173;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc173_f {
    static int n;
    static int[][] uv;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        uv = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            uv[i][0] = scanner.nextInt();
            uv[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long s = (long) n * (n + 1) * (n + 2) / 6;
        for (int[] p : uv) {
            int v = Math.min(p[0], p[1]), w = Math.max(p[0], p[1]);
            s -= (long) v * (n - w + 1);
        }
        return String.valueOf(s);
    }
}
/*
F - Intervals on Tree
https://atcoder.jp/contests/abc173/tasks/abc173_f

灵茶の试炼 2022-11-01
题目大意：
输入 n (2≤n≤2e5) 和一棵树的 n-1 条边（节点编号从 1 开始）。
定义 f(L,R) 表示用节点编号在 [L,R] 内的点组成的连通块的个数（边的两个端点必须都在 [L,R] 内）。
输出满足 1≤L≤R≤n 的所有 f(L,R) 的和。

https://atcoder.jp/contests/abc173/submissions/36127951
提示 1：假设一开始没有边，答案是多少？
提示 2：把边一条一条地加到树上，每加一条边，答案减少了多少？
提示 3：任何一个包含该边的两端点的区间 [L,R]，连通块的个数都会减少 1。有多少个这样的区间？
======

Input 1
3
1 3
2 3
Output 1
7

Input 2
2
1 2
Output 2
3

Input 3
10
5 3
5 7
8 9
1 9
9 10
8 4
7 4
6 10
7 2
Output 3
113
 */