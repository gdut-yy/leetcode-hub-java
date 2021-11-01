import java.util.List;

public class Solution524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {
            // 双指针 判断 每个 t 是否为 s 的一个子序列
            int p1 = 0;
            int p2 = 0;
            while (p1 < s.length() && p2 < t.length()) {
                if (s.charAt(p1) == t.charAt(p2)) {
                    p2++;
                }
                p1++;
            }
            if (p2 == t.length()) {
                // 遇到长度更长 或者 相同长度但字典序更小 时更新 res
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }
}
/*
524. 通过删除字母匹配到字典里最长单词
https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/

给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。

双指针判断是否子序列。

时间复杂度: O(d×(m+n))，其中 d 表示 dictionary 的长度，m 表示 s 的长度，n 表示 dictionary 中字符串的平均长度。
空间复杂度: O(1)
 */