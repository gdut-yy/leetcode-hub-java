package p1669;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1669C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            writer.write(solution(line2).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line) {
        String[] lines = line.split(" ");
        int len = lines.length;

        int num0 = Integer.parseInt(lines[0]) % 2;
        int num1 = Integer.parseInt(lines[1]) % 2;
        for (int i = 0; i < len; i += 2) {
            if (Integer.parseInt(lines[i]) % 2 != num0) {
                return "NO";
            }
        }
        for (int i = 1; i < len; i += 2) {
            if (Integer.parseInt(lines[i]) % 2 != num1) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
C. Odd/Even Increments
https://codeforces.com/contest/1669/problem/C

题目大意：
给定长度为 n 的数组 a，可以奇数下标+1 或者偶数下标+1 若干次，问数组 a 最后能否奇偶相等

分别判断 奇数下标奇偶性是否一致 和 偶数下标奇偶性是否一致 即可。
======

input
4
3
1 2 1
4
2 2 2 3
4
2 2 2 2
5
1000 1 1000 1 1000

output
YES
NO
YES
YES
 */