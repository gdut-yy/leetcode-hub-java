package p1864;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1864C {
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
        List<Integer> ans = new ArrayList<>();
        ans.add(n);
        while ((n & (n - 1)) > 0) {
            n &= n - 1;
            ans.add(n);
        }
        while (n > 1) {
            n /= 2;
            ans.add(n);
        }
        out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(ans.get(i));
        }
        out.println(sb);
    }
}
/*
C. Divisor Chain
https://codeforces.com/contest/1864/problem/C

灵茶の试炼 2026-03-24
题目大意：
输入 T(≤1e3) 表示 T 组数据。
每组数据输入 n(2≤n≤1e9)。
执行如下操作（至多 1000 次），直到 n 变成 1：
选择 n 的一个因子 d，执行 n -= d。
约束：同一个 d 至多选择 2 次。
例如 5 -> 4 -> 3 -> 2 -> 1 是不行的，每次都减去 1，一共减了 4 次 1，超过了 2 次。
例如 5 -> 4 -> 2 -> 1 是可以的。
输出两行：
第一行，输出操作过程中出现的数字个数。
第二行，输出具体的数字。第一个数一定是 n，最后一个数一定是 1，中间的数是操作后的 n'。
多解输出任意解。
可以证明，一定可以把 n 变成 1。

rating 1300
如果 n 是 2^k，那么每次操作减半即可，因子互不相同。
对于一般的 n，能不能把 n 变成 2^k？
可以。注意到 lowbit(n) 一定是 n 的因子，把 n 减去 lowbit(n) 后，下一个 lowbit(n') 和之前的 lowbit 一定不同。
我们跑了两轮循环，每个循环内的因子互不相同，所以每个因子至多使用两次，符合题目要求。
代码 https://codeforces.com/problemset/submission/1864/367904901
代码备份（上面打不开的同学看这个）
======

Input
3
3
5
14
Output
3
3 2 1
4
5 4 2 1
6
14 12 6 3 2 1
 */
