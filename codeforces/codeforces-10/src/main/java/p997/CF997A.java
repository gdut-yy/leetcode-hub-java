package p997;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF997A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, x, y, s));
    }

    private static String solve(int n, int x, int y, String s) {
        char pre = '1';
        long cnt = 0L;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && pre != '0') {
                cnt++;
            }
            pre = s.charAt(i);
        }

        if (cnt == 0) {
            return "0";
        }
        long res = (x < y) ? (cnt - 1) * x + y : cnt * y;
        return String.valueOf(res);
    }
}
/*
A. Convert to Ones
https://codeforces.com/contest/997/problem/A

灵茶の试炼 2023-05-09
题目大意：
输入 n(1≤n≤3e5) x(0≤x≤1e9) y(0≤y≤1e9) 和长为 n 的 01 字符串 s。
你可以执行任意次操作，每次选择其中一种操作执行。
1. 花费 x，reverse s 的一个子串，例如 1110 -> 0111。
2. 花费 y，flip s 的一个子串，例如 1110 -> 0001。
目标：使 s 中只有 1。
输出最少花费。

rating 1500
https://codeforces.com/contest/997/submission/205172377
如果没有 0，输出 0。
如果 x < y，那么可以把所有 0 通过多次 reverse 操作聚在一起，然后再操作一次 flip。
reverse 的操作次数就是 0 组的个数减一。例如 001101000 中有三个 0 组，需要两次 reverse。
如果 x >= y，那么把每个 0 组 flip 掉即可。
======

input
5 1 10
01000
output
11

input
5 10 1
01000
output
2

input
7 2 3
1111111
output
0
 */
