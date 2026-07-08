package p2171;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF2171E {
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
        List<Integer> a = new ArrayList<>();
        for (int x = 1; x <= n; x += 6) a.add(x);
        for (int x = 5; x <= n; x += 6) a.add(x);
        List<Integer> b = new ArrayList<>();
        for (int x = 2; x <= n; x += 2) b.add(x);
        for (int x = 3; x <= n; x += 6) b.add(x);
        int i = 0, j = 0;
        while (i < a.size() && j + 1 < b.size()) {
            out.print(a.get(i) + " " + b.get(j) + " " + b.get(j + 1) + " ");
            i++;
            j += 2;
        }
        for (; i < a.size(); i++) out.print(a.get(i) + " ");
        for (; j < b.size(); j++) out.print(b.get(j) + " ");
        out.println();
    }
}
/*
E. Anisphia Wynn Palettia and Good Permutations
https://codeforces.com/contest/2171/problem/E

灵茶の试炼 2026-01-29
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(3≤n≤2e5)。
对于序列 p，如果 gcd(p[i],p[i+1]) = gcd(p[i],p[i+2]) = gcd(p[i+1],p[i+2]) = 1，即三个相邻元素两两互质，则称 i 为坏下标。
构造一个 1~n 的排列 p，其中至多有 6 个坏下标。
可以证明，一定存在这样的排列。

rating 2000
如果可以把 1~n 中的数字分成两类 A 和 B，其中 B 中的相邻元素不互质，
那么就可以按照 ABBABBABB... 的方式构造。
注意到，1~n 中的偶数以及 3 的倍数，一共有 n/2 + n/3 - n/6 = 2n/3 个，可以作为 B 类数字。1~n 中的其余元素作为 A 类数字。
换句话说，B = [2,4,6,8,...,3,9,15,21,...]，即所有偶数，后面跟着所有是 3 的倍数的奇数。这样 B 中至多有一对相邻元素是互质的（最后一个偶数与 3）。
代码 https://codeforces.com/contest/2171/submission/360269372
代码备份（上面打不开的同学看这个）
======

Input
4
3
6
8
9
Output
2 1 3
4 1 6 3 5 2
4 1 6 3 5 2 8 7
5 4 8 1 9 3 6 2 7
 */
