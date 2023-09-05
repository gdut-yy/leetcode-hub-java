package c130;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc130_e {
    static int n, m;
    static int[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }
        t = new int[m];
        for (int i = 0; i < m; i++) {
            t[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long[][] f = new long[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i] == t[j]) {
                    f[i + 1][j + 1] = (f[i][j + 1] + f[i + 1][j] + 1) % MOD;
                } else {
                    f[i + 1][j + 1] = (f[i][j + 1] + f[i + 1][j] - f[i][j] + MOD) % MOD;
                }
            }
        }
        long ans = (f[n][m] + 1) % MOD;
        return String.valueOf(ans);
    }
}
/*
E - Common Subsequence
https://atcoder.jp/contests/abc130/tasks/abc130_e

灵茶の试炼 2022-11-14
题目大意：
输入 n(≤2000) 和 m(≤2000)，长度分别为 n 和 m 的数组 a 和 b，元素范围 [1,1e5]。
从 a 和 b 中分别选出一个子序列（允许为空），要求这两个子序列相同。
输出有多少种不同的选法，模 1e9+7。
注意：选出的子序列不同，当且仅当下标不同（即使子序列的元素是相同的，也算不同）。

https://atcoder.jp/contests/abc130/submissions/36480640
定义 f[i][j] 表示在 a 的前 i 个数和 b 的前 j 个数中选择子序列，能得到的答案。
考虑转移来源，可以是 f[i-1][j] 和 f[i][j-1]，但这两个都包含 f[i-1][j-1]，所以要减掉重复的 f[i-1][j-1]（类比二维前缀和）。
如果 a[i]=b[j]，那么我们可以把这两加到所有 f[i-1][j-1] 的末尾，再加上 1，即 a[i] 和 b[j] 单独组成子序列。
因此状态转移方程为：
f[i][j] = f[i-1][j] + f[i][j-1] - f[i-1][j-1] + (a[i]==b[j] ? f[i-1][j-1]+1 : 0)
最后答案为 f[n][m]+1（需要把空子序列加上）。
======

Input 1
2 2
1 3
3 1
Output 1
3

Input 2
2 2
1 1
1 1
Output 2
6

Input 3
4 4
3 4 5 6
3 4 5 6
Output 3
16

Input 4
10 9
9 6 5 7 5 9 8 5 6 7
8 6 8 5 5 7 9 9 7
Output 4
191

Input 5
20 20
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
Output 5
846527861
 */