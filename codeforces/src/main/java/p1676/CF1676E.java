package p1676;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CF1676E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String[] line1 = reader.readLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int q = Integer.parseInt(line1[1]);
            String line2 = reader.readLine();
            String[] lineQ = new String[q];
            for (int j = 0; j < q; j++) {
                lineQ[j] = reader.readLine();
            }
            String[] res = solution(n, q, line2, lineQ);
            for (String re : res) {
                writer.write(re.concat(System.lineSeparator()));
            }
        }
        writer.close();
        reader.close();
    }

    private static String[] solution(int n, int q, String line2, String[] lineQ) {
        String[] line2s = line2.split(" ");
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(line2s[i]));
        }
        a.sort(Comparator.reverseOrder());
        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + a.get(i);
        }

        // 二分
        String[] res = new String[q];
        for (int i = 0; i < q; i++) {
            long query = Long.parseLong(lineQ[i]);
            if (preSum[n] < query) {
                res[i] = "-1";
                continue;
            }
            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (preSum[mid] >= query) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = String.valueOf(left);
        }
        return res;
    }
}
/*
E. Eating Queries
https://codeforces.com/contest/1676/problem/E

题目大意：
给定长度为 n 的数组 a，及 q 次查询，求每次查询最少吃多少糖才能达到 q 的糖量。

贪心。将糖（数组 a）由大到小排列。
前缀和+二分。计算前缀和，求最小满足 >= q 的下标 +1。
======

input
3
8 7
4 3 3 1 1 4 5 9
1
10
50
14
15
22
30
4 1
1 2 3 4
3
1 2
5
4
6

output
1
2
-1
2
3
4
8
1
1
-1
 */