public class Solution3838 {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for (String s : words) {
            int weight = 0;
            for (char c : s.toCharArray()) {
                weight += weights[c - 'a'];
            }
            weight %= 26;
            ans.append((char) ('z' - weight));
        }
        return ans.toString();
    }
}
/*
3838. 带权单词映射
https://leetcode.cn/problems/weighted-word-mapping/description/

第 176 场双周赛 T1。

给你一个字符串数组 words，其中每个字符串表示一个由小写英文字母组成的单词。
同时给你一个长度为 26 的整数数组 weights，其中 weights[i] 表示第 i 个小写英文字母的权重。
单词的 权重 定义为其所有字符权重的 总和。
对于每个单词，将其权重对 26 取模，并将结果按字母倒序映射到一个小写英文字母（0 -> 'z', 1 -> 'y', ..., 25 -> 'a'）。
返回一个由所有单词映射后的字符按顺序连接而成的字符串。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 10
weights.length == 26
1 <= weights[i] <= 100
words[i] 仅由小写英文字母组成。

模拟。
时间复杂度 O(L)。其中 L 是所有 words[i] 的长度之和。
 */