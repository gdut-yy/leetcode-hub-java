public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                if (check(s, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(String s, int length) {
        int len = s.length();
        String pattern = s.substring(0, length);
        int partition = len / length;
        for (int i = 0; i < partition; i++) {
            String subString = s.substring(i * length, i * length + length);
            if (!pattern.equals(subString)) {
                return false;
            }
        }
        return true;
    }
}
/*
459. 重复的子字符串
https://leetcode-cn.com/problems/repeated-substring-pattern/

给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
提示：
1 <= s.length <= 10^4
s 由小写英文字母组成

枚举，重复的子字符串长度要能整除字符串长度，然后截取判等即可。
 */