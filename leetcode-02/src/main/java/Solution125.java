import java.util.Locale;

public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // 只考虑字母和数字字符，可以忽略字母的大小写
        String str = s.toLowerCase(Locale.ENGLISH).replaceAll("[^0-9a-z]+", "");
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
/*
125. 验证回文串
https://leetcode-cn.com/problems/valid-palindrome/submissions/

step1 字符串转小写，去掉非数字和字母
step2 从两侧到中心逐个字符进行比较
 */