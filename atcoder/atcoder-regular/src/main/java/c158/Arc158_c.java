package c158;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Arc158_c {
    static int n;
    static Long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new Long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long mx = 0;
        long ds = 0;
        for (long v : a) {
            mx = Math.max(mx, v);
            for (long x = v; x > 0; x /= 10) {
                ds += x % 10;
            }
        }

        long carry = 0;
        for (long pow10 = 10; pow10 <= mx * 2; pow10 *= 10) {
            long finalPow10 = pow10;
            Arrays.sort(a, Comparator.comparingLong(o -> o % finalPow10));
            int j = n - 1;
            for (Long v : a) {
                while (j >= 0 && v % pow10 + a[j] % pow10 >= pow10) {
                    j--;
                }
                carry += n - 1 - j;
            }
        }
        long ans = ds * n * 2 - carry * 9;
        return String.valueOf(ans);
    }
}
/*
C - All Pair Digit Sums
https://atcoder.jp/contests/arc158/tasks/arc158_c

灵茶の试炼 2023-08-03
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e15)。
定义 f(x) 为 x 的数位和。例如 f(123)=1+2+3=6。
输出所有 f(a[i]+a[j]) 的和，其中 i 取遍 0 到 n-1，j 取遍 0 到 n-1。

https://atcoder.jp/contests/arc158/submissions/44190713
提示 1：f(x+y)=f(x)+f(y)-9*k(x,y)，其中 k(x,y) 是计算 x+y 时产生的进位次数。
提示 2：拆位计算，即：
1. 有多少 a[i]+a[j] 时，个位数发生了进位？也就是看 a[i]%10+a[j]%10 >= 10 是否成立。
把数组按照 a[i]%10 排序，然后用相向双指针统计。
2. 有多少 a[i]+a[j] 时，十位数发生了进位？也就是看 a[i]%100+a[j]%100 >= 100 是否成立。
把数组按照 a[i]%100 排序，然后用相向双指针统计。
3. 依此类推，直到 1000..0 > 2*max(a) 时停止。
提示 3：其实到这就说完了，这里补充下怎么化简 ∑_i ∑_j f(a[i])+f(a[j])
 ∑_i ∑_j f(a[i])+f(a[j])
=∑_i (n*f(a[i])+∑_j f(a[j]))
=(n*∑f(a[i])) + (n*∑f(a[j]))
=2n*∑f(a[i])
======

Input 1
2
53 28
Output 1
36

Input 2
1
999999999999999
Output 2
135

Input 3
5
123 456 789 101 112
Output 3
321
 */