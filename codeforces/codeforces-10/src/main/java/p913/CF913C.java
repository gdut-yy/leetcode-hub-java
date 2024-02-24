package p913;

import java.util.Scanner;

public class CF913C {
    static int n, L;
    static long[] c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        L = scanner.nextInt();
        c = new long[31];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        for (int i = 0; i < n; i++) {
            if (i > 0 && c[i] > c[i - 1] * 2) {
                c[i] = c[i - 1] * 2;
            }
        }
        for (int i = n; i < 31; i++) {
            c[i] = c[i - 1] << 1;
        }

        long left = 1;
        long right = c[30];
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    static boolean checkMid(long m) {
        long s = 0;
        for (int i = 29; i >= 0; i--) {
            if (m >= c[i]) {
                m -= c[i];
                s |= 1L << i;
            }
        }
        return s >= L;
    }
}
/*
C. Party Lemonade
https://codeforces.com/contest/913/problem/C

灵茶の试炼 2022-05-04
题目大意：
有 n(<=30) 种不同的饮料，第 i（i 从 0 开始）种饮料的体积为 2^i 升，价格为 c[i](<=1e9)，每种饮料的数量无限。
求购买至少 L(<=1e9) 升的饮料至少需要多少钱？

rating 1600
https://codeforces.com/contest/913/submission/83199779
方法一：二分答案
买第 i 种饮料时，如果买两瓶 i-1 类型的饮料要更便宜的话，那就改为买两瓶 i-1。这可以递推算出来买第 i 种饮料的最低价格。
二分答案，然后按饮料体积从大到小贪心去买饮料（由于上面预处理过了，能买的话直接买是最优的）
方法二：直接计算 O(n)
沿用二分答案的想法，在从大到小考虑的时候，额外考虑多买一瓶，多买一瓶后总体积就至少是 L 升了。
代码见官方题解 https://codeforces.com/blog/entry/56992
---
群友 @freya 的解释：
预处理完价格后，从右往左遍历价格数组，用 目前还差的体积/当前位置的体积，在此时有两种方案：
1，向上取整（获得足够体积），暂存结果
2，向下取整（获得部分体积，或者刚好够），去下一个更小的体积，继续重复操作。
======

input
4 12
20 30 70 90
output
150

input
4 3
10000 1000 100 10
output
10

input
4 3
10 100 1000 10000
output
30

input
5 787787787
123456789 234567890 345678901 456789012 987654321
output
44981600785557577
 */
