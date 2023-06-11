package p1826;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1826D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve(n, b));
        }
    }

    private static final int INF = (int) 1e9;

    private static String solve(int n, int[] b) {
        // f[i][j] 表示前 i 个选 j 个最大 的最大值
        int[][] f = new int[n + 1][3];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(f[i], -INF);
        }
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = Math.max(f[i][0], b[i] + i);
            f[i + 1][1] = Math.max(f[i][1], f[i][0] + b[i]);
            f[i + 1][2] = Math.max(f[i][2], f[i][1] + b[i] - i);
        }
        return String.valueOf(f[n][2]);
    }
}
/*
D. Running Miles
https://codeforces.com/contest/1826/problem/D

题目大意：
有一条有 n 个景点的街道，第 i 个景点距离街道的起点有 i 英里。视线 i 有美 bi。你想在距离街道起点 l 英里的地方开始晨跑，在距离街道起点 r 英里的地方结束晨跑。
当你跑步的时候，你会看到你跑步经过的景点(包括距离起点 l 英里和 r 英里的景点)。你对慢跑途中 3 个最美丽的景点很感兴趣，但每跑一英里，你就越来越累。
所以选择 l 和 r，这样至少有 3 个景点你跑过，并且 3 个最美丽的景点的美减去你要跑的距离的总和是最大的。
更正式地说，选择 l 和 r，使得 b[i1]+b[i2]+b[i3]−(r−l)是最大可能，其中 i1,i2,i3 是范围[l,r]中三个最大元素的索引。

状态机 DP。
或者前后缀分解，枚举 x：(bi+i) + x + (bi-i)
======

input
4
5
5 1 4 2 3
4
1 1 1 1
6
9 8 7 6 5 4
7
100000000 1 100000000 1 100000000 1 100000000
output
8
1
22
299999996
 */
