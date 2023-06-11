package p1832;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1832B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, k, a));
        }
    }

    private static String solve(int n, int k, int[] a) {
        Arrays.sort(a);

        long sum = 0L;
        for (int x : a) {
            sum += x;
        }

        // 前后缀分解
        long[] pre = new long[k + 1];
        for (int i = 0; i < k; i++) {
            pre[i + 1] = a[i * 2] + a[i * 2 + 1] + pre[i];
        }
        long[] suf = new long[k + 1];
        for (int i = 0; i < k; i++) {
            suf[i + 1] = a[n - 1 - i] + suf[i];
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            min = Math.min(min, pre[i] + suf[k - i]);
        }
        return String.valueOf(sum - min);
    }
}
/*
B. Maximum Sum
https://codeforces.com/contest/1832/problem/B

题目大意：
给定一个数组 a1,a2，…，an，其中所有元素都不同。
你必须对它进行 k 次运算。在每次操作中，您只执行以下两个操作中的一个(您自己选择执行哪个操作):
在数组中找到两个最小元素，并删除它们;
找到数组中最大的元素，并删除它。
您必须计算结果数组中元素的最大可能和。

前后缀分解。
一开始看错题，以为要么去掉最小，要么去掉最大。滑动窗口一写发现情况并不简单。
普通双指针贪心也是不行的。
======

input
6
5 1
2 5 1 10 6
5 2
2 5 1 10 6
3 1
1 2 3
6 1
15 22 12 10 13 11
6 2
15 22 12 10 13 11
5 1
999999996 999999999 999999997 999999998 999999995
output
21
11
3
62
46
3999999986
 */
