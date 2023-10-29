package p1867;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1867B {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        char[] cs = new char[n + 1];
        Arrays.fill(cs, '0');

        int ans = 0, max1 = 0, max2 = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s[i] == s[n - i - 1]) max2++;
            else ans++;
        }
        if (n % 2 == 1) max1++;

        for (int j = 0; j <= max2; j++) {
            for (int k = 0; k <= max1; k++) {
                cs[ans + j * 2 + k] = '1';
            }
        }

        return new String(cs);
    }
}
/*
B. XOR Palindromes
https://codeforces.com/contest/1867/problem/B

题目大意：
给定一个长度为 n 的二进制字符串 s(一个仅由 0 和 1 组成的字符串)。如果存在长度为 n 的二进制字符串 l，包含 x 个 1，使得如果每个符号 si 被 si⊕li(其中 ⊕ 表示按位异或操作)替换，则字符串 s 成为回文，则数字 x 是好的。
您需要输出一个长度为 n+1 的二进制字符串 t，其中如果数字 i 是好的，则 ti(0≤i≤n)等于 1，否则等于 0。
回文是一个从左到右和从右到左读起来一样的字符串。例如，01010、1111、0110 是回文。

？kmp？
https://codeforces.com/blog/entry/120353
首先，字符串是回文当且仅当对于任意 i(1≤i≤n) si=s[n-i+1](因为当反转时，si 变成 s[n-i+1])。
我们可以将字符分成对，每对由 si 和 s[n-i+1] 组成。如果 si=s[n-i+1]，那么我们需要 li=l[n-i+1] 才能在异或之后得到相等的元素。
因此，li=l[n−i+1]=0(0 个 1)或 li=l[n−i+1]=1(2 个 1)。如果 si≠s[n-i+1]，那么 li≠l[n-i+1] 必须成立(在任何情况下都是 1)。另外，如果 n 是奇数，那么 l[n/2+1] 可以是 0 或 1(0 或 1)。
我们可以遍历 li=l[n-i+1] 中有两个 1 的对的个数，以及中间是否有一个 1。这样，我们可以得到 l 中所有可能的 1 的个数，也就是所有好的 i。
时间复杂度:每个测试用例 O(n)。
======

input
5
6
101011
5
00000
9
100100011
3
100
1
1
output
0010100
111111
0011111100
0110
11
 */
