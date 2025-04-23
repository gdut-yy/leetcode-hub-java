package c376;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Abc376_e {
    static int n, k;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
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
    }

    private static String solve() {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> a[o]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long s = 0;
        for (int i = 0; i < k; i++) {
            int id = ids[i];
            pq.add(b[id]);
            s += b[id];
        }
        long ans = a[ids[k - 1]] * s;
        for (int i = k; i < n; i++) {
            int id = ids[i];
            if (b[id] < pq.peek()) {
                s -= pq.remove() - b[id];
                ans = Math.min(ans, a[id] * s);
                pq.add(b[id]);
            }
        }

        return String.valueOf(ans);
    }
}
/*
E - Max × Sum
https://atcoder.jp/contests/abc376/tasks/abc376_e

灵茶の试炼 2025-01-21
题目大意：
输入 T(≤2e5) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n k(1≤k≤n≤2e5)，长为 n 的数组 a(1≤a[i]≤1e6)，长为 n 的数组 b(1≤b[i]≤1e6)。
你需要从 n 个下标中选择恰好 k 个下标，组成集合 S。
输出 max(a[i] for i in S) * sum(b[i] for i in S) 的最小值。

假设 a[i] 是最大的，那么我们需要在所有 <= a[i] 的对应的 b[j] 中，选择最小的 k 个数。
把 a 和 b 绑在一起，按照 a 从小到大排序。
然后遍历 a，用最大堆维护最小的 k 个 b[i]。
代码 https://atcoder.jp/contests/abc376/submissions/61770511
======

Input 1
3
3 2
3 7 6
9 2 4
5 3
6 4 1 5 9
8 6 5 1 7
10 6
61 95 61 57 69 49 46 47 14 43
39 79 48 92 90 76 30 16 30 94
Output 1
42
60
14579
 */
