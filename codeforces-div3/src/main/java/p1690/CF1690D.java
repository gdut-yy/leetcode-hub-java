package p1690;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1690D {
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
        String[] line1s = line1.split(" ");
        int n = Integer.parseInt(line1s[0]);
        int k = Integer.parseInt(line1s[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (line2.charAt(i) == 'B') {
                nums[i] = 1;
            }
        }

        // 前缀和
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int max = 0;
        for (int i = 0; i + k <= n; i++) {
            max = Math.max(max, preSum[i + k] - preSum[i]);
        }
        return String.valueOf(k - max);
    }
}
/*
D. Black and White Stripe
https://codeforces.com/contest/1690/problem/D

题目大意：
给定整数 n,k 和长度为 n 的字符串 line，每个格子不是黑色就是白色，问最少着色多少个格子才能在条纹上有一段连续 k 个黑细胞。

贪心 + 前缀和。将黑色看作 0，白色看作 1，求固定长度为 k 的最小前缀和即为答案。
======

input
4
5 3
BBWBW
5 5
BBWBW
5 1
BBWBW
1 1
W

output
1
2
0
1
 */