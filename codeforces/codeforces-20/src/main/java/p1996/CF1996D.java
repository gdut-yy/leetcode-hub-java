package p1996;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1996D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) V2.solve();
        out.flush();
    }

    // 方法一
    static class V1 {
        private static void solve() {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            long ans = 0;
            for (int a = 1; a < Math.min(n, x - 1); a++) {
                for (int b = 1; b <= Math.min(n / a, x - a); b++) {
                    ans += Math.min((n - a * b) / (a + b), x - a - b);
                }
            }
            out.println(ans);
        }
    }

    // 方法二
    static class V2 {
        private static void solve() {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            long ans = 0;
            for (int a = 1; ; a++) {
                long c = Math.min((n - a * a) / (a * 2), x - a * 2);
                if (c <= 0) {
                    break;
                }
                ans += c * 3L;
                if (c >= a) {
                    ans -= 2;
                }
                for (int b = a + 1; ; b++) {
                    long d = Math.min((n - a * b) / (a + b), x - a - b) - b;
                    if (d <= 0) {
                        break;
                    }
                    ans += d * 6;
                }
            }
            out.println(ans);
        }
    }
}
/*
D. Fun
https://codeforces.com/contest/1996/problem/D

灵茶の试炼 2025-09-23
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e6，x 之和 ≤1e6。
每组数据输入 n(1≤n≤1e6) 和 x(1≤x≤1e6)。
输出有多少个三元组 (a,b,c) 满足
1. a,b,c 均为正整数。
2. ab+ac+bc ≤ n。
3. a+b+c ≤ x。
注意 (1,1,2) 和 (1,2,1) 是不同的三元组。

rating 1500
方法一
枚举 a=1,2,... 由于 a*b < n，所以 b < n/a，所以枚举 b 的次数是 n * 调和级数。
所以 O(nlogn) 枚举 a 和 b，然后解不等式计算 c 的个数。
时间复杂度 O(nlogn)。
方法一 https://codeforces.com/contest/1996/submission/339367994
方法一备份
---
方法二
分别计算 a=b 的情况和 a<b<c 的情况。
对于 a=b 的情况，枚举 a，计算出 c 的个数，乘以 3，得到 a=b, a=c, b=c 三种排列。如果 c 的最大值 >= a，那么 a=b=c 的情况我们重复算了两次，减去 2。
对于 a<b<c 的情况，由于 a < b <= sqrt(n)，所以可以 O(sqrt(n) * sqrt(n)) = O(n) 枚举 a 和 b，然后解不等式计算 c 的个数，乘以 6 得到所有 (a,b,c) 的排列。
时间复杂度 O(n)。
方法二 https://codeforces.com/contest/1996/submission/339367289
方法二备份
======

Input
4
7 4
10 5
7 1000
900000 400000
Output
4
10
7
1768016938
 */
