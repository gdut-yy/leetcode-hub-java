package p2061;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF2061D {
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

    static int op;
    static Map<Integer, Integer> cnt;

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            cnt.merge(v, 1, Integer::sum);
        }
        op = n - m;
        boolean ok = true;
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt();
            if (ok && !f(v)) {
                ok = false;
            }
        }
        out.println(ok && op == 0 ? "Yes" : "No");
    }

    private static boolean f(int v) {
        if (v == 0 || op < 0) {
            return false;
        }
        if (cnt.getOrDefault(v, 0) > 0) {
            cnt.merge(v, -1, Integer::sum);
            return true;
        }
        op--;
        return f(v / 2) && f(v - v / 2);
    }
}
/*
D. Kevin and Numbers
https://codeforces.com/contest/2061/problem/D

灵茶の试炼 2026-02-04
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) m(1≤m≤n) 和长为 n 的数组 a(1≤a[i]≤1e9)，长为 m 的数组 b(1≤b[i]≤1e9)。
执行如下操作若干次：
从 a 中选出两个绝对差 <= 1 的数 x 和 y，从 a 中删除 x 和 y，然后把 x+y 添加到 a 中。
能否把 sort(a) 变成 sort(b)？换句话说，a 的每个数的出现次数要等于 b 的每个数的出现次数。
输出 Yes 或 No。

rating 1600
正难则反。
倒着想，把一个数 x=b[i] 分成两个数，拆分方案是唯一的吗？
是的。
如果 x 是偶数，那么只能拆分成 x/2 和 x/2，其余拆分方案都会让两数之差大于 1。
如果 x 是奇数，那么只能拆分成 (x-1)/2 和 (x+1)/2，其余拆分方案都会让两数之差大于 1。
模拟。
先统计 a 中每个数的出现次数，记在 map 中。
遍历 b 中的元素 x。递归拆分 x，如果 x 在 map 中，那么把 x 的出现次数减一，返回。
否则继续递归拆分 x。
必须保证恰好拆分 n-m 次。如果拆分次数超过 n-m，输出 No。这也同时保证了算法的时间复杂度。
如果拆分后的数字等于 0，输出 No。
代码 https://codeforces.com/problemset/submission/2061/361076485
代码备份（上面打不开的同学看这个）
======

Input
9
2 1
4 5
9
2 1
3 6
9
4 2
1 2 2 2
3 4
4 2
1 1 3 3
3 5
4 2
1 2 3 4
3 5
5 5
1 2 3 4 5
5 4 3 2 1
4 2
1 1 1 1
1 1
4 4
1 1 1 1
1 1 1 2
1 1
1
1000000000
Output
Yes
No
Yes
Yes
No
Yes
No
No
No
 */
