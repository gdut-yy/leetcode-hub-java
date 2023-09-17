package c320;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc320_c {
    static int m;
    static String[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        m = scanner.nextInt();
        s = new String[3];
        for (int i = 0; i < 3; i++) {
            s[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int inf = s[0].length() * 4;
        int ans = inf;
        for (int d = 0; d <= 9; d++) {
            String c = String.valueOf(d);
            if (s[0].contains(c) && s[1].contains(c) && s[2].contains(c)) {
                ans = Math.min(ans, getT(s[0], s[1], s[2], d));
                ans = Math.min(ans, getT(s[0], s[2], s[1], d));
                ans = Math.min(ans, getT(s[1], s[2], s[0], d));
                ans = Math.min(ans, getT(s[1], s[0], s[2], d));
                ans = Math.min(ans, getT(s[2], s[1], s[0], d));
                ans = Math.min(ans, getT(s[2], s[0], s[1], d));
            }
        }
        return ans == inf ? "-1" : String.valueOf(ans);
    }

    private static int getT(String s1, String s2, String s3, int d) {
        int n = s1.length();
        int i = 0;
        while (i < n * 3) {
            if (s1.charAt(i % n) - '0' == d) break;
            i++;
        }
        i++;
        while (i < n * 3) {
            if (s2.charAt(i % n) - '0' == d) break;
            i++;
        }
        i++;
        while (i < n * 3) {
            if (s3.charAt(i % n) - '0' == d) break;
            i++;
        }
        return i;
    }
}
/*
C - Slot Strategy 2 (Easy)
https://atcoder.jp/contests/abc320/tasks/abc320_c

题目大意：
> 这个问题是问题 G 的简单版本。
有一个有三个卷轴的老虎机。第 i 个卷轴上的符号排列用字符串 si 表示。这里，si 是一个长度为 M 的由数字组成的字符串。
每个卷轴都有相应的按钮。对于每一个非负整数 t, Takahashi 可以选择并按下一个按钮，或者在卷轴开始旋转后的 t 秒内什么都不做。
如果他在卷轴开始旋转后正好 t 秒按下第 i 个卷轴对应的按钮，第 i 个卷轴将停止并显示((tmodM)+1)-字符 Si。这里，tmodM 表示 t 除以 M 时的余数。
高桥希望停止所有的卷轴，这样所有显示的字符都是一样的。
找出从开始旋转到所有卷轴停止旋转所需的最短秒数，这样他的目标就实现了。
如果这是不可能的，报告这个事实。
---
高桥可以按以下方式停止每卷，以便在卷筒开始旋转 6 秒后，所有卷筒显示 8。
在卷筒开始纺纱后 0 秒按下第二卷对应的按钮。第二个卷轴停止并显示 8,s2 的((0mod10)+1=1)-st 字符。
在卷筒开始纺纱后 2 秒按下第三卷对应的按钮。第三个卷轴停止并显示 8,即 s3 的((2mod10)+1=3)-rd 字符。
在卷筒开始纺纱后 6 秒按下第一卷对应的按钮。第一个卷轴停止并显示 8,s1 的((6mod10)+1=7)第一个字符。
没有办法使卷轴在 5 秒或更短的时间内显示相同的字符，所以打印 6。

暴力
======

Input 1
10
1937458062
8124690357
2385760149
Output 1
6

Input 2
20
01234567890123456789
01234567890123456789
01234567890123456789
Output 2
20

Input 3
5
11111
22222
33333
Output 3
-1
 */