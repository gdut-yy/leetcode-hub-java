package p1593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CF1593D1 {
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

        List<Integer> list = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());
        if (list.size() == 1) {
            return "-1";
        }
        int res = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            res = getGCD(res, list.get(i) - list.get(i - 1));
        }
        return String.valueOf(Math.abs(res));
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
D1. All are Same
https://codeforces.com/contest/1593/problem/D1

题目大意：
给出整数数组，假设存在一个 k，对数组任一元素减去 k，重复若干次后，数组所有数相等，求 k 的任意值。

即求出最大公约数。
======

input
3
6
1 5 3 1 1 5
8
-1 0 1 -1 0 1 -1 0
4
100 -1000 -1000 -1000

output
2
1
1100
 */