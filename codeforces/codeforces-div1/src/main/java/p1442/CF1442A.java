package p1442;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1442A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        // 差分数组
        int[] d = new int[n + 1];
        d[0] = a[0];
        for (int i = 1; i < n; i++) {
            d[i] = a[i] - a[i - 1];
        }

        // d[i] < 0 的绝对值和
        int absSum = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] < 0) {
                // absSum += -d[i];
                absSum -= d[i];
            }
        }

        return absSum <= d[0] ? "YES" : "NO";
    }
}
/*
A. Extreme Subtraction
https://codeforces.com/contest/1442/problem/A

灵茶の试炼 2023-02-08
题目大意：
输入 t(≤3e4) 表示 t 组数据，每组数据输入 n(≤3e4) 和长为 n 的数组 a(1≤a[i]≤1e6)。所有数据的 n 之和不超过 3e4。
每次操作，你可以把 a 的任意一个前缀或后缀的元素都减一。
你能否把所有 a[i] 都变成 0？输出 YES 或 NO。

https://codeforces.com/contest/1442/submission/97771793
提示 1：区间加减，用差分数组 d 来思考。
定义 d[0] = a[0]，d[i] = a[i] - a[i-1]。
提示 2：
前缀减一，视作 d[0]-- 和 d[i]++。
后缀减一，视作 d[i]--（和 d[n]++，可以忽略）。
我们需要把 d[i] 都变成 0。
提示 3：
前缀操作用于修改 d[i]<0 的，但是操作次数之和不能超过 d[0]。
后缀操作用于修改 d[i]>0 的，无其他约束。
所以只需要判断「负数 d[i] 的绝对值之和」<= d[0]，满足就是 YES，否则为 NO。
======

input
4
3
1 2 1
5
11 7 9 6 8
5
1 3 1 3 1
4
5 2 1 10
output
YES
YES
NO
YES
 */
