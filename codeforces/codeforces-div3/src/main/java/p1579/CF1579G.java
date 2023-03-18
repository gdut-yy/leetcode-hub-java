package p1579;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1579G {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        // 答案显然不会超过最大 operate[i] 的 2 倍
        int max = Arrays.stream(a).max().orElseThrow() * 2 + 1;

        // f[i][j] 表示前 i 个数，最右端点纵坐标与折线图最低端点纵坐标差值为 j 时，折线图最大最小值差值的最小值
        int[][] f = new int[n + 1][max];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            for (int j = 0; j < max; j++) {
                if (f[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (j + x < max) {
                    f[i + 1][j + x] = Math.min(f[i + 1][j + x], Math.max(f[i][j], j + x));
                }
                if (j >= x) {
                    f[i + 1][j - x] = Math.min(f[i + 1][j - x], f[i][j]);
                } else {
                    f[i + 1][0] = Math.min(f[i + 1][0], f[i][j] - j + x);
                }
            }
        }
        return String.valueOf(Arrays.stream(f[n]).min().orElseThrow());
    }
}
/*
G. Minimal Coverage
https://codeforces.com/contest/1579/problem/G

题目大意：
给定整数 n 和长度为 n 的数组 a。
给定 n 个长度的线段，它们需要被放置在一个有坐标的无限轴上。第一个线段被放置在坐标轴上，因此它的一个端点位于坐标为 0 的点上。
我们称这个端点为第一个段的“开始”，称它的“结束”为不是开始的端点。下面每个片段的“开始”必须与前一个片段的“结束”一致。
因此，如果下一段的长度为 d，前一段的“结束”坐标为 x，则该段可以放在坐标 [x−d,x]上，然后其“结束”坐标为 x−d，或者放在坐标 [x,x+d] 上，在这种情况下，其“结束”坐标为 x+d。
这些段对轴的总覆盖被定义为它们的总体并集，基本上是至少一个段覆盖的点的集合。很容易表明，覆盖范围也是轴上的一段。
确定通过将所有片段放在轴上而不改变它们的顺序可以获得的最小可能的覆盖长度。

rating2200 DP
相似题目: LCP 65. 舒适的湿度
https://leetcode.cn/problems/3aqs1c/
======

input
6
2
1 3
3
1 2 3
4
6 2 3 9
4
6 8 4 5
7
1 2 4 6 7 7 3
8
8 6 5 1 2 2 3 6
output
3
3
9
9
7
8
 */
