public class Solution3856 {
    public String trimTrailingVowels(String s) {
        int n = s.length();
        int i;
        for (i = n - 1; i >= 0; i--) {
            if (!isVowel(s.charAt(i))) break;
        }
        return s.substring(0, i + 1);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
/*
3856. 移除尾部元音字母
https://leetcode.cn/problems/trim-trailing-vowels/description/

第 491 场周赛 T1。

给定一个由小写英文字母组成的字符串 s。
返回移除字符串 s 尾部 所有元音字母 后得到的字符串。
元音字母包括字符 'a'、'e'、'i'、'o' 和 'u'。
提示：
1 <= s.length <= 100
s 仅由小写英文字母组成。

遍历。
时间复杂度 O(n)。
 */