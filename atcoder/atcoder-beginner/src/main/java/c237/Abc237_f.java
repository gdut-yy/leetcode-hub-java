package c237;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc237_f {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[][][][] f = new long[n + 1][11][11][11];
        f[0][m][m][m] = 1;
        for (int i = 1; i <= n; i++) {
            for (int x = 0; x <= m; x++) {
                for (int y = x; y <= m; y++) {
                    for (int z = y; z <= m; z++) {
                        for (int j = 0; j < m; j++) {
                            long val = f[i - 1][x][y][z];
                            if (j <= x) {
                                f[i][j][y][z] = (f[i][j][y][z] + val) % MOD;
                            } else if (j <= y) {
                                f[i][x][j][z] = (f[i][x][j][z] + val) % MOD;
                            } else if (j <= z) {
                                f[i][x][y][j] = (f[i][x][y][j] + val) % MOD;
                            }
                        }
                    }
                }
            }
        }

        long ans = 0;
        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) {
                for (int z = y + 1; z < m; z++) {
                    ans += f[n][x][y][z];
                }
            }
        }
        ans %= MOD;
        return String.valueOf(ans);
    }
}
/*
F - |LIS| = 3
https://atcoder.jp/contests/abc237/tasks/abc237_f

灵茶の试炼 2022-10-24
题目大意：
输入 n (3≤n≤1000) 和 m (3≤m≤10)。
输出有多少个满足如下条件的数组：
1. 数组长度为 n；
2. 数组元素范围在 [1,m]；
3. 数组的 LIS 的长度恰好等于 3。
对答案模 998244353。
注：LIS 指最长严格上升子序列。

https://atcoder.jp/contests/abc237/submissions/35930996
回忆下 LIS 的 O(nlogn) 做法，在那个做法中，我们需要维护一个有序数组 arr。
定义 f[i][x][y][z] 表示长为 i 且 arr=[x,y,z] 的符合题目要求的数组个数。
计算 f[i][x][y][z] 时，枚举第 i 个数是多少，按照 LIS 的 O(nlogn) 做法转移到对应的 x/y/z 上。
代码实现时，可以初始化 f[0][m+1][m+1][m+1] = 1，表示 arr=[inf,inf,inf] 的初始状态。
答案为 sum(f[n][x][y][z])，1≤x<y<z≤m。
为了节省内存，可以将元素值改为从 0 开始。
======

Input 1
4 5
Output 1
135

Input 2
3 4
Output 2
4

Input 3
111 3
Output 3
144980434
 */