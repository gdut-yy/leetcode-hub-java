package p1702;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class CF1702B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line = reader.readLine();
            writer.write(solution(line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line) {
        int cnt = 0;
        int k = 0;
        Set<Character> hashSet = new HashSet<>();
        for (char ch : line.toCharArray()) {
            if (!hashSet.contains(ch)) {
                k++;
                hashSet.add(ch);
                if (k > 3) {
                    cnt++;

                    k = 0;
                    hashSet.clear();
                    k++;
                    hashSet.add(ch);
                }
            }
        }
        cnt += hashSet.isEmpty() ? 0 : 1;
        return String.valueOf(cnt);
    }
}
/*
B. Polycarp Writes a String from Memory
https://codeforces.com/contest/1702/problem/B

题目大意：
给定字符串 s，每天最多只能记住3个不同的字母，问最少多少天才能记完。

滑动窗口。
======

input
6
lollipops
stringology
abracadabra
codeforces
test
f

output
2
4
3
4
1
1
 */