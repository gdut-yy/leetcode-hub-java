package c431;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Abc431_f {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }
    static final int MOD = 998244353;
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
    private static void solve() {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int[] cnt = new int[1000001];
        long ans = 1;
        long dup = 1;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            cnt[v]++;
            dup = dup * cnt[v] % MOD;
            while (a[j] < v - d) {
                j++;
            }
            ans = ans * (i - j + 1) % MOD;
        }
        out.println(ans * quickPow(dup, MOD - 2) % MOD);
    }
}
/*
F - Almost Sorted 2
https://atcoder.jp/contests/abc431/tasks/abc431_f

灵茶の试炼 2026-05-28
题目大意：
输入 n(2≤n≤2e5) d(1≤d≤1e6) 和长为 n 的数组 a(1≤a[i]≤1e6)。
输出有多少个 a 的排列 b，其中相邻元素均满足 b[i+1] >= b[i] - d。
答案模 998244353。

rating
计算一个数组的排列，有两种方法：
1. 从左到右考虑，第一个位置有几种填法，第二个位置有几种填法，……
2. 从小到大考虑，先填最小的数，然后次小的数可以插在最小的数的左边或者右边，第三小的数可以插在两个数的左侧、中间或右侧，……
在有值域约束的情况下，用第二种方法算更合适。
把 a 从小到大排序。对于 a[i]，我们需要知道之前填了多少个 >= a[i]-d 的数，这可以二分查找或者同向双指针。设 >= a[i]-d 的第一个数的下标为 j，那么有 i-j+1 个插入位置，乘到答案中。其中 +1 是因为 a[i] 可以插在最右边。
最后，去掉重复元素的排列，即 / (cnt[1]! * cnt[2]! * ... * cnt[1e6]!)。实现时，可以在计数的同时顺带计算排列，具体见代码。
代码 https://atcoder.jp/contests/abc431/submissions/76175723
======

Input 1
4 1
5 2 1 2
Output 1
3

Input 2
5 10
20 40 60 80 100
Output 2
1

Input 3
15 12345
18270 31252 27543 31406 22271 13402 12279 25697 18349 27615 39360 22790 32581 23990 36154
Output 3
858152905
 */
