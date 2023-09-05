package p1849;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1849A {
    static int b, c, h;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            b = scanner.nextInt();
            c = scanner.nextInt();
            h = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = Math.min(b - 1, c + h) * 2 + 1;
        return String.valueOf(ans);
    }
}
/*
Educational Codeforces Round 152 (Rated for Div. 2)
A. Morning Sandwich
https://codeforces.com/contest/1849/problem/A

题目大意：
Monocarp 总是以一个美味的三明治开始他的早晨。Monocarp 制作的三明治通常由面包、奶酪和/或火腿组成。
三明治总是遵循这样的公式:
一片面包
一片奶酪或火腿
一片面包
…
一片奶酪或火腿
一片面包
所以它的顶部和底部总是有面包，面包和馅料交替使用，馅料是一片奶酪或火腿。每一片面包、每一片奶酪或火腿被称为一层。
今天 Monocarp 醒来，发现他有 b 片面包，c 片奶酪和 h 片火腿。他的早餐三明治最多能吃多少层?

贪心。
======

input
3
2 1 1
10 1 2
3 7 8
output
3
7
5
 */
