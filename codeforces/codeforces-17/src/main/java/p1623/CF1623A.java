package p1623;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CF1623A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int rb = scanner.nextInt();
            int cb = scanner.nextInt();
            int rd = scanner.nextInt();
            int cd = scanner.nextInt();
            System.out.println(solve(n, m, rb, cb, rd, cd));
        }
    }

    private static String solve(int n, int m, int rb, int cb, int rd, int cd) {
        if (rb == rd || cb == cd) {
            return "0";
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rb, cb});
        int dr = 1;
        int dc = 1;
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int[] cur = queue.remove();
            // the left or the right walls
            if ((dc == -1 && cur[1] == 1) || (dc == 1 && cur[1] == m)) {
                dc = -dc;
            }
            // the upper or lower walls
            if ((dr == -1 && cur[0] == 1) || (dr == 1 && cur[0] == n)) {
                dr = -dr;
            }
            int nextR = cur[0] + dr;
            int nextC = cur[1] + dc;
            if (nextR == rd || nextC == cd) {
                return String.valueOf(cnt);
            } else {
                queue.add(new int[]{nextR, nextC});
            }
        }
        return String.valueOf(cnt);
    }
}
/*
Codeforces Round #763 (Div. 2)
A. Robot Cleaner
https://codeforces.com/contest/1623/problem/A

题目大意：
给出整数 n, m, rb, cb, rd, 和 cd。1 到 n 行，1 到 m 列的矩阵。起始点 (rb, cb) 初始方向 dr=1, dc=1，遇墙反弹。
机器人每次清理当前行和当前列，求清洁到 (rd, cd) 所需的最少步数。

BFS 模拟即可。
======

input
5
10 10 6 1 2 8
10 10 9 9 1 1
9 8 5 6 2 1
6 9 2 2 5 8
2 2 1 1 2 1

output
7
10
9
3
0
 */