package p525;

import java.util.Arrays;
import java.util.Scanner;

public class CF525C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        reverseSort(a);
        long ans = 0;
        int i = -1;
        while (i < n) {
            for (i += 2; i < n && a[i - 1] - a[i] > 1; i++) {
            }
            if (i >= n) break;
            int v = a[i];

            for (i += 2; i < n && a[i - 1] - a[i] > 1; i++) {
            }
            if (i >= n) break;
            int w = a[i];

            ans += (long) v * w;
        }
        return String.valueOf(ans);
    }

    static void reverseSort(int[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
C. Ilya and Sticks
https://codeforces.com/contest/525/problem/C

灵茶の试炼 2023-11-29
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(2≤a[i]≤1e6)。
你有 n 根木棍，a[i] 表示第 i 根木棍的长度。
你可以缩短某些木棍的长度。
这些被缩短的木棍，长度只能减少 1。
你需要选择 4k 根木棍，制作 k 个长方形（一根木棍只能在一个长方形中）。
输出这些长方形面积之和的最大值。

rating 1600
长宽越大越好。
把 a 从大到小排序。
首先找到满足 a[i-1] - a[i] <= 1 的 a[i] 作为第一个边长。
i+=2 继续，然后找到满足 a[i-1] - a[i] <= 1 的 a[i] 作为第二个边长。
两个边长的乘积就是一个矩阵的面积。
然后继续向后找。
这可以用分组循环实现：
【简单题杀手】分组循环 https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/solutions/2528771/jiao-ni-yi-ci-xing-ba-dai-ma-xie-dui-on-zuspx/
https://codeforces.com/contest/525/submission/234411960
======

input
4
2 4 4 2
output
8

input
4
2 2 3 5
output
0

input
4
100003 100004 100005 100006
output
10000800015
 */
