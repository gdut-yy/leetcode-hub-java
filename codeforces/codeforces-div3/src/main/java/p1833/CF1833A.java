package p1833;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1833A {
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
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            set.add(s.substring(i, i + 2));
        }
        return String.valueOf(set.size());
    }
}
/*
https://www.bilibili.com/video/BV1VV4y167b6/

Codeforces Round 874 (Div. 3)
A. Musical Puzzle
https://codeforces.com/contest/1833/problem/A

题目大意：
弗拉德决定用他的吉他创作一段旋律。让我们将旋律表示为一系列音符，对应于字符 "a"、"b"、"c"、"d"、"e"、"f" 和 "g"。
然而，弗拉德在弹吉他方面不是很有经验，一次只能准确地记录两个音符。Vlad 想要获得旋律 s，为了做到这一点，他可以将录制的旋律合并在一起。在这种情况下，第一个旋律的最后一个音必须与第二个旋律的第一个音相匹配。
例如，如果 Vlad 录制了两个旋律 "ab" 和 "ba"，他可以将它们合并在一起得到旋律 "aba"，然后将结果与 "ab" 合并得到 "abab"。
帮助 Vlad 确定他需要记录的由两个音符组成的旋律的最小数量，以获得旋律 s。

哈希表 模拟。
======

input
5
4
abab
7
abacaba
6
aaaaaa
7
abcdefg
5
babdd
output
2
4
1
6
4
 */
