package p2162;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2162E {
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
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] a = new int[n];
        boolean[] has = new boolean[n + 2];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            has[a[i]] = true;
        }
        int x = 1;
        while (has[x]) x++;
        if (x <= n) {
            int z = a[n - 1];
            int y = 1;
            while (y == x || y == z) y++;
            a[0] = x;
            a[1] = y;
            a[2] = z;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(a[i % 3]).append(" ");
        }
        out.println(sb);
    }
}
/*
E. Beautiful Palindromes
https://codeforces.com/contest/2162/problem/E

灵茶の试炼 2026-01-28
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(3≤n≤2e5) k(1≤k≤n) 和长为 n 的数组 a(1≤a[i]≤n)。
你需要在 a 的末尾添加 k 个在 [1,n] 中的整数，得到一个长为 n+k 的数组 b。
目标：让 b 中的回文连续子数组的个数尽量少。
输出添加的 k 个数（按照从左到右的顺序输出）。

rating 1600
注意数据范围。
如果某个数不在 a 中，如何构造？
如果 1~n 的每个数都在 a 中，意味着什么？如何构造？
首先说明回文序列的一些性质。
长度 >= 4 的偶回文序列，包含长为 2 的回文中心。
长度 >= 5 的奇回文序列，包含长为 3 的回文中心。
所以如果没有长为 2 或 3 的回文序列，也就没有长度 >= 4 的回文序列。
据此，可以考虑按照 x y z x y z ... 的顺序添加元素，其中 x y z 互不相同。
这样新添加的元素内部没有长度 >= 2 的回文序列。
剩下要考虑的，就是新添加的元素，不能与 a 中元素组成回文序列。这是可以做到的。
分类讨论：
如果 a 不是一个 1~n 的排列，那么令：
x 是 a 缺失的任意一个数。
y 是一个不等于 x 也不等于 a[n] 的数。这会让 x 不是回文中心（a[n],x,y 不是回文序列）。当唯一元素 x 不是回文中心时，由于镜像位置没有另一个 x，所以不存在包含 x 的长度 >= 2 的回文序列。
z 是一个不等于 x 也不等于 y 的数（比如 a[n]）。同理，当唯一元素 x 不是回文中心时，由于镜像位置没有另一个 x，所以不存在包含 x 的长度 >= 2 的回文序列。
如果 a 是一个 1~n 的排列，那么令 x y z 为 a 的前三个数，即可满足要求。
代码 https://codeforces.com/contest/2162/submission/360108118
代码备份（上面打不开的同学看这个）
======

Input
5
4 1
1 3 3 4
4 2
2 2 2 2
5 1
4 1 5 2 2
6 3
1 2 3 4 5 6
5 3
3 2 5 2 3
Output
2
1 3
3
3 4 1
4 1 5
 */
