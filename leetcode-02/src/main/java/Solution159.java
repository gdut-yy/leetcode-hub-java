import java.util.HashMap;
import java.util.Map;

public class Solution159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // "", "a", "aa", "ab"
        // "abc"
        int n = s.length();
        if (n < 3) {
            return n;
        }
        // 双指针
        int left = 0;
        int right = 0;
        int maxLen = 2;
        // key: 窗口最右边字符 value: 对应下标
        Map<Character, Integer> rightIdxMap = new HashMap<>();
        while (right < n) {
            if (rightIdxMap.size() < 3) {
                rightIdxMap.put(s.charAt(right), right);
                right++;
            }
            if (rightIdxMap.size() == 3) {
                int minIdx = Integer.MAX_VALUE;
                for (int idx : rightIdxMap.values()) {
                    minIdx = Math.min(minIdx, idx);
                }
                rightIdxMap.remove(s.charAt(minIdx));
                left = minIdx + 1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
/*
$159. 至多包含两个不同字符的最长子串
https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/

给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。

滑动窗口 + HashMap
时间复杂度 O(n)
空间复杂度 O(1)

相似题目: $340. 至多包含 K 个不同字符的最长子串
https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/
 */