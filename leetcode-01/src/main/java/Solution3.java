import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> sCntMap = new HashMap<>();
        int ans = 0;
        // 双指针-滑动窗口
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            // 右指针右移
            char addCh = s.charAt(right);
            sCntMap.put(addCh, sCntMap.getOrDefault(addCh, 0) + 1);
            right++;
            // 左指针右移
            while (sCntMap.getOrDefault(addCh, 0) > 1) {
                char rmCh = s.charAt(left);
                sCntMap.put(rmCh, sCntMap.getOrDefault(rmCh, 0) - 1);
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
/*
3. 无重复字符的最长子串
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
双指针 滑动窗口
 */