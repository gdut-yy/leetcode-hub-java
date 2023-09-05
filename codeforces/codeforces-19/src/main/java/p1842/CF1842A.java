package p1842;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1842A {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    // https://codeforces.com/contest/1842/submission/210877287
    private static String solve() {
        long sumA = 0, sumB = 0;
        for (int x : a) {
            sumA += x;
        }
        for (int x : b) {
            sumB += x;
        }

        if (sumA == sumB) return "Draw";
        return sumA > sumB ? "Tsondu" : "Tenzing";
    }
}
/*
CodeTON Round 5 (Div. 1 + Div. 2, Rated, Prizes!) https://www.bilibili.com/video/BV1f14y127ex/
A. Tenzing and Tsondu
https://codeforces.com/contest/1842/problem/A

题目大意：
Tsondu 和 Tenzing 在玩纸牌。Tsondu 有 n 个技能值为 a1,a2,...,an 的怪物，而 Tenzing 有 m 个技能值为 b1,b2,...,bm 的怪物。
Tsondu 和 Tenzing 轮流走，Tsondu 先走。在每次移动中，当前玩家选择两个怪物:一个在自己这边，一个在另一边。然后，这些怪物会互相争斗。假设所选怪物的能力值分别为 x 和 y，则怪物的能力值分别为 x - y 和 y - x。如果任何怪物的技能值小于或等于 0，该怪物死亡。
当至少有一名玩家没有怪物存活时，游戏结束。获胜的是至少有一个怪物活着的玩家。如果两名玩家都没有活的怪物，游戏将以平局结束。
找出双方都处于最佳状态时的游戏结果。

a+b ?= c+d
a+b-c ?= d
结论
======

input
6
1 3
9
1 2 3
2 3
1 2
1 1 1
3 2
1 2 3
1 1
3 3
1 1 1
2 2 2
10 10
1 2 3 3 2 2 1 1 2 2
3 3 3 3 2 1 1 1 1 1
10 10
1 2 3 4 5 6 7 8 9 10
6 7 8 9 10 11 1 1 1 1
output
Tsondu
Draw
Tsondu
Tenzing
Draw
Draw
 */
