package p1788;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1788B {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Integer>[] a = new ArrayList[2];
        Arrays.setAll(a, e -> new ArrayList<>());
        int j = 0;
        for (char c : s) {
            int b = c - '0';
            a[0].add(b / 2);
            a[1].add(b / 2);
            if (c % 2 > 0) {
                // a[j][len(a[j])-1]++
                a[j].set(a[0].size() - 1, a[0].getLast() + 1);
                j ^= 1;
            }
        }
        while (a[1].size() > 1 && a[1].getFirst() == 0) {
            a[1].removeFirst();
        }
        return a[0].stream().map(String::valueOf).collect(Collectors.joining()) +
                " " + a[1].stream().map(String::valueOf).collect(Collectors.joining());
    }
}
/*
B. Sum of Two Numbers
https://codeforces.com/contest/1788/problem/B

灵茶の试炼 2025-02-17
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 n(1≤n≤1e9)。
定义 digsum(a) 表示 a 的数位和。
构造两个非负整数 x 和 y，满足 x + y = n 且 |digsum(x) - digsum(y)| <= 1。
可以证明，这样的 x 和 y 一定存在。

rating 1100
每个数位独立考虑，一分为二。
例如 246 分成两个 123。
例如 555 分成 323 和 232，也就是先分成 222 和 222，然后把奇数数位交替 +1 分给两个数的相应数位。
代码 https://codeforces.com/contest/1788/submission/304478372
代码备份（洛谷）
======

Input
5
1
161
67
1206
19
Output
1 0
67 94
60 7
1138 68
14 5
 */
