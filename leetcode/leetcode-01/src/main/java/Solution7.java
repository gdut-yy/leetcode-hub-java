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

    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) { // 不能直接 > 0
            int d = x % 10;
            int newAns = ans * 10 + d;
            // newAns 每次更新后除 10，如果不等于 ans，说明整数溢出
            if (newAns / 10 != ans) return 0;
            ans = newAns;
            x /= 10;
        }
        return ans;
    }
}
/*
7. 整数反转
https://leetcode.cn/problems/reverse-integer/

给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。
提示：
-2^31 <= x <= 2^31 - 1

使用 StringBuilder#reverse() 轻松实现字符串翻转。
 */