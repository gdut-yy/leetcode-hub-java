import java.util.HashMap;
import java.util.Map;

public class Solution3926 {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        char[] s = String.join("", chunks).toCharArray();
        int n = s.length;
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (s[i] == ' ' || s[i] == '-') {
                continue;
            }
            int start = i;
            // 遇到 ' ' 或者 "--" 或者 "- " 时，跳出循环
            while (i < n && s[i] != ' ' && (s[i] != '-' || i < n - 1 && s[i + 1] != '-' && s[i + 1] != ' ')) {
                i++;
            }
            String word = new String(s, start, i - start);
            cnt.merge(word, 1, Integer::sum); // cnt[word]++
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = cnt.getOrDefault(queries[i], 0);
        }
        return ans;
    }
}
/*
3926. 有效单词计数
https://leetcode.cn/problems/count-valid-word-occurrences/description/

第 501 场周赛 T2。

给你一个字符串数组 chunks。按顺序将这些字符串拼接起来，形成一个字符串 s。
另给定一个字符串数组 queries。
单词 定义为 s 的一个 子串，并满足：
- 由小写英文字母（'a' 到 'z'）组成；
- 可以包含连字符（'-'），但仅当每个连字符两侧都被小写英文字母包围时才允许；
- 它不是某个同样满足上述条件更长子串的一部分。
任何不是小写英文字母或合法连字符的字符都会作为分隔符。
返回一个整数数组 ans，其中 ans[i] 表示 queries[i] 作为单词在 s 中出现的次数。
子串 是字符串中一个连续的 非空 字符序列。
提示：
1 <= chunks.length <= 10^5
1 <= chunks[i].length <= 10^5
chunks[i] 可以由小写英文字母、空格和连字符组成。
所有 chunks 中字符串的总长度不超过 10^5
1 <= queries.length <= 10^5
1 <= queries[i].length <= 10^5
queries[i] 是一个有效单词
所有 queries 中字符串的总长度不超过 10^5

分组循环 https://leetcode.cn/problems/count-valid-word-occurrences/solutions/3966164/fen-zu-xun-huan-pythonjavacgo-by-endless-ii4f/
时间复杂度：O(C+Q)，其中 C 是 chunks 的字符串长度之和，Q 是 queries 的字符串长度之和。
 */