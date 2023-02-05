import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    private Map<Character, Integer> tMap;

    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m) {
            return "";
        }
        tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0, right = 0;
        int ansLen = n + 1;
        int ansL = 0;
        while (right < n) {
            char ch = s.charAt(right);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            while (check(sMap)) {
                if (ansLen > right - left + 1) {
                    ansLen = right - left + 1;
                    ansL = left;
                }
                char rm = s.charAt(left);
                sMap.put(rm, sMap.get(rm) - 1);
                left++;
            }
            right++;
        }
        return (ansLen == n + 1) ? "" : s.substring(ansL, ansL + ansLen);
    }

    // sMap 是否完全覆盖 tMap
    private boolean check(Map<Character, Integer> sMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            char ch = entry.getKey();
            if (sMap.getOrDefault(ch, 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
/*
76. 最小覆盖子串
https://leetcode.cn/problems/minimum-window-substring/

给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：
- 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
- 如果 s 中存在这样的子串，我们保证它是唯一的答案。
提示：
1 <= s.length, t.length <= 10^5
s 和 t 由英文字母组成
进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？

双指针 滑动窗口
这题细节较多。提交到第 10 次才通过，UT 中补充一些用例。
 */