package p1703;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CF1703F {
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
        List<Integer> iList = new ArrayList<>();
        List<Integer> ajList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int ai = Integer.parseInt(line2s[i]);
            // ai < i
            // aj < j
            if (ai < i + 1) {
                iList.add(i + 1);
                ajList.add(ai);
            }
        }

        Collections.sort(ajList);
        long sum = 0;
        // 双指针
        int i = 0;
        int j = 0;
        int size = ajList.size();
        while (j < size) {
            while (j < ajList.size() && ajList.get(j) <= iList.get(i)) {
                j++;
            }
            sum += size - j;
            i++;
        }
        return String.valueOf(sum);
    }
}
/*
F. Yet Another Problem About Pairs Satisfying an Inequality
https://codeforces.com/contest/1703/problem/F

题目大意：
给定整数 n 和长度为 n 的数组 a，求 ai < i < aj < j 的索引对。

首先预处理 ai < j，缩小范围，再对每个 i 双指针找符合的 aj
======

input
5
8
1 1 2 3 8 2 1 4
2
1 2
10
0 2 1 6 3 4 1 2 8 3
2
1 1000000000
3
0 1000000000 2

output
3
0
10
0
1
 */