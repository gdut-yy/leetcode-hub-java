package p2045;

import java.util.Scanner;

public class CF2045I {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        BIT tr = new BIT(n);
        int[] pre = new int[m];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int x = a[i - 1] - 1;
            if (pre[x] == 0) {
                ans += m - 1; // a[i] 的贡献
            } else {
                ans += tr.query(pre[x] + 1, i); // a[i] 的贡献
                tr.add(pre[x], -1); // 维护 a[i] 的最新下标
            }
            tr.add(i, 1); // 维护 a[i] 的最新下标
            pre[x] = i;
        }
        return String.valueOf(ans);
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int pre(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }

        int query(int l, int r) {
            return pre(r) - pre(l - 1);
        }
    }
}
/*
I. Microwavable Subsequence
https://codeforces.com/contest/2045/problem/I

灵茶の试炼 2024-12-26
题目大意：
输入 n(1≤n≤3e5) m(1≤m≤3e5) 和长为 n 的数组 a(1≤a[i]≤m)。
定义振荡序列为形如 [3,1,3]，[3,2,3,2]，[1] 这种最多由两种元素组成的，相邻元素不同的序列。
定义 f(x,y) 为 a 中最长振荡子序列的长度，其中子序列的每个数要么是 x，要么是 y。
注：子序列不一定连续。
输出所有 f(x,y) 的和，其中 1≤x<y≤m。

rating 2100
https://www.luogu.com.cn/article/zghj5f5w
计算区间内不同的数的个数，方法同 P1972. HH 的项链，用树状数组维护每个数的最新下标，查询区间内下标的个数，即为区间内不同的数的个数。
======

Input
5 4
3 2 1 3 2
Output
13

Input
3 3
1 1 1
Output
2
 */
