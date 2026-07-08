package p2071;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2071B {
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
        int[] bad = {1, 8, 49, 288, 1681, 9800, 57121, 332928};
        int n = scanner.nextInt();
        for (int v : bad) {
            if (v == n) {
                out.println(-1);
                return;
            }
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        for (int v : bad) {
            if (v > n) break;
            int tmp = a[v - 1];
            a[v - 1] = a[v];
            a[v] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int v : a) {
            sb.append(v).append(' ');
        }
        out.println(sb);
    }
}
/*
B. Perfecto
https://codeforces.com/contest/2071/problem/B

灵茶の试炼 2026-02-16
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e6。
每组数据输入 n(1≤n≤5e5)。
构造一个 1~n 的排列 p，满足 p 的前缀和不含完全平方数。
具体地，若 p 的下标从 1 开始，那么 p[1], p[1]+p[2], p[1]+p[2]+p[3], ..., sum(p) 都不是完全平方数。
如果无解，输出 -1。
否则输出任意满足要求的 p。

rating 1100
初步想法：比如，我们得到了 n = 3 的解，那么在这个解的末尾添加 4，如果满足要求，那么就得到了 n = 4 的解。
但如果添加元素 x 后，前缀和是完全平方数呢？
如果 x 是第 n 个数（即 1~n 之和是完全平方数），那么无解。
否则，可以先填 x+1，再填 x。由于完全平方数至少相差 3，所以调整后，以 x+1 结尾的前缀和不是完全平方数。
一般地，我们可以先初始化 ans = [1,2,3,...,n]，然后在此基础上微调，即如果发现前 i 个数之和是完全平方数，那么交换第 i 个数和第 i+1 个数。
注：下面代码的下标是从 0 开始的，交换的 i-1 和 i。
代码 https://codeforces.com/contest/2071/submission/363026755
代码备份（上面打不开的同学看这个）
注：如果你没有任何思路，可以试试打表找规律。
======

Input
3
1
4
5
Output
-1
2 4 1 3
5 1 4 3 2
 */
