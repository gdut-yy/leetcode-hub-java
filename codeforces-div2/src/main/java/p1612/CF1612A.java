package p1612;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1612A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(solve(x, y));
        }
    }

    private static String solve(int x, int y) {
        if ((x + y) % 2 != 0) {
            return "-1 -1";
        } else {
            int halfSum = (x + y) / 2;
            for (int cx = 0; cx <= halfSum; cx++) {
                int cy = halfSum - cx;
                if (Math.abs(cx - x) + Math.abs(cy - y) == halfSum) {
                    return cx + " " + cy;
                }
            }
        }
        return "-1 -1";
    }
}
/*
Educational Codeforces Round 117 (Rated for Div. 2)
A. Distance
https://codeforces.com/contest/1612/problem/A

题目大意：
已知两点 A 和 B，点 A 的坐标是 (0,0) 点 B 的坐标是 (x,y)，需要找到一个点 C，使 AC, BC 距离为 AB 距离一半（距离指曼哈顿距离）。

AB 距离为奇数，直接返回 "-1 -1"。距离为偶数，则逐个枚举点即可。
======

input
10
49 3
2 50
13 0
0 41
42 0
0 36
13 37
42 16
42 13
0 0

output
23 3
1 25
-1 -1
-1 -1
21 0
0 18
13 12
25 4
-1 -1
0 0
 */