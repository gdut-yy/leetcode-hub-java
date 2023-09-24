package c221;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc221_e {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int mod = 998244353;
    private static final int mod2 = (mod + 1) / 2;

    private static String solve() {
        Arrays.sort(b);

        long ans = 0;
        long[] tree = new long[n + 1];
        long p2 = 1, invp2 = 1;
        for (int i = 0; i < n; i++) {
            int v = searchInts(b, a[i]) + 1;
            for (int j = v; j > 0; j &= j - 1) {
                ans = (ans + tree[j] * p2) % mod;
            }
            p2 = p2 * 2 % mod;
            invp2 = invp2 * mod2 % mod;
            while (v <= n) {
                tree[v] = (tree[v] + invp2) % mod;
                v += v & -v;
            }
        }
        return String.valueOf(ans);
    }

    private static int searchInts(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
E - LEQ
https://atcoder.jp/contests/abc221/tasks/abc221_e

灵茶の试炼 2022-10-20
题目大意：
【更新通知】
从今天开始，带你们刷 AtCoder 啦！难度分大概是之前的 -400
输入 n(≤3e5) 和长为 n 的数组 a (1≤a[i]≤1e9)。
输出有多少个 a 的长度至少为 2 的子序列，满足子序列的第一项 ≤ 子序列的最后一项。
由于答案很大，输出答案模 998244353 的结果。
注：子序列不要求连续。

https://atcoder.jp/contests/abc221/submissions/35791225
这是一道基于逆序对的变形题。
不了解逆序对的同学，可以先看看我的讲解 https://www.bilibili.com/video/BV1tW4y1e7rb
用树状数组实现，这里的问题是，如何把 2 的幂次（中间的子序列的个数）也考虑进去。
我们可以把 2^(i-j) 转换成 2^i / 2^j，那么把 2^j 的逆元加到树状数组中即可。
注意需要离散化。
代码中展示了一个巧妙计算逆元的技巧。
相似题目: F - Numbered Checker
https://atcoder.jp/contests/abc269/tasks/abc269_f
======

Input 1
3
1 2 1
Output 1
3

Input 2
3
1 2 2
Output 2
4

Input 3
3
3 2 1
Output 3
0

Input 4
10
198495780 28463047 859606611 212983738 946249513 789612890 782044670 700201033 367981604 302538501
Output 4
830
 */