package p1650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CF1650C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            reader.readLine();
            String[] line1s = reader.readLine().split(" ");
            int n = Integer.parseInt(line1s[0]);
            int m = Integer.parseInt(line1s[1]);
            int[][] nums = new int[m][2];
            for (int j = 0; j < m; j++) {
                String[] lines = reader.readLine().split(" ");
                nums[j][0] = Integer.parseInt(lines[0]);
                nums[j][1] = Integer.parseInt(lines[1]);
            }
            List<String> res = solution(n, m, nums);
            for (String re : res) {
                writer.write(re.concat(System.lineSeparator()));
            }
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static List<String> solution(int n, int m, int[][] nums) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            numberMap.put(nums[i][0], i + 1);
        }

        // 按权重升序排列
        Arrays.sort(nums, Comparator.comparingInt(o -> o[1]));

        // 子数组
        int[][] subNums = new int[n * 2][2];
        int sum = 0;
        for (int i = 0; i < n * 2; i++) {
            subNums[i] = nums[i];
            sum += nums[i][1];
        }
        List<String> resList = new ArrayList<>();
        resList.add(String.valueOf(sum));

        // 按坐标升序排列
        Arrays.sort(subNums, Comparator.comparingInt(o -> o[0]));

        // n 行
        int left = 0;
        int right = n * 2 - 1;
        for (int i = 0; i < n; i++) {
            int leftPoint = subNums[left][0];
            int rightPoint = subNums[right][0];
            resList.add(numberMap.get(leftPoint) + " " + numberMap.get(rightPoint));
            left++;
            right--;
        }
        return resList;
    }
}
/*
C. Weight of the System of Nested Segments
https://codeforces.com/contest/1650/problem/C

题目大意：
首行给定整数 n 和 m，后面 m 行给整数 xi 和 wi，分别为坐标和权重，要求找出 n 组线段，使权重总和最小

贪心，输出最小 2n 个点，双指针进行配对即可。
=======

input
3

3 8
0 10
-2 1
4 10
11 20
7 -1
9 1
2 3
5 -2

3 6
-1 2
1 3
3 -1
2 4
4 0
8 2

2 5
5 -1
3 -2
1 0
-2 0
-5 -3

output
12
2 6
5 1
7 8

10
1 6
5 2
3 4

-6
5 1
4 2
 */