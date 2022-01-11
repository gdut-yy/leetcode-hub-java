package p1621;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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
            int[] res = solution2(n, nums);
            for (int re : res) {
                writer.write(String.valueOf(re).concat(System.lineSeparator()));
            }
        }
        writer.close();
        reader.close();
    }

    private static int[] solution2(int n, int[][] nums) {
        int[] left = nums[0];
        int[] right = nums[0];

        int[] res = new int[n];
        res[0] = nums[0][2];
        for (int i = 1; i < n; i++) {
            int[] cur = nums[i];

            // 更新最小值
            if (cur[0] < left[0]) {
                left = cur;
            } else if (cur[0] == left[0]) {
                if (cur[2] < left[2]) {
                    left = cur;
                } else if (cur[2] == left[2]) {
                    if (cur[1] > left[1]) {
                        left = cur;
                    }
                }
            }

            // 更新最大值
            if (cur[1] > right[1]) {
                right = cur;
            } else if (cur[1] == right[1]) {
                if (cur[2] < right[2]) {
                    right = cur;
                } else if (cur[2] == right[2]) {
                    if (cur[0] < right[0]) {
                        right = cur;
                    }
                }
            }

            // 统计
            if (left[0] == right[0] && left[1] == right[1]) {
                res[i] = Math.min(left[2], right[2]);
            } else if (left[0] == right[0]) {
                res[i] = right[2];
            } else if (left[1] == right[1]) {
                res[i] = left[2];
            } else {
                res[i] = left[2] + right[2];
            }
        }
        return res;
    }

    private static int[] solution(int n, int[][] nums) {
        List<Integer> minIdxList = new ArrayList<>();
        List<Integer> maxIdxList = new ArrayList<>();
        minIdxList.add(0);
        maxIdxList.add(0);
        int min = nums[0][0];
        int max = nums[0][1];

        int[] res = new int[n];
        res[0] = nums[0][2];
        for (int i = 1; i < n; i++) {
            // 更新最小值
            if (nums[i][0] < min) {
                min = nums[i][0];
                minIdxList.clear();
                minIdxList.add(i);
            } else if (nums[i][0] == min) {
                minIdxList.add(i);
            }

            // 更新最大值
            if (nums[i][1] > max) {
                max = nums[i][1];
                maxIdxList.clear();
                maxIdxList.add(i);
            } else if (nums[i][1] == max) {
                maxIdxList.add(i);
            }

            int cost = Integer.MAX_VALUE;
            for (int minIdx : minIdxList) {
                for (int maxIdx : maxIdxList) {
                    if (minIdx == maxIdx) {
                        cost = Math.min(cost, nums[minIdx][2]);
                    } else {
                        cost = Math.min(cost, nums[minIdx][2] + nums[maxIdx][2]);
                    }
                }
            }
            res[i] = cost;

        }
        return res;
    }
}
/*
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



1
6
1 4 4
5 8 9
7 8 7
2 10 252
1 11 271
1 10 1

 */