package p1175;

import java.util.Arrays;
import java.util.Scanner;

public class CF1175D {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + a[i];
        }

        long ans = k * s[n];
        s = Arrays.copyOfRange(s, 1, n);
        Arrays.sort(s);
        for (int i = 0; i < k - 1; i++) {
            ans -= s[i];
        }
        return String.valueOf(ans);
    }
}
/*
D. Array Splitting
https://codeforces.com/contest/1175/problem/D

灵茶の试炼 2025-04-03
题目大意：
输入 n k(1≤k≤n≤3e5) 和长为 n 的数组 a(-1e6≤a[i]≤1e6)。
把 a 分割成恰好 k 个非空连续子数组。
设 S = 第一个子数组的元素和乘以 1 + 第二个子数组的元素和乘以 2 + ... + 第 k 个子数组的元素和乘以 k。
输出 S 的最大值。

rating 1900
同双周赛第三题 3500. 将数组分割为子数组的最小代价。
把式子变形为 k 个非空后缀和之和。
注意 s[n]-s[0] 这个后缀和（整个数组的和）一定要选。
然后再选其余最大的 k-1 个非空后缀和，排序即可。
代码 https://codeforces.com/problemset/submission/1175/313547209
代码备份（洛谷）
======

Input
5 2
-1 -2 5 -4 8
Output
15

Input
7 6
-3 0 -1 -2 -2 -4 -1
Output
-45

Input
4 1
3 -1 6 0
Output
8
 */
