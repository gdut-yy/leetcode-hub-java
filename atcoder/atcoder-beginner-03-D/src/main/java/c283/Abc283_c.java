package c283;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc283_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        int cnt = 0;
        while (s.length() > 0) {
            if (s.endsWith("00")) {
                s = s.substring(0, s.length() - 2);
            } else {
                s = s.substring(0, s.length() - 1);
            }
            cnt++;
        }
        return String.valueOf(cnt);
    }
}
/*
C - Cash Register
https://atcoder.jp/contests/abc283/tasks/abc283_c

题目大意：
高桥是一名收银员。
有一台有 11 个键的收银机:00、0、1、2、3、4、5、6、7、8 和 9。收银机最初显示 0。每当他键入 00 键时，显示的数字就会乘以 100;每当他输入其中一个时，显示的数字乘以 10，然后加上写在键上的数字。
高桥希望收银机显示一个整数 S。至少需要敲击多少键才能显示 S？

暴力。
======

Input 1
40004
Output 1
4

Input 2
1355506027
Output 2
10

Input 3
10888869450418352160768000001
Output 3
27
 */