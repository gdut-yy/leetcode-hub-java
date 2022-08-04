package p1692;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1692E {
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
        String[] line2s = line2.split(" ");
        int n = Integer.parseInt(line1s[0]);
        int s = Integer.parseInt(line1s[1]);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line2s[i]);
        }

        // 前缀和
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + a[i];
        }
        // 无解
        if (preSum[n] < s) {
            return "-1";
        }

        // 双指针
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            while (right < n && preSum[right + 1] - preSum[left] <= s) {
                right++;
            }
            max = Math.max(max, right - left);
            left++;
        }
        return String.valueOf(n - max);
    }
}
/*
E. Binary Deque
https://codeforces.com/contest/1692/problem/E

题目大意：
给定整数 n,s 和长度为 n 的数组 a，每次操作可以删除数组第一个元素或最后一个元素。求使数组和等于 s 的最少操作次数，如果无法等于 s，输出 -1.

前缀和 + 双指针。
======

input
7
3 1
1 0 0
3 1
1 1 0
9 3
0 1 0 1 1 1 0 0 1
6 4
1 1 1 1 1 1
5 1
0 0 1 1 0
16 2
1 1 0 0 1 0 0 1 1 0 0 0 0 0 1 1
6 3
1 0 1 0 0 0

output
0
1
3
2
2
7
-1
 */