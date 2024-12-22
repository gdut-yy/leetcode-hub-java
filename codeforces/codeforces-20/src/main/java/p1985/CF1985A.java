package p1985;

import java.util.Scanner;

public class CF1985A {
    static char[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = scanner.next().toCharArray();
            b = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        char tmp = a[0];
        a[0] = b[0];
        b[0] = tmp;
        return new String(a) + " " + new String(b);
    }
}
/*
Codeforces Round 952 (Div. 4)
A. Creating Words
https://codeforces.com/contest/1985/problem/A

题目大意：
马修得到了长度均为 $3$ 的两个字符串 $a$ 和 $b$ 。他认为通过交换 $a$ 的第一个字符和 $b$ 的第一个字符来创建两个新词特别有趣。他想让你在交换后输出 $a$ 和 $b$ 。
请注意，新字不一定不同。

模拟。
======

Input
6
bit set
cat dog
hot dog
uwu owo
cat cat
zzz zzz
Output
sit bet
dat cog
dot hog
owu uwo
cat cat
zzz zzz
 */
