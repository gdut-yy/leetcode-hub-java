public class Solution664 {
    public int strangePrinter(String s) {
        int n = s.length();

        // f[i][j] 表示打印完成区间 [i,j] 的最少操作数
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = min;
                }
            }
        }
        return f[0][n - 1];
    }
}
/*
664. 奇怪的打印机
https://leetcode.cn/problems/strange-printer/

有台奇怪的打印机有以下两个特殊要求：
- 打印机每次只能打印由 同一个字符 组成的序列。
- 每次可以在从起始到结束的任意位置打印新字符，并且会覆盖掉原来已有的字符。
给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
提示：
1 <= s.length <= 100
s 由小写英文字母组成

区间 DP
时间复杂度 O(n^3)
空间复杂度 O(n^2)
 */