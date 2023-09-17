package c318;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc318_b {
    static int n;
    static int[][] abcd;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        abcd = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                abcd[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        boolean[][] cover = new boolean[105][105];
        for (int[] p : abcd) {
            for (int i = p[0]; i < p[1]; i++) {
                for (int j = p[2]; j < p[3]; j++) {
                    cover[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (boolean[] row : cover) {
            for (boolean b : row) {
                if (b) ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B - Overlapping sheets
https://atcoder.jp/contests/abc318/tasks/abc318_b

题目大意：
在一个坐标平面上有 N 个矩形片。
每个薄片覆盖的矩形区域的每条边都平行于 x 轴或 y 轴。
具体来说，第 i 张恰好覆盖了满足 A i≤x≤B i 和 C i≤y≤D i 的区域。
设 S 为一张或多张纸所覆盖区域的面积。在约束条件下，可以证明 S 是整数。
将 S 打印为整数。

暴力
======

Input 1
3
0 5 1 3
1 4 0 5
2 5 2 4
Output 1
20

Input 2
2
0 100 0 100
0 100 0 100
Output 2
10000

Input 3
3
0 1 0 1
0 3 0 5
5 10 0 10
Output 3
65
 */