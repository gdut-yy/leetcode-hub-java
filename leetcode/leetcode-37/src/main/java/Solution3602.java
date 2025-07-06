public class Solution3602 {
    public String concatHex36(int n) {
        String n2 = Integer.toString(n * n, 16);
        String n3 = Integer.toString(n * n * n, 36);
        return (n2 + n3).toUpperCase();
    }
}
/*
3602. 十六进制和三十六进制转化
https://leetcode.cn/problems/hexadecimal-and-hexatrigesimal-conversion/description/

第 160 场双周赛 T1。

给你一个整数 n。
返回 n^2 的 十六进制表示 和 n^3 的 三十六进制表示 拼接成的字符串。
十六进制 数定义为使用数字 0 – 9 和大写字母 A - F 表示 0 到 15 的值。
三十六进制 数定义为使用数字 0 – 9 和大写字母 A - Z 表示 0 到 35 的值。
提示:
1 <= n <= 1000

库函数。
时间复杂度 O(logn)。
 */