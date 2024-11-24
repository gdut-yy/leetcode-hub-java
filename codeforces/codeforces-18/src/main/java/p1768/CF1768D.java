package p1768;

import java.util.Scanner;

public class CF1768D {
    static int n;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = scanner.nextInt() - 1;
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = n + 1;
        int[] id = new int[n];
        for (int v = 0; v < n; v++) {
            int i = id[v];
            if (i > 0) continue;
            while (id[v] == 0) {
                id[v] = ans;
                v = p[v];
            }
            ans--;
        }
        for (int i = 1; i < n; i++) {
            if (id[i] == id[i - 1]) {
                ans -= 2;
                break;
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Lucky Permutation
https://codeforces.com/contest/1768/problem/D

灵茶の试炼 2024-01-11
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和一个 1~n 的排列 p。
每次操作，你可以交换 p 中的两个元素。
要使 p 的逆序对个数恰好是 1，至少要操作多少次？
注：逆序对指满足 i<j 且 p[i]>p[j] 的 (i,j)。

rating 1800
提示 1
哪些排列的逆序对个数恰好是 1？
例如 n=5 时有 [2,1,3,4,5], [1,3,2,4,5], [1,2,4,3,5], [1,2,3,5,4] 这四个。
一般地，逆序对个数恰好是 1 的排列形如 [1,2,...,k-1,k+1,k,k+2,...n]。
提示 2
先想想，要使 p 单调递增，至少要操作多少次？
这是个经典问题，做法是从 i 到 p[i] 连边建图，我们会得到若干个环，答案是 n-环个数。（注意题目是任意交换不是相邻交换）
提示 3
要么，在 p 单调递增之前，能出现逆序对个数恰好是 1 的情况，答案是 n-环个数-1。
要么，先让 p 单调递增，然后交换 p 中的一对相邻数字，从而得到逆序对个数恰好是 1 的排列，答案是 n-环个数+1。
提示 4
枚举最终得到的是提示 1 中的哪个排列，即枚举 q=[1,2,...,k-1,k+1,k,k+2,...n] 中的 k。
要计算从 p 变成 q 的最小操作次数，可以从建图上思考。
假设原来是 i 到 k 连边，j 到 k+1 连边。
改成 i 到 k+1 连边，j 到 k 连边，计算新图的 n-环个数，就是从 p 到 q 的最小操作次数了。
提示 5
如果 k 和 k+1 原来不在同一个环中，例如 i->k->i 和 j->k+1->j，那么重新连边后，得到 i->k+1->j->k->i，k 和 k+1 就在同一个环中了（两个环合并成一个环），答案就是提示 3 中的 n-环个数+1。
如果 k 和 k+1 原来在同一个环中，那么重新连边后，k 和 k+1 就不在同一个环中了（相当于把上面的过程反过来，一个环分成了两个环），答案就是提示 3 中的 n-环个数-1。
https://codeforces.com/contest/1768/submission/239483337
======

input
4
2
2 1
2
1 2
4
3 4 1 2
4
2 4 3 1
output
0
1
3
1
 */
