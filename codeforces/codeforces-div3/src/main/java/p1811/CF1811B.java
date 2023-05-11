package p1811;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1811B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            System.out.println(solve(n, x1, y1, x2, y2));
        }
    }

    private static String solve(int n, int x1, int y1, int x2, int y2) {
        // sum = 1 + n
        n++;

        x1 = Math.max(x1, n - x1);
        y1 = Math.max(y1, n - y1);
        x2 = Math.max(x2, n - x2);
        y2 = Math.max(y2, n - y2);

        int s = Math.max(x1, y1);
        int t = Math.max(x2, y2);
        return String.valueOf(Math.abs(s - t));
    }
}
/*
B. Conveyor Belts
https://codeforces.com/contest/1811/problem/B

题目大意：
输送机矩阵 mn 为大小为 n×n 的矩阵，其中 n 为偶数。矩阵由顺时针运动的同心带组成。
换句话说，n=2 时的传送带矩阵就是一个矩阵 2×2，它的细胞顺时针形成一个长度为 4 的循环。对于任意自然 k≥2，通过在矩阵 m2k−2 上加一外层形成顺时针循环得到矩阵 m2k。
你站在一个坐标为 x1,y1 的单元格里你想进入一个坐标为 x2,y2 的单元格。如果单元格位于第 x 行和第 y 列的交点，则它的坐标为 x,y。
站在某个细胞上，每秒钟你都会沿着你所在的带子的运动方向移动到下一个细胞。你也可以通过消耗一个单位的能量移动到邻近的细胞。动作是即时发生的，你可以在任何时候做出无限数量的动作。
你的任务是找出从坐标为 x1,y1 的单元格到坐标为 x2,y2 的单元格所需要消耗的最小能量。
例如，n=8，最初你在一个坐标为 1,3 的单元格中，你想进入一个坐标为 6,4 的单元格。你可以立即进行 2 次移动，一旦你进入坐标为 3,3 的单元格，8 秒后你就会进入正确的单元格。

确定层数，层数差值即是答案。
======

input
5
2 1 1 2 2
4 1 4 3 3
8 1 3 4 6
100 10 20 50 100
1000000000 123456789 987654321 998244353 500000004
output
0
1
2
9
10590032
 */
