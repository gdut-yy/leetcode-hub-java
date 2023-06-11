package p1697;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1697C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int q = scanner.nextInt();
        while (q-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            String t = scanner.next();
            System.out.println(solve(n, s, t));
        }
    }

    private static String solve(int n, String s, String t) {
        // 双指针
        int p1 = 0;
        int p2 = 0;
        while (p1 < n && p2 < n) {
            while (p1 < n && s.charAt(p1) == 'b') {
                p1++;
            }
            while (p2 < n && t.charAt(p2) == 'b') {
                p2++;
            }
            if (p1 < n && p2 < n) {
                if (s.charAt(p1) != t.charAt(p2)) {
                    return "NO";
                } else {
                    if ((s.charAt(p1) == 'c' && p1 < p2) || s.charAt(p1) == 'a' && p1 > p2) {
                        return "NO";
                    }
                    p1++;
                    p2++;
                }
            }
        }
        while (p1 < n && s.charAt(p1) == 'b') {
            p1++;
        }
        while (p2 < n && t.charAt(p2) == 'b') {
            p2++;
        }

        return p1 == n && p2 == n ? "YES" : "NO";
    }
}
/*
C. awoo's Favorite Problem
https://codeforces.com/contest/1697/problem/C

题目大意：
你有两个长度为 n 的字符串 s 和 t。这两个字符串中的每个字符都是 'a', 'b' 或 'c'。
在一个操作中，您可以执行以下操作之一:
选择 s 中出现的 "ab"，并将其替换为 "ba";
选择 s 中出现的 "bc"，并将其替换为 "cb"。
你可以执行任意数量的移动（可能是零）。你能改变字符串 s 使它等于字符串 t 吗？

双指针
相似题目: 777. 在LR字符串中交换相邻字符
https://leetcode.cn/problems/swap-adjacent-in-lr-string/
2337. 移动片段得到字符串
https://leetcode.cn/problems/move-pieces-to-obtain-a-string/
======

input
5
3
cab
cab
1
a
b
6
abbabc
bbaacb
10
bcaabababc
cbbababaac
2
ba
ab
output
YES
NO
YES
YES
NO
 */
