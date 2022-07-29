import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> sCntMap = new HashMap<>();
        Map<Character, Integer> tCntMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tCntMap.put(ch, tCntMap.getOrDefault(ch, 0) + 1);
        }

        // 双指针-滑动窗口
        int left = 0;
        int right = 0;
        // 此处有坑，不能直接 s.length() 因为存在 s = "a", t = "b" 用例
        int ansLen = Integer.MAX_VALUE;
        int ansStart = 0;
        while (right < s.length()) {
            // 右指针右移 增加字符
            char addCh = s.charAt(right);
            sCntMap.put(addCh, sCntMap.getOrDefault(addCh, 0) + 1);
            right++;

            // 左指针右移
            while (checkInclusion(sCntMap, tCntMap)) {
                int curLen = right - left;
                if (curLen < ansLen) {
                    ansLen = curLen;
                    ansStart = left;
                }
                // 移除字符
                char rmCh = s.charAt(left);
                sCntMap.put(rmCh, sCntMap.getOrDefault(rmCh, 0) - 1);
                left++;
            }
        }
        return ansLen == Integer.MAX_VALUE ? "" : s.substring(ansStart, ansStart + ansLen);
    }

    // window 是否包含 need 的字符
    private boolean checkInclusion(Map<Character, Integer> window, Map<Character, Integer> need) {
        for (Map.Entry<Character, Integer> entry : need.entrySet()) {
            char curCh = entry.getKey();
            if (window.getOrDefault(curCh, 0) < entry.getValue()) {
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