public class Solution344 {
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = tmp;
        }
    }
}
/*
344. 反转字符串
https://leetcode-cn.com/problems/reverse-string/

双指针？其实不需要，swap 交换函数，空间复杂度 O(1)
 */