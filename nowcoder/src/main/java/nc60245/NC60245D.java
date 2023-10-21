package nc60245;

import java.util.Arrays;
import java.util.Scanner;

public class NC60245D {
    static char[] cs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cs = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);
    static long[][] memo;

    private static String solve() {
        int n = cs.length;
        memo = new long[n][9];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        long ans = dfs(0, 0) - 1;
        return String.valueOf(ans);
    }

    static long dfs(int i, int sum) {
        if (i == cs.length) {
            return (sum % 9 == 0) ? 1 : 0;
        }
        if (memo[i][sum] != -1) {
            return memo[i][sum];
        }

        long res = dfs(i + 1, sum) % MOD;
        // 选
        res += dfs(i + 1, (sum + cs[i] - '0') % 9);
        res %= MOD;
        return memo[i][sum] = res;
    }
}
/*
游游的9的倍数
https://ac.nowcoder.com/acm/contest/60245/D

题目描述
游游拿到了一个数字串，她想取一个该数字串的子序列（子序列在原串中可以不连续），使得该子序列是9的倍数。子序列可以包含前导零。
游游想知道，一共能取多少个合法的子序列？答案请对10^9 +7 取模。
我们定义，若两个子序列在原串中的位置不同，则认为它们不同。
输入描述:
一个长度不超过200000的，仅由'0'~'9' 十种字符组成的字符串。
输出描述:
子序列是9的倍数的数量。答案请对 10^9 +7 取模。

记忆化搜索
======

示例1
输入
1188
输出
5
说明
共可以取4个不同的"18"子序列，和一个"1188"子序列，都是9的倍数。

示例2
输入
0123
输出
1
说明
只有子序列"0"是9的倍数。
 */