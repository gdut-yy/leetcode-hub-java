package p425;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF425C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, s, e, a, b));
    }

    private static final int MAX_N = 100000;

    private static String solve(int n, int m, int s, int e, int[] a, int[] b) {
        int k = s / e;

        int[] jj = new int[MAX_N + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int[] dq = new int[n + 1];

        int ans = 0;
        for (int h = 1; h <= k; h++) {
            Arrays.fill(jj, m);
            dq[0] = m;
            for (int i = 0, j_ = m - 1; i < n; i++) {
                int ai = a[i];
                while (j_ > dp[i]) {
                    int bj = b[j_];
                    jj[bj] = j_--;
                }
                int j = dq[i + 1] = Math.min(dq[i], jj[ai]);
                if (j < m && h * e + i + 1 + j + 1 <= s) {
                    ans = h;
                }
            }
            int[] tmp = dp;
            dp = dq;
            dq = tmp;
        }
        return String.valueOf(ans);
    }
}
/*
C. Sereja and Two Sequences
https://codeforces.com/contest/425/problem/C

题目大意：
Sereja 有两个序列 a1, a2,..., an 和 b1, b2,...,bm，由整数组成。一天，Sereja 觉得无聊，决定和他们一起玩。游戏规则很简单。Sereja 做了几个动作，在一个动作中他可以执行以下动作之一:
- 选择序列 a 的多个(至少一个)首元素(a 的非空前缀)，选择序列 b 的多个(至少一个)首元素(b 的非空前缀)；序列 a 中在所选元素中下标最大的元素必须等于序列 b 中在所选元素中下标最大的元素；从序列中移除所选元素。
- 删除两个序列的所有元素。
第一个动作值 e 个能量单位，并为 Sereja 的电子账户增加了 1 美元。第二个动作的能量单位等于 Sereja 在执行此动作之前从序列中移除的元素的数量。在 Sereja 执行第二个动作后，他得到了他在游戏期间在电子账户上赚到的所有钱。
起初，Sereja 只有几个能源单位，他的账户上没有钱。Sereja 最多能拿到多少钱?注意，Seraja 的能量在任何时候都不能是负的。

rating2300
相似题目: 序列移除
https://leetcode.cn/leetbook/read/didiglobal2/e73cns/
======

input
5 5 100000 1000
1 2 3 4 5
3 2 4 5 1
output
3

input
3 4 3006 1000
1 2 3
1 2 4 3
output
2
 */
