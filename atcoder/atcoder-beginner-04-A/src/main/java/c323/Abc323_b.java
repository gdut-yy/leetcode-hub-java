package c323;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc323_b {
    static int n;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new char[n][n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[][] score = new int[n][2];
        for (int i = 0; i < n; i++) {
            score[i][1] = i;
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'o') {
                    score[i][0]++;
                }
            }
        }
        Arrays.sort(score, (o1, o2) -> {
            if (o2[0] == o1[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o2[0], o1[0]);
        });

        List<Integer> list = Arrays.stream(score).map(o -> o[1] + 1).toList();
//        Collections.reverse(list);
        return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B - Round-Robin Tournament
https://atcoder.jp/contests/abc323/tasks/abc323_b

题目大意：
有 N 个从 1 到 N 的球员，他们参加了循环赛。在这场比赛中，每场比赛都有一名选手赢，另一名选手输。
匹配的结果以 N 个字符串 s1, s2,...,sn 的形式给出，每个字符串长度为 N，格式如下:
- 如果 i != j，则 si 的第 j 个字符为 o 或 x。o 表示玩家 i 战胜了玩家 j, x 表示玩家 i 输给了玩家 j。
- 如果 i = j，则 si 的第 j 个字符是-。
获得更多胜利的玩家排名更高。如果两名玩家的获胜次数相同，则人数较少的玩家排名较高。按排名降序报告 N 个玩家的人数。

模拟
======

Input 1
3
-xx
o-x
oo-
Output 1
3 2 1

Input 2
7
-oxoxox
x-xxxox
oo-xoox
xoo-ooo
ooxx-ox
xxxxx-x
oooxoo-
Output 2
4 7 3 1 5 2 6
 */
