package p1626;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1626B {
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

    private static String solution(String line) {
        // 两位数 数字之和 不会大于 两位数本身
        int len = line.length();
        String max = "";
        for (int i = 1; i < len; i++) {
            int num1 = line.charAt(i - 1) - '0';
            int num2 = line.charAt(i) - '0';
            String newString = line.substring(0, i - 1).concat(String.valueOf(num1 + num2)).concat(line.substring(i + 1));
            if (newString.length() > max.length()) {
                max = newString;
            } else if (newString.length() == max.length()) {
                if (newString.compareTo(max) > 0) {
                    max = newString;
                }
            }
        }
        return max;
    }
}
/*
B. Minor Reduction
https://codeforces.com/contest/1626/problem/B

题目大意：
给出一个整数 x，x 不包含前导 0。定义一种简化运算，取两个相邻的数字，并将它们替换为不带前导零的和，求所有简化结果的最大值。


======

input
4
10057
90
110
1010

output
10012
9
20
110
 */
