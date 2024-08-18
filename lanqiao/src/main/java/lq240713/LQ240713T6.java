package lq240713;

import java.util.Scanner;

public class LQ240713T6 {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static int[] dp;

    private static String solve() {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = s[i] - '0';
        }
        int[] acc = new int[n + 1];
        for (int i = 0; i < n; i++) {
            acc[i + 1] = acc[i];
            if (res[i] != 0) {
                acc[i + 1] += 1;
            }
        }

        dp = new int[n * n + 1];
        long ans = 0;
        for (int i = 1; i < n; i++) {
            for (int l = 0; l < n - i; l++) {
                int r = l + i;
                if (res[l] == res[r]) {
                    int x = dp[f(l + 1, r - 1)] + 1;
                    dp[f(l, r)] = x;
                    if (res[l] != 0) {
                        ans = ans + acc[l + x] - acc[l];
                    }
                }
            }
        }
        return String.valueOf(ans);
    }

    static int f(int a, int b) {
        return a * n + b;
    }
}
/*
字串截取【算法赛】

acc[i+1] 表示从第 0 个字符到第 i 个字符中值不为 0 的数量。
遍历每一个可能的长度 i 和起始位置 l，如果满足条件 res[l] = res[r]，则更新 dp[f(l,r)]，并根据 acc 数据更新 ans。
以 1221 为例子，dp[2][3] =1, ans = ans + acc[l+1] - acc[l]
当 len=3 时，dp[1][4] = dp[2][3] + 1 = 2, ans = ans + acc[l+2] - acc[l]
每次加都是从 i 开始以 j 结尾长度不超过 x 的串的结果。
最终时间复杂度为 O(n^2)，空间复杂度为 O(n^2)。
 */