public class Solution344 {
    public void reverseString(char[] s) {
        int len = s.length;
        for (int left = 0; left < len / 2; left++) {
            int right = len - 1 - left;
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
/*
344. 反转字符串
https://leetcode-cn.com/problems/reverse-string/

双指针。swap 交换函数，空间复杂度 O(1)
 */