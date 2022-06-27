import java.util.Locale;

public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // 只考虑字母和数字字符，可以忽略字母的大小写
        String str = s.toLowerCase(Locale.ENGLISH).replaceAll("[^0-9a-z]+", "");
        int len = str.length();
        for (int left = 0; left < len / 2; left++) {
            int right = len - 1 - left;
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}
/*
125. 验证回文串
https://leetcode.cn/problems/valid-palindrome/

给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。

step1 字符串转小写，去掉非数字和字母
step2 从两侧到中心逐个字符进行比较
 */