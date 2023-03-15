package p1619;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1619C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long a = scanner.nextLong();
            long s = scanner.nextLong();
            System.out.println(solve(a, s));
        }
    }

    private static String solve(long a, long s) {
        String aStr = String.valueOf(a);
        String sStr = String.valueOf(s);
        // 双指针
        int p1 = aStr.length() - 1;
        int p2 = sStr.length() - 1;
        // b
        StringBuilder stringBuilder = new StringBuilder();
        while (p2 >= 0) {
            int ai = (p1 >= 0) ? aStr.charAt(p1) - '0' : 0;
            int si = sStr.charAt(p2) - '0';
            // a 中 1 个字符对应 s 中 1-2 个字符
            if (si >= ai) {
                stringBuilder.append(si - ai);
                p1--;
                p2--;
            } else {
                // 第 2 个字符必须为 1
                if (p2 - 1 >= 0 && sStr.charAt(p2 - 1) == '1') {
                    int sum = si + 10;
                    stringBuilder.append(sum - ai);
                    p2 -= 2;
                    p1--;
                } else {
                    return "-1";
                }
            }
        }
        if (p1 >= 0) {
            return "-1";
        }
        String bStr = stringBuilder.reverse().toString();
        return String.valueOf(Long.parseLong(bStr));
    }
}
/*
C. Wrong Addition
https://codeforces.com/contest/1619/problem/C

题目大意：
给出两个正整数 a 和 s。求 b，题目给出一种自定义的 a + b = s 算法。

模拟即可。
======

input
6
17236 1106911
1 5
108 112
12345 1023412
1 11
1 20

output
3465
4
-1
90007
10
-1
 */