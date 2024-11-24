package p1744;

import java.util.Scanner;

public class CF1744F {
    static int n;
    static int[] pos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            pos = new int[n];
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt();
                pos[v] = i;
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long ans = 1;
        int l = pos[0], r = pos[0];
        for (int m = 2; m <= n; m++) {
            int i = pos[(m - 1) / 2];
            l = Math.min(l, Math.min(i, n - m));
            r = Math.max(r, Math.max(i, m - 1));
            ans += Math.max(m - (r - l), 0);
        }
        return String.valueOf(ans);
    }
}
/*
F. MEX vs MED
https://codeforces.com/contest/1744/problem/F

灵茶の试炼 2024-03-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和一个 0 ~ n-1 的排列 p。
输出 p 有多少个非空连续子数组 b，满足 mex(b) > median(b)。
注：mex(b) 为不在 b 中的最小非负整数，例如 mex([1,0,3]) = 2。
注：median(b) 为 b 的中位数，例如 median([0,1,2,3]) = 1。如果有两个中位数，取小的那个。

rating 2000
注意输入的是一个排列，元素互不相同。
例如子数组长度为 5，那么必然有 median >= 2，比如子数组为 [0,1,2,_,_]，或者 [0,1,3,_,_]
所以要想让 mex > median，mex 至少是 3，也就是说，子数组必须包含 0,1,2。
而当子数组包含 0,1,2 时，median 又一定等于 2，此时 mex > median 必然成立。
一般地，对于长为 m 的子数组，当且仅当子数组包含 0 ~ (m-1)/2 时，mex > median。
从小到大枚举 m 的同时，对于包含 0~(m-1)/2 的最短子数组，维护其左端点的最小值 L 和右端点的最大值 R。
注意 L 必须 <= n-m（否则右端点越界），R 必须 >= m-1（否则左端点越界），这里的数组下标从 0 开始。
那么，所有包含下标 [L,R] 的长为 m 的子数组都满足要求，对答案的贡献是 max(m - (R - L), 0)。
https://codeforces.com/contest/1744/submission/251167082
======

Input
8
1
0
2
1 0
3
1 0 2
4
0 2 1 3
5
3 1 0 2 4
6
2 0 4 1 3 5
8
3 7 2 6 0 1 5 4
4
2 0 1 3
Output
1
2
4
4
8
8
15
6
 */
