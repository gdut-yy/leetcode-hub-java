import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Map<Character, Integer> cntMap = new HashMap<>();
        int l = 0, r = 0;
        int max = 0;
        while (r < n) {
            cntMap.put(chars[r], cntMap.getOrDefault(chars[r], 0) + 1);
            while (cntMap.get(chars[r]) > 1) {
                int cnt = cntMap.get(chars[l]);
                if (cnt == 1) {
                    cntMap.remove(chars[l]);
                } else {
                    cntMap.put(chars[l], cnt - 1);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
/*
3. 无重复字符的最长子串
https://leetcode.cn/problems/longest-substring-without-repeating-characters/

给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
提示：
0 <= s.length <= 5 * 10^4
s 由英文字母、数字、符号和空格组成

双指针 滑动窗口
 */