package p1722;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1722B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String s1 = scanner.next();
            String s2 = scanner.next();
            System.out.println(solve(n, s1, s2));
        }
    }

    private static String solve(int n, String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < n; i++) {
            chars1[i] = (chars1[i] == 'B') ? 'G' : chars1[i];
            chars2[i] = (chars2[i] == 'B') ? 'G' : chars2[i];
        }
        return Arrays.equals(chars1, chars2) ? "YES" : "NO";
    }
}
/*
B. Colourblindness
https://codeforces.com/contest/1722/problem/B

题目大意：
给定整数 n 和两个长度为 n 的字符串 s1、s2，每个字符都是R、G或B，分别代表一个红色、绿色或蓝色，判断色盲（不能区分绿色和蓝色），是否会认为相等。

模拟。将 B 全部转为 G 后判等即可。
======

input
6
2
RG
RB
4
GRBG
GBGB
5
GGGGG
BBBBB
7
BBBBBBB
RRRRRRR
8
RGBRRGBR
RGGRRBGR
1
G
G

output
YES
NO
YES
NO
YES
YES
 */
