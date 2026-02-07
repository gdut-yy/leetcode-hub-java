public class SolutionP3662 {
    public String filterCharacters(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cnt[c - 'a'] < k) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
/*
$3662. 按频率筛选字符
https://leetcode.cn/problems/filter-characters-by-frequency/description/

给定一个包含小写英文字母的字符串 s 和一个整数 k。
你的任务是构造一个新的字符串，其中只包含在整个字符串 s 中出现次数 少于 k 次的字符。新字符串中字符的顺序必须与 s 中的 顺序相同。
返回结果字符串。如果没有字符满足，返回一个空字符串。
注意：出现次数少于 k 次的字符的每次出现都被保留。
提示：
1 <= s.length <= 100
s 只包含小写英文字母。
1 <= k <= s.length

统计频次。
时间复杂度 O(n)。
 */