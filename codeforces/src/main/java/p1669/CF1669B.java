package p1669;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CF1669B {
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
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (String s : lines) {
            int a = Integer.parseInt(s);
            cntMap.put(a, cntMap.getOrDefault(a, 0) + 1);
            if (cntMap.get(a) == 3) {
                return String.valueOf(a);
            }
        }
        return "-1";
    }
}
/*
B. Triple
https://codeforces.com/contest/1669/problem/B

题目大意：
给定长度为 n 的数组 a，求出现次数最少为 3 次的数，如果没有，返回 -1

HashMap 统计频次即可
======

input
7
1
1
3
2 2 2
7
2 2 3 3 4 2 2
8
1 4 3 4 3 2 4 1
9
1 1 1 2 2 2 3 3 3
5
1 5 2 4 3
4
4 4 4 4

output
-1
2
2
4
3
-1
4
 */