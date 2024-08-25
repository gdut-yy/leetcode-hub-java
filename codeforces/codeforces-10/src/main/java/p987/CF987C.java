package p987;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF987C {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;

    private static String solve() {
        int ans = INF;
        for (int j = 1; j < n - 1; j++) {
            int l = INF;
            for (int i = 0; i < j; i++) {
                if (a[i] < a[j]) {
                    l = Math.min(l, b[i]);
                }
            }
            int r = INF;
            for (int i = j + 1; i < n; i++) {
                if (a[i] > a[j]) {
                    r = Math.min(r, b[i]);
                }
            }
            ans = Math.min(ans, l + b[j] + r);
        }

        if (ans == INF) {
            ans = -1;
        }
        return String.valueOf(ans);
    }
}
/*
C. Three displays
https://codeforces.com/contest/987/problem/C

灵茶の试炼 2023-06-26
题目大意：
输入 n(3≤n≤3000) 和长度均为 n 的数组 a(1≤a[i]≤1e9) 和数组 b(1≤b[i]≤1e8)。
输出在满足 i<j<k 且 a[i]<a[j]<a[k] 的前提下，b[i]+b[j]+b[k] 的最小值。
如果不存在这样的 (i,j,k)，输出 -1。
进阶：O(nlogn)。
进阶：改成 a 的长为 4 的递增子序列（本题长为 3）。改成 5？改成 m？

rating 1400
https://codeforces.com/contest/987/submission/211026113
最简单的做法：枚举 j，然后枚举左边的满足 a[i]<a[j] 的最小的 b[i]，枚举右边的满足 a[k]>a[j] 的最小的 b[k]，用 b[i]+b[j]+b[k] 更新答案的最小值。
其它做法：定义 dp[i][j=0/1/2] 表示 a 的前 i 个数中，长为 j+1 的递增子序列的 b 之和的最小值。
在左边找比 a[i] 小的 a[p]，从 dp[p][j-1] 转移过来。
对 a 离散化，可以用线段树优化至 O(nlogn)。
相关题目: 2407. 最长递增子序列 II
https://leetcode.cn/problems/longest-increasing-subsequence-ii/
======

input
5
2 4 5 4 10
40 30 20 10 40
output
90

input
3
100 101 100
2 4 5
output
-1

input
10
1 2 3 4 5 6 7 8 9 10
10 13 11 14 15 12 13 13 18 13
output
33
 */
