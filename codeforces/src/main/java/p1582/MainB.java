package p1582;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainB {
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
        int len = Integer.parseInt(line1);
        String[] line2s = line2.split(" ");
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(line2s[i]);
        }

        int cnt0 = 0;
        int cnt1 = 0;
        for (int num : nums) {
            if (num == 0) {
                cnt0++;
            } else if (num == 1) {
                cnt1++;
            }
        }
        if (cnt1 == 0) {
            return "0";
        }
        return String.valueOf((long) (Math.pow(2, cnt0) * cnt1));
    }
}
/*
B. Luntik and Subsequences
https://codeforces.com/contest/1582/problem/B

题目大意：
给出一个整数数组。数组元素和为 s，求和为 s-1 子序列的个数。

数学，显然只与数组中 0 和 1 的个数有关，如果不存在 1，则个数为 0，假设有 a 个 0，b 个 1，则结果为 b*2^a
======

input
5
5
1 2 3 4 5
2
1000 1000
2
1 0
5
3 0 2 1 1
5
2 1 0 3 0

output
1
0
2
4
4
 */