package p1838;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1838B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        // 找出 1,2,n 三个数的下标
        int[] ids = new int[3];
        for (int i = 1; i <= n; i++) {
            if (a[i] == 1) ids[0] = i;
            else if (a[i] == 2) ids[1] = i;
            else if (a[i] == n) ids[2] = i;
        }

        int[] b = ids.clone();
        Arrays.sort(ids);
        // 将 n 换到中间
        return b[2] + " " + ids[1];
    }
}
/*
B. Minimize Permutation Subarrays
https://codeforces.com/contest/1838/problem/B

题目大意：
给你一个大小为 n 的排列 p。你想要最小化 p 的排列子数组的数量。为此，必须执行以下操作一次:
- 选择整数 i,j，其中 1≤i,j≤n，则
- 交换 pi 和 pj。
例如，如果 p=[5,1,4,2,3]，我们选择 i=2, j=3，结果数组将是[5,4,1,2,3]。如果我们选择 i=j=5，结果数组将是[5,1,4,2,3]。
i 和 j 的哪个选项会使排列的子数组的数量最小化?
长度为 n 的排列是由 n 个不同的整数以任意顺序从 1 到 n 组成的数组。例如，[2,3,1,5,4]是一个排列，但[1,2,2]不是一个排列(2 在数组中出现两次)，[1,3,4]也不是一个排列(n=3，但数组中有 4)。
如果数组 a 可以通过删除开头的几个(可能为零或全部)元素和末尾的几个(可能为零或全部)元素来从 b 获得 a，则数组 a 是数组 b 的子数组。

分类讨论
======

input
8
3
1 2 3
3
1 3 2
5
1 3 2 5 4
6
4 5 6 1 2 3
9
8 7 6 3 2 1 4 5 9
10
7 10 5 1 9 8 3 2 6 4
10
8 5 10 9 2 1 3 4 6 7
10
2 3 5 7 10 1 8 6 4 9
output
2 3
1 1
5 2
1 4
9 5
8 8
6 10
5 4
 */
