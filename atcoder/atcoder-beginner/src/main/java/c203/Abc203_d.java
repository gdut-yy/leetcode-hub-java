package c203;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc203_d {
    static int n, k;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    static int[][] s;

    private static String solve() {
        s = new int[n + 1][n + 1];

        int left = 0;
        int right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    private static boolean checkMid(int up) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1];
                if (a[i - 1][j - 1] <= up) {
                    s[i][j]++;
                }
                if (i >= k && j >= k && s[i][j] - s[i][j - k] - s[i - k][j] + s[i - k][j - k] >= (k * k + 1) / 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
D - Pond
https://atcoder.jp/contests/abc203/tasks/abc203_d

灵茶の试炼 2022-11-16
题目大意：
输入 n k (1≤k≤n≤800) 和一个 n*n 的矩阵，元素范围 [0,1e9]。
定义 k*k 子矩阵的中位数为子矩阵的第 floor(k*k/2)+1 大的数。
输出中位数的最小值。
注：「第 x 大」中的 x 从 1 开始。

https://atcoder.jp/contests/abc203/submissions/36519551
二分答案。
猜测答案为 up，如果子矩阵内的 ≤ up 的数至少有 ceil(k*k/2) 个，那么答案可以 ≤ up。
这是满足单调性的，所以可以用二分。
用二维前缀和加速计算。
======

Input 1
3 2
1 7 0
5 8 11
10 4 2
Output 1
4

Input 2
3 3
1 2 3
4 5 6
7 8 9
Output 2
5
 */