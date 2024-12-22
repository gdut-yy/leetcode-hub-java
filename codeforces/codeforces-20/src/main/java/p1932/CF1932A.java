package p1932;

import java.util.Scanner;

public class CF1932A {
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int j = s.indexOf("**");
        if (j < 0) j = n;
        int ans = 0;
        for (int i = 0; i < j; i++) {
            if (s.charAt(i) == '@') {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
Codeforces Round 927 (Div. 3)
A. Thorns and Coins
https://codeforces.com/contest/1932/problem/A

题目大意：
在你的计算机世界之旅中，你偶然发现了一个非常有趣的世界。它是一条有 n 个连续单元格的路径，每个单元格可以是空的，可以是荆棘，也可以是硬币。在一次移动中，您可以沿着路径移动一个或两个单元格，前提是目标单元格不包含荆棘(并且属于路径)。如果你带着硬币走到牢房，你就把它捡起来。
这里，绿色箭头对应合法的移动，红色箭头对应非法的移动。
你想要收集尽可能多的硬币。如果你从路径的最左边开始，找到你可以在发现的世界中收集的最大硬币数量。

找到第一个 ** 后，统计前面 @ 的数量
======

Input
3
10
.@@*@.**@@
5
.@@@@
15
.@@..@***..@@@*
Output
3
4
3
 */
