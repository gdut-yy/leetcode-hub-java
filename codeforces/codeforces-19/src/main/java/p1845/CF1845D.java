package p1845;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1845D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    // https://codeforces.com/contest/1845/submission/211448543
    private static String solve(int n, int[] a) {
        long cmax = 0;
        long cbest = 0, bestK = 0;
        long csum = 0;
        for (int i = 0; i < n; i++) {
            csum += a[i];
            cmax = Math.max(cmax, csum);
            if (cbest < cmax - csum) {
                cbest = cmax - csum;
                bestK = cmax;
            }
        }
        return String.valueOf(bestK);
    }
}
/*
D. Rating System
https://codeforces.com/contest/1845/problem/D

题目大意：
你正在为一款在线游戏开发一个评级系统。每次玩家参加比赛时，玩家的评级都会根据结果而改变。
最初，玩家的评分是 0。有 n 个匹配;在第 i 场比赛之后，评分变化等于 ai(如果 ai 为正，评分增加 ai;如果 ai 为负，评分减少 ai)。序列 a)中没有零。
这个系统还有一个额外的规则:对于一个固定的整数 k，如果玩家的评分达到 k，它就永远不会低于 k。正式地说，如果玩家的评级至少为 k，而评级改变将使其低于 k，那么评级将降至 k。
你的任务是确定 k 的值，使玩家在所有 n 场比赛后的评分是可能的最大值(在所有 k 的整数值中)。如果有多个可能的答案，您可以打印其中的任何一个。

贪心取第一个下降前的值？
最小子段和
======

input
4
4
3 -2 1 2
3
-1 -2 -1
2
4 2
7
5 1 -3 2 -1 -2 2
output
3
0
25
6
 */
