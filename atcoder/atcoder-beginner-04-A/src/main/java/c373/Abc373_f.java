package c373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Abc373_f {
    static int n, m;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        g = new ArrayList[m + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        while (n-- > 0) {
            int w = scanner.nextInt();
            int v = scanner.nextInt() - 1;
            g[w].add(v);
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] f = new long[m + 1];
        long[] val = new long[m + 1];
        for (int i = 0; i < g.length; i++) {
            List<Integer> h = g[i];
            if (h.isEmpty()) continue;

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            pq.addAll(h);
            for (int j = 1; j <= m / i; j++) {
                Integer top = pq.remove();
                val[j] = val[j - 1] + top;
                pq.add(top - 2);
            }
            for (int j = m; j >= i; j--) {
                for (int k = 1; k * i <= j; k++) {
                    f[j] = Math.max(f[j], f[j - k * i] + val[k]);
                }
            }
        }
        return String.valueOf(f[m]);
    }
}
/*
F - Knapsack with Diminishing Values
https://atcoder.jp/contests/abc373/tasks/abc373_f

灵茶の试炼 2025-04-04
题目大意：
输入 n(1≤n≤3000) m(1≤m≤3000) 表示有 n 种物品，以及一个容量为 m 的背包。
然后输入 n 行，每行输入第 i 种物品的体积 w(1≤w≤m) 和价值 v(1≤v≤1e9)。
每种物品都有无限个。
为了避免选择过多相同类型的物品，有如下规定：
如果同一种物品选了 k 个，那么这 k 个物品的实际总价值不是 k*v，而是 k*v - k^2。
输出所选物品的价值总和的最大值。物品的体积之和不能超过 m。

重量为 i 的物品至多选 m/i 个。（m 为背包容量）
假如物品的重量互不相同，对于每一种物品，我们都暴力枚举选多少个，那么由调和级数可知，总共只需暴力枚举 O(nlogm) 个物品。
这可以用多重背包的朴素写法解决。
但是，如果有多个物品的重量相同（价值可能不同），每种物品要选多少个呢？
注意到，对于同一个物品，每多选一个该物品，该物品的价值就会减少 2（计算题目所给公式的差分）。
所以可以用最大堆模拟选 1,2,3,...,m/i 个物品的最大价值总和。
代码 https://atcoder.jp/contests/abc373/submissions/64434010
======

Input 1
2 10
3 4
3 2
Output 1
5

Input 2
3 6
1 4
2 3
2 7
Output 2
14

Input 3
1 10
1 7
Output 3
12
 */
