package p1582;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MainC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            reader.readLine();
            String lineT1 = reader.readLine();
            int res = solution(lineT1);
            writer.write(String.valueOf(res));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static int solution(String str) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        int palindromeLen = longestPalindromeSubseq(str);
        if (str.length() - palindromeLen > max) {
            return -1;
        } else {
            return str.length() - palindromeLen;
        }
    }

    private static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
/*
C. Grandma Capa Knits a Scarf
https://codeforces.com/contest/1582/problem/C

题目大意：
给出字符串 s。选一个字母，在 s 中删除一些这种字母，使其变为回文串，求可删除的最小数。

TODO
======

input
5
8
abcaacab
6
xyzxyz
4
abba
8
rprarlap
10
khyyhhyhky

output
2
-1
0
3
2
 */