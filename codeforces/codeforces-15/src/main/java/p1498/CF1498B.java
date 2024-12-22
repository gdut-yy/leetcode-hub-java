package p1498;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1498B {
    static int n, w;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            w = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve1());
        }
    }

    // 写法一
    private static String solve() {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : a) {
            cnt.merge(v, 1, Integer::sum);
        }

        int ans = 0;
        while (n > 0) {
            ans++;
            int left = w;
            for (int i = 1 << 19; i > 0; i >>= 1) {
                int k = Math.min(left / i, cnt.getOrDefault(i, 0));
                cnt.merge(i, -k, Integer::sum);
                n -= k;
                left -= k * i;
            }
        }
        return String.valueOf(ans);
    }

    // 写法二
    private static String solve1() {
        int[] cnt = new int[20];
        for (int v : a) {
            cnt[Integer.numberOfTrailingZeros(v)]++;
        }
        int ans = 0;
        while (n > 0) {
            ans++;
            int left = w;
            for (int i = 19; i >= 0; i--) {
                int k = Math.min(left >> i, cnt[i]);
                cnt[i] -= k;
                n -= k;
                left -= k << i;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. Box Fitting
https://codeforces.com/contest/1498/problem/B

灵茶の试炼 2024-09-30
题目大意：
输入 T(≤5e3) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) w(1≤w≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e6)。
保证 a[i] 都是 2 的幂。保证 max(a)≤w。
有 n 个物品，第 i 个物品的体积是 a[i]。
至少要多少个容量为 w 的背包，才能装下这 n 个物品？

rating 1300
贪心，先装大的，再装小的。
如果先装小的，可能装了一些物品后，这个背包就没法装大的物品了，浪费了一些空间。
注意本题的数据都是 2 的幂，无需像 0-1 背包那样 DP。
贪心的详细证明见官解。
写法一 https://codeforces.com/problemset/submission/1498/283114909
写法二 https://codeforces.com/problemset/submission/1498/283114993
======

Input
2
5 16
1 2 8 4 8
6 10
2 8 8 2 2 8
Output
2
3
 */
