package p1932;

import java.util.Scanner;

public class CF1932B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        for (int v : a) {
            ans = (ans / v + 1) * v;
        }
        return String.valueOf(ans);
    }
}
/*
B. Chaya Calendar
https://codeforces.com/contest/1932/problem/B

题目大意：
查雅部落相信世界末日有 n 种迹象。随着时间的推移，人们发现第 i 个符号每 ai 年出现一次(ai, 2·ai, 3·ai)。
根据传说，天启发生时，征兆必须依次出现。也就是说，它们首先等待第一个信号出现，然后严格地在它之后，第二个信号将出现，以此类推。也就是说，如果第 i 个符号出现在 x 年，部落开始等待第(i+1)个符号的出现，从 x+1 年开始。
第 n 个征兆会在哪一年出现，世界末日会在哪一年发生?
---
在本例的第一组输入数据中:
部落将在第 3 年等待第 1 个信号;
部落将等待第 4 年的第二个征兆(因为第 2 年已经过去了);
部落将在第 8 年等待第三个预兆(因为第 4 年已经出现了第二个预兆);
部落将等待第 10 年的第 4 个征兆(因为第 5 年已经过去了);
部落将等待第 18 年的第五个预兆(因为第 9 年已经过去了);
部落将等待第 36 年的第六个标志(因为第五个标志已经在第 18 年发生了)。

向上取整
======

Input
4
6
3 2 4 5 9 18
5
1 2 3 4 5
5
1 1 1 1 1
6
50 30 711 200 503 1006
Output
36
5
5
2012
 */
