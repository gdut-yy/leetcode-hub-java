package p1593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class MainC {
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
        int[] nums = new int[k];
        String[] line2s = line2.split(" ");
        for (int j = 0; j < k; j++) {
            nums[j] = Integer.parseInt(line2s[j]);
        }

        Arrays.sort(nums);
        int cnt = 0;
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (cnt + n - nums[i] < n) {
                cnt += n - nums[i];
                res++;
            } else {
                break;
            }
        }
        return String.valueOf(res);
    }
}
/*
C. Save More Mice
https://codeforces.com/contest/1593/problem/C

题目大意：
给出正整数 n,k 和 k 个正整数。猫位于 0，洞位于 n，k只老鼠，第 i 只老鼠位置 ki。求能够到达洞而不被吃掉的最大老鼠数量

TODO
======

input
3
10 6
8 7 5 4 9 4
2 8
1 1 1 1 1 1 1 1
12 11
1 2 3 4 5 6 7 8 9 10 11

output
3
1
4
 */