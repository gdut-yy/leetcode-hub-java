package c324;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc324_c {
    static int n;
    static String t;
    static String[] ss;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        t = scanner.next();
        ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isOneEditDistance(t, ss[i])) {
                ans.add(i + 1);
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    static boolean isOneEditDistance(String s, String t) {
        int n = s.length(), m = t.length();
        if (Math.abs(n - m) > 1) return false;
        int choice = 1;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) != t.charAt(j)) {
                choice--;
                if (n == m) {
                    i++;
                    j++;
                } else if (n < m) {
                    j++;
                } else {
                    i++;
                }
            } else {
                i++;
                j++;
            }
            if (choice < 0) return false;
        }
        return true;
    }
}
/*
C - Error Correction
https://atcoder.jp/contests/abc324/tasks/abc324_c

题目大意：
高桥向青木发送了一个由小写英文字母组成的字符串 T。结果，青木收到了一个由小写英文字母组成的字符串 T'。
T' 可能是由 T 改变而来的。具体来说，我们知道以下四种情况中只有一种是成立的。
- T' = T。
- T' 是通过在 T 的一个位置(可能是开头和结尾)插入一个小写英文字母获得的字符串。
- T' 是通过从 T 中删除一个字符而获得的字符串。
- T' 是将 T 中的一个字符修改为另一个小写英文字母后得到的字符串。
给你青木收到的字符串 T '和 N 个由小写英文字母组成的字符串 s1, s2,..., sn。找出 s1 s2 ... sn 中所有能等于 Takahashi 发送的字符串 T 的字符串。

相似题目: $161. 相隔为 1 的编辑距离
https://leetcode.cn/problems/one-edit-distance/
======

Input 1
5 ababc
ababc
babc
abacbc
abdbc
abbac
Output 1
4
1 2 3 4

Input 2
1 aoki
takahashi
Output 2
0

Input 3
9 atcoder
atoder
atcode
athqcoder
atcoder
tacoder
jttcoder
atoder
atceoder
atcoer
Output 3
6
1 2 4 7 8 9
 */
