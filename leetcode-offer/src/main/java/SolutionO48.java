import java.util.HashMap;
import java.util.Map;

public class SolutionO48 {
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
剑指 Offer 48. 最长不含重复字符的子字符串
https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

同: 3. 无重复字符的最长子串
https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */