import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        Map<Character, Integer> pCntMap = new HashMap<>();
        Map<Character, Integer> sCntMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pCntMap.put(p.charAt(i), pCntMap.getOrDefault(p.charAt(i), 0) + 1);
            sCntMap.put(s.charAt(i), sCntMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        if (checkInclusion(sCntMap, pCntMap)) {
            ans.add(0);
        }
        // 滑动窗口-窗口大小固定为 p.length()
        for (int i = 1; i <= s.length() - p.length(); i++) {
            // 窗口往右移动 map 中加一个字符，减一个字符
            char addCh = s.charAt(i + p.length() - 1);
            char rmCh = s.charAt(i - 1);
            sCntMap.put(addCh, sCntMap.getOrDefault(addCh, 0) + 1);
            sCntMap.put(rmCh, sCntMap.getOrDefault(rmCh, 0) - 1);
            if (checkInclusion(sCntMap, pCntMap)) {
                ans.add(i);
            }
        }
        return ans;
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
438. 找到字符串中所有字母异位词
https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/

字母异位词指字母相同，但排列不同的字符串。
滑动窗口-固定窗口。由于是固定窗口，所以可以不用双指针，只用一个指针就 ok
本题与第 567 题几乎一致。
 */