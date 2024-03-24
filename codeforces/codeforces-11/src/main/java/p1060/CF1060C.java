package p1060;

import java.util.Arrays;
import java.util.Scanner;

public class CF1060C {
    static int n, m;
    static int[] a, b;
    static int x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        x = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int[] minA = f(a);
        int[] minB = f(b);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            long v = minA[i];
            for (int j = 0; j < m; j++) {
                long w = minB[j];

                if ((i + 1) * (j + 1) > ans && v * w <= x) {
                    ans = (i + 1) * (j + 1);
                }
            }
        }
        return String.valueOf(ans);
    }

    static final int INF = (int) 1e9;

    static int[] f(int[] a) {
        int n = a.length;
        int[] minS = new int[n];
        Arrays.fill(minS, INF);
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = i; j >= 0; j--) {
                s += a[j];
                minS[i - j] = Math.min(minS[i - j], s);
            }
        }
        return minS;
    }
}
/*
D. Social Circles
https://codeforces.com/contest/1060/problem/C

灵茶の试炼 2022-08-03
题目大意：
输入 n(≤2000) 和 m(≤2000)，然后输入长为 n 的数组 a 和长为 m 的数组 b，数组元素均为 [1,2000] 内的整数，最后输入一个整数 x(1≤x≤2e9)。
定义矩阵 c[i][j] = a[i]*b[j]。
找到面积最大的子矩阵，其元素和不超过 x，输出这个最大面积（子矩阵的面积=行数*列数）。
如果不存在这样的子矩阵，输出 0。
进阶：有 2000 个询问，每个询问是一个 x（作为原问题的 x），要怎么做？
open question：时间复杂度能否低于平方？
把 * 改成 & 呢？* 和 + 都改成 & 呢？@小羊肖恩

rating 1600
https://codeforces.com/contest/1060/submission/166757182
子矩阵的元素和等于 a 和 b 的子数组的元素和的积。
对 a 和 b，枚举子数组的长度，求固定长度下的元素和的最小值。
遍历所有 a 与 b 的最小值对，求出在最小值的积不超过 x 的情况下的最大长度积。
（最后这部分的遍历可以用双指针优化到 O(n+m)）
======

input
3 3
1 2 3
1 2 3
9
output
4

input
5 1
5 4 2 4 5
2
5
output
1
 */