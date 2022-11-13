package didi;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class DD2019001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int np = scanner.nextInt();
        int nq = scanner.nextInt();
        int nr = scanner.nextInt();
        System.out.println(solve(np, nq, nr));
    }

    private static long[][][][] memo;

    private static String solve(int np, int nq, int nr) {
        memo = new long[3][np + 1][nq + 1][nr + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < np + 1; j++) {
                for (int k = 0; k < nq + 1; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }

        long res = 0;
        if (np > 0) {
            res += dfs(0, np - 1, nq, nr);
        }
        if (nq > 0) {
            res += dfs(1, np, nq - 1, nr);
        }
        if (nr > 0) {
            res += dfs(2, np, nq, nr - 1);
        }
        return String.valueOf(res);
    }

    private static long dfs(int pre, int np, int nq, int nr) {
        if (np + nq + nr == 0) {
            return 1;
        }
        if (memo[pre][np][nq][nr] != -1) {
            return memo[pre][np][nq][nr];
        }

        long res = 0;
        if (pre != 0 && np > 0) {
            res += dfs(0, np - 1, nq, nr);
        }
        if (pre != 1 && nq > 0) {
            res += dfs(1, np, nq - 1, nr);
        }
        if (pre != 2 && nr > 0) {
            res += dfs(2, np, nq, nr - 1);
        }
        memo[pre][np][nq][nr] = res;
        return res;
    }
}
/*
DD-2019001. 排列小球
https://leetcode.cn/problems/FHnt4H/

给定三种类型的小球 P、Q、R，每种小球的数量分别为 np、nq、nr 个。现在想将这些小球排成一条直线，但是不允许相同类型的小球相邻，问有多少种排列方法。如果无法组合出合适的结果，则输出 0。
格式：
输入：
- 一行以空格相隔的三个数，分别表示为 np，nq，nr。
输出：
- 排列方法的数量。
示例：
输入：2 1 1
输出：6
解释：如若 np=2，nq=1，nr=1 则共有 6 种排列方式：PQRP，QPRP，PRQP，RPQP，PRPQ 以及 PQPR。

记忆化搜索。
相似题目: 1269. 停在原地的方案数
https://leetcode.cn/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
2400. 恰好移动 k 步到达某一位置的方法数目
https://leetcode.cn/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
 */