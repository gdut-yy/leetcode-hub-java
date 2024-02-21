package p175;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF175C {
    static int n, t;
    static int[][] a;
    static long[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        t = scanner.nextInt();
        p = new long[t + 1];
        for (int i = 0; i < t; i++) {
            p[i] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    private static final long INF = (long) 1e18;

    private static String solve() {
        Arrays.sort(a, Comparator.comparingInt(o -> o[1]));

        long[] d = new long[t + 1];
        d[0] = p[0];
        for (int i = 1; i < t; i++) {
            d[i] = p[i] - p[i - 1];
        }
        d[t] = INF;

        long ans = 0;
        int f = 0;
        for (int[] kc : a) {
            long k = kc[0], c = kc[1];
            while (k > d[f]) {
                ans += d[f] * c * (f + 1);
                k -= d[f];
                f++;
            }
            ans += k * c * (f + 1);
            d[f] -= k;
        }
        return String.valueOf(ans);
    }
}
/*
C. Geometry Horse
https://codeforces.com/contest/175/problem/C

灵茶の试炼 2022-07-29
题目大意：
输入 n(≤100) 表示 n 种怪物，然后输入 n 行，每行两个数字表示怪物的数量 (≤1e9)，和怪物的分数(≤1000)。
然后输入 t(≤100) 和一个长为 t 的数组 p，下标从 1 开始，1≤p[1]<p[2]<...<p[t]≤1e12，表示在你累计击败 p[i] 个怪物之后，得分系数将变为 i+1（初始得分系数为 1）。
击败一只怪物的得分 = 怪物的分数 * 当前得分系数。
你可以按照任意顺序打怪，输出击败所有怪物后的最大得分。

rating 1600
https://codeforces.com/contest/175/submission/166070298
贪心：按照得分从小到大打怪（排序不等式），这可以用双指针模拟。
为了方便计算，可以将 p 数组转换成每一段的长度（注意 p 数组实际上是一个前缀和），并在末尾加上一个 1e18 的哨兵。
======

input
1
5 10
2
3 6
output
70

input
2
3 8
5 10
1
20
output
74

6
5 9
63 3
30 4
25 6
48 2
29 9
8
105 137 172 192 632 722 972 981
 */