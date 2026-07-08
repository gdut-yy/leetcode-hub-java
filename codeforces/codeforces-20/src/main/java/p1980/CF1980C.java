package p1980;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1980C {
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        int[] b = new int[n];
        Map<Integer, Integer> need = new HashMap<>();
        int left = 0;
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
            if (a[i] != b[i]) {
                need.merge(b[i], 1, Integer::sum);
                left++;
            }
        }
        int m = scanner.nextInt();
        int[] d = new int[m];
        for (int i = 0; i < m; i++) d[i] = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (b[i] == d[m - 1]) {
                found = true;
                break;
            }
        }
        if (!found) {
            out.println("NO");
            return;
        }
        for (int i = m - 1; i >= 0; i--) {
            int v = d[i];
            if (need.getOrDefault(v, 0) > 0) {
                need.put(v, need.get(v) - 1);
                left--;
            }
        }
        out.println(left == 0 ? "YES" : "NO");
    }
}
/*
C. Sofia and the Lost Operations
https://codeforces.com/contest/1980/problem/C

灵茶の试炼 2026-02-17
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤2e5。
每组数据输入五行：
n(1≤n≤2e5)。
长为 n 的数组 a(1≤a[i]≤1e9)。
长为 n 的数组 b(1≤b[i]≤1e9)。
m(1≤n≤2e5)。
长为 m 的数组 d(1≤d[i]≤1e9)。
你需要对数组 a 执行 m 次修改操作，其中第 i 次操作把 a 中的某个数改成了 d[i]。
能否把 a 变成 b？
输出 YES 或 NO。

rating 1300
d 的最后一个数必须在 b 中。
d 的其余数字可以被后面的数覆盖，不一定要在 b 中。
但是，对于 a[i] != b[i] 的 b[i]，发生了修改，所以一定要在 d 中。
比如 a[i] != b[i] 的 b[i] 有 5,5,6，那么 d 中至少要有 2 个 5 和 1 个 6。
代码 https://codeforces.com/problemset/submission/1980/363107312
代码备份（上面打不开的同学看这个）
======

Input
7
3
1 2 1
1 3 2
4
1 3 1 2
4
1 2 3 5
2 1 3 5
2
2 3
5
7 6 1 10 10
3 6 1 11 11
3
4 3 11
4
3 1 7 8
2 2 7 10
5
10 3 2 2 1
5
5 7 1 7 9
4 10 1 2 9
8
1 1 9 8 7 2 10 4
4
1000000000 203 203 203
203 1000000000 203 1000000000
2
203 1000000000
1
1
1
5
1 3 4 5 1
Output
YES
NO
NO
NO
YES
NO
YES
 */
