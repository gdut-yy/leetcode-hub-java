package p1837;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1837A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int x = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(solve(x, k));
        }
    }

    private static String solve(int x, int k) {
        if (x % k != 0) {
            return "1" + System.lineSeparator() + x;
        }
        return "2" + System.lineSeparator() + (x - 1) + " " + 1;
    }
}
/*
Educational Codeforces Round 149 (Rated for Div. 2) https://www.bilibili.com/video/BV1uz4y1B7wQ/
A. Grasshopper on a Line
https://codeforces.com/contest/1837/problem/A

题目大意：
给定两个整数 x 和 k。蚱蜢从 x 轴上的点 0 开始。在一次移动中，它可以跳跃一个整数距离，这个整数距离不能被 k 整除，向左或向右。
蚱蜢移动到点 x 的最小步数是多少?这些动作是什么?如果有多个答案，打印其中任何一个。
2≤k≤100

脑筋急转弯。如果 x 为 k 的倍数，那么 x-1 必然不是 k 的倍数
======

input
3
10 2
10 3
3 4
output
2
7 3
1
10
1
3
 */
