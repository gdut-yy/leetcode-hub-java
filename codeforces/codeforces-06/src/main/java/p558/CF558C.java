package p558;

import java.util.Scanner;

public class CF558C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int MAX_N = (int) 1e5;

    private static String solve() {
        int[] cnt = new int[MAX_N + 1];
        long[] sum = new long[MAX_N + 1];
        for (int v : a) {
            for (int c = 0; v > 0; v /= 2, c++) {
                cnt[v]++;
                sum[v] += c;
            }
        }

        int v = MAX_N;
        while (cnt[v] < n) {
            v--;
        }
        long ans = sum[v];
        v *= 2;
        while (v <= MAX_N && cnt[v] * 2 > n) {
            ans -= cnt[v] * 2L - n;
            v *= 2;
        }
        return String.valueOf(ans);
    }
}
/*
C. Amr and Chemistry
https://codeforces.com/contest/558/problem/C

灵茶の试炼 2022-09-29
题目大意：
输入 n(≤1e5) 和一个长为 n 的数组 a (1≤a[i]≤1e5)。
每次操作你可以将某个 a[i] 乘二或除二（下取整）。
输出至少需要多少次操作，可以让 a 的所有数都相同。
你能做到 O(nlogU) 的时间复杂度吗？ U=max(a)

rating 1900
https://codeforces.com/contest/558/submission/173900538
方法一：朴素思路
提示 1：对于任意一个 a[i]，它能操作出多少个不同的数字？
观察：每个数字不会超过 max(a)，继续增大是没有意义的。
不妨以 a[0] 为准，设所有数字最终变成 x，那么 x 必然是由 a[0] 的二进制表示的某个前缀+若干个尾 0 组成（即 x = a[0] 右移若干位再左移若干位）。因此得到的不同 x 不会超过 O(17^2) 个。
提示 2：统计每个 a[i] 生成的 x，以及 a[i] 变成 x 需要操作多少次。如果能生成 n 个 x，那么对应的的操作次数就可能是答案（取最小值）。
方法二：优化思路（上面链接的写法）
方法一需要 O(17^2 * n) 的时间，可以进一步优化到 O(17n)。
统计每个前缀的出现次数 cnt[v]，以及减小到该前缀所需的操作次数 sum[v]。
那么最大的满足 cnt[v] = n 的 v 就是 x 的最小值，继续往下减小是没有意义的（最长公共前缀）。
对应的 sum[v] 也是答案的最大值。
根据中位数贪心的启发，尝试 2v 4v 8v ... 看能否得到更优解。
考虑操作次数的变化量，从 v 到 2v，有 cnt[2v] 个前缀可以少操作一次，有 n-cnt[2v] 个前缀要多操作一次。如果 cnt[2v] > n-cnt[2v]，那么所有数变成 2v 会得到更小的操作次数。依此类推。
如果 cnt[2v] > n-cnt[2v] 不成立，其实可以直接退出循环，这是因为数字越大 cnt 值就越小。
======

input
3
4 8 2
output
2

input
3
3 5 6
output
5
 */
