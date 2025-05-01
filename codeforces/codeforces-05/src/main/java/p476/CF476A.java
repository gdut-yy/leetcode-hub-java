package p476;

import java.util.Scanner;

public class CF476A {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int ans = (n + 1) / 2;
        ans += (m - ans % m) % m;
        if (ans > n) {
            ans = -1;
        }
        return String.valueOf(ans);
    }
}
/*
A. Dreamoon and Stairs
https://codeforces.com/contest/476/problem/A

灵茶の试炼 2025-03-31
题目大意：
输入 n(1≤n≤1e4) 和 m(2≤m≤10)。
从 s=0 开始，每次操作可以把 s 增加 1 或者增加 2。
目标是让 s=n，且操作次数必须是 m 的倍数。
输出最少操作次数。
如果无法做到，输出 -1。

rating 1000
尽量使用 2 或者尽量使用 1，可以得到答案的范围为 [ceil(n/2), n]。范围中的数都可以取到。
问题相当于计算区间中最小的 m 的倍数。
如果这个数 > n，输出 -1。
代码 https://codeforces.com/contest/476/submission/312875511
代码备份（洛谷）
======

Input
10 2
Output
6

Input
3 5
Output
-1
 */
