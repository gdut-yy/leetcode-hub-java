package c304;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc304_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String[] s = new String[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, s, a));
    }

    private static String solve(int n, String[] s, int[] a) {
        int minIdx = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < a[minIdx]) {
                minIdx = i;
            }
        }
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = s[(i + minIdx) % n];
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
A - First Player
https://atcoder.jp/contests/abc304/tasks/abc304_a

题目大意：
有 N 个人，编号为 1、2、…、N，按顺时针的顺序围坐在一张圆桌周围。特别是，第 1 个人顺时针方向坐在第 N 个人旁边。
对于每个 i=1,2,...,N，人 i 的名字是 si，年龄是 ai。在这里，没有两个人的名字相同或年龄相同。
从最年轻的人开始，按座位的顺时针顺序打印出所有 N 个人的名字。

模拟。循环数组
======

Input 1
5
alice 31
bob 41
carol 5
dave 92
ellen 65
Output 1
carol
dave
ellen
alice
bob

Input 2
2
takahashi 1000000000
aoki 999999999
Output 2
aoki
takahashi
 */