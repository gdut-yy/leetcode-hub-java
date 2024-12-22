package p1902;

import java.util.Arrays;
import java.util.Scanner;

public class CF1902B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (n == 1) return "1";
        Arrays.sort(a);
        int g = 0;
        for (int i = 1; i < n; i++) {
            g = getGCD(g, a[i] - a[i - 1]);
        }

        long s = 0;
        for (int v : a) {
            s += (a[n - 1] - v) / g;
        }

        int ex = n;
        for (int i = n - 1; i > 0; i--) {
            if (a[i] - a[i - 1] > g) {
                ex = n - i;
                break;
            }
        }
        return String.valueOf(s + ex);
    }

    static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
C. Insert and Equalize
https://codeforces.com/contest/1902/problem/C

灵茶の试炼 2024-08-12
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
保证所有 a[i] 互不相同。
首先，你需要往 a 中添加一个不同于任何 a[i] 的数。
然后选定一个正整数 x。
每次操作，可以把一个 a[i] 增加 x。
注意每次操作中的 x 都是一样的。
使所有 a[i] 都相同，至少要操作多少次？

rating 1300
先把 a 从小到大排序。
如果不添加元素，可以选 g=gcd(a[1]-a[0],a[2]-a[1],...,a[n-1]-a[n-2]) 作为 x。
添加元素，添加哪个最好呢？
贪心：如果 a[i]-a[i-1] > g，那么添加 a[i]-g 最好，并且这个数越大越好。
如果所有 a[i]-a[i-1] 都等于 g，可以添加 a[0]-g 或者 a[n-1]+g。
问：为什么不能添加 (a[n-1]+a[n-2])/2？
答：这相当于把 g/2 作为 x，这会导致把 a[i] 变成 a[n-1] 的操作次数翻倍，由此增加的操作次数之和是超过 n 的，不如直接添加 a[0]-g。
特判 n=1 的情况，此时直接输出 1。
代码 https://codeforces.com/contest/1902/submission/275170613
======

Input
3
3
1 2 3
5
1 -19 17 -3 -15
1
10
Output
6
27
1
 */
