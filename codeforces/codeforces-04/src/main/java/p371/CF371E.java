package p371;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF371E {
    static int n, k;
    static int[][] a; // v, i

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = i + 1;
        }
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        long s = 0, ss = 0;
        int mnR = 0;
        long mn = (long) 9e18;
        for (int r = 0; r < n; r++) {
            int[] p = a[r];
            ss += (long) p[0] * Math.min(r - 1, k - 1) - s;
            s += p[0];
            int l = r + 1 - k;
            if (l >= 0) {
                if (ss < mn) {
                    mn = ss;
                    mnR = r + 1;
                }
                s -= a[l][0];
                ss -= s - (long) a[l][0] * (k - 1);
            }
        }

        String[] output = new String[k];
        int j = 0;
        for (int i = mnR - k; i < mnR; i++) {
            output[j++] = String.valueOf(a[i][1]);
        }
        return String.join(" ", output);
    }
}
/*
E. Subway Innovation
https://codeforces.com/contest/371/problem/E

灵茶の试炼 2024-04-04
题目大意：
输入 n(3≤n≤3e5) 和长为 n 的数组 x(-1e8≤x[i]≤1e8)，然后输入 k(2≤k≤n-1)。
一维数轴上有 n 个点，第 i 个点位于 x[i]。
从中选择 k 个点，最小化这 k 个点的两两距离之和。
输出这 k 个点的下标（按照输入顺序，从 1 开始）。
多解输出任意解。

rating 2000
显然这 k 个点是连续的（用反证法证明）。
那么用滑动窗口解决。
设窗口内有 m 个点（分别记作 x1,x2,...xm），那么右侧新增一个点 x[i]，两两距离之和会增加
(x[i] - x1) + (x[i] - x2) + ... + (x[i] - xm)
= x[i] * m - (x1 + x2 + ... + xm)
所以除了维护窗口内点的两两距离之和，还要维护窗口内点的位置和。
左边移出点也同理。
https://codeforces.com/contest/371/submission/254778461
======

Input
3
1 100 101
2
Output
2 3
 */
