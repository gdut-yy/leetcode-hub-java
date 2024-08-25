package p489;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF489C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, int s) {
        // 特判
        if (n == 1 && s == 0) {
            return "0 0";
        }
        if (n * 9 < s || s == 0) {
            return "-1 -1";
        }

        // 最小值
        char[] min = new char[n];
        Arrays.fill(min, '0');
        min[0] = '1';
        int s1 = s - 1;
        for (int i = n - 1; i >= 1; i--) {
            // 0 ~ 9
            int d = Math.min(s1, 9);
            s1 -= d;
            min[i] += d;
        }
        min[0] += s1;

        // 最大值
        char[] max = new char[n];
        Arrays.fill(max, '0');
        int s2 = s;
        for (int i = 0; i < n; i++) {
            // 0 ~ 9
            int d = Math.min(s2, 9);
            s2 -= d;
            max[i] += d;
        }
        return new String(min) + " " + new String(max);
    }
}
/*
C. Given Length and Sum of Digits...
https://codeforces.com/contest/489/problem/C

灵茶の试炼 2023-05-01
题目大意：
输入 m(1≤m≤100) 和 s(0≤s≤900)。
构造长为 m 的非负整数 x，无前导零，且数位和等于 s。
输出 x 的最小值和最大值。如果没有这样的 x，输出 -1 -1。

rating 1400
https://codeforces.com/contest/489/submission/203167530
分类讨论。
最小的类似 1000069999
最大的类似 9999700000
具体细节见代码。
======

input
2 15
output
69 96

input
3 0
output
-1 -1
 */
