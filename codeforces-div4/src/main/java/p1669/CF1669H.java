package p1669;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1669H {
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
        int n = Integer.parseInt(line1s[0]);
        int k = Integer.parseInt(line1s[1]);
        String[] line2s = line2.split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line2s[i]);
        }

        int[] cnt = new int[31];
        for (int i = 0; i < n; i++) {
            for (int j = 30; j >= 0; j--) {
                // 为 0 的位
                if (((a[i] >> j) & 1) == 0) {
                    cnt[j]++;
                }
            }
        }

        int res = 0;
        for (int j = 30; j >= 0; j--) {
            if (cnt[j] <= k) {
                k -= cnt[j];
                res += (1 << j);
            }
        }
        return String.valueOf(res);
    }
}
/*
H. Maximal AND
https://codeforces.com/contest/1669/problem/H

题目大意：
给定整数 n 和 k 及长度为 n 的数组 a，可选择任意 ai 替换为为 ai 或 2^j（0 <= j <= 30），求不超过 k 次操作可以得到的最大 AND 和

贪心。由高位到低位，如果可以使 a[i] 在二进制 j 位全为 1，则进行操作。
======

input
4
3 2
2 1 1
7 0
4 6 6 28 6 6 12
1 30
0
4 4
3 1 3 1

output
2
4
2147483646
1073741825
 */