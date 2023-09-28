package c321;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc321_a {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;
        for (int i = 1; i < n; i++) {
            if (s[i - 1] <= s[i]) {
                return "No";
            }
        }
        return "Yes";
    }
}
/*
A - 321-like Checker
https://atcoder.jp/contests/abc321/tasks/abc321_a

题目大意：
当正整数 x 满足以下条件时，称为类 321 数。
- x 的数字从上到下严格递减。
- 换句话说，如果 x 有 d 位数字，那么对于每一个整数 i，它满足以下条件，
  - 使得 1≤i<d:(x 的第 i 位数字)> (x 的第 i+1)位数字)。
注意，所有的一位数正整数都是类 321 数。
例如，321、96410 和 1 是类似 321 的数字，而 123、2109 和 86411 不是。
你有 N 个输入。如果 N 是类似 321 的数字，打印“是”，否则打印“否”。

======

Input 1
321
Output 1
Yes

Input 2
123
Output 2
No

Input 3
1
Output 3
Yes

Input 4
86411
Output 4
No
 */
