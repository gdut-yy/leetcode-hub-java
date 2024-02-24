package p1251;

import java.util.Arrays;
import java.util.Scanner;

public class CF1251D {
    static int n;
    static long money;
    static Pair[] ps;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            money = scanner.nextLong();

            ps = new Pair[n];
            for (int i = 0; i < n; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                ps[i] = new Pair(l, r);
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long baseCost = 0;
        for (Pair p : ps) {
            baseCost += p.l;
        }
        Arrays.sort(ps, (o1, o2) -> Long.compare(o2.l, o1.l));

        long left = 0;
        long right = money + (long) 1e9 + 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(baseCost, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left - 1);
    }

    private static boolean checkMid(long baseCost, long x) {
        long cnt = 0;
        long cost = baseCost;
        for (Pair p : ps) {
            // 把 r >= x 的找出来（n/2 个）
            if (p.r >= x) {
                cnt++;
                if (p.l < x) {
                    // 计算额外发出的工资
                    cost += x - p.l;
                }
                if (2 * cnt - 1 == n) {
                    // 能否发出工资
                    return !(cost <= money);
                }
            }
        }
        // x 取大了
        return true;
    }

    static class Pair {
        long l, r;

        public Pair(long l, long r) {
            this.l = l;
            this.r = r;
        }
    }
}
/*
D. Salary Changing
https://codeforces.com/contest/1251/problem/D

灵茶の试炼 2022-04-21
题目大意：
你的公司有 n(<2e5 且为奇数) 名员工，你需要给他们发共计不超过 s(<=1e14) 的工资，对于第 i 位员工，他的工资应该在区间 [l[i], r[i]] 范围内(1<=l[i]<=r[i]<=1e9)。
保证 s 不小于所有 l[i] 之和。
问如何分配 s 可以使这 n 个人的工资的中位数最大。输出这个最大中位数。

rating 1900
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1251d
https://www.luogu.com.cn/problem/solution/CF1251D
提供一个比官方题解还简洁的二分思路。
观察发现中位数越大，发出的工资越多，这满足二分条件。
先预处理，将数据按照  l 从大到小排序。
然后二分中位数 x，贪心地计算所发工资是否不超过 s：
从左到右扫描排序后的数据，把 r≥x 的找出来计算额外发出的工资 max(0,x−l)，直到找到 n/2 个。这样保证找到的数加上额外发出的工资都是不小于 x 的，同时额外发出的工资尽可能地小。
对于 r<x 的数据，有 l≤r<x，所以这些数据全部位于中位数的一侧，额外发工资不会影响中位数，故不处理。
======

input
3
3 26
10 12
1 4
10 11
1 1337
1 1000000000
5 26
4 4
2 4
6 8
5 6
2 7
output
11
1337
6
 */