package p991;

import java.util.Scanner;
import java.util.function.Function;

public class CF991C {
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 1 + sortSearch(n / 2, k -> {
            k++;
            long m = n;
            long s = 0;
            while (m > k) {
                s += k;
                m -= k;
                m -= m / 10;
            }
            return (s + m) * 2 >= n;
        });
        return String.valueOf(ans);
    }

    static long sortSearch(long n, Function<Long, Boolean> f) {
        long l = 0, r = n;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
C. Candies
https://codeforces.com/contest/991/problem/C

灵茶の试炼 2024-05-07
题目大意：
输入 n(1≤n≤1e18)，表示有 n 颗石子。
A 和 B 取石子，每次 A 先取走 k 颗石子（石子剩余个数不足 k 则全取），然后 B 取走 floor(剩余石子数/10) 颗石子。如此交替取石子，直到石子全部取完为止。
输出最小的 k，使得 A 总共可以取走至少一半的石子，即 ceil(n/2) 颗石子。

rating 1500
k 越大越能满足要求（因为留给 B 的剩余石子个数变少），二分答案，然后模拟 check 即可。
由于 B 每次取走 n/10 颗石子，所以每次 check 的时间复杂度为 O(log n)。
总的时间复杂度 O(log^2 n)。
https://codeforces.com/problemset/submission/991/259025052
======

Input
68
Output
3
 */
