package p1800;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1800B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, k, s));
        }
    }

    private static String solve(int n, int k, String s) {
        int[] lo = new int[26];
        int[] up = new int[26];
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lo[ch - 'a']++;
            } else {
                up[ch - 'A']++;
            }
        }

        int res = 0;
        // 大小写
        for (int i = 0; i < 26; i++) {
            int mn = Math.min(lo[i], up[i]);
            lo[i] -= mn;
            up[i] -= mn;
            res += mn;
        }
        // 大小写转换
        for (int i = 0; i < 26; i++) {
            int mx = Math.max(lo[i], up[i]) / 2;
            int mn = Math.min(k, mx);
            k -= mn;
            res += mn;
        }
        return String.valueOf(res);
    }
}
/*
B. Count the Number of Pairs
https://codeforces.com/contest/1800/problem/B

题目大意：
给定整数 n, k 和长度为 n 的字符串 s。最多可以转换对 k 个字符做大小写切换。求最大的大小写配对数

贪心。优先队列，能匹配的先匹配完，然后从同一种字符中，每对消耗 1 次转换。
======

input
5
11 2
aAaaBACacbE
2 2
ab
4 1
aaBB
6 0
abBAcC
5 3
cbccb

output
5
0
1
3
2
 */