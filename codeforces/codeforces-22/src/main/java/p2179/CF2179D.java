package p2179;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2179D {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        out.print((1 << n) - 1);
        out.print(" ");
        for (int i = n - 1; i >= 0; i--) {
            int v = (1 << i) - 1;
            int limit = 1 << (n - 1 - i);
            for (int j = 0; j < limit; j++) {
                out.print((j << (i + 1)) | v);
                out.print(" ");
            }
        }
        out.println();
    }
}
/*
D. Blackslex and Penguin Civilization
https://codeforces.com/contest/2179/problem/D

灵茶の试炼 2026-02-10
题目大意：
输入 T(≤16) 表示 T 组数据。所有数据的 2^n 之和 ≤2^16。
每组数据输入 n(1≤n≤16)。
构造一个长为 2^n 的排列 p，元素范围为 [0, 2^n - 1]。
计算 p 的前缀 AND，即前 i=1,2,...,2^n 个数的 AND，得到一个长为 2^n 的数组 pre。
定义 S(p) = popcount(pre[1]) + popcount(pre[2]) + ... + popcount(pre[2^n])，其中 popcount(x) 表示 x 二进制中的 1 的个数。
目标是最大化 S(p)。
在所有让 S(p) 最大的排列 p 中，输出字典序最小的 p。
进阶：做到 O(1) 空间。

rating 1300
把 AND 理解为计算交集，popcount 即交集大小。
随着参与求交的集合越来越多，交集的大小只会越来越小。
为了最大化 S(p)，可以先构造 popcount = n 的情况，即排列的第一个数是 2^n - 1。
然后依次构造 popcount = n-1, n-2, ..., 0 的情况。
当排列的第一个数是 1111 的时候，第二个数可以是 1110, 1101, 1011, 0111，选哪个最好？
为了最小化字典序，选 0111。
一般地，我们可以让 AND 的结果（以 n=4 为例）去重后为 1111,0111,0011,0001,0000。
比如 AND 结果为 0001 的情况，可以构造 0001, 0101, 1001, 1101，即高位 00,01,10,11 拼接低位 01。注意从低到高第二位必须是 0，因为这一位是 1 的情况已经在 0011 这一组构造过了。
代码 https://codeforces.com/contest/2179/submission/361781785
代码备份（上面打不开的同学看这个）
======

Input
2
1
2
Output
1 0
3 1 0 2
 */
