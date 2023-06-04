package c282;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc282_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }

        solve(n, m, s);
    }

    private static void solve(int n, int m, String[] s) {
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i].charAt(j) == 'o') {
                    mask[i] |= 1 << j;
                }
            }
        }
        int cnt = 0;
        int target = (1 << m) - 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((mask[i] | mask[j]) == target) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
/*
B - Let's Get a Perfect Score
https://atcoder.jp/contests/abc282/tasks/abc282_b

题目大意：
N 个参与者，编号为 1 到 N，将参加一个竞赛，有 M 个问题，编号为 1 到 M。
对于 1 到 N 之间的整数 i 和 1 到 M 之间的整数 j，如果 s1 的第 j 个字符是 0，参与者 i 可以解决问题 j，如果该字符是 x，则无法解决问题 j。
参与者必须两人一组。打印一组可以共同解决所有 M 个问题的参与者的方法个数。
更正式地说，打印出满足 1≤x<y≤N 的整数对(x,y)的个数，使得对于 1 和 M 之间的任意整数 j，参与者 x 和参与者 y 中至少有一个可以解决问题 j。
N 为 2 ~ 30 之间的整数。
M 是 1 到 30 之间的整数。
s1 是一个长度为 M 的字符串，由 0 和 x 组成。

位运算。
======

Input 1
5 5
ooooo
oooxx
xxooo
oxoxo
xxxxx
Output 1
5

Input 2
3 2
ox
xo
xx
Output 2
1

Input 3
2 4
xxxx
oxox
Output 3
0
 */