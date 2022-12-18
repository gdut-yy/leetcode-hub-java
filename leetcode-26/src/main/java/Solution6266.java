public class Solution6266 {
    private static final int MAX_N = 100000;
    private static int[] memo;

    public int smallestValue(int n) {
        if (memo == null) {
            memo = new int[MAX_N + 1];
            for (int i = 2; i <= MAX_N; i++) {
                memo[i] = i;
                dfs(i);
            }
        }

        while (memo[n] < n) {
            n = memo[n];
        }
        return n;
    }

    private void dfs(int n) {
        int num = n;
        int sum = 0;
        for (int i = 2; i * i <= num; i++) {
            // 如果 i 能够整除 N，说明 i 为 N 的一个质因子。
            if (num % i == 0) {
                while (num % i == 0) {
                    num /= i;
                    sum += i;
                }
            }
        }
        // 说明再经过操作之后 N 留下了一个素数
        if (num != 1) {
            sum += num;
        }
        if (memo[n] > sum) {
            memo[n] = sum;
        }
    }
}
/*
6266. 使用质因数之和替换后可以取到的最小值
https://leetcode.cn/problems/smallest-value-after-replacing-with-sum-of-prime-factors/

第 324 场周赛 T2。

给你一个正整数 n 。
请你将 n 的值替换为 n 的 质因数 之和，重复这一过程。
- 注意，如果 n 能够被某个质因数多次整除，则在求和时，应当包含这个质因数同样次数。
返回 n 可以取到的最小值。
提示：
2 <= n <= 10^5

模拟 + 记忆化
 */