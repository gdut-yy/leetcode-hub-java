package p1607;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainA {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String keyboard = reader.readLine();
            String word = reader.readLine();
            writer.write(solution(keyboard, word).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String keyboard, String word) {
        // 长度 26 数组模拟 HashMap
        int[] dict = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            dict[keyboard.charAt(i) - 'a'] = i;
        }
        int res = 0;
        int preIdx = dict[word.charAt(0) - 'a'];
        for (int i = 1; i < word.length(); i++) {
            res += Math.abs(dict[word.charAt(i) - 'a'] - preIdx);
            preIdx = dict[word.charAt(i) - 'a'];
        }
        return String.valueOf(res);
    }
}
/*
Codeforces Round #753 (Div. 3)
A. Linear Keyboard
https://codeforces.com/contest/1607/problem/A

题目大意：
给定字符串 keyboard 和 word，keyboard 代表一个键盘字母顺序，求使用该键盘输出 word 经过的距离。

模拟即可。
======

input
5
abcdefghijklmnopqrstuvwxyz
hello
abcdefghijklmnopqrstuvwxyz
i
abcdefghijklmnopqrstuvwxyz
codeforces
qwertyuiopasdfghjklzxcvbnm
qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq
qwertyuiopasdfghjklzxcvbnm
abacaba

output
13
0
68
0
74
 */