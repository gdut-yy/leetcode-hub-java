package p1841;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1841A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        return n >= 5 ? "Alice" : "Bob";
    }
}
/*
Educational Codeforces Round 150 (Rated for Div. 2) https://www.bilibili.com/video/BV1y8411Z7GC/
A. Game with Board
https://codeforces.com/contest/1841/problem/A

题目大意：
爱丽丝和鲍勃玩一个游戏。他们有黑板；一开始，上面写了 n 个整数，每个整数都等于 1。
爱丽丝和鲍勃轮流;爱丽丝先走。在他们的回合中，玩家必须在棋盘上选择几个(至少两个)相等的整数，擦除它们并写下一个等于它们之和的新整数。
例如，如果棋盘上当前包含整数{1,1,2,2,2,3}，那么以下移动是可能的:
- 选择两个等于 1 的整数，擦除，写一个整数 2，则棋盘变成{2,2,2,2,3};
- 选择两个等于 2 的整数，擦除，写一个整数 4，则板子变成{1,1,2,3,4};
- 选择三个等于 2 的整数，擦除它们并写入一个整数 6，则棋盘变成{1,1,3,6}。
如果一个玩家不能移动(棋盘上的所有整数都是不同的)，那么这个玩家就赢得了游戏。
如果两个玩家都玩得很好，决定谁赢。

找规律。无法操作的玩家胜利
n >= 5 时，总能留下 2 个 1 给 Bob，Alice 必胜。
======

input
2
3
6
output
Bob
Alice

1
99
Alice
 */
