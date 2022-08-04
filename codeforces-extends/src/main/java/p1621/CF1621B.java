package p1621;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1621B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] nums = new int[n][3];
            for (int j = 0; j < n; j++) {
                String[] lines = reader.readLine().split(" ");
                nums[j][0] = Integer.parseInt(lines[0]);
                nums[j][1] = Integer.parseInt(lines[1]);
                nums[j][2] = Integer.parseInt(lines[2]);
            }
            int[] res = solution(n, nums);
            for (int re : res) {
                writer.write(String.valueOf(re).concat(System.lineSeparator()));
            }
        }
        writer.close();
        reader.close();
    }

    private static int[] solution(int n, int[][] nums) {
        // 三个指针，left 指向最小花费的最小 l 所在的 idx，right 指向最小花费的最大 r 所在的 idx，longest 指向最小花费的最长 r-l 所在的 idx
        int left = 0;
        int right = 0;
        int longest = 0;

        int[] res = new int[n];
        res[0] = nums[0][2];
        for (int i = 1; i < n; i++) {
            int[] cur = nums[i];
            int minL = nums[left][0];
            int maxR = nums[right][1];
            int longestLen = nums[longest][1] - nums[longest][0];

            // 更新 left
            if ((cur[0] < minL) || (cur[0] == minL && cur[2] < nums[left][2])) {
                left = i;
            }

            // 更新 right
            if ((cur[1] > maxR) || (cur[1] == maxR && cur[2] < nums[right][2])) {
                right = i;
            }

            // 更新 longest
            if ((cur[1] - cur[0] > longestLen) || (cur[1] - cur[0] == longestLen && cur[2] < nums[longest][2])) {
                longest = i;
            }

            // 更新 res[i]
            // 是否考虑 longest 行
            boolean bool = nums[right][1] - nums[left][0] == nums[longest][1] - nums[longest][0];
            if (left == right) {
                res[i] = bool ? Math.min(nums[longest][2], nums[left][2]) : nums[left][2];
            } else {
                res[i] = bool ? Math.min(nums[longest][2], nums[left][2] + nums[right][2]) : nums[left][2] + nums[right][2];
            }
        }
        return res;
    }
}
/*
B. Integers Shop
https://codeforces.com/contest/1621/problem/B

题目大意：
给出整数 n 和 n 行，第 ni 行给出整数 li,ri,ci，表示 [li,ri] 耗费 ci。求从 1 到 n 行，组成最大区间的最小花费

贪心。顺序遍历，记录当前 最小的 l，最大的  r，以及最长段 r-l 及对应的最小花费。结果可能由 1~2 段组成。
======

input
3
2
2 4 20
7 8 22
2
5 11 42
5 11 42
6
1 4 4
5 8 9
7 8 7
2 10 252
1 11 271
1 10 1

output
20
42
42
42
4
13
11
256
271
271
 */