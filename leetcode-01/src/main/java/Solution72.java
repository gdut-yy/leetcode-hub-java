public class Solution72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // 字符串为空串
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        // dp[i][j] 表示 word1 的前 i 个字母和 word2 的前 j 个字母之间的编辑距离
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 初始状态
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // 状态转移
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 如果 word1 和 word2 最后一个字母相同
                // dp[i][j] = min(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j-1])
                // 如果 word1 和 word2 最后一个字母不同
                // dp[i][j] = min(dp[i-1][j] + 1, dp[i][j-1] + 1, dp[i-1][j-1] + 1)
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1]));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[len1][len2];
    }
}
/*
72. 编辑距离
https://leetcode-cn.com/problems/edit-distance/

给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
- 插入一个字符
- 删除一个字符
- 替换一个字符
提示：
0 <= word1.length, word2.length <= 500
word1 和 word2 由小写英文字母组成

编辑距离算法被数据科学家广泛应用，是用作机器翻译和语音识别评价标准的基本算法。
动态规划。
时间复杂度 O(mn)
空间复杂度 O(mn)
 */