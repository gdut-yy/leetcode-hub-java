package p1828;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF1828E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    // https://codeforces.com/contest/1827/submission/205927403
    private static String solve(int n, String s) {
        n += 2;
        s = '#' + s + '@';
        char[] cs = s.toCharArray();

        int[] pal = new int[n];
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        long total = 0;
        int f = 0;
        for (int i = 1; i + 1 < n; i++) {
            if (pal[f] + f > i) {
                pal[i] = Math.min(pal[f] + f - i, pal[f - (i - f)]);
            }
            while (cs[i + pal[i] + 1] == cs[i - pal[i]]) {
                ++pal[i];
                f = i;
            }
            stack.push(i - 1);
            while (!stack.isEmpty()) {
                int p = stack.peek();
                if (pal[p] + p < i) {
                    stack.pop();
                } else {
                    int lm = p - (i - p);
                    ans[i] = ans[lm] + 1;
                    break;
                }
            }
            total += ans[i];
        }
        return String.valueOf(total);
    }
}
/*
E. Palindrome Partition
https://codeforces.com/contest/1828/problem/E

题目大意：
子字符串是来自给定字符串的连续且非空的字母段，没有任何重新排序。
偶数回文是一个向后读和正向读相同且长度为偶数的字符串。例如，字符串“zz”，“abba”，“abccba”甚至是回文，但字符串“codeforces”，“reality”，“aba”，“c”不是回文。
一个漂亮的字符串是一个偶数回文，或者一个可以被分割成一些更小的偶数回文的字符串。
给定一个字符串 s，由 n 个小写拉丁字母组成。数一下 s 的漂亮子串的个数。

rating 2600
Manacher 优化 DP
======

input
6
6
abaaba
1
a
2
aa
6
abcdef
12
accabccbacca
6
abbaaa
output
3
0
1
0
14
6
 */
