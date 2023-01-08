package meituan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Meituan009 {
    private static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        // input
        String[] line0 = reader.readLine().split(" ");
        int n = Integer.parseInt(line0[0]);
        int m = Integer.parseInt(line0[1]);

        // solution
        int res = solution(n, m);

        // output
        writer.write(String.valueOf(res));
        writer.close();
        reader.close();
    }

    private static int solution(int n, int m) {
        // dp[i][j] 表示当有 i 个格子，物品最大价值为 j 时的方案数目
        int[][] dp = new int[m + 1][n + 1];
        // 边界: 当 i == 1 时，即只有 1 个格子，不管价格多少，方案数都为 1
        for (int j = 1; j < n + 1; j++) {
            dp[1][j] = 1;
        }
        // 状态转移：
        // 当格子的数目为 i 时且最大物品价值为 j 时，考虑我们如何根据 i-1 的方案数推出 i 的方案数
        // 根据题目要求，当前的（i）物品价值需要是上一个方案（i-1）中最大物品价值的倍数
        for (int i = 2; i < m + 1; i++) {
            for (int base = 1; base < n + 1; base++) {
                for (int j = base; j < n + 1; j += base) {
                    dp[i][j] += dp[i - 1][base];
                    dp[i][j] %= MOD;
                }
            }
        }
        int res = 0;
        for (int j = 1; j < n + 1; j++) {
            res += dp[m][j];
            res %= MOD;
        }
        return res;
    }
}
/*
meituan-009. 小团的装饰物
https://leetcode.cn/problems/0VvYxa/

小团正在装饰自己的书桌，他的书桌上从左到右有 m 个空位需要放上装饰物。商店中每个整数价格的装饰物恰好有一种，且每种装饰物的数量无限多。
小团去商店的时候，想到了一个购买方案，他要让右边的装饰物价格是左边的倍数。用数学语言来说，假设小团的 m 个装饰物价格为 a[1], a[2], ..., a[m] ，
那么对于任意的 1 ≤ i ≤ j ≤ m ，a[j] 是 a[i] 的倍数。
小团是一个节约的人，他希望最贵的装饰物不超过 n 元。现在，请你计算小团有多少种购买的方案？
格式：
输入：
- 输入包含两个数，n 和 m 。
输出：
- 输出一个数，结果对 998244353 取模，表示购买的方案数。
示例：
输入：4 2
输出：8
解释：[1,1][1,2][1,3][1,4][2,2][2,4][3,3][4,4] 共 8 种。
提示：
对于 40% 的数据，n, m ≤ 10
对于 100% 的数据，1 ≤ n, m ≤ 1000
 */