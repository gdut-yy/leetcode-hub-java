package p1969;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1969D {
    static int n, k;
    static int[][] a; // x, y

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                a[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(a, Comparator.comparingInt(o -> -o[1]));

        long s = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(a[i][0]);
            s -= a[i][0];
        }
        for (int i = k; i < n; i++) {
            s += Math.max(a[i][1] - a[i][0], 0);
        }

        long ans = Math.max(s, 0);
        for (int i = k; i < n; i++) {
            s -= Math.max(a[i][1] - a[i][0], 0);
            if (k > 0 && a[i][0] < pq.peek()) {
                s += pq.remove() - a[i][0];
                ans = Math.max(ans, s);
                pq.add(a[i][0]);
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Shop Game
https://codeforces.com/contest/1969/problem/D

灵茶の试炼 2024-11-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) k(0≤k≤n)，长为 n 的数组 a(1≤a[i]≤1e9) 和长为 n 的数组 b(1≤b[i]≤1e9)。
有 n 个商品，Alice 买进价格是 a[i]，卖给 Bob 的价格是 b[i]。
首先 Alice 从 a 中选一个子集 sub，并花费 sum(sub) 元钱。sub 可以为空。
如果 sub 的大小 <= k，那么这些商品免费给 Bob。
否则 Bob 选择其中的 k 个商品免费拿走，剩余的商品花费 b[i] 购买。
Alice 的利润为从 Bob 那赚到的钱，减去购买商品的钱。
Alice 希望自己的利润最大化，而 Bob 希望 Alice 的利润最小化。
输出在 Alice 和 Bob 都采取最优行动的情况下，Alice 的利润。

rating 1900
首先 Alice 要么不买（利润为 0），要么至少买 k+1 个。
枚举 b[i] 作为最小的 Bob 免费拿走的商品价格。
价格 >= b[i] 的商品，Alice 选择其中 a[i] 最小的 k 个购买。这可以在枚举 b[i] 的过程中，用最大堆维护。
< b[i] 的商品，b[i] - a[i] > 0 的都要买。这可以把 b 从大到小排序后，用前后缀分解做（本题只需后缀和）。
代码 https://codeforces.com/contest/1969/submission/291322276
代码备份（洛谷）
======

Input
4
2 0
2 1
1 2
4 1
1 2 1 4
3 3 2 3
4 2
2 1 1 1
4 2 3 2
6 2
1 3 4 9 1 3
7 6 8 10 6 8
Output
1
1
0
7
 */
