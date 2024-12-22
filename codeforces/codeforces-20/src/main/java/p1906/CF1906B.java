package p1906;

import java.util.Scanner;

public class CF1906B {
    static int n;
    static char[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = scanner.next().toCharArray();
            b = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int c1 = f(a);
        int c2 = f(b);
        return (c1 == c2 || c1 == n + 1 - c2) ? "YES" : "NO";
    }

    static int f(char[] a) {
        int s = 0;
        int c1 = 0;
        for (char b : a) {
            s ^= b & 1;
            c1 += s;
        }
        return c1;
    }
}
/*
B. Button Pressing
https://codeforces.com/contest/1906/problem/B

灵茶の试炼 2024-08-09
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(3≤n≤2e5) 和两个长为 n 的 01 字符串 a 和 b。
每次操作，你可以选择一个值为 1 的 a[i]，然后把 a[i-1] 和 a[i+1] 翻转（异或 1）。
如果对最左边的 i 操作，就只把 a[i+1] 翻转；如果对最右边的 i 操作，就只把 a[i-1] 翻转。
注意操作不会翻转 a[i]。
能否把 a 变成 b？输出 YES 或 NO。

rating 2600
操作前后，什么是不变的？
提示：前缀异或和。
操作前后，前缀异或和发生了什么变化？
定义数组 a 的前缀异或和 s[0]=0, s[i+1]=s[i]^a[i]。
操作相当于交换前缀异或和的两个相邻元素。
也就是说，sum(s) 是不变的。
如果可以把 a 的前缀异或和，通过交换，变成数组 b 的前缀异或和，那么答案就是 YES。
也就是 sum(s(a)) = sum(s(b))。
为了保证【交换前缀异或和的两个相邻元素】这句话对于任何操作都成立，
操作 a[0] 视作交换 s[0] 和 s[1]，所以 s[0] 有可能是 1。
对于数组 b 的前缀异或和，由于它是交换后的，可能 s[0]=0，也可能 s[0]=1。
如果 s[0]=1，相当于把 s(b) 中的所有 0 变成 1，所有 1 变成 0。
所以还有一种成立的条件，sum(s(a)) = n+1-sum(s(b))
代码 https://codeforces.com/problemset/submission/1906/275159772
======

Input
2
4
0101
0100
3
000
010
Output
YES
NO

Input
5
7
0101011
1111010
5
11111
00000
4
1101
1101
6
101010
100100
3
000
000
Output
NO
NO
YES
YES
YES
 */
