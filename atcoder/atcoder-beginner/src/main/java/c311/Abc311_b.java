package c311;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc311_b {
    static int n, d;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        d = scanner.nextInt();
        a = new char[n][d];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        boolean[] occupied = new boolean[d];
        Arrays.fill(occupied, true);
        for (int j = 0; j < d; j++) {
            for (int i = 0; i < n; i++) {
                if (a[i][j] == 'x') {
                    occupied[j] = false;
                    break;
                }
            }
        }

        int cnt = 0, max = 0;
        for (int i = 0; i < d; i++) {
            if (occupied[i]) {
                cnt++;
            } else {
                cnt = 0;
            }
            max = Math.max(max, cnt);
        }
        return String.valueOf(max);
    }

}
/*
B - Vacation Together
https://atcoder.jp/contests/abc311/tasks/abc311_b

题目大意：
一共有 N 个人，编号从 1 到 N。
你会得到他们接下来 D 天的日程安排。第 i 个人的日程安排用长度为 d 的字符串 s1 表示。如果 s1 的第 j 个字符为 o，则第 i 个人在第 j 天空闲;如果是 x，他们那天已经被占用了。
从这 D 天中，考虑选择一些所有人都有空的连续日子。
最多可以选择多少天?如果不能选择日期，则报告 0。

预处理，贪心取最大连续区间。
======

Input 1
3 5
xooox
oooxx
oooxo
Output 1
2

Input 2
3 3
oxo
oxo
oxo
Output 2
1

Input 3
3 3
oox
oxo
xoo
Output 3
0

Input 4
1 7
ooooooo
Output 4
7

Input 5
5 15
oxooooooooooooo
oxooxooooooooox
oxoooooooooooox
oxxxooooooxooox
oxooooooooxooox
Output 5
5
 */