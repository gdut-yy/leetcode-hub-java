package c279;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc279_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        char[][] s = new char[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = scanner.next().toCharArray();
        }
        char[][] t = new char[h][w];
        for (int i = 0; i < h; i++) {
            t[i] = scanner.next().toCharArray();
        }
        System.out.println(solve(h, w, s, t));
    }

    private static String solve(int h, int w, char[][] s, char[][] t) {
        // 纵向字符串
        List<String> sList = new ArrayList<>();
        List<String> tList = new ArrayList<>();
        char[] cs1 = new char[h];
        char[] cs2 = new char[h];
        for (int j = 0; j < w; j++) {
            for (int i = 0; i < h; i++) {
                cs1[i] = s[i][j];
                cs2[i] = t[i][j];
            }
            sList.add(new String(cs1));
            tList.add(new String(cs2));
        }
        sList.sort(null);
        tList.sort(null);
        return sList.equals(tList) ? "Yes" : "No";
    }
}
/*
C - RANDOM
https://atcoder.jp/contests/abc279/tasks/abc279_c

题目大意：
给定由 # 和 . 组成的模式 S 和 T，每个模式有 H 行和 W 列。
模式 S 以 H 字符串的形式给出，S 的第 j 个字符表示第 i 行第 j 列的元素。T 也是一样。
通过重新排列 S 的列，确定 S 是否可以等于 T。
在这里，按如下方式重新排列模式 X 的列。
- 选择一个排列 P = (P - 1, 2,…,P W)的(1,2,…,W)。
- 然后，对于每一个 1≤i≤H 的整数 i，同时进行如下操作。
  - 对于每一个 1≤j≤W 的整数 j，同时将 X 的第 i 行第 j 列的元素替换为第 i 行第 P j 列的元素。

统计每个列的 # 数量，判断是否相等即可。
======

Input 1
3 4
##.#
##..
#...
.###
..##
...#
Output 1
Yes

Input 2
3 3
#.#
.#.
#.#
##.
##.
.#.
Output 2
No

Input 3
2 1
#
.
#
.
Output 3
Yes

Input 4
8 7
#..#..#
.##.##.
#..#..#
.##.##.
#..#..#
.##.##.
#..#..#
.##.##.
....###
####...
....###
####...
....###
####...
....###
####...
Output 4
Yes
 */