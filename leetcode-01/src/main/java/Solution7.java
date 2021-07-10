public class Solution7 {
    public int reverse(int x) {
        String str = String.valueOf(x);
        long res;
        if (str.charAt(0) == '-') {
            res = -Long.parseLong(new StringBuilder(str.substring(1)).reverse().toString());
        } else {
            res = Long.parseLong(new StringBuilder(str).reverse().toString());
        }
        if (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) {
            return (int) res;
        } else {
            return 0;
        }
    }
}
/*
7. 整数反转
https://leetcode-cn.com/problems/reverse-integer/

使用 StringBuilder#reverse() 轻松实现字符串翻转。
 */