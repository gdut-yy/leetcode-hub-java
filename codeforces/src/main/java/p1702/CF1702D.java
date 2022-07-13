package p1702;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1702D {
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
        int p = Integer.parseInt(line2);

        int[] cntArr = new int[27];
        int sum = 0;
        for (char ch : line1.toCharArray()) {
            int w = ch - 'a' + 1;
            cntArr[w]++;
            sum += w;
        }
        if (sum <= p) {
            return line1;
        }
        // sum > p
        sum -= p;

        // 需要移除
        int[] rmArr = new int[27];
        for (int w = 26; w >= 1 && sum > 0; w--) {
            int k = cntArr[w];
            if (k == 0) {
                continue;
            }
            if (sum - w * k <= 0) {
                if (sum % w == 0) {
                    int k1 = sum / w;
                    rmArr[w] += k1;
                    sum -= w * k1;
                } else {
                    int k1 = sum / w + 1;
                    rmArr[w] += k1;
                    sum -= w * k1;
                }
            } else {
                rmArr[w] += k;
                sum -= w * k;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : line1.toCharArray()) {
            int w = ch - 'a' + 1;
            if (rmArr[w] > 0) {
                rmArr[w]--;
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
/*
D. Not a Cheap String
https://codeforces.com/contest/1702/problem/D

题目大意：
给定字符串 w 和整数 p，从w中删除最小数量的字母，使其价格小于或等于p，求w中获得的最长字符串。如果有多个答案，则输出其中任何一个。

贪心，从最大的字符 'z' 开始删。
======

input
5
abca
2
abca
6
codeforces
1
codeforces
10
codeforces
100

output
aa
abc

cdc
codeforces
 */