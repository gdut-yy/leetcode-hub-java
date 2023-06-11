package p1703;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1703C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            scanner.nextLine();
            String[] b = new String[n];
            for (int j = 0; j < n; j++) {
                b[j] = scanner.nextLine();
            }
            System.out.println(solve(n, a, b));
        }
    }

    private static String solve(int n, int[] a, String[] b) {
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = b[i].split(" ")[1];
            int cnt = 0;
            for (char ch : s.toCharArray()) {
                if (ch == 'U') {
                    cnt--;
                } else {
                    cnt++;
                }
            }
            a[i] = ((a[i] + cnt) % 10 + 10) % 10;
            resList.add(String.valueOf(a[i]));
        }
        return String.join(" ", resList);
    }
}
/*
C. Cypher
https://codeforces.com/contest/1703/problem/C

题目大意：
给定整数 n 和长为 n 的数组 a，以及 n 行对第 i 个轮子操作，U和D分别表示上升和下降。求密码锁的初始序列。

模拟，取模。
======

input
3
3
9 3 1
3 DDD
4 UDUU
2 DU
2
0 9
9 DDDDDDDDD
9 UUUUUUUUU
5
0 5 9 8 3
10 UUUUUUUUUU
3 UUD
8 UUDUUDDD
10 UUDUUDUDDU
4 UUUU

output
2 1 1
9 0
0 4 9 6 9
 */