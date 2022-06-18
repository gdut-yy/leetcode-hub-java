package p1692;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CF1692B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            writer.write(solution(line1, line2).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line1, String line2) {
        int n = Integer.parseInt(line1);
        String[] line2s = line2.split(" ");

        // 统计频次
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(line2s[i]);
            cntMap.put(a, cntMap.getOrDefault(a, 0) + 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() > 1) {
                cnt += entry.getValue() - 1;
            }
        }
        // 数论向上取整法
        int times = (cnt + 1) / 2;
        return String.valueOf(n - 2 * times);
    }
}
/*
B. All Distinct
https://codeforces.com/contest/1692/problem/B

题目大意：
给定整数 n 和长度为 n 的数组 a，每次操作可以选择两个不同的下标去除 a[i] a[j]，使数组所有元素不重复且操作次数最少，返回最终数组最终长度。

贪心。
======

input
4
6
2 2 2 3 3 3
5
9 1 9 9 1
4
15 16 16 15
4
10 100 1000 10000

output
2
1
2
4
 */