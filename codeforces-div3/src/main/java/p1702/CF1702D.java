package p1702;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1702D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String w = scanner.next();
            int p = scanner.nextInt();
            System.out.println(solve(w, p));
        }
    }

    private static String solve(String w, int p) {
        int[] cntArr = new int[27];
        int sum = 0;
        for (char ch : w.toCharArray()) {
            int idx = ch - 'a' + 1;
            cntArr[idx]++;
            sum += idx;
        }
        if (sum <= p) {
            return w;
        }
        // sum > p
        sum -= p;

        // 需要移除
        int[] rmArr = new int[27];
        for (int idx = 26; idx >= 1 && sum > 0; idx--) {
            int k = cntArr[idx];
            if (k == 0) {
                continue;
            }
            if (sum - idx * k <= 0) {
                if (sum % idx == 0) {
                    int k1 = sum / idx;
                    rmArr[idx] += k1;
                    sum -= idx * k1;
                } else {
                    int k1 = sum / idx + 1;
                    rmArr[idx] += k1;
                    sum -= idx * k1;
                }
            } else {
                rmArr[idx] += k;
                sum -= idx * k;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : w.toCharArray()) {
            int idx = ch - 'a' + 1;
            if (rmArr[idx] > 0) {
                rmArr[idx]--;
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