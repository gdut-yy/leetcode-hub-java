package p482;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF482B {
    static int n, m;
    static Limit[] qs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        qs = new Limit[m];
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt();
            int q = scanner.nextInt();
            qs[i] = new Limit(l, r, q);
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] ans = new int[n];
        for (int mask = 1; mask < 1 << 30; mask <<= 1) {
            int[] d = new int[n + 1];
            for (Limit q : qs) {
                if ((q.q & mask) > 0) {
                    d[q.l]++;
                    d[q.r]--;
                }
            }
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int v = d[i];
                d[i + 1] += v;
                sum[i + 1] = sum[i];
                if (v > 0) {
                    ans[i] |= mask;
                } else {
                    sum[i + 1]++;
                }
            }
            for (Limit q : qs) {
                if ((q.q & mask) == 0 && sum[q.l] == sum[q.r]) {
                    return "NO";
                }
            }
        }

        return "YES" + System.lineSeparator() +
                Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static class Limit {
        int l, r, q;

        public Limit(int l, int r, int q) {
            this.l = l;
            this.r = r;
            this.q = q;
        }
    }
}
/*
B. Interesting Array
https://codeforces.com/contest/482/problem/B

灵茶の试炼 2022-08-24
题目大意：
输入 n (n≤1e5) 和 m (m≤1e5)，以及 m 个约束，每个约束包含三个数 l r q (1≤l≤r≤n, 0≤q<2^30)。
请你构造一个长为 n 的数组 a，对于每个约束，都满足 a[l] AND a[l+1] AND ... AND a[r] = q。
这里 AND 表示按位与，数组的下标从 1 开始。
如果无法构造，输出 NO；否则输出 YES 和任意一个符合要求的数组 a。

rating 1800
提示 1：分别考虑每个比特位。
提示 2：区间 AND = 1 表示这个区间的比特全是 1；区间 AND = 0 表示这个区间的比特存在 0。
提示 3：用差分数组来记录区间 AND = 1 的情况（可以简单地把区间元素都加上 1）。怎么快速判断区间存在 0 呢？
回答提示 3 的问题。
方法一：求差分数组的前缀和，把所有等于 0 的值视作 1，大于 0 的值视作 0，然后再求前缀和，这样区间内存在 0 就等价于两个前缀和的差大于 0。
https://codeforces.com/problemset/submission/482/169488471
方法二：求差分数组的前缀和，对每个位置，记录左侧最近的 0 的位置。这样对每个区间 [l,r]，判断 r 左侧最近 0 的位置是否不小于 l 即可。
https://codeforces.com/problemset/submission/482/169490547
复杂度都是 O(30(n+m))。
线段树的做法见 https://wangguankan.blog.luogu.org/solution-cf482b
======

input
3 1
1 3 3
output
YES
3 3 3

input
3 2
1 3 3
1 3 2
output
NO
 */
