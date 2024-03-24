package p1051;

import java.util.Arrays;
import java.util.Scanner;

public class CF1051D {
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve4());
    }

    private static final int MOD = 998244353;

    // 1964ms
    private static String solve() {
        if (k == 1) return "2";
        long[][][] f = new long[n][k + 1][4];
        f[0][1] = new long[]{1, 0, 0, 1};
        f[0][2] = new long[]{0, 1, 1, 0};
        for (int i = 1; i < n; i++) {
            f[i][1][0] = f[i - 1][1][0];
            f[i][1][3] = f[i - 1][1][3];
            for (int j = 2; j <= k; j++) {
                f[i][j][0] = (f[i - 1][j][0] + f[i - 1][j][1] + f[i - 1][j][2] + f[i - 1][j - 1][3]) % MOD;
                f[i][j][1] = (f[i - 1][j - 1][0] + f[i - 1][j][1] + f[i - 1][j - 2][2] + f[i - 1][j - 1][3]) % MOD;
                f[i][j][2] = (f[i - 1][j - 1][0] + f[i - 1][j - 2][1] + f[i - 1][j][2] + f[i - 1][j - 1][3]) % MOD;
                f[i][j][3] = (f[i - 1][j - 1][0] + f[i - 1][j][1] + f[i - 1][j][2] + f[i - 1][j][3]) % MOD;
            }
        }
        long sum = Arrays.stream(f[n - 1][k]).sum();
        return String.valueOf(sum % MOD);
    }

    // 优化 1：白黑/黑白是对称的，可以合并成一个状态
    private static String solve1() {
        if (k == 1) return "2";
        long[][][] f = new long[n][k + 1][3];
        f[0][1] = new long[]{1, 0, 1};
        f[0][2] = new long[]{0, 2, 0};
        for (int i = 1; i < n; i++) {
            f[i][1][0] = f[i - 1][1][0];
            f[i][1][2] = f[i - 1][1][2];
            for (int j = 2; j <= k; j++) {
                f[i][j][0] = (f[i - 1][j][0] + f[i - 1][j][1] + f[i - 1][j - 1][2]) % MOD;
                f[i][j][1] = ((f[i - 1][j - 1][0] + f[i - 1][j - 1][2]) * 2 % MOD + f[i - 1][j][1] + f[i - 1][j - 2][1]) % MOD;
                f[i][j][2] = (f[i - 1][j - 1][0] + f[i - 1][j][1] + f[i - 1][j][2]) % MOD;
            }
        }
        long sum = Arrays.stream(f[n - 1][k]).sum();
        return String.valueOf(sum % MOD);
    }

    // 优化 2：滚动数组，注意 [0/1/2] 这三个状态的计算顺序
    private static String solve2() {
        if (k == 1) return "2";
        long[][] f = new long[k + 1][3];
        f[1] = new long[]{1, 0, 1};
        f[2] = new long[]{0, 2, 0};
        for (int i = 1; i < n; i++) {
            for (int j = k; j > 1; j--) {
                f[j][0] = (f[j][0] + f[j][1] + f[j - 1][2]) % MOD;
                f[j][2] = (f[j - 1][0] + f[j][1] + f[j][2]) % MOD;
                f[j][1] = ((f[j - 1][0] + f[j - 1][2]) * 2 % MOD + f[j][1] + f[j - 2][1]) % MOD;
            }
        }
        long sum = Arrays.stream(f[k]).sum();
        return String.valueOf(sum % MOD);
    }

    // 优化 3：注意到前 i 列最多可以组成 2*i 个连通块，因此可以优化一下循环的上界
    private static String solve3() {
        if (k == 1) return "2";
        long[][] f = new long[k + 1][3];
        f[1] = new long[]{1, 0, 1};
        f[2] = new long[]{0, 2, 0};
        for (int i = 2; i <= n; i++) {
            for (int j = Math.min(k, i * 2); j > 1; j--) {
                f[j][0] = (f[j][0] + f[j][1] + f[j - 1][2]) % MOD;
                f[j][2] = (f[j - 1][0] + f[j][1] + f[j][2]) % MOD;
                f[j][1] = ((f[j - 1][0] + f[j - 1][2]) * 2 % MOD + f[j][1] + f[j - 2][1]) % MOD;
            }
        }
        long sum = Arrays.stream(f[k]).sum();
        return String.valueOf(sum % MOD);
    }

    // 264ms
    // 优化 4：从转移方程可以看出，白白/黑黑也是对称的，也可以合并成一个状态
    private static String solve4() {
        if (k == 1) return "2";
        long[][] f = new long[k + 1][2];
        f[1] = new long[]{2, 0};
        f[2] = new long[]{0, 2};
        for (int i = 2; i <= n; i++) {
            for (int j = Math.min(k, i * 2); j > 1; j--) {
                f[j][0] = (f[j][0] + f[j][1] * 2 + f[j - 1][0]) % MOD;
                f[j][1] = (f[j][1] + f[j - 1][0] * 2 + f[j - 2][1]) % MOD;
            }
        }
        long sum = Arrays.stream(f[k]).sum();
        return String.valueOf(sum % MOD);
    }
}
/*
D. Bicolorings
https://codeforces.com/contest/1051/problem/D

灵茶の试炼 2022-07-19
题目大意：
输入整数 n(1<=n<=1000) 和 k(1<=k<=2n)。
你需要对一个 2 行 n 列的网格染色，每个格子需要染成白色或黑色中的一种。
输出网格中有 k 个同色连通块的染色方案数，模 998244353 的结果。
同色连通块指四方向相邻且同色的格子组成的(极大)区域，结合图片理解。

rating 1700
定义 f[i][j][0/1/2/3] 表示前 i 列组成 j 个连通块，且第 i 列的颜色组合是 白白/白黑/黑白/黑黑 的方案数。
根据上一列的颜色组合来转移，具体见 https://codeforces.com/contest/1051/submission/164836262
优化 1：白黑/黑白是对称的，可以合并成一个状态 https://codeforces.com/contest/1051/submission/164837223
优化 2：滚动数组，注意 [0/1/2] 这三个状态的计算顺序 https://codeforces.com/contest/1051/submission/164838044
优化 3：注意到前 i 列最多可以组成 2*i 个连通块，因此可以优化一下循环的上界 https://codeforces.com/contest/1051/submission/164838234
优化 4：从转移方程可以看出，白白/黑黑也是对称的，也可以合并成一个状态 https://codeforces.com/contest/1051/submission/164839057
最终，我们优化到了 15ms。
相似题目：https://atcoder.jp/contests/abc248/tasks/abc248_f
======

input
3 4
output
12

input
4 1
output
2

input
1 2
output
2
 */