package p1807;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1807G2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }
            System.out.println(solve(n, c));
        }
    }

    private static String solve(int n, int[] c) {
        Arrays.sort(c);
        if (c[0] != 1) {
            return "NO";
        }

        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + c[i];
        }

        for (int i = n - 1; i > 0; i--) {
            if (c[i] > preSum[i]) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
G2. Subsequence Addition (Hard Version)
https://codeforces.com/contest/1807/problem/G2

题目大意：
这两个版本之间唯一的区别是，在这个版本中，约束条件更高。
最初，数组 a 只包含数字 1。您可以执行几个操作来更改数组。在操作中，您可以选择 a 的子序列†，并向 a 中添加一个等于该子序列中所有元素的和的元素。
已知最终数组 c。检查 c 是否可以通过对初始数组 a 执行一定数量(可能是 0)的操作从初始数组 a 中获得。
†一个序列 b 是一个序列 A 的子序列，如果 b 可以通过删除几个(可能是零，但不是全部)元素从 A 中得到。换句话说，选取 k(1≤k≤|a|)个不同指标 i1,i2，…，ik，并在 a 的任意位置插入值为 ai1+ai2+⋯⋯+aik 的新元素。

最大的数只能通过比它小的数相加产生。如果最大的数大于数组剩余数的和，则不能构造成功。
时间复杂度 O(nlogn)
======

input
6
1
1
1
2
5
5 1 3 2 1
5
7 1 5 2 1
3
1 1 1
5
1 1 4 2 1
output
YES
NO
YES
NO
YES
YES
 */
