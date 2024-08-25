package p570;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF570E {
    static int n, m;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        if (a[0][0] != a[n - 1][m - 1]) {
            return "0";
        }
        int[][] f = new int[n + 1][n + 2];
        f[1][n] = 1;
        for (int i = 1; i < (n + m) / 2; i++) {
            for (int r1 = n; r1 > 0; r1--) {
                for (int r2 = 1; r2 <= n; r2++) {
                    int c1 = i + 2 - r1, c2 = m + n - i - r2;

                    if (0 < c1 && c1 <= m && 0 < c2 && c2 <= m) {
                        if (a[r1 - 1][c1 - 1] == a[r2 - 1][c2 - 1]) {
                            f[r1][r2] = (((f[r1][r2] + f[r1][r2 + 1]) % MOD + f[r1 - 1][r2 + 1]) % MOD + f[r1 - 1][r2]) % MOD;
                        } else {
                            f[r1][r2] = 0;
                        }
                    }
                }
            }
        }

        long ans = 0;
        if ((n + m) % 2 == 1) {
            for (int i = 1; i <= n; i++) {
                ans = (ans + f[i][i] + f[i][i + 1]) % MOD;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                ans = (ans + f[i][i]) % MOD;
            }
        }
        return String.valueOf(ans);
    }
}
/*
E. Pig and Palindromes
https://codeforces.com/contest/570/problem/E

灵茶の试炼 2023-06-09
输入 n m (1≤n,m≤500) 和 n 行 m 列的字符矩阵，只包含小写字母。
你需要从左上角的 (1,1) 出发，到达右下角的 (n,m)。
每次只能向下或向右走。
问：有多少条路径对应的字符串是回文串？（见右图）
模 1e9+7。

rating 2300
https://codeforces.com/problemset/submission/570/209046565
https://codeforces.com/problemset/submission/570/209046793  循环优化
转换成两个人同时从左上和右下出发，定义 f[i][r1][r2] 表示走了 i 步，两人分别在第 r1 行和第 r2 行的方案数。这样只需要三个数就能表示坐标 (r1,c1) 和 (r2,c2)。
f[0][1][n] = 1（如果 a[1][1] != a[n][m] 直接输出 0）
如果 a[r1][c1] = a[r2][c2]，那么 f[i][r1][r2] = f[i-1][r1][r2] + f[i-1][r1][r2+1] + f[i-1][r1-1][r2] + f[i-1][r1-1][r2+1]，否则就是 0
代码实现时，第一个维度可以去掉。
最后答案按照字符串长度的奇偶性讨论。
如果是奇回文串，那么答案为 sum(f[i][i])，否则答案为 sum(f[i][i]+f[i][i+1])。
相似题目: 741. 摘樱桃
https://leetcode.cn/problems/cherry-pickup/
======

input
3 4
aaab
baaa
abba
output
3
 */
