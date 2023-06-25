package p1825;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1825B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n * m];
            for (int i = 0; i < n * m; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, m, a));
        }
    }

    private static String solve(int n, int m, int[] a) {
        int N = n * m;
        Arrays.sort(a);
        // 最大值，次大值，最小值，次小值
        int max1 = a[N - 1], max2 = a[N - 2], min1 = a[0], min2 = a[1];

        int ans = Math.max(max2 - min1, max1 - min2) * (Math.min(n, m) - 1)
                + (max1 - min1) * (N - Math.min(n, m));
        return String.valueOf(ans);
    }
}
/*
B. LuoTianyi and the Table
https://codeforces.com/contest/1825/problem/B

题目大意：
LuoTianyi 给出了 n·m 个整数的数组 b。她要求你构造一个大小为 n·m 的表 a，其中填满 n·m 个数字，数组中的每个元素必须只使用一次。她还要求你最大化以下价值:
这意味着我们考虑 n·m 个子表，左上角在(1,1)，右下角在(i,j)(1≤i≤n,1≤j≤m)，对于每个这样的子表，计算其中最大元素和最小元素的差值，然后将所有这些差值相加。你应该使结果的总和最大化。
帮她找到最大的可能值，你不需要重建表本身。

贡献法。分类讨论
最大放(1,1)，最小放(1,2)，次小放(2,1)
最大放(1,1)，最小放(2,1)，次小放(1,2)
最小放(1,1)，最大放(1,2)，次大放(2,1)
最小放(1,1)，最大放(2,1)，次大放(1,2)
======

input
5
2 2
1 3 1 4
2 2
-1 -1 -1 -1
2 3
7 8 9 -3 10 8
3 2
4 8 -3 0 -7 1
4 3
-32030 59554 16854 -85927 68060 -64460 -79547 90932 85063 82703 -12001 38762
output
9
0
64
71
1933711
 */
