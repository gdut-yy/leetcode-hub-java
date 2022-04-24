package p1669;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1669E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            int n = Integer.parseInt(line1);
            String[] lines = new String[n];
            for (int j = 0; j < n; j++) {
                lines[j] = reader.readLine();
            }
            writer.write(solution(n, lines).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, String[] lines) {
        // from 'a' to 'k'.
        int[][] cntArray = new int[11][11];
        for (String line : lines) {
            int idx0 = line.charAt(0) - 'a';
            int idx1 = line.charAt(1) - 'a';
            cntArray[idx0][idx1]++;
        }

        long cnt = 0;
        for (String line : lines) {
            int idx0 = line.charAt(0) - 'a';
            int idx1 = line.charAt(1) - 'a';
            for (int i = 0; i < 11; i++) {
                // 第一个位置不等
                if (i != idx0) {
                    cnt += cntArray[i][idx1];
                }
                // 第二个位置不等
                if (i != idx1) {
                    cnt += cntArray[idx0][i];
                }
            }
        }
        return String.valueOf(cnt / 2);
    }
}
/*
E. 2-Letter Strings
https://codeforces.com/contest/1669/problem/E

题目大意：
给定 n 个长度为 2 的字符串（为小写字母 'a'~'k'），求下标 i < j 时，si 和 sj 仅有一个下标不同的对数。

本题 n 取值 10^5，因此时间复杂度不能高于 nlogn，直接两层 for 循环必然 TLE，可以将每个字符串转化为二维数组，做累加，常数为 11。
======

input
4
6
ab
cb
db
aa
cc
ef
7
aa
bb
cc
ac
ca
bb
aa
4
kk
kk
ab
ab
5
jf
jf
jk
jk
jk

output
5
6
0
6
 */