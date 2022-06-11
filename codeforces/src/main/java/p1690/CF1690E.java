package p1690;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CF1690E {
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
        String[] line2s = line2.split(" ");
        int n = Integer.parseInt(line1s[0]);
        int k = Integer.parseInt(line1s[1]);

        long sum = 0L;
        List<Integer> remainList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(line2s[i]);
            remainList.add(a % k);
            sum += a / k;
        }
        Collections.sort(remainList);

        // 双指针
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (remainList.get(left) + remainList.get(right) >= k) {
                sum++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        return String.valueOf(sum);
    }
}
/*
E. Price Maximization
https://codeforces.com/contest/1690/problem/E

题目大意：
给定整数 n,k 和长度为 n 的数组 a，n 为偶数，将 a 分为 n/2 组，每组包含 2 个 a，记和为 s，求所有 sum/k 的最大和。

贪心，求余然后双指针组成最小大于等于 k 的组。
======

input
6
6 3
3 2 7 1 4 8
4 3
2 1 5 6
4 12
0 0 0 0
2 1
1 1
6 10
2 0 0 5 9 4
6 5
5 3 8 6 3 2

output
8
4
0
2
1
5
 */