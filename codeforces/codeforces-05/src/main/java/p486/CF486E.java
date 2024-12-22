package p486;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF486E {
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

    private static String solve() {
        int[] pre = new int[n];
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = a[i];
            int j = lowerBound(g, v);
            if (j == g.size()) g.add(v);
            else g.set(j, v);
            pre[i] = j + 1;
        }

        int[] suf = new int[n];
        g.clear();
        for (int i = n - 1; i >= 0; i--) {
            int v = -a[i];
            int j = lowerBound(g, v);
            if (j == g.size()) g.add(v);
            else g.set(j, v);
            suf[i] = j + 1;
        }

        int lis = g.size();
        char[] ans = new char[n];
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (pre[i] + suf[i] - 1 == lis) {
                ans[i] = '3'; // 暂定是 3
                cnt[pre[i]]++; // 如果有多个相同的 p，则 ans[i] = '2'（下面判断）
            } else {
                ans[i] = '1'; // 不在任何 LIS 上
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == '3' && cnt[pre[i]] > 1) {
                ans[i] = '2';
            }
        }
        return new String(ans);
    }

    static int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
E. LIS of Sequence
https://codeforces.com/contest/486/problem/E

灵茶の试炼 2024-05-31
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e5)。
定义 LIS 为 a 的最长严格递增子序列，注意可能有多个 LIS。
对于每个 i：
如果 a[i] 不在任何 LIS 中，输出 1。
如果 a[i] 在至少一个 LIS 中，但不在所有 LIS 中，输出 2。
如果 a[i] 在所有 LIS 中，输出 3。
输出在同一行，不要加空格。
注意，a=[1,2,2,3] 有两个相同的 LIS [1,2,3]，其中 1 和 3 都在这两个 LIS 中，但 2 只在其中一个 LIS 不在另一个 LIS 中，所以输出 3223。
双倍经验 https://atcoder.jp/contests/abc354/tasks/abc354_f

rating 2200
计算 a[0] 到 a[i] 的，以 a[i] 结尾的 LIS 长度，记作 pre[i]。
计算 a[i] 到 a[n-1] 的，以 a[i] 开头的 LIS 长度，记作 suf[i]。
如果 pre[i] + suf[i] - 1 ≠ 整个数组的 LIS 长度，那么 a[i] 一定不在任何 LIS 中。（减一是因为 a[i] 算重复了）
否则，a[i] 是否一定在所有 LIS 中呢？
例如 a=[1,2,2,3]，这里的两个 2 对应的 pre[i] 是一样的，a[2]=2 虽然在 LIS 中，但不在所有 LIS 中。
（在 pre[i] + suf[i] - 1 = 整个数组的 LIS 长度的前提下）统计 pre[i] 的出现次数，如果只出现一次，那么 a[i] 一定在所有 LIS 中，否则 a[i] 不在所有 LIS 中。详细证明
关于 LIS 的二分做法，见 视频讲解
关于如何求 pre 和 suf，见下面代码
https://codeforces.com/problemset/submission/486/263394726
相似题目: 1964. 找出到每个位置为止最长的有效障碍赛跑路线
https://leetcode.cn/problems/find-the-longest-valid-obstacle-course-at-each-position/
======

Input
1
4
Output
3

Input
4
1 3 2 5
Output
3223

Input
4
1 5 2 3
Output
3133
 */
