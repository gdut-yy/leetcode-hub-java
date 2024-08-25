package p354;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF354A {
    static int n, l, r, ql, qr;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();
        ql = scanner.nextInt();
        qr = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int pre = 0, suf = 0;
        for (int x : a) {
            suf += x;
        }

        int ans = suf * r + (n - 1) * qr;
        for (int i = 0; i < n; i++) {
            suf -= a[i];
            pre += a[i];
            int cost = pre * l + suf * r;
            int cl = i + 1, cr = n - 1 - i;
            if (cl + 1 < cr) {
                cost += (cr - cl - 1) * qr;
            } else if (cr + 1 < cl) {
                cost += (cl - cr - 1) * ql;
            }
            ans = Math.min(ans, cost);
        }
        return String.valueOf(ans);
    }
}
/*
A. Vasya and Robot
https://codeforces.com/contest/354/problem/A

灵茶の试炼 2023-06-20
题目大意：
输入 n(1≤n≤1e5) l r(1≤l,r≤100) ql qr(1≤l,r≤1e4) 和长为 n 的双端队列 q(1≤q[i]≤100)。
每次操作弹出 q 的队首或者队尾，代价分别为 l*a[i] 和 r*a[i]。
如果上一次和当前都是弹出队首，则代价额外加上 ql。
如果上一次和当前都是弹出队尾，则代价额外加上 qr。
输出清空 q 的最小代价。

rating 1500
https://codeforces.com/contest/354/submission/210296537
前后缀分解。
枚举弹出队首 i 次，那么弹出队尾 n-i 次。
如果 i 比较小，那么操作应该是首尾首尾 ... 尾尾尾尾。
如果 i 比较大，那么操作应该是尾首尾首 ... 首首首首。
======

input
3 4 4 19 1
42 3 99
output
576

input
4 7 2 3 9
1 2 3 4
output
34
 */
