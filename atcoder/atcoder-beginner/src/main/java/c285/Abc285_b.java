package c285;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc285_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        s = " " + s;
        // S1 ~ S6
        int[] ans = new int[n - 1];
        char[] cs = s.toCharArray();
        for (int i = 1; i <= n - 1; i++) {
            int k = 0;
            while (i + k <= n) {
                // 遇到第一个不满足就退出
                if (cs[k] == cs[k + i]) {
                    break;
                }
                k++;
                ans[i - 1] = k - 1;
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
B - Longest Uncommon Prefix
https://atcoder.jp/contests/abc285/tasks/abc285_b

题目大意：
给定一个长度为 N 的字符串 S，由小写英文字母组成。S 的第 x 个(1≤x≤N)字符是 Sx。
对于每一个 i=1,2,...,N−1，求满足以下所有条件的最大非负整数 l:
- l + i ≤ N,
- 对于所有满足 1≤k≤l 的整数 k，成立 Sk != Sk+i。
注意，l=0 总是满足这些条件。

模拟。感觉题目描述挺烂的。。
======

Input 1
6
abcbac
Output 1
5
1
2
0
1
 */