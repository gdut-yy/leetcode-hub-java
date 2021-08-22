public class Solution680 {
    public boolean validPalindrome(String s) {
        // 双指针 两侧向中心
        int left = 0;
        int right = s.length() - 1;
        while (left < s.length() / 2) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        // 三种情况 满足其一即可
        return left == s.length() / 2
                || isPalindrome(s, left, right - 1)
                || isPalindrome(s, left + 1, right);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left++;
            right--;
        }
        return left >= right;
    }
}
/*
680. 验证回文字符串 Ⅱ
https://leetcode-cn.com/problems/valid-palindrome-ii/

给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
