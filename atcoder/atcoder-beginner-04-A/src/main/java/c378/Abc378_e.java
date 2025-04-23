package c378;

import java.util.Arrays;
import java.util.Scanner;

public class Abc378_e {
    static int n, m;
    static long[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = new long[n + 1];
        for (int r = 1; r <= n; r++) {
            s[r] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        long ss = 0;
        for (int r = 1; r <= n; r++) {
            s[r] = (s[r] + s[r - 1]) % m;
            ans += r * s[r] - ss;
            ss += s[r];
        }
        ans += mergeCount(s) * m;
        return String.valueOf(ans);
    }

    static long mergeCount(long[] a) {
        int n = a.length;
        if (n <= 1) {
            return 0;
        }
        long[] left = Arrays.copyOfRange(a, 0, n / 2);
        long[] right = Arrays.copyOfRange(a, n / 2, n);
        long cnt = mergeCount(left) + mergeCount(right);
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (l < left.length && (r == right.length || left[l] <= right[r])) {
                a[i] = left[l];
                l++;
            } else {
                cnt += n / 2 - l;
                a[i] = right[r];
                r++;
            }
        }
        return cnt;
    }
}
/*
E - Mod Sigma Problem
https://atcoder.jp/contests/abc378/tasks/abc378_e

灵茶の试炼 2025-03-26
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
定义 f(b) = sum(b) % m。
输出 a 的所有非空连续子数组 b 的 f(b) 之和。

利用前缀和，a[l] ~ a[r-1] 的元素和模 m，结果为 (s[r] - s[l]) % m。
直接拆开括号是不对的，因为 (s[r] - s[l]) % m = s[r] % m - s[l] % m 这样算出来的结果可能是负数，需要额外加上 m。
分类讨论：
如果 s[r] % m >= s[l] % m，那么 (s[r] - s[l]) % m = s[r] % m - s[l] % m。
如果 s[r] % m <  s[l] % m，那么 (s[r] - s[l]) % m = s[r] % m - s[l] % m + m。
定义 t[r] = s[r] % m，我们先计算所有的 t[r] - t[l] 之和，再考虑需要额外增加多少个 m。
枚举 r，累加所有 l < r 的 t[l]，得 r * t[r] - sum(t[1] + ... + t[r-1])，后者可以用一个变量 ss 维护。注意下标从 0 开始。
需要额外增加多少个 m？
这就是 t 数组的逆序对。
可以用归并排序或者树状数组解决。
代码 https://atcoder.jp/contests/abc378/submissions/63162302
======

Input 1
3 4
2 5 0
Output 1
10

Input 2
10 100
320 578 244 604 145 839 156 857 556 400
Output 2
2736
 */
