package c290;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc290_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, k, s));
    }

    private static String solve(int n, int k, String s) {
        for (int i = 0; i < n; i++) {
            if (k == 0) {
                return s.substring(0, i) + "x".repeat(n - i);
            }
            if (s.charAt(i) == 'o') {
                k--;
            }
        }
        return s;
    }
}
/*
B - Qual B
https://atcoder.jp/contests/abc290/tasks/abc290_b

题目大意：
在一次程序设计比赛的资格赛中，有 N 名选手。所有的参赛者都有不同的等级。
给你一个长度为 N 的字符串 S，代表选手是否想参加最后一轮。具体地说,
- 如果 S 的第 i 个字符为 0，则资格赛排名第 i 位的选手希望参加决赛;
- 如果 S 的第 i 个字符是 x，则该选手在资格赛中排名第 i 位，不希望参加决赛。
在想要参加决赛的选手中，排名最低的 K 名选手进入决赛。
打印长度为 N 的字符串 T，满足以下条件:
- 资格赛第 1 名晋级决赛，第 1 个字母 T 为 0;
- 如果在资格赛中排名第 i 位的选手没有进入决赛，则 T 的第 i 个字符为 x。

字符串替换保留前 k 个 'o'，其余替换为 'x'
======

Input 1
10 3
oxxoxooxox
Output 1
oxxoxoxxxx
 */