public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int k = 1; k <= len / 2; k++) {
            if (check(s, k)) {
                return true;
            }
        }
        return false;
    }

    // 长度为 k 是否为重复的子字符串
    private boolean check(String s, int k) {
        if (s.length() % k != 0) {
            return false;
        }
        String pattern = s.substring(0, k);
        for (int i = 0; i < s.length(); i += k) {
            String subString = s.substring(i, i + k);
            if (!pattern.equals(subString)) {
                return false;
            }
        }
        return true;
    }
}
/*
459. 重复的子字符串
https://leetcode.cn/problems/repeated-substring-pattern/

给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
提示：
1 <= s.length <= 10^4
s 由小写英文字母组成

枚举，重复的子字符串长度要能整除字符串长度，然后截取判等即可。
 */