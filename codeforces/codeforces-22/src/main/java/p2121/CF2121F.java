package p2121;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF2121F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        long tar = scanner.nextLong();
        int x = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long ans = 0, s = 0;
        Map<Long, Integer> cnt = new HashMap<>();
        List<Long> todo = new ArrayList<>();
        for (int v : a) {
            if (v > x) {
                cnt.clear();
                todo.clear();
                continue;
            }
            todo.add(s);
            if (v == x) {
                for (Long s1 : todo) {
                    cnt.merge(s1, 1, Integer::sum);
                }
                todo.clear();
            }
            s += v;
            ans += cnt.getOrDefault(s - tar, 0);
        }
        out.println(ans);
    }
}
/*
F. Yamakasi
https://codeforces.com/contest/2121/problem/F

灵茶の试炼 2025-07-09
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) s(-2e14≤s≤2e14) x(-1e9≤x≤1e9) 和长为 n 的数组 a(-1e9≤a[i]≤-1e9)。
输出 a 有多少个非空连续子数组 b，满足 sum(b) = s 且 max(b) = x。

rating 1800
首先讨论 a 中没有大于 x 的数的情况。
用前缀和解决，sum[r+1] - sum[l] = s。
其中 a[l] 到 a[r] 中必须包含 x。
所以用 map 统计 sum[l] 的出现次数时，l 必须小于等于 x 的上一次出现位置。不能直接把当前前缀和加到 map 中。
关键思路：用一个 todo 数组记录尚未加到 map 中的 sum[l]，当遇到 x 的时候，就把 todo 中的前缀和加到 map 中，然后把 todo 清空。
如果 a 中有大于 x 的数，遍历到这样的数时，把 map 和 todo 都清空。
代码 https://codeforces.com/contest/2121/submission/327305878
代码备份（Ubuntu Pastebin）
======

Input
9
1 0 0
0
1 -2 -1
-2
3 -1 -1
-1 1 -1
6 -3 -2
-1 -1 -1 -2 -1 -1
8 3 2
2 2 -1 -2 3 -1 2 2
9 6 3
1 2 3 1 2 3 1 2 3
13 7 3
0 -1 3 3 3 -2 1 2 2 3 -1 0 3
2 -2 -1
-2 -1
2 -2 -1
-1 -2
Output
1
0
2
0
2
7
8
0
0
 */
