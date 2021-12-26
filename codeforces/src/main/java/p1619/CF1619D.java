package p1619;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;

public class CF1619D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            reader.readLine();
            String[] line1 = reader.readLine().split(" ");
            // m 家商店
            int m = Integer.parseInt(line1[0]);
            // n 个好友
            int n = Integer.parseInt(line1[1]);
            int[][] nums = new int[m][n];
            for (int j = 0; j < m; j++) {
                String[] lineJ = reader.readLine().split(" ");
                for (int k = 0; k < n; k++) {
                    nums[j][k] = Integer.parseInt(lineJ[k]);
                }
            }
            writer.write(solution(m, n, nums).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int m, int n, int[][] nums) {
        // 二分
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] num : nums) {
            for (int i : num) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        int left = min;
        int right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T] checkMid(mid) == T
            // ----------------------^
            if (!checkMid(m, n, nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 右边界二分
        return String.valueOf(left - 1);
    }

    private static boolean checkMid(int m, int n, int[][] nums, int mid) {
        // 访问最多 n−1 家商店，必然至少 2 个朋友在同 1 家商店购物
        boolean gt1 = false;
        BitSet bitSet = new BitSet(n);
        for (int i = 0; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                // nums[i][j] 表示在商店 i 购买 j 朋友的快乐值
                if (nums[i][j] >= mid) {
                    bitSet.set(j);
                    cnt++;
                    if (cnt > 1) {
                        gt1 = true;
                    }
                }
            }
        }
        return gt1 && bitSet.cardinality() == n;
    }
}
/*
D. New Year's Problem
https://codeforces.com/contest/1619/problem/D

题目大意：
给出 n 和 m，以及 n*m 的矩阵。定义最多选择其中 n-1 行，使得 min(p[i][j]) 的值最大。

非常巧妙的二分以及容斥思路。
由于 最多选择其中 n-1 行，因此必然有两个 j 在同一行中。
同时结果存在单调性，二分去找到最大值即可。
======

input
5

2 2
1 2
3 4

4 3
1 3 1
3 1 1
1 2 2
1 1 3

2 3
5 3 4
2 5 1

4 2
7 9
8 1
9 6
10 8

2 4
6 5 2 1
7 9 7 2

output
3
2
4
8
2
 */