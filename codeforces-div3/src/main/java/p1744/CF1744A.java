package p1744;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CF1744A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            String s = scanner.next();
            System.out.println(solve(n, a, s));
        }
    }

    private static String solve(int n, int[] a, String s) {
        Map<Integer, Set<Character>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.computeIfAbsent(a[i], key -> new HashSet<>()).add(s.charAt(i));
            if (hashMap.get(a[i]).size() > 1) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
Codeforces Round #828 (Div. 3)
A. Number Replacement
https://codeforces.com/contest/1744/problem/A

题目大意：
给定整数 n 和长度为 n 的数组 a，长度为 n 的字符串 s。一次操作可以将数组 a 的数字 x 转换成字母 y。判断是否能从数组 a 转换得到字符串 s。

成立的条件为：一个数字只能映射唯一一个字母。HashMap 模拟。
======

input
7
5
2 3 2 4 1
cacta
1
50
a
2
11 22
ab
4
1 2 2 1
aaab
5
1 2 3 2 1
aaaaa
6
1 10 2 9 3 8
azzfdb
7
1 2 3 4 1 1 2
abababb

output
YES
YES
YES
NO
YES
YES
NO
 */