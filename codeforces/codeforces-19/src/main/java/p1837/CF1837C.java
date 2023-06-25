package p1837;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1837C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        char lst = '0';
        for (int i = 0; i < n; i++) {
            if (cs[i] == '?') {
                cs[i] = lst;
            }
            lst = cs[i];
        }
        return new String(cs);
    }
}
/*
C. Best Binary String
https://codeforces.com/contest/1837/problem/C

题目大意：
给定一个字符串 s，由字符 0,1 和/或 ? 组成。我们称它为一个模式。
假设二进制字符串(每个字符为 0 或 1 的字符串)匹配模式，如果您可以替换每个字符 ? 使用 0 或 1(对于每个字符，选择是独立的)使字符串相等。例如，0010 匹配 ?01? 但是 010 和 1??, ??, ???? 不匹配。
让我们将二进制字符串的代价定义为以非降序排序字符串所需的“反转字符串的任意连续子字符串”形式的最小操作次数。
您必须在匹配给定模式的二进制字符串中找到代价最小的二进制字符串。如果有多个答案，打印其中任何一个。
---
在示例的第一个测试用例中，结果字符串的代价为 0。
在第二个测试用例中，结果字符串的代价是 2:我们可以将子字符串从第 1 个字符反转到第 5 个字符，我们得到字符串 00101。然后我们将子字符串从第 3 个字符反转到第 4 个字符，我们得到字符串 00011，它按非降序排序。

分成最少的 1 开头 0 结尾 组
======

input
4
??01?
10100
1??10?
0?1?10?10
output
00011
10100
111101
011110010

1
0?1?10?10

1
?

1
??
 */
