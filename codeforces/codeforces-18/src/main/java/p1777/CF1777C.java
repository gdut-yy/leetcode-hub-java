package p1777;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CF1777C {
    static final int A = 100001;
    static final ArrayList<Integer>[] ds = new ArrayList[A];

    static {
        Arrays.setAll(ds, e -> new ArrayList<>());
        for (int i = 1; i < A; i++) {
            for (int j = i; j < A; j += i) {
                ds[j].add(i);
            }
        }
    }

    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static final int INF = (int) 1e9;

    private static String solve() {
        // 将连续相等的元素替换为一个，类似于 Unix 的 uniq 命令。Compact 修改切片的内容，它不会创建新切片
        // slices.Sort(a)
        // a = slices.Compact(a)
        a = Arrays.stream(a).sorted().distinct().toArray();

        int ans = INF;
        int todo = m;
        int l = 0;
        int[] cnt = new int[m + 1];
        for (int v : a) {
            for (Integer d : ds[v]) {
                if (d > m) break;
                if (cnt[d] == 0) todo--;
                cnt[d]++;
            }

            while (todo == 0) {
                ans = Math.min(ans, v - a[l]);
                for (Integer d : ds[a[l]]) {
                    if (d > m) break;
                    cnt[d]--;
                    if (cnt[d] == 0) todo++;
                }
                l++;
            }
        }
        if (ans == INF) ans = -1;
        return String.valueOf(ans);
    }
}
/*
C. Quiz Master
https://codeforces.com/contest/1777/problem/C

灵茶の试炼 2024-05-01
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5，m 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) m(1≤m≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e5)。
从 a 中选一个子序列 b，要求 1,2,...,m 中的每个数字 x，都能在 b 中找到 x 的倍数。
输出 max(b) - min(b) 的最小值。
注：子序列不一定连续。

rating 1700
滑动窗口。
先预处理每个数的因子。
把 a 排序去重，然后滑窗。
用一个 cnt 数组/哈希表统计窗口内的不超过 m 的因子的出现次数。
如果 1~m 都有，就用窗口两端的元素差更新答案的最小值，然后移除窗口左端元素的因子。
https://codeforces.com/contest/1777/submission/258694584
======

Input
3
2 4
3 7
4 2
3 7 2 9
5 7
6 4 3 5 7
Output
-1
0
3
 */
