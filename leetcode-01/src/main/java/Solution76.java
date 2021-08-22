import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> sCntMap = new HashMap<>();
        Map<Character, Integer> tCntMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCntMap.put(t.charAt(i), tCntMap.getOrDefault(t.charAt(i), 0) + 1);
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

    /**
     * 判断 window 中是否包含所需字符
     *
     * @param window window中各字符出现次数
     * @param need   需要包含的字符出现次数
     * @return 是否包含
     */
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
https://leetcode-cn.com/problems/minimum-window-substring/

给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
双指针 滑动窗口
这题细节较多。提交到第 10 次才通过，UT 中补充一些用例。
 */