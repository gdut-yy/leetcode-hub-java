package p1921;

import java.util.Scanner;

public class CF1921E {
    static int h, w, xa, ya, xb, yb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            h = scanner.nextInt();
            w = scanner.nextInt();
            xa = scanner.nextInt();
            ya = scanner.nextInt();
            xb = scanner.nextInt();
            yb = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        boolean win;
        String winner;
        if ((xa - xb) % 2 == 0) {
            winner = "Bob";
            if (xa >= xb) {
                win = false;
            } else if (ya == yb) {
                win = true;
            } else {
                int n_turns = (ya < yb) ? yb - 1 : w - yb;
                win = xb - 2 * n_turns >= xa;
            }
        } else {
            winner = "Alice";
            xa++;

            // Integer.compare(x, y)
            // x < y 时返回 -1, x = y 时返回 0, x > y 时返回 1
            ya += Integer.compare(yb - ya, 0);
            if (xa > xb) {
                win = false;
            } else if (ya == yb) {
                win = true;
            } else {
                int n_turns = (ya < yb) ? w - ya : ya - 1;
                win = xb - 2 * n_turns >= xa;
            }
        }
        return win ? winner : "Draw";
    }
}
/*
E. Eat the Chip
https://codeforces.com/contest/1921/problem/E

题目大意：
爱丽丝和鲍勃正在棋盘上玩游戏。棋盘有 h 行，从上到下编号，w 列，从左到右编号。两名球员各有一枚筹码。最初，Alice 的芯片位于坐标为(xa,ya)的单元格(xa 行，ya 列)，Bob 的芯片位于(xb,yb)。保证芯片的初始位置不重合。玩家轮流移动，爱丽丝开始。
轮到爱丽丝时，她可以将筹码向下移动一个单元格，或者向下移动一个单元格，向右或向左移动一个单元格(对角线)。另一方面，Bob 将芯片向上、向右或向左移动一个单元格。不允许走超出棋盘边界的棋。
更正式地说，如果轮到爱丽丝时，她在坐标为(xa,ya)的格子中，那么她可以将筹码移动到(xa+1,ya)、(xa+1,ya−1)或(xa+1,ya+1)的格子中。Bob 可以从单元格(xb,yb)移动到(xb−1,yb)， (xb−1,yb−1)或(xb−1,yb+1)。新的芯片坐标(x '，y ')必须满足条件 1≤x '≤h 和 1≤y '≤w。
如果一个玩家把自己的筹码放在另一个玩家的筹码占据的格子里，他就立即获胜。如果任何一方不能移动(如果 alice 在最后一行，即 xa=h，如果 bob 在第一行，即 xb=1)，游戏立即以平局结束。
如果双方都采取最优策略，游戏的结果会是什么?

分类讨论
---
https://codeforces.com/blog/entry/124757
首先，让我们注意到 xb - xa 的差值分别(Alice 和 Bob)正好减少一个回合。最后，如果其中一个玩家赢了，xb - xa=0。特别地，这意味着如果 xa−xb 最初是奇数，那么只有 Alice 有机会赢得比赛，反之亦然。
假设 xa−xb 最初是偶数(比赛的结果可能是 Bob 赢或平局)。如果 xa≥xb，立即得出答案。否则，玩家将在 xa=xb 之前分别进行 t=(xb - xa)/2 次移动。
如果在这 2t 步中的某一时刻 Bob 可以达到 ya=yb，他就赢了，因为他可以继续对 Alice 的回合做出对称的反应。
如果 ya>yb 并且 Bob 不能到达右边界(w>yb+t)， Alice 总是可以为她选择最右边的选项，并且在每 2t 次移动之后，ya 将大于 yb，这意味着 Bob 无法获胜。否则，如果 Bob 总是为他选择最正确的选项，他最终会得到 ya=yb。
当 ya 最初小于 yb 的情况，以及当 Alice 有机会赢(xb−xa 是奇数)的情况，可以用类似的方式来覆盖。
======

input
12
6 5 2 2 5 3
4 1 2 1 4 1
1 4 1 3 1 1
5 5 1 4 5 2
4 4 1 1 4 4
10 10 1 6 10 8
10 10 2 6 10 7
10 10 9 1 8 1
10 10 8 1 10 2
10 10 1 1 2 1
10 10 1 3 4 1
10 10 3 1 1 1
output
Alice
Bob
Draw
Draw
Draw
Alice
Draw
Draw
Bob
Alice
Alice
Draw
 */