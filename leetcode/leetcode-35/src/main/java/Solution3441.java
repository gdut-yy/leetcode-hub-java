public class Solution3441 {
    public String minCostGoodCaption(String caption) {
        int n = caption.length();
        if (n < 3) {
            return "";
        }

        char[] s = caption.toCharArray();
        int[][] f = new int[n + 1][26];
        int[] minJ = new int[n + 1];
        int[][] nxt = new int[n + 1][26];
        for (int i = n - 1; i >= 0; i--) {
            int mn = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                int res = f[i + 1][j] + Math.abs(s[i] - 'a' - j);
                int res2 = i <= n - 6 ? f[i + 3][minJ[i + 3]] + Math.abs(s[i] - 'a' - j) + Math.abs(s[i + 1] - 'a' - j) + Math.abs(s[i + 2] - 'a' - j) : Integer.MAX_VALUE;
                if (res2 < res || res2 == res && minJ[i + 3] < j) {
                    res = res2;
                    nxt[i][j] = minJ[i + 3]; // 记录转移来源
                } else {
                    nxt[i][j] = j; // 记录转移来源
                }
                f[i][j] = res;
                if (res < mn) {
                    mn = res;
                    minJ[i] = j; // 记录最小的 f[i][j] 中的 j 是多少
                }
            }
        }

        char[] ans = new char[n];
        int i = 0;
        int j = minJ[0];
        while (i < n) {
            ans[i] = (char) ('a' + j);
            int k = nxt[i][j];
            if (k == j) {
                i++;
            } else {
                ans[i + 2] = ans[i + 1] = ans[i];
                i += 3;
                j = k;
            }
        }
        return new String(ans);
    }

}
/*
3441. 变成好标题的最少代价
https://leetcode.cn/problems/minimum-cost-good-caption/description/

第 149 场双周赛 T4。

给你一个长度为 n 的字符串 caption 。如果字符串中 每一个 字符都位于连续出现 至少 3 次 的组中，那么我们称这个字符串是 好 标题。
比方说：
- "aaabbb" 和 "aaaaccc" 都是 好 标题。
- "aabbb" 和 "ccccd" 都 不是 好标题。
你可以对字符串执行以下操作 任意 次：
选择一个下标 i（其中 0 <= i < n ）然后将该下标处的字符变为：
- 该字符在字母表中 前 一个字母（前提是 caption[i] != 'a' ）
- 该字符在字母表中 后 一个字母（caption[i] != 'z' ）
你的任务是用 最少 操作次数将 caption 变为 好 标题。如果存在 多种 好标题，请返回它们中 字典序最小 的一个。如果 无法 得到好标题，请你返回一个空字符串 "" 。
在字符串 a 和 b 中，如果两个字符串第一个不同的字符处，字符串 a 的字母比 b 的字母在字母表里出现的顺序更早，那么我们称字符串 a 的 字典序 比 b 小 。如果两个字符串前 min(a.length, b.length) 个字符都相同，那么较短的一个字符串字典序比另一个字符串小。
提示：
1 <= caption.length <= 5 * 10^4
caption 只包含小写英文字母。

枚举字母+DP。
https://leetcode.cn/problems/minimum-cost-good-caption/solutions/3061609/zhuang-tai-ji-dp-shu-chu-ju-ti-fang-an-p-kjry/
rating 2780 (clist.by)
 */