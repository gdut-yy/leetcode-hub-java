package nc64593;

import java.util.Arrays;
import java.util.Scanner;

public class NC64593D {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    // https://ac.nowcoder.com/acm/discuss/blogs?tagId=258587
    private static String solve() {
        Arrays.sort(a);
        m = n - m;
        long[][] f = new long[n + 1][m + 1];
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            f[i][1] = 1;
            for (int j = 1; j < i; j++) {
                if (a[i] % a[j] == 0) {
                    for (int k = 2; k <= m; k++) {
                        f[i][k] += f[j][k - 1];
                        f[i][k] %= MOD;
                    }
                }
            }
            ans = (ans + f[i][m]) % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
小美的元素删除
https://ac.nowcoder.com/acm/contest/64593/D

题目描述
小美有一个数组，她希望删除 k 个元素，使得剩余的元素两两之间互为倍数关系。你能告诉小美有多少种删除方案吗？
由于答案过大，请对 10^9+7 取模。
输入描述:
第一行输入两个整数 n,k(1≤k≤n≤10^3 ) 表示数组长度，删除的元素数量。
第二行输入 n 个整数表示数组 a(1≤ai≤10^9 ) 。
保证给定的数组中不存在两个相等元素。
输出描述:
输出一个整数表示答案。

动态规划
======

示例1
输入
6 4
1 4 2 3 6 7
输出
8
说明
方案1：删除1,4,2,7。
方案2：删除1,4,3,7。
方案3：删除1,3,6,7。
方案4：删除4,2,3,6。
方案5：删除4,2,3,7。
方案6：删除4,2,6,7。
方案7：删除4,3,6,7。
方案8：删除2,3,6,7。
 */