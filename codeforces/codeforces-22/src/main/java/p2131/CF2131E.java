package p2131;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2131E {
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
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) b[i] = scanner.nextInt();
        if (a[n - 1] != b[n - 1]) {
            out.println("NO");
            return;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] != b[i] && (a[i] ^ a[i + 1]) != b[i] && (a[i] ^ b[i + 1]) != b[i]) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }
}
/*
E. Adjacent XOR
https://codeforces.com/contest/2131/problem/E

灵茶の试炼 2026-04-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5)，长为 n 的数组 a(0≤a[i]<2^30) 和长为 n 的数组 b(0≤b[i]<2^30)。
下标从 1 开始。
对于 [1,n-1] 中的每个下标 i，你可以执行如下操作至多一次：
把 a[i] 更新成 a[i] XOR a[i+1]。
你可以按照任意顺序执行这些操作，无需按照下标从小到大的顺序执行。
能否把 a 变成 b？输出 YES 或 NO。

rating 1400
对于 a[i]，它有三种选择：
- 不修改。
- 在修改 a[i+1] 之前（或者不修改 a[i+1]），把 a[i] 更新成 a[i] XOR a[i+1]。
- 在修改 a[i+1] 之后，把 a[i] 更新成 a[i] XOR a[i+1]。由于 a[i+1] 已经变成了 b[i+1]，所以相当于把 a[i] 更新成 a[i] XOR b[i+1]。
如果这三种情况都无法让 a[i] 等于 b[i]，输出 NO。
注意 a[n] 无法修改，如果 a[n] ≠ b[n]，输出 NO。
代码 https://codeforces.com/contest/2131/submission/371060360
代码备份（上面打不开的同学看这个）
======

Input
7
5
1 2 3 4 5
3 2 7 1 5
3
0 0 1
1 0 1
3
0 0 1
0 0 0
4
0 0 1 2
1 3 3 2
6
1 1 4 5 1 4
0 5 4 5 5 4
3
0 1 2
2 3 2
2
10 10
11 10
Output
YES
NO
NO
NO
YES
NO
NO
 */
