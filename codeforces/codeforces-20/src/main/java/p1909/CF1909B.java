package p1909;

import java.util.Scanner;

public class CF1909B {
    static int n;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long or = 0, and = -1;
        for (long v : a) {
            or |= v;
            and &= v;
        }
        or ^= and;
        long ans = (or & -or) << 1;
        return String.valueOf(ans);
    }
}
/*
B. Make Almost Equal With Mod
https://codeforces.com/contest/1909/problem/B

灵茶の试炼 2025-02-10
题目大意：
输入 T(≤500) 表示 T 组数据。
每组数据输入 n(2≤n≤100) 和长为 n 的数组 a(1≤a[i]≤1e17)。保证所有 a[i] 互不相同。
找到一个在 [1,1e18] 中的 k，使得所有 a[i]%=k 后，a 中恰好有两个不同的数，即 len(set(a)) == 2。
输出这个 k。如果有多个答案，输出任意一个。
可以证明，答案是存在的。

rating 1200
取模后恰好有两种不同的数？试试二进制。
计算所有二进制 a[i] 的最长公共后缀。
例如下面三个二进制数：
1110
0010
1010
最长公共后缀是 10。
只要取这三个数的低三位（也就是模 8），结果必然是两个不同的数。
如何计算最长公共后缀？
设所有 a[i] 的 OR 为 or，所有 a[i] 的 AND 为 and。
例如上面的三个数，or=1110，and=0010。
从 or 中去掉 and 的比特位，即 or ^= and，可以得到 1100。
这个数的 lowbit 再左移 1 位，就是答案 1000。
代码 https://codeforces.com/problemset/submission/1909/303586836
代码备份（洛谷）
======

Input
5
4
8 15 22 30
5
60 90 98 120 308
6
328 769 541 986 215 734
5
1000 2000 7000 11000 16000
2
2 1
Output
7
30
3
5000
1000000000000000000
 */