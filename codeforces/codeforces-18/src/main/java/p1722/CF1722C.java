package p1722;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1722C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String[] line1 = new String[n];
            String[] line2 = new String[n];
            String[] line3 = new String[n];
            for (int j = 0; j < n; j++) {
                line1[j] = scanner.next();
            }
            for (int j = 0; j < n; j++) {
                line2[j] = scanner.next();
            }
            for (int j = 0; j < n; j++) {
                line3[j] = scanner.next();
            }
            System.out.println(solve(n, line1, line2, line3));
        }
    }

    private static String solve(int n, String[] line1, String[] line2, String[] line3) {
        Map<String, Integer> cntMap = new HashMap<>();
        for (String s : line1) {
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }
        for (String s : line2) {
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }
        for (String s : line3) {
            cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
        }

        return getScore(cntMap, line1) + " " + getScore(cntMap, line2) + " " + getScore(cntMap, line3);
    }

    private static int getScore(Map<String, Integer> cntMap, String[] line) {
        int res = 0;
        for (String s : line) {
            int cnt = cntMap.get(s);
            if (cnt == 1) {
                res += 3;
            } else if (cnt == 2) {
                res += 1;
            }
        }
        return res;
    }
}
/*
C. Word Game
https://codeforces.com/contest/1722/problem/C

题目大意：
给定整数 n 和 3 行每行 n 个单词，如果单词出现一次，算 3 分，如果出现两次，两人各算 1 分，求三人分数。

HashMap 统计频次后，线性遍历即可。
======

input
3
1
abc
def
abc
3
orz for qaq
qaq orz for
cod for ces
5
iat roc hem ica lly
bac ter iol ogi sts
bac roc lly iol iat

output
1 3 1
2 2 6
9 11 5
 */
