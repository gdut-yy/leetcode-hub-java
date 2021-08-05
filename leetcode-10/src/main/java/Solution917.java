public class Solution917 {
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        // 双指针
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (!Character.isLetter(chars[left]) && left < right) {
                left++;
            }
            while (!Character.isLetter(chars[right]) && left < right) {
                right--;
            }
            char ch = chars[left];
            chars[left] = chars[right];
            chars[right] = ch;

            left++;
            right--;
        }
        return new String(chars);
    }
}
/*
917. 仅仅反转字母
https://leetcode-cn.com/problems/reverse-only-letters/

第 105 场周赛 T1。
双指针翻转即可。
 */