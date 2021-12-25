package p1619;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CF1619B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line = reader.readLine();
            writer.write(solution(line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static int[] TABLES;

    private static String solution(String line) {
        // 打表
        if (TABLES == null) {
            Set<Integer> hashSet = new HashSet<>();
            // 平方
            for (int i = 1; i <= 31622; i++) {
                hashSet.add(i * i);
            }
            // 立方
            for (int i = 1; i <= 1000; i++) {
                hashSet.add(i * i * i);
            }
            TABLES = hashSet.stream().mapToInt(i -> i).toArray();
            Arrays.sort(TABLES);
        }

        int num = Integer.parseInt(line);
        int idx = binarySearchRightBound(TABLES, num);
        return String.valueOf(idx + 1);
    }

    private static int binarySearchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }
}
/*
B. Squares and Cubes
https://codeforces.com/contest/1619/problem/B

6
10
1
25
1000000000
999999999
500000000

4
1
6
32591
32590
23125

 */