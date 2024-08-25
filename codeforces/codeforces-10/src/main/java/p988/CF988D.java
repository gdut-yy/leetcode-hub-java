package p988;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF988D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, long[] a) {
        Set<Long> set = new HashSet<>();
        for (long x : a) {
            set.add(x);
        }
        long ans1 = a[0], ans2 = Integer.MAX_VALUE;

        for (int k = 0; k < 31; k++) {
            // 差值 d = 2^k
            int d = 1 << k;

            for (long x : a) {
                long x1 = x - d;
                long x2 = x - d - d;
                if (set.contains(x1)) {
                    if (set.contains(x2)) {
                        return 3 + System.lineSeparator()
                                + x2 + " " + x1 + " " + x;
                    }
                    if (ans2 == Integer.MAX_VALUE) {
                        ans1 = x1;
                        ans2 = x;
                    }
                }
            }
        }
        return ans2 == Integer.MAX_VALUE
                ? 1 + System.lineSeparator() + ans1
                : 2 + System.lineSeparator() + ans1 + " " + ans2;
    }
}
/*
D. Points and Powers of Two
https://codeforces.com/contest/988/problem/D

灵茶の试炼 2023-03-30
题目大意：
输入 n(≤1e5) 和长为 n 的整数数组 a(-1e9≤a[i]≤1e9)，没有相同元素。
从 a 中选择尽量多的数，组成集合 b，要求 b 中任意两个数的差的绝对值都是 2 的幂次。
输出 b 的大小以及 b 中的每个数。（没有顺序要求，多解输出任意一解）

rating 1800
https://codeforces.com/contest/988/submission/171194913
如果选两个数 x<y，那么枚举 k 寻找 y-x=2^k，做法类似两数之和。
如果选三个数 x<y<z，那么必须有 y-x=z-y=2^k，否则 z-x 不是 2 的幂次。做法同 2367. 算术三元组的数目
选四个是无法做到的，根据上面可知必须是等差数列，但这样最大-最小是 3*2^k，也不是 2 的幂次。
那么选大于四个数就更不可能了，因为相当于在四个数的基础上多了一个数，四个数不行就更别说大于四个数了。
相似题目: 2367. 算术三元组的数目
https://leetcode.cn/problems/number-of-arithmetic-triplets/
======

input
6
3 5 4 7 10 12
output
3
7 3 5

input
5
-1 2 5 8 11
output
1
8

1
42
1
42

2
536870912 -536870912
2
-536870912 536870912
 */
