import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        Map<Character, Integer> cntMap = new HashMap<>();
        int l = 0, r = 0;
        int ans = 0;
        while (r < n) {
            cntMap.put(cs[r], cntMap.getOrDefault(cs[r], 0) + 1);

            while (cntMap.get(cs[r]) > 1) {
                cntMap.put(cs[l], cntMap.get(cs[l]) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
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
时间复杂度 O(n)
 */