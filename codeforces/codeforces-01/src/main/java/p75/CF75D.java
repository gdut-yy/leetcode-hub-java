package p75;

import java.util.Scanner;

public class CF75D {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        Res[] rs = new Res[n];
        for (int i = 0; i < n; i++) {
            rs[i] = new Res(0, inf, -inf, -inf);
            long s = -inf;
            int k = scanner.nextInt();
            while (k-- > 0) {
                long v = scanner.nextLong();
                rs[i].s += v;
                rs[i].minS = Math.min(rs[i].minS, rs[i].s);
                rs[i].maxS = Math.max(rs[i].maxS, rs[i].s);
                s = Math.max(s + v, v);
                rs[i].maxSubS = Math.max(rs[i].maxSubS, s);
            }
        }

        int id = scanner.nextInt();
        Res r = rs[id - 1];
        long ans = r.maxSubS;
        long minS = Math.min(0, r.minS);
        long base = r.s;
        while (--m > 0) {
            id = scanner.nextInt();
            r = rs[id - 1];
            ans = Math.max(ans, Math.max(r.maxSubS, r.maxS + base - minS));
            minS = Math.min(minS, base + r.minS);
            base += r.s;
        }
        System.out.println(ans);
    }

    static final long inf = (long) 1e9;

    static class Res {
        long s, minS, maxS, maxSubS;

        public Res(long s, long minS, long maxS, long maxSubS) {
            this.s = s;
            this.minS = minS;
            this.maxS = maxS;
            this.maxSubS = maxSubS;
        }
    }
}
/*
D. Big Maximum Sum
https://codeforces.com/contest/75/problem/D

灵茶の试炼 2022-04-26
题目大意：
背景：最大子段和 https://leetcode-cn.com/problems/maximum-subarray/
有 n(<=50) 个小数组，每个小数组的长度不超过 5000，元素值在 [-1000,1000] 范围内。
现在有一个压缩数组，由 m(<=250000) 个范围在 [1,n] 的下标组成，每个下标对应一个小数组。
求压缩数组解压后（用小数组替换下标）组成的大数组的最大子段和。

rating 2000
不错的题目，考察了最大子段和的两种计算方法
1. 定义状态 dp[i] 表示以 a[i] 结尾的最大子段和，则有状态转移方程 dp[i]=max(dp[i−1],0)+a[i]
2. 遍历 a 的同时维护前缀和的最小值，则遍历到 a[i] 时，当前最大子段和为 sum[i]-min(sum[j]), j<i
小数组用第一种方法算，大数组用第二种方法算，由于大数组需要知道前面的 min，小数组里面还需要算出 min 出来
具体见 https://codeforces.com/contest/75/submission/122293599
======

input
3 4
3 1 6 -2
2 3 3
2 -5 1
2 3 1 3
output
9

input
6 1
4 0 8 -3 -10
8 3 -2 -5 10 8 -9 -5 -4
1 0
1 -3
3 -8 5 6
2 9 6
1
output
8
 */
