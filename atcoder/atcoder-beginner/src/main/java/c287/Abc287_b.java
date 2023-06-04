package c287;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc287_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        String[] t = new String[m];
        for (int i = 0; i < m; i++) {
            t[i] = scanner.next();
        }
        System.out.println(solve(n, m, s, t));
    }

    private static String solve(int n, int m, String[] s, String[] t) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, t);
        int ans = 0;
        for (String x : s) {
            String sub = x.substring(3);
            if (set.contains(sub)) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B - Postal Card
https://atcoder.jp/contests/abc287/tasks/abc287_b

题目大意：
给定 N 个长度为 6 的字符串，每个字符串由数字组成。设 si 是第 i 个(i=1,2，…，N)
你还会得到 M 个长度为 3 的字符串，每个字符串由数字组成。设 tj 是它们的第 j 个(j=1,2，…，M)
求 s1, s2,...,sn 中最后三个字符与 t1, t2,...,tm 中的一个或多个重合的字符串的个数。

模拟。
======

Input 1
3 3
142857
004159
071028
159
287
857
Output 1
2

Input 2
5 4
235983
109467
823476
592801
000333
333
108
467
983
Output 2
3

Input 3
4 4
000000
123456
987111
000000
000
111
999
111
Output 3
3
 */