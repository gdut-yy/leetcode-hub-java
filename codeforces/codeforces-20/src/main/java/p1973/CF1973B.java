package p1973;

import java.util.Scanner;

public class CF1973B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 1;
        for (int i = 0; i < 20; i++) {
            int pre = -1;
            for (int j = 0; j < n; j++) {
                if ((a[j] >> i & 1) == 1) {
                    ans = Math.max(ans, j - pre);
                    pre = j;
                }
            }
            if (pre >= 0) {
                ans = Math.max(ans, n - pre);
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. Cat, Fox and the Lonely Array
https://codeforces.com/contest/1973/problem/B

灵茶の试炼 2024-11-04
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(0≤a[i]<2^20)。
输出最小的正整数 k，使得 a 的所有长为 k 的连续子数组的 OR 都相同。
注意答案是一定存在的，因为 k=n 一定满足要求。

rating 1300
想一想，如果数组只有 0 和 1，要怎么做？
如果数组全为 0，那么答案是 1。
如果数组包含 1，那么至少有一个子数组的 OR 是 1，那么 k 必须比最长连续 0 的长度多 1，否则连续 0 的 OR 就是 0 了。
推广到一般情况，拆位，转换成数组只有 0 和 1 的情况。所有情况取最大值。
代码 https://codeforces.com/problemset/submission/1973/289427285
代码备份（洛谷）
======

Input
7
1
0
3
2 2 2
3
1 0 2
5
3 0 1 4 2
5
2 0 4 0 2
7
0 0 0 0 1 2 4
8
0 1 3 2 2 1 0 3
Output
1
1
3
4
4
7
3
 */
