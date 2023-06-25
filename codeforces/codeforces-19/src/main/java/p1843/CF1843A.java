package p1843;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1843A {
    public static void main(String[] args) {
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
        Arrays.sort(a);
        int ans = 0;
        for (int i = 0; i < n / 2; i++) {
            ans += a[n - 1 - i] - a[i];
        }
        return String.valueOf(ans);
    }
}
/*
Codeforces Round 881 (Div. 3) https://www.bilibili.com/video/BV1UX4y1i7Ej/
A. Sasha and Array Coloring
https://codeforces.com/contest/1843/problem/A

题目大意：
Sasha 找到了一个由 n 个整数组成的数组 a，并要求你绘制元素。
您必须绘制数组的每个元素。您可以使用任意多的颜色，但是每个元素都应该被绘制成一种颜色，并且对于每种颜色，应该至少有一个该颜色的元素。
一种颜色的代价是 max(S) - min(S)的值，其中 S 是该颜色的元素序列。整个着色的成本是所有颜色的成本之和。
例如，假设你有一个数组 a=[1,5,6,3,4]，你把它的元素涂成如下两种颜色:位置 1,2 和 5 上的元素颜色为 1;位置 3 和 4 上的元素颜色为 2。然后:
- 颜色 1 的代价是 max([1,5,4])−min([1,5,4])=5−1=4;
- 颜色 2 的代价是 max([6,3])−min([6,3])=6−3=3;
- 着色的总成本是 7。
对于给定的数组 a，您必须计算着色的最大可能代价。

排序后分组，由于只关心最大最小值，所以只考虑两个数即可。
======

input
6
5
1 5 6 3 4
1
5
4
1 6 3 9
6
1 13 9 3 7 2
4
2 2 2 2
5
4 5 2 2 3
output
7
0
11
23
0
5
 */
