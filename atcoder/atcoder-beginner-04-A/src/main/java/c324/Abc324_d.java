package c324;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc324_d {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(s);
        long max_value = (long) Math.pow(10, n);
        int ans = 0;
        for (long i = 0; i * i < max_value; i++) {
            String str = String.valueOf(i * i);
            char[] t = (str + "0".repeat(n - str.length())).toCharArray();
            Arrays.sort(t);
            if (Arrays.equals(s, t)) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
D - Square Permutation
https://atcoder.jp/contests/abc324/tasks/abc324_d

题目大意：
给定一个由数字组成的长度为 N 的字符串 S。
求通过将 S 的排列解释为十进制整数可以得到的平方数的个数。
更正式地，解决以下问题。
设 i 为 s 开头第 i 位(1≤i≤N)所对应的数。
(1,...,N)的排列 p =(p1, p2,..., pn)，求能表示为 i= ∑ s[pi] * 10^(n-i) 的平方数的个数。

全排列
13! = 6,227,020,800
---
https://atcoder.jp/contests/abc324/editorial/7413
如果一个平方数 X 是长度为 N 的字符串 S 的排列，那么 X 必须是小于 10^n 的平方数。
数组中小于 10^n 的平方数最多为⌊sqrt(10^n)⌋。检验它们中的每一个是否可以作为 S 的一个排列得到就足够了。
考虑下面的问题。
给定两个字符串 S 和 T，判断是否可以重新排列前者以获得后者。
当且仅当 S 和 T 对于所有字符 c 包含相同数量的 c 为真。
可以通过计算 0,1,...,9 的出现次数来检查条件，或者通过对 S 和 T 进行排序来查看它们是否属于相同的字符串。
时间复杂度 O(n * sqrt(10^n)))
---
好题！
======

Input 1
4
4320
Output 1
2

Input 2
3
010
Output 2
2

Input 3
13
8694027811503
Output 3
840
 */
