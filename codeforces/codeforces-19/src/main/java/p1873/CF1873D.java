package p1873;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1873D {
    static int n, k;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        int i = 0;
        while (i < n) {
            if (s[i] == 'B') {
                i += k;
                ans++;
            } else {
                i++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. 1D Eraser
https://codeforces.com/contest/1873/problem/D

题目大意：
给你一张 n 格长的纸条。每个细胞不是黑色就是白色。在一个操作中，你可以取任意 k 个连续的细胞，并把它们都变成白色。
找出移除所有黑色单元格所需的最小操作次数。

枚举
======

input
8
6 3
WBWWWB
7 3
WWBWBWW
5 4
BWBWB
5 5
BBBBB
8 2
BWBWBBBB
10 2
WBBWBBWBBW
4 1
BBBB
3 2
WWW
output
2
1
2
1
4
3
4
0
 */
