package p1822;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1822B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, long[] a) {
        Arrays.sort(a);
        long res = Math.max(a[0] * a[1], a[n - 2] * a[n - 1]);
        return String.valueOf(res);
    }
}
/*
B. Karina and Array
https://codeforces.com/contest/1822/problem/B

题目大意：
Karina 有一个 n 个整数的数组 a1,a2,a3,...,an。她喜欢乘数字，所以她认为一对数字的美在于它们的乘积。数组的美就是数组中相邻的一对元素的最大美。
例如，对于 n=4, a=[3,5,7,4]，这个数组的美妙之处在于 max(3·5,5·7,7·4)= max(15,35,28) = 35。
Karina 希望她的阵列尽可能的漂亮。为了实现她的目标，她可以从数组中删除一些元素(可能为零)。在 Karina 删除她想要的所有元素后，数组必须包含至少两个元素。
不幸的是，Karina 没有足够的时间来完成她的所有任务，所以她要求你计算她通过删除任意数量的元素(可能为零)所能获得的数组的最大美感。

贪心。答案要么由最小两个数乘积结果，要么为最大两个数乘积结果。
======

input
7
4
5 0 2 1
3
-1 1 0
5
2 0 -1 -4 0
6
-8 4 3 7 1 -9
6
0 3 -2 5 -4 -4
2
1000000000 910000000
7
-1 -7 -2 -5 -4 -6 -3
output
10
0
4
72
16
910000000000000000
42
 */
