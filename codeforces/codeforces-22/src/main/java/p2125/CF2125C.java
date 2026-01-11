package p2125;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2125C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int[] PS = {2, 3, 5, 7};

    private static void solve() {
        long l = scanner.nextLong();
        long r = scanner.nextLong();

        long ans = 0;
        for (int sub = 0; sub < (1 << PS.length); sub++) {
            int mul = 1;
            int temp = sub;
            while (temp > 0) {
                int pos = Integer.numberOfTrailingZeros(temp);
                mul *= PS[pos];
                temp &= temp - 1;
            }

            int sign = 1 - (Integer.bitCount(sub) % 2) * 2;
            ans += (r / mul - ((l - 1) / mul)) * sign;
        }

        out.println(ans);
    }
}
/*
C. Count Good Numbers
https://codeforces.com/contest/2125/problem/C

灵茶の试炼 2025-12-01
题目大意：
输入 T(≤1e3) 表示 T 组数据。
每组数据输入 L R(1≤L≤R≤1e18)。
输出 [L,R] 中有多少个整数 x，满足 x 的所有质因子都至少是两位数。

rating 1100
用 [1,R] 的答案减去 [1,L-1] 的答案。
正难则反，考虑至少包含一个因子 2,3,5,7 的数的个数。
用容斥原理计算。类似 LC2652. 倍数求和。
注：[1,n] 中的 k 的倍数有 floor(n/k) 个。
代码 https://codeforces.com/contest/2125/submission/350792991
代码备份（上面打不开的同学看这个）
======

Input
4
2 100
2 1000
13 37
2 1000000000000000000
Output
21
227
7
228571428571428570
 */
