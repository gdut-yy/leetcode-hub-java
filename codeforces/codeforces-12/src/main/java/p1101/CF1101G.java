package p1101;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1101G {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] b = new int[30];
        int xor = 0;
        int num = 0;
        for (int v : a) {
            xor ^= v;
            for (int i = b.length - 1; i >= 0; i--) {
                if (v >> i == 0) {
                    continue;
                }
                if (b[i] == 0) {
                    b[i] = v;
                    num++;
                    break;
                }
                v ^= b[i];
            }
        }
        if (xor == 0) {
            num = -1;
        }
        out.println(num);
    }
}
/*
G. (Zero XOR Subset)-less
https://codeforces.com/contest/1101/problem/G

灵茶の试炼 2025-07-31
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
把 a 分割成若干段（连续非空子数组），要求：从这些子段中任取若干子段，它们包含的所有数的异或和不能为 0。
输出最多能分成多少段。
如果不存在合法分割方案，输出 -1。

rating 2300
首先判断 -1。
如果整个数组的异或和等于 0，那么无论怎么分割，只要全选，异或和就是 0。无解。
否则一定有解（比如不分割）。
用前缀异或和思考。
比如 $a=[1,2]$，前缀异或和数组为 $s=[0,1,3]$。可以用 1 和 3 当作基。
选择的子段为 [1]，异或和为 1，即 s[0]^s[1] = 1。
选择的子段为 [1,2]，异或和为 3，即 s[0]^s[2] = 3。
选择的子段为 [2]，异或和为 1^3，即 s[1]^s[2] = 2。
一般地，问题相当于从前缀和数组（除去 s[0]=0）中选择一些数，这些数的任意非空子集的异或和不为 0。
解释：
如果选了偶数个数，可以两两一对，每一对对应一段。
如果选了奇数个数，那么把 s[0]=0 也选上，变成选偶数个数的情况。
反之，如果存在一个子集的异或和等于 0，可以按照上述奇偶分类讨论，能够对应到一种不合法的分割方案。
所以当且仅当从前缀和数组（除去 s[0]=0）中选择一些数，这些数的任意非空子集的异或和不为 0 时，分割方案是合法的。
答案为线性基中的基的个数。每成功插入一个基，就把答案加一。
如果不仅选了基，还选了可以被基表出的数，那么这个数和对应的基一起，异或和为 0，对应着某些段的异或和为 0。
代码实现时，由于前缀异或和可以由原数组的基表出，所以可以直接计算原数组的线性基，无需计算前缀异或和的线性基。
代码 https://codeforces.com/contest/1101/submission/331366832
代码备份（Ubuntu Pastebin）
======

Input
4
5 5 7 2
Output
2

Input
3
1 2 3
Output
-1

Input
3
3 1 10
Output
3
 */