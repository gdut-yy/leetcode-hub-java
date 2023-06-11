package c301;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc301_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        int cntT = 0, cntA = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'T') {
                cntT++;
            } else {
                cntA++;
            }
        }
        if (cntT == cntA) {
            return s.charAt(n - 1) == 'T' ? "A" : "T";
        }
        return cntT > cntA ? "T" : "A";
    }
}
/*
A - Overall Winner
https://atcoder.jp/contests/abc301/tasks/abc301_a

题目大意：
高桥和青木玩了 N 局。给你一个长度为 N 的字符串 S，代表这些游戏的结果。如果 S 的第 i 个字符是 T，高桥赢了第 i 局，如果是 A，青木赢了。
高桥和青木之间的总赢家是赢得更多比赛的一方。如果他们有相同的胜场数，总赢家是第一个达到这个胜场数的人。找出总冠军:Takahashi 或 Aoki。

模拟。
======

Input 1
5
TTAAT
Output 1
T

Input 2
6
ATTATA
Output 2
T

Input 3
1
A
Output 3
A
 */