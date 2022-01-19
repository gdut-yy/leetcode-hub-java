package p1615;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1615A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] lines = reader.readLine().split(" ");
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(lines[j]);
            }
            writer.write(solution(n, nums).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % n == 0) {
            return "0";
        }
        return "1";
    }
}
/*
Codeforces Global Round 18
A. Closing The Gap
https://codeforces.com/contest/1615/problem/A

题目大意：
给出整数 n 及长度为 n 的数组。规定可以 a[i]-1, a[j]+1 任意次，求最大高度差最少值为多少。

贪心。最终结果为所有高度平均，只有 0（数组之和恰好能整除 n） 和 1（数组之和不能整除 n） 两种可能
======

input
3
3
10 10 10
4
3 2 1 2
5
1 2 3 1 5

output
0
0
1
 */