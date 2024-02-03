package p1251;

import java.util.Scanner;

public class CF1251B {
    static int n;
    static char[][] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = new char[n][];
            for (int i = 0; i < n; i++) {
                s[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        boolean hasOdd = false;
        int c1 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i].length % 2 > 0) {
                hasOdd = true;
            }
            for (char c : s[i]) {
                if (c == '1') c1++;
            }
        }
        int ans = n;
        if (!hasOdd && c1 % 2 > 0) {
            ans--;
        }
        return String.valueOf(ans);
    }
}
/*
B. Binary Palindromes
https://codeforces.com/contest/1251/problem/B

灵茶の试炼 2023-12-25
题目大意：
输入 T(≤50) 表示 T 组数据。
每组数据输入 n(1≤n≤50) 和 n 个长度不超过 50 的 01 字符串。
你可以执行任意次交换操作，每次交换两个字符，它俩可以来自同一个字符串或者不同字符串。
输出最多可以有多少个回文串。

rating 1400
初步分析：
奇数长度 -> 直接调整成回文。
偶数长度 -> 如果 1 有偶数个，那么 0 也有偶数个，可以直接调整成回文。
所以，想清楚奇数个 0 / 奇数个 1 要怎么处理。
分类讨论：
1.1 如果有奇数长度的字符串，并且 0 一共有奇数个或者 1 一共有奇数个，那么多出的一个字符可以放在奇数长度字符串的中心。答案为 n。
1.2 如果有奇数长度的字符串，并且 0 和 1 的个数都是奇数，那么也意味着奇数长度字符串至少有两个。答案为 n。
2.1 如果没有奇数长度（所有字符串均为偶数长度），并且 1 一共有奇数个，那么 0 一共也有奇数个。多出的一个 0 和一个 1 可以都放在一个字符串中，这个字符串不是回文串，答案为 n-1。
2.2 否则答案为 n。
https://codeforces.com/problemset/submission/1251/237484700
======

input
4
1
0
3
1110
100110
010101
2
11111
000001
2
001
11100111
output
1
2
2
2
 */
