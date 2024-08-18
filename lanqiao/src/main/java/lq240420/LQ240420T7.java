package lq240420;

import java.util.Scanner;

public class LQ240420T7 {
    static int n;
    static char[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        p = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static final int mod = 998244353;

    private static String solve() {
        long[][] f = new long[1 << 10][n + 1];
        f[0][0] = 1;
        for (int i = 0; i < 1 << 10; ++i) {
            for (int j = 0; j < n; ++j) {
                if (f[i][j] > 0) {
                    for (int k = 0; k < 10; ++k) {
                        if (p[k] == 'x') continue;
                        int t = (i | (1 << k));
                        f[t][j + 1] += f[i][j];
                        if (f[t][j + 1] >= mod) {
                            f[t][j + 1] -= mod;
                        }
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 1 << 10; ++i) {
            long t = f[i][n];
            for (int j = 0; j < 10; ++j) {
                if (p[j] == 'o' && (i & (1 << j)) == 0) {
                    t = 0;
                }
                if (p[j] == 'x' && (i & (1 << j)) == 1) {
                    t = 0;
                }
            }
            ans = (ans + t) % mod;
        }
        return String.valueOf(ans);
    }
}
/*
小蓝的密码【算法赛】

解题思路
考察状压 DP。
状态定义
我们定义 dp_s,i 为，处理到第 i 个密码，当前字符出现的状态为 s 时的密码种类数，
s 是二进制表述，表述某个字符是否出现过，如 1001011000，就表示数字 0,3,5,6 出现过的情况下，密码的种类数。
我们依次枚举一下是什么字符即可。
状态转移方程如下：
dp_0,0 = 1 代表初始状态。
dp_s,i = dp_s,i-1 + dp_s^2^j,i-1
当然比较好的写法是，从当前的状态向后转移，即枚举一下个是什么字符:
dp_s|2^j,i += dp_s,i-1
时间复杂度：O(n * 2^10 * 10)
 */