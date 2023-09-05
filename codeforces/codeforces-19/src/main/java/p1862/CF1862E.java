package p1862;

import java.nio.charset.StandardCharsets;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1862E {
    static int n, m, d;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            d = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            sum -= d;
            if (minHeap.size() < m) {
                if (a[i] >= 0) {
                    sum += a[i];
                    minHeap.add(a[i]);
                }
            } else if (minHeap.size() == m) {
                if (a[i] > minHeap.peek()) {
                    sum += a[i] - minHeap.remove();
                    minHeap.add(a[i]);
                }
            }
            ans = Math.max(ans, sum);
        }
        return String.valueOf(ans);
    }
}
/*
E. Kolya and Movie Theatre
https://codeforces.com/contest/1862/problem/E

题目大意：
最近，Kolya 发现他所在的城市即将开设一家新的电影院，该电影院将连续 n 天每天放映一部新电影。因此，在数字 1≤i≤n 的那一天，电影院将首映第 i 部电影。此外，Kolya 还发现了电影的时间表，并为每部电影分配了娱乐价值，用 ai 表示。
但是，Kolya 不去电影院的时间越长，下一部电影的娱乐价值下降越大。这个减少量相当于 d·cnt，其中 d 是一个预定值，而 cnt 是距离最后一次去电影院的天数。据悉，在新电影院开业的前一天，柯利亚还去了另一家电影院。
例如，如果 d=2, a=[3,2,5,4,6]，则通过访问索引为 1 和 3 的电影，电影的总娱乐价值将为 a1−d·1+a3−d·2=3−2·1+5−2·2=2。
不幸的是，Kolya 最多只有时间去看 m 部电影。帮助他制定一个去电影院看电影的计划，以使他看的所有电影的总娱乐价值最大化。

根据数据范围排除dp，反悔贪心。
======

input
6
5 2 2
3 2 5 4 6
4 3 2
1 1 1 1
6 6 6
-82 45 1 -77 39 11
5 2 2
3 2 5 4 8
2 1 1
-1 2
6 3 2
-8 8 -2 -1 9 0
output
2
0
60
3
0
7
 */
