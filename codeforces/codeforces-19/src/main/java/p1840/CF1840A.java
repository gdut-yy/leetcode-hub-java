package p1840;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1840A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (j < n) {
            j++;
            if (cs[j] == cs[i]) {
                stringBuilder.append(cs[j]);
                j++;
                i = j;
            }
        }
        return stringBuilder.toString();
    }
}
/*
Codeforces Round 878 (Div. 3) https://www.bilibili.com/video/BV1jP411B7Zg/
A. Cipher Shifer
https://codeforces.com/contest/1840/problem/A

题目大意：
有一个字符串 a(未知)，由小写拉丁字母组成，按照以下规则加密为字符串 s:
- 在字符串 a 的每个字符之后，添加任意(可能为零)数量的小写拉丁字母，与字符本身不同;
- 在每次这样的添加之后，我们补充的字符被添加。给定字符串 s，需要输出初始字符串 a。换句话说，您需要解密字符串 s。
请注意，以这种方式加密的每个字符串都是唯一解密的。
---
在第一条加密消息中，字母 a 被加密为 aba，字母 c 被加密为 cabac。
在第二个加密消息中，只有一个字母 q 被加密为 qzxcq。
在第三个加密消息中，每个字母都添加了零个字符。

双指针 模拟
======

input
3
8
abacabac
5
qzxcq
20
ccooddeeffoorrcceess
output
ac
q
codeforces
 */
