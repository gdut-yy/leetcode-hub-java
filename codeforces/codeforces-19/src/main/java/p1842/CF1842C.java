package p1842;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1842C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static final int INF = (int) 1e9;

    // https://codeforces.com/contest/1842/submission/210884108
    private static String solve() {
        // f[i] 表示以 i 结尾最多可以移除多少个数
        // f[i] = f[i-1]
        //      = f[j-1] + (i-j+1) = f[j-1-j]
        // 转变为 最少可以保留多少个数
        int[] f = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = i;
        }
        int[] memo = new int[n + 1];
        Arrays.fill(memo, INF);

        for (int i = 0; i < n; i++) {
            f[i + 1] = Math.min(f[i + 1], f[i] + 1);
            f[i + 1] = Math.min(f[i + 1], memo[a[i]]);
            memo[a[i]] = Math.min(memo[a[i]], f[i]);
        }
        return String.valueOf(n - f[n]);
    }
}
/*
C. Tenzing and Balls
https://codeforces.com/contest/1842/problem/C

题目大意：
Tenzing 有 n 个球排成一行。左边第 i 个球的颜色是 ai。
Tenzing 可以任意次数做以下操作:
- 选取 i 和 j，使 1≤i<j≤|a|且 ai=aj，
- 从数组中删除 ai,ai+1,...,aj(并将 aj 右侧所有元素的下标减小 j-i+1)。
丹增想知道他能取出的球的最大数量。

动态规划，O(n^2) 优化至 O(n)
======

input
2
5
1 2 2 3 3
4
1 2 1 2
output
4
3
 */
