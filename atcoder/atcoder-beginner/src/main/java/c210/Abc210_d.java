package c210;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc210_d {
    static int n, m, c;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        c = scanner.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static final long INF = (long) 1e18;

    private static String solve() {
        long[] pre = new long[m + 1];
        long[] suf = new long[m + 1];
        Arrays.fill(pre, INF);
        Arrays.fill(suf, INF);

        long ans = INF;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.min(ans, a[i][j] + (long) c * (i + j) + Math.min(pre[j + 1], pre[j]));
                pre[j + 1] = Math.min(Math.min(pre[j + 1], pre[j]), a[i][j] - (long) c * (i + j));
            }
            for (int j = m - 1; j >= 0; j--) {
                ans = Math.min(ans, a[i][j] + (long) c * (i - j) + suf[j]);
                suf[j] = Math.min(Math.min(suf[j], suf[j + 1]), a[i][j] - (long) c * (i - j));
            }
        }
        return String.valueOf(ans);
    }
}
/*
D - National Railway
https://atcoder.jp/contests/abc210/tasks/abc210_d

灵茶の试炼 2022-11-17
题目大意：
输入 n m (2≤n,m≤1000) c(≤1e9) 和一个 n 行 m 列的矩阵 a，元素范围 [1,1e9]。
对于两个不同位置 (i,j) 和 (i',j')，输出 a[i][j] + a[i'][j'] + c*(|i-i'|+|j-j'|) 的最小值。

https://atcoder.jp/contests/abc210/submissions/36539833
逐行遍历矩阵。
把式子拆开：
1. 如果 (i',j') 在 (i,j) 的正左/左上/正上，那么相当于求
a[i][j]+c*(i+j) + min{a[i'][j']-c*(i'+j')} 的最小值。
后面 min 的内容可以用一个 pre_min 数组维护。
正左可以用 pre_min[j-1]，左上和正上是 pre_min[j]。
代码实现时，为了避免出现 -1 下标，pre_min 的下标改成从 1 开始。
2. 如果 (i',j') 在 (i,j) 的右上，那么相当于求
a[i][j]+c*(i-j) + min{a[i'][j']-c*(i'-j')} 的最小值。
后面 min 的内容可以用一个 suf_min 数组维护。注意这个需要倒着遍历矩阵的行。
根据对称性，我们只需要考虑这两种情况。
======

Input 1
3 4 2
1 7 7 9
9 6 3 7
7 8 6 4
Output 1
10

Input 2
3 3 1000000000
1000000 1000000 1
1000000 1000000 1000000
1 1000000 1000000
Output 2
1001000001
 */