package c325;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc325_b {
    static int n;
    static int[][] wx;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        wx = new int[n][2];
        for (int i = 0; i < n; i++) {
            wx[i][0] = scanner.nextInt();
            wx[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] cnt = new int[24];
        for (int[] p : wx) {
            int w = p[0], x = p[1];
            for (int i = 0; i < 9; i++) {
                cnt[(x + i) % 24] += w;
            }
        }

        int ans = Arrays.stream(cnt).max().orElseThrow();
        return String.valueOf(ans);
    }
}
/*
B - World Meeting
https://atcoder.jp/contests/abc325/tasks/abc325_b

题目大意：
Keyence 在全球有 N 个基地，编号从 1 到 N。基地 i 有 W 名员工，在协调世界时(UTC)的 0 点，基地 i 的 Xi 点钟方向。
你想在全公司开一个一小时的会议。每个员工只能参加会议，如果会议时间完全在其基地的 9:00-18:00 时间段内。在决定会议时间时，找到可以参加会议的最大员工人数，以允许尽可能多的员工参加会议。

数据范围小，直接暴力。大的话考虑差分。
======

Input 1
3
5 0
3 3
2 18
Output 1
8

Input 2
2
1 10
1000000 20
Output 2
1000000

Input 3
6
31 3
20 8
11 5
4 3
47 14
1 18
Output 3
67
 */
