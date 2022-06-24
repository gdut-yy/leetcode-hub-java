public class Solution424 {
    public int characterReplacement(String s, int k) {
        int[] cntArr = new int[26];
        // 双指针
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            cntArr[s.charAt(right) - 'A']++;
            max = Math.max(max, cntArr[s.charAt(right) - 'A']);

            // 左指针右移
            if (right - left + 1 - max > k) {
                cntArr[s.charAt(left) - 'A']--;
                left++;
            }

            right++;
        }
        return right - left;
    }
}
/*
424. 替换后的最长重复字符
https://leetcode.cn/problems/longest-repeating-character-replacement/

给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
在执行上述操作后，返回包含相同字母的最长子字符串的长度。
提示：
1 <= s.length <= 10^5
s 仅由大写英文字母组成
0 <= k <= s.length

双指针，只需统计一个窗口内最长重复字符即可！
时间复杂度 O(n)
 */