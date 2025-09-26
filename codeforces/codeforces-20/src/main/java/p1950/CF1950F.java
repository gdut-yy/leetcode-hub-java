package p1950;

import java.util.Scanner;

public class CF1950F {
    static int a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (a + 1 != c) {
            return "-1";
        }
        int h = bitsLen(a);
        b -= (1 << h) - c;
        if (b > 0) {
            h += (b - 1) / c + 1;
        }
        return String.valueOf(h);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
F. 0, 1, 2, Tree!
https://codeforces.com/contest/1950/problem/F

灵茶の试炼 2024-06-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 a+b+c 之和 ≤3e5。
每组数据输入 a,b,c (0≤a,b,c≤1e5 且 1≤a+b+c)。
有一棵二叉树，其中 a 个节点有两个儿子，b 个节点有一个儿子，c 个节点没有儿子。
输出这棵二叉树的最小高度。
注意这里的高度是根到最远叶节点的路径上的边的个数。
特别地，只有一个节点的二叉树的高度为 0。
进阶：做到 O(1) 时间。

rating 1700
把这三种节点（有两个/一个/零个儿子）分别记作 A B C。
整体思路：
一层一层地放置，先放 A，然后 B，最后 C。
先判断 -1。
由于 a 个节点 A 会产生 a+1 个「插座」，可以插入恰好 a+1 个节点，所以必须满足 a+1=c。
B 节点由于插入插座后自己又产生了一个插座，所以无需判断 b。
对于节点 A 来说，一层一层地放置，可以放 a 的二进制长度层，设其为 h1。
最后一层可以放恰好 c 个节点，还留有 k = 2^h1 - c 个「插座」，可以放一部分节点 B。
如果 b-k > 0，那么剩下的 b-k 个节点需要 h2 = ceil((b-k)/c) 层。
最后一层放节点 C。
所以树高为 h1 + h2 + 1 - 1 = h1 + h2，减一是因为按照题目规定，高度等于层数减一。
https://codeforces.com/problemset/submission/1950/266388752
======

Input
10
2 1 3
0 0 1
0 1 1
1 0 2
1 1 3
3 1 4
8 17 9
24 36 48
1 0 0
0 3 1
Output
2
0
1
1
-1
3
6
-1
-1
3
 */
