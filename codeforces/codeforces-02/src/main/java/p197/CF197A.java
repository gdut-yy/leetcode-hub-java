package p197;

import java.util.Scanner;

public class CF197A {
    static int a, b, r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        r = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        return r * 2 <= a && r * 2 <= b ? "First" : "Second";
    }
}
/*
A. Plate Game
https://codeforces.com/contest/197/problem/A

灵茶の试炼 2022-05-17
题目大意：
有一张长为 a 宽为 b 的桌子，以及数量无限的半径为 r 的圆形盘子（a b r 均为 [1,100] 的整数）
Alice 和 Bob 先后往桌子上放盘子，盘子之间不能重叠，且不能超出桌子的边界（可以紧贴边界或其它盘子）。无法放盘子的人输，另一个人赢。
如果先手能赢则输出 First，否则输出 Second。

rating 1600
https://codeforces.com/contest/197/submission/157437054
如果盘子可以放在桌子上，那么先手把盘子放在桌子正中央，那么无论后手怎么放，先手都可以放在关于桌子中心对称的位置上，这样最后一定是后手没法放盘子。
因此只要盘子可以放在桌子上就是先手必胜，否则先手无法放任何盘子，必败。
======

input
5 5 2
output
First

input
6 7 4
output
Second
 */
