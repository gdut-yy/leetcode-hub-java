package p1729;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1729B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            String t = scanner.next();
            System.out.println(solve(n, t));
        }
    }

    private static String solve(int n, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (t.charAt(i) == '0') {
                int num = Integer.parseInt(t.substring(i - 2, i));
                char ch = (char) (num - 1 + 'a');
                stringBuilder.append(ch);
                i -= 2;
            } else {
                int num = t.charAt(i) - '0';
                char ch = (char) (num - 1 + 'a');
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.reverse().toString();
    }
}
/*
B. Decode String
https://codeforces.com/contest/1729/problem/B

题目大意：
给定整数 n 和长为 n 的字符串 s。'c' 表示 3，'o' 表示 15。如果字母数是个位数(小于 10)，就直接写出来；如果字母数字是两位数(大于或等于 10)，则将其写出来并在后面加上数字 0。
通过编码后的字符串求原始字符串。

模拟，从右到左逆操作即可以求出原串。
======

input
9
6
315045
4
1100
7
1213121
6
120120
18
315045615018035190
7
1111110
7
1111100
5
11111
4
2606

output
code
aj
abacaba
ll
codeforces
aaaak
aaaaj
aaaaa
zf
 */