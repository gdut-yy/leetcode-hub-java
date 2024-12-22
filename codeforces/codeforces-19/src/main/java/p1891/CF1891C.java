package p1891;

import java.util.Arrays;
import java.util.Scanner;

public class CF1891C {
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
        long s = 0;
        for (int v : a) s += v;

        Arrays.sort(a);
        long left = (s + 1) / 2;
        long ans = left;
        for (int i = 0; i < n; i++) {
            if (left < a[i]) {
                ans += n - i;
                break;
            }
            left -= a[i];
        }
        return String.valueOf(ans);
    }
}
/*
C. Smilo and Monsters
https://codeforces.com/contest/1891/problem/C

灵茶の试炼 2024-07-16
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
一开始 cnt = 0。
有两种操作，每种都可以执行任意次。
第一种：把一个大于 0 的 a[i] 减少 1，然后 cnt += 1。
第二种：把一个大于等于 cnt 的 a[i] 减少 cnt，然后 cnt = 0。
把所有 a[i] 都变成 0，最少要操作多少次？

rating 1500
提示 1：从特殊情况入手。如果有一个数非常大，最优操作是什么样的？
如果有一个数非常大，可以把其他数都通过操作一搞定，最后把操作二用到这个数上。
这启发我们，用操作一操作小的数，用操作二操作大的数，可以让总操作次数尽量小。
也可以反过来思考：如果用操作一操作大的数，操作二操作小的数，就会因为操作二的限制，导致操作二必须执行很多次。
提示 2：把 cnt 理解为能量，操作一积累能量，操作二释放能量，但释放多少，其实可以自己决定。
设 s = sum(a)，left = ceil(s/2)。
把 a 从小到大排序。不断地把 left 减少 a[i]，直到 left < a[i] 为止。
此时我们积累了足够的能量，剩余的 n-i 个数（i 从 0 开始）全部用操作二搞定。
答案为 ceil(s/2) + n-i。
代码 https://codeforces.com/problemset/submission/1891/270160606
======

Input
4
4
1 3 1 1
4
1 2 1 1
6
3 2 1 5 2 4
2
1 6
Output
4
4
11
5
 */
