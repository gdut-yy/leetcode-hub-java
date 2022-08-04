package p1616;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CF1616A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            writer.write(solution(n, line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, String line) {
        String[] lines = line.split(" ");
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Math.abs(Integer.parseInt(lines[i]));
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getKey() == 0) {
                cnt++;
            } else {
                if (entry.getValue() > 1) {
                    cnt += 2;
                } else {
                    cnt++;
                }
            }
        }
        return String.valueOf(cnt);
    }
}
/*
Good Bye 2021: 2022 is NEAR
A. Integer Diversity
https://codeforces.com/contest/1616/problem/A

题目大意：
给出整数 n 和长度为 n 的数组，可以将任意元素 x 取反，求不同元素的最大数量是多少

统计每个元素对应的绝对值的频次，正整数均能表示成 x 和 -x 两个不同的元素，求和即可。
======

input
3
4
1 1 2 2
3
1 2 3
2
0 0

output
4
3
1
 */