package p1619;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1619A {
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
        int len = line.length();
        if (len % 2 == 1) {
            return "NO";
        }
        int halfLen = len / 2;
        if (line.substring(0, halfLen).equals(line.substring(halfLen))) {
            return "YES";
        }
        return "NO";
    }
}
/*
Codeforces Round #762 (Div. 3)
A. Square String?
https://codeforces.com/contest/1619/problem/A

10
a
aa
aaa
aaaa
abab
abcabc
abacaba
xxyy
xyyx
xyxy

NO
YES
NO
YES
YES
YES
NO
NO
NO
YES

 */