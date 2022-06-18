package p1692;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1692F {
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

        int[] cntArr = new int[10];
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(line2s[i]);
            cntArr[a % 10]++;
        }

        int[] targets = {3, 13, 23};
        for (int i = 0; i < 10; i++) {
            if (cntArr[i] > 0) {
                cntArr[i]--;
                for (int j = 0; j < 10; j++) {
                    if (cntArr[j] > 0) {
                        cntArr[j]--;
                        for (int target : targets) {
                            int want = target - i - j;
                            if (want >= 0 && want < 10 && cntArr[want] > 0) {
                                return "YES";
                            }
                        }
                        cntArr[j]++;
                    }
                }
                cntArr[i]++;
            }
        }
        return "NO";
    }
}
/*
F. 3SUM
https://codeforces.com/contest/1692/problem/F

题目大意：
给定整数 n 和长度为 n 的数组 a，判断是否存在三个不同的下标 i,j,k 使得 a[i] + a[j] + a[k] 以 3 结尾。

本题 n 范围为 2*10^5，三层循环 TLE，哪怕用双指针进行优化时间复杂度 O(n^2) 也无法通过。
考虑取余，以 3 结尾只可能是 3,13,23 压缩到余数 0~9 后进行统计。时间复杂度 O(n) 常数最大为 30
======

input
6
4
20 22 19 84
4
1 11 1 2022
4
1100 1100 1100 1111
5
12 34 56 78 90
4
1 9 8 4
6
16 38 94 25 18 99

output
YES
YES
NO
NO
YES
YES
 */