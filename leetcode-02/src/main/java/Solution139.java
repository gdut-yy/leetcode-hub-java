import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> hashSet = new HashSet<>(wordDict);
        // 定义 dp[i] 为 s[0,i-1] 是否可以被空格拆分为一个或多个在字典中出现的单词
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        // 状态转移 dp[0,j-1] && dp[j,i-1]
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
/*
139. 单词拆分
https://leetcode-cn.com/problems/word-break/

给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。

动态规划。
时间复杂度 O(n^2)
空间复杂度 O(n)
 */