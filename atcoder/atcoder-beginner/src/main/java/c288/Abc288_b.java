package c288;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc288_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        System.out.println(solve(k, s));
    }

    private static String solve(int k, String[] s) {
        Arrays.sort(s, 0, k);
        String[] ans = new String[k];
        for (int i = 0; i < k; i++) {
            ans[i] = s[i];
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
B - Qualification Contest
https://atcoder.jp/contests/abc288/tasks/abc288_b

题目大意：
有一次比赛有 N 人参加。排名第 i 位的选手的绰号是“Si”。
按字典顺序打印前 K 名参与者的昵称。

模拟。
======

Input 1
5 3
abc
aaaaa
xyz
a
def
Output 1
aaaaa
abc
xyz

Input 2
4 4
z
zyx
zzz
rbg
Output 2
rbg
z
zyx
zzz

Input 3
3 1
abc
arc
agc
Output 3
abc
 */