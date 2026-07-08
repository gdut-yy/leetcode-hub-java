package p2031;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2031C {
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
        int[] a = {1, 2, 2, 3, 3, 4, 4, 5, 5, 1, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 1, 6};
        int n = scanner.nextInt();
        if (n % 2 == 0) {
            for (int i = 1; i <= n / 2; i++) {
                out.print(i + " " + i + " ");
            }
        } else if (n < 27) {
            out.print(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int v : a) sb.append(v).append(" ");
            n -= 27;
            for (int i = 14; i < 14 + n / 2; i++) {
                sb.append(i).append(" ").append(i).append(" ");
            }
            out.print(sb.toString().trim());
        }
        out.println();
    }
}
/*
C. Penchick and BBQ Buns
https://codeforces.com/contest/2031/problem/C

灵茶の试炼 2026-03-17
题目大意：
输入 T(≤2e5) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5)。
构造一个长为 n 的整数数组 a，要求：
1. 元素范围 [1, 1e6]。
2. 每个 a[i] 都在 a 中至少出现 2 次。
3. 任意一对相同元素的距离（下标之差）都是完全平方数。
如果无解，输出 -1。
否则输出 a。

rating 1300
如果 n 是偶数，那么构造 1,1,2,2,3,3,...,n/2,n/2 即可。
否则，有一个数要至少出现 3 次。可以让其中一个数出现 3 次，其余数出现 2 次。
设这 3 个数的距离分别为 x y z（其中 z 最大），那么必须满足 x^2+y^2=z^2。这是勾股数。
最小的勾股数是 9+16=25。
假设 1 出现了 3 次。
前两个 1 中间有 8 个数，刚好可以放 4 个数，每个数出现 2 次。
后两个 1 中间有 15 个数，怎么办？
让另一对不为 1 的数也间隔 15 个数。
比如，构造前 27 个数为
1,2,2,3,3,4,4,5,5,1,6,7,7,8,8,9,9,10,10,11,11,12,12,13,13,1,6
剩余的 n-27 个数从 14 开始，继续往后排。
代码 https://codeforces.com/problemset/submission/2031/366389491
代码备份（上面打不开的同学看这个）
======

Input
2
3
12
Output
-1
1 2 3 6 10 2 7 6 10 1 7 3
 */
