package p1955;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1955D {
    static int n, m, k;
    static int[] a;
    static Map<Integer, Integer> cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            cnt = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int v = scanner.nextInt();
                cnt.merge(v, 1, Integer::sum);
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0, c = 0;
        for (int r = 0; r < n; r++) {
            int v = a[r];
            if (cnt.getOrDefault(v, 0) > 0) {
                c++;
            }
            cnt.merge(v, -1, Integer::sum);
            int l = r + 1 - m;
            if (l < 0) {
                continue;
            }
            if (c >= k) {
                ans++;
            }
            if (cnt.merge(a[l], 1, Integer::sum) > 0) {
                c--;
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Inaccurate Subsequence Search
https://codeforces.com/contest/1955/problem/D

灵茶の试炼 2024-10-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n m k(1≤k≤m≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e6)，长为 m 的数组 b(1≤b[i]≤1e6)。
输出 a 有多少个长为 m 的连续子数组 sub，满足 sub 与 b 的交集大小至少是 k。
交集可以有重复元素。

rating 1400
先用 cnt 统计数组 b 中每个元素的出现次数。
然后写一个定长滑窗。
移入 v 就减少 cnt[v]，移出 v 就增大 cnt[v]。
如果减少前/增大后 cnt[v]>0，那么把 c 加一/减一。
如果 c>=k 则把答案加一。
代码 https://codeforces.com/contest/1955/submission/285024486
======

Input
5
7 4 2
4 1 2 3 4 5 6
1 2 3 4
7 4 3
4 1 2 3 4 5 6
1 2 3 4
7 4 4
4 1 2 3 4 5 6
1 2 3 4
11 5 3
9 9 2 2 10 9 7 6 3 6 3
6 9 7 8 10
4 1 1
4 1 5 6
6
Output
4
3
2
4
1
 */
