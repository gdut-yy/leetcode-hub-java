package p1140;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1140C {
    static int n, k;
    static int[][] tb;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        tb = new int[n][2];
        for (int i = 0; i < n; i++) {
            tb[i][0] = scanner.nextInt();
            tb[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(tb, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        PriorityQueue<Integer> h = new PriorityQueue<>();
        long sum = 0, ans = 0;
        for (int[] p : tb) {
            h.add(p[0]);
            sum += p[0];
            while (h.size() > k) {
                sum -= h.remove();
            }
            ans = Math.max(ans, sum * p[1]);
        }
        return String.valueOf(ans);
    }
}
/*
C. Playlist
https://codeforces.com/contest/1140/problem/C

灵茶の试炼 2023-11-08
题目大意：
输入 n k(1≤k≤n≤3e5) 和 n 个物品，每个物品输入两个属性值 t[i] 和 b[i]，范围 [1,1e6]。
从这 n 个物品中选出至多 k 个物品，输出这 k 个物品的 sum(t) * min(b) 的最大值。

rating 1600
按照 b 从大到小排序，这样可以枚举最小的 b。把当前的 t 和左边的 t 都加到一个最小堆中，从而维护堆中最大的 k 个数的和。
https://codeforces.com/contest/1140/submission/231732136
======

input
4 3
4 7
15 1
3 6
6 8
output
78

input
5 3
12 31
112 4
100 100
13 55
55 50
output
10000
 */
