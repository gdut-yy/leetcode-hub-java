package c293;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc293_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(h, w, a));
    }

    private static String solve(int h, int w, int[][] a) {
        int ans = 0;
        // 往右 w-1 步，往下 h-1 步，一共走 k 步
        int k = (w - 1) + (h - 1);
        for (int mask = 0; mask < 1 << k; mask++) {
            if (Integer.bitCount(mask) != w - 1) {
                continue;
            }
            int cx = 0, cy = 0;
            Set<Integer> vis = new HashSet<>();
            vis.add(a[cx][cy]);
            boolean flag = true;
            for (int i = 0; i < k; i++) {
                // 1 向右，0 向下
                if ((mask >> i & 1) == 1) {
                    cy++;
                    if (!vis.contains(a[cx][cy])) {
                        vis.add(a[cx][cy]);
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    cx++;
                    if (!vis.contains(a[cx][cy])) {
                        vis.add(a[cx][cy]);
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C - Make Takahashi Happy
https://atcoder.jp/contests/abc293/tasks/abc293_c

题目大意：
有一个有 H 横行和 W 纵列的网格。对于两个整数 i 和 j，满足 1≤i≤H 和 1≤j≤W，那么从上到下第 i 行，从左到第 j 列的正方形(我们用(i,j)表示)上有一个整数 a1,j。
Takahashi 目前在(1,1)。从现在开始，他重复移动到当前方块右侧或下方的相邻方块，直到到达(H,W)。当他移动时，他不允许走到格子外。
如果写在他访问的方格上的整数(包括初始值(1,1)和最终值(H,W))是不同的，Takahashi 会很高兴。找出让他快乐的可能路径的数量。
2≤H,W≤10
1≤Ai,j≤10e9

状态压缩枚举。
======

Input 1
3 3
3 2 2
2 1 3
1 5 4
Output 1
3

Input 2
10 10
1 2 3 4 5 6 7 8 9 10
11 12 13 14 15 16 17 18 19 20
21 22 23 24 25 26 27 28 29 30
31 32 33 34 35 36 37 38 39 40
41 42 43 44 45 46 47 48 49 50
51 52 53 54 55 56 57 58 59 60
61 62 63 64 65 66 67 68 69 70
71 72 73 74 75 76 77 78 79 80
81 82 83 84 85 86 87 88 89 90
91 92 93 94 95 96 97 98 99 100
Output 2
48620
 */