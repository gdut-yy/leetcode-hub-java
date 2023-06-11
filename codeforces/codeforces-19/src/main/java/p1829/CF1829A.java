package p1829;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1829A {
    private static final String CODEFORCES = "codeforces";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (s.charAt(i) != CODEFORCES.charAt(i)) {
                cnt++;
            }
        }
        return String.valueOf(cnt);
    }
}
/*
Codeforces Round 871 (Div. 4)
A. Love Story
https://codeforces.com/contest/1829/problem/A

题目大意：
Timur 喜欢代码力。这就是为什么他有一个长度为 10 的字符串 s，只包含小写的拉丁字母。Timur 想知道字符串 s 与字符串“codeforces”有多少个索引不同。
例如，字符串 s= "coolforsez"与"codeforces"在 4 个索引上不同，以粗体显示。
帮助 Timur 找出字符串 s 与“codeforces”不同的索引数。
注意，不能对字符串 s 中的字符重新排序。

枚举。
======

input
5
coolforsez
cadafurcie
codeforces
paiuforces
forcescode
output
4
5
0
4
9
 */

