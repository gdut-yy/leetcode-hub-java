package p166;

import java.util.Scanner;

public class CF166E {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long d = 1, abc = 0;
        for (int i = 0; i < n; i++) {
            // d, abc = abc*3%p, (d+abc*2)%p
            long new_abc = (d + abc * 2) % MOD;

            d = abc * 3 % MOD;
            abc = new_abc;
        }
        return String.valueOf(d);
    }
}
/*
E. Tetrahedron
https://codeforces.com/contest/166/problem/E

灵茶の试炼 2022-07-05
题目大意：
输入正整数 n(n<=1e7)。
一只蚂蚁站在一个四面体的某个顶点 D 上，沿着四面体的棱行走。
输出它走了恰好 n 条棱后，又重新回到顶点 D 的路径数，模 1e9+7 的结果。
路径中间可以经过 D。

rating 1500
https://codeforces.com/contest/166/submission/132173160
相对于起点 D，A/B/C 三点都是对称的。
设 f[i][0] 表示走了 i 条棱到达 D 的方案数，f[i][1] 表示走了 i 条棱到达 A/B/C 的方案数。
则 D 可以从 A/B/C 转移过来，A 可以从 B/C/D 转移过来，等等。
据此得：
f[i][0] = f[i-1][1] * 3
f[i][1] = f[i-1][0] + f[i-1][1] * 2
初始值 f[0][0] = 1, f[0][1] = 0。
答案为 f[n][0]。
注意用 64 位整数。
======

input
2
output
3

input
4
output
21
 */
