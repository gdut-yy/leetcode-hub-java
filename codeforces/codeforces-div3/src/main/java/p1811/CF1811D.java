package p1811;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1811D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(solve(n, x, y));
        }
    }

    private static final int MAX_N = 50;
    private static int[] fib;

    private static String solve(int n, int x, int y) {
        if (fib == null) {
            fib = new int[MAX_N];
            fib[0] = fib[1] = 1;
            for (int i = 2; i < MAX_N; i++) {
                fib[i] = fib[i - 2] + fib[i - 1];
            }
        }
        return dfs(n, x - 1, y - 1) ? "YES" : "NO";
    }

    private static boolean dfs(int n, int x, int y) {
        if (n == 1) {
            return true;
        }
        if (fib[n - 1] <= y && y < fib[n]) {
            return false;
        }
        if (fib[n] <= y) {
            y -= fib[n];
        }
        return dfs(n - 1, y, x);
    }
}
/*
D. Umka and a Long Flight
https://codeforces.com/contest/1811/problem/D

题目大意：
女孩乌姆卡喜欢旅行和参加数学奥林匹克竞赛。一天，她在飞往下一届奥林匹克运动会的飞机上，出于无聊，在一张巨大的方格纸上翻找。
Umka 有一个 n 阶的斐波那契矩形。有人在 x 行和 y 列的交点给一个单元格上色。
记第 n 个斐波那契数为
Fn = 1, n = 0
Fn = 1, n = 1
Fn = Fn-2 + Fn-1, n >= 2
有必要把这个矩形精确地切成 n+1 个正方形，这样
- 粉刷过的牢房是一个边长为 1 的正方形;
- 最多只有一对等边正方形;
- 每个正方形的边长等于一个斐波那契数。
乌姆卡能用这种方式切割这个矩形吗?

F0^2 + F1^2 + ... + Fn^2 = Fn·Fn+1
======

input
12
1 1 1
2 1 2
3 1 4
3 3 2
4 4 6
4 3 3
5 6 5
5 4 12
5 2 12
4 2 1
1 1 2
44 758465880 1277583853
output
YES
NO
YES
YES
YES
NO
YES
NO
NO
YES
YES
NO
 */
