package didi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class DDBook26 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int Total = scanner.nextInt();
        int Cost = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, Total, Cost, a, b));
    }

    private static final int MAX_N = 100000;

    private static String solve(int n, int Total, int Cost, int[] a, int[] b) {
        int k = Total / Cost;

        int[] jj = new int[MAX_N + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int[] dq = new int[n + 1];

        int ans = 0;
        for (int h = 1; h <= k; h++) {
            Arrays.fill(jj, n);
            dq[0] = n;
            for (int i = 0, j_ = n - 1; i < n; i++) {
                int ai = a[i];
                while (j_ > dp[i]) {
                    int bj = b[j_];
                    jj[bj] = j_--;
                }
                int j = dq[i + 1] = Math.min(dq[i], jj[ai]);
                if (j < n && h * Cost + i + 1 + j + 1 <= Total) {
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
序列移除
https://leetcode.cn/leetbook/read/didiglobal2/e73cns/

现在有 A，B 两个序列，两个序列都是拥有 n 个元素，你有两种操作:
从 A 序列中选择一个非空前缀，再从 B 序列中选择一个非空前缀，要求选择的这两个前缀的末尾元素相等。把这两个前缀移除，这个操作将花费 Cost 代价，但是这个操作可以使你得到一颗宝石。
花费两个序列剩余元素数量之和大小的代价，移除两个序列中剩下的所有元素，游戏结束，收起所有宝石。
要求总代价不超过 Total，且序列中不得有剩余，那么最多可以获得多少宝石。
格式：
输入：
- 输入第一行包含三个正整数 n, Total, Cost 。
- 接下来两行，每行 n 个数，表示 A，B 序列。
输出：
- 一个数表示最多可以获得的宝石数量。
示例：
输入：
5 10000 1000
1 5 4 2 3
5 4 3 2 1
输出：3
提示：
1 <= n <= 5*10^4
1 <= Total <= 3*10^5
10^3 <= Cost <= 10^4

https://www.nowcoder.com/discuss/353155303749394432
相似题目: C. Sereja and Two Sequences
https://codeforces.com/contest/425/problem/C
 */