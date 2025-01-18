package p1974;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1974G {
    static int n, x;
    static int[] c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            x = scanner.nextInt();
            c = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = n, s = 0;
        for (int v : c) {
            s -= v;
            pq.add(v);
            while (s < 0) {
                s += pq.remove();
                ans--;
            }
            s += x;
        }
        return String.valueOf(ans);
    }
}
/*
G. Money Buys Less Happiness Now
https://codeforces.com/contest/1974/problem/G

灵茶の试炼 2024-10-10
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) x(1≤x≤1e3) 表示有 n 个月，每个月的月底你会得到 x 元钱。
然后输入长为 n 的数组 c(1≤c[i]≤1e3)，表示你可以在第 i 月的月初支付 c[i] 元钱，可以得到 1 个单位的幸福。
注意第 1 月你没有钱。
输出你能得到的幸福总量的最大值。

rating 2000
反悔贪心。
用最大堆维护买过的幸福价格。
每个幸福先无脑买，如果自己的钱变成负数，就撤销堆顶的购买，重复直到钱 >= 0。
代码 https://codeforces.com/contest/1974/submission/284768534
======

Input
6
3 3
2 2 2
6 5
2 2 8 2 6 8
6 4
4 10 3 8 6 10
2 1
1 1
4 1
4 1 3 1
4 2
1 3 4 3
Output
2
4
3
1
2
1
 */
