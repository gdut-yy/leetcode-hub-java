package p1582;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1582C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        int min = Integer.MAX_VALUE;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int left = 0;
            int right = n - 1;
            int erased = 0;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    if (s.charAt(left) == ch) {
                        erased++;
                        left++;
                    } else if (s.charAt(right) == ch) {
                        erased++;
                        right--;
                    } else {
                        break;
                    }
                }
            }
            // 能处理成回文
            if (left >= right) {
                min = Math.min(min, erased);
            }
        }
        return min == Integer.MAX_VALUE ? "-1" : String.valueOf(min);
    }
}
/*
C. Grandma Capa Knits a Scarf
https://codeforces.com/contest/1582/problem/C

题目大意：
给出字符串 s。选一个字母，在 s 中删除一些这种字母，使其变为回文串，求最小删除数。

枚举 + 双指针
只能删一种字母，即只能删除 'a' ~ 'z' 中的一个。假设当前能删除的字符为 ch，当首位字符相等时，两个都选取；
当首尾字符不等时，如果字符为 ch，可以删除，否则不能构成回文。统计 26 种情况的最小值即可。
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