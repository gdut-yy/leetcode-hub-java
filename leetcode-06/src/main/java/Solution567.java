import java.util.HashMap;
import java.util.Map;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> s1CntMap = new HashMap<>();
        Map<Character, Integer> s2CntMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            // s1 中各字符出现次数
            s1CntMap.put(s1.charAt(i), s1CntMap.getOrDefault(s1.charAt(i), 0) + 1);
            // s2 中前 s1.length() 长度的字符串各字符出现次数
            s2CntMap.put(s2.charAt(i), s2CntMap.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (checkInclusion(s2CntMap, s1CntMap)) {
            return true;
        }
        // 滑动窗口-窗口大小固定为 s1.length() 注意是 <=
        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            // 窗口往右移动 map 中加一个字符，减一个字符
            char addCh = s2.charAt(i + s1.length() - 1);
            char rmCh = s2.charAt(i - 1);
            s2CntMap.put(addCh, s2CntMap.getOrDefault(addCh, 0) + 1);
            s2CntMap.put(rmCh, s2CntMap.getOrDefault(rmCh, 0) - 1);
            if (checkInclusion(s2CntMap, s1CntMap)) {
                return true;
            }
        }
        return false;
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
567. 字符串的排列
https://leetcode-cn.com/problems/permutation-in-string/

给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。

滑动窗口-固定窗口。由于是固定窗口，所以可以不用双指针，只用一个指针就 ok
本题与第 438 题几乎一致。
 */