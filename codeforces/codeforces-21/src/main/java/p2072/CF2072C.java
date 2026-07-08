package p2072;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2072C {
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
        int or = scanner.nextInt();
        int lb0 = (or + 1) & (~or);
        if (n > lb0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lb0; i++) {
                sb.append(i).append(" ");
            }
            for (int i = 0; i < n - lb0; i++) {
                sb.append(or).append(" ");
            }
            out.println(sb.toString().trim());
        } else {
            StringBuilder sb = new StringBuilder();
            int s = 0;
            for (int i = 0; i < n - 1; i++) {
                s |= i;
                sb.append(i).append(" ");
            }
            if ((s | (n - 1)) == or) {
                sb.append(n - 1);
            } else {
                sb.append(or);
            }
            out.println(sb);
        }
    }
}
/*
C. Creating Keys for StORages Has Become My Main Skill
https://codeforces.com/contest/2072/problem/C

灵茶の试炼 2026-04-27
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和 x(0≤x<2^30)。
构造一个长为 n 的数组 a(0≤a[i]<2^30)，满足如下要求：
1. a 中所有元素的按位或（OR）恰好等于 x。
2. 在满足 1 的前提下，mex(a) 尽量大。
注：mex(a) 是不在 a 中的最小非负整数。
输出 a。
多解输出任意解。

rating 1200
为了让 mex 尽量大，a 里面要有 0,1,2,... 哪个数一定不能在 a 中？
比如 x 的二进制为 1011，那么 100，也就是 4，一定不能在 a 中。
如果 n > 4，可以构造 a = [0,1,2,3,x,x,...,x]。
如果 n <= 4 呢？那就只能先往 a 中填入 0,1,...,n-2，然后看下一个数能不能填 n-1（需要满足 x），如果不能填，那就填 x（这不影响 mex）。
代码 https://codeforces.com/problemset/submission/2072/371443779
代码备份（上面打不开的同学看这个）
======

Input
9
1 69
7 7
5 7
7 3
8 7
3 52
9 11
6 15
2 3
Output
69
6 0 3 4 1 2 5
4 1 3 0 2
0 1 2 3 2 1 0
7 0 6 1 5 2 4 3
0 52 0
0 1 8 3 0 9 11 2 10
4 0 3 8 1 2
0 3
 */
