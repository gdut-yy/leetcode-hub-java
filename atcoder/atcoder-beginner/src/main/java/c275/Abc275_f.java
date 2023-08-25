package c275;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc275_f {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;

    private static String solve() {
        int[][] f = new int[m + 1][2];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(f[i], INF);
        }
        f[0][1] = 0;
        for (int v : a) {
            for (int j = m; j > 0; j--) {
                f[j][0] = Math.min(f[j][0], f[j][1] + 1);
                if (j >= v) {
                    f[j][1] = Math.min(f[j - v][0], f[j - v][1]);
                } else {
                    f[j][1] = INF;
                }
            }
            f[0] = new int[]{1, INF};
        }

        int[] ans = new int[m];
        for (int i = 1; i < m + 1; i++) {
            int res = Arrays.stream(f[i]).min().orElseThrow();
            ans[i - 1] = res == INF ? -1 : res;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
F - Erase Subarray
https://atcoder.jp/contests/abc275/tasks/abc275_f

灵茶の试炼 2022-12-21
题目大意：
输入 n(≤3000) m(≤3000) 和长为 n 的数组 a (1≤a[i]≤3000)。
每次操作你可以删除 a 的一个非空连续子数组。
定义 f(x) 表示使 sum(a) = x 的最小操作次数。
输出 f(1), f(2), ..., f(m)。

https://atcoder.jp/contests/abc275/submissions/37418527
这题和 01 背包有点像，但是直接按照 01 背包那样定义状态是不够的，需要加一个维度。
定义 f[i][j][0/1] 表示前 i 个数，和为 j，其中第 i 个数【0=删除，1=保留】
f[i][j][0] = min(f[i-1][j][0], f[i-1][j][1]+1)
f[i][j][1] = min(f[i-1][j-a[i]][0], f[i-1][j-a[i]][1])
初始值 f[0][0][0]=inf, f[0][0][1]=1, f[i>0][0][0]=1, f[i>0][0][1]=inf。
答案为 min(f[n][j][0], f[n][j][1])。
代码实现时可以像 01 背包那样压缩空间。
======

Input 1
4 5
1 2 3 4
Output 1
1
2
1
1
1

Input 2
1 5
3
Output 2
-1
-1
0
-1
-1

Input 3
12 20
2 5 6 5 2 1 7 9 7 2 5 5
Output 3
2
1
2
2
1
2
1
2
2
1
2
1
1
1
2
2
1
1
1
1
 */